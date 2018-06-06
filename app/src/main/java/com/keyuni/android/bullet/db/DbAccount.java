package com.keyuni.android.bullet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.keyuni.android.bullet.Helper.OpenHelper;
import com.keyuni.android.bullet.model.Accounts;
import com.keyuni.android.bullet.model.Produk;

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

    public boolean insertAkun(Accounts akun){
        ContentValues newV = new ContentValues();
        newV.put("koin", akun.getKoin());
        newV.put("nama", akun.getNama());
        newV.put("email", akun.getEmail());
        newV.put("no_hp", akun.getNo_hp());
        newV.put("alamat", akun.getAlamat());
        newV.put("katasandi", akun.getKata_sandi());
        newV.put("konfirmasi_sandi", akun.getKonfirmasi_sandi());

        long ins = db.insert("user", null, newV);
        if(ins == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public Accounts getAccount(int id){
        Cursor cur = db.rawQuery("SELECT  * FROM USER WHERE _id="+ id, null);

        Accounts receivedAccounts = new Accounts();
        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedAccounts.setId(cur.getInt(0));
            receivedAccounts.setKoin(100000);
            receivedAccounts.setNama(cur.getString(2));
            receivedAccounts.setEmail(cur.getString(3));
            receivedAccounts.setNo_hp(cur.getString(4));
            receivedAccounts.setAlamat(cur.getString(5));
            receivedAccounts.setKata_sandi(cur.getString(6));
            receivedAccounts.setKonfirmasi_sandi(cur.getString(7));
        }

        return receivedAccounts;

    }

    public void deleteAccount(long id, Context context){

        db.execSQL("DELETE FROM USER WHERE _id='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();
    }

    public void updateAccount(int idUser, Context context, Accounts updatedAccount){
        db.execSQL("UPDATE  USER SET nama ='" + updatedAccount.getNama()+ "', email ='"+ updatedAccount.getEmail() + "'," +
                "no_hp ='"+ updatedAccount.getNo_hp()+ "', alamat ='"+ updatedAccount.getAlamat() + "'," +
                "katasandi ='"+ updatedAccount.getKata_sandi()+ "', konfirmasi_sandi ='"+ updatedAccount.getKonfirmasi_sandi() +
                "'  WHERE _id='" + idUser + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();
    }

    public boolean checkAccount(String email, String katasandi){
        db = dbAccount.getReadableDatabase();
        Cursor cur = db.rawQuery("Select * from USER where email=? and katasandi=?", new String[]{email, katasandi});
        if (cur.getCount()>0) return true;
        else return false;
    }

    public boolean checkEmail(String email){
        db = dbAccount.getReadableDatabase();
        Cursor cur = db.rawQuery("Select * from USER where email=?", new String[]{email});
        if (cur.getCount()>0) return false;
        else return true;
    }

    public Accounts getId_Accounts(String email){
        db = dbAccount.getReadableDatabase();
        Cursor cur = db.rawQuery("Select * from USER where email=?", new String[] {email});

        Accounts receivedAccounts = new Accounts();
        if(cur.getCount() > 0){
            cur.moveToFirst();

            receivedAccounts.setId(cur.getInt(0));
            receivedAccounts.setKoin(100000);
            receivedAccounts.setNama(cur.getString(2));
            receivedAccounts.setEmail(cur.getString(3));
            receivedAccounts.setNo_hp(cur.getString(4));
            receivedAccounts.setAlamat(cur.getString(5));
            receivedAccounts.setKata_sandi(cur.getString(6));
            receivedAccounts.setKonfirmasi_sandi(cur.getString(7));
        }

        return receivedAccounts;
    }

    public void updatePassword(String email, Context context, String kata_sandi, Accounts updatePassword){
        db = dbAccount.getWritableDatabase();
        db.execSQL("UPDATE PASSWORD SET katasandi ='" + updatePassword.getKata_sandi()+ "', konfirmasi_sandi='"+ updatePassword.getKonfirmasi_sandi()+
                "'  WHERE _email='" + email + "'");
        Toast.makeText(context, "Password berhasil di reset!.", Toast.LENGTH_SHORT).show();
    }
}
