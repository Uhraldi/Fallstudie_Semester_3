package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class BezahlartActivity extends AppCompatActivity {

    CheckBox kreditkarte_checkbox;
    CheckBox bankueberweisung_checkbox;
    CheckBox paypal_checkbox;

    boolean kreditkarte = false; //#patsch
    boolean bankueberweisung = false;//#patsch
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
        else if (bankueberweisung_checkbox.isChecked()){
            IntroductionActivity.Controller.setBezahlart("Rechnung");
        }
        else if (paypal_checkbox.isChecked()){
            IntroductionActivity.Controller.setBezahlart("PayPal");
        }

        //block reihenfolge geändert #patsch
        if (kreditkarte==false && paypal==false&&bankueberweisung==false){
            Toast toast = Toast.makeText(this, "Bitte mindestens eine Option wählen", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            Intent intent = new Intent(this, ProduktionsvolumenActivity.class);
            startActivity(intent);
        }
        finish();
    }

    //#patsch ToDo evtl Nutzung der boolean Werte in allen 3 onClick MEthoden
    public void onClickKreditkarte (View view){
        if (kreditkarte == true){
            kreditkarte = false;
        }
        else {
            kreditkarte = true;
        }
    } // Ende onClickKreditkarte

    //patsch
    public void onClickPayPal(View view){
        if(paypal==true){
            paypal = false;
        }
        else{
            paypal = true;
        }
    }// Ende onClickPayPal

    //patsch
    //TODo heist es banküberweisung oder Rechnung??? #patsch
    public void onClickRechnung (View view){
        if (bankueberweisung == true){
            bankueberweisung = false;
        }
        else{
            bankueberweisung = true;
        }
    }// Ende onClickRechnung

} // Ende Activty
