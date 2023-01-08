package com.example.builderpro.data.repository;

import com.example.builderpro.data.interfaceDataSource.AuthTukangDataSource;
import com.example.builderpro.data.interfaceDataSource.AuthenticationDataSource;
import com.example.builderpro.data.model.User;
import com.example.builderpro.data.model.Worker;

public class AuthTukangRepository {
    AuthTukangDataSource authenticationRemoteDataSource;

    public AuthTukangRepository(AuthTukangDataSource authenticationRemoteDataSource) {
        this.authenticationRemoteDataSource = authenticationRemoteDataSource;
    }

    public void register(Worker worker, String password, AuthTukangDataSource.AuthCallback callback) {
        this.authenticationRemoteDataSource.register(worker, password, new AuthTukangDataSource.AuthCallback() {
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
