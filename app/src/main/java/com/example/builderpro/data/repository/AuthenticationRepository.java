package com.example.builderpro.data.repository;

import androidx.annotation.NonNull;

import com.example.builderpro.data.interfaceDataSource.AuthenticationDataSource;
import com.example.builderpro.data.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class AuthenticationRepository {
    AuthenticationDataSource authenticationRemoteDataSource;
    public AuthenticationRepository(AuthenticationDataSource authenticationRemoteDataSource) {
        this.authenticationRemoteDataSource = authenticationRemoteDataSource;
    }

    public void register(User user, String password, AuthenticationDataSource.AuthenticationCallback callback) {
        this.authenticationRemoteDataSource.register(user, password, new AuthenticationDataSource.AuthenticationCallback() {
            @Override
            public void success(Boolean success) {

                callback.success(success);
            }
            @Override
            public void error(Throwable err) {

                callback.error(err);
            }
        });
    }
    public void getUserByEmail(String email, AuthenticationDataSource.UserCallback callback) {
        this.authenticationRemoteDataSource.getUserByEmail(email, new AuthenticationDataSource.UserCallback() {
            @Override
            public void success(User success) {

                callback.success(success);
            }

            @Override
            public void error(Throwable err) {

                callback.error(err);
            }
        });


    }

}
