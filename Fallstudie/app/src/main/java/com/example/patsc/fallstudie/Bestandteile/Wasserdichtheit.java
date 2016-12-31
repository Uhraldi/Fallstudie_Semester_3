package com.example.patsc.fallstudie.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 */

public class Wasserdichtheit extends Bestandteil {

    public Wasserdichtheit(){
        super();
        String[] auswahlen = {"Nicht Wasserdicht", "Spritzwassergeschützt", "Wasserdicht"};
        setAuswahl(auswahlen);
        double[] ekps = {0,0.5,2};
        setEkp(ekps);
        double[] pwss = {-0.1,0.0,0.15};
        setRisiko(pwss);
        double[] risiken = {0,0,0};
        setRisiko(risiken);
        double[] trends = {};
        setTrend(trends);
    }
}
