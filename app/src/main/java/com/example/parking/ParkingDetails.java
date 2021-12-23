package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ParkingDetails extends AppCompatActivity {

    TextView name,zone;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_details);

        Intent i = getIntent();
        position = i.getExtras().getInt("position");

        name = findViewById(R.id.parkingdetails_name);
        zone = findViewById(R.id.parkingdetails_zone);

        name.setText("Name: " + ParkingList.arrayList.get(position).getName());
        zone.setText("Zone: " + ParkingList.arrayList.get(position).getZone());
    }

    public void DetailsBack(View view) {
        finish();
    }
}