package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class BezahlartActivity extends AppCompatActivity {

    CheckBox kreditkarte_checkbox;
    CheckBox bankueberweisung_checkbox;
    CheckBox paypal_checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezahlart);
        IntroductionActivity.Controller.setActivity_Bezahlart();

        //Verknüpft Checkboxes
        kreditkarte_checkbox = (CheckBox)findViewById(R.id.kreditkarte_checkbox);
        bankueberweisung_checkbox = (CheckBox)findViewById(R.id.bankueberweisung_checkbox);
        paypal_checkbox= (CheckBox)findViewById(R.id.paypal_checkbox);


        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }



    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) throws Exception {

        //Übergabe der Checkbox-Werte an Controller
        if (kreditkarte_checkbox.isChecked()){
            IntroductionActivity.Controller.setBezahlart("Kreditkarte");
        }
        if (bankueberweisung_checkbox.isChecked()){
            IntroductionActivity.Controller.setBezahlart("Banküberweisung");
        }
        if (paypal_checkbox.isChecked()){
            IntroductionActivity.Controller.setBezahlart("PayPal");
        }
;

        Intent intent = new Intent(this, ProduktionsvolumenActivity.class);
        finish();
        startActivity(intent);
    }

}