package com.keyuni.android.bullet.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Thread {
    int id_thread, id_user;
    String judul_thread, kategori_thread, deskripsi_thread, stringdate;
    Date tanggal_buat;

    public Thread() {
    }

    public Thread(int id_thread, int id_user, String judul_thread, String kategori_thread, String deskripsi_thread, Date tanggal_buat) {
        this.id_thread = id_thread;
        this.id_user = id_user;
        this.judul_thread = judul_thread;
        this.kategori_thread = kategori_thread;
        this.deskripsi_thread = deskripsi_thread;
        this.tanggal_buat = tanggal_buat;
    }

    /*private String getDateTime() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
        Date tanggal_buat = dateformat.parse(stringdate);
        return dateformat.format(tanggal_buat);
    }*/

    public int getId_thread() {
        return id_thread;
    }

    public void setId_thread(int id_thread) {
        this.id_thread = id_thread;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getJudul_thread() {
        return judul_thread;
    }

    public void setJudul_thread(String judul_thread) {
        this.judul_thread = judul_thread;
    }

    public String getKategori_thread() {
        return kategori_thread;
    }

    public void setKategori_thread(String kategori_thread) {
        this.kategori_thread = kategori_thread;
    }

    public String getDeskripsi_thread() {
        return deskripsi_thread;
    }

    public void setDeskripsi_thread(String deskripsi_thread) {
        this.deskripsi_thread = deskripsi_thread;
    }

    public Date getTanggal_buat() {
        return tanggal_buat;
    }

    public void setTanggal_buat(Date tanggal_buat) {
        this.tanggal_buat = tanggal_buat;
    }
}
