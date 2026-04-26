package org.example.spotManagers;

import org.example.entity.ParkingSpot;
import org.example.lookUpStrategy.ParkignSpotLookUpStrategy;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager{

    public FourWheelerSpotManager(List<ParkingSpot> spots, ParkignSpotLookUpStrategy strategy){
        super(spots,strategy);
    }
}
