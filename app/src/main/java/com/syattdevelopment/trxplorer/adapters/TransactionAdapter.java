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
import com.syattdevelopment.trxplorer.activities.HomeActivity;
import com.syattdevelopment.trxplorer.activities.TransactionDetailsActivity;
import com.syattdevelopment.trxplorer.globals.Codes;
import com.syattdevelopment.trxplorer.models.transactions.Transaction;
import com.syattdevelopment.trxplorer.models.transfers.Transfer;

import java.util.ArrayList;

public class TransactionAdapter extends ArrayAdapter<Transaction> {
    public static final String TAG = TransactionAdapter.class.getSimpleName();

    private Context mContext;
    private HomeActivity mActivity;

    public TransactionAdapter(Context context, ArrayList<Transaction> transactions,
                              HomeActivity activity) {
        super(context, 0, transactions);
        mContext = context;
        mActivity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Transaction transaction = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_transaction, parent, false);
        }

        RelativeLayout container = convertView.findViewById(R.id.container_transaction);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TransactionDetailsActivity.class);
                mActivity.startActivityForResult(intent, Codes.TRANSACTION_DETAILS_CODE);
            }
        });

        TextView confirmed = convertView.findViewById(R.id.confirmed);

        return convertView;
    }
}
