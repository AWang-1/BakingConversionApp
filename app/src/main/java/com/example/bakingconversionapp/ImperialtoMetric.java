package com.example.bakingconversionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ImperialtoMetric extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imperialto_metric);



        Spinner chooseOption = findViewById(R.id.ItoMSelectConvertType);
        chooseOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if(arg2 == 1)
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else if(arg2 == 3)
                {
                    Intent intent = new Intent(getApplicationContext(), ImperialToImperial.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });


        Spinner ingredients = findViewById(R.id.ItoMIngredient);
        final ArrayAdapter<String> allOptions;
        final ArrayAdapter<String> tblspnBelow;
        final List<String> allOptionsContent;
        List<String> tblspnBelowContent;
        allOptionsContent = new ArrayList<String>();
        tblspnBelowContent = new ArrayList<String>();

        allOptionsContent.add("cups");
        allOptionsContent.add("half cups");
        allOptionsContent.add("third cups");
        allOptionsContent.add("fourth cups");
        allOptionsContent.add("tablespoons");
        allOptionsContent.add("teaspoons");
        allOptionsContent.add("half teaspoons");
        allOptionsContent.add("quarter teaspoons");

        tblspnBelowContent.add("tablespoons");
        tblspnBelowContent.add("teaspoons");
        tblspnBelowContent.add("half teaspoons");
        tblspnBelowContent.add("quarter teaspoons");



        tblspnBelow = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tblspnBelowContent);
        allOptions = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, allOptionsContent);

        ingredients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Spinner measurement = findViewById(R.id.ItoMUnits);
                if(arg2 == 0 || arg2 == 1)
                {
                    measurement.setAdapter(tblspnBelow);
                    tblspnBelow.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                }
                else
                {
                    measurement.setAdapter(allOptions);
                    allOptions.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });
    }


    public void ChooseSelection(View view)
    {
        Spinner ingredients = findViewById(R.id.ItoMIngredient);
        Spinner measurement = findViewById(R.id.ItoMUnits);
        String measurementType = measurement.getSelectedItem().toString();
        String ingredientType = ingredients.getSelectedItem().toString();

        switch(ingredientType)
        {
            case "Flour":
                flourtoGrams(view);
                break;
            case "Liquid/Wet":
                liquidsTomL(view);
                break;
            case "Raw Sugar":
                rawSugartoGrams(view);
                break;
            case "Brown Sugar":
                brownSugarToGrams(view);
                break;
            case "Baking Powder":
                bakingPowderToGrams(view);
                break;
            case "Baking Soda":
                bakingSodaToGrams(view);
                break;
            default:
                TextView textView = (TextView) findViewById(R.id.ItoMoutput);
                textView.setText("");
                textView.append("You've selected something else, it has no functionality yet");
                textView.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void liquidsTomL(View view)
    {
        TextView input = (TextView) findViewById(R.id.ItoMInput);
        Spinner unitSpinner = (Spinner) findViewById(R.id.ItoMUnits);
        String inputVal = input.getText().toString();
        String unit = unitSpinner.getSelectedItem().toString();

        if(!inputVal.equals(""))
        {
            double initial = Double.parseDouble(inputVal);
            double mL = 0.0;
            switch(unit)
            {
                case "cups":
                    mL = initial * 240;
                    displayWetResult(view, mL);
                    break;
                case "half cups":
                    mL = initial * 120;
                    displayWetResult(view, mL);
                    break;
                case "third cups":
                    mL = initial * 80;
                    displayWetResult(view, mL);
                    break;
                case "fourth cups":
                    mL = initial * 60;
                    displayWetResult(view, mL);
                    break;
                case "tablespoons":
                    mL = initial * 15;
                    displayWetResult(view, mL);
                    break;
                case "teaspoons":
                    mL = initial * 5;
                    displayWetResult(view, mL);
                    break;
                case "half teaspoons":
                    mL = initial * 2.5;
                    displayWetResult(view, mL);
                    break;
                case "quarter teaspoons":
                    mL = initial * 1.25;
                    displayWetResult(view, mL);
                    break;
                default:
                    break;
            }
        }
    }

    public void flourtoGrams(View view)
    {
        TextView input = (TextView) findViewById(R.id.ItoMInput);
        Spinner unitSpinner = (Spinner) findViewById(R.id.ItoMUnits);
        String inputVal = input.getText().toString();
        String unit = unitSpinner.getSelectedItem().toString();
        if(!inputVal.equals(""))
        {
            double initial = Double.parseDouble(inputVal);
            double numGrams = 0.0;
            switch(unit)
            {
                case "cups":
                    numGrams = 125 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "half cups":
                    numGrams = 62.5 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "third cups":
                    numGrams = 41.67 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "fourth cups":
                    numGrams = 31.25 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "tablespoons":
                    numGrams = 7.8125 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "teaspoons":
                    numGrams = 2.6041667 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "half teaspoons":
                    numGrams = 1.3020833 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "quarter teaspoons":
                    numGrams = 0.6510416667 * initial;
                    displayDryResult(view, numGrams);
                    break;
                default:
                    break;

            }

        }
    }

    public void rawSugartoGrams(View view)
    {
        TextView input = (TextView) findViewById(R.id.ItoMInput);
        Spinner unitSpinner = (Spinner) findViewById(R.id.ItoMUnits);
        String inputVal = input.getText().toString();
        String unit = unitSpinner.getSelectedItem().toString();
        if(!inputVal.equals(""))
        {
            double initial = Double.parseDouble(inputVal);
            double numGrams = 0.0;
            switch(unit)
            {
                case "cups":
                    numGrams = 250 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "half cups":
                    numGrams = 125 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "third cups":
                    numGrams = 83.33 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "fourth cups":
                    numGrams = 62.5 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "tablespoons":
                    numGrams = 15.625 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "teaspoons":
                    numGrams = 5.20833 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "half teaspoons":
                    numGrams = 2.6041667 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "quarter teaspoons":
                    numGrams = 1.3020833 * initial;
                    displayDryResult(view, numGrams);
                    break;
                default:
                    break;

            }

        }
    }

    public void brownSugarToGrams(View view)
    {
        TextView input = (TextView) findViewById(R.id.ItoMInput);
        Spinner unitSpinner = (Spinner) findViewById(R.id.ItoMUnits);
        String inputVal = input.getText().toString();
        String unit = unitSpinner.getSelectedItem().toString();
        if(!inputVal.equals(""))
        {
            double initial = Double.parseDouble(inputVal);
            double numGrams = 0.0;
            switch(unit)
            {
                case "cups":
                    numGrams = 220 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "half cups":
                    numGrams = 110 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "third cups":
                    numGrams = 73.333 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "fourth cups":
                    numGrams = 55 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "tablespoons":
                    numGrams = 13.75 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "teaspoons":
                    numGrams = 4.5833 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "half teaspoons":
                    numGrams = 2.29167 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "quarter teaspoons":
                    numGrams = 1.145833 * initial;
                    displayDryResult(view, numGrams);
                    break;
                default:
                    break;

            }

        }
    }


    public void bakingPowderToGrams(View view)
    {
        TextView input = (TextView) findViewById(R.id.ItoMInput);
        Spinner unitSpinner = (Spinner) findViewById(R.id.ItoMUnits);
        String inputVal = input.getText().toString();
        String unit = unitSpinner.getSelectedItem().toString();
        if(!inputVal.equals(""))
        {
            double initial = Double.parseDouble(inputVal);
            double numGrams = 0.0;
            switch(unit)
            {
                case "tablespoons":
                    numGrams = 14.38 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "teaspoons":
                    numGrams = 4.79 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "half teaspoons":
                    numGrams = 2.395 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "quarter teaspoons":
                    numGrams = 1.1975 * initial;
                    displayDryResult(view, numGrams);
                    break;
                default:
                    break;
            }

        }
    }

    public void bakingSodaToGrams(View view)
    {
        TextView input = (TextView) findViewById(R.id.ItoMInput);
        Spinner unitSpinner = (Spinner) findViewById(R.id.ItoMUnits);
        String inputVal = input.getText().toString();
        String unit = unitSpinner.getSelectedItem().toString();
        if(!inputVal.equals(""))
        {
            double initial = Double.parseDouble(inputVal);
            double numGrams = 0.0;
            switch(unit)
            {
                case "tablespoons":
                    numGrams = 14.40 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "teaspoons":
                    numGrams = 4.80 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "half teaspoons":
                    numGrams = 2.4 * initial;
                    displayDryResult(view, numGrams);
                    break;
                case "quarter teaspoons":
                    numGrams = 1.2 * initial;
                    displayDryResult(view, numGrams);
                    break;
                default:
                    break;
            }

        }
    }

    public void displayDryResult(View view, double numGrams)
    {
        TextView textView = (TextView) findViewById(R.id.ItoMoutput);
        textView.setText("");

        if(numGrams == 1)
        {
            @SuppressLint("DefaultLocale") String finalGrams = String.format("%.2f", numGrams);
            textView.append(finalGrams + " gram");
        }
        else
        {
            @SuppressLint("DefaultLocale") String finalGrams = String.format("%.2f", numGrams);
            textView.append(finalGrams + " grams");
        }

        //textView.append(Math.round(numGrams) + " grams");
        textView.setVisibility(View.VISIBLE);
    }

    public void displayWetResult(View view, double mL)
    {
        TextView output = (TextView) findViewById(R.id.ItoMoutput);
        output.setText("");
        @SuppressLint("DefaultLocale") String finalGrams = String.format("%.2f", mL);
        output.append(finalGrams + " mL");
        //textView.append(Math.round(numGrams) + " grams");
        output.setVisibility(View.VISIBLE);
    }
}