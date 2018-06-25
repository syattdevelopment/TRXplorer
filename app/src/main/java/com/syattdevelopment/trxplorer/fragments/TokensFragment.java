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

public class TokensFragment extends Fragment implements QueryDataListener {
    public static final String TAG = TokensFragment.class.getSimpleName();

    private QueryDataService mService;
    private int mPage;

    public TokensFragment() {
        // Required empty public constructor
    }

    public static TokensFragment getInstance() {
        return new TokensFragment();
    }

    private void initRetrieveTokens() {
        mService = new QueryDataService(this);
        mService.execute(APIS.OVERVIEW_URL + mPage);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initRetrieveTokens();
        return inflater.inflate(R.layout.fragment_tokens, container, false);
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "Response :: " + response);
    }

    @Override
    public void onError() {

    }
}
