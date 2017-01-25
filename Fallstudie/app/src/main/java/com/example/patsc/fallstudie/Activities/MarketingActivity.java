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

public class MarketingActivity extends AppCompatActivity {

    CheckBox fernsehwerbung_checkbox;
    CheckBox radiowerbung_checkbox;
    CheckBox printwerbung_checkbox;

    boolean fernsehwerbung = false;
    boolean radiowerbung = false;
    boolean printwerbung = false;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketing);
        IntroductionActivity.Controller.setActivity_Marketing();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText("Investition");
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText(IntroductionActivity.Controller.getRunde());
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

        //Verknüpft Checkboxes
        fernsehwerbung_checkbox = (CheckBox)findViewById(R.id.fernsehwerbung_checkbox);
        radiowerbung_checkbox = (CheckBox)findViewById(R.id.radiowerbung_checkbox);
        printwerbung_checkbox= (CheckBox)findViewById(R.id.printwerbung_checkbox);


        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }

    //Todo evtl nutzung der Variablen???
   //onClick Methoden fuer die drei CheckBoxes, mit Moeglichkeit zum Deaktivieren
   public void onCheckboxClickedRadiowerbung (View view){
       if (radiowerbung == true){
           radiowerbung = false;
       }
       else {
           radiowerbung = true;
       }
   } // Ende onCheckboxClickedRadiowerbung

    public void onCheckboxClickedFersnsehwerbung(View view){
        if (fernsehwerbung == true){
            fernsehwerbung = false;
        }
        else{
            fernsehwerbung = true;
        }
    }// Ende onCheckboxClickedFersnsehwerbung

    public void onCheckboxClickedPrintwerbung(View view){
        if (printwerbung== true){
            printwerbung = false;
        }
        else{
            printwerbung = true;
        }
    } // Ende onCheckboxClickedPrintwerbung

    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
    public void goToNextActivity (View view) throws Exception {

        //Übergabe der Checkbox-Werte an Controller
        if (fernsehwerbung_checkbox.isChecked()){
            IntroductionActivity.Controller.setMarketing("Fernsehwerbung");
        }
        if (radiowerbung_checkbox.isChecked()){
            IntroductionActivity.Controller.setMarketing("Radiowerbung");
        }
        if (printwerbung_checkbox.isChecked()){
            IntroductionActivity.Controller.setMarketing("Printwerbung");
        }

        Intent intent = new Intent(this, ArmbandActivity.class);

        //Überprüfung ob mindestens eine Checkbox aktiviert wurde, dann Weiterleitung, sonst Toast
        if (fernsehwerbung_checkbox.isChecked() || radiowerbung_checkbox.isChecked() || printwerbung_checkbox.isChecked()){
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, "Bitte mindestens eine Option wählen", Toast.LENGTH_SHORT);
            toast.show();
        }

        finish();
    }

}
