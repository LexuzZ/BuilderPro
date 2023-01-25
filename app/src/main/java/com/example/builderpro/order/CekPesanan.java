package com.example.builderpro.order;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.builderpro.R;

public class CekPesanan extends AppCompatActivity {
    TextView name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_pesanan);
        name = findViewById(R.id.tv_cust);
//
//        Intent intent = getIntent();
//        String username = intent.getExtras().getString("Customers");
//        name.setText("Customer " + username);
    }
    public void proced (View view){
        Intent intent = new Intent(CekPesanan.this, CekPesanan2.class);
        startActivity(intent);
    }
}