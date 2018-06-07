package com.keyuni.android.bullet;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        /*
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        tabLayout.getTabAt(0).setIcon(R.drawable.profil);
        tabLayout.getTabAt(1).setIcon(R.drawable.chat_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.shop_icon);
        */

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_user:
                        Intent intent0 = new Intent(MainActivity.this, ProfilActivity.class);
                        startActivity(intent0);
                        break;

                    case R.id.nav_chat:
                        Intent intent1 = new Intent(MainActivity.this, Forum.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav_shop:
                        Intent intent2 = new Intent(MainActivity.this, InfoUsahaActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav_bounty:
                        Intent intent3 = new Intent(MainActivity.this, PeminjamanActivity.class);
                        startActivity(intent3);
                        break;

                    case R.id.nav_cheque:
                        Intent intent4 = new Intent(MainActivity.this, CatatanKeuanganActivity.class);
                        startActivity(intent4);
                        break;
                }


                return false;
            }
        });


    /*
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }*/
    }
}
