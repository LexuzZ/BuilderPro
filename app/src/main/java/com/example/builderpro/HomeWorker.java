package com.example.builderpro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.builderpro.recyclerView.Painter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeWorker extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private TextView textName;
    private ImageButton btnOrder;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_worker);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        textName = findViewById(R.id.name);
        btnOrder = findViewById(R.id.imagehome);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HistoryOrder.class));
            }
        });

        if (firebaseUser!=null){
            textName.setText(firebaseUser.getDisplayName());
        }else{
            textName.setText("Login Gagal");
        }




    }
    public void sett (View view){
        Intent intent = new Intent(HomeWorker.this, SettingWorker.class);
        startActivity(intent);
    }
    public void recyc (View view){
        Intent intent = new Intent(HomeWorker.this, Painter.class);
        startActivity(intent);
    }




}