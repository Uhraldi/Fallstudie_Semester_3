package com.example.patsc.fallstudie.Covered.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 * testable
 */

public class Gehaeuse {

    //Auswahlen
    private boolean glas = false;
    private boolean holz = false;
    private boolean kunststoff = false;
    private boolean metall = false;

    //Variable Kosten
    private double VarKostenGlas = 2;
    private double VarKostenHolz = 1.5;
    private double VarKostenKunststoff = 0.2;
    private double VarKostenMetall = 1;

    //PWSs
    private double glasPWS = 0.2;
    private double holzPWS = 0.05;
    private double kunststoffPWS = -0.1;
    private double metallPWS = 0.1;

    //Risiken
    private double glasRisiko = 0.06;
    private double holzRisiko = 0.12;
    private double kunststoffRisiko = 0.8;
    private double metallRisiko = 0.08;

    //Zufall
    private double glasZufall = Math.random()*0.1;
    private double holzZufall = Math.random()*0.1;
    private double kunststoffZufall = Math.random()*0.1;
    private double metallZufall = Math.random()*0.1;

    /**
     * Constructor
     */
    public Gehaeuse(){

    }

    public void setHolzZufall(double holzZufall) {
        this.holzZufall = holzZufall;
    }

    public void setGlasZufall(double glasZufall) {
        this.glasZufall = glasZufall;
    }

    public void setKunststoffZufall(double kunststoffZufall) {
        this.kunststoffZufall = kunststoffZufall;
    }

    public void setMetallZufall(double metallZufall) {
        this.metallZufall = metallZufall;
    }

    public String toString(){
        String gehauseString;
        gehauseString = glasZufall + ":" +holzZufall+ ":" +kunststoffZufall+ ":" +metallZufall;
        return gehauseString;
    }

    /**
     * Variablen-Getter
     */
    public boolean isGlas() {
        return glas;
    }

    public boolean isHolz() {
        return holz;
    }

    public boolean isKunststoff() {
        return kunststoff;
    }

    public boolean isMetall() {
        return metall;
    }

    public double getVarKostenGlas() {
        return VarKostenGlas;
    }

    public double getVarKostenHolz() {
        return VarKostenHolz;
    }

    public double getVarKostenKunststoff() {
        return VarKostenKunststoff;
    }

    public double getVarKostenMetall() {
        return VarKostenMetall;
    }

    public double getGlasPWS() {
        return glasPWS;
    }

    public double getHolzPWS() {
        return holzPWS;
    }

    public double getKunststoffPWS() {
        return kunststoffPWS;
    }

    public double getMetallPWS() {
        return metallPWS;
    }

    public double getGlasRisiko() {
        return glasRisiko;
    }

    public double getHolzRisiko() {
        return holzRisiko;
    }

    public double getKunststoffRisiko() {
        return kunststoffRisiko;
    }

    public double getMetallRisiko() {
        return metallRisiko;
    }

    public double getGlasZufall() {
        return glasZufall;
    }

    public double getHolzZufall() {
        return holzZufall;
    }

    public double getKunststoffZufall() {
        return kunststoffZufall;
    }

    public double getMetallZufall() {
        return metallZufall;
    }

    /**
     * Variablen.Setter
     */
    public void setGlas(boolean glas) {
        this.glas = glas;
    }

    public void setHolz(boolean holz) {
        this.holz = holz;
    }

    public void setKunststoff(boolean kunststoff) {
        this.kunststoff = kunststoff;
    }

    public void setMetall(boolean metall) {
        this.metall = metall;
    }
}