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

    private Daten daten; // Klasse in der alle Daten gehalten werden wird bei OnCreate erzeugt
    public Daten getDaten(){
        return daten;
    }

    public Spieler aktiverSpieler;
    public void setAktiverSpieler(){
        //ToDo
    }


    /**
     * Strings für die Übergabe der Auswahl
     */
    public final String DESIGNER_WAHL_LOWBUDGET = "LowBudget";
    public final String DESINGER_WAHL_MITTELMAESIG = "Mittelmäßig";
    public final String DESIGNER_WAHL_MARKEN = "Marken";

    public final String ARMBAND_WAHL_LEDER = "Leder";
    public final String ARMBAND_WAHL_KUNSTLEDER = "Kunstleder";
    public final String ARMBAND_WAHL_HOLZ = "Holz";
    public final String ARMBAND_WAHL_TEXTIL = "Textil";
    public final String ARMBAND_WAHL_METALL = "Metall";

    public final String UHRWERK_WAHL_MECHANISCH = "mechanisch";
    public final String UHRWERK_WAHL_ELEKTROMECHANISCH ="elektromechanisch";
    public final String UHRWERK_WAHL_ELEKTRONISCH = "elektronisch";

    public final String GEHAEUSE_WAHL_GLAS = "glas";
    public final String GEHAEUSE_WAHL_HOLZ = "holz";
    public final String GEHAEUSE_WAHL_KUNSTSTOFF = "kunststoff";
    public final String GEHAEUSE_WAHL_METALL ="metall";

    public final String VERSANDART_WAHL_FLUGZEUG = "flugzeug";
    public final String VESANDART_WAHL_SCHIFF ="schiff";
    public final String VERSANDART_WAHL_LANDWEG = "landweg";

    public final String WASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT = "nichtWassergeschützt";
    public final String WASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT = "spritzwassergeschützt";
    public final String WASSERDICHTHEIT_WAHL_WASSERDICHT = "wasserdicht";

    public final String ZUSAMMENBAU_WAHL_DEUTSCHLAND = "deutschland";
    public final String ZUSAMMENBAU_WAHL_ASIEN ="asien";
    public final String ZUSAMMENBAU_WAHL_OSTEUROPA ="osteuropa";
    public final String ZUSAMMENBAU_WAHL_SCHWEIZ ="schweiz";

    public final String WERBUNG_WAHL_VIEL = "viel";
    public final String WERBUNG_WAHL_WENIG = "wenig";
    public final String WERBUNG_WAHL_MITTEL = "mittel";

    // Einzelne Schritte in dem Auswahlprozess
    public final String SCHRITT_DESIGNER = "SCHRITT_DESIGNER"; // erster Schritt Wahl des Designers
    public final String SCHRITT_ARMBAND = "SCHRITT_ARMBAND"; // zweite Schritt Wahl des Armbands
    public final String SCHRITT_UHRWERK = "SCHRITT_UHRWERK"; // dritter Schritt Wahl des Uhrwerks und der Uhrenart
    public final String SCHRITT_GEHAUESE = "SCHRITT_GEHAUSE"; // vierter Schritt Wahl des Gehäuses für die Uhr
    public final String SCHRITT_DICHTHEIT = "SCHRITT_DICHTHEIT"; // fuenfter Schritt Wahl der Dichtheit
    public final String SCHRITT_ZUSAMMENBAU = "SCHRITT_ZUSAMMENBAU"; // sechster Schritt Wahl Zusammenbau
    public final String SCHRITT_WERBUNG = "SCHRITT_WEBUNG"; // siebter Schritt Wahl des Werbeetars
    public final String SCHRITT_KAUFVOLUMEN = "SCHRITT_KAUFVOLUMEN"; // achter Schritt Wahl des Kaufvolumens
    public final String SCHRITT_VERSANDART = "SCHRITT_VERSANDART"; // neunter Schritt Wahl der Versandart
    public final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS"; // zehnter Schritt Wahl der Versandart
    /*
     * getter Methoden
     * keine String Methode da final
     */


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

    /*
            Zustände während des Spiels
             */
    private boolean Zustand_Spielbeginn = true;
    private boolean Zustand_Bestellung = false;
    private boolean Zustand_Ereignis = false; // ToDO Eventuell mehrere? für jedes Ereignis ein eigener Zustand? Oder wie bei Bestellung?

    private boolean Zustand_Lieferung = false;

    private boolean Zustand_Ende = false;
    /*
    Getter und Setter für Zustände
     */
    public boolean isZustand_Spielbeginn(){return Zustand_Spielbeginn;}

    public boolean isZustand_Bestellung(){return Zustand_Bestellung;}
    public boolean isZustand_Ende(){return Zustand_Ende;}
    public boolean isZustand_Ereignis(){return Zustand_Ereignis;}
    public boolean isZustand_Lieferung(){return Zustand_Lieferung;}


    /**
     * Konstruktor, wird in der on Create Methode aufgerufen
     */
    public Model(){
        daten = new Daten(); // erzeugung der Klasse Daten
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


    /**
     * ToDO
     * @param Zustand
     */
    public void setZustand_Bestellung(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Bestellung = true;
        Bestellung bestellung = daten.getDieserSpieler().getBestellung();
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


    /**
     * Methoden
     */

    public void naechster_Schritt_Auswahl(){} // Setzen des nächsten AuswahlSchritts
    public void naechster_Zustand(){} // Setzen des nächsten Zustands


    /**
     * Hilfsmethoden
     */


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


    /**
     * Methoden für die Wechsel innerhalb der Zustände Zustände
     */

    /**
     * Aufruf wenn Nutzerdaten bestätigt werden (Button in UI)
     * UI Registierung
     * Parameter werden von UI übergeben
     * @param name
     * @param passwort
     */
    public void registrierung(String name, String passwort){
           try {
               new Spieler(name, passwort, daten);
           }
           catch (Exception e1) {
                   e1.printStackTrace();
               }
           } // Ende registrierung()

    /**
     * Aufrug wenn Login bestätigt wird (Button in UI)
     * UI Login
     * Parameter werden von UI übergeben
     * @param name
     * @param passwort
     */
    public void login(String name, String passwort){
        // daten.ladeSpieler(name, passwort); ToDo in Daten
    }

    //ToDO Spielfortsetzen

    // Zusand Spielbeginn



    // METHODEN VON NILS HINZUGEFÜGT, VORERST LEER, WERDEN VON GUI AUFGERUFEN //TODO: Methoden füllen

    // Methoden zum weitergeben der UI-Inputs

    /**
     * Aufruf in Activity
     * @param designerAuswahl
     */
    public void setDesigner (String designerAuswahl){
        //Prüfung ob die Wahl des Designers erlaubt ist
        try{
            if (SCHRITT_DESIGNER_boolean){
              if(designerAuswahl == DESIGNER_WAHL_LOWBUDGET ||designerAuswahl == DESIGNER_WAHL_MARKEN || designerAuswahl==DESINGER_WAHL_MITTELMAESIG ){
                aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleDesigner(designerAuswahl);
                setzeAlleSchritteFalse();}
                else{
                  throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
              }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// Ende setDesigner

    public void setArmband (String armbandAuswahl){
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// Ende SetArmband

    public void setArmbandNeu (String armbandAuswahl){              //nach Zufall Z3
        try{
            if (AENDERE_ARMBAND_boolean){
                if(armbandAuswahl == ARMBAND_WAHL_HOLZ || armbandAuswahl == ARMBAND_WAHL_KUNSTLEDER|| armbandAuswahl==ARMBAND_WAHL_LEDER || armbandAuswahl==ARMBAND_WAHL_METALL|| armbandAuswahl==ARMBAND_WAHL_TEXTIL)
                  // Pruefunf das nicht das gleiche Material wieder gewählt wird
                  //  switch
                    // if (!armbandAuswahl == aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getArmband().get)
                { aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleArmband(armbandAuswahl);
                    AENDERE_ARMBAND_boolean=false;}
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// Ende setArmbandNeu

    public void setUhrwerk (String uhrwerkAuswahl){
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//Ende setUhrwek

    public void setGehaeuse (String gehaeuseAuswahl){
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// Ende setGehaeuse

    public void setGehaeuseNeu (String gehaeuseAuswahl){                //nach Zufall Z2
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Ende setGehaeuseNeu

    public void setVersandart (String versandartAuswahl){
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //Ende set Versandart

    public void setWasserdichtheit (String wasserdichtheitAuswahl){
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Ende setWasserdichtheit

    public void setZusammenbau (String zusammenbauAuswahl){
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // Ende setZusammebau

    public void setZusammenbauNeu (String zusammenbauAuswahl){              //nach Zufall Z3
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// Ende setZusammenbauNeu

    public void setWerbung (String werbungAuswahl){
        try{
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setKaufvolumen (float kaufvolumenAuswahl){
        try{
            if (SCHRITT_KAUFVOLUMEN_boolean){
                int kaufVolumen = ((int) kaufvolumenAuswahl);
                aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleMenge(kaufVolumen);
                    setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVerkaufspreis (float verkaufspreisAuswahl){
        try{
            if (SCHRITT_VERKAUFSPREIS_boolean){
                int verkaufspreis = ((int)verkaufspreisAuswahl);
                aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).bestelleVKP(verkaufspreis);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Methoden zum abholen der Bestellpositionen, zur Anzeige er Bestellzusammenfassung

    public String getDesigner ( ){
        return "";
    }

    public String getArmband ( ){
        return "";
    }

    public String getUhrwerk ( ){
        return "";
    }

    public String getGehaeuse ( ){
        return "";
    }

    public String getVersandart ( ){
        return "";
    }

    public String getWasserdichtheit ( ){
        return "";
    }

    public String getZusammenbau (){
        return "";
    }

    public String getWerbung ( ){
        return "";
    }

    public float getKaufvolumen ( ){
        return 0;
    }

    public float getVerkaufspreis ( ){
        return 0;
    }



    //Methoden zum Abrufen der aktuellen Fixkosten und variablen Kosten //TODO: return-Werte

    public float getFixKosten() {
       return 0;
    }

    public float getVarKosten(){
        return 0;
    }

    //
    public double getGuthaben()
          //getRunde

    public Spieler[] getBestenliste{
        //ToDo
    }
    //Methoden zum Überprüfen ob ein Zufall eingetreten ist, entsprechende Weiterleitung der Activities
    // TODO: richtiger Rückgabewert, welcher genaue Zufall? bei Z1 Leder, Metall oder .. ?

    public boolean isZufall1 (){
        return true;
    }

    public boolean isZufall2 (){
        return true;
    }

    public boolean isZufall3 (){
        return true;
    }


    //Methoden zum setzen der aktuellen UI-Activity (aufgerufen in onCreate)

    public void setActivity_Login () {

    }

    public void setActivity_E1 () {

    }

    public void setActivity_E2 () {

    }

    public void setActivity_E3 () {

    }

    public void setActivity_E4 () {

    }

    public void setActivity_E5 () {

    }

    public void setActivity_E6 () {

    }

    public void setActivity_E7 () {

    }

    public void setActivity_E8 () {

    }

    public void setActivity_E9 () {

    }

    public void setActivity_E10 () {

    }


    public void setActivity_Bestellzusammenfassung () {

    }


    public void setActivity_Z1 () {

    }


    public void setActivity_Z2 () {

    }


    public void setActivity_Z3 () {

    }


    public void setActivity_Berechnung () {

    }


    public void setActivity_Rundenergebnis () {

    }




    public boolean SCHRITT_DESIGNER_boolean = false;// erster Schritt Wahl des Designers
    public boolean SCHRITT_ARMBAND_boolean  = false;// zweite Schritt Wahl des Armbands
    public boolean SCHRITT_UHRWERK_boolean  = false;// dritter Schritt Wahl des Uhrwerks und der Uhrenart
    public boolean SCHRITT_GEHAUESE_boolean  = false;// vierter Schritt Wahl des Gehäuses für die Uhr
    public boolean SCHRITT_DICHTHEIT_boolean  = false;// fuenfter Schritt Wahl der Dichtheit
    public boolean SCHRITT_ZUSAMMENBAU_boolean  = false;// sechster Schritt Wahl Zusammenbau
    public boolean SCHRITT_WERBUNG_boolean  = false; // siebter Schritt Wahl des Werbeetars
    public boolean SCHRITT_KAUFVOLUMEN_boolean  = false; // achter Schritt Wahl des Kaufvolumens
    public boolean SCHRITT_VERSANDART_boolean  = false; // neunter Schritt Wahl der Versandart
    public boolean  SCHRITT_VERKAUFSPREIS_boolean = false;

    public boolean AENDERE_ARMBAND_boolean=false;
    public boolean AENDERE_GEHAEUSE_boolean =false;
    public boolean AENDERE_ZUSAMMENBAU_boolean = false;


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


} // ENDE KLASSE

