package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.patsc.fallstudie.R;

public class BerechnungActivity extends AppCompatActivity {

    /** Dauer der Wartezeit **/
    private final int CALCULATION_DISPLAY_LENGTH = 10000;  //TODO: richtiges Warten auf andere Spieler

    /**
     *
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_berechnung);
        IntroductionActivity.Controller.setActivity_Berechnung();

        /* neuer Handler, der die RundenergebnisActivity nach ein paar Sekunden anzeigt*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(BerechnungActivity.this, RundenergebnisActivity.class);
                BerechnungActivity.this.startActivity(intent);
                BerechnungActivity.this.finish();
            }
        }, CALCULATION_DISPLAY_LENGTH);
    }
}