package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class VerkaufspreisActivity extends AppCompatActivity {

    float auswahlVerkaufspreis;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verkaufspreis);
        IntroductionActivity.Controller.setActivity_Verkaufspreis();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.absatz_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText(getString(R.string.Rundebla) + String.valueOf(IntroductionActivity.Controller.getRunde() + 1));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getGesamtkosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getStueckkosten()));

    }


    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
   public void goToNextActivity (View view) throws Exception {
       //Verschoben #patsch
       //Verknuepfen von EditText mit UI-Element per ID
       EditText verkaufspreis_input = (EditText) findViewById(R.id.verkaufspreis_input);

       //Verschoben #patsch
       //speichere Eingabewert im String


       //Methodenaufruf von Controller um Input weiterzugeben, mit Bedingung/Überprüfung der Eingabewerte
       if (verkaufspreis_input != null && !TextUtils.isEmpty(verkaufspreis_input.getText())) {
           String verkaufspreisString = verkaufspreis_input.getText().toString();
           auswahlVerkaufspreis = Float.parseFloat(verkaufspreisString);
           if (auswahlVerkaufspreis < 5 || auswahlVerkaufspreis > 1500) {
               Toast toast = Toast.makeText(this, "ungültige Eingabe", Toast.LENGTH_SHORT);
               toast.show();
           } else {
               IntroductionActivity.Controller.setVerkaufspreisAktuell(auswahlVerkaufspreis);
               Intent intent = new Intent(this, BestellzusammenfassungActivity.class);
               finish();
               startActivity(intent);
           }
       } else {
           Toast toast = Toast.makeText(this, "Bitte einen Verkaufspreis angeben!", Toast.LENGTH_SHORT);
           toast.show();
       }
   }
}
