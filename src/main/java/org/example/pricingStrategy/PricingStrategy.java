package org.example.pricingStrategy;

import org.example.entity.Ticket;

public interface PricingStrategy {
    double calculate(Ticket ticket);
}
