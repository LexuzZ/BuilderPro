package com.example.builderpro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.builderpro.data.model.UserBiasa;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahUser extends AppCompatActivity {
    EditText name, address, district, city, postal;
    Button save;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_user);
        name = findViewById(R.id.nama);
        address = findViewById(R.id.harga);
        district = findViewById(R.id.loc);
        city = findViewById(R.id.ahli);
        postal = findViewById(R.id.rate);
        save = findViewById(R.id.simpan);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUsername = name.getText().toString();
                String getAlamat = address.getText().toString();
                String getDistrict = district.getText().toString();
                String getCity = city.getText().toString();
                String getKodepos = postal.getText().toString();


                if(getUsername.isEmpty()){
                    name.setError("Name...");
                }else if(getAlamat.isEmpty()) {
                    address.setError("Address..");
                }else if(getDistrict.isEmpty()) {
                    district.setError("District...");
                }else if(getCity.isEmpty()) {
                    city.setError("City...");
                }else if(getKodepos.isEmpty()){
                    postal.setError("Postal ...");
                }else{
                    database.child("Customers").push().setValue(new UserBiasa(getUsername, getAlamat, getDistrict, getCity, getKodepos)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(TambahUser.this, "Data Berhasil Disimpan" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(TambahUser.this, FormUser.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TambahUser.this, "Gagal Menyimpan Data" , Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}