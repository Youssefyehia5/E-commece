package com.jmc.bitcart.Models;

public class Person {
    private String name;
    private String email;
    private String password;
    private String phone;

    public Person(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Person(String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Person(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public void login(){
        System.out.println("Login successful");
    }
    public void logout(){
        System.out.println("Logout successful");
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
