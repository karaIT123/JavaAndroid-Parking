package com.example.parking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MyAccount extends AppCompatActivity implements Serializable {

    EditText fullname,username,email,password;
    String id;
    DatabaseManager databaseManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        Intent i = getIntent();
        id = i.getSerializableExtra("users_id").toString();

        fullname = findViewById(R.id.account_fullname);
        username = findViewById(R.id.account_username);
        email = findViewById(R.id.account_email);
        password = findViewById(R.id.account_password);


        databaseManager = new DatabaseManager(this);

        try {
            databaseManager.open();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        fill();
    }

    private void fill()
    {
        Cursor cursor = databaseManager.getOneUser(this.id);
        cursor.moveToFirst();
        fullname.setText(cursor.getString((int)cursor.getColumnIndex(DatabaseHelper.USER_FULLNAME)));
        username.setText(cursor.getString((int)cursor.getColumnIndex(DatabaseHelper.USER_USERNAME)));
        email.setText(cursor.getString((int)cursor.getColumnIndex(DatabaseHelper.USER_EMAIL)));
        password.setText(cursor.getString((int)cursor.getColumnIndex(DatabaseHelper.USER_PASSWORD)));
    }

    public void accountGoBack(View view) {
        finish();
    }

    public void update(View view) {
        String sfullname = fullname.getText().toString();
        String susername = username.getText().toString();
        String semail = email.getText().toString();
        String spassord = password.getText().toString();


        if(sfullname.isEmpty()){
            Toast.makeText(this,"Enter Name",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(susername.isEmpty()){
            Toast.makeText(this,"Enter Username",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(semail.isEmpty()){
            Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(spassord.isEmpty()){
            Toast.makeText(this,"Enter Password",Toast.LENGTH_SHORT).show();
            return;
        }
        else {

            boolean checkSign = databaseManager.updatetUser(id,sfullname,susername,semail,spassord);
            if(checkSign){
                Toast.makeText(getApplicationContext(),"SignUp success", Toast.LENGTH_SHORT).show();
                finish();
            }
            else
                Toast.makeText(getApplicationContext(),"SignUp failed", Toast.LENGTH_SHORT).show();

        }
    }
}