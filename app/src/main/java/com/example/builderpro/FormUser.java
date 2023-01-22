package com.example.builderpro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.builderpro.adapter.AdapterProfile;
import com.example.builderpro.data.model.UserBiasa;
import com.example.builderpro.recyclerView.TambahActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FormUser extends AppCompatActivity {
    FloatingActionButton tambah;
    AdapterProfile adapterProfile;
    RecyclerView dataTampil;
    ArrayList<UserBiasa> listCust;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        tambah = findViewById(R.id.btn_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FormUser.this, TambahActivity.class));
            }
        });

        dataTampil = findViewById(R.id.data_customer);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        dataTampil.setLayoutManager(mLayout);
        dataTampil.setItemAnimator(new DefaultItemAnimator());

        tampilData();
    }
    private void tampilData() {
        database.child("Customer").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listCust = new ArrayList<>();
                for(DataSnapshot item : snapshot.getChildren()){
                    UserBiasa tkg = item.getValue(UserBiasa.class);
                    tkg.setKey(item.getKey());
                    listCust.add(tkg);

                }
                adapterProfile = new AdapterProfile(listCust, FormUser.this);
                dataTampil.setAdapter(adapterProfile);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}