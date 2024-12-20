package com.jmc.bitcart;

public class Payment {
    private static int counter=0;
    private int id;
    private double amount;
    private String paymentMethod;
    private String status;

    public Payment(int id, double amount, String paymentMethod, String status) {
        counter++;
        this.id = counter;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

}
