package com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;

public class LargeParkingSpot extends ParkingSpot {
    public LargeParkingSpot(String floorNumber, String spotNumber) {
        super(floorNumber, spotNumber, SpotType.LARGE);
    }
}
