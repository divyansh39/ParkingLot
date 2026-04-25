package org.example.entity;

public class Vehicle {

    private String vehicleNo;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNo, VehicleType vehicleType){
        this.vehicleNo=vehicleNo;
        this.vehicleType=vehicleType;
    }

    public String getVehicleNo(){
        return vehicleNo;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }

}
