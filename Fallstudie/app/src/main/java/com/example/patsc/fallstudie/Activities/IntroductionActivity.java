package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.patsc.fallstudie.Model;
import com.example.patsc.fallstudie.R;

public class IntroductionActivity extends AppCompatActivity {

 static Model model = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.SplashScreenTheme);                                                      //cold-start splash screen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        //erzeugt Instanz der Klasse Model, das fortlaufend den Activities mitgegeben wird
        model = new Model();
    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        //finish(); <-- diese Activity leben lassen wegen des Model model Objects?
        startActivity(intent);
    }
}
