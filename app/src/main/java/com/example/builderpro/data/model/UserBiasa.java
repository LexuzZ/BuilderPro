package com.example.builderpro.data.model;

public class UserBiasa {
    public String username;
    public String alamat;
    public String district;
    public String city;
    public String kodepos;
    public String key;

    public UserBiasa(){

    }

    public UserBiasa(String username, String alamat, String district, String city, String kodepos) {
        this.username = username;
        this.alamat = alamat;
        this.district = district;
        this.city = city;
        this.kodepos = kodepos;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}



