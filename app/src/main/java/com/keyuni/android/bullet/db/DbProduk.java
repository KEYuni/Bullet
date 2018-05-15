package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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

    public Produk getProduk(int id){
        Cursor cur = db.rawQuery("SELECT  * FROM PRODUK WHERE _id_produk="+ id, null);
        //Cursor cur = null;

        Produk receivedProduk = new Produk();

        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedProduk.setHarga(cur.getInt(2));
            receivedProduk.setStok(cur.getInt(3));
            receivedProduk.setNama_produk(cur.getString(4));
            receivedProduk.setDeskripsi_produk(cur.getString(5));
            receivedProduk.setKategori(cur.getString(6));
        }

        return receivedProduk;

    }

    public void deleteProduk(long id, Context context){

        db.execSQL("DELETE FROM PRODUK WHERE _id_produk='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updateProduk(long idProduk, Context context, Produk updatedProduk){
        db.execSQL("UPDATE  PRODUK SET harga ='"+ updatedProduk.getHarga() + "', stok ='" + updatedProduk.getStok()+ "', " +
                "nama_produk ='"+ updatedProduk.getNama_produk() + "', deskripsi_produk ='"+ updatedProduk.getDeskripsi_produk()+ "', " +
                "kategori ='"+ updatedProduk.getKategori() + "'  WHERE _id_produk='" + idProduk + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Produk> getAllProduk(){
        Cursor cur = null;
        ArrayList<Produk> out = new ArrayList<>();

        cur = db.rawQuery("SELECT * FROM PRODUK", null);

        if (cur.moveToFirst()) {
            do{
                Produk pro = new Produk();
                pro.setId_produk(cur.getInt(0));
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
