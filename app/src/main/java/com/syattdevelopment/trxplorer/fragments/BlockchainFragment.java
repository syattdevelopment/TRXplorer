package com.syattdevelopment.trxplorer.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.activities.HomeActivity;
import com.syattdevelopment.trxplorer.utils.ViewUtils;

public class BlockchainFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = BlockchainFragment.class.getSimpleName();

    private HomeActivity mContext;
    private BottomNavigationView mBottomNavigationView;

    private BlocksFragment mBlocksFragment;
    private TransactionsFragment mTransactionsFragment;
    private TransfersFragment mTransfersFragment;
    private AccountsFragment mAccountsFragment;

    public BlockchainFragment() {
        // Required empty public constructor
    }

    public static BlockchainFragment getInstance(HomeActivity context) {
        BlockchainFragment fragment = new BlockchainFragment();
        fragment.mContext = context;
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blockchain, container, false);

        mBottomNavigationView = view.findViewById(R.id.navigation);
        ViewUtils.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        onNavigationItemSelected(mBottomNavigationView.getMenu().getItem(0));

        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_blocks:
                mBlocksFragment = BlocksFragment.getInstance(mContext);
                getChildFragmentManager().beginTransaction().replace(R.id.container, mBlocksFragment, BlocksFragment.TAG).commit();
                return true;
            case R.id.action_transactions:
                mTransactionsFragment = TransactionsFragment.getInstance();
                getChildFragmentManager().beginTransaction().replace(R.id.container, mTransactionsFragment, TransactionsFragment.TAG).commit();
                return true;
            case R.id.action_transfers:
                mTransfersFragment = TransfersFragment.getInstance();
                getChildFragmentManager().beginTransaction().replace(R.id.container, mTransfersFragment, TransfersFragment.TAG).commit();
                return true;
            case R.id.action_accounts:
                mAccountsFragment = AccountsFragment.getInstance();
                getChildFragmentManager().beginTransaction().replace(R.id.container, mAccountsFragment, AccountsFragment.TAG).commit();
                return true;
        }
        return false;
    }
}
