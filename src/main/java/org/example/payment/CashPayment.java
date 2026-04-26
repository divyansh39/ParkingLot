package org.example.payment;

public class CashPayment implements Payment {

    @Override
    public boolean pay(double amount){
        System.out.println("cash paid "+amount);
        return true;
    }

}
