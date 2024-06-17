package com.rohit.practice.LLD.patterns.factory;

public class TwoWheelerFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}
