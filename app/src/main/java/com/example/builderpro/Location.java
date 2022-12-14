package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.activities.fragment.Ceramist;
import com.example.builderpro.activities.fragment.Etc;
import com.example.builderpro.activities.fragment.Painter;
import com.example.builderpro.activities.fragment.RoofTile;

public class Location extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }

    public void loc(View view) {
        Intent intent = new Intent(Location.this, Painter.class);
        startActivity(intent);
    }

    public void locr(View view) {
        Intent intent = new Intent(Location.this, RoofTile.class);
        startActivity(intent);
    }

    public void locc(View view) {
        Intent intent = new Intent(Location.this, Ceramist.class);
        startActivity(intent);
    }

    public void loce(View view) {
        Intent intent = new Intent(Location.this, Etc.class);
        startActivity(intent);
    }

    public void set(View view) {
        Intent intent = new Intent(Location.this, SettingUser.class);
        startActivity(intent);
    }
}