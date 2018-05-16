package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.keyuni.android.bullet.Helper.OpenHelper;
import com.keyuni.android.bullet.model.Accounts;

public class DbAccount {
    private SQLiteDatabase db;
    private final OpenHelper dbAccount;

    public DbAccount(Context c){
        dbAccount = new OpenHelper(c);
    }

    public void open(){
        db = dbAccount.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long insertProduk(Accounts akun){
        ContentValues newV = new ContentValues();
        newV.put("koin", 100000);
        newV.put("nama", akun.getNama());
        newV.put("email", akun.getEmail());
        newV.put("no_hp", akun.getNo_hp());
        newV.put("alamat", akun.getAlamat());
        newV.put("katasandi", akun.getKata_sandi());
        newV.put("konfirmasi_katasandi", akun.getKonfirmasi_sandi());

        return db.insert("user", null, newV);
    }

    public Accounts getAccount(long id){
        Cursor cur = db.rawQuery("SELECT  * FROM USER WHERE _id="+ id, null);

        Accounts receivedAccounts = new Accounts();
        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedAccounts.setKoin(100000);
            receivedAccounts.setNama(cur.getString(cur.getColumnIndex("nama")));
            receivedAccounts.setEmail(cur.getString(cur.getColumnIndex("email")));
            receivedAccounts.setNo_hp(cur.getString(cur.getColumnIndex("no_hp")));
            receivedAccounts.setAlamat(cur.getString(cur.getColumnIndex("alamat")));
            receivedAccounts.setKata_sandi(cur.getString(cur.getColumnIndex("katasandi")));
            receivedAccounts.setKonfirmasi_sandi(cur.getString(cur.getColumnIndex("konfirmasi_katasandi")));
        }

        return receivedAccounts;

    }

    public void deleteAccount(long id, Context context){

        db.execSQL("DELETE FROM USER WHERE _id='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updateAccount(long idUser, Context context, Accounts updatedAccount){
        db.execSQL("UPDATE  USER SET nama ='" + updatedAccount.getNama()+ "', email ='"+ updatedAccount.getEmail() + "'," +
                "no_hp ='"+ updatedAccount.getNo_hp()+ "', alamat ='"+ updatedAccount.getAlamat() + "'," +
                "katasandi ='"+ updatedAccount.getKata_sandi()+ "', konfirmasi_katasandi ='"+ updatedAccount.getKonfirmasi_sandi() +
                "'  WHERE _id='" + idUser + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

    //public boolean checkAccount(String email, String password){
      //  db = dbAccount.getReadableDatabase();
        //Cursor cur = db.rawQuery("Select * from USER where email=? and katasandi=?", new String[]{email, katasandi});
       // if (cur.getCount()>0) return true;
       // else return false;
   // }

    public boolean checkEmail(String email){
        db = dbAccount.getReadableDatabase();
        Cursor cur = db.rawQuery("Select * from USER where email=?", new String[]{email});
        if (cur.getCount()>0) return false;
        else return true;
    }
}
