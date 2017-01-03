package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.patsc.fallstudie.R;

public class Z3_ZusammenbauActivity extends AppCompatActivity {
    private Spinner ZusammenbauSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z3_zusammenbau);

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToZusammenbauSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoZusammenbauSpinner();

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToZusammenbauSpinner(){

        ZusammenbauSpinner = (Spinner) findViewById(R.id.zusammenbau_spinner);

        ArrayAdapter zusammenbau_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.zusammenbau_spinner_array,
                android.R.layout.simple_spinner_item);

        //zusammenbauSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        ZusammenbauSpinner.setAdapter(zusammenbau_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoZusammenbauSpinner(){

        ZusammenbauSpinner = (Spinner) findViewById(R.id.zusammenbau_spinner);

        ZusammenbauSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInZusammenbauSpinner = parent.getItemAtPosition(pos).toString();    //speichert den gewaehlten Wert in einem String
                //der weitergegeben werden muss...
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {
        Intent intent = new Intent(this, BerechnungActivity.class);
        finish();
        startActivity(intent);
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E6_Wasserdichtheit.class);
        startActivity(intent);
    }*/
}
