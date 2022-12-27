package com.example.builderpro.data.interfaceDataSource;

import com.example.builderpro.data.model.User;

public interface AuthenticationDataSource {
    public void register(User user, String password, AuthenticationCallback callback);
    public void registerW(String email, String password, AuthenticationCallback callback);

    public interface AuthenticationCallback {
        public void success(Boolean success);
        public void error(Throwable err);




    }
}
