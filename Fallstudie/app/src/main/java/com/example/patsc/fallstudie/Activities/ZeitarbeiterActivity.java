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

import com.example.patsc.fallstudie.R;

public class ZeitarbeiterActivity extends AppCompatActivity {

    private Spinner ZeitarbeiterSpinner;
    private String auswahlZeitarbeiter;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zeitarbeiter);
        IntroductionActivity.Controller.setActivity_Zeitarbeiter();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.personalwesen_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText("Runde: " + (String.valueOf((IntroductionActivity.Controller.getRunde()))));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

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


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToZeitarbeiterSpinner(){

        ZeitarbeiterSpinner = (Spinner) findViewById(R.id.zeitarbeiter_spinner);

        ArrayAdapter Zeitarbeiter_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.zeitarbeiter_spinner_array,
                android.R.layout.simple_spinner_item);

        ZeitarbeiterSpinner.setAdapter(Zeitarbeiter_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoZeitarbeiterSpinner(){

        ZeitarbeiterSpinner = (Spinner) findViewById(R.id.zeitarbeiter_spinner);

        ZeitarbeiterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInZeitarbeiterSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInZeitarbeiterSpinner.split("\\(");
                auswahlZeitarbeiter = separated[0].trim();
            }

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

        //Methodenaufruf von Controller um Spinner Auswahl zu setzen
        IntroductionActivity.Controller.setZeitarbeiterAktuell(auswahlZeitarbeiter);
        Intent intent = new Intent(this, ForschungActivity.class);
        finish();
        startActivity(intent);
    }

}
