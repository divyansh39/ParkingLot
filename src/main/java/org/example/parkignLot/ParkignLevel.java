package org.example.parkignLot;

import org.example.entity.ParkingSpot;
import org.example.entity.VehicleType;
import org.example.spotManagers.ParkingSpotManager;

import java.util.Map;

public class ParkignLevel {

    private final int levelNumber;
    private final Map<VehicleType, ParkingSpotManager> managers;

    public ParkignLevel(int levelNumber, Map<VehicleType, ParkingSpotManager> managers){
        this.levelNumber=levelNumber;
        this.managers=managers;
    }

    public boolean hasAvailability(VehicleType type){
        ParkingSpotManager manager=managers.get(type);
        return manager!=null && manager.hasFreeSpot();
    }

    public ParkingSpot park(VehicleType type){
        ParkingSpotManager manager=managers.get(type);
        if(manager==null){
            throw new IllegalArgumentException("No parkign available for vehicle type: "+type);
        }
        return manager.park();
    }

    public void unPark(VehicleType type, ParkingSpot spot){
        ParkingSpotManager manager= managers.get(type);
        if(manager!=null){
            manager.unPark(spot);
        }
    }

    public int getLevelNumber(){
        return levelNumber;
    }
}
