package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.keyuni.android.bullet.Helper.OpenHelper;
import com.keyuni.android.bullet.model.Peminjaman;

import java.util.ArrayList;

public class DbPeminjaman {
    private SQLiteDatabase db;
    private final OpenHelper dbPeminjaman;

    public DbPeminjaman(Context c){
        dbPeminjaman = new OpenHelper(c);
    }

    public void open(){
        db = dbPeminjaman.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertProduk(Peminjaman peminjaman){
        ContentValues newV = new ContentValues();
        newV.put("id_pinjam", peminjaman.getId_pinjam());
        newV.put("id_user", peminjaman.getId_user());
        newV.put("jumlah_pinjam", peminjaman.getJumlah_pinjam());
        newV.put("durasi_pinjam", peminjaman.getDurasi_pinjam());
        //newV.put("tanggal_pinjam", peminjaman.getTanggal_pinjam());
        newV.put("status", peminjaman.getStatus());

        return db.insert("peminjaman", null, newV);
    }

    public Peminjaman getPeminjaman(int id){
        Cursor cur = db.rawQuery("SELECT  * FROM PEMINJAMAN WHERE _id_pinjam="+ id, null);
        //Cursor cur = null;

        Peminjaman receivedPinjam = new Peminjaman();

        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedPinjam.setId_pinjam(cur.getInt(0));
            receivedPinjam.setId_user(cur.getInt(1));
            receivedPinjam.setJumlah_pinjam(cur.getInt(2));
            receivedPinjam.setDurasi_pinjam(cur.getInt(3));
            //receivedPinjam.setTanggal_pinjam(cur.getString(4));
            receivedPinjam.setStatus(cur.getString(5));
        }

        return receivedPinjam;

    }

    public void deletePinjam(long id, Context context){

        db.execSQL("DELETE FROM PEMINJAMAN WHERE _id_pinjam='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updatePinjam(long idPinjam, Context context, Peminjaman updatedPinjam){
        db.execSQL("UPDATE  PEMINJAMAN SET id_pinjam ='"+ updatedPinjam.getId_pinjam() + "', id_user ='" + updatedPinjam.getId_user()+ "', " +
                "jumlah_pinjam ='"+ updatedPinjam.getJumlah_pinjam() + "', durasi_pinjam ='"+ updatedPinjam.getDurasi_pinjam() + "', " +
                "tanggal_pinjam ='"+ updatedPinjam.getTanggal_pinjam() + "', status ='"+ updatedPinjam.getStatus() + "'  WHERE _id_pinjam='" + idPinjam + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Peminjaman> getAllProduk(){
        Cursor cur = null;
        ArrayList<Peminjaman> out = new ArrayList<>();

        cur = db.rawQuery("SELECT * FROM PRODUK", null);

        if (cur.moveToFirst()) {
            do{
                Peminjaman pro = new Peminjaman();
                pro.setId_pinjam(cur.getInt(0));
                pro.setId_user(cur.getInt(1));
                pro.setJumlah_pinjam(cur.getInt(2));
                pro.setDurasi_pinjam(cur.getInt(3));
                //pro.setTanggal_pinjam(cur.getString(4));
                pro.setStatus(cur.getString(5));
                out.add(pro);
            }while(cur.moveToNext());
        }

        cur.close();
        return out;
    }
}
