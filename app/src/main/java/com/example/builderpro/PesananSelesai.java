package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.order.CekPesanan;

public class PesananSelesai extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesanan_selesai);
    }
    public void receive(View view){
        Intent intent = new Intent(PesananSelesai.this, CekPesanan.class);
        startActivity(intent);

    }
}