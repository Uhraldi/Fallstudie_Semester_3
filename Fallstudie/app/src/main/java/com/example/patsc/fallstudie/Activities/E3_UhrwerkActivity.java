package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.patsc.fallstudie.R;

public class E3_UhrwerkActivity extends AppCompatActivity {

    private Spinner UhrwerkSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //prüft ob Spinner bereits eine Auswahl hatte und stellt diese dann wieder her
/*        if (savedInstanceState != null) {
            UhrwerkSpinner.setSelection(savedInstanceState.getInt("ArmbandSpinner", 0));
        }*/

        setContentView(R.layout.activity_e3_uhrwerk);

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToUhrwerkSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoUhrwerkSpinner();

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToUhrwerkSpinner(){

        UhrwerkSpinner = (Spinner) findViewById(R.id.uhrwerk_spinner);

        ArrayAdapter uhrwerk_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.uhrwerk_spinner_array,
                android.R.layout.simple_spinner_item);

        //UhrwerkSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        UhrwerkSpinner.setAdapter(uhrwerk_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoUhrwerkSpinner(){

        UhrwerkSpinner = (Spinner) findViewById(R.id.uhrwerk_spinner);

        UhrwerkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInUhrwerkSpinner = parent.getItemAtPosition(pos).toString();    //speichert den gewaehlten Wert in einem String
                //der weitergegeben werden muss...
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {
        Intent intent = new Intent(this, E4_GehaeuseActivity.class);
        finish();
        startActivity(intent);
    }

/*
    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E2_ArmbandActivity.class);
        startActivity(intent);
    }

    //speichert den aktuellen Zustand des Spinners (um wiederhergestellt werden zu können)
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("ArmbandSpinner", UhrwerkSpinner.getSelectedItemPosition());
    }
*/


}
