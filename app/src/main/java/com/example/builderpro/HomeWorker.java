package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.example.builderpro.order.CekOrder;

public class HomeWorker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_worker);

        Switch simpleSwitch = (Switch) findViewById(R.id.simpleSwitch);

        simpleSwitch.setTextOn("On");
        simpleSwitch.setTextOff("Off");
    }
    public void cek (View view){
        Intent intent = new Intent(HomeWorker.this, CekOrder.class);
        startActivity(intent);
    }
    public void sett (View view){
        Intent intent = new Intent(HomeWorker.this, SettingWorker.class);
        startActivity(intent);
    }




}