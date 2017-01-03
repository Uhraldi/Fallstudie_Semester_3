package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.patsc.fallstudie.R;

public class E2_ArmbandActivity extends AppCompatActivity {

    String ItemSelectedInArmbandSpinner;
    private Spinner ArmbandSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //prüft ob Spinner bereits eine Auswahl hatte und stellt diese dann wieder her
 /*       if (savedInstanceState != null) {
            ArmbandSpinner.setSelection(savedInstanceState.getInt("ArmbandSpinner", 0));
        }*/


        setContentView(R.layout.activity_e2_armband);

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToArmbandSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoArmbandSpinner();

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToArmbandSpinner(){

        ArmbandSpinner = (Spinner) findViewById(R.id.armband_spinner);

        ArrayAdapter armband_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.armband_spinner_array,
                android.R.layout.simple_spinner_item);

        //armbandSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        ArmbandSpinner.setAdapter(armband_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoArmbandSpinner(){

        ArmbandSpinner = (Spinner) findViewById(R.id.armband_spinner);

        ArmbandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInArmbandSpinner = parent.getItemAtPosition(pos).toString();    //speichert den gewaehlten Wert in einem String
                //der weitergegeben werden muss...
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {
        Intent intent = new Intent(this, E3_UhrwerkActivity.class);

        //Methodenaufruf von Model um Designer zu setzen
        IntroductionActivity.model.setDesigner(ItemSelectedInArmbandSpinner);

        startActivity(intent);
        finish();
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*
    public void goToPreviousActivity (View view) {
        this.finish();
    }
*/



/*
    //speichert den aktuellen Zustand des Spinners (um wiederhergestellt werden zu können)
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("ArmbandSpinner", ArmbandSpinner.getSelectedItemPosition());
    }
*/

}


