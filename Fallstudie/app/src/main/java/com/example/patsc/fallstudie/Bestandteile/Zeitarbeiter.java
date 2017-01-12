package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 * testable
 */

public class Zeitarbeiter {

    //Auswahlen
    private boolean Geselle = false;
    private boolean Praktikant = false;
    private boolean Lehrling = false;
    private boolean Meister = false;

    //EKPs
    private double GeselleEKP = 0.45;
    private double PraktikantEKP = 0.5;
    private double LehrlingEKP = 0.5;
    private double MeisterEKP = 5;

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


    public Zeitarbeiter(){

    }

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

    public double getGeselleEKP() {
        return GeselleEKP;
    }

    public double getPraktikantEKP() {
        return PraktikantEKP;
    }

    public double getLehrlingEKP() {
        return LehrlingEKP;
    }

    public double getMeisterEKP() {
        return MeisterEKP;
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
}