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


        //Platz 1
        TextView einspos = (TextView) findViewById(R.id.einspos);
        einspos.setText("");
        TextView einsname = (TextView) findViewById(R.id.einsname);
        einsname.setText(" ");
        TextView einsguthaben = (TextView) findViewById(R.id.einsguthaben);
        einsguthaben.setText("");
        TextView einsmarktanteil = (TextView) findViewById(R.id.einsmarktanteil);
        einsmarktanteil.setText("");


        //Platz2
        TextView zweipos = (TextView) findViewById(R.id.zweipos);
        zweipos.setText("");
        TextView zweiname = (TextView) findViewById(R.id.zweiname);
        zweiname.setText("");
        TextView zweiguthaben = (TextView) findViewById(R.id.zweiguthaben);
        zweiguthaben.setText("");
        TextView zweimarktanteil = (TextView) findViewById(R.id.zweimarktanteil);
        zweimarktanteil.setText("");

        //Platz3
        TextView dreipos = (TextView) findViewById(R.id.dreipos);
        dreipos.setText("");
        TextView dreiname = (TextView) findViewById(R.id.dreiname);
        dreiname.setText("");
        TextView dreiguthaben = (TextView) findViewById(R.id.dreiguthaben);
        dreiguthaben.setText("");
        TextView dreimarktanteil = (TextView) findViewById(R.id.dreimarktanteil);
        dreimarktanteil.setText("");

        //Platz 4
        TextView vierpos = (TextView) findViewById(R.id.vierpos);
        vierpos.setText("");
        TextView viername = (TextView) findViewById(R.id.viername);
        viername.setText("");
        TextView vierguthaben = (TextView) findViewById(R.id.vierguthaben);
        vierguthaben.setText("");
        TextView viermarktanteil = (TextView) findViewById(R.id.viermarktanteil);
        viermarktanteil.setText("");

        //Platz 5
        TextView fuenfpos = (TextView) findViewById(R.id.fuenfpos);
        fuenfpos.setText("");
        TextView fuenfname = (TextView) findViewById(R.id.fuenfname);
        fuenfname.setText("");
        TextView fuenfguthaben = (TextView) findViewById(R.id.fuenfguthaben);
        fuenfguthaben.setText("");
        TextView fuenfmarktanteil = (TextView) findViewById(R.id.fuenfmarktanteil);
        fuenfmarktanteil.setText("");


    }

    public void neuesSpiel(){
        IntroductionActivity.Controller.neuesSpiel();
    }

}
