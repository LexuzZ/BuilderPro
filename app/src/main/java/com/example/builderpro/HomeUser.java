package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeUser extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private TextView textName;
    private ImageView Setting;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);
        textName = findViewById(R.id.name);
        Setting = findViewById(R.id.setting);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        Setting.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), SettingUser.class));
        });

        if (firebaseUser!=null){
            textName.setText(firebaseUser.getDisplayName());
        }else{
            textName.setText("Login Gagal");
        }


    }
    public void buy(View view){
        Intent intent = new Intent(HomeUser.this, Location.class);
        startActivity(intent);
    }
    public void buyc(View view){
        Intent intent = new Intent(HomeUser.this, Location.class);
        startActivity(intent);
    }
    public void buyr(View view){
        Intent intent = new Intent(HomeUser.this, Location.class);
        startActivity(intent);
    }
    public void buyt (View view){
        Intent intent = new Intent(HomeUser.this, Location.class);
        startActivity(intent);
    }

}

