package org.example.parkignLot;

import org.example.entity.Ticket;
import org.example.entity.Vehicle;

public class ParkignLot {

    private final  ParkingBuilding building;
    private final EntranceGate entranceGate;
    private final ExitGate exitGate;

    public ParkignLot(ParkingBuilding building, EntranceGate entranceGate, ExitGate exitGate){
        this.building=building;
        this.entranceGate=entranceGate;
        this.exitGate=exitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle){
        return entranceGate.enter(building,vehicle);
    }

    public void exitGate(Ticket ticket, Payment payment){
        exitGate.completeExit(building, ticket, payment);
    }

}
