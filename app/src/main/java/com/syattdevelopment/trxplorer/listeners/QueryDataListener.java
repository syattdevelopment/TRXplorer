package com.syattdevelopment.trxplorer.listeners;

public interface QueryDataListener {
    void onResponse(String response);

    void onError();
}
