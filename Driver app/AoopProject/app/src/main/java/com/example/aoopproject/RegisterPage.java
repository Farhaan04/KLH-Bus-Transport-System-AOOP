package com.example.aoopproject;


import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Objects;

public class RegisterPage extends AppCompatActivity {
    private TextView Logintext;
    private EditText mEmail,mPass,mUser,mNum;
    private Button Register;
    FirebaseAuth mAuth;

    DatabaseReference users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        Logintext=(TextView) findViewById(R.id.loginText);
        Logintext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPage.this,LoginPage.class);
                startActivity(intent);
            }
        });

        mAuth=FirebaseAuth.getInstance();

        mUser=(EditText) findViewById(R.id.Name);
        mEmail=(EditText) findViewById(R.id.Email);
        mNum=(EditText) findViewById(R.id.Phone);
        mPass=(EditText) findViewById(R.id.Password);
        Register=(Button) findViewById(R.id.btn_register);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });


    }

    private void createUser() {

        String email=mEmail.getText().toString().trim();
        String name=mUser.getText().toString().trim();
        String password=mPass.getText().toString().trim();
        String number= mNum.getText().toString().trim();

        if (name.isEmpty()){
            mUser.setError("Name is Required");
            mUser.requestFocus();
            return;
        }
        if (email.isEmpty()){
            mEmail.setError("Email is Required");
            mEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("Please enter valid Email");
            mEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            mPass.setError("Password is Required");
            mPass.requestFocus();
            return;
        }
        if (password.length() < 8)
        {
            mPass.setError("Password must be grater than 8 charecters");
            mPass.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(task -> {

                    if (task.isSuccessful()){
                        User user = new User(name,email,number,password);

                        FirebaseDatabase.getInstance().getReference("users")
                                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                .setValue(user).addOnCompleteListener(task1 -> {
                                    if (task1.isSuccessful()){
                                        Toast.makeText(RegisterPage.this,"The User has been registered successfully",Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(RegisterPage.this , LoginPage.class));
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(RegisterPage.this,"Failed",Toast.LENGTH_LONG).show();
                                    }
                                });
                    }else {
                        Toast.makeText(RegisterPage.this,"Failed to register",Toast.LENGTH_LONG).show();
                    }
                });
    }

}