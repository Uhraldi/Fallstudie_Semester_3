package com.example.patsc.fallstudie;
import com.example.patsc.fallstudie.Bestandteile.Armband;
import com.example.patsc.fallstudie.Bestandteile.Designer;
import com.example.patsc.fallstudie.Bestandteile.Gehaeuse;
import com.example.patsc.fallstudie.Bestandteile.Produktionsort;
import com.example.patsc.fallstudie.Bestandteile.Uhrwerk;
import com.example.patsc.fallstudie.Bestandteile.Versandart;
import com.example.patsc.fallstudie.Bestandteile.Wasserdichtheit;
import com.example.patsc.fallstudie.Bestandteile.Werbung;
/**
 * Created by vince on 01.01.2017.
 */

public class Bestellposition {

    private double fixKosten = 0;
    private double varKosten = 0;
    private double pws = 0;
    private double risikoArmband = 0;
    private double risikoGehaeuse = 0;
    private double risikoProduktionsort = 0;
    private double zufall = 0;

    private Armband armband = new Armband();
    private Designer designer = new Designer();
    private Gehaeuse gehaeuse = new Gehaeuse();
    private Produktionsort produktionsort = new Produktionsort();
    private Uhrwerk uhrwerk = new Uhrwerk();
    private Versandart versandart = new Versandart();
    private Wasserdichtheit wasserdichtheit = new Wasserdichtheit();
    private Werbung werbung = new Werbung();

    public Bestellposition(){

    }

    /* Vorlage zum kopieren und ersetzen der Variablen und Klassen
    public void ABCDF(String eingabe){
        switch(eingabe) {
            case "ABCDE": {
                ABCDF.setABCDE(true);
                fixKosten = fixKosten + ABCDF.getABCDEEKP();
                pws = pws + ABCDF.getABCDEPWS();
                break;
            }
            case "ABCDE": {
                ABCDF.setABCDE(true);
                fixKosten = fixKosten + ABCDF.getABCDEEKP();
                pws = pws + ABCDF.getABCDEPWS();
                break;
            }
            case "ABCDE": {
                ABCDF.setABCDE(true);
                fixKosten = fixKosten + ABCDF.getABCDEEKP();
                pws = pws + ABCDF.getABCDEPWS();
                break;
            }
            case "ABCDE": {
                ABCDF.setABCDE(true);
                fixKosten = fixKosten + ABCDF.getABCDEEKP();
                pws = pws + ABCDF.getABCDEPWS();
                break;
            }
            case "ABCDE": {
                ABCDF.setABCDE(true);
                fixKosten = fixKosten + ABCDF.getABCDEEKP();
                pws = pws + ABCDF.getABCDEPWS();
                break;
            }
        }
    }*/

   
    public void bestelleArmband(String eingabe){
        switch(eingabe) {
            case "Leder": {
                armband.setLeder(true);
                varKosten += armband.getLederEKP();
                pws += armband.getLederPWS();
                risikoArmband = armband.getLederRisiko();
                zufall += armband.getLederZufall();
                break;
            }
            case "Kunstleder": {
                armband.setKunstleder(true);
                varKosten += armband.getKunstlederEKP();
                pws += armband.getKunstlederPWS();
                risikoArmband = armband.getKunstlederRisiko();
                zufall += armband.getKunstlederZufall();
                break;
            }
            case "Holz": {
                armband.setHolz(true);
                varKosten += armband.getHolzEKP();
                pws += armband.getHolzPWS();
                risikoArmband = armband.getHolzRisiko();
                zufall += armband.getHolzZufall();
                break;
            }
            case "Textil": {
                armband.setTextil(true);
                varKosten += armband.getTextilEKP();
                pws += armband.getTextilPWS();
                risikoArmband = armband.getTextilRisiko();
                zufall += armband.getTextilZufall();
                break;
            }
            case "Metall": {
                armband.setMetall(true);
                varKosten += armband.getMetallEKP();
                pws += armband.getMetallPWS();
                risikoArmband = armband.getMetallRisiko();
                zufall += armband.getMetallZufall();
                break;
            }
        }
    }

    public void bestelleDesigner(String eingabe){
        switch(eingabe){
            case "Marken": {
                designer.setMarken(true);
                fixKosten += designer.getMarkenEKP();
                pws += designer.getMarkenPWS();
                break;
            }
            case "Mittelmäßig": {
                designer.setMittelmaessig(true);
                fixKosten += designer.getMittelmaessigEKP();
                pws += designer.getMittelmaessigPWS();
            }
            case "LowBudget": {
                designer.setLowBudget(true);
                fixKosten += designer.getLowBudgetEKP();
                pws += designer.getLowBudgetPWS();
            }
        }
    }

    public void bestelleGehaeuse(String eingabe){
        switch(eingabe) {
            case "Glas": {
                gehaeuse.setGlas(true);
                varKosten += gehaeuse.getGlasEKP();
                pws += gehaeuse.getGlasPWS();
                risikoGehaeuse = gehaeuse.getGlasRisiko();
                zufall += gehaeuse.getGlasZufall();
                break;
            }
            case "Holz": {
                gehaeuse.setHolz(true);
                varKosten += gehaeuse.getHolzEKP();
                pws += gehaeuse.getHolzPWS();
                risikoGehaeuse = gehaeuse.getHolzRisiko();
                zufall += gehaeuse.getHolzZufall();
                break;
            }
            case "Kunststoff": {
                gehaeuse.setKunststoff(true);
                varKosten += gehaeuse.getKunststoffEKP();
                pws += gehaeuse.getKunststoffPWS();
                risikoGehaeuse = gehaeuse.getKunststoffRisiko();
                zufall += gehaeuse.getKunststoffZufall();
                break;
            }
            case "Metall": {
                gehaeuse.setMetall(true);
                varKosten += gehaeuse.getMetallEKP();
                pws += gehaeuse.getMetallPWS();
                risikoGehaeuse = gehaeuse.getMetallRisiko();
                zufall += gehaeuse.getMetallZufall();
                break;
            }
        }
    }

    public void bestelleProduktionsort(String eingabe){
        switch(eingabe) {
            case "Deutschland": {
                produktionsort.setDeutschland(true);
                varKosten += produktionsort.getDeutschlandEKP();
                pws += produktionsort.getDeutschlandPWS();
                risikoProduktionsort = produktionsort.getDeutschlandRisiko();
                break;
            }
            case "Asien": {
                produktionsort.setAsien(true);
                varKosten += produktionsort.getAsienEKP();
                pws += produktionsort.getAsienPWS();
                risikoProduktionsort = produktionsort.getAsienRisiko();
                break;
            }
            case "Osteuropa": {
                produktionsort.setOsteuropa(true);
                varKosten += produktionsort.getOsteuropaEKP();
                pws += produktionsort.getOsteuropaPWS();
                risikoProduktionsort = produktionsort.getOsteuropaRisiko();
                break;
            }
            case "Schweiz": {
                produktionsort.setSchweiz(true);
                varKosten += produktionsort.getSchweizEKP();
                pws += produktionsort.getSchweizPWS();
                risikoProduktionsort = produktionsort.getSchweizRisiko();
                break;
            }
        }
    }

    public void bestelleUhrwerk(String eingabe) {
        switch (eingabe) {
            case "Mechanisch": {
                uhrwerk.setMechanisch(true);
                varKosten += uhrwerk.getMechanischEKP();
                pws += uhrwerk.getMechanischPWS();
                break;
            }
            case "Elektromechanisch": {
                uhrwerk.setElektromechanisch(true);
                varKosten += uhrwerk.getElektromechanischEKP();
                pws += uhrwerk.getElektromechanischPWS();
                break;
            }
            case "Elektronisch": {
                uhrwerk.setElektronisch(true);
                varKosten += uhrwerk.getElektronischEKP();
                pws += uhrwerk.getEletronischPWS();
                break;
            }
        }
    }

    public void bestelleVersandart(String eingabe) {
        switch (eingabe) {
            case "Flugzeug": {
                versandart.setFlugzeug(true);
                varKosten += versandart.getFlugzeugEKP();
                pws += versandart.getFlugzeugPWS();
                zufall += versandart.getFlugzeugZufall();
                break;
            }
            case "Schiff": {
                versandart.setSchiff(true);
                varKosten += versandart.getSchiffEKP();
                pws += versandart.getSchiffPWS();
                zufall += versandart.getSchiffZufall();
                break;
            }
            case "Landweg": {
                versandart.setLandweg(true);
                varKosten += versandart.getLandwegEKP();
                pws += versandart.getLandwegPWS();
                zufall += versandart.getLandwegZufall();
                break;
            }
        }
    }

    public void bestelleWasserdichtheit(String eingabe) {
        switch (eingabe) {
            case "Nicht Wassergeschützt": {
                wasserdichtheit.setNichtWassergeschützt(true);
                varKosten += wasserdichtheit.getNichtWassergeschütztEKP();
                pws += wasserdichtheit.getNichtWassergeschütztPWS();
                break;
            }
            case "Spritzwassergeschützt": {
                wasserdichtheit.setSpritzwassergeschützt(true);
                varKosten += wasserdichtheit.getSpritzwassergeschütztEKP();
                pws += wasserdichtheit.getSpritzwassergeschütztPWS();
                break;
            }
            case "Wasserdicht": {
                wasserdichtheit.setWasserdicht(true);
                varKosten += wasserdichtheit.getWasserdichtEKP();
                pws += wasserdichtheit.getWasserdichtPWS();
                break;
            }
        }
    }

    public void bestelleWerbung(String eingabe) {
        switch (eingabe) {
            case "viel": {
                werbung.setViel(true);
                fixKosten += werbung.getVielEKP();
                pws += werbung.getVielPWS();
                break;
            }
            case "mittel": {
                werbung.setMittel(true);
                fixKosten += werbung.getMittelEKP();
                pws += werbung.getMittelPWS();
                break;
            }
            case "wenig": {
                werbung.setWenig(true);
                fixKosten += werbung.getWenigEKP();
                pws += werbung.getWenigPWS();
                break;
            }
        }
    }

    public double getFixKosten() {
        return fixKosten;
    }

    public double getVarKosten() {
        return varKosten;
    }

    public double getPws() {
        return pws;
    }

    public double getRisikoArmband() {
        return risikoArmband;
    }

    public double getRisikoGehaeuse() {
        return risikoGehaeuse;
    }

    public double getRisikoProduktionsort() {
        return risikoProduktionsort;
    }

    public double getZufall() {
        return zufall;
    }
}
