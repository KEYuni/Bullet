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
            "CREATE TABLE USER (ID INTEGER PRIMARY KEY AUTOINCREMENT, KOIN INTEGER, NAMA TEXT, " +
                    "EMAIL TEXT, NO_HP TEXT, ALAMAT TEXT, KATASANDI TEXT, KONFIRMASI_SANDI TEXT)" ;

    public static final String TABLE_CREATE_PRODUK =
            "CREATE TABLE PRODUK (ID_PRODUK INTEGER PRIMARY KEY AUTOINCREMENT, ID_ACC  INTEGER, HARGA  INTEGER, " +
                    "STOK INTEGER, NAMA_PRODUK TEXT, DESKRIPSI_PRODUK TEXT, KATEGORI TEXT)" ;

    public static final String TABLE_CREATE_USAHA =
            "CREATE TABLE USAHA (ID_USAHA INTEGER PRIMARY KEY AUTOINCREMENT, ID_USER INTEGER, NAMA_USAHA TEXT, " +
                    "EMAIL_USAHA TEXT, NOHP_USAHA TEXT, JENIS_USAHA TEXT, ALAMAT_USAHA TEXT)" ;

    public OpenHelper(Context context) {
        super (context, DATABASE_NAME , null , DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    //create database
        db.execSQL( TABLE_CREATE_USER );
        db.execSQL( TABLE_CREATE_PRODUK );
        db.execSQL( TABLE_CREATE_USAHA );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //jika app diupgrade (diinstall yang baru) maka database akan dicreate ulang (data hilang)
    //jika tidak tidak ingin hilang, bisa diproses disini
        db.execSQL( "DROP TABLE IF EXISTS USER" );
        db.execSQL( "DROP TABLE IF EXISTS PRODUK" );
        db.execSQL( "DROP TABLE IF EXISTS USAHA" );
    }
}
