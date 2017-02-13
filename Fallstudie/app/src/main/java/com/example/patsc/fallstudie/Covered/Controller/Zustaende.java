package com.example.patsc.fallstudie.Covered.Controller;

import com.example.patsc.fallstudie.Covered.Auftragssammlung;
import com.example.patsc.fallstudie.Covered.Spieler;

/**
 * Created by Patricia Schneider.
 *
 * In dieser Klasse wird das Interface Zustaende implentiert.
 * Hier finden alle Prüfungen statt, in welchem Zustand bzw. Schritt sich das Spiel aktuell befindet.
 * Dadurch soll sicher gestellt werden, dass unter anterdem bei der Produktion stehts alle Werte gesetzt wurden
 * und es nicht zu Null-Pointer Fehlern kommen kann.
 */

public abstract class Zustaende extends SuperController implements IZustaende {

    /**
     * Mögliche Zustaende in den sich das Spiel befinden kann.
     * Initial Wert nur für Spielbeginn true, da nur so einloggen bzw registrieren möglich ist.
     * Es darf imme nur ein Zustand true sein.
     * Die Reihenfolge muss beachtet werden.
     * Diese ist Spiel
     */
    private boolean Zustand_Ende = false;
    private boolean Zustand_Spielbeginn = true;
    private boolean Zustand_Bestellung = false;
    private boolean Zustand_Ereignis = false;
    private boolean Zustand_Lieferung = false;

    /**
     * Schritte, die während des Auswahlprozesses für die Produktion durchlaufen werden müssen.
     *
     */
    private boolean SCHRITT_FORSCHUNG_boolean = false;// erster Schritt Wahl des Designers
    private boolean SCHRITT_ARMBAND_boolean  = false;// zweite Schritt Wahl des Armbands
    private boolean SCHRITT_UHRWERK_boolean  = false;// dritter Schritt Wahl des Uhrwerks und der Uhrenart
    private boolean SCHRITT_GEHAUESE_boolean  = false;// vierter Schritt Wahl des Gehäuses für die Uhr
    private boolean SCHRITT_ZEITARBEITER_boolean = false;// sechster Schritt Wahl Zeitarbeiter
    private boolean SCHRITT_MARKETING_boolean = false; // siebter Schritt Wahl des Werbeetars
    private boolean SCHRITT_PRODUKTIONSVOLUMEN_boolean = false; // achter Schritt Wahl des Kaufvolumens
    private boolean SCHRITT_BEZAHLART_boolean = false; // neunter Schritt Wahl der Bezahlart
    private boolean SCHRITT_VERKAUFSPREIS_boolean = false;
    private boolean SCHRITT_PERSONALWESEN_boolean = false;

    // Zustands Variablen fuer die Aenderungen
    private boolean AENDERE_ARMBAND_boolean=false;
    private boolean AENDERE_GEHAEUSE_boolean =false;
    private boolean AENDERE_ZEITARBEITER_boolean = false;

    /**
     * Setter Methoden
     *
     */
    public void setAENDERE_ARMBAND_boolean(boolean AENDERE_ARMBAND_boolean) {
        this.AENDERE_ARMBAND_boolean = AENDERE_ARMBAND_boolean;
    }
    public void setAENDERE_GEHAEUSE_boolean(boolean AENDERE_GEHAEUSE_boolean) {
        this.AENDERE_GEHAEUSE_boolean = AENDERE_GEHAEUSE_boolean;
    }
    public void setAENDERE_ZEITARBEITER_boolean(boolean AENDERE_ZEITARBEITER_boolean) {
        this.AENDERE_ZEITARBEITER_boolean = AENDERE_ZEITARBEITER_boolean;
    }
    public void setSCHRITT_ARMBAND_boolean(boolean SCHRITT_ARMBAND_boolean) {
        this.SCHRITT_ARMBAND_boolean = SCHRITT_ARMBAND_boolean;
    }
    public void setSCHRITT_FORSCHUNG_boolean(boolean SCHRITT_FORSCHUNG_boolean) {
        this.SCHRITT_FORSCHUNG_boolean = SCHRITT_FORSCHUNG_boolean;
    }
    public void setSCHRITT_GEHAUESE_boolean(boolean SCHRITT_GEHAUESE_boolean) {
        this.SCHRITT_GEHAUESE_boolean = SCHRITT_GEHAUESE_boolean;
    }
    public void setSCHRITT_PRODUKTIONSVOLUMEN_boolean(boolean SCHRITT_PRODUKTIONSVOLUMEN_boolean) {
        this.SCHRITT_PRODUKTIONSVOLUMEN_boolean = SCHRITT_PRODUKTIONSVOLUMEN_boolean;
    }
    public void setSCHRITT_UHRWERK_boolean(boolean SCHRITT_UHRWERK_boolean) {
        this.SCHRITT_UHRWERK_boolean = SCHRITT_UHRWERK_boolean;
    }
    public void setSCHRITT_VERKAUFSPREIS_boolean(boolean SCHRITT_VERKAUFSPREIS_boolean) {
        this.SCHRITT_VERKAUFSPREIS_boolean = SCHRITT_VERKAUFSPREIS_boolean;
    }
    public void setSCHRITT_BEZAHLART_boolean(boolean SCHRITT_BEZAHLART_boolean) {
        this.SCHRITT_BEZAHLART_boolean = SCHRITT_BEZAHLART_boolean;
    }
    public void setSCHRITT_MARKETING_boolean(boolean SCHRITT_MARKETING_boolean) {
        this.SCHRITT_MARKETING_boolean = SCHRITT_MARKETING_boolean;
    }
    public void setSCHRITT_ZEITARBEITER_boolean(boolean SCHRITT_ZEITARBEITER_boolean) {
        this.SCHRITT_ZEITARBEITER_boolean = SCHRITT_ZEITARBEITER_boolean;
    }
    public void setZustand_Spielbeginn(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Spielbeginn = true;
    }
    public void setZustand_Ereignis(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Ereignis = true;
    }

    /**
     * Getter Methoden
     */
    public boolean isAENDERE_ARMBAND_boolean() {
        return AENDERE_ARMBAND_boolean;
    }
    public boolean isAENDERE_GEHAEUSE_boolean() {
        return AENDERE_GEHAEUSE_boolean;
    }
    public boolean isAENDERE_ZEITARBEITER_boolean() {
        return AENDERE_ZEITARBEITER_boolean;
    }
    public boolean isSCHRITT_ARMBAND_boolean() {
        return SCHRITT_ARMBAND_boolean;
    }
    public boolean isSCHRITT_FORSCHUNG_boolean() {
        return SCHRITT_FORSCHUNG_boolean;
    }
    public boolean isSCHRITT_GEHAUESE_boolean() {
        return SCHRITT_GEHAUESE_boolean;
    }
    public boolean isSCHRITT_PRODUKTIONSVOLUMEN_boolean() {
        return SCHRITT_PRODUKTIONSVOLUMEN_boolean;
    }
    public boolean isSCHRITT_UHRWERK_boolean() {
        return SCHRITT_UHRWERK_boolean;
    }
    public boolean isSCHRITT_VERKAUFSPREIS_boolean() {
        return SCHRITT_VERKAUFSPREIS_boolean;
    }
    public boolean isSCHRITT_BEZAHLART_boolean() {
        return SCHRITT_BEZAHLART_boolean;
    }
    public boolean isSCHRITT_MARKETING_boolean() {
        return SCHRITT_MARKETING_boolean;
    }
    public boolean isSCHRITT_ZEITARBEITER_boolean() {
        return SCHRITT_ZEITARBEITER_boolean;
    }
    public boolean isZustand_Spielbeginn(){return Zustand_Spielbeginn;}
    public boolean isZustand_Bestellung(){return Zustand_Bestellung;}
    public boolean isZustand_Ereignis(){return Zustand_Ereignis;}

    public String getSCHRITT_VERKAUFSPREIS() {
        return SCHRITT_VERKAUFSPREIS;
    }
    public String getARMBAND_WAHL_LEDER() {
        return ARMBAND_WAHL_LEDER;
    }
    public String getGEHAEUSE_WAHL_METALL() {
        return GEHAEUSE_WAHL_METALL;
    }
    public String getSCHRITT_ARMBAND() {
        return SCHRITT_ARMBAND;
    }
    public String getSCHRITT_FORSCHUNG() {


        return SCHRITT_FORSCHUNG;
    }

    public String getSCHRITT_PRODUKTIONSVOLUMEN() {
        return SCHRITT_PRODUKTIONSVOLUMEN;
    }
    public String getSCHRITT_UHRWERK() {
        return SCHRITT_UHRWERK;
    }
    public String getZEITARBEITER_WAHL_Lehrling() {
        return ZEITARBEITER_WAHL_Lehrling;
    }

    public void setzeZustaendeAendere(boolean b){
        AENDERE_ARMBAND_boolean=b;
        AENDERE_GEHAEUSE_boolean =b;
        AENDERE_ZEITARBEITER_boolean = b;
    }

    /**
     * Alle IZustaende werden auf false gesetzt
     */
    protected void setzeAlleZustaendeFalse(){
        Zustand_Bestellung = false;
        Zustand_Ende = false;
        Zustand_Ereignis = false;
        Zustand_Lieferung = false;
        Zustand_Spielbeginn = false;

    }

    /**
     * Alle Schritte werden auf false gesetzt
     */
    protected void setzeAlleSchritteFalse(){
        SCHRITT_FORSCHUNG_boolean = false;// erster Schritt Wahl des Designers
        SCHRITT_ARMBAND_boolean  = false;// zweite Schritt Wahl des Armbands
        SCHRITT_UHRWERK_boolean  = false;// dritter Schritt Wahl des Uhrwerks und der Uhrenart
        SCHRITT_GEHAUESE_boolean  = false;// vierter Schritt Wahl des Gehäuses für die Uhr
        //SCHRITT_DICHTHEIT_boolean  = false;// fuenfter Schritt Wahl der Dichtheit
        SCHRITT_ZEITARBEITER_boolean = false;// sechster Schritt Wahl Zeitarbeiter
        SCHRITT_MARKETING_boolean = false; // siebter Schritt Wahl des Werbeetars
        SCHRITT_PRODUKTIONSVOLUMEN_boolean = false; // achter Schritt Wahl des Kaufvolumens
        SCHRITT_BEZAHLART_boolean = false; // neunter Schritt Wahl der Bezahlart
        SCHRITT_VERKAUFSPREIS_boolean = false;
        SCHRITT_PERSONALWESEN_boolean = false;
    }

/*
Setter MEthoden
 */
    public void setZustand_Lieferung (boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Lieferung = true;
    }
    public void setZustand_Ende (boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Ende = true;
    }

    public void setZustand_Bestellung(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Bestellung = true;
    }
}
