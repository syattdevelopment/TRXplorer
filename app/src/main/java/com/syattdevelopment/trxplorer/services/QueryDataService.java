package com.syattdevelopment.trxplorer.services;

import android.os.AsyncTask;

import com.syattdevelopment.trxplorer.globals.APIS;
import com.syattdevelopment.trxplorer.listeners.QueryDataListener;
import com.syattdevelopment.trxplorer.utils.NetworkUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class QueryDataService extends AsyncTask<String, String, String> {
    public static final String TAG = QueryDataService.class.getSimpleName();

    private QueryDataListener mListener;

    public QueryDataService(QueryDataListener listener) {
        mListener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url;
        HttpURLConnection httpURLConnection;

        try {
            url = new URL(strings[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return NetworkUtils.readStream(httpURLConnection.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        if (response != null) {
            mListener.onResponse(response);
        } else {
            mListener.onError();
        }
    }
}
