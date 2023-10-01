package com.projectzero.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weight,heightFt,heightIn;
        Button btnCalc;
        TextView txtResult;
        LinearLayout bg;

        weight= findViewById(R.id.weight);
        heightFt= findViewById(R.id.heightFt);
        heightIn= findViewById(R.id.heightIn);
        btnCalc= findViewById(R.id.btnCalc);
        txtResult= findViewById(R.id.result);
        bg= findViewById(R.id.bg);

        btnCalc.setOnClickListener(view -> {
            int wt = Integer.parseInt(weight.getText().toString());
            int ft = Integer.parseInt(heightFt.getText().toString());
            int in = Integer.parseInt(heightIn.getText().toString());


            double totalInch = ft * 12 + in;
            double totalCm = totalInch * 2.53;
            double totalM = totalCm / 100;

            double bmi = wt / (totalM * totalM);

            if (bmi > 25) {
                txtResult.setText(" You are OverWeight!!");
                bg.setBackgroundColor(getResources().getColor(R.color.red));
            } else if (bmi < 18) {
                txtResult.setText("You are UnderWeight!!");
                bg.setBackgroundColor(getResources().getColor(R.color.orange));
            } else {
                txtResult.setText("You are Healthy!!");
                bg.setBackgroundColor(getResources().getColor(R.color.green));
            }
        });
    }
}