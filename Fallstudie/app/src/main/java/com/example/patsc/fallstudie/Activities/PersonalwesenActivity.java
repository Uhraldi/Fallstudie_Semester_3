package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.patsc.fallstudie.R;

public class PersonalwesenActivity extends AppCompatActivity { //TODO: Personalwesen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalwesen);
    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) throws Exception {

        //Methodenaufruf von Controller um Personalwesen zu setzen

        //IntroductionActivity.Controller.setPersonalwesen(auswahlPersonalwesen);
        Intent intent = new Intent(this, ZeitarbeiterActivity.class);
        startActivity(intent);
        finish();
    }

}
