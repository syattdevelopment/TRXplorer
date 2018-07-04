package com.syattdevelopment.trxplorer.models.blocks;

import java.util.ArrayList;

public class BlockSizeData {
    public int total;
    public ArrayList<BlockSize> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<BlockSize> getData() {
        return data;
    }

    public void setData(ArrayList<BlockSize> data) {
        this.data = data;
    }
}
