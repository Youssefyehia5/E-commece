package com.jmc.bitcart;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseManger {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "0000";

    public static Connection getConnection() throws Exception {
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;

    }

}
