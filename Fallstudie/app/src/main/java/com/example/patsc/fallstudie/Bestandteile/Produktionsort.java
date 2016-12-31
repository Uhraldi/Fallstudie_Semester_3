package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 */

public class Produktionsort extends Bestandteil{

    public Produktionsort(){
        super();
        String[] auswahlen = {"Deutschland", "Asien", "Osteuropa", "Schweiz"};
        setAuswahl(auswahlen);
        double[] ekps = {4.5,0.5,0.5,5};
        setEkp(ekps);
        double[] pwss = {0.2,-0.05,-0.05,0.25};
        setRisiko(pwss);
        double[] risiken = {0,0.15,0.10,0};
        setRisiko(risiken);
        double[] trends = {0.1,0.1,0.1,0.1};
        setTrend(trends);
    }
}
