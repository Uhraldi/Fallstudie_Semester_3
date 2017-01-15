package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        //Verknuepfen von UI-Elementen mit Java-Klasse und Aufrufen von Controller-Methoden zum Anzeigen der Auftragspositionens

        TextView personalwesen_output = (TextView) findViewById(R.id.personalwesen_output);
        //personalwesen_output.setText(IntroductionActivity.Controller.getPersonalwesen()); TODO

        TextView zeitarbeiter_output = (TextView) findViewById(R.id.zeitarbeiter_output);
        try {
            zeitarbeiter_output.setText(IntroductionActivity.Controller.getZeitarbeiter());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView forschung_output = (TextView) findViewById(R.id.forschung_output);
        try {
            forschung_output.setText(IntroductionActivity.Controller.getForschung());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView marketing_output = (TextView) findViewById(R.id.marketing_output);
        try {
            marketing_output.setText(IntroductionActivity.Controller.getMarketing());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView armband_output = (TextView) findViewById(R.id.armband_output);
        try {
            armband_output.setText(IntroductionActivity.Controller.getArmband());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView uhrwerk_output = (TextView) findViewById(R.id.uhrwerk_output);
        try {
            uhrwerk_output.setText(IntroductionActivity.Controller.getUhrwerk());
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView gehaeuse_output = (TextView) findViewById(R.id.gehaeuse_output);
        try {
            gehaeuse_output.setText(IntroductionActivity.Controller.getGehaeuse());
        } catch (Exception e) {
            e.printStackTrace();

        }
        TextView bezahlart_output = (TextView) findViewById(R.id.bezahlart_output);
        try {
            bezahlart_output.setText(IntroductionActivity.Controller.getBezahlart());
        } catch (Exception e) {
            e.printStackTrace();
        }


        TextView produktionsvolumen_output = (TextView) findViewById(R.id.produktionsvolumen_output);
        produktionsvolumen_output.setText(String.valueOf(IntroductionActivity.Controller.getKaufvolumen())); //TODO: Umbenennung zu getProduktionsvolumen

        TextView verkaufspreis_output = (TextView) findViewById(R.id.verkaufspreis_output);
        verkaufspreis_output.setText(String.valueOf(IntroductionActivity.Controller.getVerkaufspreis()));


    }


    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
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
