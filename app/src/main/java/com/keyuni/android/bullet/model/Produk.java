package com.keyuni.android.bullet.model;

public class Produk {
    int id_produk, id_acc, harga, stok;
    String nama_produk, deskripsi_produk, kategori;

    public Produk() {
    }

    public Produk(int harga, int stok, String nama_produk, String deskripsi_produk, String kategori) {
        this.harga = harga;
        this.stok = stok;
        this.nama_produk = nama_produk;
        this.deskripsi_produk = deskripsi_produk;
        this.kategori = kategori;
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public int getId_acc() {
        return id_acc;
    }

    public void setId_acc(int id_acc) {
        this.id_acc = id_acc;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getDeskripsi_produk() {
        return deskripsi_produk;
    }

    public void setDeskripsi_produk(String deskripsi_produk) {
        this.deskripsi_produk = deskripsi_produk;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
