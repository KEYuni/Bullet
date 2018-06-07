package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import android.view.Menu;
import android.view.MenuItem;
=======
=======
>>>>>>> Stashed changes
import android.widget.Button;
import android.widget.TextView;

import com.keyuni.android.bullet.db.DbPeminjaman;
import com.keyuni.android.bullet.db.DbProduk;
import com.keyuni.android.bullet.model.Peminjaman;
import com.keyuni.android.bullet.model.Produk;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

public class CatatanPeminjamanActivity extends AppCompatActivity {

    private TextView tvjumlah_pinjam, tvjumlah_bayar, tvkodebayar;
    Button bayar;
    private Integer idPinjam, idUser, durasiPinjam;
    private DbPeminjaman dbpinjam;
    private Peminjaman pinjam;
    private int receivedPinjamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan_peminjaman);

<<<<<<< Updated upstream
<<<<<<< Updated upstream
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
                        Intent intent0 = new Intent(CatatanPeminjamanActivity.this, ProfilActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.nav_chat:
                        Intent intent1 = new Intent(CatatanPeminjamanActivity.this, Forum.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_shop:

                        Intent intent5 = new Intent(CatatanPeminjamanActivity.this, InfoUsahaActivity.class);
                        startActivity(intent5);
                        break;

                    case R.id.nav_bounty:
                        Intent intent3 = new Intent(CatatanPeminjamanActivity.this, PeminjamanActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_cheque:
                        Intent intent4 = new Intent(CatatanPeminjamanActivity.this, CatatanKeuanganActivity.class);
                        startActivity(intent4);
                        break;
                }


                return false;
            }
        });
=======
=======
>>>>>>> Stashed changes
        /*tvjumlah_pinjam = findViewById(R.id.tvJumPinjam);
        tvjumlah_bayar = findViewById(R.id.tvJumBayar);
        tvkodebayar = findViewById(R.id.tvKodeBayar);

        dbpinjam = new DbPeminjaman(this);
        dbpinjam.open();

        try{
            receivedPinjamId = getIntent().getIntExtra("id_pinjam", 1);

        } catch (Exception e){
            e.printStackTrace();
        }

        pinjam = dbpinjam.getPeminjaman(receivedPinjamId);
        //set field to this user data
        //idPinjam.equals(Integer.valueOf(pinjam.getId_pinjam()));
        //idUser.equals(Integer.valueOf(pinjam.getId_user()));
        //durasiPinjam.equals(Integer.valueOf(pinjam.getDurasi_pinjam()));
        tvjumlah_pinjam.setText(String.valueOf(pinjam.getJumlah_pinjam()));
        tvjumlah_bayar.setText(String.valueOf(pinjam.getJumlah_pinjam()));
        tvkodebayar.setText(String.valueOf(pinjam.getKode_bayar()));*/
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }
}
