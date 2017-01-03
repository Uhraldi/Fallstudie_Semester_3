package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.patsc.fallstudie.R;

public class E5_VersandartActivity extends AppCompatActivity {

    private Spinner VersandartSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e5_versandart);

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToVersandartSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoVersandartSpinner();

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToVersandartSpinner(){

        VersandartSpinner = (Spinner) findViewById(R.id.versandart_spinner);

        ArrayAdapter versandart_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.versandart_spinner_array,
                android.R.layout.simple_spinner_item);

        //versandartSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        VersandartSpinner.setAdapter(versandart_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoVersandartSpinner(){

        VersandartSpinner = (Spinner) findViewById(R.id.versandart_spinner);

        VersandartSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInVersandartSpinner = parent.getItemAtPosition(pos).toString();    //speichert den gewaehlten Wert in einem String
                //der weitergegeben werden muss...
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {
        Intent intent = new Intent(this, E6_Wasserdichtheit.class);
        finish();
        startActivity(intent);
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E4_GehaeuseActivity.class);
        startActivity(intent);
    }*/
}
