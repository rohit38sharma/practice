package com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;
import com.rohit.practice.LLD.Design.ParkingLot.model.vehicle.Vehicle;

public abstract class ParkingSpot {
    private final String floorNumber;
    private final String spotNumber;
    private final SpotType parkingSpotType;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSpot(String floorNumber, String spotNumber, SpotType parkingSpotType){
        this.parkingSpotType = parkingSpotType;
        this.floorNumber = floorNumber;
        this.spotNumber = spotNumber;
        this.isFree = true;
    }

    public String getFloorNumber() {
        return this.floorNumber;
    }

    public String getSpotNumber() {
        return this.spotNumber;
    }

    public SpotType getParkingSpotType() {
        return this.parkingSpotType;
    }

    public boolean isFree() {
        return this.isFree;
    }

    public void assignVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.isFree = true;
    }
}
