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


public class ProduktionsvolumenActivity extends AppCompatActivity {

    int auswahlProduktionsvolumen;
    String ProduktionsvolumenString;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produktionsvolumen);
        IntroductionActivity.Controller.setActivity_Produktionsvolumen();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.absatz_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText("Runde: " + (String.valueOf((IntroductionActivity.Controller.getRunde()))));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }


    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
    public void goToNextActivity (View view) throws Exception {

        //Verknuepfen von EditText mit UI-Element per ID
        EditText Produktionsvolumen_input = (EditText) findViewById(R.id.produktionsvolumen_input);

        //Methodenaufruf von Controller um Input weiterzugeben, mit Bedingung/Überprüfung der Eingabewerte und ob das Guthaben reicht
        if (Produktionsvolumen_input != null && !TextUtils.isEmpty(Produktionsvolumen_input.getText())) {
            ProduktionsvolumenString = Produktionsvolumen_input.getText().toString();
            auswahlProduktionsvolumen = Integer.parseInt(ProduktionsvolumenString);
                if (auswahlProduktionsvolumen >= 100 && auswahlProduktionsvolumen <= 10000) {
                    if ((IntroductionActivity.Controller.getFixKosten() + (IntroductionActivity.Controller.getVarKosten() * auswahlProduktionsvolumen)) <
                            IntroductionActivity.Controller.getGuthaben()) {
                        IntroductionActivity.Controller.setProduktionsvolumen(auswahlProduktionsvolumen);
                        Intent intent = new Intent(this, VerkaufspreisActivity.class);
                        finish();
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(this, "Ihr aktuelles Guthaben reicht fuer dieses Produktionsvolumen nicht aus", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(this, "ungueltige Eingabe", Toast.LENGTH_SHORT);
                    toast.show();
                }
        } else {
            Toast toast = Toast.makeText(this, "Bitte ein Produktionsvolumen bestimmen", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

}
