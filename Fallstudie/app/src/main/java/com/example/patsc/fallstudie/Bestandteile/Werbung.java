package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 */

public class Werbung extends Bestandteil {

    public Werbung(){
        super();
        String[] auswahlen = {"viel", "mittel", "wenig"};
        setAuswahl(auswahlen);
        double[] ekps = {5000,3000,1000};
        setEkp(ekps);
        double[] pwss = {0.4,0.2,0.5};
        setRisiko(pwss);
        double[] risiken = {0.2,0.2,0.2};
        setRisiko(risiken);
        double[] trends = {};
        setTrend(trends);
    }
}