package com.example.patsc.fallstudie.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 */

public class Versandart extends Bestandteil {

    //Auswahlen
    private boolean flugzeug = false;
    private boolean schiff = false;
    private boolean landweg = false;

    //EKPs
    private double flugzeugEKP = 5000;
    private double schiffEKP = 3000;
    private double landwegEKP = 1000;

    //PWSs
    private double flugzeugPWS = 0.4;
    private double schiffPWS = 0.2;
    private double landwegPWS = 0.05;

    //Time-to-Market (wird behandelt wie Zufall aber mit fixen werten
    private double flugzeugZufall = 0.1;
    private double schiffZufall = 0;
    private double landwegZufall = -0.1;



    public Versandart(){
        /*
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
        */
    }

    public boolean isFlugzeug() {
        return flugzeug;
    }

    public boolean isSchiff() {
        return schiff;
    }

    public boolean isLandweg() {
        return landweg;
    }

    public double getFlugzeugEKP() {
        return flugzeugEKP;
    }

    public double getSchiffEKP() {
        return schiffEKP;
    }

    public double getLandwegEKP() {
        return landwegEKP;
    }

    public double getFlugzeugPWS() {
        return flugzeugPWS;
    }

    public double getSchiffPWS() {
        return schiffPWS;
    }

    public double getLandwegPWS() {
        return landwegPWS;
    }

    public double getFlugzeugZufall() {
        return flugzeugZufall;
    }

    public double getSchiffZufall() {
        return schiffZufall;
    }

    public double getLandwegZufall() {
        return landwegZufall;
    }


    public void setFlugzeug(boolean flugzeug) {
        this.flugzeug = flugzeug;
    }

    public void setSchiff(boolean schiff) {
        this.schiff = schiff;
    }

    public void setLandweg(boolean landweg) {
        this.landweg = landweg;
    }
}
