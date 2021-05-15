package com.example.moneycounter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.moneycounter.databinding.ActivityMainBinding;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;

import static java.lang.Double.valueOf;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private ActivityMainBinding binding;
    private Double twenties;
    private Double tens;
    private Double fives;
    private Double ones;
    private Double quarters;
    private Double dimes;
    private Double nickles;
    private Double pennies;
    private Double other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.title;
        tv.setText(stringFromJNI());

        binding.button.setOnClickListener(v -> {
            getAMntOfMoney();
            binding.amnt.setText(String.format("%s", new DecimalFormat("#.##").format(calculateMoney(other, twenties, tens, fives, ones, quarters, dimes, nickles, pennies))));
        });
    }

    public native String stringFromJNI();
    public native Double calculateMoney(double other, double twenties, double tens,
                                        double fives, double ones, double quarters,
                                        double dimes, double nickles, double pennies);

    public void getAMntOfMoney() {
        try {
            other = valueOf(binding.rolledInput.getText().toString());
        } catch (NumberFormatException e) {
            other = 0.0;
        }

        try {
            twenties = valueOf(binding.twentyInput.getText().toString());
        } catch (NumberFormatException e) {
            twenties = 0.0;
        }

        try {
            tens = valueOf(binding.tenInput.getText().toString());
        } catch (NumberFormatException e) {
            tens = 0.0;
        }

        try {
            fives = valueOf(binding.fiveInput.getText().toString());
        } catch (NumberFormatException e) {
            fives = 0.0;
        }

        try {
            ones = valueOf(binding.oneInput.getText().toString());
        } catch (NumberFormatException e) {
            ones = 0.0;
        }

        try {
            quarters = valueOf(binding.quarterInput.getText().toString());
        } catch (NumberFormatException e) {
            quarters = 0.0;
        }

        try {
            dimes = valueOf(binding.dimeInput.getText().toString());
        } catch (NumberFormatException e) {
            dimes = 0.0;
        }

        try {
            nickles = valueOf(binding.nickleInput.getText().toString());
        } catch (NumberFormatException e) {
            nickles = 0.0;
        }
        try {
            pennies = valueOf(binding.pennyInput.getText().toString());
        } catch (NumberFormatException e) {
            pennies = 0.0;
        }
    }
}