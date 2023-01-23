package com.example.builderpro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.builderpro.adapter.AdapterProfile;
import com.example.builderpro.data.model.UserBiasa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryOrder extends AppCompatActivity {
    AdapterProfile adapterProfile;
    RecyclerView dataTampil;
    ArrayList<UserBiasa> listCust;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    Button btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_order);
        dataTampil = findViewById(R.id.data_customer);

        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        dataTampil.setLayoutManager(mLayout);
        dataTampil.setItemAnimator(new DefaultItemAnimator());


        tampilData();
    }
    private void tampilData() {
        database.child("Customers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listCust = new ArrayList<>();
                for(DataSnapshot item : snapshot.getChildren()){
                    UserBiasa ub = item.getValue(UserBiasa.class);
                    ub.setKey(item.getKey());
                    listCust.add(ub);

                }
                adapterProfile = new AdapterProfile(listCust, HistoryOrder.this);
                dataTampil.setAdapter(adapterProfile);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}