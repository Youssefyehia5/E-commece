package com.jmc.bitcart;

public class Person {
    private String name;
    private String email;
    private String password;

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

}
