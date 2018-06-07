package com.keyuni.android.bullet.Helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper{
    //kalau ada upgrage, increment versi database
    public static final int DATABASE_VERSION = 1 ;
    public static final String DATABASE_NAME = "dbBullet.db" ;

    //Membuat tabel user
    public static final String TABLE_CREATE_USER =
            "CREATE TABLE USER (_ID INTEGER PRIMARY KEY AUTOINCREMENT, KOIN INTEGER, NAMA TEXT, " +
                    "EMAIL TEXT, NO_HP TEXT, ALAMAT TEXT, KATASANDI TEXT, KONFIRMASI_SANDI TEXT)" ;

    public static final String TABLE_CREATE_PRODUK =
            "CREATE TABLE PRODUK (_ID_PRODUK INTEGER PRIMARY KEY AUTOINCREMENT, ID_ACC  INTEGER, HARGA  INTEGER, " +
                    "STOK INTEGER, NAMA_PRODUK TEXT, DESKRIPSI_PRODUK TEXT, KATEGORI TEXT)" ;

    public static final String TABLE_CREATE_USAHA =
            "CREATE TABLE USAHA (_ID_USAHA INTEGER PRIMARY KEY AUTOINCREMENT, ID_USER INTEGER, NAMA_USAHA TEXT, " +
                    "EMAIL_USAHA TEXT, NOHP_USAHA TEXT, JENIS_USAHA TEXT, ALAMAT_USAHA TEXT)" ;

    public static final String TABLE_CREATE_THREAD =
            "CREATE TABLE THREAD (_ID_THREAD INTEGER PRIMARY KEY AUTOINCREMENT, ID_USER INTEGER, JUDUL_THREAD TEXT," +
                    "KATEGORI_THREAD TEXT, DESKRIPSI_THREAD TEXT, TANGGAL_BUAT DATE)";

    public static final String TABLE_CREATE_KOMENTAR =
            "CREATE TABLE KOMENTAR (_ID_KOMENTAR INTEGER PRIMARY KEY AUTOINCREMENT, ID_USER INTEGER, ID_THREAD INTEGER, " +
                    "ISI_KOMENTAR TEXT, TANGGAL_BUAT DATE)" ;

    public static final String TABLE_CREATE_PEMBELI =
            "CREATE TABLE PEMBELI (_ID_PEMBELI INTEGER PRIMARY KEY AUTOINCREMENT, ID_USER INTEGER, ID_USAHA INTEGER, " +
                    "ID_PRODUK INTEGER, KODE_TRANSAKSI TEXT, JUMLAH_BELI INTEGER, TANGGAL_BELI DATET)" ;

    public static final String TABLE_CREATE_PEMINJAMAN  =
            "CREATE TABLE PEMINJAMAN (_ID_PINJAM INTEGER PRIMARY KEY AUTOINCREMENT, ID_USER INTEGER, JUMLAH_PINJAM INTEGER, " +
                    "DURASI_PINJAM INTEGER, TANGGAL_PINJAM DATE, KODE_BAYAR TEXT, STATUS TEXT)" ;

    public static final String TABLE_CREATE_KEUANGAN =
            "CREATE TABLE KEUANGAN (_ID_KEUANGAN INTEGER PRIMARY KEY AUTOINCREMENT, ID_USER INTEGER, PENGELUARAN INTEGER, " +
                    "PEMASUKAN INTEGER)" ;

    public OpenHelper(Context context) {
        super (context, DATABASE_NAME , null , DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    //create database
        db.execSQL( TABLE_CREATE_USER );
        db.execSQL( TABLE_CREATE_PRODUK );
        db.execSQL( TABLE_CREATE_USAHA );
        db.execSQL( TABLE_CREATE_THREAD);
        db.execSQL( TABLE_CREATE_KOMENTAR);
        db.execSQL( TABLE_CREATE_PEMBELI);
        db.execSQL( TABLE_CREATE_PEMINJAMAN);
        db.execSQL( TABLE_CREATE_KEUANGAN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //jika app diupgrade (diinstall yang baru) maka database akan dicreate ulang (data hilang)
    //jika tidak tidak ingin hilang, bisa diproses disini
        db.execSQL( "DROP TABLE IF EXISTS USER" );
        db.execSQL( "DROP TABLE IF EXISTS PRODUK" );
        db.execSQL( "DROP TABLE IF EXISTS USAHA" );
        db.execSQL( "DROP TABLE IF EXISTS KEUANGAN" );
        db.execSQL( "DROP TABLE IF EXISTS PEMBELI" );
        db.execSQL( "DROP TABLE IF EXISTS PEMINJAMAN" );
        db.execSQL( "DROP TABLE IF EXISTS THREAD" );
        db.execSQL( "DROP TABLE IF EXISTS KOMENTAR" );
    }
}
