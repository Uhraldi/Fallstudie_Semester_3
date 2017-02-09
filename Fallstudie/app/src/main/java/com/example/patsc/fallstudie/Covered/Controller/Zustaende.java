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

public class Zustaende extends SuperController implements IZustaende {

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
        //Berechnung der Risiken Extra Klasse??? ToDo
        Zustand_Ereignis = true;
    }
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
    //  public boolean isSCHRITT_DICHTHEIT_boolean() {
    //   return SCHRITT_DICHTHEIT_boolean;
    //}
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
    public boolean isZustand_Ende(){return Zustand_Ende;}
    public boolean isZustand_Ereignis(){return Zustand_Ereignis;}
    public boolean isZustand_Lieferung(){return Zustand_Lieferung;}

    public String getSCHRITT_VERKAUFSPREIS() {
        return SCHRITT_VERKAUFSPREIS;
    }
    public String getARMBAND_WAHL_KUNSTLEDER() {
        return ARMBAND_WAHL_KUNSTLEDER;
    }
    public String getARMBAND_WAHL_LEDER() {
        return ARMBAND_WAHL_LEDER;
    }
    public String getARMBAND_WAHL_METALL() {
        return ARMBAND_WAHL_METALL;
    }
    public String getARMBAND_WAHL_TEXTIL() {
        return ARMBAND_WAHL_TEXTIL;
    }
    public String getFORSCHUNG_WAHL_LOWBUDGET() {
        return FORSCHUNG_WAHL_LOWBUDGET;
    }
    public String getARMBAND_WAHL_HOLZ() {
        return ARMBAND_WAHL_HOLZ;
    }
    public String getDESIGNER_WAHL_MARKEN() {
        return FORSCHUNG_WAHL_HOCH;
    }
    public String getFORSCHUNG_WAHL_MITTELMAESIG() {
        return FORSCHUNG_WAHL_MITTELMAESIG;
    }
    public String getGEHAEUSE_WAHL_GLAS() {
        return GEHAEUSE_WAHL_GLAS;
    }
    public String getGEHAEUSE_WAHL_HOLZ() {
        return GEHAEUSE_WAHL_HOLZ;
    }
    public String getGEHAEUSE_WAHL_KUNSTSTOFF() {
        return GEHAEUSE_WAHL_KUNSTSTOFF;
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
    public boolean isSCHRITT_PERSONALWESEN_boolean(){return SCHRITT_PERSONALWESEN_boolean;}
    // public String getSCHRITT_DICHTHEIT() {
    //   return SCHRITT_DICHTHEIT;
    //}
    public String getSCHRITT_GEHAUESE() {
        return SCHRITT_GEHAUESE;
    }
    public String getSCHRITT_PRODUKTIONSVOLUMEN() {
        return SCHRITT_PRODUKTIONSVOLUMEN;
    }
    public String getSCHRITT_UHRWERK() {
        return SCHRITT_UHRWERK;
    }
    public String getSCHRITT_BEZAHLART() {
        return SCHRITT_BEZAHLART;
    }
    public String getSCHRITT_MARKETING() {
        return SCHRITT_MARKETING;
    }
    public String getUHRWERK_WAHL_ELEKTROMECHANISCH() {
        return UHRWERK_WAHL_ELEKTROMECHANISCH;
    }
    public String getUHRWERK_WAHL_ELEKTRONISCH() {
        return UHRWERK_WAHL_ELEKTRONISCH;
    }
    public String getUHRWERK_WAHL_MECHANISCH() {
        return UHRWERK_WAHL_MECHANISCH;
    }
    public String getBEZAHLART_WAHL_Kreditkarte() {
        return BEZAHLART_WAHL_KREDITKARTE;
    }
    public String getBEZAHLART_WAHL_PayPal() {
        return BEZAHLART_WAHL_PAYPAL;
    }
    public String getBEZAHLART_WAHL_Rechnung() {
        return BEZAHLART_WAHL_RECHNUNG;
    }
    // public String getWASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT() {
    // return WASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT;
    ///}
    //public String getWASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT() {
    //    return WASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT;
    // }
    // public String getWASSERDICHTHEIT_WAHL_WASSERDICHT() {
    //    return WASSERDICHTHEIT_WAHL_WASSERDICHT;
    // }
    public String getMARKETING_WAHL_PRINTWERBUNG() {
        return MARKETING_WAHL_PRINTWERBUNG;
    }
    public String getMARKETING_WAHL_FERNSEHWERBUNG() {
        return MARKETING_WAHL_FERNSEHWERBUNG;
    }
    public String getMARKETING_WAHL_RADIOWERBUNG() {
        return MARKETING_WAHL_RADIOWERBUNG;
    }
    public String getZEITARBEITER_WAHL_PRAKTIKANT() {
        return ZEITARBEITER_WAHL_PRAKTIKANT;
    }
    public String getZEITARBEITER_WAHL_GESELLE() {
        return ZEITARBEITER_WAHL_GESELLE;
    }
    public String getZEITARBEITER_WAHL_Lehrling() {
        return ZEITARBEITER_WAHL_Lehrling;
    }
    public String getZUSAMMENBAU_WAHL_Meister() {
        return ZEITARBEITER_WAHL_MEISTER;
    }
    public String getSchrittDesigner(){return SCHRITT_FORSCHUNG;}
    public String getSchrittArmband(){return SCHRITT_ARMBAND;}
    public String getSchrittUhrwerk(){return SCHRITT_UHRWERK;}
    //  public String getSchrittDichtheit(){return SCHRITT_DICHTHEIT;}
    public String getSchrittGehauese(){return SCHRITT_GEHAUESE;}
    public String getSchrittZusammenbau(){return SCHRITT_ZEITARBEITER;}
    public String getSchrittWerbung(){return SCHRITT_MARKETING;}
    public String getSchrittKaufvolumen(){return SCHRITT_PRODUKTIONSVOLUMEN;}
    public String getSchrittBezahlart(){return SCHRITT_BEZAHLART;}
    public String getSchrittVerkaufspreis(){return SCHRITT_VERKAUFSPREIS;}

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
        //ToDo auftragsammlund entfernt evtl Problem aktueller Auftrag
    }
}
