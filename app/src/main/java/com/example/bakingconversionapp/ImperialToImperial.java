package com.example.bakingconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


public class ImperialToImperial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imperial_to_imperial);

        Spinner chooseOption = findViewById(R.id.itoiSelectConvertType);
        chooseOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if(arg2 == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else if(arg2 == 2)
                {
                    Intent intent = new Intent(getApplicationContext(), ImperialtoMetric.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

    public void ChooseSelection(View view)
    {

        Spinner inputMeasurement = findViewById(R.id.iToiUnits);
        String inputMeasurementType = inputMeasurement.getSelectedItem().toString();



        TextView input = (TextView) findViewById(R.id.iToiInput);
        String inputVal = input.getText().toString();
        if(!inputVal.equals(""))
        {
            Double amount = Double.parseDouble(inputVal);
            switch(inputMeasurementType)
            {
                case "cups":
                    convertFromCups(view, amount);
                    break;

                case "tablespoons":
                    convertFromTblspns(view, amount);
                    break;
                case "teaspoons":
                    convertFromTspns(view, amount);
                    break;
                default:
                    TextView textView = (TextView) findViewById(R.id.ItoMoutput);
                    textView.setText("");
                    textView.append("You've selected something else, it has no functionality yet");
                    textView.setVisibility(View.VISIBLE);
                    break;
            }
        }



    }

    @SuppressLint("DefaultLocale")
    public void convertFromCups(View view, double amount)
    {
        int numCups = (int)(amount / 1);
        double leftOver = amount % 1;
        int numHalfCups = (int)(leftOver / 0.5);
        leftOver %= 0.5;
        int numThirdCups = (int)(leftOver / 0.33);
        leftOver %= 0.33;
        int numQuarterCups = (int)(leftOver / 0.25);
        leftOver %= 0.25;

        int numTblspns = (int)(leftOver / 0.0625);
        leftOver %= 0.0625;

        int numTspns = (int)(leftOver / 0.0208);
        leftOver %= 0.0208;

        int numHalfTspns = (int)(leftOver / 0.010412);
        leftOver %= 0.010412;

        double numQuarterTspns = leftOver / 0.00521;
        leftOver %= 0.00521;

        TextView textView = (TextView) findViewById(R.id.itoiOutput);
        textView.setText("");
        if(numCups != 0)
        {
            if(numCups == 1)
            {
                textView.append(numCups + " cup\n");
            }
            else
            {
                textView.append(numCups + " cups\n");
            }
        }
        if(numHalfCups != 0)
        {
            if(numHalfCups == 1)
            {
                textView.append(numHalfCups + " half cup\n");

            }
            else
            {
                textView.append(numHalfCups + " half cups\n");

            }
        }
        if(numThirdCups != 0)
        {
            if(numThirdCups == 1)
            {
                textView.append(numThirdCups + " third cup\n");
            }
            else
            {
                textView.append(numThirdCups + " third cups\n");
            }
        }
        if(numQuarterCups != 0)
        {
            if(numQuarterCups == 1)
            {
                textView.append(numQuarterCups + " quarter cup\n");
            }
            else
            {
                textView.append(numQuarterCups + " quarter cups\n");
            }
        }
        if(numTblspns != 0)
        {
            if(numTblspns == 1)
            {
                textView.append(numTblspns + " tablespoon\n");

            }
            else
            {
                textView.append(numTblspns + " tablespoons\n");
            }

        }
        if(numTspns != 0)
        {
            if(numTspns == 1)
            {
                textView.append(numTspns + " teaspoon\n");
            }
            else
            {
                textView.append(numTspns + " teaspoons\n");
            }
        }
        if(numHalfTspns != 0)
        {
            if(numHalfTspns == 1)
            {
                textView.append(numHalfTspns + " half teaspoon\n");
            }
            else
            {
                textView.append(numHalfTspns + " half teaspoons\n");
            }
        }
        if(numQuarterTspns != 0)
        {
            if(numQuarterTspns == 1)
            {
                textView.append(String.format("%.2f", numQuarterTspns) + " quarter teaspoon\n");
            }
            else
            {
                textView.append(String.format("%.2f", numQuarterTspns) + " quarter teaspoons\n");
            }
        }
        textView.setVisibility(View.VISIBLE);
    }

    @SuppressLint("DefaultLocale")
    public void convertFromTblspns(View view, double amount)
    {
        int numCups = (int)(amount / 16);
        double leftOver = amount % 16;
        int numHalfCups = (int)(leftOver / 32);
        leftOver %= 32;
        int numThirdCups = (int)(leftOver / 48);
        leftOver %= 48;
        int numQuarterCups = (int)(leftOver / 64);
        leftOver %= 64;

        int numTblspns = (int)(leftOver / 1);
        leftOver %= 1;

        int numTspns = (int)(leftOver / 0.33);
        leftOver %= 0.33;

        int numHalfTspns = (int)(leftOver / 0.16666);
        leftOver %= 0.16666;

        double numQuarterTspns = leftOver / 0.08333;
        leftOver %= 0.08333;

        TextView textView = (TextView) findViewById(R.id.itoiOutput);
        textView.setText("");
        if(numCups != 0)
        {
            if(numCups == 1)
            {
                textView.append(numCups + " cup\n");
            }
            else
            {
                textView.append(numCups + " cups\n");
            }
        }
        if(numHalfCups != 0)
        {
            if(numHalfCups == 1)
            {
                textView.append(numHalfCups + " half cup\n");

            }
            else
            {
                textView.append(numHalfCups + " half cups\n");

            }
        }
        if(numThirdCups != 0)
        {
            if(numThirdCups == 1)
            {
                textView.append(numThirdCups + " third cup\n");
            }
            else
            {
                textView.append(numThirdCups + " third cups\n");
            }
        }
        if(numQuarterCups != 0)
        {
            if(numQuarterCups == 1)
            {
                textView.append(numQuarterCups + " quarter cup\n");
            }
            else
            {
                textView.append(numQuarterCups + " quarter cups\n");
            }
        }
        if(numTblspns != 0)
        {
            if(numTblspns == 1)
            {
                textView.append(numTblspns + " tablespoon\n");

            }
            else
            {
                textView.append(numTblspns + " tablespoons\n");
            }

        }
        if(numTspns != 0)
        {
            if(numTspns == 1)
            {
                textView.append(numTspns + " teaspoon\n");
            }
            else
            {
                textView.append(numTspns + " teaspoons\n");
            }
        }
        if(numHalfTspns != 0)
        {
            if(numHalfTspns == 1)
            {
                textView.append(numHalfTspns + " half teaspoon\n");
            }
            else
            {
                textView.append(numHalfTspns + " half teaspoons\n");
            }
        }
        if(numQuarterTspns != 0)
        {
            if(numQuarterTspns == 1)
            {
                textView.append(String.format("%.2f", numQuarterTspns) + " quarter teaspoon\n");
            }
            else
            {
                textView.append(String.format("%.2f", numQuarterTspns) + " quarter teaspoons\n");
            }
        }

        textView.setVisibility(View.VISIBLE);

    }


    @SuppressLint("DefaultLocale")
    public void convertFromTspns(View view, double amount)
    {
        int numCups = (int)(amount / 48);
        double leftOver = amount % 48;
        int numHalfCups = (int)(leftOver / 96);
        leftOver %= 96;
        int numThirdCups = (int)(leftOver / 144);
        leftOver %= 144;
        int numQuarterCups = (int)(leftOver / 192);
        leftOver %= 192;

        int numTblspns = (int)(leftOver / 3);
        leftOver %= 3;

        int numTspns = (int)(leftOver / 1);
        leftOver %= 1;

        int numHalfTspns = (int)(leftOver / 0.5);
        leftOver %= 0.5;

        double numQuarterTspns = leftOver / 0.25;
        leftOver %= 0.25;

        TextView textView = (TextView) findViewById(R.id.itoiOutput);
        textView.setText("");

        if(numCups != 0)
        {
            if(numCups == 1)
            {
                textView.append(numCups + " cup\n");
            }
            else
            {
                textView.append(numCups + " cups\n");
            }
        }
        if(numHalfCups != 0)
        {
            if(numHalfCups == 1)
            {
                textView.append(numHalfCups + " half cup\n");

            }
            else
            {
                textView.append(numHalfCups + " half cups\n");

            }
        }
        if(numThirdCups != 0)
        {
            if(numThirdCups == 1)
            {
                textView.append(numThirdCups + " third cup\n");
            }
            else
            {
                textView.append(numThirdCups + " third cups\n");
            }
        }
        if(numQuarterCups != 0)
        {
            if(numQuarterCups == 1)
            {
                textView.append(numQuarterCups + " quarter cup\n");
            }
            else
            {
                textView.append(numQuarterCups + " quarter cups\n");
            }
        }
        if(numTblspns != 0)
        {
            if(numTblspns == 1)
            {
                textView.append(numTblspns + " tablespoon\n");

            }
            else
            {
                textView.append(numTblspns + " tablespoons\n");
            }

        }
        if(numTspns != 0)
        {
            if(numTspns == 1)
            {
                textView.append(numTspns + " teaspoon\n");
            }
            else
            {
                textView.append(numTspns + " teaspoons\n");
            }
        }
        if(numHalfTspns != 0)
        {
            if(numHalfTspns == 1)
            {
                textView.append(numHalfTspns + " half teaspoon\n");
            }
            else
            {
                textView.append(numHalfTspns + " half teaspoons\n");
            }
        }
        if(numQuarterTspns != 0)
        {
            if(numQuarterTspns == 1)
            {
                textView.append(String.format("%.2f", numQuarterTspns) + " quarter teaspoon\n");
            }
            else
            {
                textView.append(String.format("%.2f", numQuarterTspns) + " quarter teaspoons\n");
            }
        }

        textView.setVisibility(View.VISIBLE);

    }


}