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
import com.syattdevelopment.trxplorer.activities.TransferActivity;
import com.syattdevelopment.trxplorer.globals.Codes;
import com.syattdevelopment.trxplorer.models.transfers.Transfer;
import com.syattdevelopment.trxplorer.utils.ContractUtils;
import com.syattdevelopment.trxplorer.utils.TimeUtils;

import java.util.ArrayList;

public class TransferAdapter extends ArrayAdapter<Transfer> {
    public static final String TAG = TransferAdapter.class.getSimpleName();

    private Context mContext;
    private HomeActivity mActivity;

    public TransferAdapter(Context context, ArrayList<Transfer> transfers, HomeActivity activity) {
        super(context, 0, transfers);
        mContext = context;
        mActivity = activity;
    }

    private String setValue(int value) {
        return value + " TRX";
    }

    private String setTime(int unix) {
        return TimeUtils.convertUnixtoUtc(unix);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Transfer transfer = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_transfer,
                    parent, false);
        }

        RelativeLayout container = convertView.findViewById(R.id.container_transfer);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TransferActivity.class);
                mActivity.startActivityForResult(intent, Codes.TRANSFER_DETAILS_CODE);
            }
        });

        TextView value = convertView.findViewById(R.id.value);
        TextView from = convertView.findViewById(R.id.from);
        TextView contract = convertView.findViewById(R.id.contract);
        TextView to = convertView.findViewById(R.id.to);
        TextView timestamp = convertView.findViewById(R.id.timestamp);

        if (transfer != null) {
            value.setText(setValue(transfer.getAmount()));
            from.setText(transfer.getTransferFromAddress());
            contract.setText(ContractUtils.determineContract(1998));
            to.setText(transfer.getTransferToAddress());
            timestamp.setText(setTime(transfer.getTimestamp()));
        }

        return convertView;
    }
}
