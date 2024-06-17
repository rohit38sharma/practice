package com.rohit.practice.LLD.patterns.factory;

public class Client {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new TwoWheelerFactory();
        Vehicle vehicle = vehicleFactory.createVehicle();
        vehicle.print();

        vehicleFactory = new FourWheelerFactory();
        vehicle = vehicleFactory.createVehicle();
        vehicle.print();

    }
}
