package com.syattdevelopment.trxplorer.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.fragments.SearchFragment;

import java.util.Objects;

public class SearchActivity extends AppCompatActivity implements View.OnFocusChangeListener, TextWatcher {
    public static final String TAG = SearchActivity.class.getSimpleName();

    private EditText mSearchBox;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mSearchBox = findViewById(R.id.search_box);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.pager);

        mSearchBox.setOnFocusChangeListener(this);
        mSearchBox.addTextChangedListener(this);

        mViewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.action_clear:
                mSearchBox.setText("");
                mSearchBox.clearFocus();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);

        MenuItem clear = menu.findItem(R.id.action_clear);
        MenuItem qr = menu.findItem(R.id.action_qr);

        if (mSearchBox.getText().length() != 0) {
            clear.setVisible(true);
            qr.setVisible(false);
        } else {
            clear.setVisible(false);
            qr.setVisible(true);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        invalidateOptionsMenu();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {
        public final String TAG = SectionPagerAdapter.class.getSimpleName();

        SectionPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return SearchFragment.getInstance(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Address";
                case 1:
                    return "Block";
                case 2:
                    return "Tx Hash";
                case 3:
                    return "Asset";
            }

            return super.getPageTitle(position);
        }
    }
}
