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
import com.keyuni.android.bullet.model.Accounts;

public class ResetPasswordActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "Authentification";
    public SharedPreferences sp;
    public SharedPreferences.Editor ed;
    private EditText etEmail, etNewPass, etKonfNewPass;
    //private int id;
    String strEmail;
    Button btnReset;
    private DbAccount dbAkun;
    Accounts akun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etEmail = findViewById(R.id.etEmailBr);
        etNewPass = findViewById(R.id.etSandiBaru);
        etKonfNewPass = findViewById(R.id.etKonfSandiBaru);
        btnReset = findViewById(R.id.btnReset);

        sp = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        ed = sp.edit();

        //id = sp.getInt("id", 0);
        //strEmail = sp.getString("email", "");
        dbAkun = new DbAccount(this);
        dbAkun.open();

        //akun = dbAkun.getAccount(id);

        //etEmail.setText(String.valueOf(akun.getEmail()));
        //etNewPass.setText(String.valueOf(akun.getKata_sandi()));
        //etKonfNewPass.setText(String.valueOf(akun.getKonfirmasi_sandi()));

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eEmail, newPass, konfNewpass;
                eEmail = etEmail.getText().toString().trim();
                newPass = etNewPass.getText().toString().trim();
                konfNewpass = etKonfNewPass.getText().toString().trim();
                if(konfNewpass.equals(newPass)){
                    Boolean chkemail = dbAkun.checkEmail(eEmail);

                    if(chkemail == true) {
                        int koin = akun.getKoin();

                        String nama, email, noHp, alamat, katasandi, konf;

                        nama = akun.getNama();
                        email = akun.getEmail();
                        noHp = akun.getNo_hp();
                        alamat = akun.getAlamat();
                        katasandi = etNewPass.getText().toString().trim();
                        konf = etKonfNewPass.getText().toString().trim();

                        akun = new Accounts(koin, nama, email, noHp, alamat, katasandi, konf);
                        dbAkun.updatePassword(email, getApplicationContext(), katasandi, akun);
                        dbAkun.close();
                        finish();

                        Intent intentEdit = new Intent(getBaseContext(), LoginActivity.class);
                        startActivity(intentEdit);
                    }else{
                        Toast.makeText(getApplicationContext(), "Email belum terdaftar", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Kata Sandi Tidak Sama", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
