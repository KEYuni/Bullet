package com.keyuni.android.bullet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.keyuni.android.bullet.db.DbAccount;
import com.keyuni.android.bullet.model.Accounts;

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
    Button editButton;
    public SharedPreferences sp;
    public SharedPreferences.Editor ed;
    String strID, strPasswd;
    private DbAccount dbAccount;
    private Accounts accounts;
    public static final String PREFS_NAME = "Authentification";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        BottomNavigationView btm = findViewById(R.id.bottomNavView);
        disableShiftMode(btm);

        sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        ed = sp.edit();

        strID = sp.getString("id", "");
        strPasswd = sp.getString("passwd", "");

        fotoProfil = findViewById(R.id.ivFotoProfil);
        tvNama = findViewById(R.id.tvNamaProfl);
        tvEmail = findViewById(R.id.tvEmailProfil);
        tvNoHP = findViewById(R.id.tvNohpProfil);
        tvAlamat = findViewById(R.id.tvAlamatProfil);
        editButton = findViewById(R.id.btnEditProfil);

        dbAccount = new DbAccount(this);
        dbAccount.open();

        accounts = dbAccount.getId_Accounts(strID);

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
    }
    @SuppressLint("RestrictedApi")
    private void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
