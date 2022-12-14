package com.example.builderpro.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.HomeWorker;
import com.example.builderpro.R;

public class CekOrder3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_order3);
    }
    public void backk(View view){
        Intent intent = new Intent (CekOrder3.this, HomeWorker.class);
        startActivity(intent);
    }
}