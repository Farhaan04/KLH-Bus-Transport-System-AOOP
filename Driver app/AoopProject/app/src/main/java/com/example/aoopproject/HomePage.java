package com.example.aoopproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {

    private Button Share,Stop,Details;
    private FirebaseAuth mAuh;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Share=(Button) findViewById(R.id.button1);
        Stop=(Button) findViewById(R.id.button2);
        Details=(Button) findViewById(R.id.button3);

        Share.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, MapsActivity.class);
            startActivity(intent);
        });

        Stop.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomePage.this, LoginPage.class);
                startActivity(intent);
        });

        Details.setOnClickListener(view -> {
            Intent intent = new Intent(HomePage.this, LoginPage.class);
            startActivity(intent);
        });

    }
}