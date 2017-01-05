package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

public class Z1_Armband extends AppCompatActivity {

    private Spinner ArmbandSpinner;
    private String auswahlArmband;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_z1_armband);
        IntroductionActivity.model.setActivity_Z1();

        //Je nach Sub-Zufall die Ausgabe des richtigen Strings/Info-Texts
        TextView z1armband_info_textiew = (TextView) findViewById(R.id.z1armband_info_textview);
        switch (IntroductionActivity.model.getArmband()){
            case "Leder": {
                z1armband_info_textiew.setText(R.string.z1leder_info_textview);
                break;
            }
            case "Kunstleder": {
                z1armband_info_textiew.setText(R.string.z1kunstleder_info_textview);
                break;
            }
            case "Holz": {
                z1armband_info_textiew.setText(R.string.z1holz_info_textview);
                break;
            }
            case "Textil": {
                z1armband_info_textiew.setText(R.string.z1textil_info_textview);
                break;
            }
            case "Metall": {
                z1armband_info_textiew.setText(R.string.z1metall_info_textview);
                break;
            }
        }


        //fuegt dem Spinner die Werte aus dem String-Array hinzu
        addItemsToArmbandSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoArmbandSpinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
        TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(IntroductionActivity.model.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(IntroductionActivity.model.getVarKosten()));

    }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToArmbandSpinner(){

        ArmbandSpinner = (Spinner) findViewById(R.id.armband_spinner);

        ArrayAdapter armband_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.armband_spinner_array,
                android.R.layout.simple_spinner_item);

        //armbandSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        ArmbandSpinner.setAdapter(armband_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoArmbandSpinner(){

        ArmbandSpinner = (Spinner) findViewById(R.id.armband_spinner);

        ArmbandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInArmbandSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInArmbandSpinner.split("\\(");
                auswahlArmband = separated[0].trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {

        //Methodenaufruf von Model um Spinner Auswahl zu setzen, mit Prüfung ob anderer Wert als vorher
        if(IntroductionActivity.model.getArmband().equals(auswahlArmband)) {
            Toast toast = Toast.makeText(this, "Diese Option geht leider nicht mehr", Toast.LENGTH_SHORT);
        } else {
            IntroductionActivity.model.setArmbandNeu(auswahlArmband);
        }

        Intent z2 = new Intent(this, Z2_Gehaeuse.class);
        Intent z3 = new Intent(this, Z3_ZusammenbauActivity.class);
        Intent keinZufall = new Intent(this, BerechnungActivity.class);

        //Abfrage ob Zufall Z2-Z3 eingetreten ist und entsprechende Weiterleitung
        if (IntroductionActivity.model.isZufall2()){
            startActivity(z2);
        } else if (IntroductionActivity.model.isZufall3()){
            startActivity(z3);
        } else {
            startActivity(keinZufall);
        }

        finish();
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*
    public void goToPreviousActivity (View view) {
        this.finish();
    }
*/



/*
    //speichert den aktuellen Zustand des Spinners (um wiederhergestellt werden zu können)
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("ArmbandSpinner", ArmbandSpinner.getSelectedItemPosition());
    }
*/

}


