package com.example.grevienceapp;
/**
 * This page must be removed during the integration of the project
 * This page will be replaced with automatic user level auth
 * IMPORTANT
 * ONLY FOR DEVELOPMENT
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class G_Admin_LevelAuth extends AppCompatActivity {
    Button btnLevel;
    //Spinner spinner2;
    EditText edt_url ;
    EditText edt_body;
    EditText edt_heading;
    Connection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g__admin__level_auth);
        edt_url= findViewById(R.id.edt_url);
        String eu = edt_url.getText().toString();
        edt_body= findViewById(R.id.edt_body);
        String eb = edt_body.getText().toString();
        edt_heading = findViewById(R.id.edt_heading);
        String eh = edt_heading.getText().toString();
btnLevel = findViewById(R.id.btnAdminLevel);
btnLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                G_Admin_LevelAuth.AlertDatabase AlertDB = new G_Admin_LevelAuth.AlertDatabase();
                AlertDB.execute("");
            }
        });
        con = new DatabaseConnection().ConnectDB();
        if (con != null) {
            Toast.makeText(G_Admin_LevelAuth.this, "Connection valid", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(G_Admin_LevelAuth.this, "Connection invalid", Toast.LENGTH_SHORT).show();
        }
    }


    public class AlertDatabase extends AsyncTask<String, String, String> {

        String z = "";
        //Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(G_Admin_LevelAuth.this, r, Toast.LENGTH_SHORT).show();
//            if (isSuccess) {
//                Toast.makeText(G_Admin_LevelAuth.this, "Login Successful", Toast.LENGTH_LONG).show();
//
//            }
        }

        @Override
        protected String doInBackground(String... params) {
             String url1 = edt_url.getText().toString();
                String heading1 = edt_heading.toString();
                String body = edt_body.toString();
                //java.sql.Date sqlDate = new java.sql.Date(currentDateandTime);
                //@SuppressLint("WrongThread") String sendMore = edAdd.getText().toString();


//            System.out.println(url1);
//                 System.out.println(heading1);
//                 System.out.println(body);

                String query = "insert into News (url,heading,news) Values ('" + url1 + "','" + heading1 + "','" + body  + "')";

            Statement stmt = null;
            try {
                stmt = con.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            try {
                stmt.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "sucess";
        }




    }
}

