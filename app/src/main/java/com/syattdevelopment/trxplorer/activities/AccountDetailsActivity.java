package com.syattdevelopment.trxplorer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.syattdevelopment.trxplorer.R;

public class AccountDetailsActivity extends AppCompatActivity {
    public static final String TAG = AccountDetailsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
    }
}
