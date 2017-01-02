package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 28.12.2016.
 */

public class Uhrwerk extends Bestandteil{

    //Auswahlen
    private boolean mechanisch = false;
    private boolean elektromechanisch = false;
    private boolean elektronisch = false;

    //EKPs
    private double mechanischEKP = 4;
    private double elektromechanischEKP = 3;
    private double elektronischEKP = 2;

    //PWSs
    private double mechanischPWS = 0.1;
    private double elektromechanischPWS = 0;
    private double eletronischPWS = 0.05;



    public Uhrwerk(){
        /*
        super();
        String[] auswahlen = {"Mechanisch", "Elektromechanisch", "Eletrisch"};
        setAuswahl(auswahlen);
        double[] ekps = {4,3,2};
        setEkp(ekps);
        double[] pwss = {0.1,0.0,-0.05};
        setRisiko(pwss);
        double[] risiken = {0.1,0.0,-0.05};
        setRisiko(risiken);
        double[] trends = {};
        setTrend(trends);
        */
    }

    public boolean isMechanisch() {
        return mechanisch;
    }

    public boolean isElektromechanisch() {
        return elektromechanisch;
    }

    public boolean isElektronisch() {
        return elektronisch;
    }

    public double getMechanischEKP() {
        return mechanischEKP;
    }

    public double getElektromechanischEKP() {
        return elektromechanischEKP;
    }

    public double getElektronischEKP() {
        return elektronischEKP;
    }

    public double getMechanischPWS() {
        return mechanischPWS;
    }

    public double getElektromechanischPWS() {
        return elektromechanischPWS;
    }

    public double getEletronischPWS() {
        return eletronischPWS;
    }

    public void setMechanisch(boolean mechanisch) {
        this.mechanisch = mechanisch;
    }

    public void setElektromechanisch(boolean elektromechanisch) {
        this.elektromechanisch = elektromechanisch;
    }

    public void setElektronisch(boolean elektronisch) {
        this.elektronisch = elektronisch;
    }
}