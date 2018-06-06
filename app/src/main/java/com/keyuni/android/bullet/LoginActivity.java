package com.keyuni.android.bullet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.keyuni.android.bullet.db.DbAccount;
import com.keyuni.android.bullet.model.Accounts;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    Button btnLogin;
    SQLiteDatabase db;
    private TextView tvDaftar, tvForgotPassword;
    private DbAccount dbAkun;
    private Accounts akun;
    SharedPreferences sp;
    SharedPreferences.Editor ed;
    public static final String PREFS_NAME = "Authentification";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etuname);
        etPassword = findViewById(R.id.etpass);
        btnLogin = findViewById(R.id.btnLogin);
        tvDaftar = findViewById(R.id.tvDaftar);
        tvForgotPassword = findViewById(R.id.tvLupaSandi);

        sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        ed = sp.edit();

        dbAkun = new DbAccount(this);
        dbAkun.open();



        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin = new Intent(getBaseContext(), ForgotPasswordActivity.class);
                startActivity(intentLogin);
            }

        });

        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin = new Intent(getBaseContext(), SignUpActivity.class);
                startActivity(intentLogin);
            }

        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username, password;

                username = etUsername.getText().toString().trim();
                password = etPassword.getText().toString().trim();

                Boolean chkAkun = dbAkun.checkAccount(username, password);

                if(chkAkun == true){

                    akun = dbAkun.getId_Accounts(username);
                    int idAkun = akun.getId();

                    ed.putInt("id", idAkun);
                    ed.putString("passwd", password);
                    ed.commit();

                    Intent intentLogin = new Intent(getBaseContext(), InfoUsahaActivity.class);
                    startActivity(intentLogin);
                }else{
                    Toast.makeText(getApplicationContext(), "Email atau Password salah", Toast.LENGTH_SHORT).show();
                }


            }

        });
    }
}
