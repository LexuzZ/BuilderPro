package com.example.builderpro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.builderpro.dashboard.HomeUser;
import com.example.builderpro.recyclerView.PaintList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Location extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private TextView textName;
    private ImageButton Setting, home;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        textName = findViewById(R.id.name);
        Setting = findViewById(R.id.setting);
        home = findViewById(R.id.home_button);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        home.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), HomeUser.class));
        });

        Setting.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), SettingUser.class));
        });

        if (firebaseUser!=null){
            textName.setText(firebaseUser.getDisplayName());
        }else{
            textName.setText("Login Gagal");
        }
    }

    public void loc(View view) {
        Intent intent = new Intent(Location.this, PaintList.class);
        startActivity(intent);
    }


    public void set(View view) {
        Intent intent = new Intent(Location.this, SettingUser.class);
        startActivity(intent);
    }
}