package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.R;

public class IntroductionActivity extends AppCompatActivity {

 static Controller Controller = null;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        //erzeugt Instanz der Klasse Controller, die durchgehend bestehen bleibt
        Controller = new Controller();
    }

    /**
     * /Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
     * @param view
     */
    public void goToNextActivity (View view) {

        Intent intent = new Intent(this, LoginActivity.class);
        //diese Activity "leben" lassen wegen des Controller Controller Objects
        startActivity(intent);
    }
}
