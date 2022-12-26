package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.builderpro.data.ui.CreateAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingUser extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private ImageButton logout;
    private TextView name;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_user);
        logout = findViewById(R.id.btn_Logout);
        name = findViewById(R.id.namee);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        name.setText(firebaseUser.getDisplayName());

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