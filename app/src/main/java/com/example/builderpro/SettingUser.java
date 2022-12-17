package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class SettingUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_user);
    }
    public void out (View view){
        Intent intent = new Intent (SettingUser.this, CreateAccount.class);
        startActivity(intent);
    }
    public void historyy (View view){
        Intent intent = new Intent(SettingUser.this, RiwayatTransaksi.class);
        startActivity(intent);
    }
    public void notif(View view){
        Intent intent = new Intent (SettingUser.this, Pesanan.class);
        startActivity(intent);
    }
}