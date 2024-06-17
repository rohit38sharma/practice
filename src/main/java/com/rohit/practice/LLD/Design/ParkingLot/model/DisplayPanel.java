package com.rohit.practice.LLD.Design.ParkingLot.model;

public class DisplayPanel {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void displayMsg(){
        System.out.println(this.msg);
    }
}
