package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.keyuni.android.bullet.Helper.OpenHelper;
import com.keyuni.android.bullet.model.Komentar;
import com.keyuni.android.bullet.model.Thread;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class DbKomentar {
    private SQLiteDatabase db;
    private final OpenHelper dbKomen;

    private String getDateTime() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
        Date date = new Date();
        return dateformat.format(date);
    }

    public DbKomentar(Context c){
        dbKomen = new OpenHelper(c);
    }

    public void open(){
        db = dbKomen.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertKomen(Komentar komen){
        ContentValues newV = new ContentValues();
        newV.put("id_komentar", komen.getId_komentar());
        newV.put("id_user", komen.getId_user());
        newV.put("id_thread", komen.getId_thread());
        newV.put("isi_komentar", komen.getIsi_komentar());
        newV.put("tanggal_buat", getDateTime());

        return db.insert("komentar", null, newV);
    }

    public Komentar getKomen(long id){
        Cursor cur = db.rawQuery("SELECT  * FROM KOMENTAR WHERE id_komentar="+ id, null);

        Komentar receivedKomen = new Komentar();
        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedKomen.setId_komentar(cur.getInt(cur.getColumnIndex("id_komentar")));
            receivedKomen.setId_user(cur.getInt(cur.getColumnIndex("id_user")));
            receivedKomen.setId_thread(cur.getInt(cur.getColumnIndex("id_thread")));
            receivedKomen.setIsi_komentar(cur.getString(cur.getColumnIndex("isi_komentar")));
            //receivedThread.setTanggal_buat(cur.getLong(cur.getColumnIndex("tanggal_buat")));
        }

        return receivedKomen;
    }

    public void deleteKomen(long id, Context context){

        db.execSQL("DELETE FROM KOMENTAR WHERE _id_komentar='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updateKomentar(long idKomentar, Context context, Komentar updatedKomen){
        db.execSQL("UPDATE  KOMENTAR SET id_komentar ='" + updatedKomen.getId_komentar() + "', id_user ='"+ updatedKomen.getId_user() + "'," +
                "id_thread ='"+ updatedKomen.getId_thread()+ "', isi_komentar ='"+ updatedKomen.getIsi_komentar()+
                "', tanggal_buat ='"+ updatedKomen.getTanggal_buat()+"'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }
    /*
    public ArrayList<Thread> getAllThread(){
        Cursor cur = null;
        ArrayList<Thread> out = new ArrayList<>();

        cur = db.rawQuery("SELECT * FROM PRODUK", null);

        if (cur.moveToFirst()) {
            do{
                Thread thread = new Thread();
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
