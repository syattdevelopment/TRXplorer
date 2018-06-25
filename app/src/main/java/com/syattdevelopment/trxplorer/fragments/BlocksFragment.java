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

public class BlocksFragment extends Fragment implements QueryDataListener {
    public static final String TAG = BlocksFragment.class.getSimpleName();

    private QueryDataService mService;
    private int mPage;

    public BlocksFragment() {
        // Required empty public constructor
    }

    public static BlocksFragment getInstance() {
        return new BlocksFragment();
    }

    private void initRetrieveBlocks() {
        mService = new QueryDataService(this);
        mService.execute(APIS.BLOCKS_URL + mPage);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initRetrieveBlocks();
        return inflater.inflate(R.layout.fragment_blocks, container, false);
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, "Reponse :: " + response);
    }

    @Override
    public void onError() {

    }
}
