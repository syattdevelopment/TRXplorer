package com.syattdevelopment.trxplorer.models.transfers;

public class Transfer {
    private String id;
    private String txHash;
    private int block;
    private int timestamp;
    private String transferFromAddress;
    private String transferToAddress;
    private int amount;
    private String tokenName;
    private boolean confirmed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransferFromAddress() {
        return transferFromAddress;
    }

    public void setTransferFromAddress(String transferFromAddress) {
        this.transferFromAddress = transferFromAddress;
    }

    public String getTransferToAddress() {
        return transferToAddress;
    }

    public void setTransferToAddress(String transferToAddress) {
        this.transferToAddress = transferToAddress;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
