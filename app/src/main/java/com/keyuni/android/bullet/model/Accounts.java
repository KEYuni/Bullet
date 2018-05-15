package com.keyuni.android.bullet.model;

public class Accounts {
    private int id, koin;
    private String nama, email, no_hp, alamat, kata_sandi, konfirmasi_sandi;

    public Accounts() {
    }

    public Accounts(int koin, String nama, String email, String no_hp, String alamat, String kata_sandi, String konfirmasi_sandi) {
        this.koin = koin;
        this.nama = nama;
        this.email = email;
        this.no_hp = no_hp;
        this.alamat = alamat;
        this.kata_sandi = kata_sandi;
        this.konfirmasi_sandi = konfirmasi_sandi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKoin() {
        return koin;
    }

    public void setKoin(int koin) {
        this.koin = koin;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKata_sandi() {
        return kata_sandi;
    }

    public void setKata_sandi(String kata_sandi) {
        this.kata_sandi = kata_sandi;
    }

    public String getKonfirmasi_sandi() {
        return konfirmasi_sandi;
    }

    public void setKonfirmasi_sandi(String konfirmasi_sandi) {
        this.konfirmasi_sandi = konfirmasi_sandi;
    }
}
