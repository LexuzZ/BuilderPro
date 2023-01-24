package com.example.builderpro;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.builderpro.adapter.AdapterPesanan;
import com.example.builderpro.data.model.UserBiasa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LihatPesanan extends AppCompatActivity {
    AdapterPesanan adapterPesanan;
    RecyclerView data_Tampil;
    ArrayList<UserBiasa> listCustomer;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pesanan);
        data_Tampil = findViewById(R.id.data_pesanan);


        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        data_Tampil.setLayoutManager(mLayout);
        data_Tampil.setItemAnimator(new DefaultItemAnimator());


        tampilData();
    }
    private void tampilData() {
        database.child("Customers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listCustomer = new ArrayList<>();
                for(DataSnapshot item : snapshot.getChildren()){
                    UserBiasa ub = item.getValue(UserBiasa.class);
                    ub.setKey(item.getKey());
                    listCustomer.add(ub);

                }
                adapterPesanan = new AdapterPesanan(listCustomer, LihatPesanan.this);
                data_Tampil.setAdapter(adapterPesanan);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}