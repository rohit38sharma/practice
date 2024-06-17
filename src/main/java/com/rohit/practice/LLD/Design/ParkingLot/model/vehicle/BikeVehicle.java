package com.rohit.practice.LLD.Design.ParkingLot.model.vehicle;

import com.rohit.practice.LLD.Design.ParkingLot.constant.VehicleType;

public class BikeVehicle extends Vehicle {
    public BikeVehicle(String licenseNumber) {
        super(licenseNumber, VehicleType.BIKE);
    }
}
