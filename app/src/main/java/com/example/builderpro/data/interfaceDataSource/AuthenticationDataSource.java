package com.example.builderpro.data.interfaceDataSource;

import com.example.builderpro.data.model.User;

public interface AuthenticationDataSource {
    public void register(User user, String password, String type, AuthenticationCallback callback);

    void getUserByEmail(String email, UserCallback userCallback);

    public interface AuthenticationCallback {
        public void success(Boolean success);
        public void error(Throwable err);
    }
    public interface UserCallback{
        public void success (User success);
        public void error(Throwable err);
    }
}
