package com.example.builderpro.data.interfaceDataSource;

import com.example.builderpro.data.model.Tukang;
import com.example.builderpro.data.model.Worker;

public interface AuthTukangDataSource {
    public void register(Worker worker, String password, AuthCallback callback);

    public interface AuthCallback {
        public void success(Boolean success);

        public void error(Throwable err);
    }
    public interface WorkCallback{
        public void success (Boolean success);
        public void error(Throwable err);
    }
}
