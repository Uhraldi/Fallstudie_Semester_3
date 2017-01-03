package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.patsc.fallstudie.R;

public class E10_VerkaufspreisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e10_verkaufspreis);

        //Verknuepfen von EditText mit UI-Element per ID
        EditText verkaufspreis_input = (EditText) findViewById(R.id.verkaufspreis_input);           //verkaufspreis_input zweimal verwenden ok?

        //speichere Eingabewert im String
        String inputVerkaufspreis = verkaufspreis_input.getText().toString();
    }


    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
   public void goToNextActivity (View view) {
        Intent intent = new Intent(this, BestellzusammenfassungActivity.class);
       finish();
        startActivity(intent);
    }

 /*   //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E9_KaufvolumenActivity.class);
        startActivity(intent);
    }*/
}
