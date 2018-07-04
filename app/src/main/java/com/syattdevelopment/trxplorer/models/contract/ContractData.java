package com.syattdevelopment.trxplorer.models.contract;

public class ContractData {
    private ContractVotesData contractVotesData;
    private String ownerAddress;

    public ContractVotesData getContractVotesData() {
        return contractVotesData;
    }

    public void setContractVotesData(ContractVotesData contractVotesData) {
        this.contractVotesData = contractVotesData;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
}
