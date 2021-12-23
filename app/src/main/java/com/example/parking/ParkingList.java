package com.example.parking;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ParkingList extends AppCompatActivity {

    public static ArrayList<ParkingClass> arrayList = new ArrayList<>();
    ParkingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_list);

        ListView listView = findViewById(R.id.list);
        adapter = new ParkingAdapter(this,arrayList);
        listView.setAdapter(adapter);
        retrivesData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View","Edit","Delete"};

                builder.setTitle(arrayList.get(position).getName());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch (which){
                            case 0:
                                startActivity(new Intent(getApplicationContext(),ParkingDetails.class).putExtra("position",position));
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                        }
                    }
                });

                builder.create().show();
            }
        });


    }


    private void retrivesData()
    {
        arrayList.clear();
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
                ParkingClass cls = new ParkingClass();
                cls.setId(cursor.getString((int) cursor.getColumnIndex(DatabaseHelper.PARKING_ID)));
                cls.setName(cursor.getString((int) cursor.getColumnIndex(DatabaseHelper.PARKING_NAME)));
                cls.setZone(cursor.getString((int) cursor.getColumnIndex(DatabaseHelper.PARKING_ZONE)));

                arrayList.add(cls);
            }
            while (cursor.moveToNext());
        }
        adapter.notifyDataSetChanged();
    }
}