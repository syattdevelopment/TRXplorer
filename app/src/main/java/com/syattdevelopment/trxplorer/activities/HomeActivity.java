package com.syattdevelopment.trxplorer.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.fragments.BlockchainFragment;
import com.syattdevelopment.trxplorer.fragments.HomeFragment;
import com.syattdevelopment.trxplorer.fragments.MarketsFragment;
import com.syattdevelopment.trxplorer.fragments.NodeTesterFragment;
import com.syattdevelopment.trxplorer.fragments.NodesFragment;
import com.syattdevelopment.trxplorer.fragments.RepresentativesFragment;
import com.syattdevelopment.trxplorer.fragments.SettingsFragment;
import com.syattdevelopment.trxplorer.fragments.SystemFragment;
import com.syattdevelopment.trxplorer.fragments.TokensFragment;
import com.syattdevelopment.trxplorer.fragments.TransactionViewerFragment;
import com.syattdevelopment.trxplorer.fragments.VotesFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = HomeActivity.class.getSimpleName();

    private NavigationView mNavigationView;

    private final int SEARCH_CODE = 112;

    private HomeFragment mHomeFragment;
    private BlockchainFragment mBlockchainFragment;
    private NodesFragment mNodesFragment;
    private RepresentativesFragment mRepresentativesFragment;
    private TokensFragment mTokensFragment;
    private MarketsFragment mMarketsFragment;
    private VotesFragment mVotesFragment;
    private SettingsFragment mSettingsFragment;
    private TransactionViewerFragment mTransactionViewerFragment;
    private NodeTesterFragment mNodeTesterFragment;
    private SystemFragment mSystemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(mNavigationView.getMenu().getItem(0));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivityForResult(intent, SEARCH_CODE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_blockchain) {
            mBlockchainFragment = BlockchainFragment.getInstance(this);
            setTitle(getResources().getString(R.string.blockchain));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mBlockchainFragment, BlockchainFragment.TAG).commit();
        } else if (id == R.id.nav_nodes) {
            mNodesFragment = NodesFragment.getInstance();
            setTitle(getResources().getString(R.string.nodes));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mNodesFragment, NodesFragment.TAG).commit();
        } else if (id == R.id.nav_representatives) {
            mRepresentativesFragment = RepresentativesFragment.getInstance();
            setTitle(getResources().getString(R.string.reps));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mRepresentativesFragment, RepresentativesFragment.TAG).commit();
        } else if (id == R.id.nav_tokens) {
            mTokensFragment = TokensFragment.getInstance();
            setTitle(getResources().getString(R.string.tokens));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mTokensFragment, TokensFragment.TAG).commit();
        } else if (id == R.id.nav_markets) {
            mMarketsFragment = MarketsFragment.getInstance();
            setTitle(getResources().getString(R.string.markets));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mMarketsFragment, MarketsFragment.TAG).commit();
        } else if (id == R.id.nav_votes) {
            mVotesFragment = VotesFragment.getInstance();
            setTitle(getResources().getString(R.string.votes));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mVotesFragment, VotesFragment.TAG).commit();

        } else if (id == R.id.nav_settings) {
            mSettingsFragment = SettingsFragment.getInstance();
            setTitle(getResources().getString(R.string.settings));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mSettingsFragment, SettingsFragment.TAG).commit();
        } else if (id == R.id.nav_transaction_viewer) {
            mTransactionViewerFragment = TransactionViewerFragment.getInstance();
            mNavigationView.getMenu().findItem(id).setChecked(true);
            setTitle(getResources().getString(R.string.transaction_viewer));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mTransactionViewerFragment, TransactionViewerFragment.TAG).commit();
        } else if (id == R.id.nav_node_tester) {
            mNodeTesterFragment = NodeTesterFragment.getInstance();
            mNavigationView.getMenu().findItem(id).setChecked(true);
            setTitle(getResources().getString(R.string.node_tester));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mNodeTesterFragment, NodeTesterFragment.TAG).commit();
        } else if (id == R.id.nav_system) {
            mSystemFragment = SystemFragment.getInstance();
            mNavigationView.getMenu().findItem(id).setChecked(true);
            setTitle(getResources().getString(R.string.system));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mSystemFragment, SystemFragment.TAG).commit();
        } else if (id == R.id.nav_home) {
            mHomeFragment = HomeFragment.getInstance();
            setTitle(getResources().getString(R.string.home));
            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                    mHomeFragment, HomeFragment.TAG).commit();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        item.setChecked(true);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
