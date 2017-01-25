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

public class ArmbandActivity extends AppCompatActivity {

    String auswahlArmband;
    private Spinner ArmbandSpinner;


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_armband);
        IntroductionActivity.Controller.setActivity_Armband();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.materialeinkauf_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText("Runde: " + (String.valueOf((IntroductionActivity.Controller.getRunde()))));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

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


    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
    public void goToNextActivity (View view)throws Exception {

        //Methodenaufruf von Controller um Spinner Auswahl zu setzen
        IntroductionActivity.Controller.setArmband(auswahlArmband);

        Intent intent = new Intent(this, UhrwerkActivity.class);
        startActivity(intent);
        finish();
    }


}


