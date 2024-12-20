package com.jmc.bitcart.Models;

public class Product {
    private static int counter=0;
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;
    private String ImageSrc;
    private String seller;
private int quantity;
    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(int id, String name, double price, String description, Category category) {
        counter++;
        this.id = counter;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    public Product(){
        this.id = 0;
        this.name = "";
        this.price = 0;
        this.description = "";
        this.category = null;
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
//FXML starts from here

    public void setName(String name) {
        this.name = name;
    }

    public String getImageSrc() {
        return ImageSrc;
    }

    public void setImageSrc(String imageSrc) {
        ImageSrc = imageSrc;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public static void setCounter(int counter) {
        Product.counter = counter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", ImageSrc='" + ImageSrc + '\'' +
                ", seller='" + seller + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
