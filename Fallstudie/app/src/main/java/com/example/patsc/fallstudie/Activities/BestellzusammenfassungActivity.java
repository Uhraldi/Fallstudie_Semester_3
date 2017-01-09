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
        IntroductionActivity.model.setActivity_Bestellzusammenfassung();

        //Verknuepfen von UI-Elementen mit Java-Klasse und Aufrufen von Model-Methoden zum Anzeigen der Bestellpositionen
        TextView designer_auswahl_output_textview = (TextView) findViewById(R.id.designer_auswahl_output_textview);
        //designer_auswahl_output_textview.setText(IntroductionActivity.model.getDesigner());

        TextView armband_auswahl_output_textview = (TextView) findViewById(R.id.armband_auswahl_output_textview);
        armband_auswahl_output_textview.setText(IntroductionActivity.model.getArmband());

        TextView uhrwerk_auswahl_output_textview = (TextView) findViewById(R.id.uhrwerk_auswahl_output_textview);
        uhrwerk_auswahl_output_textview.setText(IntroductionActivity.model.getUhrwerk());

        TextView gehaeuse_auswahl_output_textview = (TextView) findViewById(R.id.gehaeuse_auswahl_output_textview);
        gehaeuse_auswahl_output_textview.setText(IntroductionActivity.model.getGehaeuse());

        TextView versandart_auswahl_output_textview = (TextView) findViewById(R.id.versandart_auswahl_output_textview);
        versandart_auswahl_output_textview.setText(IntroductionActivity.model.getVersandart());

        TextView wasserdichtheit_auswahl_output_textview = (TextView) findViewById(R.id.wasserdichtheit_auswahl_output_textview);
        wasserdichtheit_auswahl_output_textview.setText(IntroductionActivity.model.getWasserdichtheit());

        TextView zusammenbau_auswahl_output_textview = (TextView) findViewById(R.id.zusammenbau_auswahl_output_textview);
        zusammenbau_auswahl_output_textview.setText(IntroductionActivity.model.getZusammenbau());

        TextView werbung_auswahl_output_textview = (TextView) findViewById(R.id.werbung_auswahl_output_textview);
        werbung_auswahl_output_textview.setText(IntroductionActivity.model.getWerbung());

        TextView kaufvolumen_auswahl_output_textview = (TextView) findViewById(R.id.kaufvolumen_auswahl_output_textview);
        kaufvolumen_auswahl_output_textview.setText(String.valueOf(IntroductionActivity.model.getKaufvolumen()));

        TextView verkaufspreis_auswahl_output_textview = (TextView) findViewById(R.id.verkaufspreis_auswahl_output_textview);
        verkaufspreis_auswahl_output_textview.setText(String.valueOf(IntroductionActivity.model.getVerkaufspreis()));




    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity(View view) {

        Intent z1 = new Intent(this, Z1_Armband.class);
        Intent z2 = new Intent(this, Z2_Gehaeuse.class);
        Intent z3 = new Intent(this, Z3_ZusammenbauActivity.class);
        Intent keinZufall = new Intent(this, BerechnungActivity.class);

        //Abfrage ob Zufall Z1-Z3 eingetreten ist und entsprechende Weiterleitung
        if (IntroductionActivity.model.isZufall1()){
            startActivity(z1);
        } else if (IntroductionActivity.model.isZufall2()){
            startActivity(z2);
        } else if (IntroductionActivity.model.isZufall3()){
            startActivity(z3);
        } else {
            startActivity(keinZufall);
        }

        finish();
    }
}
