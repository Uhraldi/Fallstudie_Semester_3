package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class RundenergebnisActivity extends AppCompatActivity {

    /**
     *
     * @param savedInstanceState
     */
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
        toolbar_runde.setText(getString(R.string.Rundebla) + String.valueOf(IntroductionActivity.Controller.getRunde() + 1));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

       //Verknuepfen von UI-Elementen mit Java-Klasse und Aufrufen von Controller-Methoden zum Anzeigen der Rundenergebnisse
       TextView spieler_output = (TextView) findViewById(R.id.spieler_output);
        spieler_output.setText(IntroductionActivity.Controller.getAktiverSpieler().getName());

        TextView runde_output = (TextView) findViewById(R.id.runde_output);
        int i = 1 + IntroductionActivity.Controller.getRunde();
        runde_output.setText(String.valueOf(i));

        TextView absatz_output = (TextView) findViewById(R.id.absatz_output);
        absatz_output.setText(String.valueOf(IntroductionActivity.Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getAbsatz(IntroductionActivity.Controller.getAktiverSpieler().getName())));

        TextView marktanteil_output = (TextView) findViewById(R.id.marktanteil_output);
        double marktanteil = IntroductionActivity.Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getMarktanteil(IntroductionActivity.Controller.getAktiverSpieler().getName());
        marktanteil = marktanteil * 10000;
        marktanteil = Math.round(marktanteil);
        marktanteil = marktanteil/100;
        marktanteil_output.setText((String.valueOf(marktanteil) + " %"));

        TextView gewinn_output = (TextView) findViewById(R.id.gewinn_output);
        gewinn_output.setText(String.valueOf(IntroductionActivity.Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getRundenGewinn(IntroductionActivity.Controller.aktiverSpieler.getName())));

        TextView guthaben_output = (TextView) findViewById(R.id.guthaben_output);
        guthaben_output.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

        TextView position_output = (TextView) findViewById(R.id.position_output);
        position_output.setText(String.valueOf(IntroductionActivity.Controller.getPosition()));

        //Verknuepfen der Buttons
        Button gameover_button = (Button) findViewById(R.id.gameover_button);
        Button neueEingabewerte_button = (Button) findViewById(R.id.neueEingabewerte_button);
        Button gleichenWerte_button = (Button) findViewById(R.id.gleichenWerte_button);
        TextView ergebnis_message = (TextView) findViewById(R.id.ergebnis_message);

        //Anzeige der richtigen Strings und Buttons je nachdem ob man pleite ist oder nicht
        if (IntroductionActivity.Controller.getGuthaben() < (5400 + (27600 * IntroductionActivity.Controller.getEingestellteGesamt())) ){
            gameover_button.setVisibility(View.VISIBLE);
            ergebnis_message.setText(R.string.gameover_message);
            } else if (IntroductionActivity.Controller.getGuthaben() < (10400 + (27600 * IntroductionActivity.Controller.getEingestellteGesamt()))) {
                Toast toast = Toast.makeText(this, "Sie sind kurz vor der Insolvenz. Produzieren Sie günstig in der nächsten Runde!", Toast.LENGTH_LONG);
                toast.show();
                neueEingabewerte_button.setVisibility(View.VISIBLE);
                gleichenWerte_button.setVisibility(View.VISIBLE);
                ergebnis_message.setText(R.string.naechste_runde_string);
            } else {
                    neueEingabewerte_button.setVisibility(View.VISIBLE);
                    gleichenWerte_button.setVisibility(View.VISIBLE);
                    ergebnis_message.setText(R.string.naechste_runde_string);
            }
    }


    /**
     * Button um die naechste Runde mit den gleichen Auswahlen zu spielen
     * @param view
     */
    public void gleichenWerteNochmal (View view){
        if (IntroductionActivity.Controller.gleichenWerteNochmal()) {
            Intent intent = new Intent(this, BestellzusammenfassungActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast toast = Toast.makeText(this, "Bitte erneut versuchen oder andere Auswahl treffen", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Button um die naechste Runde normal zu starten
     * @param view
     */
    public void starteNaechsteRunde (View view){
        if (IntroductionActivity.Controller.starteNaechsteRunde()) {
            Intent intent = new Intent(this, PersonalwesenActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast toast = Toast.makeText(this, "Bitte erneut versuchen oder andere Auswahl treffen", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Button um ein neues Spiel zu starten (bei Gameover)
     * @param view
     */
    public void neuesSpiel (View view){
        IntroductionActivity.Controller.neuesSpiel();
        Intent intent = new Intent(this, PersonalwesenActivity.class);
        startActivity(intent);
        finish();
    }


}
