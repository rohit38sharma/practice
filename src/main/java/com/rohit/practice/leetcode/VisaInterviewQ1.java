package com.rohit.practice.leetcode;

import java.util.HashMap;

public class VisaInterviewQ1 {
    int findLastBusDeparted(String[] buses, String curTime){
        int n = buses.length;
        String[] curTimeSplit = curTime.split(":");
        int curHour = Integer.parseInt(curTimeSplit[0]);
        int curMin = Integer.parseInt(curTimeSplit[1]);

        int idx = 0;
        for(;idx<n;++idx){
            String[] busTime = buses[idx].split(":");
            int busHour = Integer.parseInt(busTime[0]);
            int busMin = Integer.parseInt(busTime[1]);

            if(curHour < busHour || (curHour == busHour && curMin <= busMin)){
                break;
            }
        }
        if(idx > 0){
            String[] busTime = buses[idx-1].split(":");
            int busHour = Integer.parseInt(busTime[0]);
            int busMin = Integer.parseInt(busTime[1]);
            if(curMin<busMin){
                --curHour;
                curMin += 60;
            }
            int minDiff = (curMin-busMin);
            int hourDiff = curHour<busHour ?0 : curHour-busHour;

            return (minDiff + (hourDiff*60));
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
