package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nilshohgraefe on 03/01/2017.
 * dient dem Anzeigen des App-Logos während des Kaltstarts der App anstelle eines schwarzen Screens
 */

public class SplashScreen extends AppCompatActivity{

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, IntroductionActivity.class);
        startActivity(intent);
        finish();
    }

}
