package com.syattdevelopment.trxplorer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syattdevelopment.trxplorer.R;

public class SettingsFragment extends Fragment {
    public static final String TAG = SettingsFragment.class.getSimpleName();

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment getInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

}
