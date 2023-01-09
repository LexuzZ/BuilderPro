package com.example.builderpro.data.model;

public class User {
    public String nama;
    public Alamat alamat;
    public String no_hp;
    public String email;
    public boolean is_tukang = false;

    @Override
    public String toString() {
        return "User{" +
                "nama='" + nama + '\'' +
                ", alamat=" + alamat +
                ", no_hp='" + no_hp + '\'' +
                ", email='" + email + '\'' +
                ", is_tukang=" + is_tukang +
                '}';
    }

    public User(String nama, Alamat alamat, String no_hp, String email) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_hp = no_hp;
        this.email = email;
    }
    public User(String nama, Alamat alamat, String no_hp, String email, boolean is_tukang) {
        this.nama = nama;
        this.alamat = alamat;
        this.no_hp = no_hp;
        this.email = email;
        this.is_tukang = is_tukang;
    }
}
