package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeUser extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);


    }
    public void buy(View view){
        Intent intent = new Intent(HomeUser.this, Location.class);
        startActivity(intent);
    }
    public void buyc(View view){
        Intent intent = new Intent(HomeUser.this, Location.class);
        startActivity(intent);
    }
    public void buyr(View view){
        Intent intent = new Intent(HomeUser.this, Location.class);
        startActivity(intent);
    }
    public void buyt (View view){
        Intent intent = new Intent(HomeUser.this, Location.class);
        startActivity(intent);
    }
    public void set (View view ){
        Intent intent = new Intent (HomeUser.this, SettingUser.class);
        startActivity(intent);
    }
}

