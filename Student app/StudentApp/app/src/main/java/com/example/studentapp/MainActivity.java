package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    TextView appname;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo= findViewById(R.id.imageView);
        appname= findViewById(R.id.textView);
        lottieAnimationView=findViewById(R.id.lottie);

        appname.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(2000).setDuration(1000).setStartDelay(4000);


        final Intent[] intent = new Intent[1];
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                intent[0] = new Intent(MainActivity.this, MainPage.class);
                startActivity(intent[0]);
                finish();
            }
        },5000);

    }
}