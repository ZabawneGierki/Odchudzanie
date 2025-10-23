package com.example.odchudzanie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;


public class SetupActivity extends AppCompatActivity {
    EditText ageInput, weightInput, heightInput;
    Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        ageInput = findViewById(R.id.ageInput);
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        genderSpinner = findViewById(R.id.genderSpinner);
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> saveUserData());
    }

    private void saveUserData() {
        int age = Integer.parseInt(ageInput.getText().toString());
        float weight = Float.parseFloat(weightInput.getText().toString());
        float height = Float.parseFloat(heightInput.getText().toString());
        String gender = genderSpinner.getSelectedItem().toString();

        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("age", age);
        editor.putFloat("weight", weight);
        editor.putFloat("height", height);
        editor.putString("gender", gender);
        editor.apply();

        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
