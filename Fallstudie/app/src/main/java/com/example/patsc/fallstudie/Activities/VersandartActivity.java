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

public class VersandartActivity extends AppCompatActivity {

    private Spinner VersandartSpinner;
    String auswahlVersandart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_versandart);
        IntroductionActivity.Controller.setActivity_Versandart(); //ToDo: neu benannt, fehlt noch im Controller

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToVersandartSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoVersandartSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToVersandartSpinner(){

        VersandartSpinner = (Spinner) findViewById(R.id.versandart_spinner);

        ArrayAdapter versandart_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.versandart_spinner_array,
                android.R.layout.simple_spinner_item);

        VersandartSpinner.setAdapter(versandart_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoVersandartSpinner(){

        VersandartSpinner = (Spinner) findViewById(R.id.versandart_spinner);

        VersandartSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInVersandartSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInVersandartSpinner.split("\\(");
                auswahlVersandart = separated[0].trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) throws Exception {

        //Methodenaufruf von Controller um Spinner Auswahl zu setzen
        IntroductionActivity.Controller.setVersandart(auswahlVersandart);

        Intent intent = new Intent(this, ProduktionsvolumenActivity.class);
        finish();
        startActivity(intent);
    }

}
