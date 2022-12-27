package com.example.builderpro.activities.fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.builderpro.KonfirmasiPembayaran;
import com.example.builderpro.R;
import com.example.builderpro.SettingUser;
import com.example.builderpro.TambahActivity;
import com.example.builderpro.adapter.AdapterTukang;
import com.example.builderpro.data.interfaceDataSource.LayananDataSource;
import com.example.builderpro.data.model.Tukang;
import com.example.builderpro.data.remote.LayananRemoteDataSource;
import com.example.builderpro.data.repository.LayananRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Painter extends AppCompatActivity {
    private LayananDataSource layananDataSource;
    private LayananRepository layananRepository;
    FloatingActionButton tambah;
    AdapterTukang adapterTukang;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<Tukang> listTukang;
    RecyclerView data_tampil;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painter);



        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Painter.this, TambahActivity.class));
            }
        });

        data_tampil = findViewById(R.id.data_tampil);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        data_tampil.setLayoutManager(mLayout);
        data_tampil.setItemAnimator(new DefaultItemAnimator());

        tampilData();


    }

    private void tampilData() {
        database.child("Tukang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listTukang = new ArrayList<>();
                for(DataSnapshot item : snapshot.getChildren()){
                    Tukang tkg = item.getValue(Tukang.class);
                    tkg.setKey(item.getKey());
                    listTukang.add(tkg);

                }
                adapterTukang = new AdapterTukang(listTukang, Painter.this);
                data_tampil.setAdapter(adapterTukang);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void set (View view){
        Intent intent = new Intent(Painter.this, SettingUser.class);
        startActivity(intent);
    }
    public void paint (View view){
        Intent intent = new Intent (Painter.this, KonfirmasiPembayaran.class);
        startActivity(intent);
    }
}