package com.camilaBarahona.pocketsave.menuHome;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.camilaBarahona.pocketsave.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomeMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private NavigationView navigationView;
    MenuItem prevMenuItem;
    BottomNavigationView bottomBar;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
        this.setTitle("Menú Principal");
        viewPager = (ViewPager) findViewById(R.id.vp_horizontal);
        viewPager.setOffscreenPageLimit(100);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new GastosFragment());
        adapter.addFragment(new RecordatoriosFragment());
        adapter.addFragment(new LogoutFragment());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        bottomBar = findViewById(R.id.bottom_navigation_id);

        bottomBar.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.myhome:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.gastos:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.recordatorios:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.cerrarSesion:
                                    viewPager.setCurrentItem(3);
                                    break;
                        }
                        return false;
                    }
                });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomBar.getMenu().getItem(0).setChecked(false);
                }
                bottomBar.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomBar.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.myhome) {
            viewPager.setCurrentItem(0);
            Intent intent = new Intent(HomeMenu.this, HomeFragment.class);
            startActivity(intent);
        }
        return false;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }
    }

}
