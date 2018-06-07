package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CatatanPenjualanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_penjualan);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_user:
                        Intent intent0 = new Intent(CatatanPenjualanActivity.this, ProfilActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.nav_chat:
                        Intent intent1 = new Intent(CatatanPenjualanActivity.this, Forum.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_shop:

                        Intent intent5 = new Intent(CatatanPenjualanActivity.this, InfoUsahaActivity.class);
                        startActivity(intent5);
                        break;

                    case R.id.nav_bounty:
                        Intent intent3 = new Intent(CatatanPenjualanActivity.this, PeminjamanActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_cheque:
                        Intent intent4 = new Intent(CatatanPenjualanActivity.this, CatatanKeuanganActivity.class);
                        startActivity(intent4);
                        break;
                }


                return false;
            }
        });
    }
}
