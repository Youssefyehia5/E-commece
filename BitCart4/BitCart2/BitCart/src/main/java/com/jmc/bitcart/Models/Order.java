package com.jmc.bitcart.Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter=0;
    public  int id;
    private User user;
    public List<Product> products;
    private Payment payment;

    public Order() {
        this.products = new ArrayList<>(); // Initialize the products list
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", payment=" + payment +
                '}';
    }
}
