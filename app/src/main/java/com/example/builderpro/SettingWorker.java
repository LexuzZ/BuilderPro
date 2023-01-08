package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.builderpro.data.sign.CreateAccount;
import com.example.builderpro.order.CekOrder;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SettingWorker extends AppCompatActivity {
    private FirebaseUser firebaseUser;
    private ImageButton logout;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_worker);
        logout = findViewById(R.id.btn_logout);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        logout.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), CreateAccount.class));
            finish();
        });

    }

    public void lihat(View view) {
        Intent intent = new Intent(SettingWorker.this, LihatRating.class);
        startActivity(intent);
    }
    
    public void history(View view) {
        Intent intent = new Intent(SettingWorker.this, History.class);
        startActivity(intent);

    }

    public void lonceng(View view) {
        Intent intent = new Intent(SettingWorker.this, CekOrder.class);
        startActivity(intent);
    }
}