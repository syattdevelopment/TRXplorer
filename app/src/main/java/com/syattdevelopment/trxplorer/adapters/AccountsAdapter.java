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
import com.syattdevelopment.trxplorer.activities.AccountDetailsActivity;
import com.syattdevelopment.trxplorer.activities.HomeActivity;
import com.syattdevelopment.trxplorer.globals.Codes;
import com.syattdevelopment.trxplorer.models.accounts.Account;

import java.util.ArrayList;

public class AccountsAdapter extends ArrayAdapter<Account> {
    public static final String TAG = AccountsAdapter.class.getSimpleName();

    private Context mContext;
    private HomeActivity mActivity;

    public AccountsAdapter(Context context, ArrayList<Account> accounts, HomeActivity activity) {
        super(context, 0, accounts);
        mContext = context;
        mActivity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Account account = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_account, parent, false);
        }

        RelativeLayout container = convertView.findViewById(R.id.container_account);
        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, AccountDetailsActivity.class);
                mActivity.startActivityForResult(intent, Codes.ACCOUNT_DETAILS_CODE);
            }
        });

        TextView balance = convertView.findViewById(R.id.balance);
        TextView address = convertView.findViewById(R.id.address);

        if (account != null) {
            balance.setText(account.getBalance() + " TRX");
            address.setText(account.getAddress());
        }

        return convertView;
    }
}
