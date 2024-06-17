package com.rohit.practice.LLD.Design.ParkingLot.mapper;

import com.rohit.practice.LLD.Design.ParkingLot.constant.SpotType;
import com.rohit.practice.LLD.Design.ParkingLot.constant.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class SpotVehicleMapper {
    public List<SpotType> mapSpotTypeForVehicle(VehicleType vehicleType, boolean isHandicapped){
        List<SpotType> spotTypes = new ArrayList<>();
        if(vehicleType == VehicleType.BIKE){
            spotTypes.add(SpotType.BIKE);
        }else if(vehicleType == VehicleType.CAR){
            spotTypes.add(SpotType.COMPACT);
            spotTypes.add(SpotType.LARGE);
            if(isHandicapped)
                spotTypes.add(SpotType.HANDICAPPED);
        }else if(vehicleType == VehicleType.TRUCK){
            spotTypes.add(SpotType.LARGE);
        }else if(vehicleType == VehicleType.ELECTRIC){
            spotTypes.add(SpotType.ELECTRIC);
        }

        return spotTypes;
    }
}
