package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.builderpro.order.CekOrder;

public class HomeOrder extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4, tv5, tv6;
    Button order;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_order);

        tv1 = findViewById(R.id.tv_tukang);
        tv2 = findViewById(R.id.tv_harga);
        tv3 = findViewById(R.id.tv_loc);
        tv4 = findViewById(R.id.tv_ahli);
        tv5 = findViewById(R.id.tv_rate);
        tv6 = findViewById(R.id.tv_action);
        order = findViewById(R.id.btn_order);

        order.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), KonfirmasiPembayaran.class));
        });

        Intent intent = getIntent();
        String nama = intent.getExtras().getString("Tukang");
        String harga = intent.getExtras().getString("Harga");
        String loc = intent.getExtras().getString("Lokasi");
        String ahli = intent.getExtras().getString("Keahlian");
        String rate = intent.getExtras().getString("Rate");
        String action = intent.getExtras().getString("Action");

        tv1.setText(nama);
        tv2.setText(harga);
        tv3.setText(loc);
        tv4.setText(ahli);
        tv5.setText(rate);
        tv6.setText(action);

    }

    public void order(View view) {
        Intent intent = new Intent(HomeOrder.this, CekOrder.class);
        startActivity(intent);
    }
}