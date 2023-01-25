package com.example.builderpro.order;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.builderpro.R;

public class CekOrder2 extends AppCompatActivity {
    TextView name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_order2);
        name = findViewById(R.id.tv_cust);




    }
    public void cek3 (View view){
        Intent intent = new Intent(CekOrder2.this, CekOrder3.class);
        startActivity(intent);
    }
}