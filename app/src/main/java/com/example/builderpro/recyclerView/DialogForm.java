package com.example.builderpro.recyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.builderpro.R;
import com.example.builderpro.data.model.Tukang;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DialogForm extends DialogFragment {
    String nama, harga, action,ahli, rate, loc, key, pilih;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    public DialogForm(String nama, String harga, String loc,String ahli, String rate, String action, String key, String pilih) {
        this.nama = nama;
        this.harga = harga;
        this.loc = loc;
        this.ahli = ahli;
        this.rate = rate;
        this.action = action;
        this.key = key;
        this.pilih = pilih;
    }
    TextView tnama, tharga, tloc,tahli,trate, taction;
    Button simpan;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_tambah, container, false);
        tnama = view.findViewById(R.id.nama);
        tharga = view.findViewById(R.id.harga);
        tloc = view.findViewById(R.id.loc);
        tahli = view.findViewById(R.id.ahli);
        trate = view.findViewById(R.id.rate);
        taction = view.findViewById(R.id.action);
        simpan = view.findViewById(R.id.simpan);

        tnama.setText(nama);
        tharga.setText(harga);
        tloc.setText(loc);
        tahli.setText(ahli);
        trate.setText(rate);
        taction.setText(action);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = tnama.getText().toString();
                String harga = tharga.getText().toString();
                String loc = tloc.getText().toString();
                String ahli = tahli.getText().toString();
                String rate = trate.getText().toString();
                String action = taction.getText().toString();

                if (pilih.equals("Ubah")){
                    database.child("Tukang").child(key).setValue(new Tukang(nama, harga, loc, ahli, rate, action)).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Berhasil Di Update !", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(view.getContext(), "Maaf Gagal Update Data", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null){
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
