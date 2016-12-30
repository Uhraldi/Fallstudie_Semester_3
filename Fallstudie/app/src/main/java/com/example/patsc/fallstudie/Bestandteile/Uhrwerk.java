package com.example.patsc.fallstudie.Bestandteile;

import com.example.patsc.fallstudie.Bestandteile.Bestandteil;

/**
 * Created by vince on 28.12.2016.
 */

public class Uhrwerk extends Bestandteil {


    public Uhrwerk(){
        super();
        String[] auswahlen = {"Mechanisch", "Elektromechanisch", "Eletrisch"};
        setAuswahl(auswahlen);
        double[] ekps = {4,3,2};
        setEkp(ekps);
        double[] pwss = {0.1,0.0,-0.05};
        setRisiko(pwss);
        double[] risiken = {0.1,0.0,-0.05};
        setRisiko(risiken);
    }
}