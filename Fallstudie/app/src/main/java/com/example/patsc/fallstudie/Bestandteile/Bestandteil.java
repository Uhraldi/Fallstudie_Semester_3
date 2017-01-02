
package com.example.patsc.fallstudie.Bestandteile;
/**
 * Created by vince on 28.12.2016.
 * Diese Klasse ist die Oberklasse, von der die Bestandteile erben
 * Die Bestandteile werden dann vom Benutzer gewählt
 */

public class Bestandteil {

    private double[] ekp;   //ekp = Einkaufspreis / Stück
    private double[] risiko;
    private double[] pws;
    //PWS =Produktwertsteigerung
    //Werte sind in % anzugeben. Bei Multiplikation muss also 1 addiert werden (Bsp. Whl. von 10% entpsicht Eingabe "0.1"
    private double[] trend;     //Gibt an, wie gut das Bestandteil am Markt ankommt. Sollte dem Benutzer nicht angezeigt werden, sondern dient zur Randomisierung des Absatzes
    private boolean[] auswahl;
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
        if(0<=ekp && ekp<=1000)
            this.ekp[i] = ekp;
    }

    public void setEkp(double[] ekp) {
        for(int i=0;i<ekp.length;i++){
            if(0<=ekp[i] && ekp[i]<=10000) {
                this.ekp[i] = ekp[i];
            }
        }
    }


    //Risiko
    public double getRisiko(int i) {
        return risiko[i];
    }

    public double[] getRisiko() {
        return risiko;
    }

    public void setRisiko(int i, double risiko) {
        if(0<=risiko && risiko<=1000)
        this.risiko[i] = risiko;
    }

    public void setRisiko(double[] risiko) {
        for(int i=0;i<risiko.length;i++){
            if(0<=risiko[i] && risiko[i]<=10000) {
        this.risiko[i] = risiko[i];}}
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
        if(0<=pws && pws<=1000)
        this.pws[i] = pws;
    }

    public void setPws(double[] pws){
        for(int i=0;i<pws.length;i++){
            if(0<=pws[i] && pws[i]<=10000) {
        this.pws[i] = pws[i];}}
    }


    //trend
    public double getTrend(int i) {
        return trend[i];
    }

    public double[] getTrend() {
        return trend;
    }

    public void setTrend(int i, double trend) {
        if(0<=trend && trend<=1000)
        this.trend[i] = trend;
    }

    public void setTrend(double[] trend) {
            for(int i=0;i<trend.length;i++){
                if(0<=trend[i] && trend[i]<=10000) {
        this.trend[i] = trend[i];}}
    }

    //Auswahl
    public boolean getAuswahl(int i) {
        return auswahl[i];
    }

    public boolean[] getAuswahl() {
        return auswahl;
    }

    public boolean getActiveAuswahl() {
        return auswahl[active];
    }

    public void setAuswahl(int i, boolean auswahl) {
        this.auswahl[i] = auswahl;
    }

    public void setAuswahl(boolean[] auswahl) {
        this.auswahl = auswahl;
    }
    
    
    
}