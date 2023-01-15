package com.example.builderpro.data.repository;

import com.example.builderpro.data.interfaceDataSource.AuthenticationDataSource;
import com.example.builderpro.data.model.User;

public class AuthenticationRepository {
    AuthenticationDataSource authenticationRemoteDataSource;
    AuthenticationDataSource authRemoteDataSource;
    public AuthenticationRepository(AuthenticationDataSource authenticationRemoteDataSource) {
        this.authenticationRemoteDataSource = authenticationRemoteDataSource;
    }

    public void register(User user, String password, AuthenticationDataSource.AuthenticationCallback callback) {
        this.authenticationRemoteDataSource.register(user, password, "USER_BIASA", new AuthenticationDataSource.AuthenticationCallback() {
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
    public void registerTukang(User user, String password, AuthenticationDataSource.AuthenticationCallback callback) {
        this.authenticationRemoteDataSource.register(user, password, "USER_TUKANG", new AuthenticationDataSource.AuthenticationCallback() {
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
