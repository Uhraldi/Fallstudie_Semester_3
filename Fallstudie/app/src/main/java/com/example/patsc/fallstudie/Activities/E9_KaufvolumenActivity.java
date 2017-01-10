package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;


public class E9_KaufvolumenActivity extends AppCompatActivity {

    int auswahlKaufvolumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e9_kaufvolumen);
        IntroductionActivity.model.setActivity_E9();

        //Verknuepfen von EditText mit UI-Element per ID
        EditText kaufvolumen_input = (EditText) findViewById(R.id.kaufvolumen_input);

        //speichere Eingabewert in Variable
        String kaufvolumenString = kaufvolumen_input.getText().toString();
        auswahlKaufvolumen = Integer.parseInt(kaufvolumenString);// Absturz 2.17 ToDo // Testende


        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.model.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.model.getVarKosten()));

    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {

        //Methodenaufruf von Model um Input weiterzugeben, mit Bedingung/Überprüfung der Eingabewerte
        if (auswahlKaufvolumen < 100 || auswahlKaufvolumen > 10000){
            Toast toast = Toast.makeText(this, "ungültige Eingabe", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            IntroductionActivity.model.setKaufvolumen(auswahlKaufvolumen);
            Intent intent = new Intent(this, E10_VerkaufspreisActivity.class);
            finish();
            startActivity(intent);
        }

    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E8_WerbungActivity.class);
        startActivity(intent);
    }*/
}
