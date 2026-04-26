package org.example.parkignLot;

import org.example.entity.Ticket;
import org.example.payment.Payment;
import org.example.pricingStrategy.CostComputation;

public class ExitGate {

    private final CostComputation costComputation;

    public  ExitGate(CostComputation costComputation){
        this.costComputation=costComputation;
    }

    public void completeExit(ParkingBuilding parkingBuilding, Ticket ticket, Payment payment){
        double amount=calculatePrice(ticket);
        boolean success=payment.pay(amount);

        if(!success){
            throw  new RuntimeException("Payment Failed, Exit Denied");
        }
        parkingBuilding.release(ticket);
        System.out.println("Exit Successful. Gate opened");

    }

    private double calculatePrice(Ticket ticket){
        return costComputation.compute(ticket);
    }

}
