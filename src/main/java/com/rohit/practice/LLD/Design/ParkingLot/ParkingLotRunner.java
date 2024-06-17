package com.rohit.practice.LLD.Design.ParkingLot;

import com.rohit.practice.LLD.Design.ParkingLot.constant.PaymentMode;
import com.rohit.practice.LLD.Design.ParkingLot.model.ParkingFloor;
import com.rohit.practice.LLD.Design.ParkingLot.model.ParkingTicket;
import com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot.BikeParkingSpot;
import com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot.CompactParkingSpot;
import com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot.LargeParkingSpot;
import com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot.ParkingSpot;
import com.rohit.practice.LLD.Design.ParkingLot.model.vehicle.BikeVehicle;
import com.rohit.practice.LLD.Design.ParkingLot.model.vehicle.CarVehicle;
import com.rohit.practice.LLD.Design.ParkingLot.model.vehicle.Vehicle;

public class ParkingLotRunner {
    public static void main(String[] args) throws InterruptedException {


        ParkingFloor parkingFloor = new ParkingFloor("Floor1");
        ParkingSpot parkingSpot1 = new BikeParkingSpot(parkingFloor.getFloorNumber(), "BikeS1");
        ParkingSpot parkingSpot2 = new BikeParkingSpot(parkingFloor.getFloorNumber(), "BikeS2");
        ParkingSpot parkingSpot3 = new CompactParkingSpot(parkingFloor.getFloorNumber(), "CompactS1");
        ParkingSpot parkingSpot4 = new LargeParkingSpot(parkingFloor.getFloorNumber(), "LargeS1");

        parkingFloor.addParkingSpot(parkingSpot1);
        parkingFloor.addParkingSpot(parkingSpot2);
        parkingFloor.addParkingSpot(parkingSpot3);
        parkingFloor.addParkingSpot(parkingSpot4);

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addParkingFloors(parkingFloor);

        Vehicle bike = new BikeVehicle("123");
        ParkingTicket bikeTicket =  parkingLot.assignParkingTicket(bike, false);

        Vehicle car1 = new CarVehicle("234");
        ParkingTicket car1Ticket =  parkingLot.assignParkingTicket(car1, false);

        Vehicle car2 = new CarVehicle("345");
        ParkingTicket car2Ticket =  parkingLot.assignParkingTicket(car2, false);

        Vehicle car3 = new CarVehicle("456");
        ParkingTicket car3Ticket =  parkingLot.assignParkingTicket(car3, false);

        Thread.sleep(10000);

        parkingLot.payParkingTicket(bikeTicket, PaymentMode.CASH);

        parkingLot.payParkingTicket(car1Ticket, PaymentMode.CARD);

        parkingLot.payParkingTicket(car2Ticket, PaymentMode.CASH);

    }
}
