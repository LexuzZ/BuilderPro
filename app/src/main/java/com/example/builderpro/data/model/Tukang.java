package com.example.builderpro.data.model;

import java.util.Date;

public class Tukang {
    private String nama;
    private String harga;
    private String action;
    private String ahli;
    private String rate;
    private String loc;
    private String key;

    public Tukang(){

    }

    public Tukang(String nama, String harga, String loc,String ahli, String rate, String action) {
        this.nama = nama;
        this.harga = harga;
        this.action = action;
        this.ahli = ahli;
        this.rate = rate;
        this.loc = loc;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAhli() {
        return ahli;
    }

    public void setAhli(String ahli) {
        this.ahli = ahli;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
