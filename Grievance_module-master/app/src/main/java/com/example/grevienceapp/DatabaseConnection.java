package com.example.grevienceapp;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnection {

    //ESTABLISHES CONNECTION WITH MS SQL DATABASE
    //can be called from any class
    @SuppressLint("NewApi")
    static Connection ConnectDB()
    {
        String ip = "192.168.1.9";
        String port = "1433";
        String Classes = "net.sourceforge.jtds.jdbc.Driver";
        String database = "testDatabase1";
        String username = "test";
        String password = "root";
        String url = "jdbc:jtds:sqlserver://"+ip+":"+port+"/"+database;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        try
        {
            Class.forName(Classes);
            connection = DriverManager.getConnection(url, username,password);
            //textView.setText("DATABASE CONNECTED");
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }
}
