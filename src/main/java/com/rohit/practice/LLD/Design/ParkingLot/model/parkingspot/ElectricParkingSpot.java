package com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;

public class ElectricParkingSpot extends ParkingSpot {
    public ElectricParkingSpot(String floorNumber, String spotNumber) {
        super(floorNumber, spotNumber, SpotType.ELECTRIC);
    }
}
