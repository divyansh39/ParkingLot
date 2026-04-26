package org.example.lookUpStrategy;

import org.example.entity.ParkingSpot;

import java.util.List;

public class RandomLookUpStrategy implements  ParkignSpotLookUpStrategy{

    public ParkingSpot selectSpot(List<ParkingSpot> spots){
        for(ParkingSpot spot:spots){
            if(spot.isSpotFree()){
                return spot;
            }
        }
        return null;
    }

}
