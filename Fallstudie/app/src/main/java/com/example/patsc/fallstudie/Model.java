package com.example.patsc.fallstudie;

/**
 * Created by patsc on 13.12.2016.
 */


//Hier ein Kommentar von Nils

public class  Model {
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
    private final String DESIGNER_WAHL_LOWBUDGET = "LowBudget";
    private final String DESINGER_WAHL_MITTELMAESIG = "Mittelmäßig";
    private final String DESIGNER_WAHL_MARKEN = "Marken";

    private final String ARMBAND_WAHL_LEDER = "Leder";
    private final String ARMBAND_WAHL_KUNSTLEDER = "Kunstleder";
    private final String ARMBAND_WAHL_HOLZ = "Holz";
    private final String ARMBAND_WAHL_TEXTIL = "Textil";
    private final String ARMBAND_WAHL_METALL = "Metall";

    private final String UHRWERK_WAHL_MECHANISCH = "mechanisch";
    private final String UHRWERK_WAHL_ELEKTROMECHANISCH ="elektromechanisch";
    private final String UHRWERK_WAHL_ELEKTRONISCH = "elektronisch";

    private final String GEHAEUSE_WAHL_GLAS = "glas";
    private final String GEHAEUSE_WAHL_HOLZ = "holz";
    private final String GEHAEUSE_WAHL_KUNSTSTOFF = "kunststoff";
    private final String GEHAEUSE_WAHL_METALL ="metall";

    private final String VERSANDART_WAHL_FLUGZEUG = "flugzeug";
    private final String VESANDART_WAHL_SCHIFF ="schiff";
    private final String VERSANDART_WAHL_LANDWEG = "landweg";

    private final String WASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT = "nichtWassergeschützt";
    private final String WASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT = "spritzwassergeschützt";
    private final String WASSERDICHTHEIT_WAHL_WASSERDICHT = "wasserdicht";

    private final String ZUSAMMENBAU_WAHL_DEUTSCHLAND = "deutschland";
    private final String ZUSAMMENBAU_WAHL_ASIEN ="asien";
    private final String ZUSAMMENBAU_WAHL_OSTEUROPA ="osteuropa";
    private final String ZUSAMMENBAU_WAHL_SCHWEIZ ="schweiz";

    private final String WERBUNG_WAHL_VIEL = "viel";
    private final String WERBUNG_WAHL_WENIG = "wenig";
    private final String WERBUNG_WAHL_MITTEL = "mittel";

    // Einzelne Schritte in dem Auswahlprozess
    private final String SCHRITT_DESIGNER = "SCHRITT_DESIGNER"; // erster Schritt Wahl des Designers
    private final String SCHRITT_ARMBAND = "SCHRITT_ARMBAND"; // zweite Schritt Wahl des Armbands
    private final String SCHRITT_UHRWERK = "SCHRITT_UHRWERK"; // dritter Schritt Wahl des Uhrwerks und der Uhrenart
    private final String SCHRITT_GEHAUESE = "SCHRITT_GEHAUSE"; // vierter Schritt Wahl des Gehäuses für die Uhr
    private final String SCHRITT_DICHTHEIT = "SCHRITT_DICHTHEIT"; // fuenfter Schritt Wahl der Dichtheit
    private final String SCHRITT_ZUSAMMENBAU = "SCHRITT_ZUSAMMENBAU"; // sechster Schritt Wahl Zusammenbau
    private final String SCHRITT_WERBUNG = "SCHRITT_WEBUNG"; // siebter Schritt Wahl des Werbeetars
    private final String SCHRITT_KAUFVOLUMEN = "SCHRITT_KAUFVOLUMEN"; // achter Schritt Wahl des Kaufvolumens
    private final String SCHRITT_VERSANDART = "SCHRITT_VERSANDART"; // neunter Schritt Wahl der Versandart
    private final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS"; // zehnter Schritt Wahl der Versandart

    // Zustände während der Bestellung
    private boolean SCHRITT_DESIGNER_boolean = false;// erster Schritt Wahl des Designers
    private boolean Zustand_Spielbeginn = true;
    private boolean Zustand_Bestellung = false;
    private boolean Zustand_Ereignis = false;
    private boolean Zustand_Lieferung = false;

    private boolean Zustand_Ende = false;
    private boolean SCHRITT_ARMBAND_boolean  = false;// zweite Schritt Wahl des Armbands
    private boolean SCHRITT_UHRWERK_boolean  = false;// dritter Schritt Wahl des Uhrwerks und der Uhrenart

    // Zustandsvariablen fuer die Schritte bei dem Zusammenbau
    private boolean SCHRITT_GEHAUESE_boolean  = false;// vierter Schritt Wahl des Gehäuses für die Uhr
    private boolean SCHRITT_DICHTHEIT_boolean  = false;// fuenfter Schritt Wahl der Dichtheit
    private boolean SCHRITT_ZUSAMMENBAU_boolean  = false;// sechster Schritt Wahl Zusammenbau
    private boolean SCHRITT_WERBUNG_boolean  = false; // siebter Schritt Wahl des Werbeetars
    private boolean SCHRITT_KAUFVOLUMEN_boolean  = false; // achter Schritt Wahl des Kaufvolumens
    private boolean SCHRITT_VERSANDART_boolean  = false; // neunter Schritt Wahl der Versandart
    private boolean SCHRITT_VERKAUFSPREIS_boolean = false;

    // Zustands Variablen fuer die Aenderungen
    private boolean AENDERE_ARMBAND_boolean=false;
    private boolean AENDERE_GEHAEUSE_boolean =false;
    private boolean AENDERE_ZUSAMMENBAU_boolean = false;

    /**
     * Konstruktor, wird in der on Create Methode aufgerufen
     */
    public Model(){
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
    public void setAENDERE_ZUSAMMENBAU_boolean(boolean AENDERE_ZUSAMMENBAU_boolean) {
        this.AENDERE_ZUSAMMENBAU_boolean = AENDERE_ZUSAMMENBAU_boolean;
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
    public void setSCHRITT_DESIGNER_boolean(boolean SCHRITT_DESIGNER_boolean) {
        this.SCHRITT_DESIGNER_boolean = SCHRITT_DESIGNER_boolean;
    }
    public void setSCHRITT_DICHTHEIT_boolean(boolean SCHRITT_DICHTHEIT_boolean) {
        this.SCHRITT_DICHTHEIT_boolean = SCHRITT_DICHTHEIT_boolean;
    }
    public void setSCHRITT_GEHAUESE_boolean(boolean SCHRITT_GEHAUESE_boolean) {
        this.SCHRITT_GEHAUESE_boolean = SCHRITT_GEHAUESE_boolean;
    }
    public void setSCHRITT_KAUFVOLUMEN_boolean(boolean SCHRITT_KAUFVOLUMEN_boolean) {
        this.SCHRITT_KAUFVOLUMEN_boolean = SCHRITT_KAUFVOLUMEN_boolean;
    }
    public void setSCHRITT_UHRWERK_boolean(boolean SCHRITT_UHRWERK_boolean) {
        this.SCHRITT_UHRWERK_boolean = SCHRITT_UHRWERK_boolean;
    }
    public void setSCHRITT_VERKAUFSPREIS_boolean(boolean SCHRITT_VERKAUFSPREIS_boolean) {
        this.SCHRITT_VERKAUFSPREIS_boolean = SCHRITT_VERKAUFSPREIS_boolean;
    }
    public void setSCHRITT_VERSANDART_boolean(boolean SCHRITT_VERSANDART_boolean) {
        this.SCHRITT_VERSANDART_boolean = SCHRITT_VERSANDART_boolean;
    }
    public void setSCHRITT_WERBUNG_boolean(boolean SCHRITT_WERBUNG_boolean) {
        this.SCHRITT_WERBUNG_boolean = SCHRITT_WERBUNG_boolean;
    }
    public void setSCHRITT_ZUSAMMENBAU_boolean(boolean SCHRITT_ZUSAMMENBAU_boolean) {
        this.SCHRITT_ZUSAMMENBAU_boolean = SCHRITT_ZUSAMMENBAU_boolean;
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
        Bestellung bestellung = aktiverSpieler.getBestellung(); //Aenderung 2.01 daten.getDieserSpieler() gefixt//ToDo auch hier tritt ein Nullpointer auf, verbindung mit dem in Daten?
        bestellung.neueBestellpositon();
        bestellung.getBestellposition(daten.getRundenAnzahl()); // Wie man die Bestellposition bekomt
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
    public boolean isAENDERE_ZUSAMMENBAU_boolean() {
        return AENDERE_ZUSAMMENBAU_boolean;
    }
    public boolean isSCHRITT_ARMBAND_boolean() {
        return SCHRITT_ARMBAND_boolean;
    }
    public boolean isSCHRITT_DESIGNER_boolean() {
        return SCHRITT_DESIGNER_boolean;
    }
    public boolean isSCHRITT_DICHTHEIT_boolean() {
        return SCHRITT_DICHTHEIT_boolean;
    }
    public boolean isSCHRITT_GEHAUESE_boolean() {
        return SCHRITT_GEHAUESE_boolean;
    }
    public boolean isSCHRITT_KAUFVOLUMEN_boolean() {
        return SCHRITT_KAUFVOLUMEN_boolean;
    }
    public boolean isSCHRITT_UHRWERK_boolean() {
        return SCHRITT_UHRWERK_boolean;
    }
    public boolean isSCHRITT_VERKAUFSPREIS_boolean() {
        return SCHRITT_VERKAUFSPREIS_boolean;
    }
    public boolean isSCHRITT_VERSANDART_boolean() {
        return SCHRITT_VERSANDART_boolean;
    }
    public boolean isSCHRITT_WERBUNG_boolean() {
        return SCHRITT_WERBUNG_boolean;
    }
    public boolean isSCHRITT_ZUSAMMENBAU_boolean() {
        return SCHRITT_ZUSAMMENBAU_boolean;
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
    public String getDESIGNER_WAHL_LOWBUDGET() {
        return DESIGNER_WAHL_LOWBUDGET;
    }
    public String getDESIGNER_WAHL_MARKEN() {
        return DESIGNER_WAHL_MARKEN;
    }
    public String getDESINGER_WAHL_MITTELMAESIG() {
        return DESINGER_WAHL_MITTELMAESIG;
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
    public String getSCHRITT_DESIGNER() {

        return SCHRITT_DESIGNER;
    }
    public String getSCHRITT_DICHTHEIT() {
        return SCHRITT_DICHTHEIT;
    }
    public String getSCHRITT_GEHAUESE() {
        return SCHRITT_GEHAUESE;
    }
    public String getSCHRITT_KAUFVOLUMEN() {
        return SCHRITT_KAUFVOLUMEN;
    }
    public String getSCHRITT_UHRWERK() {
        return SCHRITT_UHRWERK;
    }
    public String getSCHRITT_VERSANDART() {
        return SCHRITT_VERSANDART;
    }
    public String getSCHRITT_WERBUNG() {
        return SCHRITT_WERBUNG;
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
    public String getVERSANDART_WAHL_FLUGZEUG() {
        return VERSANDART_WAHL_FLUGZEUG;
    }
    public String getVERSANDART_WAHL_LANDWEG() {
        return VERSANDART_WAHL_LANDWEG;
    }
    public String getVESANDART_WAHL_SCHIFF() {
        return VESANDART_WAHL_SCHIFF;
    }
    public String getWASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT() {
        return WASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT;
    }
    public String getWASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT() {
        return WASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT;
    }
    public String getWASSERDICHTHEIT_WAHL_WASSERDICHT() {
        return WASSERDICHTHEIT_WAHL_WASSERDICHT;
    }
    public String getWERBUNG_WAHL_MITTEL() {
        return WERBUNG_WAHL_MITTEL;
    }
    public String getWERBUNG_WAHL_VIEL() {
        return WERBUNG_WAHL_VIEL;
    }
    public String getWERBUNG_WAHL_WENIG() {
        return WERBUNG_WAHL_WENIG;
    }
    public String getZUSAMMENBAU_WAHL_ASIEN() {
        return ZUSAMMENBAU_WAHL_ASIEN;
    }
    public String getZUSAMMENBAU_WAHL_DEUTSCHLAND() {
        return ZUSAMMENBAU_WAHL_DEUTSCHLAND;
    }
    public String getZUSAMMENBAU_WAHL_OSTEUROPA() {
        return ZUSAMMENBAU_WAHL_OSTEUROPA;
    }
    public String getZUSAMMENBAU_WAHL_SCHWEIZ() {
        return ZUSAMMENBAU_WAHL_SCHWEIZ;
    }
    public String getSchrittDesigner(){return SCHRITT_DESIGNER;}
    public String getSchrittArmband(){return SCHRITT_ARMBAND;}
    public String getSchrittUhrwerk(){return SCHRITT_UHRWERK;}
    public String getSchrittDichtheit(){return SCHRITT_DICHTHEIT;}
    public String getSchrittGehauese(){return SCHRITT_GEHAUESE;}
    public String getSchrittZusammenbau(){return SCHRITT_ZUSAMMENBAU;}
    public String getSchrittWerbung(){return SCHRITT_WERBUNG;}
    public String getSchrittKaufvolumen(){return SCHRITT_KAUFVOLUMEN;}
    public String getSchrittVersandart(){return SCHRITT_VERSANDART;}
    public String getSchrittVerkaufspreis(){return SCHRITT_VERKAUFSPREIS;}

    public Daten getDaten(){
        return daten;
    }

    public void setAktiverSpieler(){
        //ToDo
    }


    // Setter Zustand für die Methoden


    // Methoden die von dem UI Aufgerufen werden
    //Methoden zum setzen der aktuellen UI-Activity (aufgerufen in onCreate)
    public void setActivity_Login () {
        setzeAlleZustaendeFalse();
        setzeAlleSchritteFalse();
        setZustand_Spielbeginn(true);
    }
    public void setActivity_E1 () {
      aktiverSpieler.getBestellung().neueBestellpositon(); // Absturz 1.54; aktiver SPier in registrierung zugeordnet Fix 1.58
        //ToDo RUndenanzahl erhöhen
        setZustand_Bestellung(true); // Absturz 2.01 fix 2.04
        setSCHRITT_DESIGNER_boolean(true);
    }
    public void setActivity_E2 () {
        setZustand_Bestellung(true);
        setSCHRITT_ARMBAND_boolean(true);
    }
    public void setActivity_E3 () {
        setZustand_Bestellung(true);
        setSCHRITT_UHRWERK_boolean(true);
    }
    public void setActivity_E4 () {
        setZustand_Bestellung(true);
        setSCHRITT_GEHAUESE_boolean(true);
    }
    public void setActivity_E5 () {
        setZustand_Bestellung(true);
        setSCHRITT_VERSANDART_boolean(true);

    }
    public void setActivity_E6 () {
        setZustand_Bestellung(true);
        setSCHRITT_DICHTHEIT_boolean(true);
    }
    public void setActivity_E7 () {
        setZustand_Bestellung(true);
        setSCHRITT_ZUSAMMENBAU_boolean(true);
    }
    public void setActivity_E8 () {
        setZustand_Bestellung(true);
        setSCHRITT_WERBUNG_boolean(true);
    }
    public void setActivity_E9 () {
        setZustand_Bestellung(true);
        setSCHRITT_KAUFVOLUMEN_boolean(true);
    }
    public void setActivity_E10 () {
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
        setAENDERE_ZUSAMMENBAU_boolean(true);
    }
    public void setActivity_Berechnung () throws Exception {
        setZustand_Lieferung(true);

        //Hier Preis und Marktsimulation durchführen!
        // erstellen der Preissimulation

        //ToDo Prüfung ob alle Spieler Werte eingegeben haben
        // ToDO DB abruf
        double kosten = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getFixKosten() + aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVarKosten();
        Preissimulation preissim = new Preissimulation(kosten, aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVkp(), daten.getRundenAnzahl(), aktiverSpieler.getBestellung()); //ToDo
        aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).setPreissim(preissim);
        Marktsim marktsim = new Marktsim(getPreissimulationenPreis());
        aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).setMarktsim(marktsim);// ToDo evtl in MarktSim ausgübt

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
    public void setDesigner (String designerAuswahl) throws Exception{
        //Prüfung ob die Wahl des Designers erlaubt ist

            if (SCHRITT_DESIGNER_boolean){
                if(designerAuswahl == DESIGNER_WAHL_LOWBUDGET ||designerAuswahl == DESIGNER_WAHL_MARKEN || designerAuswahl==DESINGER_WAHL_MITTELMAESIG ){
                    aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleDesigner(designerAuswahl); //ToDo Nullpointer Exception
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }

    } // Ende SetDesigner
    public void setArmband (String armbandAuswahl) throws Exception{
            if (SCHRITT_ARMBAND_boolean){
                if(armbandAuswahl == ARMBAND_WAHL_HOLZ || armbandAuswahl == ARMBAND_WAHL_KUNSTLEDER|| armbandAuswahl==ARMBAND_WAHL_LEDER || armbandAuswahl==ARMBAND_WAHL_METALL|| armbandAuswahl==ARMBAND_WAHL_TEXTIL){
                    aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleArmband(armbandAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }// Ende SetArmband
    public void setArmbandNeu (String armbandAuswahl)throws Exception{              //nach Zufall Z3
            if (AENDERE_ARMBAND_boolean){
                if(armbandAuswahl == ARMBAND_WAHL_HOLZ || armbandAuswahl == ARMBAND_WAHL_KUNSTLEDER|| armbandAuswahl==ARMBAND_WAHL_LEDER || armbandAuswahl==ARMBAND_WAHL_METALL|| armbandAuswahl==ARMBAND_WAHL_TEXTIL)
                // Prüfung ob das Material schon einmal gewaehlt wurde in Activity
                { aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleArmband(armbandAuswahl);
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
                { aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleUhrwerk(uhrwerkAuswahl);
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
                { aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleGehaeuse(gehaeuseAuswahl);
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
                    aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).korrigiereGehaeuse(gehaeuseAuswahl);
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
    public void setVersandart (String versandartAuswahl)throws  Exception{
            if (SCHRITT_VERSANDART_boolean){
                if(versandartAuswahl.equals(VERSANDART_WAHL_FLUGZEUG)||versandartAuswahl.equals(VERSANDART_WAHL_LANDWEG)||versandartAuswahl.equals(VESANDART_WAHL_SCHIFF))
                { aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleVersandart(versandartAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    } //Ende set Versandart //
    public void setWasserdichtheit (String wasserdichtheitAuswahl)throws Exception{
            if (SCHRITT_DICHTHEIT_boolean){
                if(wasserdichtheitAuswahl.equals(WASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT)||wasserdichtheitAuswahl.equals(WASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT)||wasserdichtheitAuswahl.equals(WASSERDICHTHEIT_WAHL_WASSERDICHT))
                { aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleWasserdichtheit(wasserdichtheitAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    } // Ende setWasserdichtheit
    public void setZusammenbau (String zusammenbauAuswahl)throws Exception{
            if (SCHRITT_ZUSAMMENBAU_boolean){
                if(zusammenbauAuswahl.equals(ZUSAMMENBAU_WAHL_ASIEN)||zusammenbauAuswahl.equals(ZUSAMMENBAU_WAHL_DEUTSCHLAND)||zusammenbauAuswahl.equals(ZUSAMMENBAU_WAHL_OSTEUROPA)||zusammenbauAuswahl.equals(ZUSAMMENBAU_WAHL_SCHWEIZ))
                { aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleZusamenbau(zusammenbauAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    } // Ende setZusammebau
    public void setZusammenbauNeu (String zusammenbauAuswahl)throws Exception{              //nach Zufall Z3
            if (AENDERE_ZUSAMMENBAU_boolean){
                if(zusammenbauAuswahl.equals(ZUSAMMENBAU_WAHL_ASIEN)||zusammenbauAuswahl.equals(ZUSAMMENBAU_WAHL_DEUTSCHLAND)||zusammenbauAuswahl.equals(ZUSAMMENBAU_WAHL_OSTEUROPA)||zusammenbauAuswahl.equals(ZUSAMMENBAU_WAHL_SCHWEIZ))
                {aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).korrigiereZusammenbau(zusammenbauAuswahl);
                    AENDERE_ZUSAMMENBAU_boolean=false;
                }
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }// Ende setZusammenbauNeu
    public void setWerbung (String werbungAuswahl)throws Exception{
            if (SCHRITT_WERBUNG_boolean){
                if(werbungAuswahl.equals(WERBUNG_WAHL_MITTEL)||werbungAuswahl.equals(WERBUNG_WAHL_VIEL)||werbungAuswahl.equals(WERBUNG_WAHL_WENIG))
                { aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleWerbung(werbungAuswahl);
                    setzeAlleSchritteFalse();}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }//Ende set Werbung
    public void setKaufvolumen (float kaufvolumenAuswahl)throws Exception{
            if (SCHRITT_KAUFVOLUMEN_boolean){
                int kaufVolumen = ((int) kaufvolumenAuswahl);
                aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleMenge(kaufVolumen);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }

    }//Ende setKaufvolumen //
    public void setVerkaufspreis (float verkaufspreisAuswahl)throws Exception{
            if (SCHRITT_VERKAUFSPREIS_boolean){
                double verkaufspreis = ((double)verkaufspreisAuswahl);
                aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleVKP(verkaufspreis);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }
    }// Ende Verkaufspreis //

    //Methoden zum abholen der Bestellpositionen, zur Anzeige er Bestellzusammenfassung
    public String getDesigner ( )throws Exception{
        String designer ="";
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getDesigner().isLowBudget()){
                designer = DESIGNER_WAHL_LOWBUDGET;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getDesigner().isMarken()){
                designer = DESIGNER_WAHL_MARKEN;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getDesigner().isMittelmaessig()){
                designer = DESINGER_WAHL_MITTELMAESIG;
            }
            else{

                throw new Exception("Keine Wahl getroffen");
            }
        // Ende try
        return designer;
    }// Ende getDesigner
    public String getArmband ( )throws Exception{
        String armband ="";
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().isHolz()){
                armband = ARMBAND_WAHL_HOLZ;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().isKunstleder()){
                armband =ARMBAND_WAHL_KUNSTLEDER;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().isLeder()){
                armband = ARMBAND_WAHL_LEDER;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().isMetall()){
                armband = ARMBAND_WAHL_METALL;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().isTextil()){
                armband = ARMBAND_WAHL_TEXTIL;
            }
            else{

                throw new Exception("Keine Wahl getroffen");
            }
        return armband;
    }// Ende get Armband
    public String getUhrwerk ( ) throws Exception{
        String uhrwerk = "";
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getUhrwerk().isElektromechanisch()){
                uhrwerk = UHRWERK_WAHL_ELEKTROMECHANISCH;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getUhrwerk().isElektronisch()) {
                uhrwerk = UHRWERK_WAHL_ELEKTRONISCH;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getUhrwerk().isMechanisch()){
                uhrwerk = UHRWERK_WAHL_MECHANISCH;}
            else{
                throw new Exception("Keine Wahl im Uhrwerk getroffen.");
            }
        return uhrwerk;
    }// Ende getUhrwerk
    public String getGehaeuse ( ) throws Exception{
        String gehaeuse ="";
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getGehaeuse().isMetall()){
                gehaeuse = GEHAEUSE_WAHL_METALL;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getGehaeuse().isHolz()){
                gehaeuse = GEHAEUSE_WAHL_HOLZ;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getGehaeuse().isGlas()){
                gehaeuse =GEHAEUSE_WAHL_GLAS;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getGehaeuse().isKunststoff()) {
                gehaeuse = GEHAEUSE_WAHL_KUNSTSTOFF;
            }
            else{
                throw new Exception("Keine Auswahl des Gehaueses getroffen.");
            }
        return gehaeuse;
    } // Ende getGehaeuse
    public String getVersandart ( )throws Exception{
        String versandart="";
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVersandart().isFlugzeug()){
                versandart = VERSANDART_WAHL_FLUGZEUG;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVersandart().isLandweg()){
                versandart = VERSANDART_WAHL_LANDWEG;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVersandart().isSchiff()){
                versandart = VESANDART_WAHL_SCHIFF;
            }
            else{
                throw new Exception("Keine Auswahl der Versandart getroffen.");
            }
        return versandart;
    }//Ende getVersandart
    public String getWasserdichtheit ( )throws Exception{
        String dichtheit = "";
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getWasserdichtheit().isNichtWassergeschützt()){
                dichtheit=WASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getWasserdichtheit().isSpritzwassergeschützt()){
                dichtheit = WASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getWasserdichtheit().isWasserdicht()){
                dichtheit = WASSERDICHTHEIT_WAHL_WASSERDICHT;
            }
            else{
                throw new Exception("Keine Auswahl der Wasserdichtheit getroffen.");
            }
        return dichtheit;
    }// ENde getWasserdichtheit
    public String getZusammenbau ()throws Exception{
        String zusammenbau = "";
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getZusammenbau().isAsien()){
                zusammenbau = ZUSAMMENBAU_WAHL_ASIEN;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getZusammenbau().isDeutschland()){
                zusammenbau = ZUSAMMENBAU_WAHL_DEUTSCHLAND;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getZusammenbau().isOsteuropa()){
                zusammenbau = ZUSAMMENBAU_WAHL_OSTEUROPA;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getZusammenbau().isSchweiz()){
                zusammenbau =ZUSAMMENBAU_WAHL_SCHWEIZ;
            }
            else{
                throw new Exception("Keine Auswahl bei dem Zusamenbau getroffen.");
            }
        return zusammenbau;
    } // Ende getZussamenbau
    public String getWerbung ( )throws Exception{
        String werbung ="";
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getWerbung().isMittel()){
                werbung = WERBUNG_WAHL_MITTEL;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getWerbung().isViel()){
                werbung = WERBUNG_WAHL_VIEL;
            }
            else if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getWerbung().isWenig()){
                werbung = WERBUNG_WAHL_WENIG;
            }
            else{
                throw new Exception("Keine Auswahl bei dem Zusamenbau getroffen.");
            }
        return werbung;
    } // Ende get Werbung
    public float getKaufvolumen ( ){
        float kv = (float)aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getMenge();
        return kv;
    } // Ende getKaufvolumen
    public float getVerkaufspreis ( ){
        float vkp = (float)aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVkp();
        return vkp;
    }// Ende getVerkaugspreis

    // Methoden zum Aufrufen der Bonären Werte
    public float getFixKosten() {
        float fixKosten = (float) aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getFixKosten();
        return fixKosten;
    }
    public float getVarKosten(){
        float varKosten =(float) aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVarKosten();
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
        AENDERE_ZUSAMMENBAU_boolean = false;
        double wahrscheinlichkeit = 0;
            if (aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().isHolz()){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().getHolzRisiko();
            }
            else if (getArmband().equals(ARMBAND_WAHL_KUNSTLEDER) ){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().getKunstlederRisiko();
            }
            else if (getArmband().equals(ARMBAND_WAHL_LEDER)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().getLederRisiko();
            }
            else if (getArmband().equals(ARMBAND_WAHL_METALL)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().getMetallRisiko();
            }
            else if (getArmband().equals(ARMBAND_WAHL_TEXTIL)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().getTextilRisiko();
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
        AENDERE_ZUSAMMENBAU_boolean = false;
        double wahrscheinlichkeit = 0;
            if (getGehaeuse().equals(GEHAEUSE_WAHL_KUNSTSTOFF)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getGehaeuse().getKunststoffRisiko();
            }
            else if(getGehaeuse().equals(GEHAEUSE_WAHL_METALL)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getGehaeuse().getMetallRisiko();
            }
            else if(getGehaeuse().equals(GEHAEUSE_WAHL_GLAS)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getGehaeuse().getGlasRisiko();
            }
            else if (getGehaeuse().equals(GEHAEUSE_WAHL_HOLZ)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getGehaeuse().getHolzRisiko();
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
    public boolean isZufall3 ()throws Exception{ // Zufall 3 = Zusammenbau Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZUSAMMENBAU_boolean = false;
        double wahrscheinlichkeit = 0;
            if (getZusammenbau().equals(ZUSAMMENBAU_WAHL_ASIEN)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getZusammenbau().getAsienRisiko();
            }
            else if (getZusammenbau().equals(ZUSAMMENBAU_WAHL_SCHWEIZ)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getZusammenbau().getSchweizRisiko();
            }
            else if (getZusammenbau().equals(ZUSAMMENBAU_WAHL_OSTEUROPA)){
                wahrscheinlichkeit =  aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getZusammenbau().getAsienRisiko();

            }
            else if (getZusammenbau().equals(ZUSAMMENBAU_WAHL_DEUTSCHLAND)){
                wahrscheinlichkeit = aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getZusammenbau().getDeutschlandRisiko();
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
        SCHRITT_DESIGNER_boolean = false;// erster Schritt Wahl des Designers
        SCHRITT_ARMBAND_boolean  = false;// zweite Schritt Wahl des Armbands
        SCHRITT_UHRWERK_boolean  = false;// dritter Schritt Wahl des Uhrwerks und der Uhrenart
        SCHRITT_GEHAUESE_boolean  = false;// vierter Schritt Wahl des Gehäuses für die Uhr
        SCHRITT_DICHTHEIT_boolean  = false;// fuenfter Schritt Wahl der Dichtheit
        SCHRITT_ZUSAMMENBAU_boolean  = false;// sechster Schritt Wahl Zusammenbau
        SCHRITT_WERBUNG_boolean  = false; // siebter Schritt Wahl des Werbeetars
        SCHRITT_KAUFVOLUMEN_boolean  = false; // achter Schritt Wahl des Kaufvolumens
        SCHRITT_VERSANDART_boolean  = false; // neunter Schritt Wahl der Versandart
        SCHRITT_VERKAUFSPREIS_boolean = false;
    }


    /**
     * Methode für die Marktsiumulation
     * @return gibt eine Liste der einzelnen Bestellpositionen fuer jeden Speieler zurueck
     */
    public Bestellposition[] getBestellpositionen()throws Exception{
        Bestellposition[] bestellpositionen = new Bestellposition[daten.getSpielerAnzahl()];
            if (daten.getSpielerListe() == null) {
                throw new Exception("Spieler Liste leer");
            }

            for (int i = 0; i < daten.getSpielerAnzahl(); i++) {
                if (daten.getSpielerListe().get(i).getBestellung().getBestellposition(daten.getRundenAnzahl()) != null)
                    bestellpositionen[i] = daten.getSpielerListe().get(i).getBestellung().getBestellposition(daten.getRundenAnzahl());
                else{
                    throw new Exception ("Kein Objekt gefunden");
                }
            }// Ende for

        return bestellpositionen;
    }  // Ende getBestellpositionen

    public double[] getPreissimulationenPreis () throws Exception {
        double[] Preise = new double[daten.getSpielerAnzahl()];
        if (daten.getSpielerListe() == null) {
            throw new Exception("Spieler Liste leer");
        }
        for (int i = 0; i < daten.getSpielerAnzahl(); i++) {
            if (daten.getSpielerListe().get(i).getBestellung().getBestellposition(daten.getRundenAnzahl()) != null)
                Preise[i] = daten.getSpielerListe().get(i).getBestellung().getBestellposition(daten.getRundenAnzahl()).getPreissimulation().getVerkaufspreis();
            else {
                throw new Exception("Kein Objekt gefunden");
            }
        }
        return Preise;
    } // Ende Preissimulation
} // ENDE KLASSE

