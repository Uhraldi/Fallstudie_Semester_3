package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class RundenergebnisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rundenergebnis);
        IntroductionActivity.Controller.setActivity_Rundenergebnis();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.rundenergebnis_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText(getString(R.string.Rundebla) + (String.valueOf((IntroductionActivity.Controller.getRunde()))));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

/*        //Verknuepfen von UI-Elementen mit Java-Klasse und Aufrufen von Controller-Methoden zum Anzeigen der Rundenergebnisse
       TextView spieler_output = (TextView) findViewById(R.id.spieler_output);
        spieler_output.setText(IntroductionActivity.Controller.getSpielername());

        TextView runde_output = (TextView) findViewById(R.id.runde_output);
        runde_output.setText(IntroductionActivity.Controller.getRunde());

        TextView absatz_output = (TextView) findViewById(R.id.absatz_output);
        absatz_output.setText(IntroductionActivity.Controller.getAbsatz());

        TextView marktanteil_output = (TextView) findViewById(R.id.marktanteil_output);
        marktanteil_output.setText(IntroductionActivity.Controller.getMarktanteil());

        TextView gewinn_output = (TextView) findViewById(R.id.gewinn_output);
        gewinn_output.setText(IntroductionActivity.Controller.getKonto());

        TextView guthaben_output = (TextView) findViewById(R.id.guthaben_output);
        guthaben_output.setText(IntroductionActivity.Controller.getGuthaben());

        TextView position_output = (TextView) findViewById(R.id.position_output);
        position_output.setText(IntroductionActivity.Controller.getPosition()); */
    }


    //TODO: Methoden für Entscheidung zur nächsten Runde

    public void eineRundeAussetzen (){
        Intent intent = new Intent(this, PersonalwesenActivity.class);
        startActivity(intent);
        finish();
    }

    public void gleichenWerteNochmal (){
        Intent intent = new Intent(this, PersonalwesenActivity.class);
        startActivity(intent);
        finish();
    }

    public void starteNaechsteRunde (){
        Intent intent = new Intent(this, PersonalwesenActivity.class);
        startActivity(intent);
        finish();
    }


}
