package com.example.builderpro.activities.fragment;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.builderpro.Location;
import com.example.builderpro.R;
import com.example.builderpro.SettingUser;

public class Etc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etc);
    }
    public void etc (View view){
        Intent intent = new Intent(Etc.this, Location.class);
        startActivity(intent);
    }
    public void set (View view){
        Intent intent = new Intent (Etc.this, SettingUser.class);
        startActivity(intent);
}
}