package com.rohit.practice.LLD.patterns.factory;

public class FourWheelerFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}
