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


public class ForschungActivity extends AppCompatActivity {

    private Spinner ForschungSpinner;
    String auswahlForschung;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forschung);
        IntroductionActivity.Controller.setActivity_Forschung();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.investition_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText("Runde: " + (String.valueOf((IntroductionActivity.Controller.getRunde()))));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
          addItemsToForschungSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoForschungSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

        }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToForschungSpinner(){

        ForschungSpinner = (Spinner) findViewById(R.id.forschung_spinner);

        ArrayAdapter forschung_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.forschung_spinner_array,
                android.R.layout.simple_spinner_item);

        ForschungSpinner.setAdapter(forschung_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoForschungSpinner(){

        ForschungSpinner = (Spinner) findViewById(R.id.forschung_spinner);

        ForschungSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInForschungSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInForschungSpinner.split("\\(");
                auswahlForschung = separated[0].trim();
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

        //Methodenaufruf von Controller um Forschungsauswahl zu setzen
        IntroductionActivity.Controller.setForschung(auswahlForschung);

        Intent intent = new Intent(this, MarketingActivity.class);
        startActivity(intent);
        finish();
    }


}

