package com.example.patsc.fallstudie;

/**
 * Created by patsc on 13.12.2016.
 */


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
    public static final String FORSCHUNG_WAHL_LOWBUDGET = "1000€ Investition";
    public static final String FORSCHUNG_WAHL_MITTELMAESIG = "3000€ Investition";
    public static final String FORSCHUNG_WAHL_HOCH = "5000€ Investition";

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
    public static final String SCHRITT_BEZAHLART = "SCHRITT_BEZAHLART"; // neunter Schritt Wahl der Versandart
    public static final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS"; // zehnter Schritt Wahl der Versandart
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
    private boolean SCHRITT_BEZAHLART_boolean = false; // neunter Schritt Wahl der Versandart
    private boolean SCHRITT_VERKAUFSPREIS_boolean = false;
    private boolean SCHRITT_PERSONALWESEN_boolean = false;

    // Zustands Variablen fuer die Aenderungen
    private boolean AENDERE_ARMBAND_boolean=false;
    private boolean AENDERE_GEHAEUSE_boolean =false;
    private boolean AENDERE_ZEITARBEITER_boolean = false;

    /**
     * Konstruktor, wird in der on Create Methode aufgerufen
     */
    public Controller(){
        daten = new Daten(); // erzeugung der Klasse Daten

    }


    /**
     * getter Methoden
     * keine String Methode da final
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
        auftragssammlung.neueBestellpositon();
        auftragssammlung.getAuftrag(daten.getRundenAnzahl()); // Wie man die Auftrag bekomt
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
    public String getSCHRITT_VERSANDART() {
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
    public String getVERSANDART_WAHL_Kreditkarte() {
        return BEZAHLART_WAHL_KREDITKARTE;
    }
    public String getVERSANDART_WAHL_PayPal() {
        return BEZAHLART_WAHL_PAYPAL;
    }
    public String getVESANDART_WAHL_Rechnung() {
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
    public String getSchrittVersandart(){return SCHRITT_BEZAHLART;}
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
      aktiverSpieler.getAuftragssammlung().neueBestellpositon(); // Absturz 1.54; aktiver SPier in registrierung zugeordnet Fix 1.58
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
        aktiverSpieler.getAuftragssammlung().neueBestellpositon(); // neu
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
        setZustand_Bestellung(true);
        setzeAlleZustaendeFalse();
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
            double kosten = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getFixKosten() + aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getVarKosten();
            Preissimulation preissim = new Preissimulation(daten.getRundenAnzahl(), aktiverSpieler.getAuftragssammlung()); //ToDo
            aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).setPreissim(preissim);
            Marktsim marktsim = new Marktsim(getPreissimulationenPreis());
            aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).setMarktsim(marktsim);// ToDo evtl in MarktSim ausgübt
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
    public void setForschung (String designerAuswahl){
        //Prüfung ob die Wahl des Designers erlaubt ist
        try {
            if (SCHRITT_FORSCHUNG_boolean) {
                if (designerAuswahl == FORSCHUNG_WAHL_LOWBUDGET || designerAuswahl == FORSCHUNG_WAHL_HOCH || designerAuswahl == FORSCHUNG_WAHL_MITTELMAESIG) {
                    aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleForschung(designerAuswahl); //ToDo Nullpointer Exception
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
          //  aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleForschung(FORSCHUNG_WAHL_MITTELMAESIG); //ToDo Nullpointer Exception s.o. L483
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }

    } // Ende SetDesigner
    public void setArmband (String armbandAuswahl) {
        try {
            if (SCHRITT_ARMBAND_boolean) {
                if (armbandAuswahl == ARMBAND_WAHL_HOLZ || armbandAuswahl == ARMBAND_WAHL_KUNSTLEDER || armbandAuswahl == ARMBAND_WAHL_LEDER || armbandAuswahl == ARMBAND_WAHL_METALL || armbandAuswahl == ARMBAND_WAHL_TEXTIL) {
                    aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleArmband(armbandAuswahl);
                    setzeAlleSchritteFalse();
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        catch (Exception e){
         //   aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleArmband(ARMBAND_WAHL_HOLZ); //ToDO Nullpointer Exception
            //Klasse Auftragssammlung (ArrayList) Methode getAuftrag
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }// Ende SetArmband
    public void setArmbandNeu (String armbandAuswahl)throws Exception{              //nach Zufall Z3
            if (AENDERE_ARMBAND_boolean){
                if(armbandAuswahl == ARMBAND_WAHL_HOLZ || armbandAuswahl == ARMBAND_WAHL_KUNSTLEDER|| armbandAuswahl==ARMBAND_WAHL_LEDER || armbandAuswahl==ARMBAND_WAHL_METALL|| armbandAuswahl==ARMBAND_WAHL_TEXTIL)
                // Prüfung ob das Material schon einmal gewaehlt wurde in Activity
                { aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleArmband(armbandAuswahl);
                    AENDERE_ARMBAND_boolean=false;}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }// Ende setArmbandNeu
    public void setUhrwerk (String uhrwerkAuswahl) throws Exception{
            if (SCHRITT_UHRWERK_boolean){
                if(uhrwerkAuswahl.equals(UHRWERK_WAHL_ELEKTROMECHANISCH)||uhrwerkAuswahl.equals(UHRWERK_WAHL_ELEKTRONISCH)||uhrwerkAuswahl.equals(UHRWERK_WAHL_MECHANISCH))
                { aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleUhrwerk(uhrwerkAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }//Ende setUhrwek //
    public void setGehaeuse (String gehaeuseAuswahl)throws Exception{
            if (SCHRITT_GEHAUESE_boolean){
                if(gehaeuseAuswahl.equals(GEHAEUSE_WAHL_GLAS)|| gehaeuseAuswahl.equals(GEHAEUSE_WAHL_HOLZ)||gehaeuseAuswahl.equals(GEHAEUSE_WAHL_KUNSTSTOFF)||gehaeuseAuswahl.equals(GEHAEUSE_WAHL_METALL))
                { aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleGehaeuse(gehaeuseAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }// Ende setGehaeuse
    public void setGehaeuseNeu (String gehaeuseAuswahl) throws Exception{                //nach Zufall Z
            if (AENDERE_GEHAEUSE_boolean){
                if(gehaeuseAuswahl.equals(GEHAEUSE_WAHL_GLAS)|| gehaeuseAuswahl.equals(GEHAEUSE_WAHL_HOLZ)||gehaeuseAuswahl.equals(GEHAEUSE_WAHL_KUNSTSTOFF)||gehaeuseAuswahl.equals(GEHAEUSE_WAHL_METALL)) {
                    aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).korrigiereGehaeuse(gehaeuseAuswahl);
                    AENDERE_GEHAEUSE_boolean=false;
                }
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }

    } // Ende setGehaeuseNeu
    public void setBezahlart (String bezahlartAuswahl)throws  Exception{    //TODO: Anpassung Namen
            if (SCHRITT_BEZAHLART_boolean){
                if(bezahlartAuswahl.equals(BEZAHLART_WAHL_KREDITKARTE)|| bezahlartAuswahl.equals(BEZAHLART_WAHL_PAYPAL)|| bezahlartAuswahl.equals(BEZAHLART_WAHL_RECHNUNG))
                { aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleVersandart(bezahlartAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    } //Ende set Versandart //

    public void setZeitarbeiter (String zeitarbeiterAuswahl)throws Exception{
        if (SCHRITT_ZEITARBEITER_boolean){
          if(zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_PRAKTIKANT)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_GESELLE)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_Lehrling)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_MEISTER))
          { aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleZeitarbeiter(zeitarbeiterAuswahl);
              setzeAlleSchritteFalse();}
         else{
              throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
          }
      }
      else{
          throw new Exception("Falscher Bestellschritt");
      }
  } // Ende setZusammebau
    public void setZeitarbeiterNeu(String zeitarbeiterAuswahl)throws Exception{              //nach Zufall Z3
            if (AENDERE_ZEITARBEITER_boolean){
                if(zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_PRAKTIKANT)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_GESELLE)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_Lehrling)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_MEISTER))
                {aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).korriegiereZeitarbeiter(zeitarbeiterAuswahl);
                    AENDERE_ZEITARBEITER_boolean =false;
                }
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }// Ende setZeitarbeiterNeu
    public void setMarketing (String marketingAuswahl)throws Exception{
            if (SCHRITT_MARKETING_boolean){
                if(marketingAuswahl.equals(MARKETING_WAHL_PRINTWERBUNG)||marketingAuswahl.equals(MARKETING_WAHL_FERNSEHWERBUNG)||marketingAuswahl.equals(MARKETING_WAHL_RADIOWERBUNG))
                { aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleWerbung(marketingAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }//Ende set Marketing
    public void setProduktionsvolumen (float produktionsvolumenAuswahl)throws Exception{
            if (SCHRITT_PRODUKTIONSVOLUMEN_boolean){
                int produktionsVolumen = ((int) produktionsvolumenAuswahl);
                aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleMenge(produktionsVolumen);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }

    }//Ende setKaufvolumen //
    public void setVerkaufspreis (float verkaufspreisAuswahl)throws Exception{
            if (SCHRITT_VERKAUFSPREIS_boolean){
                double verkaufspreis = ((double)verkaufspreisAuswahl);
                aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).bestelleVKP(verkaufspreis);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }// Ende Verkaufspreis //



    // TODO: Methoden zum Einstellen und Kuendigen von Mitarbeitern
    public void einstellen (int anzahlMitarbeiter) {

    }

    public  void kuendigen (int anzahlMitarbeiter){
    }





    //Methoden zum abholen der Bestellpositionen, zur Anzeige er Bestellzusammenfassung
    public String getForschung( )throws Exception{
        String forschung ="";
            if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getForschung().isLowBudget()){
                forschung = FORSCHUNG_WAHL_LOWBUDGET;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getForschung().isMarken()){
                forschung = FORSCHUNG_WAHL_HOCH;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getForschung().isMittelmaessig()){
                forschung = FORSCHUNG_WAHL_MITTELMAESIG;
            }
            else{

                throw new Exception("Keine Wahl getroffen");
            }
        // Ende try
        return forschung;
    }// Ende getForschung
    public String getArmband ( )throws Exception{
        String armband ="";
            if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().isHolz()){
                armband = ARMBAND_WAHL_HOLZ;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().isKunstleder()){
                armband =ARMBAND_WAHL_KUNSTLEDER;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().isLeder()){
                armband = ARMBAND_WAHL_LEDER;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().isMetall()){
                armband = ARMBAND_WAHL_METALL;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().isTextil()){
                armband = ARMBAND_WAHL_TEXTIL;
            }
            else{

                throw new Exception("Keine Wahl getroffen");
            }
        return armband;
    }// Ende get Armband
    public String getUhrwerk ( ) throws Exception{
        String uhrwerk = "";
            if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getUhrwerk().isElektromechanisch()){
                uhrwerk = UHRWERK_WAHL_ELEKTROMECHANISCH;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getUhrwerk().isElektronisch()) {
                uhrwerk = UHRWERK_WAHL_ELEKTRONISCH;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getUhrwerk().isMechanisch()){
                uhrwerk = UHRWERK_WAHL_MECHANISCH;}
            else{
                throw new Exception("Keine Wahl im Uhrwerk getroffen.");
            }
        return uhrwerk;
    }// Ende getUhrwerk

    public String getZeitarbeiter()throws Exception{
        String zeitarbeiter = "";
        if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getZusammenbau().isPraktikant()){
            zeitarbeiter = ZEITARBEITER_WAHL_PRAKTIKANT;
        }
        else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getZusammenbau().isGeselle()){
            zeitarbeiter = ZEITARBEITER_WAHL_GESELLE;
        }
        else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getZusammenbau().isLehrling()){
            zeitarbeiter = ZEITARBEITER_WAHL_Lehrling;
        }
        else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getZusammenbau().isMeister()){
            zeitarbeiter =ZEITARBEITER_WAHL_MEISTER;
        }
        else{
            throw new Exception("Keine Auswahl bei dem Zusamenbau getroffen.");
        }
        return zeitarbeiter;
    } // Ende getZussamenbau
    public String getGehaeuse ( ) throws Exception{
        String gehaeuse ="";
            if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getGehaeuse().isMetall()){
                gehaeuse = GEHAEUSE_WAHL_METALL;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getGehaeuse().isHolz()){
                gehaeuse = GEHAEUSE_WAHL_HOLZ;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getGehaeuse().isGlas()){
                gehaeuse =GEHAEUSE_WAHL_GLAS;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getGehaeuse().isKunststoff()) {
                gehaeuse = GEHAEUSE_WAHL_KUNSTSTOFF;
            }
            else{
                throw new Exception("Keine Auswahl des Gehaueses getroffen.");
            }
        return gehaeuse;
    } // Ende getGehaeuse
    public String getBezahlart( )throws Exception{
        String bezahlart ="";
            if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getVersandart().isKreditkarte()){
                bezahlart = BEZAHLART_WAHL_KREDITKARTE;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getVersandart().isPayPal()){
                bezahlart = BEZAHLART_WAHL_PAYPAL;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getVersandart().isRechnung()){
                bezahlart = BEZAHLART_WAHL_RECHNUNG;
            }
            else{
                throw new Exception("Keine Auswahl der Versandart getroffen.");
            }
        return bezahlart;
    }//Ende getBezahlart
    public String getMarketing( )throws Exception{
        String marketing ="";
            if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getMarketing().isRadiowerbung()){
                marketing = MARKETING_WAHL_PRINTWERBUNG;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getMarketing().isFernsehwerbung()){
                marketing = MARKETING_WAHL_FERNSEHWERBUNG;
            }
            else if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getMarketing().isPrintwerbung()){
                marketing = MARKETING_WAHL_RADIOWERBUNG;
            }
            else{
                throw new Exception("Keine Auswahl bei dem Zusamenbau getroffen.");
            }
        return marketing;
    } // Ende get Marketing
    public float getKaufvolumen ( ){
        float kv = (float)aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getMenge();
        return kv;
    } // Ende getKaufvolumen
    public float getVerkaufspreis ( ){
        float vkp = (float)aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getVkp();
        return vkp;
    }// Ende getVerkaugspreis

    // Methoden zum Aufrufen der Bonären Werte
    public float getFixKosten() {
        float fixKosten = (float) aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getFixKosten();
        return fixKosten;
    }
    public float getVarKosten(){
        float varKosten =(float) aktiverSpieler.getAuftragssammlung().getAuftrag(0).getVarKosten();
        return varKosten;
    }
    public double getGuthaben(){
        double guthaben = (double) aktiverSpieler.getGuthaben();
        return guthaben;
    }

    // Methoden für die Ereignisse
    //Methoden zum Überprüfen ob ein Zufall eingetreten ist, entsprechende Weiterleitung der Activities
    public boolean isZufall1 ()throws Exception{ // Zufall 1 = Armband Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZEITARBEITER_boolean = false;
        double wahrscheinlichkeit = 0;
            if (aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().isHolz()){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().getHolzRisiko();
            }
            else if (getArmband().equals(ARMBAND_WAHL_KUNSTLEDER) ){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().getKunstlederRisiko();
            }
            else if (getArmband().equals(ARMBAND_WAHL_LEDER)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().getLederRisiko();
            }
            else if (getArmband().equals(ARMBAND_WAHL_METALL)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().getMetallRisiko();
            }
            else if (getArmband().equals(ARMBAND_WAHL_TEXTIL)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getArmband().getTextilRisiko();
            }
            else{
                throw new Exception("Keine Auswahl fuer Armband getroffen");
            }

        if (zufallszahl<=wahrscheinlichkeit){
            AENDERE_ARMBAND_boolean =true;
            return true;
        }
        else{
            return false;
        }
    }// Ende isZufall1
    public boolean isZufall2 ()throws Exception{ // Zufall 2 = Gehäuse Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZEITARBEITER_boolean = false;
        double wahrscheinlichkeit = 0;
            if (getGehaeuse().equals(GEHAEUSE_WAHL_KUNSTSTOFF)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getGehaeuse().getKunststoffRisiko();
            }
            else if(getGehaeuse().equals(GEHAEUSE_WAHL_METALL)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getGehaeuse().getMetallRisiko();
            }
            else if(getGehaeuse().equals(GEHAEUSE_WAHL_GLAS)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getGehaeuse().getGlasRisiko();
            }
            else if (getGehaeuse().equals(GEHAEUSE_WAHL_HOLZ)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getGehaeuse().getHolzRisiko();
            }
            else{
                throw new Exception("Keine Auswahl des Gehaeuses getroffen.");
            }
        if (zufallszahl<=wahrscheinlichkeit){
            AENDERE_GEHAEUSE_boolean =true;
            return true;
        }
        else{
            return false;
        }
    }// Ende isZufall2
    public boolean isZufall3 ()throws Exception{ // Zufall 3 = Zeitarbeiter Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZEITARBEITER_boolean = false;
        double wahrscheinlichkeit = 0;
            if (getZeitarbeiter().equals(ZEITARBEITER_WAHL_PRAKTIKANT)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getZusammenbau().getPraktikantRisiko();
            }
            else if (getZeitarbeiter().equals(ZEITARBEITER_WAHL_MEISTER)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getZusammenbau().getMeisterRisiko();
            }
            else if (getZeitarbeiter().equals(ZEITARBEITER_WAHL_Lehrling)){
                wahrscheinlichkeit =  aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getZusammenbau().getPraktikantRisiko();

            }
            else if (getZeitarbeiter().equals(ZEITARBEITER_WAHL_GESELLE)){
                wahrscheinlichkeit = aktiverSpieler.getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getZusammenbau().getGeselleRisiko();
            }
            else{
                throw new Exception("Keine Auswahl des Gehaeuses getroffen.");
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
     */ public void registrierung(String name, String passwort) throws Exception{
        Spieler spieler = new Spieler(name,passwort,getDaten());
        aktiverSpieler= spieler;
        /* try {
            aktiverSpieler =   new Spieler(name, passwort, daten);
        }
        catch (Exception e1) {
            e1.printStackTrace();
        }*/
    } // Ende registrierung()
    /**
     * Aufrug wenn Login bestätigt wird (Button in UI)
     * UI Login
     * Parameter werden von UI übergeben
     * ToDo if abfrage
     * @param name
     * @param passwort
     */
    public boolean login (String name, String passwort) throws Exception{
        Spieler spieler = new Spieler(name,passwort,getDaten());
        spieler= aktiverSpieler;
        if (name.equals(aktiverSpieler.getName()) && passwort.equals(aktiverSpieler.getPasswort())) {
            return true; //falls Name und Passwort von Spieler übereinstimmen
        }
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
        return daten.getRundenAnzahl();
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
        SCHRITT_BEZAHLART_boolean = false; // neunter Schritt Wahl der Versandart
        SCHRITT_VERKAUFSPREIS_boolean = false;
        SCHRITT_PERSONALWESEN_boolean = false;
    }


    /**
     * Methode für die Marktsiumulation
     * @return gibt eine Liste der einzelnen Bestellpositionen fuer jeden Speieler zurueck
     */
    public Auftrag[] getAuftrage()throws Exception{
        Auftrag[] auftraege = new Auftrag[daten.getSpielerAnzahl()];
            if (daten.getSpielerListe() == null) {
                throw new Exception("Spieler Liste leer");
            }

            for (int i = 0; i < daten.getSpielerAnzahl(); i++) {
                if (daten.getSpielerListe().get(i).getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()) != null)
                    auftraege[i] = daten.getSpielerListe().get(i).getAuftragssammlung().getAuftrag(daten.getRundenAnzahl());
                else{
                    throw new Exception ("Kein Objekt gefunden");
                }
            }// Ende for

        return auftraege;
    }  // Ende getAuftrage

    public double[] getPreissimulationenPreis () throws Exception {
        double[] Preise = new double[daten.getSpielerAnzahl()];
        if (daten.getSpielerListe() == null) {
            throw new Exception("Spieler Liste leer");
        }
        for (int i = 0; i < daten.getSpielerAnzahl(); i++) {
            if (daten.getSpielerListe().get(i).getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()) != null)
                Preise[i] = daten.getSpielerListe().get(i).getAuftragssammlung().getAuftrag(daten.getRundenAnzahl()).getPreissimulation().getVerkaufspreis();
            else {
                throw new Exception("Kein Objekt gefunden");
            }
        }
        return Preise;
    } // Ende Preissimulation
} // ENDE KLASSE

