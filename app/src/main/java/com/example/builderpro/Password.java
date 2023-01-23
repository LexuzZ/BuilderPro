package com.example.builderpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.builderpro.data.sign.CreateAccount;
import com.google.firebase.auth.FirebaseAuth;


public class Password extends AppCompatActivity {
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

    }
    public void repeat (View view){
        Intent intent = new Intent(Password.this, CreateAccount.class);
        startActivity(intent);
    }
}