package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class PersonalwesenActivity extends AppCompatActivity { //TODO: Personalwesen

    RadioButton einstellen_radiobutton;
    RadioButton kuendigen_radiobutton;
    int auswahlEinstellen;
    int auswahlKuendigen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalwesen);
        IntroductionActivity.Controller.setActivity_Personalwesen();

        //Verknuepfen der UI Elemente
        einstellen_radiobutton = (RadioButton) findViewById(R.id.einstellen_radiobutton);
        kuendigen_radiobutton = (RadioButton) findViewById(R.id.kuendigen_radiobutton);
        EditText einstellen = (EditText) findViewById(R.id.einstellen_input);
        EditText kuendigen = (EditText) findViewById(R.id.kuendigen_input);

        //speichere Eingabewerte in Variablen
        String einstellenString = einstellen.getText().toString();
        auswahlEinstellen = Integer.parseInt(einstellenString);
        String kuendigenString = kuendigen.getText().toString();
        auswahlKuendigen = Integer.parseInt(kuendigenString);


        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));
    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) throws Exception {

        //Methodenaufruf von Controller um Personalwesen zu setzen
        if (einstellen_radiobutton.isChecked()) {
            IntroductionActivity.Controller.einstellen(auswahlEinstellen);
        }
        if (kuendigen_radiobutton.isChecked()) {
            IntroductionActivity.Controller.kuendigen(auswahlKuendigen);
        }

        //IntroductionActivity.Controller.setPersonalwesen(auswahlPersonalwesen);
        Intent intent = new Intent(this, ZeitarbeiterActivity.class);
        startActivity(intent);
        finish();
    }

}
