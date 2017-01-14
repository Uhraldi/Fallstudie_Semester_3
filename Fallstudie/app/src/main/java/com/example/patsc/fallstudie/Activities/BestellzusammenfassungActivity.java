package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class BestellzusammenfassungActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestellzusammenfassung);
        IntroductionActivity.Controller.setActivity_Bestellzusammenfassung();

        //Verknuepfen von UI-Elementen mit Java-Klasse und Aufrufen von Controller-Methoden zum Anzeigen der Bestellpositionen
        TextView designer_auswahl_output_textview = (TextView) findViewById(R.id.designer_auswahl_output_textview);
        //designer_auswahl_output_textview.setText(IntroductionActivity.Controller.getForschung());

        TextView armband_auswahl_output_textview = (TextView) findViewById(R.id.armband_auswahl_output_textview);
        try {
            armband_auswahl_output_textview.setText(IntroductionActivity.Controller.getArmband());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView uhrwerk_auswahl_output_textview = (TextView) findViewById(R.id.uhrwerk_auswahl_output_textview);
        try {
            uhrwerk_auswahl_output_textview.setText(IntroductionActivity.Controller.getUhrwerk());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView gehaeuse_auswahl_output_textview = (TextView) findViewById(R.id.gehaeuse_auswahl_output_textview);
        try {
            gehaeuse_auswahl_output_textview.setText(IntroductionActivity.Controller.getGehaeuse());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView versandart_auswahl_output_textview = (TextView) findViewById(R.id.versandart_auswahl_output_textview);
        try {
            versandart_auswahl_output_textview.setText(IntroductionActivity.Controller.getBezahlart());
        } catch (Exception e) {
            e.printStackTrace();
        }

       /* TextView wasserdichtheit_auswahl_output_textview = (TextView) findViewById(R.id.wasserdichtheit_auswahl_output_textview);
        try {
            wasserdichtheit_auswahl_output_textview.setText(IntroductionActivity.Controller.getWasserdichtheit());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        TextView zusammenbau_auswahl_output_textview = (TextView) findViewById(R.id.zusammenbau_auswahl_output_textview);
        try {
            zusammenbau_auswahl_output_textview.setText(IntroductionActivity.Controller.getZeitarbeiter());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView werbung_auswahl_output_textview = (TextView) findViewById(R.id.werbung_auswahl_output_textview);
        try {
            werbung_auswahl_output_textview.setText(IntroductionActivity.Controller.getMarketing());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView kaufvolumen_auswahl_output_textview = (TextView) findViewById(R.id.kaufvolumen_auswahl_output_textview);
        kaufvolumen_auswahl_output_textview.setText(String.valueOf(IntroductionActivity.Controller.getKaufvolumen()));

        TextView verkaufspreis_auswahl_output_textview = (TextView) findViewById(R.id.verkaufspreis_auswahl_output_textview);
        verkaufspreis_auswahl_output_textview.setText(String.valueOf(IntroductionActivity.Controller.getVerkaufspreis()));




    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity(View view) throws Exception {

        Intent z1 = new Intent(this, Z1_ArmbandActivity.class);
        Intent z2 = new Intent(this, Z2_GehaeuseActivity.class);
        Intent z3 = new Intent(this, Z3_ZusammenbauActivity.class);
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
