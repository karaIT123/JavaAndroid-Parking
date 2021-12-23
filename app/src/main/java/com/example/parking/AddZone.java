package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddZone extends AppCompatActivity {

    EditText name,zone;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_zone);

        name = findViewById(R.id.parking_name);
        zone = findViewById(R.id.parking_zone);

        databaseManager = new DatabaseManager(this);

        try {
            databaseManager.open();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void Add(View view) {
        String sname = name.getText().toString();
        String szone = zone.getText().toString();

        if(sname.isEmpty()){
            Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(szone.isEmpty()){
            Toast.makeText(this,"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            boolean checkSign = databaseManager.insertParking(sname,szone);
            if(checkSign){
                Toast.makeText(getApplicationContext(),"Add with success", Toast.LENGTH_SHORT).show();
                finish();
            }
            else
                Toast.makeText(getApplicationContext(),"Add failed", Toast.LENGTH_SHORT).show();
        }
    }
}