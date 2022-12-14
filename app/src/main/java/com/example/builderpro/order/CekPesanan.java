package com.example.builderpro.order;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.builderpro.R;

public class CekPesanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_pesanan);
    }
    public void proced (View view){
        Intent intent = new Intent(CekPesanan.this, CekPesanan2.class);
        startActivity(intent);
    }
}