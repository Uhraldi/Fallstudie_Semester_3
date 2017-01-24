package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;


public class ProduktionsvolumenActivity extends AppCompatActivity {

    int auswahlProduktionsvolumen;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produktionsvolumen);
        IntroductionActivity.Controller.setActivity_Produktionsvolumen();

        //Verknuepfen von EditText mit UI-Element per ID-> verschoben #patsch
        // EditText Produktionsvolumen_input = (EditText) findViewById(R.id.produktionsvolumen_input);

        //speichere Eingabewert in Variable -> verschoben in gotToNExtActivity #patsch
       //#patsch String ProduktionsvolumenString = Produktionsvolumen_input.getText().toString();
        //#patsch auswahlProduktionsvolumen = Integer.parseInt(ProduktionsvolumenString);


        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.Controller.getVarKosten()));

    }

    //ToDO wo ist die Abfrage bzgl ausreichend Geld? #patsch
    /**
     * Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     * @throws Exception
     */
    public void goToNextActivity (View view) throws Exception {

        //Verknuepfen von EditText mit UI-Element per ID
        EditText Produktionsvolumen_input = (EditText) findViewById(R.id.produktionsvolumen_input);
        //speichere Eingabewert in Variable
        String ProduktionsvolumenString = Produktionsvolumen_input.getText().toString();
        auswahlProduktionsvolumen = Integer.parseInt(ProduktionsvolumenString);

        //Methodenaufruf von Controller um Input weiterzugeben, mit Bedingung/Überprüfung der Eingabewerte
        if (auswahlProduktionsvolumen < 100 || auswahlProduktionsvolumen > 10000){
            Toast toast = Toast.makeText(this, "ungültige Eingabe", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            IntroductionActivity.Controller.setProduktionsvolumen(auswahlProduktionsvolumen);
            Intent intent = new Intent(this, VerkaufspreisActivity.class);
            finish();
            startActivity(intent);
        }

    }

}
