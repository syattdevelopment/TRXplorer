package com.syattdevelopment.trxplorer.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.activities.HomeActivity;
import com.syattdevelopment.trxplorer.adapters.TransferAdapter;
import com.syattdevelopment.trxplorer.globals.APIS;
import com.syattdevelopment.trxplorer.listeners.QueryDataListener;
import com.syattdevelopment.trxplorer.models.transfers.TransferData;
import com.syattdevelopment.trxplorer.services.QueryDataService;
import com.syattdevelopment.trxplorer.utils.JsonUtils;

public class TransfersFragment extends Fragment implements QueryDataListener, View.OnClickListener {
    public static final String TAG = TransfersFragment.class.getSimpleName();

    private QueryDataService mService;
    private int mPage;
    private TransferData mTransferData;

    private RelativeLayout mData;
    private RelativeLayout mProgress;
    private RelativeLayout mError;

    private TransferAdapter mAdapter;

    private LineChart mLineChart;
    private ListView mListView;
    private TextView mSubtitle;
    private TextView mSubtitle2;
    private Button mRetry;

    private int mCounter;
    private HomeActivity mActivity;

    public TransfersFragment() {
        // Required empty public constructor
    }

    public static TransfersFragment getInstance(HomeActivity activity) {
        TransfersFragment transfersFragment = new TransfersFragment();
        transfersFragment.mActivity = activity;
        return transfersFragment;
    }

    private void initRetrieveTransfers() {
        mService = new QueryDataService(this);
        mService.execute(APIS.TRANSFERS_URL + mPage);
    }

    private void showProgress() {
        mProgress.setVisibility(View.VISIBLE);
        mError.setVisibility(View.GONE);
        mData.setVisibility(View.GONE);
    }

    private void showError() {
        mProgress.setVisibility(View.GONE);
        mError.setVisibility(View.VISIBLE);
        mData.setVisibility(View.GONE);
    }

    private void showData() {
        mProgress.setVisibility(View.GONE);
        mError.setVisibility(View.GONE);
        mData.setVisibility(View.VISIBLE);
    }

    private void setTransferData() {
        if (mTransferData != null) {
            mAdapter = new TransferAdapter(mActivity, mTransferData.getData(), mActivity);
            mListView.setAdapter(mAdapter);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transfers, container, false);

        mData = view.findViewById(R.id.data);
        mProgress = view.findViewById(R.id.progress);
        mError = view.findViewById(R.id.error);

        mLineChart = view.findViewById(R.id.transfer_per_hour_chart);
        mListView = view.findViewById(R.id.list_transfers);
        mSubtitle = view.findViewById(R.id.subtitle);
        mSubtitle2 = view.findViewById(R.id.subtitle_2);
        mRetry = view.findViewById(R.id.btn_retry);
        mRetry.setOnClickListener(this);

        showProgress();
        initRetrieveTransfers();
        return view;
    }

    @Override
    public void onResponse(String response, String url) {
        Log.d(TAG, "Response :: " + response);

        int code = JsonUtils.determineParse(url);
        if (url.equals(APIS.TRANSFERS_URL)) {
            mCounter++;
            mTransferData = (TransferData) JsonUtils.parseData(response, code);
            setTransferData();
        }

        if (mCounter == 1) {
            mCounter = 0;
            showData();
        }
    }

    @Override
    public void onError() {
        mCounter = 0;
        showError();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.btn_retry:
                mCounter = 0;
                showProgress();
                initRetrieveTransfers();
                break;
        }
    }
}
