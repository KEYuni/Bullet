package com.keyuni.android.bullet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.keyuni.android.bullet.db.DbAccount;
import com.keyuni.android.bullet.model.Accounts;
import com.keyuni.android.bullet.model.Produk;

public class EditProfilActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "Authentification";
    public SharedPreferences sp;
    public SharedPreferences.Editor ed;
    public EditText eNama, eEmail, eNoHP, eAlamat;
    private DbAccount dbAccount;
    private Accounts accounts;
    private int id;
    Button btnSimpan;
    String strID, strPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        eNama = findViewById(R.id.etEPNama);
        eEmail = findViewById(R.id.etEPEmail);
        eNoHP = findViewById(R.id.etEPNomorHP);
        eAlamat = findViewById(R.id.etEPAlamat);
        btnSimpan = findViewById(R.id.btnEPSimpan);

        sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        ed = sp.edit();

        id = sp.getInt("id", 0);
        strPasswd = sp.getString("passwd", "");

        dbAccount = new DbAccount(this);
        dbAccount.open();

        accounts = dbAccount.getAccount(id);

        eNama.setText(String.valueOf(accounts.getNama()));
        eAlamat.setText(String.valueOf(accounts.getAlamat()));
        eEmail.setText(String.valueOf(accounts.getEmail()));
        eNoHP.setText(String.valueOf(accounts.getNo_hp()));


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int koin = accounts.getKoin();

                String nama, email, noHp, alamat, katasandi, konf;
                nama = eNama.getText().toString().trim();
                email = eEmail.getText().toString().trim();
                noHp = eNoHP.getText().toString().trim();
                alamat = eAlamat.getText().toString().trim();
                katasandi = accounts.getKata_sandi();
                konf = accounts.getKonfirmasi_sandi();

                accounts = new Accounts(koin, nama, email, noHp, alamat, katasandi, konf);
                dbAccount.updateAccount(id, getApplicationContext(), accounts);
                dbAccount.close();
                finish();

                Intent intentEdit = new Intent(getBaseContext(), ProfilActivity.class);
                startActivity(intentEdit);
            }

        });
    }
}
