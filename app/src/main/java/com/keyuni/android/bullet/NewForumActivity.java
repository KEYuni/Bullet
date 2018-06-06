package com.keyuni.android.bullet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewForumActivity extends AppCompatActivity {

    EditText judul, kategori, deskripsi;
    Button btnPost, btnBatal;
    ImageView fotoForum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_forum);

        judul = findViewById(R.id.etNFJudul);
        kategori = findViewById(R.id.etNFKategori);
        deskripsi = findViewById(R.id.etNFDeskripsi);

        btnPost = findViewById(R.id.btnNFPost);
        btnBatal = findViewById(R.id.btnFIBatal);

        fotoForum = findViewById(R.id.ivNFffoto);


    }
}
