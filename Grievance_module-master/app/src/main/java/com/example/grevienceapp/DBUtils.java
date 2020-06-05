package com.example.grevienceapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

    Connection conn;
   // String url="jdbc:oracle:thin:@localhost:1521:XE";
   String ip = "192.168.1.1";
    String port = "1433";
    String Classes = "net.sourceforge.jtds.jdbc.Driver";
    String database = "testDatabase1";
    String username = "test";
    String password = "root";
    String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,"hr12","root");
        }catch(Exception e) {
            System.out.println("asda");
        }
        return conn;
    }

}
