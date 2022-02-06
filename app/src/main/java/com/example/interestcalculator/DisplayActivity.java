package com.example.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_display);

        SharedPreferences sharedPref = getSharedPreferences(SettingsActivity.SHARED_PREF, MODE_PRIVATE);
        String currency = sharedPref.getString(SettingsActivity.KEY, "\u0024");

        Intent intent = getIntent();
        double balance = intent.getDoubleExtra(MainActivity.BALANCE_MESSAGE, 0);
        DecimalFormat df = new DecimalFormat(currency + "#.##");

        TextView balanceTextView = (TextView) findViewById(R.id.balanceTextView);
        balanceTextView.setText(df.format(balance));
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}