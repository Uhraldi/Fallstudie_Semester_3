package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class PersonalwesenActivity extends AppCompatActivity {

    RadioButton einstellen_radiobutton;
    RadioButton kuendigen_radiobutton;
    RadioButton nichts_radiobutton;
    boolean einstellen;
    boolean kuendigen;
    int auswahlEinstellen;
    int auswahlKuendigen;
    String einstellenString;
    String kuendigenString;
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalwesen);
        IntroductionActivity.Controller.setActivity_Personalwesen();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.personalwesen_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText("Runde: " + (String.valueOf((IntroductionActivity.Controller.getRunde()))));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

        //Verknuepfen der UI Elemente
        einstellen_radiobutton = (RadioButton) findViewById(R.id.einstellen_radiobutton);
        kuendigen_radiobutton = (RadioButton) findViewById(R.id.kuendigen_radiobutton);
        nichts_radiobutton = (RadioButton) findViewById(R.id.nichts_radiobutton);

        TextView aktuelleMitarbeiter_output = (TextView) findViewById(R.id.aktuelleMitarbeiter_output);
        aktuelleMitarbeiter_output.setText(String.valueOf(IntroductionActivity.Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getPersonalwesen().getEingestellte()));

    }


    //onClick Methoden fuer die RadioButtions
    public void onClickRadioGroup(View view){

    }

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

            Intent intent = new Intent(this, ZeitarbeiterActivity.class);

            //Verknuepfen von EditText mit UI-Element
            EditText einstellen = (EditText) findViewById(R.id.einstellen_input);
            EditText kuendigen = (EditText) findViewById(R.id.kuendigen_input);

            //Weitergabe der Eingabewerte bei entsprechender CheckBox Auswahl
            if (einstellen_radiobutton.isChecked()){
                if (einstellen != null && !TextUtils.isEmpty(einstellen.getText())){
                    einstellenString = einstellen.getText().toString().trim();
                    auswahlEinstellen = Integer.parseInt(einstellenString);
                    IntroductionActivity.Controller.einstellen(auswahlEinstellen);
                    startActivity(intent);
                    finish();
                } else {
                    Toast toast = Toast.makeText(this, "Bitte angeben, wieviele Mitarbeiter Sie einstellen moechten", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }

            if (kuendigen_radiobutton.isChecked()) {
                if (kuendigen != null && !TextUtils.isEmpty(kuendigen.getText())){
                    kuendigenString = kuendigen.getText().toString().trim();
                    auswahlKuendigen = Integer.parseInt(kuendigenString);
                    if (IntroductionActivity.Controller.kuendigen(auswahlKuendigen)) {
                        startActivity(intent);
                        finish();
                    }  else{
                        Toast toast1 = Toast.makeText(this, "Es muss mindestens ein Mitarbeiter eingestellt sein.", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                } else {
                    Toast toast2 = Toast.makeText(this, "Bitte angeben, wieviele Mitarbeiter Sie kuendigen moechten.", Toast.LENGTH_SHORT);
                    toast2.show();
                }
            }

            if (nichts_radiobutton.isChecked()){
                IntroductionActivity.Controller.keineVeraenderung();
                startActivity(intent);
                finish();
            }

            if (!einstellen_radiobutton.isChecked() && !kuendigen_radiobutton.isChecked() && !nichts_radiobutton.isChecked()){
                Toast toast3 = Toast.makeText(this, "Bitte mindestens eine Option waehlen", Toast.LENGTH_SHORT);
                toast3.show();
            }

        } //Ende goToNextActivity

    } //Ende Klasse


