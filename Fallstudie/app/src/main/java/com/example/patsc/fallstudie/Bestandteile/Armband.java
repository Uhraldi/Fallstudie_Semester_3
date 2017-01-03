package com.example.patsc.fallstudie.Bestandteile;

import java.util.Random;

/**
 * Created by vince on 30.12.2016.
 */

public class Armband {

    //Auswahlen
    private boolean leder = false;
    private boolean kunstleder = false;
    private boolean holz = false;
    private boolean textil = false;
    private boolean metall = false;

    //EKPs
    private double lederEKP = 1;
    private double kunstlederEKP = 0.2;
    private double holzEKP = 1.45;
    private double textilEKP = 0.1;
    private double metallEKP = 1;

    //PWSs
    private double lederPWS = 0.2;
    private double kunstlederPWS = 0;
    private double holzPWS = 0.05;
    private double textilPWS = -0.1;
    private double metallPWS = 0.1;

    //Risiken
    private double lederRisiko = 0.08;
    private double kunstlederRisiko = 0.04;
    private double holzRisiko = 0.12;
    private double textilRisiko = 0.08;
    private double metallRisiko = 0.08;

    //Zufall (z.B. Beliebtheit)
    private double lederZufall = Math.random()*0.1;
    private double kunstlederZufall = Math.random()*0.1;
    private double holzZufall = Math.random()*0.1;
    private double textilZufall = Math.random()*0.1;
    private double metallZufall = Math.random()*0.1;


    public Armband(){

    }

    public boolean isLeder() {
        return leder;
    }

    public boolean isKunstleder() {
        return kunstleder;
    }

    public boolean isHolz() {
        return holz;
    }

    public boolean isTextil() {
        return textil;
    }

    public boolean isMetall() {
        return metall;
    }

    public double getLederEKP() {
        return lederEKP;
    }

    public double getKunstlederEKP() {
        return kunstlederEKP;
    }

    public double getHolzEKP() {
        return holzEKP;
    }

    public double getTextilEKP() {
        return textilEKP;
    }

    public double getMetallEKP() {
        return metallEKP;
    }

    public double getLederPWS() {
        return lederPWS;
    }

    public double getKunstlederPWS() {
        return kunstlederPWS;
    }

    public double getHolzPWS() {
        return holzPWS;
    }

    public double getTextilPWS() {
        return textilPWS;
    }

    public double getMetallPWS() {
        return metallPWS;
    }

    public double getLederRisiko() {
        return lederRisiko;
    }

    public double getKunstlederRisiko() {
        return kunstlederRisiko;
    }

    public double getHolzRisiko() {
        return holzRisiko;
    }

    public double getTextilRisiko() {
        return textilRisiko;
    }

    public double getMetallRisiko() {
        return metallRisiko;
    }

    public double getLederZufall() {
        return lederZufall;
    }

    public double getKunstlederZufall() {
        return kunstlederZufall;
    }

    public double getHolzZufall() {
        return holzZufall;
    }

    public double getTextilZufall() {
        return textilZufall;
    }

    public double getMetallZufall() {
        return metallZufall;
    }

    public void setLeder(boolean leder) {
        this.leder = leder;
    }

    public void setKunstleder(boolean kunstleder) {
        this.kunstleder = kunstleder;
    }

    public void setHolz(boolean holz) {
        this.holz = holz;
    }

    public void setTextil(boolean textil) {
        this.textil = textil;
    }

    public void setMetall(boolean metall) {
        this.metall = metall;
    }
}
