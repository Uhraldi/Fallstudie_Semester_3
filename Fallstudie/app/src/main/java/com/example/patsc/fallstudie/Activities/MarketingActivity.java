package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

import static android.webkit.WebSettings.PluginState.ON;

public class MarketingActivity extends AppCompatActivity {

    CheckBox fernsehwerbung_checkbox;
    CheckBox radiowerbung_checkbox;
    CheckBox printwerbung_checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketing);
        IntroductionActivity.Controller.setActivity_Marketing(); //ToDo: neu benannt, fehlt noch im Controller

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



    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) throws Exception {

        //Übergabe der Checkbox-Werte an Controller
        if (fernsehwerbung_checkbox.isChecked()){
            IntroductionActivity.Controller.setMarketing("Fernsehwerbung"); //ToDo: neu benannt, fehlt noch im Controller
        }
        if (radiowerbung_checkbox.isChecked()){
            IntroductionActivity.Controller.setMarketing("Radiowerbung");
        }
        if (printwerbung_checkbox.isChecked()){
            IntroductionActivity.Controller.setMarketing("Printwerbung");
        }

        Intent intent = new Intent(this, ArmbandActivity.class);
        finish();
        startActivity(intent);
    }

}
