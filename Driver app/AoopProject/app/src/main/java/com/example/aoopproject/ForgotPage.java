package com.example.aoopproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPage extends AppCompatActivity {

    private EditText editTextEmail;
    private Button Fog_pass;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_page);

        editTextEmail=(EditText) findViewById(R.id.fog_email);
        Fog_pass=(Button) findViewById(R.id.btn_fog);
        Fog_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email;
                Email=editTextEmail.getText().toString().trim();
            }
        });

    }
}