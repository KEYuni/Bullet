package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.keyuni.android.bullet.db.DbProduk;
import com.keyuni.android.bullet.model.Produk;

public class TambahProdukActivity extends AppCompatActivity {

    private Button btnOkeTambahProduk, btnBatalTambahProduk;
    private EditText etNamaProduk, etDeskripsiProduk, etHargaProduk, etStokProduk;
    Spinner spKategoriProduk;
    String kategoriPilihan;
    private DbProduk dbProduk;
    private Produk produk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_produk);

        //Deklarasi Tombol
        btnBatalTambahProduk = findViewById(R.id.btnBatalTambahProduk);
        btnOkeTambahProduk = findViewById(R.id.btnOkeTambahProduk);

        //Deklarasi Edit Text
        etNamaProduk = findViewById(R.id.etNamaProduk);
        etDeskripsiProduk = findViewById(R.id.etDeskripsiProduk);
        etHargaProduk = findViewById(R.id.etHargaProduk);
        etStokProduk = findViewById(R.id.etStokProduk);

        dbProduk = new DbProduk(this);
        dbProduk.open();

        //Deklarasi Spinner
        spKategoriProduk = findViewById(R.id.spKategoriProduk);

        ArrayAdapter<CharSequence>  adKategori = ArrayAdapter.createFromResource(this, R.array.kategoriProduk, android.R.layout.simple_spinner_item);
        adKategori.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKategoriProduk.setAdapter(adKategori);

        spKategoriProduk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //memasukan nilai yang akan di lempar ke DetailActivity
                kategoriPilihan = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

        btnBatalTambahProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBatalProduk = new Intent(getBaseContext(), DaftarProdukActivity.class);
                startActivity(intentBatalProduk);
            }
        });

        btnOkeTambahProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id_acc, harga, stok;
                harga = Integer.parseInt(etHargaProduk.getText().toString().trim());
                stok = Integer.parseInt(etStokProduk.getText().toString().trim());

                String nama_produk, deskripsi_produk, kategori;
                nama_produk = etNamaProduk.getText().toString().trim();
                deskripsi_produk = etDeskripsiProduk.getText().toString().trim();
                kategori = kategoriPilihan;

                produk = new Produk(harga, stok, nama_produk, deskripsi_produk, kategori);
                dbProduk.insertProduk(produk);
                dbProduk.close();
                finish();

                Intent intentOkeProduk = new Intent(getBaseContext(), DaftarProdukActivity.class);
                startActivity(intentOkeProduk);
            }

        });
    }
}
