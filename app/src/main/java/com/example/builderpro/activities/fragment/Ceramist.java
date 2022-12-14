package com.example.builderpro.activities.fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

import com.example.builderpro.KonfirmasiPembayaran;
import com.example.builderpro.R;
import com.example.builderpro.SettingUser;

public class Ceramist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceramist);
    }

    public void Cer(View view) {
        Intent intent = new Intent(Ceramist.this, KonfirmasiPembayaran.class);
        startActivity(intent);
    }

    public void set(View view) {
        Intent intent = new Intent(Ceramist.this, SettingUser.class);
        startActivity(intent);
    }
}