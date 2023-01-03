package com.example.builderpro.data.remote;

import androidx.annotation.NonNull;

import com.example.builderpro.data.interfaceDataSource.LayananDataSource;
import com.example.builderpro.data.model.Layanan;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public class LayananRemoteDataSource implements LayananDataSource {
    private final FirebaseFirestore db;

    public LayananRemoteDataSource(){
        db = FirebaseFirestore.getInstance();
    }
    @Override
    public void getLayanan(GetLayananCallback callback) {
        db.collection("Layanan").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    ArrayList<Layanan> all_layanan = new ArrayList<>();
                    for (QueryDocumentSnapshot document : task.getResult()){
                        Map<String, Object> data = document.getData();
                        document.getData().get("nama");
                        Layanan per_layanan = new Layanan(document.getId(), String.valueOf(document.getData().get("nama")),((Long) Objects.requireNonNull(data.get("harga"))).intValue());
                        all_layanan.add(per_layanan);
                    }
                    callback.success(all_layanan);
                }
            }
        });

    }

    @Override
    public void addLayanan(Layanan layanan, AddLayananCallback callback) {


    }
}
