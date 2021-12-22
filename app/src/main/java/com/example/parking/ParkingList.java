package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ParkingList extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_list);

        listView = findViewById(R.id.list);
        adapter = new ArrayAdapter(ParkingList.this,R.layout.support_simple_spinner_dropdown_item);
        listView.setAdapter(adapter);


    }

    private ArrayList<String> GetArrayList()
    {
        ArrayList<String> arr = new ArrayList<String>();
        return arr;
    }
}