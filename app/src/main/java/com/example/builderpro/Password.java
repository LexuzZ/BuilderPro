package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
    }
    public void repeat (View view){
        Intent intent = new Intent(Password.this, MainActivity.class);
        startActivity(intent);
    }
}