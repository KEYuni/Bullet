package com.keyuni.android.bullet;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.keyuni.android.bullet.db.DbProduk;
import com.keyuni.android.bullet.model.Produk;

public class DetailProductActivity extends AppCompatActivity {

    private TextView tvNamaProduk, tvDeskripsiProduk, tvKategori, tvHarga, tvStok;
    private DbProduk dbProduk;
    private Produk produk;
    private int receivedProdukId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        tvNamaProduk = findViewById(R.id.tvDetailNamaProduk);
        tvDeskripsiProduk = findViewById(R.id.tvDeskripsiDetailProduk);
        tvKategori = findViewById(R.id.tvKategoriDetailProduk);
        tvHarga = findViewById(R.id.tvHargaDetailProduk);
        tvStok = findViewById(R.id.tvStokDetailProduk);

        dbProduk = new DbProduk(this);
        dbProduk.open();

        //final Intent intentDetail = getIntent();
        //receivedProdukId = intentDetail.getIntExtra("id_produk", 1);

        //toast = Toast.makeText(getApplicationContext(), String.valueOf(receivedProdukId), Toast.LENGTH_SHORT);
        //toast.show();

        try{
            receivedProdukId = getIntent().getIntExtra("id_produk", 1);

        } catch (Exception e){
            e.printStackTrace();
        }

        produk = dbProduk.getProduk(receivedProdukId);
        //set field to this user data
        tvNamaProduk.setText(String.valueOf(produk.getNama_produk()));
        tvDeskripsiProduk.setText(String.valueOf(produk.getDeskripsi_produk()));
        tvKategori.setText(String.valueOf(produk.getKategori()));
        tvHarga.setText(String.valueOf(produk.getHarga()));
        tvStok.setText(String.valueOf(produk.getStok()));

    }
}
