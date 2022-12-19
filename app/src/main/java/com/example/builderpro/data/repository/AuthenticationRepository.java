package com.example.builderpro.data.repository;

import com.example.builderpro.data.interfaceDataSource.AuthenticationDataSource;
import com.example.builderpro.data.model.User;

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

}
