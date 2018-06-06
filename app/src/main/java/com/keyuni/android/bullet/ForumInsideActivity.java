package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForumInsideActivity extends AppCompatActivity {

    Button btnBalas, btnBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_keuangan);
        btnBalas = findViewById(R.id.btnFIBalas);
        btnBatal= findViewById(R.id.btnFIBatal);

        btnBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCatKeuangan= new Intent(getBaseContext(), Forum.class);
                startActivity(intentCatKeuangan);
            }

        });

        btnBalas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentCatKeuangan= new Intent(getBaseContext(), Forum.class);
                startActivity(intentCatKeuangan);
            }

        });
    }
}
