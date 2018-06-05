package com.keyuni.android.bullet.model;

import java.sql.Time;
import java.util.Date;

public class Pembeli {
    int id_pembeli, id_user, id_usaha,id_produk, jumlah_beli;
    String kode_transaksi;
    Time tanggal_beli;

    public Pembeli() {
    }

    public Pembeli(int id_pembeli, int id_user, int id_usaha, int id_produk, String kode_transaksi, int jumlah_beli, Time tanggal_beli) {
        this.id_pembeli = id_pembeli;
        this.id_user = id_user;
        this.id_usaha = id_usaha;
        this.id_produk = id_produk;
        this.kode_transaksi = kode_transaksi;
        this.tanggal_beli = tanggal_beli;
    }

    public int getId_pembeli() {
        return id_pembeli;
    }

    public void setId_pembeli(int id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_usaha() {
        return id_usaha;
    }

    public void setId_usaha(int id_usaha) {
        this.id_usaha = id_usaha;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public int getJumlah_beli() {
        return jumlah_beli;
    }

    public void setJumlah_beli(int jumlah_beli) {
        this.jumlah_beli = jumlah_beli;
    }

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public Time getTanggal_beli() {
        return tanggal_beli;
    }

    public void setTanggal_beli(Time tanggal_beli) {
        this.tanggal_beli = tanggal_beli;
    }
}
