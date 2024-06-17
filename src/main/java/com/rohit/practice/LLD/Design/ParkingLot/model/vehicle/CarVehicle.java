package com.rohit.practice.LLD.Design.ParkingLot.model.vehicle;

import com.rohit.practice.LLD.Design.ParkingLot.constant.VehicleType;

public class CarVehicle extends Vehicle {
    public CarVehicle(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
