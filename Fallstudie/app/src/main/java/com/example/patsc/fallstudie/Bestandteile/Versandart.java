package com.example.patsc.fallstudie.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 */

public class Versandart extends Bestandteil {

    public Versandart(){
        super();
        String[] auswahlen = {"Flugzeug", "Schiff", "Landweg"};
        setAuswahl(auswahlen);
        double[] ekps = {0,0,0};
        setEkp(ekps);
        double[] pwss = {0,0,0};
        setRisiko(pwss);
        double[] risiken = {0,0,0};
        setRisiko(risiken);
        double[] trends = {};
        setTrend(trends);
    }
}
