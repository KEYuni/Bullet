package com.keyuni.android.bullet.model;

import java.sql.Time;
import java.util.Date;

public class Peminjaman {
    int id_pinjam, id_user, durasi_pinjam, jumlah_pinjam;
    String status, kode_bayar;
    Time tanggal_pinjam;

    public Peminjaman() {
    }

    public Peminjaman(int id_pinjam, int id_user, int durasi_pinjam, int jumlah_pinjam, String status, String kode_bayar) {
        this.id_pinjam = id_pinjam;
        this.id_user = id_user;
        this.durasi_pinjam = durasi_pinjam;
        this.jumlah_pinjam = jumlah_pinjam;
        this.status = status;
        this.kode_bayar = kode_bayar;
    }

    public int getId_pinjam() {
        return id_pinjam;
    }

    public void setId_pinjam(int id_pinjam) {
        this.id_pinjam = id_pinjam;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getDurasi_pinjam() {
        return durasi_pinjam;
    }

    public void setDurasi_pinjam(int durasi_pinjam) {
        this.durasi_pinjam = durasi_pinjam;
    }

    public int getJumlah_pinjam() {
        return jumlah_pinjam;
    }

    public void setJumlah_pinjam(int jumlah_pinjam) {
        this.jumlah_pinjam = jumlah_pinjam;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKode_bayar() {
        return kode_bayar;
    }

    public void setKode_bayar(String kode_bayar) {
        this.kode_bayar = kode_bayar;
    }

    public Time getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public void setTanggal_pinjam(Time tanggal_pinjam) {
        this.tanggal_pinjam = tanggal_pinjam;
    }
}
