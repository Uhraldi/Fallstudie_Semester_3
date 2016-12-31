package com.example.patsc.fallstudie.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 */

public class Armband extends Bestandteil {

    public Armband(){
        super();
        String[] auswahlen = {"Leder", "Kunstleder", "Holz", "Textil", "Metall"};
        setAuswahl(auswahlen);
        double[] ekps = {1, 0.2, 1.45, 0.1, 1};
        setEkp(ekps);
        double[] pwss = {0.2, 0, 0.05, -0.1, 0.1};
        setRisiko(pwss);
        double[] risiken = {};
        setRisiko(risiken);
        double[] trends = {0.1, 0.1, 0.1, 0.1, 0.1};
        setTrend(trends);
    }
}
