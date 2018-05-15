package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.keyuni.android.bullet.Helper.ProdukAdapter;
import com.keyuni.android.bullet.db.DbProduk;
import com.keyuni.android.bullet.model.Produk;

import java.util.ArrayList;

public class DaftarProdukActivity extends AppCompatActivity {

    private Button btnTambahProduk;
    private RecyclerView rvDaftarProduk;
    private DbProduk dbProduk;
    private ArrayList<Produk> produks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_produk);

        dbProduk = new DbProduk(this);
        dbProduk.open();

        produks = dbProduk.getAllProduk();

        rvDaftarProduk = findViewById(R.id.rvDaftarProduk);
        rvDaftarProduk.setAdapter(new ProdukAdapter(this, produks));
        rvDaftarProduk.setHasFixedSize(true);
        rvDaftarProduk.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        btnTambahProduk = findViewById(R.id.btnTambahProduk);

        btnTambahProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddProduk = new Intent(getBaseContext(), TambahProdukActivity.class);
                startActivity(intentAddProduk);
            }

        });
    }
}
