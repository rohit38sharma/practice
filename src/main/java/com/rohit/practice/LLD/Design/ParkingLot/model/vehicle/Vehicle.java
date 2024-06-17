package com.rohit.practice.LLD.Design.ParkingLot.model.vehicle;

import com.rohit.practice.LLD.Design.ParkingLot.constant.VehicleType;
import com.rohit.practice.LLD.Design.ParkingLot.model.ParkingTicket;
import com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot.ParkingSpot;

public abstract class Vehicle {
    private final String licenseNumber;
    private final VehicleType vehicleType;
    private ParkingTicket parkingTicket;
    private ParkingSpot parkingSpot;

    public Vehicle(String licenseNumber, VehicleType vehicleType){
        this.vehicleType = vehicleType;
        this.licenseNumber = licenseNumber;
    }

    public ParkingSpot getParkingSpot(){
        return this.parkingSpot;
    }

    public String getLicenseNumber(){
        return this.licenseNumber;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

    public void assignTicket(ParkingTicket parkingTicket){
        this.parkingTicket = parkingTicket;
    }

    public void assignSpot(ParkingSpot parkingSpot){
        this.parkingSpot = parkingSpot;
    }


}
