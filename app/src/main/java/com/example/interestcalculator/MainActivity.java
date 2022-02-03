package com.example.interestcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
    }

    public void handleCheckBox(View view) {
        CheckBox checkBox = (CheckBox) view;
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        if (checkBox.isChecked()) {
            radioGroup.clearCheck();
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                radioGroup.getChildAt(i).setEnabled(false);
            }
        } else {
            for (int i = 0; i < radioGroup.getChildCount(); i++) {
                radioGroup.getChildAt(i).setEnabled(true);
            }
        }
    }

    public void calculateInterest(View view) {

        if (isEmpty()) {
            //Show Message
            return;
        }

        TextView principleTextBox = (TextView) findViewById(R.id.principleTextBox);
        double principle = Double.parseDouble(principleTextBox.getText().toString());
        TextView interestTextBox = (TextView) findViewById(R.id.interestTextBox);
        double interestPercent = Double.parseDouble(interestTextBox.getText().toString());
        double interest = interestPercent / 100.0;
        TextView yearTextBox = (TextView) findViewById(R.id.yearsTextBox);
        double years = Double.parseDouble(yearTextBox.getText().toString());

        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        boolean isContinous = checkBox.isChecked();

        double finalAmount;

        if (!isContinous) {
            RadioButton monthButton = (RadioButton) findViewById(R.id.monthButton);
            RadioButton fourMonthButton = (RadioButton) findViewById(R.id.fourMonthButton);
            RadioButton yearButton = (RadioButton) findViewById(R.id.yearButton);

            int periods;

            if (monthButton.isChecked()) {
                periods = 12;
            } else if (fourMonthButton.isChecked()) {
                periods = 3;
            } else {
                periods = 1;
            }

            finalAmount = principle * Math.pow((1 + (interest / periods)), periods * years);
        } else {
            finalAmount = principle * Math.exp(interest * years);
        }

        System.out.println(finalAmount);

    }

    public boolean isEmpty() {
        return false;
    }
}