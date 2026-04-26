package org.example.entity;

import org.example.parkignLot.ParkignLevel;

import java.time.LocalDateTime;
import java.util.logging.Level;

public class Ticket {

    private final Vehicle vehicle;
    private final ParkignLevel level;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;

    public Ticket(Vehicle vehicle,ParkignLevel level, ParkingSpot spot){
        this.vehicle=vehicle;
        this.level=level;
        this.spot=spot;
        this.entryTime=LocalDateTime.now();
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public ParkignLevel getLevel() {
        return level;
    }

    public ParkingSpot getSpot(){
        return spot;
    }

    public LocalDateTime getEntryTime(){
        return  entryTime;
    }

}
