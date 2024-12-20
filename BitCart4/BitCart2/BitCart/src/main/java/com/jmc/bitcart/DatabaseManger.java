package com.jmc.bitcart;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManger {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
<<<<<<< HEAD:BitCart4/BitCart2/BitCart/src/main/java/com/jmc/bitcart/DatabaseManger.java
    private static final String PASSWORD = "1234";
=======
    private static final String PASSWORD = "0000";
>>>>>>> d6527837593129256ddda22a0022f0de1697c299:BitCart/src/main/java/com/jmc/bitcart/DatabaseManger.java

    public static Connection getConnection() throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;

    }

}
