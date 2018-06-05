package com.keyuni.android.bullet.model;

import java.util.Date;

public class Komentar {
    int id_komentar, id_user, id_thread;
    String isi_komentar;
    Date tanggal_buat;

    public Komentar() {
    }

    public Komentar(int id_komentar, int id_user, int id_thread, String isi_komentar, Date tanggal_buat) {
        this.id_komentar = id_komentar;
        this.id_thread = id_thread;
        this.id_user = id_user;
        this.isi_komentar = isi_komentar;
        this.tanggal_buat = tanggal_buat;
    }

    public int getId_komentar() {
        return id_komentar;
    }

    public void setId_komentar(int id_komentar) {
        this.id_komentar = id_komentar;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_thread() {
        return id_thread;
    }

    public void setId_thread(int id_thread) {
        this.id_thread = id_thread;
    }

    public String getIsi_komentar() {
        return isi_komentar;
    }

    public void setIsi_komentar(String isi_komentar) {
        this.isi_komentar = isi_komentar;
    }

    public Date getTanggal_buat() {
        return tanggal_buat;
    }

    public void setTanggal_buat(Date tanggal_buat) {
        this.tanggal_buat = tanggal_buat;
    }
}
