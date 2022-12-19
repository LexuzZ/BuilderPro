package com.example.builderpro.data.model;

import java.util.Date;

public class Layanan {
    private String id, name;
    private Date date;
    private int harga;
    private Tukang tukang;

    public Layanan(String id, String name, Date date, int harga, Tukang tukang) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.harga = harga;
        this.tukang = tukang;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
