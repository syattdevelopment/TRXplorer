package com.syattdevelopment.trxplorer.models.accounts;

import java.util.ArrayList;

public class AccountData {
    private int total;
    private ArrayList<Account> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Account> getData() {
        return data;
    }

    public void setData(ArrayList<Account> data) {
        this.data = data;
    }
}
