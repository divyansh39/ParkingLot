package org.example.entity;

public class ParkingSpot {
    private final String spotNo;
    private boolean isFree=true;

    public ParkingSpot(String spotNo){
        this.spotNo=spotNo;
    }

    public boolean isSpotFree(){
        return isFree;
    }

    public void occupiedSpot(){
        isFree=false;
    }

    public void releaseSpot(){
        isFree=true;
    }

    public String getSpotNo(){
        return spotNo;
    }

}
