package com.rohit.practice.LLD.Design.ParkingLot;

import com.rohit.practice.LLD.Design.ParkingLot.constant.PaymentMode;
import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;
import com.rohit.practice.LLD.Design.ParkingLot.constant.VehicleType;
import com.rohit.practice.LLD.Design.ParkingLot.mapper.SpotVehicleMapper;
import com.rohit.practice.LLD.Design.ParkingLot.model.Address;
import com.rohit.practice.LLD.Design.ParkingLot.model.ParkingFloor;
import com.rohit.practice.LLD.Design.ParkingLot.model.ParkingRate;
import com.rohit.practice.LLD.Design.ParkingLot.model.ParkingTicket;
import com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot.ParkingSpot;
import com.rohit.practice.LLD.Design.ParkingLot.model.payment.PaymentGateway;
import com.rohit.practice.LLD.Design.ParkingLot.model.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private String name;
    private Address address;
    private ParkingRate parkingRate;
    private SpotVehicleMapper spotVehicleMapper;
    private Map<String, ParkingFloor> parkingFloors;
    private Map<String, ParkingTicket> activeTickets;

    private static ParkingLot parkingLot = null;

    private ParkingLot(){
        this.name = loadName();
        this.address = loadAddress();
        this.parkingRate = new ParkingRate();
        this.spotVehicleMapper = new SpotVehicleMapper();
        this.parkingFloors = new HashMap<>();
        this.activeTickets = new HashMap<>();
    }

    public static ParkingLot getInstance(){
        if(parkingLot == null){
            synchronized (ParkingLot.class){
                if(parkingLot == null){
                    parkingLot = new ParkingLot();
                }
            }
        }

        return parkingLot;
    }

    public void addParkingFloors(ParkingFloor parkingFloor){
        if(parkingFloor == null || this.parkingFloors.containsKey(parkingFloor.getFloorNumber())){
            System.out.println("Parking floor already exist.");
            return;
        }
        this.parkingFloors.put(parkingFloor.getFloorNumber(), parkingFloor);
    }

    public ParkingTicket assignParkingTicket(Vehicle vehicle, boolean isHandicapped){
        //Find a suitable spot for the vehicle
        List<SpotType> supportedSpotTypes = this.spotVehicleMapper.
                mapSpotTypeForVehicle(vehicle.getVehicleType(), isHandicapped);

        //Find and Assign a free spot to the vehicle
        ParkingSpot parkingSpot = null;
        for(SpotType type : supportedSpotTypes){
            for(String floor : parkingFloors.keySet()){
                parkingSpot = parkingFloors.get(floor).assignParkingSpot(type, vehicle);
                if(parkingSpot != null)
                    break;
            }
            if(parkingSpot != null)
                break;
        }

        if(parkingSpot == null){
            System.out.println("No free parking slot available for this vehicle.");
            return null;
        }

        vehicle.assignSpot(parkingSpot);
        //Generate a new ticket
        ParkingTicket parkingTicket = new ParkingTicket(vehicle);
        vehicle.assignTicket(parkingTicket);
        this.activeTickets.put(parkingTicket.getTicketNumber(), parkingTicket);

        return parkingTicket;
    }

    public boolean payParkingTicket(ParkingTicket parkingTicket, PaymentMode paymentMode){
        if(parkingTicket == null)
            return false;

        Vehicle vehicle = parkingTicket.getVehicle();
        ParkingSpot assignedParkingSpot = vehicle.getParkingSpot();
        parkingFloors.get(assignedParkingSpot.getFloorNumber()).freeParkingSpot(assignedParkingSpot);

        double totalAmount = this.parkingRate.calculateParkingCharges(assignedParkingSpot.getParkingSpotType(),
                parkingTicket.getEntryTime());
        System.out.println("Total parking charge is Rs. " + totalAmount);
        boolean paymentStatus = PaymentGateway.getInstance().acceptPayment(totalAmount, paymentMode);
        if(paymentStatus){
            parkingTicket.markPaid();
            this.activeTickets.remove(parkingTicket.getTicketNumber());
            return true;
        }else{
            System.out.println("Payment failed.");
            return false;
        }
    }

    public String getName(){
        return this.name;
    }

    public Address getAddress() {
        return this.address;
    }

    private Address loadAddress() {
        return new Address();
    }

    private String loadName() {
        return "";
    }


}
