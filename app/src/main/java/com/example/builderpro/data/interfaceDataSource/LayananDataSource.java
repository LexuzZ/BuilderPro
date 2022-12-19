package com.example.builderpro.data.interfaceDataSource;

import com.example.builderpro.data.model.Layanan;

import java.util.ArrayList;

public interface LayananDataSource {
    public void getLayanan(GetLayananCallback callback);
    public void addLayanan(Layanan layanan, AddLayananCallback callback);

    public interface GetLayananCallback {
        public void success(ArrayList<Layanan> layanan);
        public void error(Throwable err);
    }

    public interface AddLayananCallback {
        public void success(boolean success);
        public void error(Throwable err);
    }
}
