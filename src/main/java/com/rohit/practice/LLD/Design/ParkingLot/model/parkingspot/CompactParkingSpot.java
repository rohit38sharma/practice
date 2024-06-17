package com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;

public class CompactParkingSpot extends ParkingSpot {
    public CompactParkingSpot(String floorNumber, String spotNumber) {
        super(floorNumber, spotNumber, SpotType.COMPACT);
    }
}
