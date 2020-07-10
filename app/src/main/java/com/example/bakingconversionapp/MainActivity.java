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

import static android.R.layout;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner ingredients = findViewById(R.id.Ingredient);
        final ArrayAdapter<String> liquidUnits;
        final ArrayAdapter<String> dryUnits;
        List<String> liquidUnitsContent;
        List<String> dryUnitsContent;
        liquidUnitsContent = new ArrayList<String>();
        dryUnitsContent = new ArrayList<String>();


        liquidUnitsContent.add("mL");
        dryUnitsContent.add("g");


        liquidUnits = new ArrayAdapter<String>(this, layout.simple_dropdown_item_1line, liquidUnitsContent);
        dryUnits =  new ArrayAdapter<String>(this, layout.simple_dropdown_item_1line, dryUnitsContent);

        ingredients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Spinner measurement = findViewById(R.id.units);
                if(arg2 == 4)
                {
                    measurement.setAdapter(liquidUnits);
                    liquidUnits.setDropDownViewResource(layout.simple_dropdown_item_1line);
                }
                else
                {
                    measurement.setAdapter(dryUnits);
                    dryUnits.setDropDownViewResource(layout.simple_dropdown_item_1line);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }

        });

        Spinner chooseOption = findViewById(R.id.selectConvertType);
        chooseOption.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                if(arg2 == 2)
                {
                    Intent intent = new Intent(getApplicationContext(), ImperialtoMetric.class);
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


    }


    public void ChooseSelection(View view)
    {
        Spinner ingredients = findViewById(R.id.Ingredient);
        Spinner measurement = findViewById(R.id.units);
        String measurementType = measurement.getSelectedItem().toString();
        String ingredientType = ingredients.getSelectedItem().toString();

        switch(ingredientType)
        {
            case "Flour":
                if(measurementType.equals("g"))
                {
                    convertGramsToCupsFlour(view);
                }

                break;
            case "Liquid/Wet":
                if(measurementType.equalsIgnoreCase("mL"))
                {
                    convertMLToCups(view);
                }

                break;
            case "Raw Sugar":
                if(measurementType.equals("g"))
                {
                    convertToCupsRawSugar(view);
                }
            case "Brown Sugar":
                {
                    convertToCupsBrownSugar(view);
                }
                break;
            case "Baking Powder":
            {
                convertToTablespoonTeaspoonBakingPowder(view);
                break;
            }
            case "Baking Soda":
                convertToTablespoonTeaspoonBakingSoda(view);
                break;
            default:
                TextView textView = (TextView) findViewById(R.id.Output);
                textView.setText("");
                textView.append("You've selected something else, it has no functionality yet");
                textView.setVisibility(View.VISIBLE);
                break;
        }
    }



    public void convertGramsToCupsFlour(View view)
    {

        TextView textView = (TextView) findViewById(R.id.input);
        String textVal = textView.getText().toString();
        if(!textVal.equals(""))
        {
            double initialVal = Double.parseDouble(textVal);
            int numCups = (int)(initialVal / 125);
            double leftOver = initialVal % 125;
            int numHalfCups = (int)(leftOver / 62.5);
            leftOver %= 62.5;
            int numThirdCups = (int)(leftOver / 41.67);
            leftOver %= 41.67;
            int numQuarterCups = (int)(leftOver / 31.25);
            leftOver %= 31.25;


            displayCupResult(view, numCups, numHalfCups, numThirdCups, numQuarterCups, leftOver);
            convertGramsToTableSpoonsFlour(view, leftOver);

        }
    }


    public void convertGramsToTableSpoonsFlour(View view, double remaining)
    {
        int tableSpoons = (int)(remaining / 7.8125);
        double leftover = remaining % 7.8125;
        int teaSpoons = (int)(leftover / 2.604167);
        leftover %= 2.604167;
        int halfTsp = (int)(leftover/1.3020833);
        leftover %= 1.3020833;
        double quarterTsp = leftover/0.651041;

        if(quarterTsp <= 0.4)
        {
            quarterTsp = 0.0;
        }
        else if(quarterTsp > 0.4 && quarterTsp <0.8)
        {
            quarterTsp = 0.5;
        }
        else
        {
            quarterTsp = 1;
        }
        leftover %= 0.6510416667;

        displayTablespoonsTeaspoons(view, tableSpoons, teaSpoons, halfTsp, quarterTsp, leftover);

    }


    public void convertMLToCups(View view)
    {
        TextView textView = (TextView) findViewById(R.id.input);
        String textVal = textView.getText().toString();
        if(!textVal.equals(""))
        {
            double initialVal = Double.parseDouble(textVal);
            int numCups = (int)(initialVal /240);
            double leftOver = initialVal % 240;
            int numHalfCups = (int)(leftOver / 120);
            leftOver %= 120;
            int numThirdCups = (int)(leftOver / 80);
            leftOver %= 80;
            int numQuarterCups = (int)(leftOver / 60);
            leftOver %= 60;

            displayCupResult(view, numCups, numHalfCups, numThirdCups, numQuarterCups, leftOver);
            convertMLtoTblspn(view, leftOver);
        }
    }


    public void convertMLtoTblspn(View view, double remaining)
    {
        int tableSpoons = (int)(remaining / 15);
        double leftover = remaining % 15;
        int teaSpoons = (int)(leftover / 5);
        leftover %= 5;
        int halfTsp = (int)(leftover/2.5);
        leftover %= 2.5;
        double quarterTsp = leftover/1.25;
        leftover %= 1.25;
        if(leftover >= 0.7)
        {
            quarterTsp += 1;
            leftover -= 1.25;
        }

        displayTablespoonsTeaspoons(view, tableSpoons, teaSpoons, halfTsp, quarterTsp, leftover);
    }



    public void convertToCupsRawSugar(View view)
    {
        TextView textView = (TextView) findViewById(R.id.input);
        String textVal = textView.getText().toString();
        if(!textVal.equals(""))
        {
            double initialVal = Double.parseDouble(textVal);
            int cups = (int)(initialVal /250);
            double leftOver = initialVal % 250;
            int halfCups = (int)(leftOver / 125);
            leftOver %= 125;
            int thirdCups = (int)(leftOver / 83.333);
            leftOver %= 83.3333;
            int fourthCups = (int)(leftOver / 62.5);
            leftOver %= 62.5;

            displayCupResult(view, cups, halfCups, thirdCups, fourthCups, leftOver);
            convertToTablespoonTeaspoonRawSugar(view, leftOver);

        }
    }

    public void convertToTablespoonTeaspoonRawSugar(View view, double remaining)
    {
        int tblspns = (int)(remaining / 15.625);
        double leftOver = remaining % 15.625;
        int tspns = (int)(leftOver /5.208333);
        leftOver %= 5.208333;
        int halfTspns = (int)(leftOver / 2.6041667);
        leftOver %= 2.6041667;
        int quarterTspns = (int)(leftOver / 1.3020833);
        leftOver %= 1.3020833;
        if(leftOver >= 0.7)
        {
            quarterTspns += 1;
            leftOver -= 1.3020833;
        }
        displayTablespoonsTeaspoons(view, tblspns, tspns, halfTspns, quarterTspns, leftOver);
    }

    public void convertToCupsBrownSugar(View view)
    {
        TextView textView = (TextView) findViewById(R.id.input);
        String textVal = textView.getText().toString();
        if(!textVal.equals(""))
        {
            double initialVal = Double.parseDouble(textVal);
            int cups = (int)(initialVal /220);
            double leftOver = initialVal % 220;
            int halfCups = (int)(leftOver / 110);
            leftOver %= 110;
            int thirdCups = (int)(leftOver / 73.333);
            leftOver %= 73.333;
            int fourthCups = (int)(leftOver / 55);
            leftOver %= 55;

            displayCupResult(view, cups, halfCups, thirdCups, fourthCups, leftOver);
            convertToTablespoonTeaspoonBrownSugar(view, leftOver);
            //convertToTablespoonTeaspoonRawSugar(view, leftOver);

        }
    }

    public void convertToTablespoonTeaspoonBrownSugar(View view, double remaining)
    {
        int tblspns = (int)(remaining / 13.75);
        double leftOver = remaining % 13.75;
        int tspns = (int)(leftOver /4.5833);
        leftOver %= 4.5833;
        int halfTspns = (int)(leftOver / 2.29167);
        leftOver %= 2.29167;
        int quarterTspns = (int)(leftOver / 1.145833);
        leftOver %= 1.145833;
        if(leftOver >= 0.7)
        {
            quarterTspns += 1;
            leftOver -= 1.1458333333;
        }
        displayTablespoonsTeaspoons(view, tblspns, tspns, halfTspns, quarterTspns, leftOver);
    }

    public void convertToTablespoonTeaspoonBakingPowder(View view)
    {
        TextView textView = (TextView) findViewById(R.id.input);
        String textVal = textView.getText().toString();

        if(!textVal.equals(""))

        {
            double initialVal = Double.parseDouble(textVal);
            int tblspns = (int) (initialVal / 14.38);
            double leftOver = initialVal % 14.38;
            int tspns = (int)(leftOver / 4.79);
            leftOver %= 4.79;
            int halfTspns = (int)(leftOver / 2.395);
            leftOver %= 2.395;
            int quarterTspns = (int)(leftOver / 1.1975);
            leftOver %= 1.1975;
            if(leftOver >= 0.7)
            {
                quarterTspns += 1;
                leftOver -= 1.1975;
            }
            TextView output = (TextView) findViewById(R.id.Output);
            output.setText("");
            displayTablespoonsTeaspoons(view, tblspns, tspns, halfTspns, quarterTspns, leftOver);

        }
    }

    public void convertToTablespoonTeaspoonBakingSoda(View view)
    {
        TextView textView = (TextView) findViewById(R.id.input);
        String textVal = textView.getText().toString();

        if(!textVal.equals(""))

        {
            double initialVal = Double.parseDouble(textVal);
            int tblspns = (int) (initialVal / 14.40);
            double leftOver = initialVal % 14.40;
            int tspns = (int)(leftOver /4.80);
            leftOver %= 4.80;
            int halfTspns = (int)(leftOver / 2.4);
            leftOver %= 2.4;
            int quarterTspns = (int)(leftOver / 1.2);
            leftOver %= 1.2;
            if(leftOver >= 0.7)
            {
                quarterTspns += 1;
                leftOver -= 1.2;
            }
            TextView output = (TextView) findViewById(R.id.Output);
            output.setText("");
            displayTablespoonsTeaspoons(view, tblspns, tspns, halfTspns, quarterTspns, leftOver);

        }
    }


    public void displayCupResult(View view, int numCups, int numHalfCups, int numThirdCups, int numQuarterCups, double left) {

        TextView textView = (TextView) findViewById(R.id.Output);
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
                String halfCups = Integer.toString(numHalfCups);
                textView.append(halfCups + " half cup\n");
            }
            else
            {
                String halfCups = Integer.toString(numHalfCups);
                textView.append(halfCups + " half cups\n");
            }
        }

        if(numThirdCups != 0)
        {
            if(numThirdCups == 1)
            {
                String thirdCups = Integer.toString(numThirdCups);
                textView.append(thirdCups + " third cup\n");
            }
            else
            {
                String thirdCups = Integer.toString(numThirdCups);
                textView.append(thirdCups + " third cups\n");
            }


        }
        if(numQuarterCups != 0)
        {
            if(numQuarterCups == 1)
            {
                String quarterCups = Integer.toString(numQuarterCups);
                textView.append(quarterCups + " quarter cup\n");
            }
            else
            {
                String quarterCups = Integer.toString(numQuarterCups);
                textView.append(quarterCups + " quarter cups\n");
            }
        }

        if (textView.getVisibility() == View.INVISIBLE) {
            textView.setVisibility(View.VISIBLE);
        }

    }

    public void displayTablespoonsTeaspoons(View view, int numTblspn, int numTsp, int numHalfTsp, double numQuarterTsp, double left)
    {
        TextView textView = (TextView) findViewById(R.id.Output);

        if(numTblspn != 0)
        {
            if(numTblspn == 1)
            {
                String tblspns = Integer.toString(numTblspn);
                textView.append(tblspns + " tablespoon\n");
            }
            else
            {
                String tblspns = Integer.toString(numTblspn);
                textView.append(tblspns + " tablespoons\n");
            }

        }
        if(numTsp != 0)
        {
            if(numTsp == 1)
            {
                String tspn = Integer.toString(numTsp);
                textView.append(tspn + " teaspoon\n");
            }
            else
            {
                String tspn = Integer.toString(numTsp);
                textView.append(tspn + " teaspoons\n");
            }

        }
        if(numHalfTsp != 0)
        {
            if(numHalfTsp == 1)
            {
                String halftsp = Integer.toString(numHalfTsp);
                textView.append(halftsp + " half teaspoon \n");
            }
            else
            {
                String halftsp = Integer.toString(numHalfTsp);
                textView.append(halftsp + " half teaspoons \n");
            }

        }
        if(numQuarterTsp != 0)
        {
            if(numQuarterTsp == 1)
            {
                @SuppressLint("DefaultLocale") String quartertsp = String.format("%.2f", numQuarterTsp);
                textView.append(quartertsp + " quarter teaspoon");
            }
            else
            {
                @SuppressLint("DefaultLocale") String quartertsp = String.format("%.1f", numQuarterTsp);
                textView.append(quartertsp + " quarter teaspoons");
            }

        }



        if(textView.getVisibility() == View.INVISIBLE)
        {
            textView.setVisibility(View.VISIBLE);
        }
    }




}

