package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.recyclerView.Painter;
import com.example.builderpro.order.CekOrder;

public class HomeWorker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_worker);


    }
    public void cek (View view){
        Intent intent = new Intent(HomeWorker.this, CekOrder.class);
        startActivity(intent);
    }
    public void sett (View view){
        Intent intent = new Intent(HomeWorker.this, SettingWorker.class);
        startActivity(intent);
    }
    public void recyc (View view){
        Intent intent = new Intent(HomeWorker.this, Painter.class);
        startActivity(intent);
    }




}