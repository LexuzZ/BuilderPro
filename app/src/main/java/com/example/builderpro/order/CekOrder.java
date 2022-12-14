package com.example.builderpro.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.R;

public class CekOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_order);
    }
    public  void cek2 (View view ){
        Intent intent = new Intent(CekOrder.this, CekOrder2.class);
        startActivity(intent);
    }
}