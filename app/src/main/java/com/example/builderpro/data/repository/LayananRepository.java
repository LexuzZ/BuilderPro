package com.example.builderpro.data.repository;

import com.example.builderpro.data.interfaceDataSource.LayananDataSource;
import com.example.builderpro.data.model.Layanan;

import java.util.ArrayList;

public class LayananRepository {
    private LayananDataSource layananRemoteDataSource;
    private LayananDataSource layananLocalDataSource;

    public LayananRepository(LayananDataSource layananRemoteDataSource) {
      //  this.layananLocalDataSource = layananLocalDataSource;
        this.layananRemoteDataSource = layananRemoteDataSource;

    }
    public void getLayanan(LayananDataSource.GetLayananCallback callback){
        this.layananRemoteDataSource.getLayanan(new LayananDataSource.GetLayananCallback() {
            @Override
            public void success(ArrayList<Layanan> layanan) {
                callback.success(layanan);

            }

            @Override
            public void error(Throwable err) {

            }
        });
    }
}
