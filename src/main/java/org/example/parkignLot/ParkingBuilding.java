package org.example.parkignLot;

import org.example.entity.ParkingSpot;
import org.example.entity.Ticket;
import org.example.entity.Vehicle;
import org.example.spotManagers.ParkingSpotManager;

import java.util.List;

public class ParkingBuilding {

    List<ParkignLevel> levels;

    public ParkingBuilding(List<ParkignLevel> levels){
        this.levels=levels;
    }

    public Ticket allocate(Vehicle vehicle){
        for(ParkignLevel level:levels){
            if(level.hasAvailability(vehicle.getVehicleType())){
                ParkingSpot spot=level.park(vehicle.getVehicleType());
                if(spot!=null){
                    Ticket ticket=new Ticket(vehicle,level,spot);
                    System.out.println("Parkign allocated at level: "
                            +level.getLevelNumber()+" spot: "+spot.getSpotNo());
                    return ticket;
                }
            }
        }
        throw new RuntimeException("Parking Full");
    }

    public void release(Ticket ticket){
        ticket.getLevel().unPark(
                ticket.getVehicle().getVehicleType(),ticket.getSpot()
        );
    }

}
