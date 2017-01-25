package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class BezahlartActivity extends AppCompatActivity {

    CheckBox kreditkarte_checkbox;
    CheckBox rechnung_checkbox;
    CheckBox paypal_checkbox;

    boolean kreditkarte = false; //#patsch
    boolean rechnung = false;//#patsch
    boolean paypal = false; //#patsch
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bezahlart);
        IntroductionActivity.Controller.setActivity_Bezahlart();

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

        //Verknüpft Checkboxes
        kreditkarte_checkbox = (CheckBox)findViewById(R.id.kreditkarte_checkbox);
        rechnung_checkbox = (CheckBox)findViewById(R.id.rechnung_checkbox);
        paypal_checkbox= (CheckBox)findViewById(R.id.paypal_checkbox);


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

        //Übergabe der Checkbox-Werte an Controller
        if (kreditkarte_checkbox.isChecked()){
            IntroductionActivity.Controller.setBezahlart("Kreditkarte");
        }
        else if (rechnung_checkbox.isChecked()){
            IntroductionActivity.Controller.setBezahlart("Rechnung");
        }
        else if (paypal_checkbox.isChecked()){
            IntroductionActivity.Controller.setBezahlart("PayPal");
        }

        //Abfrage, ob mind. 1 Option gewaehlt wurde, sonst Toast
        if (kreditkarte==false && paypal==false&&rechnung==false){
            Toast toast = Toast.makeText(this, "Bitte mindestens eine Option wählen", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(this, ProduktionsvolumenActivity.class);
            startActivity(intent);
            finish();
        }

    }

    //Todo evtl nutzung der Variablen???
    //onClick Methoden fuer die drei Checkboxes, mit Moeglichkeit zum Deaktivieren
    public void onClickKreditkarte (View view){
        if (kreditkarte == true){
            kreditkarte = false;
        }
        else {
            kreditkarte = true;
        }
    } // Ende onClickKreditkarte

    public void onClickPayPal(View view){
        if(paypal==true){
            paypal = false;
        }
        else{
            paypal = true;
        }
    }// Ende onClickPayPal

    public void onClickRechnung (View view){
        if (rechnung == true){
            rechnung = false;
        }
        else{
            rechnung = true;
        }
    }// Ende onClickRechnung

} // Ende Activty
