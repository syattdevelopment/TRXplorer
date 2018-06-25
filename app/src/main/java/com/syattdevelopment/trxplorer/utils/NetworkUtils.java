package com.syattdevelopment.trxplorer.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetworkUtils {
    public static final String TAG = NetworkUtils.class.getSimpleName();

    public static String readStream(InputStream inputStream) {
        BufferedReader reader = null;
        StringBuilder response = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }
}
