package com.jmc.bitcart;
import java.util.List;

public class Order {
    private static int counter=0;
    private int id;
    private User user;
    private List<Product> products;
    private Payment payment;

    public Order(int id, User user, List<Product> products, Payment payment) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.payment = payment;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Payment getPayment() {
        return payment;
    }


}
