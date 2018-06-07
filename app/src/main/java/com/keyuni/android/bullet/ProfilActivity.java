package com.keyuni.android.bullet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.keyuni.android.bullet.db.DbAccount;
import com.keyuni.android.bullet.model.Accounts;
import com.keyuni.android.bullet.model.Usaha;

import java.lang.reflect.Field;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ProfilActivity extends AppCompatActivity {

    public TextView tvNama, tvEmail, tvNoHP, tvAlamat;
    public ImageView fotoProfil;
    Button editButton, btnLogout;
    public SharedPreferences sp;
    public SharedPreferences.Editor ed;
    String strPasswd;
    int idAkun;
    private DbAccount dbAccount;
    private Accounts accounts;
    public static final String PREFS_NAME = "Authentification";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        ed = sp.edit();

        idAkun= sp.getInt("id",  0);
        strPasswd = sp.getString("passwd", "");

        fotoProfil = findViewById(R.id.ivFotoProfil);
        tvNama = findViewById(R.id.tvNamaProfl);
        tvEmail = findViewById(R.id.tvEmailProfil);
        tvNoHP = findViewById(R.id.tvNohpProfil);
        tvAlamat = findViewById(R.id.tvAlamatProfil);
        editButton = findViewById(R.id.btnEditProfil);
        btnLogout = findViewById(R.id.btnLogout);

        dbAccount = new DbAccount(this);
        dbAccount.open();

        accounts = dbAccount.getAccount(idAkun);

        tvNama.setText(": " +String.valueOf(accounts.getNama()));
        tvAlamat.setText(": " +String.valueOf(accounts.getAlamat()));
        tvEmail.setText(": " +String.valueOf(accounts.getEmail()));
        tvNoHP.setText(": " +String.valueOf(accounts.getNo_hp()));


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentProfil = new Intent(getBaseContext(), EditProfilActivity.class);
                startActivity(intentProfil);
            }

        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOut = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intentOut);
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_user:
                        break;

                    case R.id.nav_chat:
                        Intent intent1 = new Intent(ProfilActivity.this, Forum.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_shop:

                        Intent intent0 = new Intent(ProfilActivity.this, InfoUsahaActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.nav_bounty:
                        Intent intent3 = new Intent(ProfilActivity.this, PeminjamanActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_cheque:
                        Intent intent4 = new Intent(ProfilActivity.this, CatatanKeuanganActivity.class);
                        startActivity(intent4);
                        break;
                }


                return false;
            }
        });
    }

}
