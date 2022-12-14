package com.example.builderpro.order;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.R;

public class CekOrder2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_order2);
    }
    public void cek3 (View view){
        Intent intent = new Intent(CekOrder2.this, CekOrder3.class);
        startActivity(intent);
    }
}