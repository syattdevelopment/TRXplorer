package com.syattdevelopment.trxplorer.models.blocks;

public class Block {
    private int number;
    private String hash;
    public int size;
    private int timestamp;
    private String txTrieRoot;
    private String parentHash;
    private int witnessId;
    private String witnessAddress;
    private int nrOfTx;
    private boolean confirmed;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getTxTrieRoot() {
        return txTrieRoot;
    }

    public void setTxTrieRoot(String txTrieRoot) {
        this.txTrieRoot = txTrieRoot;
    }

    public String getParentHash() {
        return parentHash;
    }

    public void setParentHash(String parentHash) {
        this.parentHash = parentHash;
    }

    public int getWitnessId() {
        return witnessId;
    }

    public void setWitnessId(int witnessId) {
        this.witnessId = witnessId;
    }

    public String getWitnessAddress() {
        return witnessAddress;
    }

    public void setWitnessAddress(String witnessAddress) {
        this.witnessAddress = witnessAddress;
    }

    public int getNrOfTx() {
        return nrOfTx;
    }

    public void setNrOfTx(int nrOfTx) {
        this.nrOfTx = nrOfTx;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
