package com.jmc.bitcart;

public class Product {
    private static int counter=0;
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;

    public Product(int id, String name, double price, String description, Category category) {
        counter++;
        this.id = counter;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

}
