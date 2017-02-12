package com.example.patsc.fallstudie.Covered.Bestandteile;
/**
 * @author Vincent Schmalor
 * Created by vince on 30.12.2016.
 * testable
 */

public class Wasserdichtheit {

    /**Initialisierung zur Quasidatenhaltung*/
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


    /**Konstruktor*/
    public Wasserdichtheit(){

    }


    /**Getter*/
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
    /**End of Getter*/

    /**Setter*/
    public void setNichtWassergeschützt(boolean nichtWassergeschützt) {
        this.nichtWassergeschützt = nichtWassergeschützt;
    }

    public void setSpritzwassergeschützt(boolean spritzwassergeschützt) {
        this.spritzwassergeschützt = spritzwassergeschützt;
    }

    public void setWasserdicht(boolean wasserdicht) {
        this.wasserdicht = wasserdicht;
    }
    /**End of Setter*/
}
