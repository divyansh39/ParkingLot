package org.example.spotManagers;

import org.example.entity.ParkingSpot;
import org.example.lookUpStrategy.ParkignSpotLookUpStrategy;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public abstract class ParkingSpotManager {

    protected final List<ParkingSpot> spots;
    private final ParkignSpotLookUpStrategy strategy;
    private final ReentrantLock lock=new ReentrantLock(true);

    protected ParkingSpotManager(List<ParkingSpot> spots, ParkignSpotLookUpStrategy strategy){
        this.spots=spots;
        this.strategy=strategy;
    }

    public ParkingSpot park(){
        lock.lock();
        try{
            ParkingSpot spot=strategy.selectSpot(spots);
            if(spot==null){
                return null;
            }
            spot.occupiedSpot();
            return spot;
        }finally {
            lock.unlock();
        }
    }

    public void unPark(ParkingSpot spot){
        lock.lock();
        try{
            spot.releaseSpot();
        }finally {
            lock.unlock();
        }
    }

    public boolean hasFreeSpot(){
        lock.lock();
        try{
            return spots.stream().anyMatch(ParkingSpot::isSpotFree);
        }finally {
            lock.unlock();
        }
    }


}
