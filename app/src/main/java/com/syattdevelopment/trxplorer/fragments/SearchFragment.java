package com.syattdevelopment.trxplorer.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syattdevelopment.trxplorer.R;

public class SearchFragment extends Fragment {
    public static final String TAG = SearchFragment.class.getSimpleName();

    private int mId;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment getInstance(int id) {
        SearchFragment fragment = new SearchFragment();
        fragment.mId = id;
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }
}
