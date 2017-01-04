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
 * testable
 */

public class Bestellposition {

    private double fixKosten = 0;
    private double varKosten = 0;
    private double pws = 0;
    private int menge = 0;
    private double vkp = 0;
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

   
    public void bestelleArmband(String eingabe) throws FalscheEingabe {
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
            default: {
                throw new FalscheEingabe();
            }
        }
    }

    public void bestelleDesigner(String eingabe) throws FalscheEingabe{
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
                break;
            }
            case "LowBudget": {
                designer.setLowBudget(true);
                fixKosten += designer.getLowBudgetEKP();
                pws += designer.getLowBudgetPWS();
                break;
            }
            default: {
                throw new FalscheEingabe();
            }
        }
    }

    public void bestelleGehaeuse(String eingabe) throws FalscheEingabe{
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
            default: {
                throw new FalscheEingabe();
            }
        }
    }

    public void bestelleProduktionsort(String eingabe) throws FalscheEingabe{
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
            default: {
                throw new FalscheEingabe();
            }
        }
    }

    public void bestelleUhrwerk(String eingabe) throws FalscheEingabe{
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
            default: {
                throw new FalscheEingabe();
            }
        }
    }

    public void bestelleVersandart(String eingabe) throws FalscheEingabe {
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
            default: {
                throw new FalscheEingabe();
            }
        }
    }

    public void bestelleWasserdichtheit(String eingabe) throws FalscheEingabe {
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
            default: {
                throw new FalscheEingabe();
            }
        }
    }

    public void bestelleWerbung(String eingabe) throws FalscheEingabe {
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
            default: {
                throw new FalscheEingabe();
            }
        }
    }

    public void bestelleMenge(int menge) throws FalscheEingabe{
        if (menge>0 && menge < 1500) {
            this.menge = menge;
        }else{
            throw new FalscheEingabe();
        }
    }

    public void bestelleVKP(int vkp)throws FalscheEingabe{
        if(vkp > 0 && vkp < 1500) {
            this.vkp = vkp;
        }else{
            throw new FalscheEingabe();
        }
    }

    public void korrigiereArmband(String alteEingabe, String eingabe) throws FalscheEingabe{
        if(alteEingabe.equals("Leder")){
                armband.setLeder(false);
                varKosten -= armband.getLederEKP();
                pws -= armband.getLederPWS();
                risikoArmband = 0;
                zufall -= armband.getLederZufall();
            }else if(alteEingabe.equals("Kunstleder")) {
                armband.setKunstleder(false);
                varKosten -= armband.getKunstlederEKP();
                pws -= armband.getKunstlederPWS();
                risikoArmband = 0;
                zufall -= armband.getKunstlederZufall();
            }else if(alteEingabe.equals("Holz")) {
                armband.setHolz(false);
                varKosten -= armband.getHolzEKP();
                pws -= armband.getHolzPWS();
                risikoArmband = 0;
                zufall -= armband.getHolzZufall();
            }else if(alteEingabe.equals("Textil")) {
                armband.setTextil(false);
                varKosten -= armband.getTextilEKP();
                pws -= armband.getTextilPWS();
                risikoArmband = 0;
                zufall -= armband.getTextilZufall();
            }else if (alteEingabe.equals("Metall")) {
                armband.setMetall(false);
                varKosten -= armband.getMetallEKP();
                pws -= armband.getMetallPWS();
                risikoArmband = 0;
                zufall -= armband.getMetallZufall();
            }else {
                throw new FalscheEingabe();
            }
        bestelleArmband(eingabe);
    }

    public void korrigiereGehaeuse(String alteEingabe, String eingabe) throws FalscheEingabe{
        if(alteEingabe.equals("Glas")){
            gehaeuse.setGlas(false);
            varKosten -= gehaeuse.getGlasEKP();
            pws -= gehaeuse.getGlasPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getGlasZufall();
        }else if (alteEingabe.equals("Holz")){
            gehaeuse.setHolz(false);
            varKosten -= gehaeuse.getHolzEKP();
            pws -= gehaeuse.getHolzPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getHolzZufall();
        }else if (alteEingabe.equals("Kunststoff")){
            gehaeuse.setKunststoff(false);
            varKosten -= gehaeuse.getKunststoffEKP();
            pws -= gehaeuse.getKunststoffPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getKunststoffZufall();
        }else if (alteEingabe.equals("Metall")){
            gehaeuse.setMetall(false);
            varKosten -= gehaeuse.getMetallEKP();
            pws -= gehaeuse.getMetallPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getMetallZufall();
        }else{
            throw new FalscheEingabe();
        }
        bestelleGehaeuse(eingabe);
    }

    public void korrigiereProduktionsort(String alteEingabe, String eingabe) throws FalscheEingabe{
        if(alteEingabe.equals("Deutschland")){
            produktionsort.setDeutschland(false);
            varKosten -= produktionsort.getDeutschlandEKP();
            pws -= produktionsort.getDeutschlandPWS();
            risikoProduktionsort = 0;
        }else if(alteEingabe.equals("Asien")){
            produktionsort.setAsien(false);
            varKosten -= produktionsort.getAsienEKP();
            pws -= produktionsort.getAsienPWS();
            risikoProduktionsort = 0;
        }else if (alteEingabe.equals("Osteuropa")) {
            produktionsort.setOsteuropa(false);
            varKosten -= produktionsort.getOsteuropaEKP();
            pws -= produktionsort.getOsteuropaPWS();
            risikoProduktionsort = 0;
        }else if(alteEingabe.equals("Schweiz")){
            produktionsort.setSchweiz(false);
            varKosten -= produktionsort.getSchweizEKP();
            pws -= produktionsort.getSchweizPWS();
            risikoProduktionsort = 0;
        }else{
            throw new FalscheEingabe();
        }
        bestelleProduktionsort(eingabe);
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

    public int getMenge() {
        return menge;
    }

    public double getVkp() {
        return vkp;
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

    public Designer getDesigner() {
        return designer;
    }

    public Armband getArmband() {
        return armband;
    }

    public Uhrwerk getUhrwerk() {
        return uhrwerk;
    }

    public Gehaeuse getGehaeuse() {
        return gehaeuse;
    }

    public Produktionsort getProduktionsort() {
        return produktionsort;
    }

    public Versandart getVersandart() {
        return versandart;
    }

    public Wasserdichtheit getWasserdichtheit() {
        return wasserdichtheit;
    }

    public Werbung getWerbung() {
        return werbung;
    }
}
