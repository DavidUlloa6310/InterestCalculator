package com.example.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    public static String SHARED_PREF = "sharedPrefs";
    public static String KEY = "currency";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);
        sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void dollarClick(View view) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY, "\u0024");
        editor.apply();
    }

    public void euroClick(View view) {
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY, "\u20ac");
        editor.apply();
    }

    public void yenClick(View view) {
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(KEY, "\u00A5");
        editor.apply();
    }

}