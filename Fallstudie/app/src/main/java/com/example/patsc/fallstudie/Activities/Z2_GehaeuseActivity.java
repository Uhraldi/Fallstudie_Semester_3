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

public class Z2_GehaeuseActivity extends AppCompatActivity {

    private Spinner GehaeuseSpinner;
    private String auswahlGehaeuse;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z2_gehaeuse);
        IntroductionActivity.Controller.setActivity_Z2();

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
        TextView z2gehaeuse_info_textiew = (TextView) findViewById(R.id.z2gehaeuse_info_textview);
        try {
            switch (IntroductionActivity.Controller.getGehaeuseAktuellerAuftrag()){
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
        } catch (Exception e) {
            e.printStackTrace();
        }

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


    /**
     * Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
     */
    public void addItemsToGehaeuseSpinner() {

        GehaeuseSpinner = (Spinner) findViewById(R.id.gehaeuse_spinner);

        ArrayAdapter gehaeuse_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.gehaeuse_spinner_array,
                android.R.layout.simple_spinner_item);

        GehaeuseSpinner.setAdapter(gehaeuse_spinner_adapter);
    }


    /**
     * Methode um dem Spinner einen Listener hinzuzufuegen
     */
    public void addListenertoGehaeuseSpinner() {

        GehaeuseSpinner = (Spinner) findViewById(R.id.gehaeuse_spinner);

        GehaeuseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             *
             * @param parent
             * @param view
             * @param pos
             * @param l
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInGehaeuseSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInGehaeuseSpinner.split("\\(");
                auswahlGehaeuse = separated[0].trim();
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
    public void goToNextActivity(View view) throws Exception {

        //Methodenaufruf von Controller um Spinner Auswahl zu setzen und Ueberpruefung ob anderer Wert als vorher gewaehlt wurde
        if(IntroductionActivity.Controller.getGehaeuseAktuellerAuftrag().equals(auswahlGehaeuse)) {
            Toast toast = Toast.makeText(this, "Diese Option ist leider nicht mehr verfügbar", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            IntroductionActivity.Controller.setGehaeuseNeu(auswahlGehaeuse);


            Intent z3 = new Intent(this, Z3_ZeitarbeiterActivity.class);
            Intent keinZufall = new Intent(this, BerechnungActivity.class);

            //Abfrage ob Zufall Z3 eingetreten ist und entsprechende Weiterleitung
            if (IntroductionActivity.Controller.isZufall3()) {
                startActivity(z3);
            } else {
                startActivity(keinZufall);
            }
            finish();
        }

    }

}