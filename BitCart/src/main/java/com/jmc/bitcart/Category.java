package com.jmc.bitcart;
import java.util.ArrayList;
import java.util.List;


public class Category {
    private static int counter=0;
    private int id;
    private String name;
    private List<Product> products=new ArrayList<>();

    public Category(int id, String name) {
        counter++;
        this.id = counter;
        this.name = name;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
        System.out.println(product.getName()+" added to acategory"+name);
    }
    public void removeProduct(Product product){
        products.remove(product);
        System.out.println(product.getName()+" removed from acategory"+name);
    }
}
