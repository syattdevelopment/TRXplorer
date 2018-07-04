package com.syattdevelopment.trxplorer.models.transactions;

import java.util.ArrayList;

public class TransactionData {
    private int total;
    private ArrayList<Transaction> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Transaction> getData() {
        return data;
    }

    public void setData(ArrayList<Transaction> data) {
        this.data = data;
    }
}
