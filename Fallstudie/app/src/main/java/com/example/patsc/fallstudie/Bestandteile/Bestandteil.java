package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 28.12.2016.
 * Diese Klasse ist die Oberklasse, von der die Bestandteile erben
 * Die Bestandteile werden dann vom Benutzer gewählt
 */

public class Bestandteil {

    private String[] auswahl;
    private double[] ekp;   //ekp = Einkaufspreis / Stück
    private double[] pws;
        //PWS =Produktwertsteigerung
        //Werte sind in % anzugeben. Bei Multiplikation muss also 1 addiert werden (Bsp. Whl. von 10% entpsicht Eingabe "0.1"
    private double[] risiko;
    private int active=0; //Die aktive Auswahl wird mit diesem int gekennzeichnet. Er entspricht der Position im Stringarray auswahl


    //EKP
    public double getEkp(int i) {
        return ekp[i];
    }

    public double[] getEkp() {
        return ekp;
    }

    public double getActiveEkp() {
        return ekp[active];
    }

    public void setEkp(int i, float ekp) {
        this.ekp[i] = ekp;
    }

    public void setEkp(double[] ekp) {
        this.ekp = ekp;
    }


    //Risiko
    public double getRisiko(int i) {
        return risiko[i];
    }

    public double[] getRisiko() {
        return risiko;
    }

    public void setRisiko(int i, double risiko) {
        this.risiko[i] = risiko;
    }

    public void setRisiko(double[] risiko) {
        this.risiko = risiko;
    }


    //PWS
    public double getPws(int i) {
        return pws[i];
    }

    public double[] getPws() {
        return pws;
    }

    public double getActivePws() {
        return pws[active];
    }

    public void setPws(int i, double pws) {
        this.pws[i] = pws;
    }

    public void setPws(double[] pws){
        this.pws = pws;
    }


    //Auswahl
    public String getAuswahl(int i) {
        return auswahl[i];
    }

    public String[] getAuswahl() {
        return auswahl;
    }

    public String getActiveAuswahl() {
        return auswahl[active];
    }

    public void setAuswahl(int i, String auswahl) {
        this.auswahl[i] = auswahl;
    }

    public void setAuswahl(String[] auswahl) {
        this.auswahl = auswahl;
    }
}