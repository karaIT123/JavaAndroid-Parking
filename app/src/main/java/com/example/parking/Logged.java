package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Logged extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);
    }

    public void myAccount(View view) {

    }

    public void addParking(View view) {
        Intent i = new Intent(getApplicationContext(),AddZone.class);
        startActivity(i);
    }

    public void parkingList(View view) {
        Intent i = new Intent(getApplicationContext(),ParkingList.class);
        startActivity(i);
    }

    public void userList(View view) {
        Intent i = new Intent(getApplicationContext(),UserList.class);
        startActivity(i);
    }
}