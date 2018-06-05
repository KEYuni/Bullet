package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.keyuni.android.bullet.Helper.OpenHelper;
import com.keyuni.android.bullet.model.Pembeli;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DbPembeli {
    private SQLiteDatabase db;
    private final OpenHelper dbPembeli;

    private String getDateTime() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
        Date date = new Date();
        return dateformat.format(date);
    }

    public DbPembeli(Context c){
        dbPembeli = new OpenHelper(c);
    }

    public void open(){
        db = dbPembeli.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertPembeli(Pembeli pembeli){
        ContentValues newV = new ContentValues();
        newV.put("id_pembeli", pembeli.getId_pembeli());
        newV.put("id_user", pembeli.getId_user());
        newV.put("id_usaha", pembeli.getId_usaha());
        newV.put("kode_transaksi", pembeli.getKode_transaksi());
        newV.put("jumlah_beli", pembeli.getJumlah_beli());
        newV.put("tanggal_beli", getDateTime());

        return db.insert("pembeli", null, newV);
    }

    public Pembeli getPembeli(long id){
        Cursor cur = db.rawQuery("SELECT  * FROM PEMBELI WHERE id_pembeli="+ id, null);

        Pembeli receivedPembeli = new Pembeli();
        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedPembeli.setId_pembeli(cur.getInt(cur.getColumnIndex("id_pembeli")));
            receivedPembeli.setId_user(cur.getInt(cur.getColumnIndex("id_user")));
            receivedPembeli.setId_usaha(cur.getInt(cur.getColumnIndex("id_usaha")));
            receivedPembeli.setId_produk(cur.getInt(cur.getColumnIndex("id_produk")));
            receivedPembeli.setKode_transaksi(cur.getString(cur.getColumnIndex("kode_transaksi")));
            receivedPembeli.setJumlah_beli(cur.getInt(cur.getColumnIndex("jumlah_beli")));
            //receivedThread.setTanggal_buat(cur.getLong(cur.getColumnIndex("tanggal_buat")));
        }

        return receivedPembeli;
    }

    public void deletePembeli(long id, Context context){

        db.execSQL("DELETE FROM PEMBELI WHERE _id_pembeli='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updatePembeli(long idPembeli, Context context, Pembeli updatedPembeli){
        db.execSQL("UPDATE  PEMBELI SET id_pembeli ='" + updatedPembeli.getId_pembeli() + "', id_user ='"+ updatedPembeli.getId_user() + "'," +
                "id_usaha ='"+ updatedPembeli.getId_usaha()+ "',id_produk ='"+ updatedPembeli.getId_produk()+ "', kode_transaksi ='"+ updatedPembeli.getKode_transaksi()+
                "', jumlah_beli ='"+ updatedPembeli.getJumlah_beli() +"' tanggal_buat ='"+ updatedPembeli.getTanggal_beli()+"'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }
    /*
    public ArrayList<Pembeli> getAllThread(){
        Cursor cur = null;
        ArrayList<Pembeli> out = new ArrayList<>();

        cur = db.rawQuery("SELECT * FROM PEMBELI", null);

        if (cur.moveToFirst()) {
            do{
                Pembeli pembeli = new Pembeli();
                thread.setId_thread(cur.getInt(0));
                thread.setId_user(cur.getInt(2));
                thread.setJudul_thread(cur.getString(3));
                thread.setKategori_thread(cur.getString(4));
                thread.setDeskripsi_thread(cur.getString(5));
                //thread.setTanggal_buat(cur.getColumnName(6));
                out.add(thread);
            }while(cur.moveToNext());
        }

        cur.close();
        return out;
    }*/
}
