package com.example.builderpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.builderpro.dashboard.HomeUser;

public class Ulasan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasan);
    }

    public void user(View view) {
        Intent intent = new Intent(Ulasan.this, HomeUser.class);
        startActivity(intent);
    }

    public void showMessage(View view) {
        String myString = "Pesan Ulasan Terkirim";
        Toast toast = Toast.makeText(getApplicationContext(), myString, Toast.LENGTH_LONG);
        toast.show();
    }
}