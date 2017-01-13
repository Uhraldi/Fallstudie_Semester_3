package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class WasserdichtheitActivity extends AppCompatActivity {

    private Spinner WasserdichtheitSpinner;
    private String auswahlWasserdichtheit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wasserdichtheit);
        //IntroductionActivity.Controller.setActivity_E6();
        //ToDO Activity E6 Wasserdichtheit raus...
        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToWasserdichtheitSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoWasserdichtheitSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToWasserdichtheitSpinner(){

        WasserdichtheitSpinner = (Spinner) findViewById(R.id.wasserdichtheit_spinner);

        ArrayAdapter wasserdichtheit_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.wasserdichtheit_spinner_array,
                android.R.layout.simple_spinner_item);

        //wasserdichtheitSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        WasserdichtheitSpinner.setAdapter(wasserdichtheit_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoWasserdichtheitSpinner(){

        WasserdichtheitSpinner = (Spinner) findViewById(R.id.wasserdichtheit_spinner);

        WasserdichtheitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInWasserdichtheitSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInWasserdichtheitSpinner.split("\\(");
                auswahlWasserdichtheit = separated[0].trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) throws Exception {

        //Methodenaufruf von Controller um Spinner Auswahl zu setzen
      //ToDo Wasserdichtheit ist ja raus...
      //  IntroductionActivity.Controller.setWasserdichtheit(auswahlWasserdichtheit);

        Intent intent = new Intent(this, ZeitarbeiterActivity.class);
        finish();
        startActivity(intent);
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, BezahlartActivity.class);
        startActivity(intent);
    }*/
}