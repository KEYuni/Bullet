package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.keyuni.android.bullet.model.Accounts;
import com.keyuni.android.bullet.model.Usaha;

import com.keyuni.android.bullet.Helper.OpenHelper;

public class DbUsaha {
    private SQLiteDatabase db;
    private final OpenHelper dbUsaha;

    public DbUsaha(Context c){
        dbUsaha = new OpenHelper(c);
    }

    public void open(){
        db = dbUsaha.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertUsaha(Usaha usaha){
        ContentValues newV = new ContentValues();
        newV.put("id_user", usaha.getId_user());
        newV.put("nama_usaha", usaha.getNama_usaha());
        newV.put("email_usaha", usaha.getEmail_usaha());
        newV.put("nohp_usaha", usaha.getNohp_usaha());
        newV.put("jenis_usaha", usaha.getJenis_usaha());
        newV.put("alamat_usaha", usaha.getAlamat_usaha());

        return db.insert("usaha", null, newV);
    }

    public Usaha getUsaha(long id){
        Cursor cur = db.rawQuery("SELECT  * FROM USAHA WHERE id_user="+ id, null);

        Usaha receivedUsaha = new Usaha();
        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedUsaha.setNama_usaha(cur.getString(2));
            receivedUsaha.setEmail_usaha(cur.getString(3));
            receivedUsaha.setNohp_usaha(cur.getString(4));
            receivedUsaha.setJenis_usaha(cur.getString(5));
            receivedUsaha.setAlamat_usaha(cur.getString(6));

        }

        return receivedUsaha;
    }

    public void deleteUsaha(long id, Context context){

        db.execSQL("DELETE FROM USAHA WHERE _id_usaha='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updateUsaha(long idUsaha, Context context, Usaha updatedUsaha){
        db.execSQL("UPDATE  USAHA SET _id_usaha ='" + updatedUsaha.getId_usaha() + "', id_user ='"+ updatedUsaha.getId_user() + "'," +
                "nama_usaha ='"+ updatedUsaha.getNama_usaha()+ "',email_usaha ='"+ updatedUsaha.getEmail_usaha()+ "', nohp_usaha ='"+ updatedUsaha.getNohp_usaha()+
                "', jenis_usaha ='"+ updatedUsaha.getJenis_usaha()+"', alamat_usaha ='"+ updatedUsaha.getAlamat_usaha() + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

    public boolean checkUsaha(long idUser){
        db = dbUsaha.getReadableDatabase();
        Cursor cur = db.rawQuery("SELECT  * FROM USAHA WHERE id_user="+ idUser, null);
        if (cur.getCount()>0) return true;
        else return false;
    }
}
