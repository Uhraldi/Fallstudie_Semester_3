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

public class UhrwerkActivity extends AppCompatActivity {

    private Spinner UhrwerkSpinner;
    String auswahlUhrwerk;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_uhrwerk);
        IntroductionActivity.Controller.setActivity_Uhrwerk();

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
        addItemsToUhrwerkSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoUhrwerkSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToUhrwerkSpinner(){

        UhrwerkSpinner = (Spinner) findViewById(R.id.uhrwerk_spinner);

        ArrayAdapter uhrwerk_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.uhrwerk_spinner_array,
                android.R.layout.simple_spinner_item);

        UhrwerkSpinner.setAdapter(uhrwerk_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoUhrwerkSpinner(){

        UhrwerkSpinner = (Spinner) findViewById(R.id.uhrwerk_spinner);

        UhrwerkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInUhrwerkSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInUhrwerkSpinner.split("\\(");
                auswahlUhrwerk = separated[0].trim();
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
        IntroductionActivity.Controller.setUhrwerkAktuell(auswahlUhrwerk);

        Intent intent = new Intent(this, GehaeuseActivity.class);
        finish();
        startActivity(intent);
    }

}
