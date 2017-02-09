package com.example.patsc.fallstudie.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.patsc.fallstudie.R;

public class BestenlisteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestenliste);
        IntroductionActivity.Controller.setActivity_Bestenliste();

        //Initialisieren der Toolbar mit aktuellen Werten
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView toolbar_titel = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_titel.setText(R.string.bestenliste_title);
        TextView toolbar_runde = (TextView) toolbar.findViewById(R.id.toolbar_runde);
        toolbar_runde.setText(getString(R.string.Rundebla) + String.valueOf(IntroductionActivity.Controller.getRunde() + 1));
        TextView toolbar_konto = (TextView) toolbar.findViewById(R.id.toolbar_konto);
        toolbar_konto.setText(String.valueOf((IntroductionActivity.Controller.getGuthaben())));

        String [][] bestenListe = IntroductionActivity.Controller.getBestenliste();

        //Platz 1
        TextView einspos = (TextView) findViewById(R.id.einspos);
        einspos.setText(bestenListe[0][0]);
        TextView einsname = (TextView) findViewById(R.id.einsname);
        einsname.setText(bestenListe[0][1]);
        TextView einsguthaben = (TextView) findViewById(R.id.einsguthaben);
        einsguthaben.setText(bestenListe[0][2]);
        TextView einsmarktanteil = (TextView) findViewById(R.id.einsmarktanteil);
        einsmarktanteil.setText(bestenListe[0][3]);


        //Platz2
        TextView zweipos = (TextView) findViewById(R.id.zweipos);
        zweipos.setText(bestenListe[1][0]);
        TextView zweiname = (TextView) findViewById(R.id.zweiname);
        zweiname.setText(bestenListe[1][1]);
        TextView zweiguthaben = (TextView) findViewById(R.id.zweiguthaben);
        zweiguthaben.setText(bestenListe[1][2]);
        TextView zweimarktanteil = (TextView) findViewById(R.id.zweimarktanteil);
        zweimarktanteil.setText(bestenListe[1][3]);

        //Platz3
        TextView dreipos = (TextView) findViewById(R.id.dreipos);
        dreipos.setText(bestenListe[2][0]);
        TextView dreiname = (TextView) findViewById(R.id.dreiname);
        dreiname.setText(bestenListe[2][1]);
        TextView dreiguthaben = (TextView) findViewById(R.id.dreiguthaben);
        dreiguthaben.setText(bestenListe[2][2]);
        TextView dreimarktanteil = (TextView) findViewById(R.id.dreimarktanteil);
        dreimarktanteil.setText(bestenListe[2][3]);

        //Platz 4
        TextView vierpos = (TextView) findViewById(R.id.vierpos);
        vierpos.setText(bestenListe[3][0]);
        TextView viername = (TextView) findViewById(R.id.viername);
        viername.setText(bestenListe[3][1]);
        TextView vierguthaben = (TextView) findViewById(R.id.vierguthaben);
        vierguthaben.setText(bestenListe[3][2]);
        TextView viermarktanteil = (TextView) findViewById(R.id.viermarktanteil);
        viermarktanteil.setText(bestenListe[3][3]);

        //Platz 5
        TextView fuenfpos = (TextView) findViewById(R.id.fuenfpos);
        fuenfpos.setText(bestenListe[4][0]);
        TextView fuenfname = (TextView) findViewById(R.id.fuenfname);
        fuenfname.setText(bestenListe[4][1]);
        TextView fuenfguthaben = (TextView) findViewById(R.id.fuenfguthaben);
        fuenfguthaben.setText(bestenListe[4][2]);
        TextView fuenfmarktanteil = (TextView) findViewById(R.id.fuenfmarktanteil);
        fuenfmarktanteil.setText(bestenListe[4][3]);


    }

    public void neuesSpiel(){
        IntroductionActivity.Controller.neuesSpiel();
    }

}
