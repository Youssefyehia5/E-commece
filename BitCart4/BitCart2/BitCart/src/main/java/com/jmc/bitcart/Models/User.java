package com.jmc.bitcart.Models;

import java.util.ArrayList;
import java.util.List;

public class User extends Person{
    private static int counter=0;
    private int id;
    private List<Product> wishlist=new ArrayList<>();
    private List<Order> orders= new ArrayList<>();

    public User(String email, String password, String phone) {
        super(email, password);
        this.id = id;
    }

    public User(String email, String password) throws Exception {
        super(email, password);
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setWishlist(List<Product> wishlist) {
        this.wishlist = wishlist;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setCounter(int counter) {
        User.counter = counter;
    }

    public int getId() {
        return id;
    }

    public User(String name, String email, String password, String phone) {
        super(name, email, password, phone);
    }

    public User(int id, String name, String email, String password) {
        super(name, email, password);
        counter++;
        this.id = counter;
    }

    public List<Product> getWishlist() {
        return wishlist;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void addToWishlist(Product product){
        wishlist.add(product);
        System.out.println(product.getName()+" added to wishlist");
    }
    public void removeFromWishlist(Product product){
        wishlist.remove(product);
        System.out.println(product.getName()+" removed to wishlist");
    }
    public void placeOrder(Order order){
        orders.add(order);
        System.out.println("Order ID "+order.getId());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", wishlist=" + wishlist +
                ", orders=" + orders +
                "} " + super.toString();
    }
}
