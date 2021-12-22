package com.example.parking;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {

    EditText fullname,username,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname = findViewById(R.id.sign_fullname);
        username = findViewById(R.id.sign_username);
        email = findViewById(R.id.sign_email);
        password = findViewById(R.id.sign_password);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void sign_up(View view) {
        String sfullname = fullname.getText().toString();
        String susername = username.getText().toString();
        String semail = email.getText().toString();
        String spassord = password.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(SignUp.this);
        progressDialog.setMessage("Loading...");


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
            progressDialog.show();
            StringRequest request = new StringRequest(Request.Method.POST, "http://localhost:8000/signup",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.equalsIgnoreCase("Sign Up Success")){
                                Toast.makeText(SignUp.this,"SignUp success",Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else
                            {
                                Toast.makeText(SignUp.this,response,Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(SignUp.this,error.getMessage() + " Bla bla bla bla",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String,String>();


                    params.put("fullname",sfullname);
                    params.put("username",susername);
                    params.put("email",semail);
                    params.put("password",spassord);

                    return params;
                }
            }
            ;


            RequestQueue requestQueue = Volley.newRequestQueue(SignUp.this);
            requestQueue.add(request);
        }

    }
}