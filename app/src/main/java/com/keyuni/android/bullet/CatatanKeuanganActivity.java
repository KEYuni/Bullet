package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CatatanKeuanganActivity extends AppCompatActivity {
    Button btnCatPeminjaman,btnCatPenjualan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_keuangan);
        btnCatPeminjaman = findViewById(R.id.btnCKPeminjaman);
        btnCatPenjualan = findViewById(R.id.btnCKPenjualan);

        btnCatPeminjaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCatKeuangan= new Intent(getBaseContext(), CatatanPeminjamanActivity.class);
                startActivity(intentCatKeuangan);
            }

        });

        btnCatPenjualan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCatKeuangan= new Intent(getBaseContext(), CatatanPenjualanActivity.class);
                startActivity(intentCatKeuangan);
            }

        });
    }
}
