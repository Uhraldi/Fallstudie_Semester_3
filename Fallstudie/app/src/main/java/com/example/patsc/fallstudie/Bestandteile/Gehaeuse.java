package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 */

public class Gehaeuse extends Bestandteil{

    public Gehaeuse(){
        super();
        String[] auswahlen = {"Glas", "Holz", "Kunststoff", "Metall"};
        setAuswahl(auswahlen);
        double[] ekps = {2, 1.5, 0.2, 1};
        setEkp(ekps);
        double[] pwss = {0.2, 0.05, -0.1, 0.1};
        setRisiko(pwss);
        double[] risiken = {};
        setRisiko(risiken);
        double[] trends = {};
        setTrend(trends);
    }
}