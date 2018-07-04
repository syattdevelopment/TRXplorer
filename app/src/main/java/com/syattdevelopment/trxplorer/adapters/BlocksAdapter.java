package com.syattdevelopment.trxplorer.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.syattdevelopment.trxplorer.R;
import com.syattdevelopment.trxplorer.activities.BlockDetailsActivity;
import com.syattdevelopment.trxplorer.activities.HomeActivity;
import com.syattdevelopment.trxplorer.globals.Codes;
import com.syattdevelopment.trxplorer.models.blocks.Block;
import com.syattdevelopment.trxplorer.utils.TimeUtils;

import java.util.ArrayList;

public class BlocksAdapter extends ArrayAdapter<Block> {
    public static final String TAG = BlocksAdapter.class.getSimpleName();

    private Context mContext;
    private HomeActivity mActivity;

    public BlocksAdapter(Context context, ArrayList<Block> blocks, HomeActivity activity) {
        super(context, 0, blocks);
        mContext = context;
        mActivity = activity;
    }

    private String getBytes(int value) {
        return value + " " + "Bytes";
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Block block = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_block, parent,
                    false);
        }

        RelativeLayout container = convertView.findViewById(R.id.container_block);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, BlockDetailsActivity.class);
                mActivity.startActivityForResult(intent, Codes.BLOCK_DETAILS_CODE);
            }
        });

        TextView height = convertView.findViewById(R.id.height);
        TextView hash = convertView.findViewById(R.id.hash);
        TextView timestamp = convertView.findViewById(R.id.timestamp);
        TextView size = convertView.findViewById(R.id.size);
        TextView transactionNumber = convertView.findViewById(R.id.transactions_number);

        if (block != null) {
            height.setText(block.getNumber());
            hash.setText(block.getHash());
            timestamp.setText(TimeUtils.convertUnixtoUtc(block.getTimestamp()));
            size.setText(getBytes(block.getSize()));
            transactionNumber.setText(block.getNrOfTx());
        }

        return convertView;
    }
}
