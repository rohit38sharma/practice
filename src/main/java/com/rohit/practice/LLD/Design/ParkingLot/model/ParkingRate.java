package com.rohit.practice.LLD.Design.ParkingLot.model;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;
import com.rohit.practice.LLD.Design.ParkingLot.util.DateTimeUtil;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class ParkingRate {
    private Map<SpotType, Double> parkingRates;

    public ParkingRate(){
        loadParkingRates();
    }

    private void loadParkingRates(){
        this.parkingRates = new HashMap<>();
        this.parkingRates.put(SpotType.BIKE, 10.0);
        this.parkingRates.put(SpotType.COMPACT, 30.0);
        this.parkingRates.put(SpotType.LARGE, 50.0);
        this.parkingRates.put(SpotType.HANDICAPPED, 30.0);
        this.parkingRates.put(SpotType.ELECTRIC, 30.0);
    }

    public double calculateParkingCharges(SpotType spotType, Timestamp entryTime){
        Timestamp current = DateTimeUtil.getCurrentTime();
        long totalHours = Math.max(DateTimeUtil.getTimeDiffInHours(entryTime, current), 1);
        return parkingRates.get(spotType) * totalHours;
    }
}
