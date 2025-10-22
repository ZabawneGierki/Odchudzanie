package com.example.odchudzanie;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

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

    }
}