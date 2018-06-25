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

public class NodesFragment extends Fragment implements QueryDataListener {
    public static final String TAG = NodesFragment.class.getSimpleName();

    private QueryDataService mService;

    public NodesFragment() {
        // Required empty public constructor
    }

    public static NodesFragment getInstance() {
        return new NodesFragment();
    }

    private void initRetrieveNodes() {
        mService = new QueryDataService(this);
        mService.execute(APIS.NODES_URL);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initRetrieveNodes();
        return inflater.inflate(R.layout.fragment_nodes, container, false);
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "Response :: " + response);
    }

    @Override
    public void onError() {

    }
}
