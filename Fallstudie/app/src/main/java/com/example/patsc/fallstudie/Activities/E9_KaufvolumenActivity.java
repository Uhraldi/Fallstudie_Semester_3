package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.patsc.fallstudie.R;



public class E9_KaufvolumenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e9_kaufvolumen);

        //Verknuepfen von EditText mit UI-Element per ID
        EditText kaufvolumen_input = (EditText) findViewById(R.id.kaufvolumen_input);               //kaufvolumen_input zweimal verwenden ok?

        //speichere Eingabewert im String
        String inputKaufvolumen = kaufvolumen_input.getText().toString();


    }
    public void goToNextActivity (View view) {
        Intent intent = new Intent(this, E10_VerkaufspreisActivity.class);
        finish();
        startActivity(intent);
    }

    //Methode fuer den zurueck_button um zur vorherigen Activity/Screen zu navigieren
/*    public void goToPreviousActivity (View view) {
        Intent intent = new Intent (this, E8_WerbungActivity.class);
        startActivity(intent);
    }*/
}
