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

public class E2_ArmbandActivity extends AppCompatActivity {

    String auswahlArmband;
    private Spinner ArmbandSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //prüft ob Spinner bereits eine Auswahl hatte und stellt diese dann wieder her
 /*       if (savedInstanceState != null) {
            ArmbandSpinner.setSelection(savedInstanceState.getInt("ArmbandSpinner", 0));
        }*/


        setContentView(R.layout.activity_e2_armband);
        IntroductionActivity.Controller.setActivity_E2();

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToArmbandSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoArmbandSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

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
                String ItemSelectedInArmbandSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInArmbandSpinner.split("\\(");
                auswahlArmband = separated[0].trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view)throws Exception {

        //Methodenaufruf von Controller um Spinner Auswahl zu setzen
        IntroductionActivity.Controller.setArmband(auswahlArmband);

        Intent intent = new Intent(this, E3_UhrwerkActivity.class);
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


