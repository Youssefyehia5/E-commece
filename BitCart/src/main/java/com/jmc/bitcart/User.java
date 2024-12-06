package com.jmc.bitcart;
import java.util.ArrayList;
import java.util.List;

public class User extends Person{
    private static int counter=0;
    private int id;
    private List<Product> wishlist=new ArrayList<>();
    private List<Order> orders= new ArrayList<>();

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
}
