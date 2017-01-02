
package com.example.patsc.fallstudie.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 */

public class Werbung extends Bestandteil {

    //Auswahlen
    private boolean viel = false;
    private boolean mittel = false;
    private boolean wenig = false;

    //EKPs
    private double vielEKP = 5000;
    private double mittelEKP = 3000;
    private double wenigEKP = 1000;

    //PWSs
    private double vielPWS = 0.4;
    private double mittelPWS = 0.2;
    private double wenigPWS = 0.05;



    public Werbung(){
        /*
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
        */
    }

    public boolean isViel() {
        return viel;
    }

    public boolean isMittel() {
        return mittel;
    }

    public boolean isWenig() {
        return wenig;
    }

    public double getVielEKP() {
        return vielEKP;
    }

    public double getMittelEKP() {
        return mittelEKP;
    }

    public double getWenigEKP() {
        return wenigEKP;
    }

    public double getVielPWS() {
        return vielPWS;
    }

    public double getMittelPWS() {
        return mittelPWS;
    }

    public double getWenigPWS() {
        return wenigPWS;
    }


    public void setViel(boolean viel) {
        this.viel = viel;
    }

    public void setMittel(boolean mittel) {
        this.mittel = mittel;
    }

    public void setWenig(boolean wenig) {
        this.wenig = wenig;
    }
}