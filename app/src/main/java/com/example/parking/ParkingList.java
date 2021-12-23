package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ParkingList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_list);

        ListView listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ParkingList.this,R.layout.support_simple_spinner_dropdown_item, getList());
        listView.setAdapter(adapter);


    }


    private ArrayList<String> getList()
    {
        ArrayList<String> arr = new ArrayList<String>();
        DatabaseManager databaseManager = new DatabaseManager(getApplicationContext());
        try {
            databaseManager.open();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        Cursor cursor = databaseManager.getAllParking();
        if (cursor.moveToFirst()) {
            do {

                arr.add(cursor.getString((int) cursor.getColumnIndex(DatabaseHelper.PARKING_NAME)) + " " + cursor.getString((int) cursor.getColumnIndex(DatabaseHelper.PARKING_ZONE)));
            }
            while (cursor.moveToNext());
        }
        return arr;
    }
}