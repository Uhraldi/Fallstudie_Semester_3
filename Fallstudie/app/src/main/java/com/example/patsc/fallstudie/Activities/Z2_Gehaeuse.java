package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class Z2_Gehaeuse extends AppCompatActivity {

    private Spinner GehaeuseSpinner;
    private String auswahlGehaeuse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z2_gehaeuse);
        IntroductionActivity.model.setActivity_Z2();

        //Je nach Sub-Zufall die Ausgabe des richtigen Strings/Info-Texts
        TextView z2gehaeuse_info_textiew = (TextView) findViewById(R.id.z2gehaeuse_info_textview);
        switch (IntroductionActivity.model.getGehaeuse()){
            case "Glas": {
                z2gehaeuse_info_textiew.setText(R.string.z2glas_info_textview);
                break;
            }
            case "Holz": {
                z2gehaeuse_info_textiew.setText(R.string.z2holz_info_textview);
                break;
            }
            case "Kunststoff": {
                z2gehaeuse_info_textiew.setText(R.string.z2kunststoff_info_textview);
                break;
            }
            case "Metall": {
                z2gehaeuse_info_textiew.setText(R.string.z2metall_info_textview);
                break;
            }
        }

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToGehaeuseSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoGehaeuseSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.model.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.model.getVarKosten()));

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToGehaeuseSpinner() {

        GehaeuseSpinner = (Spinner) findViewById(R.id.gehaeuse_spinner);

        ArrayAdapter gehaeuse_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.gehaeuse_spinner_array,
                android.R.layout.simple_spinner_item);

        //gehaeuseSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        GehaeuseSpinner.setAdapter(gehaeuse_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoGehaeuseSpinner() {

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
    public void goToNextActivity(View view) {

        //Methodenaufruf von Model um Spinner Auswahl zu setzen
        if(IntroductionActivity.model.getGehaeuse().equals(auswahlGehaeuse)) {
            Toast toast = Toast.makeText(this, "Diese Option geht leider nicht mehr", Toast.LENGTH_SHORT);
        } else {
            IntroductionActivity.model.setGehaeuseNeu(auswahlGehaeuse);
        }

        Intent z3 = new Intent(this, Z3_ZusammenbauActivity.class);
        Intent keinZufall = new Intent(this, BerechnungActivity.class);

        //Abfrage ob Zufall Z3 eingetreten ist und entsprechende Weiterleitung
        if (IntroductionActivity.model.isZufall3()){
            startActivity(z3);
        }  else {
            startActivity(keinZufall);
        }

        finish();
    }

//Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E3_UhrwerkActivity.class);
        startActivity(intent);
    }*/


}