package com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;

public class HandicappedParkingSpot extends ParkingSpot {
    public HandicappedParkingSpot(String floorNumber, String spotNumber) {
        super(floorNumber, spotNumber, SpotType.HANDICAPPED);
    }
}
