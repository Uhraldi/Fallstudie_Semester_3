package com.example.patsc.fallstudie.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 */

public class Wasserdichtheit extends Bestandteil {

    //Auswahlen
    private boolean nichtWassergeschützt = false;
    private boolean spritzwassergeschützt = false;
    private boolean wasserdicht = false;

    //EKPs
    private double nichtWassergeschütztEKP = 0;
    private double spritzwassergeschütztEKP = 0.5;
    private double wasserdichtEKP = 2;

    //PWSs
    private double nichtWassergeschütztPWS = -0.1;
    private double spritzwassergeschütztPWS = 0.0;
    private double wasserdichtPWS = 0.15;



    public Wasserdichtheit(){
        /*
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
        */
    }

    public boolean isNichtWassergeschützt() {
        return nichtWassergeschützt;
    }

    public boolean isSpritzwassergeschützt() {
        return spritzwassergeschützt;
    }

    public boolean isWasserdicht() {
        return wasserdicht;
    }

    public double getNichtWassergeschütztEKP() {
        return nichtWassergeschütztEKP;
    }

    public double getSpritzwassergeschütztEKP() {
        return spritzwassergeschütztEKP;
    }

    public double getWasserdichtEKP() {
        return wasserdichtEKP;
    }

    public double getNichtWassergeschütztPWS() {
        return nichtWassergeschütztPWS;
    }

    public double getSpritzwassergeschütztPWS() {
        return spritzwassergeschütztPWS;
    }

    public double getWasserdichtPWS() {
        return wasserdichtPWS;
    }


    public void setNichtWassergeschützt(boolean nichtWassergeschützt) {
        this.nichtWassergeschützt = nichtWassergeschützt;
    }

    public void setSpritzwassergeschützt(boolean spritzwassergeschützt) {
        this.spritzwassergeschützt = spritzwassergeschützt;
    }

    public void setWasserdicht(boolean wasserdicht) {
        this.wasserdicht = wasserdicht;
    }
}
