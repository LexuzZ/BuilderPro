package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;

public class HomeUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);
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
    public void set (View view ){
        Intent intent = new Intent (HomeUser.this, SettingUser.class);
        startActivity(intent);
    }
}

