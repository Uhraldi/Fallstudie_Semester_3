package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.patsc.fallstudie.R;

public class BerechnungActivity extends AppCompatActivity {

    /** Dauer der Wartezeit **/
    private final int CALCULATION_DISPLAY_LENGTH = 5000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_berechnung);

        /* neuer Handler, der die Rundenergebnis Activity nach ein paar Sekunden anzeigt*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(BerechnungActivity.this, RundenergebnisActivity.class);
                BerechnungActivity.this.startActivity(mainIntent);
                BerechnungActivity.this.finish();
            }
        }, CALCULATION_DISPLAY_LENGTH);
    }
}