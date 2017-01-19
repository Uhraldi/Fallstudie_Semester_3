package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class PersonalwesenActivity extends AppCompatActivity {

    RadioButton einstellen_radiobutton;
    RadioButton kuendigen_radiobutton;
    boolean einstellen; //#patsch
    boolean kuendigen; //#patsch
    int auswahlEinstellen;
    int auswahlKuendigen;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalwesen);
        IntroductionActivity.Controller.setActivity_Personalwesen();

        //Verknuepfen der UI Elemente
        einstellen_radiobutton = (RadioButton) findViewById(R.id.einstellen_radiobutton);
        kuendigen_radiobutton = (RadioButton) findViewById(R.id.kuendigen_radiobutton);

        //Ausgabe der aktuellen Kosten anhand der Auswahl
       TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
      //ToDo wieder rein #patsch  gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        //ToDo wieder rein #patsch  stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));
    }
    //#patsch
public void onClickRadioGroup(View view){

}
    //#patsch
public void onClickRadioButton(View view){
    if (einstellen_radiobutton.isChecked()){
        einstellen = true;
        kuendigen = false;
    }
    else if (kuendigen_radiobutton.isChecked()){
        kuendigen = true;
        einstellen = true;
    }
}
    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
    public void goToNextActivity (View view) throws Exception {

        //Methodenaufruf von Controller um Personalwesen zu setzen TODO: funzt einstellen/kuendigen? darf nur eins aktiviert sein? Antwort: funktioniert nicht; ja es darf nur eines aktiviert sein; fehler gefixed #patsch

        // Block parseInt usw. von OnCreate hierher verschoben, da sonst Fehler entstehen #patsch
        //speichere Eingabewerte in Variablen
        EditText einstellen = (EditText) findViewById(R.id.einstellen_input);
        EditText kuendigen = (EditText) findViewById(R.id.kuendigen_input);
        // ToDo Prüfung ob auch wirklich ein Wert eingegeben wurde; sonst stürz die App ab #patsch
        if (einstellen_radiobutton.isChecked()) {
            IntroductionActivity.Controller.einstellen(auswahlEinstellen);
            String einstellenString = einstellen.getText().toString();
            auswahlEinstellen = Integer.parseInt(einstellenString);
        }
        if (kuendigen_radiobutton.isChecked()) {
            String kuendigenString = kuendigen.getText().toString();
            auswahlKuendigen = Integer.parseInt(kuendigenString);
            IntroductionActivity.Controller.kuendigen(auswahlKuendigen);
        }

        Intent intent = new Intent(this, ZeitarbeiterActivity.class);
        startActivity(intent);
        finish();
    }

}
