package com.keyuni.android.bullet;

import android.app.AlertDialog;
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

public class UpdateProdukActivity extends AppCompatActivity {

    private Button btnUpdateProduk, btnBatalUpdateProduk;
    private EditText etNamaProduk, etDeskripsiProduk, etHargaProduk, etStokProduk;
    Spinner spKategoriProduk;
    String kategoriPilihan;
    private DbProduk dbProduk;
    private Produk produk;
    private int receivedProdukId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_produk);

        //Deklarasi Tombol
        btnUpdateProduk = findViewById(R.id.btnUpdateProduk);
        btnBatalUpdateProduk = findViewById(R.id.btnBatalUpdateProduk);

        //Deklarasi Edit Text
        etNamaProduk = findViewById(R.id.etUpdateNamaProduk);
        etDeskripsiProduk = findViewById(R.id.etUpdateDeskripsiProduk);
        etHargaProduk = findViewById(R.id.etUpdateHargaProduk);
        etStokProduk = findViewById(R.id.etUpdateStokProduk);

        dbProduk = new DbProduk(this);
        dbProduk.open();

        //Deklarasi Spinner
        spKategoriProduk = findViewById(R.id.spUpdateKategoriProduk);

        ArrayAdapter<CharSequence> adKategori = ArrayAdapter.createFromResource(this, R.array.kategoriProduk, android.R.layout.simple_spinner_item);
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

        try{
            receivedProdukId = getIntent().getIntExtra("id_produk", 1);


        } catch (Exception e){
            e.printStackTrace();
        }

        produk = dbProduk.getProduk(receivedProdukId);
        //set field to this user data
        etNamaProduk.setText(String.valueOf(produk.getNama_produk()));
        etDeskripsiProduk.setText(String.valueOf(produk.getDeskripsi_produk()));
        spKategoriProduk.setSelection(adKategori.getPosition(String.valueOf(produk.getKategori())));
        etHargaProduk.setText(String.valueOf(produk.getHarga()));
        etStokProduk.setText(String.valueOf(produk.getStok()));

        btnBatalUpdateProduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBatalUpdate = new Intent(getBaseContext(), DaftarProdukActivity.class);
                startActivity(intentBatalUpdate);
            }
        });

        btnUpdateProduk.setOnClickListener(new View.OnClickListener() {
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
                dbProduk.updateProduk(receivedProdukId, getApplicationContext(), produk);
                dbProduk.close();
                finish();

                Intent intentOkeProduk = new Intent(getBaseContext(), DaftarProdukActivity.class);
                startActivity(intentOkeProduk);
            }

        });
    }
}
