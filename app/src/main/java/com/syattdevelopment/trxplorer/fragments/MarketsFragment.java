package com.syattdevelopment.trxplorer.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.globals.APIS;
import com.syattdevelopment.trxplorer.listeners.QueryDataListener;
import com.syattdevelopment.trxplorer.services.QueryDataService;

public class MarketsFragment extends Fragment implements QueryDataListener {
    public static final String TAG = MarketsFragment.class.getSimpleName();

    private QueryDataService mService;

    public MarketsFragment() {
        // Required empty public constructor
    }

    public static MarketsFragment getInstance() {
        return new MarketsFragment();
    }

    private void initRetrieveMarkets(String url) {
        mService = new QueryDataService(this);
        mService.execute(url);
    }

    private void initDataQuery() {
        initRetrieveMarkets(APIS.AVERAGE_PRICE_URL);
        initRetrieveMarkets(APIS.AVERAGE_VOLUME_URL);
        initRetrieveMarkets(APIS.MARKETS_URL);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initDataQuery();
        return inflater.inflate(R.layout.fragment_markets, container, false);
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "Response :: " + response);
    }

    @Override
    public void onError() {

    }
}
