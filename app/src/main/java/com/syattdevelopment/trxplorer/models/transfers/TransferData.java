package com.syattdevelopment.trxplorer.models.transfers;

import java.util.ArrayList;

public class TransferData {
    private int total;
    private ArrayList<Transfer> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Transfer> getData() {
        return data;
    }

    public void setData(ArrayList<Transfer> data) {
        this.data = data;
    }
}
