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

public class RepresentativesFragment extends Fragment implements QueryDataListener {
    public static final String TAG = RepresentativesFragment.class.getSimpleName();

    private QueryDataService mService;

    public RepresentativesFragment() {
        // Required empty public constructor
    }

    public static RepresentativesFragment getInstance() {
        return new RepresentativesFragment();
    }

    private void initRetrieveReps() {
        mService = new QueryDataService(this);
        mService.execute(APIS.REPS_URL);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initRetrieveReps();
        return inflater.inflate(R.layout.fragment_representatives, container, false);
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "Response :: " + response);
    }

    @Override
    public void onError() {

    }
}
