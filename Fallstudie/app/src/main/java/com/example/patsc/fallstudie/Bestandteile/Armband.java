package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 * testable
 */

public class Armband {

    //Auswahlen
    private boolean leder = false;
    private boolean kunstleder = false;
    private boolean holz = false;
    private boolean textil = false;
    private boolean metall = false;

    //Variable Kosten
    private double VarKostenLeder = 1;
    private double VarKostenKunstleder = 0.2;
    private double VarKostenHolz = 1.45;
    private double VarKostenTextil = 0.1;
    private double VarKostenMetall = 1;

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
    //ToDo
    /*
    Zufall:
     */
    private double lederZufall = Math.random()*0.1;
    private double kunstlederZufall = Math.random()*0.1;
    private double holzZufall = Math.random()*0.1;
    private double textilZufall = Math.random()*0.1;
    private double metallZufall = Math.random()*0.1;

    /**
     * Constructor
     */
    public Armband(){

    }

    public void setLederZufall(double i){
        lederZufall = i;
    }

    public void setHolzZufall(double holzZufall) {
        this.holzZufall = holzZufall;
    }

    public void setKunstlederZufall(double kunstlederZufall) {
        this.kunstlederZufall = kunstlederZufall;
    }

    public void setTextilZufall(double textilZufall) {
        this.textilZufall = textilZufall;
    }

    public void setMetallZufall(double metallZufall) {
        this.metallZufall = metallZufall;
    }

    //Material nicht da Methode im Controller mit String
    public String toString(){

        String stringArmband;
        stringArmband = lederZufall + ":" + kunstlederZufall + ":" + holzZufall + ":" + textilZufall + ":" +metallZufall;
        return stringArmband;
    }

    /**
     * Variablen-Getter
     */
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

    public double getVarKostenLeder() {
        return VarKostenLeder;
    }

    public double getVarKostenKunstleder() {
        return VarKostenKunstleder;
    }

    public double getVarKostenHolz() {
        return VarKostenHolz;
    }

    public double getVarKostenTextil() {
        return VarKostenTextil;
    }

    public double getVarKostenMetall() {
        return VarKostenMetall;
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

    /**
     * Variablen-Setter
     */
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
