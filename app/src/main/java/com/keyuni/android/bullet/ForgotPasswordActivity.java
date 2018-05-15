package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgotPasswordActivity extends AppCompatActivity {

    Button btnKirimPasswordBaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnKirimPasswordBaru = findViewById(R.id.btnKirimPassBaru);

        btnKirimPasswordBaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentLogin = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intentLogin);
            }

        });
    }
}
