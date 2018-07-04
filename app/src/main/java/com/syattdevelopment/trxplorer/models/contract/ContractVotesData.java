package com.syattdevelopment.trxplorer.models.contract;

public class ContractVotesData {
    private int voteCount;
    private String votesAddress;

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getVotesAddress() {
        return votesAddress;
    }

    public void setVotesAddress(String votesAddress) {
        this.votesAddress = votesAddress;
    }
}
