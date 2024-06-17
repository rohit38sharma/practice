package com.rohit.practice.LLD.Design.ParkingLot.model;

import com.rohit.practice.LLD.Design.ParkingLot.constant.TicketStatus;
import com.rohit.practice.LLD.Design.ParkingLot.model.vehicle.Vehicle;
import com.rohit.practice.LLD.Design.ParkingLot.util.DateTimeUtil;

import java.sql.Timestamp;

public class ParkingTicket {
    private final String ticketNumber;
    private final Timestamp entryTime;
    private final Vehicle vehicle;
    private TicketStatus status;

    public ParkingTicket(Vehicle vehicle){
        this.vehicle = vehicle;
        this.ticketNumber = generateTicketNumber();
        this.entryTime = DateTimeUtil.getCurrentTime();
        this.status = TicketStatus.ACTIVE;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }

    public Timestamp getEntryTime(){
        return this.entryTime;
    }

    public String getTicketNumber(){
        return this.ticketNumber;
    }

    public void markPaid(){
        this.status = TicketStatus.PAID;
    }

    public void markLost(){
        this.status = TicketStatus.LOST;
    }

    private String generateTicketNumber(){
        return String.valueOf(System.currentTimeMillis());
    }

}
