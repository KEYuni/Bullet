package com.keyuni.android.bullet.model;

public class Usaha {
    int id_usaha, id_user;
    String nama_usaha, email_usaha, nohp_usaha, jenis_usaha, alamat_usaha;

    public Usaha() {
    }

    public Usaha(int id_usaha, int id_user, String nama_usaha, String email_usaha, String nohp_usaha, String jenis_usaha, String alamat_usaha) {
        this.id_usaha = id_usaha;
        this.id_user = id_user;
        this.nama_usaha = nama_usaha;
        this.email_usaha = email_usaha;
        this.nohp_usaha = nohp_usaha;
        this.jenis_usaha = jenis_usaha;
        this.alamat_usaha = alamat_usaha;
    }

    public int getId_usaha() {
        return id_usaha;
    }

    public void setId_usaha(int id_usaha) {
        this.id_usaha = id_usaha;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNama_usaha() {
        return nama_usaha;
    }

    public void setNama_usaha(String nama_usaha) {
        this.nama_usaha = nama_usaha;
    }

    public String getEmail_usaha() {
        return email_usaha;
    }

    public void setEmail_usaha(String email_usaha) {
        this.email_usaha = email_usaha;
    }

    public String getNohp_usaha() {
        return nohp_usaha;
    }

    public void setNohp_usaha(String nohp_usaha) {
        this.nohp_usaha = nohp_usaha;
    }

    public String getJenis_usaha() {
        return jenis_usaha;
    }

    public void setJenis_usaha(String jenis_usaha) {
        this.jenis_usaha = jenis_usaha;
    }

    public String getAlamat_usaha() {
        return alamat_usaha;
    }

    public void setAlamat_usaha(String alamat_usaha) {
        this.alamat_usaha = alamat_usaha;
    }
}
