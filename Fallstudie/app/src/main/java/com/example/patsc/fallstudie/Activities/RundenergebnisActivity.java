package com.example.patsc.fallstudie.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.patsc.fallstudie.R;

public class RundenergebnisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rundenergebnis);
        IntroductionActivity.Controller.setActivity_Rundenergebnis();

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
        gewinn_output.setText(IntroductionActivity.Controller.getGewinn());

        TextView guthaben_output = (TextView) findViewById(R.id.guthaben_output);
        guthaben_output.setText(IntroductionActivity.Controller.getGuthaben());

        TextView position_output = (TextView) findViewById(R.id.position_output);
        position_output.setText(IntroductionActivity.Controller.getPosition()); */
    }


    //TODO: Methoden für Entscheidung zur nächsten Runde

    public void eineRundeAussetzen (){

    }

    public void gleichenWerteNochmal (){

    }

    public void starteNaechsteRunde (){

    }


}
