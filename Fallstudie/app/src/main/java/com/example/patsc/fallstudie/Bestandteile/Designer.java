package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 */

public class Designer extends Bestandteil {

    public Designer() {
        super();
        String[] auswahlen = {"Markendesigner", "Mittelmäßiger Designer", "Low-Budget-Designer"};
        setAuswahl(auswahlen);
        double[] ekps = {5000,3000,1000};
        setEkp(ekps);
        double[] pwss = {0.4, 0.2, 0.05};
        setRisiko(pwss);
        double[] risiken = {0.01, 0.05, 0.2};
        setRisiko(risiken);
        double[] trends = {};
        setTrend(trends);
    }
}
