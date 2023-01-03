package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void loc(View view) {
        Intent intent = new Intent(Location.this, PaintList.class);
        startActivity(intent);
    }

    public void set(View view) {
        Intent intent = new Intent(Location.this, SettingUser.class);
        startActivity(intent);
    }
}