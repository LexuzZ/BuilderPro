package com.example.builderpro.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.dashboard.HomeUser;
import com.example.builderpro.R;
import com.example.builderpro.Ulasan;

public class CekPesanan3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_pesanan3);
    }

    public void bck(View view) {
        Intent intent = new Intent(CekPesanan3.this, HomeUser.class);
        startActivity(intent);
    }

    public void back(View view) {
        Intent intent = new Intent(CekPesanan3.this, Ulasan.class);
        startActivity(intent);
    }
}