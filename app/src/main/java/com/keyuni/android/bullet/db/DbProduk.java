package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.keyuni.android.bullet.Helper.OpenHelper;
import com.keyuni.android.bullet.model.Produk;

import java.util.ArrayList;

public class DbProduk {
    private SQLiteDatabase db;
    private final OpenHelper dbProduk;

    public DbProduk(Context c){
        dbProduk = new OpenHelper(c);
    }

    public void open(){
        db = dbProduk.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertProduk(Produk produk){
        ContentValues newV = new ContentValues();
        newV.put("harga", produk.getHarga());
        newV.put("stok", produk.getStok());
        newV.put("nama_produk", produk.getNama_produk());
        newV.put("deskripsi_produk", produk.getDeskripsi_produk());
        newV.put("kategori", produk.getKategori());

        return db.insert("produk", null, newV);
    }

    public ArrayList<Produk> getAllProduk(){
        Cursor cur = null;
        ArrayList<Produk> out = new ArrayList<>();

        cur = db.rawQuery("SELECT * FROM PRODUK", null);

        if (cur.moveToFirst()) {
            do{
                Produk pro = new Produk();
                pro.setId_produk(cur.getInt(1));
                pro.setHarga(cur.getInt(2));
                pro.setStok(cur.getInt(3));
                pro.setNama_produk(cur.getString(4));
                pro.setDeskripsi_produk(cur.getString(5));
                pro.setKategori(cur.getString(6));
                out.add(pro);
            }while(cur.moveToNext());
        }

        cur.close();
        return out;
    }
}
