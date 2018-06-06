package com.keyuni.android.bullet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.keyuni.android.bullet.db.DbAccount;
import com.keyuni.android.bullet.db.DbUsaha;
import com.keyuni.android.bullet.model.Accounts;
import com.keyuni.android.bullet.model.Usaha;

public class EditUsahaActivity extends AppCompatActivity {

    EditText etnama,etemail, etnomor, etjenis, etalamat;
    Button btnSimpan;

    int idAkun;
    private DbUsaha dbUsaha;
    private Usaha usaha;
    public static final String PREFS_NAME = "Authentification";

    public SharedPreferences sp;
    public SharedPreferences.Editor ed;
    int idUsaha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_usaha);

        etnama = findViewById(R.id.etEUNamaUsaha);
        etemail = findViewById(R.id.etEUEmail);
        etnomor = findViewById(R.id.etEUNomorUsaha);
        etjenis = findViewById(R.id.etEUJenisUsaha);
        etalamat = findViewById(R.id.etEUAlamatUsaha);

        btnSimpan = findViewById(R.id.btnEUSimpan);

        sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        ed = sp.edit();

        idAkun= sp.getInt("id",  0);

        dbUsaha = new DbUsaha(this);
        dbUsaha.open();

        final boolean insAkun = dbUsaha.checkUsaha(idAkun);
        if(insAkun == true){
            usaha = dbUsaha.getUsaha(idAkun);
            idUsaha = usaha.getId_usaha();
            etnama.setText(String.valueOf(usaha.getNama_usaha()));
            etalamat.setText(String.valueOf(usaha.getAlamat_usaha()));
            etemail.setText(String.valueOf(usaha.getEmail_usaha()));
            etnomor.setText(String.valueOf(usaha.getNohp_usaha()));
            etjenis.setText(String.valueOf(usaha.getJenis_usaha()));
        }


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, email, noHP, alamat, jenis;
                nama = etnama.getText().toString().trim();
                email = etemail.getText().toString().trim();
                noHP = etnomor.getText().toString().trim();
                alamat = etalamat.getText().toString().trim();
                jenis = etjenis.getText().toString().trim();

                usaha = new Usaha(idAkun, nama, email, noHP, jenis, alamat);

                if(insAkun){
                    dbUsaha.updateUsaha(idUsaha, getApplicationContext(), usaha);
                }else {
                    dbUsaha.insertUsaha(usaha);
                }
                dbUsaha.close();
                finish();
                Toast.makeText(getApplicationContext(), "Info Usaha berhasil diubah", Toast.LENGTH_SHORT).show();

            }

        });
    }
}
