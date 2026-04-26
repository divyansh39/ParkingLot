package org.example.lookUpStrategy;

import org.example.entity.ParkingSpot;

import java.util.List;

public interface ParkignSpotLookUpStrategy {
    ParkingSpot selectSpot(List<ParkingSpot> spots);
}
