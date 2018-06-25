package com.syattdevelopment.trxplorer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syattdevelopment.trxplorer.R;

public class TransactionViewerFragment extends Fragment {
    public static final String TAG = TransactionViewerFragment.class.getSimpleName();

    public TransactionViewerFragment() {
        // Required empty public constructor
    }

    public static TransactionViewerFragment getInstance() {
        return new TransactionViewerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction_viewer, container, false);
    }
}
