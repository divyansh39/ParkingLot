package org.example;

import org.example.entity.ParkingSpot;
import org.example.entity.Ticket;
import org.example.entity.Vehicle;
import org.example.entity.VehicleType;
import org.example.lookUpStrategy.ParkignSpotLookUpStrategy;
import org.example.lookUpStrategy.RandomLookUpStrategy;
import org.example.parkignLot.*;
import org.example.payment.CashPayment;
import org.example.payment.UpiPayment;
import org.example.pricingStrategy.CostComputation;
import org.example.pricingStrategy.FixedPricingStrategy;
import org.example.spotManagers.FourWheelerSpotManager;
import org.example.spotManagers.ParkingSpotManager;
import org.example.spotManagers.TwoWheelerSpotManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkignSpotLookUpStrategy strategy=new RandomLookUpStrategy();
        Map<VehicleType, ParkingSpotManager> levelOneManagers=new HashMap<>();
        levelOneManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L1-S1"),
                new ParkingSpot("L1-S2")),strategy));

        levelOneManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L1-S3")),strategy));

        ParkignLevel level1=new ParkignLevel(1, levelOneManagers);

        Map<VehicleType, ParkingSpotManager> levelTwoManagers=new HashMap<>();
        levelTwoManagers.put(VehicleType.TWO_WHEELER,
                new TwoWheelerSpotManager(List.of(new ParkingSpot("L2-S1")),strategy));

        levelTwoManagers.put(VehicleType.FOUR_WHEELER,
                new FourWheelerSpotManager(List.of(new ParkingSpot("L2-S2"),
                        new ParkingSpot("L2-S3")), strategy));

        ParkignLevel level2=new ParkignLevel(2, levelTwoManagers);

        ParkingBuilding parkingBuilding=new ParkingBuilding(
                List.of(level1, level2),
                new CostComputation(new FixedPricingStrategy()));

        ParkignLot parkignLot=new ParkignLot(parkingBuilding, new EntranceGate(),
                new ExitGate(new CostComputation(new FixedPricingStrategy()))
        );

        Vehicle bike =new Vehicle("BIKE-101", VehicleType.TWO_WHEELER);
        Vehicle car =new Vehicle("CAR-201", VehicleType.FOUR_WHEELER);

        Ticket t1= parkignLot.vehicleArrives(bike);
        Ticket t2= parkignLot.vehicleArrives(car);

        parkignLot.vehicleExits(t1, new CashPayment());
        parkignLot.vehicleExits(t2, new UpiPayment());


    }
}