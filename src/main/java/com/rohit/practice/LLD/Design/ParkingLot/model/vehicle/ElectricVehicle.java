package com.rohit.practice.LLD.Design.ParkingLot.model.vehicle;

import com.rohit.practice.LLD.Design.ParkingLot.constant.VehicleType;

import java.sql.Timestamp;

public class ElectricVehicle extends Vehicle {
    boolean chargingUse;
    Timestamp chargingStartTime;
    public ElectricVehicle(String licenseNumber) {
        super(licenseNumber, VehicleType.ELECTRIC);
    }
}
