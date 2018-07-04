package com.syattdevelopment.trxplorer.utils;

public class ContractUtils {
    public static String determineContract(int code) {
        switch (code) {
            case 1998:
                return "Transfer";
            default:
                return null;
        }
    }
}
