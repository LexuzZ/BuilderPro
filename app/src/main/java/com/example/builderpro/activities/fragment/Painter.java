package com.example.builderpro.activities.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.KonfirmasiPembayaran;
import com.example.builderpro.R;
import com.example.builderpro.SettingUser;
import com.example.builderpro.TambahActivity;
import com.example.builderpro.data.interfaceDataSource.LayananDataSource;
import com.example.builderpro.data.remote.LayananRemoteDataSource;
import com.example.builderpro.data.repository.LayananRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Painter extends AppCompatActivity {
    private LayananDataSource layananDataSource;
    private LayananRepository layananRepository;
    FloatingActionButton tambah;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter);

        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Painter.this, TambahActivity.class));
            }
        });



        this.layananDataSource = new LayananRemoteDataSource();

    }
    public void set (View view){
        Intent intent = new Intent(Painter.this, SettingUser.class);
        startActivity(intent);
    }
    public void paint (View view){
        Intent intent = new Intent (Painter.this, KonfirmasiPembayaran.class);
        startActivity(intent);
    }
}