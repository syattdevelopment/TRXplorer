package com.syattdevelopment.trxplorer.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.models.blocks.Block;

public class BlockDetailsActivity extends AppCompatActivity {
    public static final String TAG = BlockDetailsActivity.class.getSimpleName();

    private Block mBlock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_details);
    }
}
