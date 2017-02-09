package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class BerechnungActivity extends AppCompatActivity {

    /** Dauer der Wartezeit **/
    private final int CALCULATION_DISPLAY_LENGTH = 5000;

    /**
     *
     * @param icicle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_berechnung);
        IntroductionActivity.Controller.setActivity_Berechnung();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.berechnung_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText(getString(R.string.Rundebla) + String.valueOf(IntroductionActivity.Controller.getRunde() + 1));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf(""));

        /* neuer Handler, der die RundenergebnisActivity nach ein paar Sekunden anzeigt*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (IntroductionActivity.Controller.getRunde() < 9) {
                    Intent intent = new Intent(BerechnungActivity.this, RundenergebnisActivity.class);
                    BerechnungActivity.this.startActivity(intent);
                    BerechnungActivity.this.finish();
                } else {
                    Intent intent = new Intent(BerechnungActivity.this, BestenlisteActivity.class);
                    BerechnungActivity.this.startActivity(intent);
                    BerechnungActivity.this.finish();
                }

            }
        }, CALCULATION_DISPLAY_LENGTH);
    }
}