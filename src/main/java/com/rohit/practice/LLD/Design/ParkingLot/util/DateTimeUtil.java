package com.rohit.practice.LLD.Design.ParkingLot.util;

import java.sql.Timestamp;

public class DateTimeUtil {
    public static Timestamp getCurrentTime(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static long getTimeDiffInHours(Timestamp time1, Timestamp time2){
        long time1InMillis = time1.getTime();
        long time2InMillis = time2.getTime();
        long diff = time2InMillis - time1InMillis;
        long totalHours = diff / (60 * 60 * 1000);
        return totalHours;
    }
}
