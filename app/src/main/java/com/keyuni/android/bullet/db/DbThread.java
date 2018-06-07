package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.keyuni.android.bullet.Helper.OpenHelper;
import com.keyuni.android.bullet.model.Thread;

public class DbThread {
    private SQLiteDatabase db;
    private final OpenHelper dbThread;

    /*private String getDateTime() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy", Locale.getDefault());
        Date tanggal_buat = dateformat.parse();
        return dateformat.format(tanggal_buat);
    }*/
    public DbThread(Context c){
        dbThread = new OpenHelper(c);
    }

    public void open(){
        db = dbThread.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertThread(Thread thread){
        ContentValues newV = new ContentValues();
        newV.put("id_thread", thread.getId_thread());
        newV.put("id_user", thread.getId_user());
        newV.put("judul_thread", thread.getJudul_thread());
        newV.put("kategori_thread", thread.getKategori_thread());
        newV.put("deskripsi_thread", thread.getDeskripsi_thread());
        //newV.put("tanggal_buat", thread.getTanggal_buat());

        return db.insert("thread", null, newV);
    }

    public Thread getThread(long id){
        Cursor cur = db.rawQuery("SELECT  * FROM THREAD WHERE id_thread="+ id, null);

        Thread receivedThread = new Thread();
        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedThread.setId_thread(cur.getInt(cur.getColumnIndex("id_thread")));
            receivedThread.setId_user(cur.getInt(cur.getColumnIndex("id_user")));
            receivedThread.setJudul_thread(cur.getString(cur.getColumnIndex("judul_thread")));
            receivedThread.setKategori_thread(cur.getString(cur.getColumnIndex("kategori_thread")));
            receivedThread.setDeskripsi_thread(cur.getString(cur.getColumnIndex("deskripsi_thread")));
            //receivedThread.setTanggal_buat(cur.getLong(cur.getColumnIndex("tanggal_buat")));
        }

        return receivedThread;
    }

    public void deleteThread(long id, Context context){

        db.execSQL("DELETE FROM THREAD WHERE _id_thread='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updateThread(long idThread, Context context, Thread updatedThread){
        db.execSQL("UPDATE  THREAD SET id_thread ='" + updatedThread.getId_thread() + "', id_user ='"+ updatedThread.getId_user() + "'," +
                "judul_thread ='"+ updatedThread.getJudul_thread()+ "',kategori_thread ='"+ updatedThread.getKategori_thread()+ "', deskripsi_thread ='"+ updatedThread.getDeskripsi_thread()+
                "', tanggal_buat ='"+ updatedThread.getTanggal_buat()+"'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

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
    }
}
