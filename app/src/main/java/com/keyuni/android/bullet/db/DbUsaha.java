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
        newV.put("id_usaha", usaha.getId_usaha());
        newV.put("id_user", usaha.getId_user());
        newV.put("nama_usaha", usaha.getNama_usaha());
        newV.put("email_usaha", usaha.getEmail_usaha());
        newV.put("nohp_usaha", usaha.getNohp_usaha());
        newV.put("jenis_usaha", usaha.getJenis_usaha());
        newV.put("alamat_usaha", usaha.getAlamat_usaha());

        return db.insert("usaha", null, newV);
    }

    public Usaha getUsaha(long id){
        Cursor cur = db.rawQuery("SELECT  * FROM USER WHERE id="+ id, null);

        Usaha receivedUsaha = new Usaha();
        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedUsaha.setId_usaha(cur.getInt(cur.getColumnIndex("id_usaha")));
            receivedUsaha.setId_user(cur.getInt(cur.getColumnIndex("id_user")));
            receivedUsaha.setNama_usaha(cur.getString(cur.getColumnIndex("nama_usaha")));
            receivedUsaha.setEmail_usaha(cur.getString(cur.getColumnIndex("email_usaha")));
            receivedUsaha.setNohp_usaha(cur.getString(cur.getColumnIndex("nohp_usaha")));
            receivedUsaha.setJenis_usaha(cur.getString(cur.getColumnIndex("jenis_usaha")));
            receivedUsaha.setAlamat_usaha(cur.getString(cur.getColumnIndex("alamat_usaha")));
        }

        return receivedUsaha;
    }

    public void deleteUsaha(long id, Context context){

        db.execSQL("DELETE FROM USAHA WHERE _id_usaha='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updateUsaha(long idUsaha, Context context, Usaha updatedUsaha){
        db.execSQL("UPDATE  USAHA SET id_usaha ='" + updatedUsaha.getId_usaha() + "', id_user ='"+ updatedUsaha.getId_user() + "'," +
                "nama_usaha ='"+ updatedUsaha.getNama_usaha()+ "',email_usaha ='"+ updatedUsaha.getEmail_usaha()+ "', nohp_usaha ='"+ updatedUsaha.getNohp_usaha()+
                "', jenis_usaha ='"+ updatedUsaha.getJenis_usaha()+"', alamat_usaha ='"+ updatedUsaha.getAlamat_usaha() + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }
}
