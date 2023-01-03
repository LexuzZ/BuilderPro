package com.example.builderpro.data.model;

import java.util.Date;

public class Layanan {
    private String id, name;
    private int harga;
    private Tukang tukang;

    public Layanan(String id, String name, int harga) {
        this.id = id;
        this.name = name;

        this.harga = harga;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tukang getTukang() {
        return tukang;
    }

    public void setTukang(Tukang tukang) {
        this.tukang = tukang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Layanan{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", harga=" + harga +
                ", tukang=" + tukang +
                '}';
    }
}
