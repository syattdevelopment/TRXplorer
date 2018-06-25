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

public class VotesFragment extends Fragment implements QueryDataListener {
    public static final String TAG = VotesFragment.class.getSimpleName();

    private QueryDataService mService;

    public VotesFragment() {
        // Required empty public constructor
    }

    public static VotesFragment getInstance() {
        return new VotesFragment();
    }

    private void initRetrieveVotes(String url) {
        mService = new QueryDataService(this);
        mService.execute(url);
    }

    private void initDataQuery() {
        initRetrieveVotes(APIS.CURRENT_CYCLE_URL);
        initRetrieveVotes(APIS.NEXT_CYCLE_URL);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initDataQuery();
        return inflater.inflate(R.layout.fragment_votes, container, false);
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "Response :: " + response);
    }

    @Override
    public void onError() {

    }
}
