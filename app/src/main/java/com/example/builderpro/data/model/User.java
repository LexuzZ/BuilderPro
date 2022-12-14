package com.example.builderpro.data.model;

public class User {
    public String nama;
    public Alamat alamat;
    public String no_hp;
    public String email;

    public User(String nama, Alamat alamat, String no_hp, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_hp = no_hp;
        this.email = email;
    }
}
