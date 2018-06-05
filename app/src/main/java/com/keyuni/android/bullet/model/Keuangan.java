package com.keyuni.android.bullet.model;

public class Keuangan {
    int id_keuangan, id_user, pengeluaran, pemasukan;

    public Keuangan() {
    }

    public Keuangan(int id_keuangan, int id_user, int pengeluaran, int pemasukan) {
        this.id_keuangan = id_keuangan;
        this.id_user = id_user;
        this.pengeluaran = pengeluaran;
        this.pemasukan = pemasukan;
    }

    public int getId_keuangan() {
        return id_keuangan;
    }

    public void setId_keuangan(int id_keuangan) {
        this.id_keuangan = id_keuangan;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(int pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public int getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(int pemasukan) {
        this.pemasukan = pemasukan;
    }
}
