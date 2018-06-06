package com.keyuni.android.bullet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.keyuni.android.bullet.db.DbAccount;
import com.keyuni.android.bullet.db.DbUsaha;
import com.keyuni.android.bullet.model.Accounts;
import com.keyuni.android.bullet.model.Usaha;

public class InfoUsahaActivity extends AppCompatActivity {

    Button btnPembelian, btnProduk, btnEditUsaha;
    TextView tvnamaUsaha, tvemail, tvnomor, tvjenis, tvalamat;
    public SharedPreferences sp;
    public SharedPreferences.Editor ed;
    int idAkun;
    private DbUsaha dbUsaha;
    private Usaha usaha;
    public static final String PREFS_NAME = "Authentification";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_usaha);

        btnPembelian = findViewById(R.id.btnPembelian);
        btnProduk = findViewById(R.id.btnProduk);
        btnEditUsaha = findViewById(R.id.btnEditUsaha);

        tvnamaUsaha = findViewById(R.id.tvIUNamaUsaha);
        tvemail = findViewById(R.id.tvIUEmail);
        tvnomor = findViewById(R.id.tvIUNoHP);
        tvjenis = findViewById(R.id.tvIUJenisUsaha);
        tvalamat = findViewById(R.id.tvIUAlamatUsaha);

        sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        ed = sp.edit();

        dbUsaha = new DbUsaha(this);
        dbUsaha.open();


        idAkun= sp.getInt("id",  0);

        boolean insAkun = dbUsaha.checkUsaha(idAkun);
        if(insAkun == true){
            usaha = dbUsaha.getUsaha(idAkun);

            tvnamaUsaha.setText(String.valueOf(usaha.getNama_usaha()));
            tvalamat.setText(String.valueOf(usaha.getAlamat_usaha()));
            tvemail.setText(String.valueOf(usaha.getEmail_usaha()));
            tvnomor.setText(String.valueOf(usaha.getNohp_usaha()));
            tvjenis.setText(String.valueOf(usaha.getJenis_usaha()));
        }

        btnPembelian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin = new Intent(getBaseContext(), DaftarPembeliActivity.class);
                startActivity(intentLogin);
            }

        });

        btnProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin = new Intent(getBaseContext(), DaftarProdukActivity.class);
                startActivity(intentLogin);
            }

        });

        btnEditUsaha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin = new Intent(getBaseContext(), EditUsahaActivity.class);
                startActivity(intentLogin);
            }

        });
    }
}
