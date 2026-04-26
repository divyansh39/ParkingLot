package org.example.pricingStrategy;

import org.example.entity.Ticket;

public class FixedPricingStrategy implements  PricingStrategy{
    @Override
    public double calculate(Ticket ticket){
        return 100;
    }
}
