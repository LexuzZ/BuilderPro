package com.example.builderpro.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.builderpro.data.interfaceDataSource.AuthTukangDataSource;
import com.example.builderpro.data.interfaceDataSource.AuthenticationDataSource;
import com.example.builderpro.data.model.Tukang;
import com.example.builderpro.data.model.User;
import com.example.builderpro.data.model.Worker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class AuthTukangRemoteDataSource  implements AuthTukangDataSource {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    public AuthTukangRemoteDataSource() {
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }

    @Override
    public void register(Worker worker, String password, AuthCallback callback) {
        mAuth.createUserWithEmailAndPassword(worker.email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser != null) {

                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(worker.nama)
                                .build();
                        firebaseUser.updateProfile(request).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                callback.success(true);
                            }
                        });
                    }else{
                        callback.error(new Throwable("Register Gagal"));
                    }
                }else{
                    callback.error(new Throwable(task.getException().getLocalizedMessage()));
                }
            }
        });
    }
    public void getUserByEmail(String email, AuthenticationDataSource.UserCallback callback) {

        db.collection("user").whereEqualTo("email", email).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if (task.isSuccessful()) {

                    Map<String, Object> data = task.getResult().getDocuments().get(0).getData();
                    User user = new User((String) data.get("nama"), null, "", (String) data.get("email"));
                    if (!data.get("type").toString().equals("TUKANG_BIASA")) {
                        user.is_tukang = true;
                    }
                    Log.e("user", user.toString());
                    callback.success(user);
                }
            }
        });
    }
}
