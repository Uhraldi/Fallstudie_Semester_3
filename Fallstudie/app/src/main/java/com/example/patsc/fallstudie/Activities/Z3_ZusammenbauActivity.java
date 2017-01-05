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

public class Z3_ZusammenbauActivity extends AppCompatActivity {

    private Spinner ZusammenbauSpinner;
    private String auswahlZusammenbau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z3_zusammenbau);
        IntroductionActivity.model.setActivity_Z3();

        //Je nach Sub-Zufall die Ausgabe des richtigen Strings/Info-Texts
        TextView z3zusammenbau_info_textview = (TextView) findViewById(R.id.z3zusammenbau_info_textview);
        switch (IntroductionActivity.model.getGehaeuse()){
            case "Deutschland": {
                z3zusammenbau_info_textview.setText(R.string.z3deutschland_info_textview);
                break;
            }
            case "Asien": {
                z3zusammenbau_info_textview.setText(R.string.z3asien_info_textview);
                break;
            }
            case "Osteuropa": {
                z3zusammenbau_info_textview.setText(R.string.z3osteuropa_info_textview);
                break;
            }
            case "Schweiz": {
                z3zusammenbau_info_textview.setText(R.string.z3schweiz_info_textview);
                break;
            }
        }

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToZusammenbauSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoZusammenbauSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.model.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.model.getVarKosten()));

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
                String ItemSelectedInZusammenbauSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInZusammenbauSpinner.split("\\(");
                auswahlZusammenbau = separated[0].trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {

        //Methodenaufruf von Model um Spinner Auswahl zu setzen
        if(IntroductionActivity.model.getZusammenbau().equals(auswahlZusammenbau)) {
            Toast toast = Toast.makeText(this, "Diese Option geht leider nicht mehr", Toast.LENGTH_SHORT);
        } else {
            IntroductionActivity.model.setZusammenbauNeu(auswahlZusammenbau);
        }

        Intent intent = new Intent(this, BerechnungActivity.class);
        finish();
        startActivity(intent);
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E6_WasserdichtheitActivity.class);
        startActivity(intent);
    }*/
}
