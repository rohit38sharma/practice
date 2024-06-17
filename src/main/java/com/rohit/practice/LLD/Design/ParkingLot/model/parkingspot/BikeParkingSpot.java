package com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(String floorNumber, String spotNumber) {
        super(floorNumber, spotNumber, SpotType.BIKE);
    }
}
