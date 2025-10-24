package com.example.odchudzanie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {



    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        boolean hasData = prefs.contains("age");



        if (!hasData) {
             Intent intent = new Intent(this, SetupActivity.class);
            startActivity(intent);
             finish();
        }


        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);

        // open drawer on hamburger click
        toolbar.setNavigationOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        // handle menu item clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_calendar) {
                //startActivity(new Intent(this, CalendarActivity.class));
            } else if (id == R.id.nav_settings) {
                //startActivity(new Intent(this, SettingsActivity.class));
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }
}