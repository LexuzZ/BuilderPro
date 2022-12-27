package com.example.builderpro.order;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.builderpro.R;

public class CekOrder extends AppCompatActivity {
    ImageView view1, view2, view3;
    SeekBar seekBar;

    @SuppressLint("MissingInflatedId")
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