package com.rohit.practice.LLD.Design.ParkingLot.model;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;
import com.rohit.practice.LLD.Design.ParkingLot.model.parkingspot.ParkingSpot;
import com.rohit.practice.LLD.Design.ParkingLot.model.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {

    private final String floorNumber;
    private Map<SpotType, Map<String, ParkingSpot>> spots;
    private Map<SpotType, Integer> freeSpotCount;
    private final DisplayPanel displayPanel;

    public ParkingFloor(String floorNumber){
        this.floorNumber = floorNumber;
        this.spots = new HashMap<>();
        this.displayPanel = new DisplayPanel();
        this.freeSpotCount = new HashMap<>();
    }

    public String getFloorNumber(){
        return this.floorNumber;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        this.spots.computeIfAbsent(parkingSpot.getParkingSpotType(), key -> new HashMap<>())
                .put(parkingSpot.getSpotNumber(), parkingSpot);
        this.freeSpotCount.put(parkingSpot.getParkingSpotType(),
                this.freeSpotCount.getOrDefault(parkingSpot.getParkingSpotType(), 0) + 1);
        updateDisplayPanelMsg();
    }

    public void removeParkingSpot(ParkingSpot parkingSpot){
        if(parkingSpot != null){
            Map<String, ParkingSpot> spotMap = this.spots.get(parkingSpot.getParkingSpotType());
            if(spotMap != null && spotMap.containsKey(parkingSpot.getParkingSpotType())){
                spotMap.remove(parkingSpot.getSpotNumber());
                updateDisplayPanelMsg();
            }
        }
    }

    public ParkingSpot assignParkingSpot(SpotType spotType, Vehicle vehicle) {
        ParkingSpot spot = null;
        Map<String, ParkingSpot> allSpots = this.spots.get(spotType);
        if(this.freeSpotCount.getOrDefault(spotType,0) > 0){
            synchronized (allSpots){
                for(String spotnum : allSpots.keySet()){
                    ParkingSpot s = allSpots.get(spotnum);
                    if(s.isFree()){
                        spot = s;
                        s.assignVehicle(vehicle);
                        this.freeSpotCount.put(spotType,
                                this.freeSpotCount.get(spotType) - 1);
                        break;
                    }
                }
            }
        }
        if(spot != null)
            updateDisplayPanelMsg();
        return spot;
    }

    public void freeParkingSpot(ParkingSpot parkingSpot){
        if(parkingSpot != null){
            parkingSpot.removeVehicle();
            this.freeSpotCount.put(parkingSpot.getParkingSpotType(),
                    this.freeSpotCount.get(parkingSpot.getParkingSpotType()) + 1);
            updateDisplayPanelMsg();
        }
    }

    private void updateDisplayPanelMsg(){
        StringBuilder sb = new StringBuilder();
        for(SpotType type : this.spots.keySet()){
            sb.append("\n");
            sb.append("---------------");
            sb.append("\n");
            sb.append(type.toString());
            sb.append("\n");
            sb.append("---------------");
            Map<String, ParkingSpot> s = this.spots.get(type);
            int total = s.size();
            int free = 0;
            for(String n : s.keySet()){
                if(s.get(n).isFree()){
                    ++free;
                }
            }
            sb.append("\n");
            sb.append("Total spots = ");
            sb.append(total);
            sb.append("\n");
            sb.append("Free spots = ");
            sb.append(free);
            sb.append("\n");
            sb.append("---------------");
            sb.append("\n");
        }
        this.displayPanel.setMsg(sb.toString());
        this.displayPanel.displayMsg();
    }

}
