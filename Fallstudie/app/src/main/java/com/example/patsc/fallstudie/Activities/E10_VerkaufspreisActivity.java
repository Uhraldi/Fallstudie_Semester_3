package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class E10_VerkaufspreisActivity extends AppCompatActivity {

    float auswahlVerkaufspreis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e10_verkaufspreis);
        IntroductionActivity.Controller.setActivity_E10();

        //Verknuepfen von EditText mit UI-Element per ID
        EditText verkaufspreis_input = (EditText) findViewById(R.id.verkaufspreis_input);

        //speichere Eingabewert im String
        String verkaufspreisString = verkaufspreis_input.getText().toString();
        auswahlVerkaufspreis = Float.parseFloat(verkaufspreisString);
    }


    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
   public void goToNextActivity (View view) throws Exception {

       //Methodenaufruf von Controller um Input weiterzugeben, mit Bedingung/Überprüfung der Eingabewerte
       if (auswahlVerkaufspreis < 5 || auswahlVerkaufspreis > 1500){
           Toast toast = Toast.makeText(this, "ungültige Eingabe", Toast.LENGTH_SHORT);
           toast.show();
       } else {
           IntroductionActivity.Controller.setKaufvolumen(auswahlVerkaufspreis);
           Intent intent = new Intent(this, BestellzusammenfassungActivity.class);
           finish();
           startActivity(intent);
       }
    }

 /*   //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E9_ProduktionsvolumenActivity.class);
        startActivity(intent);
    }*/
}
