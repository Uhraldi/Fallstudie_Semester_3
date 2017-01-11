package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

import static com.example.patsc.fallstudie.Activities.IntroductionActivity.Controller;


public class E1_ForschungActivity extends AppCompatActivity {

    private Spinner DesignerSpinner;
    String auswahlDesigner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //prüft ob Spinner bereits eine Auswahl hatte und stellt diese dann wieder her
/*        if (savedInstanceState != null) {
            DesignerSpinner.setSelection(savedInstanceState.getInt("DesignerSpinner", 0));
        }*/

        setContentView(R.layout.activity_e1_designer);
        IntroductionActivity.Controller.setActivity_E1(); // ToDo Absturz der App auch bei Aufruf anderer Methoden

        //fuegt dem Spinner die Werte aus dem String-Array hinzu
          addItemsToDesignerSpinner();

        //fuegt dem Spinner einen Listener hinzu
        addListenertoDesigner_Spinner();

        //Ausgabe der aktuellen Kosten anhand der Auswahl
       TextView gesamtkosten_output = (TextView) findViewById(R.id.gesamtkosten_output);
        gesamtkosten_output.setText(String.valueOf(Controller.getFixKosten()));
        TextView stueckkosten_output = (TextView) findViewById(R.id.stueckkosten_output);
        stueckkosten_output.setText(String.valueOf(Controller.getVarKosten()));

        }


    //Methode um Spinner die Werte aus dem String-Array hinzuzufuegen
    public void addItemsToDesignerSpinner(){

        DesignerSpinner = (Spinner) findViewById(R.id.designer_spinner);

        ArrayAdapter designer_spinner_adapter = ArrayAdapter.createFromResource(this,
                R.array.designer_spinner_array,
                android.R.layout.simple_spinner_item);

        //DesignerSpinner.setDropDownViewResource(android.R.layout.simple_spinner);

        DesignerSpinner.setAdapter(designer_spinner_adapter);
    }


    //Methode um dem Spinner einen Listener hinzuzufuegen
    public void addListenertoDesigner_Spinner(){

        DesignerSpinner = (Spinner) findViewById(R.id.designer_spinner);

        DesignerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String ItemSelectedInDesignerSpinner = parent.getItemAtPosition(pos).toString();
                String[] separated = ItemSelectedInDesignerSpinner.split("\\(");
                auswahlDesigner = separated[0].trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) throws Exception {

        //Methodenaufruf von Controller um Designer zu setzen
        Controller.setDesigner(auswahlDesigner);

        Intent intent = new Intent(this, E2_ArmbandActivity.class);
        startActivity(intent);
        finish();
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, LogInActivity.class);
        startActivity(intent); }
    */



    //speichert den aktuellen Zustand des Spinners (um wiederhergestellt werden zu können)
 /*   @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("DesignerSpinner", DesignerSpinner.getSelectedItemPosition());
    }
*/

}

