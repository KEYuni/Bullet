package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.keyuni.android.bullet.db.DbAccount;
import com.keyuni.android.bullet.db.DbProduk;
import com.keyuni.android.bullet.model.Accounts;
import com.keyuni.android.bullet.model.Produk;

public class SignUpActivity extends AppCompatActivity {

    private EditText etNama, etEmail, etNoHP, etAlamat, etKataSandi, etKonfirmasiKataSandi;
    Button btnDaftar;
    private DbAccount dbAkun;
    private Accounts akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etNama = findViewById(R.id.etSUNama);
        etEmail = findViewById(R.id.etSUEmail);
        etNoHP = findViewById(R.id.etSUNomorHP);
        etAlamat = findViewById(R.id.etSUAlamat);
        etKataSandi = findViewById(R.id.etSUPass);
        etKonfirmasiKataSandi = findViewById(R.id.etSUConfirm);
        btnDaftar = findViewById(R.id.btnDaftar);

        dbAkun = new DbAccount(this);


        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, email, noHP, alamat, kataSandi, konfirmasiSandi;
                int koin;
                koin = 100000;
                nama = etNama.getText().toString().trim();
                email = etEmail.getText().toString().trim();
                noHP = etNoHP.getText().toString().trim();
                alamat = etAlamat.getText().toString().trim();
                kataSandi = etKataSandi.getText().toString().trim();
                konfirmasiSandi = etKonfirmasiKataSandi.getText().toString().trim();

                if(kataSandi.equals(konfirmasiSandi)) {
                    Boolean chkemail = dbAkun.checkEmail(email);

                    if (chkemail == true) {
                        dbAkun.open();
                        akun = new Accounts(koin, nama, email, noHP, alamat, kataSandi, konfirmasiSandi);
                        Boolean insAkun = dbAkun.insertAkun(akun);
                        dbAkun.close();
                        finish();

                        if(insAkun == true){
                            Toast.makeText(getApplicationContext(), "Daftar Akun berhasil", Toast.LENGTH_SHORT).show();

                            Intent intentSignUp = new Intent(getBaseContext(), LoginActivity.class);
                            startActivity(intentSignUp);
                        }
                    }else{
                       Toast.makeText(getApplicationContext(), "Email sudah terdaftar", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Kata Sandi Tidak Sama", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}
