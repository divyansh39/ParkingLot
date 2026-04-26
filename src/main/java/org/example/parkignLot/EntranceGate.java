package org.example.parkignLot;

import org.example.entity.Ticket;
import org.example.entity.Vehicle;

public class EntranceGate {
    public Ticket enter(ParkingBuilding building, Vehicle vehicle){
        return building.allocate(vehicle);
    }

}
