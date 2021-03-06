package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class Z3_ZeitarbeiterActivity extends AppCompatActivity {

    private Spinner ZeitarbeiterSpinner;
    private String auswahlZeitarbeiter;


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z3_zeitarbeiter);
        IntroductionActivity.Controller.setActivity_Z3();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.materialeinkauf_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText(getString(R.string.Rundebla) + String.valueOf(IntroductionActivity.Controller.getRunde() + 1));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

        //Je nach Sub-Zufall die Ausgabe des richtigen Strings/Info-Texts
        TextView z3Zeitarbeiter_info_textview = (TextView) findViewById(R.id.z3Zeitarbeiter_info_textview);
        try {
            switch (IntroductionActivity.Controller.getZeitarbeiterAktuellerAuftrag()){
                case "Geselle": {
                    z3Zeitarbeiter_info_textview.setText(R.string.z3Geselle_info_textview);
                    break;
                }
                case "Praktikant": {
                    z3Zeitarbeiter_info_textview.setText(R.string.z3Praktikant_info_textview);
                    break;
                }
                case "Lehrling": {
                    z3Zeitarbeiter_info_textview.setText(R.string.z3Lehrling_info_textview);
                    break;
                }
                case "Meister": {
                    z3Zeitarbeiter_info_textview.setText(R.string.z3Meister_info_textview);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToZeitarbeiterSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoZeitarbeiterSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }


    /**
     * Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
     */
    public void addItemsToZeitarbeiterSpinner(){

        ZeitarbeiterSpinner = (Spinner) findViewById(R.id.zeitarbeiter_spinner);

        ArrayAdapter Zeitarbeiter_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.zeitarbeiter_spinner_array,
                android.R.layout.simple_spinner_item);

        ZeitarbeiterSpinner.setAdapter(Zeitarbeiter_spinner_adapter);
    }


    /**
     * Methode um dem Spinner einen Listener hinzuzufuegen
     */
    public void addListenertoZeitarbeiterSpinner(){

        ZeitarbeiterSpinner = (Spinner) findViewById(R.id.zeitarbeiter_spinner);

        ZeitarbeiterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             *
             * @param parent
             * @param view
             * @param pos
             * @param l
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInZeitarbeiterSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInZeitarbeiterSpinner.split("\\(");
                auswahlZeitarbeiter = separated[0].trim();
            }

            /**
             *
             * @param adapterView
             */
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
    public void goToNextActivity (View view) throws Exception {

        //Methodenaufruf von Controller um Spinner Auswahl zu setzen und Ueberpruefung ob ein anderer Wert als vorher gewaehlt wurde
        if (IntroductionActivity.Controller.getZeitarbeiterAktuellerAuftrag().equals(auswahlZeitarbeiter)) {
            Toast toast = Toast.makeText(this, "Diese Option ist leider nicht mehr verfügbar", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            IntroductionActivity.Controller.setZeitarbeiterNeu(auswahlZeitarbeiter);

            Intent intent = new Intent(this, BerechnungActivity.class);
            startActivity(intent);
            finish();
        }
    }

}
