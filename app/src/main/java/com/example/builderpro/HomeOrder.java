package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.order.CekOrder;

public class HomeOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_order);
    }
    public void order(View view){
        Intent intent = new Intent(HomeOrder.this, CekOrder.class);
        startActivity(intent);
    }
}