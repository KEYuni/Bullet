package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.keyuni.android.bullet.Helper.OpenHelper;
import com.keyuni.android.bullet.model.Keuangan;

import java.util.ArrayList;

public class DbKeuangan {
    private SQLiteDatabase db;
    private final OpenHelper dbKeuangan;

    public DbKeuangan(Context c){
        dbKeuangan = new OpenHelper(c);
    }

    public void open(){
        db = dbKeuangan.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertKeuangan(Keuangan keuangan){
        ContentValues newV = new ContentValues();
        newV.put("id_keuangan", keuangan.getId_keuangan());
        newV.put("id_user", keuangan.getId_user());
        newV.put("pengeluaran", keuangan.getPengeluaran());
        newV.put("pemasukan", keuangan.getPemasukan());

        return db.insert("keuangan", null, newV);
    }

    public Keuangan getKeuangan(int id){
        Cursor cur = db.rawQuery("SELECT  * FROM KEUANGAN WHERE _id_keuangan="+ id, null);
        //Cursor cur = null;

        Keuangan receivedUang = new Keuangan();

        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedUang.setId_keuangan(cur.getInt(0));
            receivedUang.setId_user(cur.getInt(1));
            receivedUang.setPemasukan(cur.getInt(2));
            receivedUang.setPengeluaran(cur.getInt(3));
        }

        return receivedUang;

    }

    public void deleteKeuangan(long id, Context context){

        db.execSQL("DELETE FROM KEUANGAN WHERE _id_keuangan='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updateKeuangan(long idKeuangan, Context context, Keuangan updatedKeuangan){
        db.execSQL("UPDATE KEUANGAN SET id_keuangan ='"+ updatedKeuangan.getId_keuangan() + "', id_user ='" + updatedKeuangan.getId_user()+ "', " +
                "pengeluaran ='"+ updatedKeuangan.getPengeluaran() + "', pemasukan ='"+ updatedKeuangan.getPemasukan()+ "'WHERE _id_keuangan='" + idKeuangan + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Keuangan> getAllProduk(){
        Cursor cur = null;
        ArrayList<Keuangan> out = new ArrayList<>();

        cur = db.rawQuery("SELECT * FROM KEUANGAN", null);

        if (cur.moveToFirst()) {
            do{
                Keuangan keu = new Keuangan();
                keu.setId_keuangan(cur.getInt(0));
                keu.setId_user(cur.getInt(2));
                keu.setPengeluaran(cur.getInt(3));
                keu.setPemasukan(cur.getInt(4));
                out.add(keu);
            }while(cur.moveToNext());
        }

        cur.close();
        return out;
    }
}
