package com.syattdevelopment.trxplorer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syattdevelopment.trxplorer.R;

public class NodeTesterFragment extends Fragment {
    public static final String TAG = NodeTesterFragment.class.getSimpleName();

    public NodeTesterFragment() {
        // Required empty public constructor
    }

    public static NodeTesterFragment getInstance() {
        return new NodeTesterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_node_tester, container, false);
    }

}
