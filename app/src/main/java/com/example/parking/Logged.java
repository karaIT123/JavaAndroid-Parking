package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class Logged extends AppCompatActivity implements Serializable {

    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        Intent i = getIntent();
        id = i.getSerializableExtra("user_id").toString();

    }

    public void myAccount(View view) {
        Intent i = new Intent(getApplicationContext(),MyAccount.class);
        i.putExtra("users_id",this.id);
        startActivity(i);
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