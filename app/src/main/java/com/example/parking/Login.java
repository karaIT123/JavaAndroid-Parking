package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username,password;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);

        databaseManager = new DatabaseManager(this);

        try {
            databaseManager.open();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void goToSignUp(View view) {
        Intent i = new Intent(getApplicationContext(),SignUp.class);
        startActivity(i);
    }

    public void login(View view) {
        Cursor cursor = databaseManager.getUserByUsernameAndPassword(username.getText().toString(),password.getText().toString());
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            Intent i = new Intent(this,Logged.class);
            int index = cursor.getColumnIndex("_ID");
            String id = cursor.getString(index);
            i.putExtra("user_id",id);
            startActivity(i);

            Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_SHORT).show();
        }
    }
}