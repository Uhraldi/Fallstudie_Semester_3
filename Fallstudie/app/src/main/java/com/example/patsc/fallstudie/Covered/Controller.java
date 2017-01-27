package com.example.patsc.fallstudie.Covered;

import com.example.patsc.fallstudie.Network.Data;
import com.example.patsc.fallstudie.Network.Funkturm;

import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by patsc on 13.12.2016.
 */
    //// TODO: 24.01.2017 #Vincent sortArray implementieren
    //// TODO: 24.01.2017 #Patschi Nils über Bestenliste informieren

//Hier ein Kommentar von Nils

public class Controller {
    /*
    Deklaration der einzelnen Namen der Schritte.
    Final damit sich der Name nicht verändert.
     */
    // Zugriff auf wichtige Elemente
    private Daten daten; // Klasse in der alle Daten gehalten werden wird bei OnCreate erzeugt
    public Spieler aktiverSpieler;

    /**
     * Strings für die Übergabe der Auswahl
     */
    public static final String FORSCHUNG_WAHL_LOWBUDGET = "2500€ Investition";
    public static final String FORSCHUNG_WAHL_MITTELMAESIG = "8000€ Investition";
    public static final String FORSCHUNG_WAHL_HOCH = "15000€ Investition";
    //ToDo Forschungswerte anpassen

    public static final String ARMBAND_WAHL_LEDER = "Leder";
    public static  final String ARMBAND_WAHL_KUNSTLEDER = "Kunstleder";
    public static  final String ARMBAND_WAHL_HOLZ = "Holz";
    public static final String ARMBAND_WAHL_TEXTIL = "Textil";
    public static final String ARMBAND_WAHL_METALL = "Metall";

    public static final String UHRWERK_WAHL_MECHANISCH = "mechanisch";
    public static final String UHRWERK_WAHL_ELEKTROMECHANISCH ="elektromechanisch";
    public static final String UHRWERK_WAHL_ELEKTRONISCH = "elektronisch";

    public static final String GEHAEUSE_WAHL_GLAS = "glas";
    public static final String GEHAEUSE_WAHL_HOLZ = "holz";
    public static final String GEHAEUSE_WAHL_KUNSTSTOFF = "kunststoff";
    public static final String GEHAEUSE_WAHL_METALL ="metall";

    public static final String BEZAHLART_WAHL_KREDITKARTE = "Kreditkarte";
    public static final String BEZAHLART_WAHL_RECHNUNG ="Rechnung";
    public static final String BEZAHLART_WAHL_PAYPAL = "PayPal";

//    private final String WASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT = "nichtWassergeschützt";
//    private final String WASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT = "spritzwassergeschützt";
//    private final String WASSERDICHTHEIT_WAHL_WASSERDICHT = "wasserdicht";

    public static final String ZEITARBEITER_WAHL_GESELLE = "Geselle";
    public static final String ZEITARBEITER_WAHL_PRAKTIKANT ="Praktikant";
    public static final String ZEITARBEITER_WAHL_Lehrling ="Lehrling";
    public static  final String ZEITARBEITER_WAHL_MEISTER ="Meister";

    public static final String MARKETING_WAHL_RADIOWERBUNG = "Radiowerbung";
    public static final String MARKETING_WAHL_PRINTWERBUNG = "Printwerbung";
    public static final String MARKETING_WAHL_FERNSEHWERBUNG = "Fernsehwerbung";

    // Einzelne Schritte in dem Auswahlprozess
    public static final String SCHRITT_FORSCHUNG = "SCHRITT_FORSCHUNG"; // erster Schritt Wahl des Designers
    public static final String SCHRITT_ARMBAND = "SCHRITT_ARMBAND"; // zweite Schritt Wahl des Armbands
    public static final String SCHRITT_UHRWERK = "SCHRITT_UHRWERK"; // dritter Schritt Wahl des Uhrwerks und der Uhrenart
    public static final String SCHRITT_GEHAUESE = "SCHRITT_GEHAUSE"; // vierter Schritt Wahl des Gehäuses für die Uhr
   // private final String SCHRITT_DICHTHEIT = "SCHRITT_DICHTHEIT"; // fuenfter Schritt Wahl der Dichtheit
    public static  final String SCHRITT_ZEITARBEITER = "SCHRITT_ZEITARBEITER"; // sechster Schritt Wahl Zeitarbeiter
    public static  final String SCHRITT_MARKETING = "SCHRITT_MARKETING"; // siebter Schritt Wahl des Werbeetars
    public static final String SCHRITT_PRODUKTIONSVOLUMEN = "SCHRITT_PRODUKTIONSVOLUMEN"; // achter Schritt Wahl des Kaufvolumens
    public static final String SCHRITT_BEZAHLART = "SCHRITT_BEZAHLART"; // neunter Schritt Wahl der Bezahlart
    public static final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS"; // zehnter Schritt Wahl der Bezahlart
    public static final String SCHRITT_PERSONALWESEN = "SCHRITT_PERSONALWESEN";
    // Zustände während der Auftragssammlung
    private boolean SCHRITT_FORSCHUNG_boolean = false;// erster Schritt Wahl des Designers
    private boolean Zustand_Spielbeginn = true;
    private boolean Zustand_Bestellung = false;
    private boolean Zustand_Ereignis = false;
    private boolean Zustand_Lieferung = false;

    private boolean Zustand_Ende = false;
    private boolean SCHRITT_ARMBAND_boolean  = false;// zweite Schritt Wahl des Armbands
    private boolean SCHRITT_UHRWERK_boolean  = false;// dritter Schritt Wahl des Uhrwerks und der Uhrenart

    // Zustandsvariablen fuer die Schritte bei dem Zeitarbeiter
    private boolean SCHRITT_GEHAUESE_boolean  = false;// vierter Schritt Wahl des Gehäuses für die Uhr
    //private boolean SCHRITT_DICHTHEIT_boolean  = false;// fuenfter Schritt Wahl der Dichtheit
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


    private double gesamtkosten = 0;

    /**
     * Funkturm zum Senden von Daten
     */
    Funkturm funkturm = new Funkturm();

    /**
     * Konstruktor, wird in der on Create Methode aufgerufen
     */
    public Controller(){
        daten = new Daten(); // erzeugung der Klasse Daten

    }
    public String toString(){
        String controllerString;
        controllerString = "";
        return controllerString;
    }

    /**
     * getter Methoden
     * keine String Methode da final
     */

    /*
    How To für Jonas
    // PRüfung des vorherigen Wertes, darf der neue boolean für diesen Schritt gesetzt werden?
    Wenn ja weitergehen
    Sonst Exception

    setze alle boolean werte false
    setze den neuen wert true

    Das wars!
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
    public void setAktiverSpieler(Spieler aktiverSpieler) {
        this.aktiverSpieler = aktiverSpieler;
    }
    public void setDaten(Daten daten) {
        this.daten = daten;
    }
    public void setSCHRITT_ARMBAND_boolean(boolean SCHRITT_ARMBAND_boolean) {
        this.SCHRITT_ARMBAND_boolean = SCHRITT_ARMBAND_boolean;
    }
    public void setSCHRITT_FORSCHUNG_boolean(boolean SCHRITT_FORSCHUNG_boolean) {
        this.SCHRITT_FORSCHUNG_boolean = SCHRITT_FORSCHUNG_boolean;
    }
   // public void setSCHRITT_DICHTHEIT_boolean(boolean SCHRITT_DICHTHEIT_boolean) {
   //     this.SCHRITT_DICHTHEIT_boolean = SCHRITT_DICHTHEIT_boolean;
   // }
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
    public void setZustand_Bestellung(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Bestellung = true;
        Auftragssammlung auftragssammlung = aktiverSpieler.getAuftragssammlung(); //Aenderung 2.01 daten.getDieserSpieler() gefixt//ToDo auch hier tritt ein Nullpointer auf, verbindung mit dem in Daten?
       // auftragssammlung.neuerAuftrag();
        auftragssammlung.getAktuellerAuftrag(); // Wie man die Auftrag bekomt
        //Einfügen der Werte in die Bestllposition mittels der Buttons aktives pushen
    }
    public void setZustand_Lieferung (boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Lieferung = true;
    }
    public void setZustand_Ende (boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Ende = false;
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
    public Spieler getAktiverSpieler() {
        return aktiverSpieler;
    }
    public String getSCHRITT_VERKAUFSPREIS() {
        return SCHRITT_VERKAUFSPREIS;
    }
    public String getARMBAND_WAHL_HOLZ() {
        return ARMBAND_WAHL_HOLZ;
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

    public Daten getDaten(){
        return daten;
    }




    // Setter Zustand für die Methoden


    // Methoden die von dem UI Aufgerufen werden
    //Methoden zum setzen der aktuellen UI-Activity (aufgerufen in onCreate)

    public void setActivity_Login () {
        setzeAlleZustaendeFalse();
        setzeAlleSchritteFalse();
        setZustand_Spielbeginn(true);
    }

    //TODO: Methode füllen
    public void setActivity_Personalwesen () {


    }


    public void setActivity_Forschung () {
      //aktiverSpieler.getAuftragssammlung().neuerAuftrag(); // Absturz 1.54; aktiver SPier in registrierung zugeordnet Fix 1.58
        //ToDo RUndenanzahl erhöhen
        setZustand_Bestellung(true); // Absturz 2.01 fix 2.04
        setSCHRITT_FORSCHUNG_boolean(true);
    }
    public void setActivity_Armband () {
        setZustand_Bestellung(true);
        setSCHRITT_ARMBAND_boolean(true);
    }
    public void setActivity_Uhrwerk () {
        setZustand_Bestellung(true);
        setSCHRITT_UHRWERK_boolean(true);
    }
    public void setActivity_Gehaeuse () {
        setZustand_Bestellung(true);
        setSCHRITT_GEHAUESE_boolean(true);
    }
    public void setActivity_Bezahlart () {      //TODO: Anpassung des Namens
        setZustand_Bestellung(true);
        setSCHRITT_BEZAHLART_boolean(true);
        //aktiverSpieler.getAuftragssammlung().neuerAuftrag(); // neu
    }
  //  public void setActivity_E6 () {
  //      setZustand_Bestellung(true);
  //      setSCHRITT_DICHTHEIT_boolean(true);
  //  }
    public void setActivity_Zeitarbeiter () {
        setZustand_Bestellung(true);
        setSCHRITT_ZEITARBEITER_boolean(true);
    }
    public void setActivity_Marketing () {
        setZustand_Bestellung(true);
        setSCHRITT_MARKETING_boolean(true);
    }
    public void setActivity_Produktionsvolumen () {
        setZustand_Bestellung(true);
        setSCHRITT_PRODUKTIONSVOLUMEN_boolean(true);
    }
    public void setActivity_Verkaufspreis () {
        setZustand_Bestellung(true);
        setSCHRITT_VERKAUFSPREIS_boolean(true);

    }
    public void setActivity_Bestellzusammenfassung () {
        setzeAlleZustaendeFalse();
        setZustand_Bestellung(true);
            }
    public void setActivity_Z1 () {
        setZustand_Ereignis(true);
        setAENDERE_ARMBAND_boolean(true);
    }
    public void setActivity_Z2 () {
        setZustand_Ereignis(true);
        setAENDERE_GEHAEUSE_boolean(true);
    }
    public void setActivity_Z3 () {
        setZustand_Ereignis(true);
        setAENDERE_ZEITARBEITER_boolean(true);
    }

    public void setActivity_Berechnung (){
        try {
            setZustand_Lieferung(true);

            //Hier Preis und Marktsimulation durchführen!
            // erstellen der Preissimulation

            //ToDo Prüfung ob alle Spieler Werte eingegeben haben
            // ToDO DB abruf
            double kosten = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getFixKosten() + aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getVarKosten();
            Preissimulation preissim = new Preissimulation(this); //ToDo
            aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().setPreissim(preissim);
            Data data = new Data(aktiverSpieler.getName(),daten.getRundenAnzahl(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge(),aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPreissimulation().getReservationspreis(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getVkp(),getGesamtkosten(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPreissimulation().getBonus(), aktiverSpieler.getGuthaben());
            funkturm.sendData(data);
            Thread.sleep(3000);
            Data[] gegnerliste = funkturm.getData(daten.getRundenAnzahl());
            Marktsim marktsim = new Marktsim(getPreissimulationenPreis(), this, this.getDaten(), gegnerliste);
            aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().setMarktsim(marktsim);// ToDo evtl in MarktSim ausgübt
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setActivity_Rundenergebnis () {
        setZustand_Lieferung(true);
    }
    public void setActivity_Bestenliste() {
        //TODO: setActivity_Bestenliste
    }

    // Methoden zum weitergeben der UI-Inputs
    /**
     * Aufruf in Activity
     * @param designerAuswahl
     */
    public void setForschungAktuell(String designerAuswahl){
        setForschungEingabeWerte(designerAuswahl,aktiverSpieler,daten.getRundenAnzahl());
        } // Ende SetForschung


    public void setForschungEingabeWerte (String designerAuswahl, Spieler spieler, int auftragsnummer){
        //Prüfung ob die Wahl des Designers erlaubt ist
        try {
            if (SCHRITT_FORSCHUNG_boolean) {
                if (designerAuswahl == FORSCHUNG_WAHL_LOWBUDGET || designerAuswahl == FORSCHUNG_WAHL_HOCH || designerAuswahl == FORSCHUNG_WAHL_MITTELMAESIG) {
                    spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleForschung(designerAuswahl); //ToDo Nullpointer Exception
                    setzeAlleSchritteFalse();
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmässig auf Mittelmaessig gesetzt
        catch (Exception e){
            spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getForschung().setInvestition8000(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }


    }
    public void setArmbandAktuell(String armbandAuswahl) {
        setArmbandEingabeWerte(armbandAuswahl,aktiverSpieler,daten.getRundenAnzahl());
    }// Ende SetArmband

    public void setArmbandEingabeWerte(String armbandAuswahl, Spieler spieler, int auftragsnummer){
        try {
            if (SCHRITT_ARMBAND_boolean) {
                if (armbandAuswahl == ARMBAND_WAHL_HOLZ || armbandAuswahl == ARMBAND_WAHL_KUNSTLEDER || armbandAuswahl == ARMBAND_WAHL_LEDER || armbandAuswahl == ARMBAND_WAHL_METALL || armbandAuswahl == ARMBAND_WAHL_TEXTIL) {
                    spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleArmband(armbandAuswahl);
                    setzeAlleSchritteFalse();
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmässig auf Leder gesetzt
        catch (Exception e){
            spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getArmband().setLeder(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }

    }
    public void setArmbandNeu (String armbandAuswahl){              //nach Zufall Z3
        try {
            if (AENDERE_ARMBAND_boolean) {
                if (armbandAuswahl == ARMBAND_WAHL_HOLZ || armbandAuswahl == ARMBAND_WAHL_KUNSTLEDER || armbandAuswahl == ARMBAND_WAHL_LEDER || armbandAuswahl == ARMBAND_WAHL_METALL || armbandAuswahl == ARMBAND_WAHL_TEXTIL)
                // Prüfung ob das Material schon einmal gewaehlt wurde in Activity
                {
                    aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().bestelleArmband(armbandAuswahl);
                    AENDERE_ARMBAND_boolean = false;
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standarmäßig auf Kunstleder gesetzt
        catch (Exception e){
            aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().setKunstleder(true);
            AENDERE_ARMBAND_boolean = false;
            e.printStackTrace();
            //ToDO vorherige Auswahl war Kunstleder
            }

    }// Ende setArmbandNeu
    public void setUhrwerkAktuell(String uhrwerkAuswahl){
         setUhrwerkEingabeWerte(uhrwerkAuswahl,aktiverSpieler,daten.getRundenAnzahl());
    }//Ende setUhrwek //

 public void setUhrwerkEingabeWerte(String uhrwerkAuswahl, Spieler spieler, int auftragsnummer){
     try {
         if (SCHRITT_UHRWERK_boolean) {
             if (uhrwerkAuswahl.equals(UHRWERK_WAHL_ELEKTROMECHANISCH) || uhrwerkAuswahl.equals(UHRWERK_WAHL_ELEKTRONISCH) || uhrwerkAuswahl.equals(UHRWERK_WAHL_MECHANISCH)) {
                 spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleUhrwerk(uhrwerkAuswahl);
                 setzeAlleSchritteFalse();
             } else {
                 throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
             }
         } else {
             throw new Exception("Falscher Bestellschritt");
         }
     }
     //Wahl wird standardmäßig auf Elektronisch gesetzt
     catch (Exception e) {
         spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getUhrwerk().setElektronisch(true);
         setzeAlleSchritteFalse();
         e.printStackTrace();
     }
 }


    public void setGehaeuseAktuell(String gehaeuseAuswahl){
         setGehaueseWerte(gehaeuseAuswahl,aktiverSpieler,daten.getRundenAnzahl());
    }// Ende setGehaeuseAktuell


    public void setGehaueseWerte(String gehaeuseAuswahl, Spieler spieler, int auftragsnummer){
        try {
            if (SCHRITT_GEHAUESE_boolean) {
                if (gehaeuseAuswahl.equals(GEHAEUSE_WAHL_GLAS) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_HOLZ) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_KUNSTSTOFF) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_METALL)) {
                    spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleGehaeuse(gehaeuseAuswahl);
                    setzeAlleSchritteFalse();
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmäßig auf Metall gesetzt
        catch (Exception e) {
            spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getGehaeuse().setMetall(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }


    public void setGehaeuseNeu (String gehaeuseAuswahl){                //nach Zufall Z
         try {
             if (AENDERE_GEHAEUSE_boolean) {
                 if (gehaeuseAuswahl.equals(GEHAEUSE_WAHL_GLAS) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_HOLZ) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_KUNSTSTOFF) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_METALL)) {
                     aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().korrigiereGehaeuse(gehaeuseAuswahl);
                     AENDERE_GEHAEUSE_boolean = false;
                 } else {
                     throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                 }
             } else {
                 throw new Exception("Falscher Bestellschritt");
             }
         }
         //Wahl wird standardmäßig auf Holz gesetzt
         catch (Exception e) {
             aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().setHolz(true);
             AENDERE_GEHAEUSE_boolean = false;
             e.printStackTrace();
             //ToDO vorherige Auswahl war Holz
         }
    } // Ende setGehaeuseNeu
    public void setBezahlartAktuell(String bezahlartAuswahl){    //TODO: Anpassung Namen
         setBezahlartWerte(bezahlartAuswahl,aktiverSpieler,daten.getRundenAnzahl());
    } //Ende set Bezahlart //

    public void setBezahlartWerte (String bezahlartAuswahl, Spieler spieler, int auftragsnummer){
        try {
            if (SCHRITT_BEZAHLART_boolean) {
                if (bezahlartAuswahl.equals(BEZAHLART_WAHL_KREDITKARTE) || bezahlartAuswahl.equals(BEZAHLART_WAHL_PAYPAL) || bezahlartAuswahl.equals(BEZAHLART_WAHL_RECHNUNG)) {
                    spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleBezahlart(bezahlartAuswahl);
                }
                //letzte Auswahl die gesetzt werden kan
                else if (bezahlartAuswahl.equals(BEZAHLART_WAHL_PAYPAL)) {
                    setzeAlleSchritteFalse();
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmäßig auf NUR Rechnung gesetzt
        catch (Exception e) {
            spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getBezahlart().setRechnung(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }

    public void setZeitarbeiterAktuell(String zeitarbeiterAuswahl){

        setZeitarbeiterWerte(zeitarbeiterAuswahl, aktiverSpieler, daten.getRundenAnzahl());
  } // Ende setZusammebau

    public void setZeitarbeiterWerte (String zeitarbeiterAuswahl, Spieler spieler, int auftragsnummer) {
        try{
            if (SCHRITT_ZEITARBEITER_boolean){
                if(zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_PRAKTIKANT)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_GESELLE)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_Lehrling)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_MEISTER))
                { spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleZeitarbeiter(zeitarbeiterAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmäßig auf Lehrling gesetzt
        catch (Exception e){
            spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getZusammenbau().setLehrling(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }

    public void setZeitarbeiterNeu(String zeitarbeiterAuswahl){              //nach Zufall Z3
        try{
            if (AENDERE_ZEITARBEITER_boolean){
                if(zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_PRAKTIKANT)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_GESELLE)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_Lehrling)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_MEISTER))
                {aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().korriegiereZeitarbeiter(zeitarbeiterAuswahl);
                    AENDERE_ZEITARBEITER_boolean =false;
                }
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmäßig auf Geselle gesetzt
        catch (Exception e){
            aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().setGeselle(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
            //ToDO vorherige Auswahl Geselle
        }
    }// Ende setZeitarbeiterNeu



    public void setMarketingAktuell(String marketingAuswahl){
         setMarketingWerte(marketingAuswahl, aktiverSpieler, daten.getRundenAnzahl());
    }//Ende set Marketing

    public void setMarketingWerte (String marketingAuswahl, Spieler spieler, int auftragsnummer){
        try{
            if (SCHRITT_MARKETING_boolean){
                if(marketingAuswahl.equals(MARKETING_WAHL_PRINTWERBUNG)||marketingAuswahl.equals(MARKETING_WAHL_FERNSEHWERBUNG)||marketingAuswahl.equals(MARKETING_WAHL_RADIOWERBUNG))
                { spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleWerbung(marketingAuswahl);
                }
                // letzter Schritt der gesetzt werden kann; danach kann kein anderer mehr hinzukommen
                else if (  marketingAuswahl.equals(MARKETING_WAHL_PRINTWERBUNG)){
                    setzeAlleSchritteFalse();
                }
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmäßig auf Radiowerbung gesetzt
        catch (Exception e){
            spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getMarketing().setRadiowerbung(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }


    public void setProduktionsvolumenAktuell(float produktionsvolumenAuswahl){
         setProduktionsvolumenWerte (produktionsvolumenAuswahl, aktiverSpieler, daten.getRundenAnzahl());
    }//Ende setProduktionsvolumenAktuell

    public void setProduktionsvolumenWerte(float produktionsvolumenAuswahl, Spieler spieler, int auftragsnummer){
        try{
            if (SCHRITT_PRODUKTIONSVOLUMEN_boolean){
                int produktionsVolumen = ((int) produktionsvolumenAuswahl);
                spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleMenge(produktionsVolumen);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }
        catch (Exception e){
            setzeAlleSchritteFalse();
            SCHRITT_PRODUKTIONSVOLUMEN_boolean = true;
            int produktionsVolumen = ((int) produktionsvolumenAuswahl);
            spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleMenge(produktionsVolumen);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }

    public void setVerkaufspreisAktuell (float verkaufspreisAuswahl){
         setVerkaufpreisWerte(verkaufspreisAuswahl,aktiverSpieler,daten.getRundenAnzahl());
    }// Ende Verkaufspreis //

    public void setVerkaufpreisWerte(float verkaufspreisAuswahl, Spieler spieler, int auftragsnummer){
        try{
            if (SCHRITT_VERKAUFSPREIS_boolean){
                double verkaufspreis = ((double)verkaufspreisAuswahl);
                spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleVKP(verkaufspreis);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }
        catch (Exception e){
            setzeAlleSchritteFalse();
            SCHRITT_VERKAUFSPREIS_boolean = true;
            double verkaufspreis = ((double)verkaufspreisAuswahl);
            spieler.getAuftragssammlung().getAuftrag(auftragsnummer).bestelleVKP(verkaufspreis);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }


    // TODO: Methoden zum Einstellen und Kuendigen von Mitarbeitern
    public void einstellen (int anzahlMitarbeiter) {

    }

    public  void kuendigen (int anzahlMitarbeiter){
    }

        //Methoden zum abholen der Bestellpositionen, zur Anzeige der Bestellzusammenfassung
    public String getForschungAktuellerAuftrag( ){
        return getForschungAuftragI(daten.getRundenAnzahl(),aktiverSpieler);
    }// Ende getForschungAktuellerAuftrag


    //Methoden zum abholen der Bestellpositionen, zur Anzeige der Bestellzusammenfassung
    public String getForschungAuftragI(int i, Spieler spieler ){
        String forschung = "";
        try {
            if (spieler.getAuftragssammlung().getAuftrag(i).getForschung().isInvestition2500()) {
                forschung = FORSCHUNG_WAHL_LOWBUDGET;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getForschung().isInvestition15000()) {
             forschung = FORSCHUNG_WAHL_HOCH;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getForschung().isInvestition8000()) {
                forschung = FORSCHUNG_WAHL_MITTELMAESIG;
            } else {

                throw new Exception("Keine Wahl getroffen");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return forschung;
    }// Ende getForschungAuftragI(int i


    public String getArmbandAktuellerAuftrag( ){
        return getArmbandAuftragI(daten.getRundenAnzahl(),aktiverSpieler);
    }// Ende get Armband

    public String getArmbandAuftragI(int i ,Spieler spieler){
        String armband ="";
        try {
            if (spieler.getAuftragssammlung().getAuftrag(i).getArmband().isHolz()) {
                armband = ARMBAND_WAHL_HOLZ;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getArmband().isKunstleder()) {
                armband = ARMBAND_WAHL_KUNSTLEDER;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getArmband().isLeder()) {
                armband = ARMBAND_WAHL_LEDER;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getArmband().isMetall()) {
                armband = ARMBAND_WAHL_METALL;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getArmband().isTextil()) {
                armband = ARMBAND_WAHL_TEXTIL;
            } else {
                throw new Exception("Keine Wahl getroffen");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return armband;
    }// Ende get Armband Auftrag i

    public String getUhrwerkAktuellerAuftrag( ) {
        return getUhrwerkAuftragI(daten.getRundenAnzahl(), aktiverSpieler);
    }// Ende getUhrwerkAktuellerAuftrag

    public String getUhrwerkAuftragI(int i, Spieler spieler){
        String uhrwerk = "";
        try {
            if (spieler.getAuftragssammlung().getAuftrag(i).getUhrwerk().isElektromechanisch()) {
                uhrwerk = UHRWERK_WAHL_ELEKTROMECHANISCH;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getUhrwerk().isElektronisch()) {
                uhrwerk = UHRWERK_WAHL_ELEKTRONISCH;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getUhrwerk().isMechanisch()) {
                uhrwerk = UHRWERK_WAHL_MECHANISCH;
            } else {
                throw new Exception("Keine Wahl im Uhrwerk getroffen.");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return uhrwerk;
    }


    public String getZeitarbeiterAktuellerAuftrag(){
        return getZeitarbeiterAuftragI(daten.getRundenAnzahl(), aktiverSpieler);
    } // Ende getZeitarbeiterAktuellerAuftrag


    public String getZeitarbeiterAuftragI(int i, Spieler spieler){
        String zeitarbeiter = "";
        try{
            if (spieler.getAuftragssammlung().getAuftrag(i).getZusammenbau().isPraktikant()){
                zeitarbeiter = ZEITARBEITER_WAHL_PRAKTIKANT;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getZusammenbau().isGeselle()){
                zeitarbeiter = ZEITARBEITER_WAHL_GESELLE;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getZusammenbau().isLehrling()){
                zeitarbeiter = ZEITARBEITER_WAHL_Lehrling;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getZusammenbau().isMeister()){
                zeitarbeiter =ZEITARBEITER_WAHL_MEISTER;
            }
            else{
                throw new Exception("Keine Auswahl bei dem Zusamenbau getroffen.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return zeitarbeiter;
    }

    public String getGehaeuseAktuellerAuftrag( ){
        return getGehaeuseAuftragI(daten.getRundenAnzahl(),aktiverSpieler);
    } // Ende getGehaeuseAktuellerAuftrag


    public String getGehaeuseAuftragI ( int i, Spieler spieler){
        String gehaeuse ="";
        try{
            if (spieler.getAuftragssammlung().getAuftrag(i).getGehaeuse().isMetall()){
                gehaeuse = GEHAEUSE_WAHL_METALL;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getGehaeuse().isHolz()){
                gehaeuse = GEHAEUSE_WAHL_HOLZ;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getGehaeuse().isGlas()){
                gehaeuse =GEHAEUSE_WAHL_GLAS;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getGehaeuse().isKunststoff()) {
                gehaeuse = GEHAEUSE_WAHL_KUNSTSTOFF;
            }
            else{
                throw new Exception("Keine Auswahl des Gehaueses getroffen.");
            }
        }
        catch (Exception e){

        }
        return gehaeuse;
    }

    public String getBezahlartAktuellerAuftrag( ){
return        getBezahlartAuftragI(daten.getRundenAnzahl(),aktiverSpieler);
    }//Ende getBezahlartAktuellerAuftrag


    public String getBezahlartAuftragI (int i, Spieler spieler){
        String bezahlart ="";
        try{
            if (spieler.getAuftragssammlung().getAuftrag(i).getBezahlart().isKreditkarte()){

                bezahlart = BEZAHLART_WAHL_KREDITKARTE;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getBezahlart().isPayPal()){
                if (!bezahlart.equals("")){
                    bezahlart = bezahlart + ", ";
                }
                bezahlart = BEZAHLART_WAHL_PAYPAL;
            }
            else if (spieler.getAuftragssammlung().getAuftrag(i).getBezahlart().isRechnung()){
                if (!bezahlart.equals("")){
                    bezahlart = bezahlart + ", ";
                }
                bezahlart = BEZAHLART_WAHL_RECHNUNG;
            }
            else{
                throw new Exception("Keine Auswahl der Bezahlart getroffen.");
            }
        }
        catch (Exception e){

        }
        return bezahlart;
    }

    //ToDo mehrfachauswahl
    public String getMarketingAktuellerAuftrag( ){
        return getMarketingAuftragI(daten.getRundenAnzahl(), aktiverSpieler);
    } // Ende get Marketing

    public String getMarketingAuftragI (int i, Spieler spieler){
        String marketing ="";
        try {
            if (spieler.getAuftragssammlung().getAuftrag(i).getMarketing().isRadiowerbung()) {
                marketing = MARKETING_WAHL_PRINTWERBUNG;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getMarketing().isFernsehwerbung()) {
                if (!marketing.equals("")) {
                    marketing = marketing + ":";
                }
                marketing = MARKETING_WAHL_FERNSEHWERBUNG;
            } else if (spieler.getAuftragssammlung().getAuftrag(i).getMarketing().isPrintwerbung()) {
                if (!marketing.equals("")) {
                    marketing = marketing + ":";
                }
                marketing = MARKETING_WAHL_RADIOWERBUNG;
            } else {
                throw new Exception("Keine Auswahl bei dem Zusamenbau getroffen.");
            }
        }
        catch (Exception e){

        }
        return marketing;
    }
    public float getProduktionsvolumen( ){ //#Nils Refactored von getKaufvolumen zu getProduktionsvolumen
        float kv = (float)aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge();
        return kv;
    } // Ende getProduktionsvolumen
    public float getVerkaufspreis ( ){
        float vkp = (float)aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getVkp();
        return vkp;
    }// Ende getVerkaugspreis

    // Methoden zum Aufrufen der Bonären Werte
    public float getFixKosten() {
        Spieler s = aktiverSpieler;
        Auftragssammlung as = s.getAuftragssammlung();
        Auftrag a = as.getAktuellerAuftrag();
        double fixKosten = a.getFixKosten();
        //float fixKosten =aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getFixKosten();

        return (float) fixKosten;
    }
    public float getVarKosten(){
        Spieler s = aktiverSpieler;
        Auftragssammlung as = s.getAuftragssammlung();
        Auftrag a = as.getAktuellerAuftrag();
        double varKosten = a.getVarKosten();
        //ToDo(float) aktiverSpieler.getAuftragssammlung().getAuftrag(0).getVarKosten();
        return (float) varKosten;
    }
    public double getGuthaben(){
        double guthaben = (double) aktiverSpieler.getGuthaben();
        return guthaben;
    }



    //TODO: getGesamtkosten und getStueckkosten fuer Anzeige bei VerkaufspreisActivity
    public double getGesamtkosten () {
        return aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getFixKosten()+
                aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getVarKosten()*
                aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge();
    }

    public double getStueckkosten () {
        return getGesamtkosten()/aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge();
    }




    // Methoden für die Ereignisse
    //Methoden zum Überprüfen ob ein Zufall eingetreten ist, entsprechende Weiterleitung der Activities
    public boolean isZufall1 (){ // Zufall 1 = Armband Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZEITARBEITER_boolean = false;
        double wahrscheinlichkeit = 0;
        try {
            if (aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().isHolz()) {
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().getHolzRisiko();
            } else if (getArmbandAktuellerAuftrag().equals(ARMBAND_WAHL_KUNSTLEDER)) {
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().getKunstlederRisiko();
            } else if (getArmbandAktuellerAuftrag().equals(ARMBAND_WAHL_LEDER)) {
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().getLederRisiko();
            } else if (getArmbandAktuellerAuftrag().equals(ARMBAND_WAHL_METALL)) {
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().getMetallRisiko();
            } else if (getArmbandAktuellerAuftrag().equals(ARMBAND_WAHL_TEXTIL)) {
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().getTextilRisiko();
            } else {
                throw new Exception("Keine Auswahl fuer Armband getroffen");
            }
        }
        catch(Exception e)
        {
            aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().setLeder(true);
            setzeAlleSchritteFalse();
            wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().getLederRisiko();
            e.printStackTrace();
        }
        if (zufallszahl<=wahrscheinlichkeit){
            AENDERE_ARMBAND_boolean =true;
            return true;
        }
        else{
            return false;
        }
    }// Ende isZufall1
    public boolean isZufall2 (){ // Zufall 2 = Gehäuse Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZEITARBEITER_boolean = false;
        double wahrscheinlichkeit = 0;
            try{
                if (getGehaeuseAktuellerAuftrag().equals(GEHAEUSE_WAHL_KUNSTSTOFF)){
                    wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().getKunststoffRisiko();
                }
                else if(getGehaeuseAktuellerAuftrag().equals(GEHAEUSE_WAHL_METALL)){
                    wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().getMetallRisiko();
                }
                else if(getGehaeuseAktuellerAuftrag().equals(GEHAEUSE_WAHL_GLAS)){
                    wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().getGlasRisiko();
                }
                else if (getGehaeuseAktuellerAuftrag().equals(GEHAEUSE_WAHL_HOLZ)){
                    wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().getHolzRisiko();
                }
                else{
                    throw new Exception("Keine Auswahl des Gehaeuses getroffen.");
                }
            }
            catch(Exception e){
                aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().setMetall(true);
                setzeAlleSchritteFalse();
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().getMetallRisiko();
                e.printStackTrace();
            }
        if (zufallszahl<=wahrscheinlichkeit){
            AENDERE_GEHAEUSE_boolean =true;
            return true;
        }
        else{
            return false;
        }
    }// Ende isZufall2
    public boolean isZufall3 (){ // Zufall 3 = Zeitarbeiter Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZEITARBEITER_boolean = false;
        double wahrscheinlichkeit = 0;
            try{
                if (getZeitarbeiterAktuellerAuftrag().equals(ZEITARBEITER_WAHL_PRAKTIKANT)){
                    wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().getPraktikantRisiko();
                }
                else if (getZeitarbeiterAktuellerAuftrag().equals(ZEITARBEITER_WAHL_MEISTER)){
                    wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().getMeisterRisiko();
                }
                else if (getZeitarbeiterAktuellerAuftrag().equals(ZEITARBEITER_WAHL_Lehrling)){
                    wahrscheinlichkeit =  aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().getPraktikantRisiko();

                }
                else if (getZeitarbeiterAktuellerAuftrag().equals(ZEITARBEITER_WAHL_GESELLE)){
                    wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().getGeselleRisiko();
                }
                else{
                    throw new Exception("Keine Auswahl des Gehaeuses getroffen.");
                }
            }
            catch (Exception e){
                aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().setLehrling(true);
                setzeAlleSchritteFalse();
                wahrscheinlichkeit =  aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().getPraktikantRisiko();
                e.printStackTrace();
            }
        if (zufallszahl<=wahrscheinlichkeit){
            AENDERE_GEHAEUSE_boolean =true;
            return true;
        }
        else{
            return false;
        }
    }// Ende isZufall3

    //Andere Abfragen
    public Spieler[] getBestenliste(){
        //ToDo
        Spieler [] nF = new Spieler[1];
        nF[0] = aktiverSpieler;
        return nF;
    } //Ende getBestenliste

    public void naechster_Schritt_Auswahl(){} // Setzen des nächsten AuswahlSchritts
    public void naechster_Zustand(){} // Setzen des nächsten Zustands
    /**
     * Aufruf wenn Nutzerdaten bestätigt werden (Button in UI)
     * UI Registierung
     * Parameter werden von UI übergeben
     * @param name
     * @param passwort
     */ public boolean registrierung(String name, String passwort){
        try {
            // Prüfen ob der Spielername bereits auf dem Device verwendet wird, wenn ja soll ein Fehler geworfen werden
            ArrayList<Spieler> SpielerListe = daten.getSpielerListe();
            for (int i = 0; i < SpielerListe.size(); i++) {
                if (SpielerListe.get(i).getName().equals(name)) { // Name war richtig
                    return false;
                }  // Ende if Schleife namens Prüfung
            } // Ende for Schleife
            // Wenn die Schleife durchlaufen ist, aber kein Spieler den Namen bereits verwendet, wird der Spieler angelegt und als aktiver Spieler gesetzt
            aktiverSpieler = new Spieler(name, passwort, daten);
            daten.addSpielerListe(aktiverSpieler);
        } // Ende try
        catch (Exception e){
        e.printStackTrace();
        } // Ende catch
        return true; } // Ende registrierung()
    /**
     * Aufrug wenn Login bestätigt wird (Button in UI)
     * UI Login
     * Parameter werden von UI übergeben
     * @param name
     * @param passwort
     */
    public boolean login (String name, String passwort){
        try {
          // Prüfen ob der Spieler auf dem Device gespeichert ist
            ArrayList<Spieler> SpielerListe =  daten.getSpielerListe();
            for (int i = 0; i<SpielerListe.size(); i++) {
                if (SpielerListe.get(i).getName().equals(name)) { // Name war richtig
                    if (SpielerListe.get(i).getPasswort().equals(passwort)){ // Name und Passwort richtig Spieler wird alsaktiver SPieler gesetzt.
                        aktiverSpieler = SpielerListe.get(i);
                        i=SpielerListe.size()+2; // Sicher gehen, dass nicht mehr in for Schleife gegangen wird
                        daten.setDieserSpieler(aktiverSpieler);
                        return true;
                    } // Ende if Passwort prüfen
                    else{ // richtiger Name falsches Passwort
                        i=SpielerListe.size()+2; // Sicher gehen, dass nicht mehr in for Schleife gegangen wird
                        return false;
                    } // Ende else
                } // Ende if Schleife namens Prüfung
            } // Ende for Schleife
            // Wenn die Schleife durchlaufen ist, aber kein Spieler den richtigen Namen hatte, wird false zurückgegeben
            return false;
        } // Ende try
        catch (Exception e)
        {
            e.printStackTrace();
        }//Ende catch
            return false; //falls Name und Passwort nicht zusammengehören
    }
    public int getPosition(){
        return 1; //ToDO
    }
    public float getMarktanteil(){
        float marktAnteil = (float) aktiverSpieler.getMarktanteil();
        return marktAnteil;
    }// Ende getMarktanteil

    //ToDo Spielfortsetzen


    public String[] getNamen(){
        return new String[3];
    } // ToDo Liste der geordneten Spielernamen

    //  Mehrfach genutzte Datenabfrage.
    public int getRunde(){
        return daten.getRundenAnzahl()+1;
    }//Ende getRunde
    // Hilfsmethoden
    /**
     * Alle Zustaende werden auf false gesetzt
     */
    private void setzeAlleZustaendeFalse(){

        Zustand_Bestellung = false;
        Zustand_Ende = false;
        Zustand_Ereignis = false;
        Zustand_Lieferung = false;
        Zustand_Spielbeginn = false;

    }
    private void setzeAlleSchritteFalse(){
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


    /**
     * Methode für die Marktsiumulation
     * @return gibt eine Liste der einzelnen Bestellpositionen fuer jeden Speieler zurueck
     */
    public Auftrag[] getAuftrage()throws Exception{
        Auftrag[] auftraege = new Auftrag[daten.getSpielerAnzahl()];
            try {
                if (daten.getSpielerListe() == null) {
                    throw new Exception("Spieler Liste leer");
                }

                for (int i = 0; i < daten.getSpielerAnzahl(); i++) {
                    if (daten.getSpielerListe().get(i).getAuftragssammlung().getAktuellerAuftrag() != null)
                        auftraege[i] = daten.getSpielerListe().get(i).getAuftragssammlung().getAktuellerAuftrag();
                    else {
                        throw new Exception("Kein Objekt gefunden");
                    }
                }// Ende for
            }
            catch (Exception e){
                e.printStackTrace();
            }

        return auftraege;
    }  // Ende getAuftrage

    public double[] getPreissimulationenPreis () {
        double[] Preise = new double[daten.getSpielerAnzahl()];
        try {
            if (daten.getSpielerListe() == null) {
                throw new Exception("Spieler Liste leer");
            }
            for (int i = 0; i < daten.getSpielerAnzahl(); i++) {
                if (daten.getSpielerListe().get(i).getAuftragssammlung().getAktuellerAuftrag() != null){


                 //   Preise[i] = daten.getSpielerListe().get(i).getAuftragssammlung().getAktuellerAuftrag().getPreissimulation().getVerkaufspreis();
                }
                    else {
                    throw new Exception("Kein Objekt gefunden");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return Preise;
    } // Ende Preissimulation

    public Data[] sortSpieler(Data[] spielers){
        Data temp;
        for(int i=1; i<spielers.length; i++) {
            for(int j=0; j<spielers.length-i; j++) {
                if((spielers[j].getMarktanteil()*spielers[j].getRundengewinn())>(spielers[j+1].getMarktanteil()*spielers[j].getRundengewinn())) {
                    temp=spielers[j];
                    spielers[j]=spielers[j+1];
                    spielers[j+1]=temp;
                }

            }
        }
        return spielers;
    }
} // ENDE KLASSE