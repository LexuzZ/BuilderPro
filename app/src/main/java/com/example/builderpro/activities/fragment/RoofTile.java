package com.example.builderpro.activities.fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

import com.example.builderpro.KonfirmasiPembayaran;
import com.example.builderpro.R;
import com.example.builderpro.SettingUser;

public class RoofTile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roof_tile);
    }
    public void roof (View view){
        Intent intent = new Intent(RoofTile.this, KonfirmasiPembayaran.class);
        startActivity(intent);
    }
    public void set(View view){
        Intent intent = new Intent (RoofTile.this, SettingUser.class);
        startActivity(intent);
    }
}