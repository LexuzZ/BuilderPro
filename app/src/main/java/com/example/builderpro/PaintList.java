package com.example.builderpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.builderpro.activities.fragment.Painter;
import com.example.builderpro.adapter.AdapterTukang;
import com.example.builderpro.data.model.Tukang;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PaintList extends AppCompatActivity {
    AdapterTukang adapterTukang;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<Tukang> listTukang;
    RecyclerView data_tampil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_list);
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
                adapterTukang = new AdapterTukang(listTukang, PaintList.this);
                data_tampil.setAdapter(adapterTukang);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}