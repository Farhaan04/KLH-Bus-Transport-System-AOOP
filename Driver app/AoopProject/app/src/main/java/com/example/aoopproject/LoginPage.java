package com.example.aoopproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

public class LoginPage extends AppCompatActivity {

    private TextView register,forgot;
    private EditText editTextEmail,editTextPassword;
    private Button login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        editTextEmail = (EditText) findViewById(R.id.log_email);
        editTextPassword=(EditText) findViewById(R.id.log_pass);
        mAuth=FirebaseAuth.getInstance();

        forgot=(TextView) findViewById(R.id.log_fogpass);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this,ForgotPage.class);
                startActivity(intent);
            }
        });

        register=(TextView) findViewById(R.id.log_signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this,RegisterPage.class);
                startActivity(intent);
            }
        });

        login = (Button) findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogin();
            }
        });
        
    }

    private void userLogin() {
        String email=editTextEmail.getText().toString().trim();
        String password =editTextPassword.getText().toString().trim();

        if (email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter valid Email");
            editTextEmail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            editTextPassword.setError("Password is Required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length()<6){
            editTextPassword.setError("Password must me more than 6 digits");
            editTextPassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginPage.this, "Login in successful", Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginPage.this,HomePage.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginPage.this, "Failed to login Check credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}