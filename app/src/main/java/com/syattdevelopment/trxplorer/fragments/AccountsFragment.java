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

import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.activities.HomeActivity;
import com.syattdevelopment.trxplorer.adapters.AccountsAdapter;
import com.syattdevelopment.trxplorer.globals.APIS;
import com.syattdevelopment.trxplorer.listeners.QueryDataListener;
import com.syattdevelopment.trxplorer.models.accounts.AccountData;
import com.syattdevelopment.trxplorer.services.QueryDataService;
import com.syattdevelopment.trxplorer.utils.JsonUtils;

import org.w3c.dom.Text;

public class AccountsFragment extends Fragment implements QueryDataListener, View.OnClickListener {
    public static final String TAG = AccountsFragment.class.getSimpleName();

    private QueryDataService mService;
    private int mPage;
    private AccountData mAccountData;

    private RelativeLayout mData;
    private RelativeLayout mProgress;
    private RelativeLayout mError;

    private ListView mListView;
    private AccountsAdapter mAdapter;

    private TextView mSubtitle;
    private Button mRetry;

    private int mCounter;
    private HomeActivity mActivity;

    public AccountsFragment() {
        // Required empty public constructor
    }

    public static AccountsFragment getInstance(HomeActivity activity) {
        AccountsFragment accountsFragment = new AccountsFragment();
        accountsFragment.mActivity = activity;
        return accountsFragment;
    }

    private void initRetrieveAccounts() {
        mService = new QueryDataService(this);
        mService.execute(APIS.ACCOUNTS_URL + mPage);
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
        View view = inflater.inflate(R.layout.fragment_accounts, container, false);

        mData = view.findViewById(R.id.data);
        mProgress = view.findViewById(R.id.progress);
        mError = view.findViewById(R.id.error);

        mSubtitle = view.findViewById(R.id.subtitle);
        mListView = view.findViewById(R.id.list_accounts);
        mRetry = view.findViewById(R.id.btn_retry);
        mRetry.setOnClickListener(this);

        showProgress();
        initRetrieveAccounts();
        return view;
    }

    private void setAccounts() {
        if (mAccountData != null) {
            mAdapter = new AccountsAdapter(mActivity, mAccountData.getData(), mActivity);
            mListView.setAdapter(mAdapter);
        }
    }

    @Override
    public void onResponse(String response, String url) {
        Log.d(TAG, "Response :: " + response);

        int code = JsonUtils.determineParse(url);
        if (url.equals(APIS.ACCOUNTS_URL)) {
            mCounter++;
            mAccountData = (AccountData) JsonUtils.parseData(response, code);
            setAccounts();
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
                initRetrieveAccounts();
                break;
        }
    }
}
