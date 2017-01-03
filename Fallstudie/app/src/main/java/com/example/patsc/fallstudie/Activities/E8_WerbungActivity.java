package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.patsc.fallstudie.R;

public class E8_WerbungActivity extends AppCompatActivity {

    private Spinner WerbungSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e8_werbung);

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToWerbungSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoWerbungSpinner();

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToWerbungSpinner(){

        WerbungSpinner = (Spinner) findViewById(R.id.werbung_spinner);

        ArrayAdapter werbung_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.werbung_spinner_array,
                android.R.layout.simple_spinner_item);

        //werbungSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        WerbungSpinner.setAdapter(werbung_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoWerbungSpinner(){

        WerbungSpinner = (Spinner) findViewById(R.id.werbung_spinner);

        WerbungSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInWerbungSpinner = parent.getItemAtPosition(pos).toString();    //speichert den gewaehlten Wert in einem String
                //der weitergegeben werden muss...
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {
        Intent intent = new Intent(this, E9_KaufvolumenActivity.class);
        finish();
        startActivity(intent);
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E7_ZusammenbauActivity.class);
        startActivity(intent);
    }*/
}
