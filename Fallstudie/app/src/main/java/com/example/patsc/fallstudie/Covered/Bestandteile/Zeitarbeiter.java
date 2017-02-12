package com.example.patsc.fallstudie.Covered.Bestandteile;

/**
 * @author Vincent Schmalor
 * Created by vince on 30.12.2016.
 * testable
 */

public class Zeitarbeiter {

    /**Initialisierung zur Quasidatenhaltung*/
    //Auswahlen
    private boolean Geselle = false;
    private boolean Praktikant = false;
    private boolean Lehrling = false;
    private boolean Meister = false;

    //Variable Kosten
    private double VarKostenGeselle = 4.5;
    private double VarKostenPraktikant = 0.5;
    private double VarKostenLehrling = 0.5;
    private double VarKostenMeister = 5;

    //PWSs
    private double GesellePWS = 0.2;
    private double PraktikantPWS = -0.05;
    private double LehrlingPWS = -0.05;
    private double MeisterPWS = 0.25;

    //Risiken
    private double GeselleRisiko = 0.08;
    private double PraktikantRisiko = 0.17;
    private double LehrlingRisiko = 0.13;
    private double MeisterRisiko = 0.05;

    private double GeselleZufall = Math.random()*0.1;
    private double PraktikantZufall = Math.random()*0.1;
    private double LehrlingZufall = Math.random()*0.1;
    private double MeisterZufall = Math.random()*0.1;


    /**Konstruktor*/
    public Zeitarbeiter() {

    }


    /**Getter*/
    public boolean isGeselle() {
        return Geselle;
    }

    public boolean isPraktikant() {
        return Praktikant;
    }

    public boolean isLehrling() {
        return Lehrling;
    }

    public boolean isMeister() {
        return Meister;
    }

    public double getVarKostenGeselle() {
        return VarKostenGeselle;
    }

    public double getVarKostenPraktikant() {
        return VarKostenPraktikant;
    }

    public double getVarKostenLehrling() {
        return VarKostenLehrling;
    }

    public double getVarKostenMeister() {
        return VarKostenMeister;
    }

    public double getGesellePWS() {
        return GesellePWS;
    }

    public double getPraktikantPWS() {
        return PraktikantPWS;
    }

    public double getLehrlingPWS() {
        return LehrlingPWS;
    }

    public double getMeisterPWS() {
        return MeisterPWS;
    }

    public double getGeselleRisiko() {
        return GeselleRisiko;
    }

    public double getPraktikantRisiko() {
        return PraktikantRisiko;
    }

    public double getLehrlingRisiko() {
        return LehrlingRisiko;
    }

    public double getMeisterRisiko() {
        return MeisterRisiko;
    }
    /**End of Getter*/

    /**Setter*/
    public void setGeselle(boolean geselle) {
        this.Geselle = geselle;
    }

    public void setPraktikant(boolean Praktikant) {
        this.Praktikant = Praktikant;
    }

    public void setLehrling(boolean Lehrling) {
        this.Lehrling = Lehrling;
    }

    public void setMeister(boolean Meister) {
        this.Meister = Meister;
    }
    /**End of Setter*/
}