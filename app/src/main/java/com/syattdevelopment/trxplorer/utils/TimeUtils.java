package com.syattdevelopment.trxplorer.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {
    public static String convertUnixtoUtc(int unix) {
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZone);

        return simpleDateFormat.format(new Date(unix));
    }
}
