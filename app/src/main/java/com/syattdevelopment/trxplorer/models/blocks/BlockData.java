package com.syattdevelopment.trxplorer.models.blocks;

import java.util.ArrayList;

public class BlockData {
    private int total;
    private ArrayList<Block> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<Block> getData() {
        return data;
    }

    public void setData(ArrayList<Block> data) {
        this.data = data;
    }
}
