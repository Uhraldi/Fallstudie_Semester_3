package com.example.patsc.fallstudie;
import com.example.patsc.fallstudie.Bestandteile.*;
/**
 * Created by vince on 01.01.2017.
 * testable
 */

public class Auftrag {

    /**
     * Variablen deklarieren und instanziieren
     */
    private double fixKosten = 0;
    private double varKosten = 0;
    private double pws = 0;
    private int menge = 0;
    private double vkp = 0;
    private double risikoArmband = 0;
    private double risikoGehaeuse = 0;
    private double risikoZusammenbau = 0;
    private double zufall = 0;
    private double strafe = 0;

    /**
     * Objekte deklarieren und instanziieren
     */
    private Armband armband = new Armband();
    private Designer designer = new Designer();
    private Gehaeuse gehaeuse = new Gehaeuse();
    private Zusammenbau zusamenbau = new Zusammenbau();
    private Uhrwerk uhrwerk = new Uhrwerk();
    private Versandart versandart = new Versandart();
    private Wasserdichtheit wasserdichtheit = new Wasserdichtheit();
    private Werbung werbung = new Werbung();
    private Marktsim marktsim = null;
    private Preissimulation preissim = null;

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

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleArmband(String eingabe) throws Exception{
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
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleDesigner(String eingabe) throws Exception{
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
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleGehaeuse(String eingabe) throws Exception{
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
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleZusamenbau(String eingabe) throws Exception{
        switch(eingabe) {
            case "Deutschland": {
                zusamenbau.setDeutschland(true);
                varKosten += zusamenbau.getDeutschlandEKP();
                pws += zusamenbau.getDeutschlandPWS();
                risikoZusammenbau = zusamenbau.getDeutschlandRisiko();
                break;
            }
            case "Asien": {
                zusamenbau.setAsien(true);
                varKosten += zusamenbau.getAsienEKP();
                pws += zusamenbau.getAsienPWS();
                risikoZusammenbau = zusamenbau.getAsienRisiko();
                break;
            }
            case "Osteuropa": {
                zusamenbau.setOsteuropa(true);
                varKosten += zusamenbau.getOsteuropaEKP();
                pws += zusamenbau.getOsteuropaPWS();
                risikoZusammenbau = zusamenbau.getOsteuropaRisiko();
                break;
            }
            case "Schweiz": {
                zusamenbau.setSchweiz(true);
                varKosten += zusamenbau.getSchweizEKP();
                pws += zusamenbau.getSchweizPWS();
                risikoZusammenbau = zusamenbau.getSchweizRisiko();
                break;
            }
            default: {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleUhrwerk(String eingabe) throws Exception{
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
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleVersandart(String eingabe) throws Exception {
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
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleWasserdichtheit(String eingabe) throws Exception {
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
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleWerbung(String eingabe) throws Exception {
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
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param menge = Menge, die im Spinner eingegeben wird und die Menge an herzustellenden Uhren angibt
     */
    public void bestelleMenge(int menge){
            this.menge = menge;
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param vkp = Verkaupspreis, der im Spinner eingegeben wird und den Verkaufspreis bestimmt, zu dem die Uhren am Markt angeboten werden
     */
    public void bestelleVKP(double vkp){
            this.vkp = vkp;
    }

    /**
     * Methode, die ausgelöst wird, wenn das Risikoereignis im Armband ausgelöst woird. Alle relevanten Änderungen an den Variablen weden zurückgerollt und mit der neien eingabe erneut ausgeführt
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void korrigiereArmband( String eingabe) throws Exception{
        if(armband.isLeder()){
                armband.setLeder(false);
                varKosten -= armband.getLederEKP();
                pws -= armband.getLederPWS();
                risikoArmband = 0;
                zufall -= armband.getLederZufall();
            }else if(armband.isKunstleder()) {
                armband.setKunstleder(false);
                varKosten -= armband.getKunstlederEKP();
                pws -= armband.getKunstlederPWS();
                risikoArmband = 0;
                zufall -= armband.getKunstlederZufall();
            }else if(armband.isHolz()) {
                armband.setHolz(false);
                varKosten -= armband.getHolzEKP();
                pws -= armband.getHolzPWS();
                risikoArmband = 0;
                zufall -= armband.getHolzZufall();
            }else if(armband.isTextil()) {
                armband.setTextil(false);
                varKosten -= armband.getTextilEKP();
                pws -= armband.getTextilPWS();
                risikoArmband = 0;
                zufall -= armband.getTextilZufall();
            }else if (armband.isMetall()) {
                armband.setMetall(false);
                varKosten -= armband.getMetallEKP();
                pws -= armband.getMetallPWS();
                risikoArmband = 0;
                zufall -= armband.getMetallZufall();
            }else {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        varKosten += getStrafe(); //Erhöhung der varKosten um eine Strafe max um varKosten*0.05^3 bei 3 Ereignissen
        bestelleArmband(eingabe);
    }

    /**
     * Methode, die ausgelöst wird, wenn das Risikoereignis im Gehaeuse ausgelöst woird. Alle relevanten Änderungen an den Variablen weden zurückgerollt und mit der neien eingabe erneut ausgeführt
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void korrigiereGehaeuse(String eingabe) throws Exception{
        if(gehaeuse.isGlas()){
            gehaeuse.setGlas(false);
            varKosten -= gehaeuse.getGlasEKP();
            pws -= gehaeuse.getGlasPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getGlasZufall();
        }else if (gehaeuse.isHolz()){
            gehaeuse.setHolz(false);
            varKosten -= gehaeuse.getHolzEKP();
            pws -= gehaeuse.getHolzPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getHolzZufall();
        }else if (gehaeuse.isKunststoff()){
            gehaeuse.setKunststoff(false);
            varKosten -= gehaeuse.getKunststoffEKP();
            pws -= gehaeuse.getKunststoffPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getKunststoffZufall();
        }else if (gehaeuse.isMetall()){
            gehaeuse.setMetall(false);
            varKosten -= gehaeuse.getMetallEKP();
            pws -= gehaeuse.getMetallPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getMetallZufall();
        }else{
            throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
        }
        varKosten += getStrafe();
        bestelleGehaeuse(eingabe);
    }

    /**
     * Methode, die ausgelöst wird, wenn das Risikoereignis im Zusammenbau ausgelöst woird. Alle relevanten Änderungen an den Variablen weden zurückgerollt und mit der neien eingabe erneut ausgeführt
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void korrigiereZusammenbau(String eingabe) throws Exception{
        if(zusamenbau.isDeutschland()){
            zusamenbau.setDeutschland(false);
            varKosten -= zusamenbau.getDeutschlandEKP();
            pws -= zusamenbau.getDeutschlandPWS();
            risikoZusammenbau = 0;
        }else if(zusamenbau.isAsien()){
            zusamenbau.setAsien(false);
            varKosten -= zusamenbau.getAsienEKP();
            pws -= zusamenbau.getAsienPWS();
            risikoZusammenbau = 0;
        }else if (zusamenbau.isOsteuropa()) {
            zusamenbau.setOsteuropa(false);
            varKosten -= zusamenbau.getOsteuropaEKP();
            pws -= zusamenbau.getOsteuropaPWS();
            risikoZusammenbau = 0;
        }else if(zusamenbau.isSchweiz()){
            zusamenbau.setSchweiz(false);
            varKosten -= zusamenbau.getSchweizEKP();
            pws -= zusamenbau.getSchweizPWS();
            risikoZusammenbau = 0;
        }else{
            throw new Exception();
        }
        varKosten += getStrafe();
        bestelleZusamenbau(eingabe);
    }


    /**
     *  Variablen-Getter
     */
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

    public double getRisikoZusammenbau() {
        return risikoZusammenbau;
    }

    public double getZufall() {
        return zufall;
    }

    public double getStrafe(){
        strafe = vkp*0.05;
        return strafe;
    }

    /**
     * Bestandteil-Getter
     */
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

    public Zusammenbau getZusammenbau() {
        return zusamenbau;
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

    public Preissimulation getPreissimulation(){
        return preissim;
    }

    public Marktsim getMarktsim(){
        return marktsim;
    }

    /**
     * Objekt-Setter
     */
    public void setMarktsim(Marktsim marktsim) {
        this.marktsim = marktsim;
    }

    public void setPreissim(Preissimulation preissim) {
        this.preissim = preissim;
    }
}
