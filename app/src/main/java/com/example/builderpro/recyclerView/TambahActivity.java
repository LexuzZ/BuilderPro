package com.example.builderpro.recyclerView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.builderpro.R;
import com.example.builderpro.data.model.Tukang;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TambahActivity extends AppCompatActivity {
    EditText idnama, idharga, iddate,idahli,idrate, idaction;
    Button save;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        idnama = findViewById(R.id.nama);
        idharga = findViewById(R.id.harga);
        iddate = findViewById(R.id.loc);
        idahli = findViewById(R.id.ahli);
        idrate = findViewById(R.id.rate);
        idaction = findViewById(R.id.action);
        save = findViewById(R.id.simpan);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getNama = idnama.getText().toString();
                String getHarga = idharga.getText().toString();
                String getLoc = iddate.getText().toString();
                String getAhli = idahli.getText().toString();
                String getRate = idrate.getText().toString();
                String getAction = idaction.getText().toString();

                if(getNama.isEmpty()){
                    idnama.setError("Masukkan Nama...");
                }else if(getHarga.isEmpty()) {
                    idharga.setError("Masukkan Harga..");
                }else if(getLoc.isEmpty()) {
                    iddate.setError("Masukkan Kecamatan...");
                }else if(getAhli.isEmpty()) {
                    idahli.setError("Masukkan Keahlian...");
                }else if(getRate.isEmpty()){
                    idrate.setError("Masukkan Rating");
                }else if(getAction.isEmpty()){
                    idaction.setError("Masukkan Action...");
                }else{
                    database.child("Tukang").push().setValue(new Tukang(getNama, getHarga, getLoc,getAhli,getRate, getAction)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(TambahActivity.this, "Data Berhasil Disimpan" , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(TambahActivity.this, Painter.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(TambahActivity.this, "Gagal Menyimpan Data" , Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }
}