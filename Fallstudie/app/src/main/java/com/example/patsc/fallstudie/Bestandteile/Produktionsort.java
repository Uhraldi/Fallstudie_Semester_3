package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 */

public class Produktionsort {

    //Auswahlen
    private boolean deutschland = false;
    private boolean asien = false;
    private boolean osteuropa = false;
    private boolean schweiz = false;

    //EKPs
    private double deutschlandEKP = 0.45;
    private double asienEKP = 0.5;
    private double osteuropaEKP = 0.5;
    private double schweizEKP = 5;

    //PWSs
    private double deutschlandPWS = 0.2;
    private double asienPWS = -0.05;
    private double osteuropaPWS = -0.05;
    private double schweizPWS = 0.25;

    //Risiken
    private double deutschlandRisiko = 0.08;
    private double asienRisiko = 0.17;
    private double osteuropaRisiko = 0.13;
    private double schweizRisiko = 0.05;


    public Produktionsort(){

    }

    public boolean isDeutschland() {
        return deutschland;
    }

    public boolean isAsien() {
        return asien;
    }

    public boolean isOsteuropa() {
        return osteuropa;
    }

    public boolean isSchweiz() {
        return schweiz;
    }

    public double getDeutschlandEKP() {
        return deutschlandEKP;
    }

    public double getAsienEKP() {
        return asienEKP;
    }

    public double getOsteuropaEKP() {
        return osteuropaEKP;
    }

    public double getSchweizEKP() {
        return schweizEKP;
    }

    public double getDeutschlandPWS() {
        return deutschlandPWS;
    }

    public double getAsienPWS() {
        return asienPWS;
    }

    public double getOsteuropaPWS() {
        return osteuropaPWS;
    }

    public double getSchweizPWS() {
        return schweizPWS;
    }

    public double getDeutschlandRisiko() {
        return deutschlandRisiko;
    }

    public double getAsienRisiko() {
        return asienRisiko;
    }

    public double getOsteuropaRisiko() {
        return osteuropaRisiko;
    }

    public double getSchweizRisiko() {
        return schweizRisiko;
    }


    public void setDeutschland(boolean deutschland) {
        this.deutschland = deutschland;
    }

    public void setAsien(boolean asien) {
        this.asien = asien;
    }

    public void setOsteuropa(boolean osteuropa) {
        this.osteuropa = osteuropa;
    }

    public void setSchweiz(boolean schweiz) {
        this.schweiz = schweiz;
    }
}