package com.example.builderpro.recyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.builderpro.R;
import com.example.builderpro.SettingUser;
import com.example.builderpro.adapter.AdapterUser;
import com.example.builderpro.dashboard.HomeUser;
import com.example.builderpro.data.model.Tukang;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PaintList extends AppCompatActivity {
    AdapterUser adapterUser;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<Tukang> listTukang;
    RecyclerView data_tampil;
    ImageButton btn_menu, btn_setting, btn_home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_list);
        btn_menu = findViewById(R.id.menu_button);
        btn_setting = findViewById(R.id.settings_button);
        btn_home = findViewById(R.id.home_button);
        data_tampil = findViewById(R.id.data_tampil);
        RecyclerView.LayoutManager mLayout = new LinearLayoutManager(this);
        data_tampil.setLayoutManager(mLayout);
        data_tampil.setItemAnimator(new DefaultItemAnimator());

        btn_home.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), HomeUser.class));
        });

        btn_setting.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), SettingUser.class));
        });

        btn_menu.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), SettingUser.class));
        });

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
                adapterUser = new AdapterUser(listTukang, PaintList.this );
                data_tampil.setAdapter(adapterUser);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}