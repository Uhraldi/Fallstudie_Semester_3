package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class BestellzusammenfassungActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestellzusammenfassung);
        IntroductionActivity.Controller.setActivity_Bestellzusammenfassung();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.bestellzsmfassung_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText("Runde: " + (String.valueOf((IntroductionActivity.Controller.getRunde()))));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));


        //Verknuepfen von UI-Elementen mit Java-Klasse und Aufrufen von Controller-Methoden zum Anzeigen der Auftragspositionens
        TextView personalwesen_output = (TextView) findViewById(R.id.personalwesen_output);
        //personalwesen_output.setText(IntroductionActivity.Controller.getPersonalwesen()); TODO: sobald in Controller, wie Anzeigen?

        TextView zeitarbeiter_output = (TextView) findViewById(R.id.zeitarbeiter_output);
        try {
            zeitarbeiter_output.setText(IntroductionActivity.Controller.getZeitarbeiterAktuellerAuftrag());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView forschung_output = (TextView) findViewById(R.id.forschung_output);
        try {
            forschung_output.setText(IntroductionActivity.Controller.getForschungAktuellerAuftrag());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView marketing_output = (TextView) findViewById(R.id.marketing_output);
        try {
            marketing_output.setText(IntroductionActivity.Controller.getMarketingAktuellerAuftrag());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView armband_output = (TextView) findViewById(R.id.armband_output);
        try {
            armband_output.setText(IntroductionActivity.Controller.getArmbandAktuellerAuftrag());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView uhrwerk_output = (TextView) findViewById(R.id.uhrwerk_output);
        try {
            uhrwerk_output.setText(IntroductionActivity.Controller.getUhrwerkAktuellerAuftrag());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView gehaeuse_output = (TextView) findViewById(R.id.gehaeuse_output);
        try {
            gehaeuse_output.setText(IntroductionActivity.Controller.getGehaeuseAktuellerAuftrag());
        } catch (Exception e) {
            e.printStackTrace();

        }
        TextView bezahlart_output = (TextView) findViewById(R.id.bezahlart_output);
        try {
            bezahlart_output.setText(IntroductionActivity.Controller.getBezahlartAktuellerAuftrag());
        } catch (Exception e) {
            e.printStackTrace();
        }


        TextView produktionsvolumen_output = (TextView) findViewById(R.id.produktionsvolumen_output);
        produktionsvolumen_output.setText(String.valueOf(IntroductionActivity.Controller.getProduktionsvolumen()));

        TextView verkaufspreis_output = (TextView) findViewById(R.id.verkaufspreis_output);
        verkaufspreis_output.setText(String.valueOf(IntroductionActivity.Controller.getVerkaufspreis()));

        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getGesamtkosten()));


    }


    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
    public void goToNextActivity(View view) throws Exception {

        Intent z1 = new Intent(this, Z1_ArmbandActivity.class);
        Intent z2 = new Intent(this, Z2_GehaeuseActivity.class);
        Intent z3 = new Intent(this, Z3_ZeitarbeiterActivity.class);
        Intent keinZufall = new Intent(this, BerechnungActivity.class);

        //Abfrage ob Zufall Z1-Z3 eingetreten ist und entsprechende Weiterleitung
        if (IntroductionActivity.Controller.isZufall1()){
            startActivity(z1);
        } else if (IntroductionActivity.Controller.isZufall2()){
            startActivity(z2);
        } else if (IntroductionActivity.Controller.isZufall3()){
            startActivity(z3);
        } else {
            startActivity(keinZufall);
        }

        finish();
    }
}
