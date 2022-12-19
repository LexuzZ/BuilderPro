package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.builderpro.data.ui.CreateAccount;
import com.google.firebase.auth.FirebaseAuth;

public class SettingUser extends AppCompatActivity {
    private Button logout;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_user);
        logout = findViewById(R.id.btn_Logout);

        logout.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), CreateAccount.class));
            finish();
        });
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