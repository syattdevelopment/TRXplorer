package com.syattdevelopment.trxplorer.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.globals.APIS;
import com.syattdevelopment.trxplorer.listeners.QueryDataListener;
import com.syattdevelopment.trxplorer.models.transactions.TransactionData;
import com.syattdevelopment.trxplorer.services.QueryDataService;

public class TransactionsFragment extends Fragment implements QueryDataListener, View.OnClickListener {
    public static final String TAG = TransactionsFragment.class.getSimpleName();

    private QueryDataService mService;
    private int mPage;
    private TransactionData mTransactionData;

    private RelativeLayout mData;
    private RelativeLayout mProgress;
    private RelativeLayout mError;

    private Trans

    public TransactionsFragment() {
        // Required empty public constructor
    }

    public static TransactionsFragment getInstance() {
        return new TransactionsFragment();
    }

    private void initRetrieveTransactions() {
        mService = new QueryDataService(this);
        mService.execute(APIS.TRANSACTIONS_URL + mPage);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initRetrieveTransactions();
        return inflater.inflate(R.layout.fragment_transactions, container, false);
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "Response :: " + response);
    }

    @Override
    public void onResponse(String response, String url) {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onClick(View v) {

    }
}
