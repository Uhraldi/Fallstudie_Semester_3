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

public class GehaeuseActivity extends AppCompatActivity {

    private Spinner GehaeuseSpinner;
    String auswahlGehaeuse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gehaeuse);
        IntroductionActivity.Controller.setActivity_Gehaeuse();

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToGehaeuseSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoGehaeuseSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToGehaeuseSpinner(){

        GehaeuseSpinner = (Spinner) findViewById(R.id.gehaeuse_spinner);

        ArrayAdapter gehaeuse_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.gehaeuse_spinner_array,
                android.R.layout.simple_spinner_item);

        GehaeuseSpinner.setAdapter(gehaeuse_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoGehaeuseSpinner(){

        GehaeuseSpinner = (Spinner) findViewById(R.id.gehaeuse_spinner);

        GehaeuseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInGehaeuseSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInGehaeuseSpinner.split("\\(");
                auswahlGehaeuse = separated[0].trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) throws Exception {

        //Methodenaufruf von Controller um Spinner Auswahl zu setzen
        IntroductionActivity.Controller.setGehaeuse(auswahlGehaeuse);

        Intent intent = new Intent(this, VersandartActivity.class);
        finish();
        startActivity(intent);
    }


}
