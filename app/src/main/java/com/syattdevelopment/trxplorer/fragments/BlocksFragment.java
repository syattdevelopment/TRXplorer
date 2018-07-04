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
import com.syattdevelopment.trxplorer.adapters.BlocksAdapter;
import com.syattdevelopment.trxplorer.globals.APIS;
import com.syattdevelopment.trxplorer.listeners.QueryDataListener;
import com.syattdevelopment.trxplorer.models.blocks.BlockData;
import com.syattdevelopment.trxplorer.models.blocks.BlockSizeData;
import com.syattdevelopment.trxplorer.services.QueryDataService;
import com.syattdevelopment.trxplorer.utils.JsonUtils;

public class BlocksFragment extends Fragment implements QueryDataListener, View.OnClickListener {
    public static final String TAG = BlocksFragment.class.getSimpleName();

    private QueryDataService mService;
    private int mPage;
    private BlockData mBlockData;
    private BlockSizeData mBlockSizeData;

    private RelativeLayout mData;
    private RelativeLayout mProgress;
    private RelativeLayout mError;

    private BlocksAdapter mAdapter;

    private LineChart mLineChart;
    private ListView mListView;
    private TextView mSubtitle;
    private TextView mSubtitle2;
    private Button mRetry;

    private int mCounter;
    private HomeActivity mActivity;


    public BlocksFragment() {
        // Required empty public constructor
    }

    public static BlocksFragment getInstance(HomeActivity activity) {
        BlocksFragment blocksFragment = new BlocksFragment();
        blocksFragment.mActivity = activity;
        return blocksFragment;
    }

    private void initRetrieveBlocks() {
        mService = new QueryDataService(this);
        mService.execute(APIS.BLOCKS_URL + mPage);
        mService.execute(APIS.BLOCK_SIZE_URL);
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blocks, container, false);

        mData = view.findViewById(R.id.data);
        mProgress = view.findViewById(R.id.progress);
        mError = view.findViewById(R.id.error);

        mLineChart = view.findViewById(R.id.block_size_chart);
        mSubtitle = view.findViewById(R.id.subtitle);
        mSubtitle2 = view.findViewById(R.id.subtitle_2);
        mListView = view.findViewById(R.id.list_blocks);
        mRetry = view.findViewById(R.id.btn_retry);
        mRetry.setOnClickListener(this);

        showProgress();
        initRetrieveBlocks();

        return view;
    }

    private void setBlocksData() {
        if (mBlockData != null) {
            mAdapter = new BlocksAdapter(mActivity, mBlockData.getData(), mActivity);
            mListView.setAdapter(mAdapter);
        }
    }

    private void setBlockSizeData() {
        if (mBlockSizeData != null) {

        }
    }

    @Override
    public void onResponse(String response, String url) {
        Log.d(TAG, "Response :: " + response);

        int code = JsonUtils.determineParse(url);
        if (url.equals(APIS.BLOCKS_URL)) {
            mCounter++;
            mBlockData = (BlockData) JsonUtils.parseData(response, code);
            setBlocksData();
        } else if (url.equals(APIS.BLOCK_SIZE_URL)) {
            mCounter++;
            mBlockSizeData = (BlockSizeData) JsonUtils.parseData(response, code);
            setBlockSizeData();
        }

        if (mCounter == 2) {
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
                initRetrieveBlocks();
                break;
        }
    }
}
