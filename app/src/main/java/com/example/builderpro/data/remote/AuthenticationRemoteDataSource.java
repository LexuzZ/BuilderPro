package com.example.builderpro.data.remote;

import androidx.annotation.NonNull;
import com.example.builderpro.data.interfaceDataSource.AuthenticationDataSource;
import com.example.builderpro.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class AuthenticationRemoteDataSource implements AuthenticationDataSource {
    private FirebaseAuth mAuth;
    public AuthenticationRemoteDataSource() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void register(User user, String password, AuthenticationCallback callback) {
        mAuth.createUserWithEmailAndPassword(user.email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser = task.getResult().getUser();
                    if (firebaseUser != null) {

                        UserProfileChangeRequest request = new UserProfileChangeRequest.Builder()
                                .setDisplayName(user.nama)
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

    @Override
    public void registerW(String email, String password, AuthenticationCallback callback) {

    }
}

