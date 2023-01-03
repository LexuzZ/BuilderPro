package com.example.builderpro.activities.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;

import com.example.builderpro.KonfirmasiPembayaran;
import com.example.builderpro.R;
import com.example.builderpro.SettingUser;
import com.example.builderpro.adapter.AdapterTukang;
import com.example.builderpro.adapter.LayananAdapter;
import com.example.builderpro.data.interfaceDataSource.LayananDataSource;
import com.example.builderpro.data.remote.LayananRemoteDataSource;
import com.example.builderpro.data.repository.LayananRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RoofTile extends AppCompatActivity {
    private LayananDataSource layananRemoteDataSource;
    private LayananRepository layananRepository;
    private LayananAdapter layananAdapter;
    private FloatingActionButton btn;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roof_tile);



        this.layananRemoteDataSource = new LayananRemoteDataSource();
        this.layananRepository = new LayananRepository(layananRemoteDataSource);
    }

    private void setDataToRecycleView() {
    }

}