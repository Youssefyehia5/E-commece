package com.jmc.bitcart.Models;

public class Admin extends Person{

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }

    void addProduct(Product laptop) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void addCategory(Category electronics) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

