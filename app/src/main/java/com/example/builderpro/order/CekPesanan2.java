package com.example.builderpro.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.order.CekPesanan3;
import com.example.builderpro.R;

public class CekPesanan2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_pesanan2);
    }

    public void proced(View view) {
        Intent intent = new Intent(CekPesanan2.this, CekPesanan3.class);
        startActivity(intent);
    }
}