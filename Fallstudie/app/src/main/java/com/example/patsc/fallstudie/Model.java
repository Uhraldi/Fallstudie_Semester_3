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
             aktiverSpieler =   new Spieler(name, passwort, daten);
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


/*
    //TODO: if-Abfrage richtig implementieren
    public boolean login (String name, String passwort){
        if (name.equals(Spieler.getName()) && passwort.equals(Spieler.getPasswort())) {
            return true; //falls Name und Passwort von Spieler übereinstimmen
        }
            return false; //falls Name und Passwort nicht zusammengehören
    }
*/


  /*  public void login(String name, String passwort){

       aktiverSpieler = new Spieler(name, passwort,daten);
        // daten.ladeSpieler(name, passwort); ToDo in Daten
    }
*/
    //ToDO Spielfortsetzen

    // Zusand Spielbeginn



    // METHODEN VON NILS HINZUGEFÜGT, VORERST LEER, WERDEN VON GUI AUFGERUFEN

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
                double verkaufspreis = ((double)verkaufspreisAuswahl);
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
     String designer ="";
        try{
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
        } // Ende try
        catch (Exception e) {
            e.printStackTrace();
        }
        return designer;
    }// Ende getDesigner

    public String getArmband ( ){
        String armband ="";
        try {
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
        } // Ende try
        catch (Exception e) {
            e.printStackTrace();
        }
        return armband;
    }// Ende get Armband

    public String getUhrwerk ( ) {
        String uhrwerk = "";
        try{
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
        }}
        catch (Exception e) {
            e.printStackTrace();
        }
        return uhrwerk;
    }// Ende getUhrwerk


    public String getGehaeuse ( ){
        String gehaeuse ="";
        try{
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
        }//Ende try
        catch (Exception e) {
            e.printStackTrace();
        }
        return gehaeuse;
    } // Ende getGehaeuse

    public String getVersandart ( ){
        String versandart="";
        try{
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
        }//Ende try
        catch (Exception e) {
            e.printStackTrace();
        }
        return versandart;
    }//Ende getVersandart

    public String getWasserdichtheit ( ){
        String dichtheit = "";
        try{
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
        }//Ende try
        catch (Exception e) {
            e.printStackTrace();
        }
        return dichtheit;
    }// ENde getWasserdichtheit

    public String getZusammenbau (){
        String zusammenbau = "";
        try{
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
        }//Ende try
        catch (Exception e) {
            e.printStackTrace();
        }
        return zusammenbau;
    } // Ende getZussamenbau

    public String getWerbung ( ){
        String werbung ="";
        try{
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
    }//Ende try
    catch (Exception e) {
        e.printStackTrace();
    }
    return werbung;
} // Ende get Werbung

    public float getKaufvolumen ( ){
        float kv = (float)aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getMenge();
        return kv;
    }

    public float getVerkaufspreis ( ){
        float vkp = (float)aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVkp();
        return vkp;
    }



    //Methoden zum Abrufen der aktuellen Fixkosten und variablen Kosten

    public float getFixKosten() {
       float fixKosten = (float) aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getFixKosten();
        return fixKosten;
    }

    public float getVarKosten(){
        float varKosten =(float) aktiverSpieler.getBestellung().getBestellposition(daten.getRundenAnzahl()).getVarKosten();
        return varKosten;
    }

    //
    public double getGuthaben(){
       double guthaben = (double) aktiverSpieler.getGuthaben();
        return guthaben;
    }

    public int getRunde(){
        return daten.getRundenAnzahl();
    }

/*    public Spieler[] getBestenliste{
        //ToDo
        Spieler [] nF = new SPieler()[3];
        return nF;
    }*/
    //Methoden zum Überprüfen ob ein Zufall eingetreten ist, entsprechende Weiterleitung der Activities


    public boolean isZufall1 (){ // Zufall 1 = Armband Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZUSAMMENBAU_boolean = false;
        double wahrscheinlichkeit = 0;
        try {
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

        }//Ende try

        catch (Exception e) {
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
        AENDERE_ZUSAMMENBAU_boolean = false;
        double wahrscheinlichkeit = 0;
        try {
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
        }//Ende try

        catch (Exception e) {
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

    public boolean isZufall3 (){ // Zufall 3 = Zusammenbau Ändern
        double zufallszahl = Math.random();
        AENDERE_ARMBAND_boolean=false;
        AENDERE_GEHAEUSE_boolean =false;
        AENDERE_ZUSAMMENBAU_boolean = false;
        double wahrscheinlichkeit = 0;
        try {
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
    }//Ende try

    catch (Exception e) {
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


    //Methoden zum setzen der aktuellen UI-Activity (aufgerufen in onCreate)

    public void setActivity_Login () {
    setzeAlleZustaendeFalse();
        setzeAlleSchritteFalse();
        setZustand_Spielbeginn(true);
    }

    public void setActivity_E1 () {
        setZustand_Bestellung(true);
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


    public void setActivity_Berechnung () {
    setZustand_Lieferung(true);
        //Hier Preis und Marktsimulation durchführen!
        }


    public void setActivity_Rundenergebnis () {
        setZustand_Lieferung(true);
    }

    //TODO: setActivity_Bestenliste
    public void setActivity_Bestenliste() {

    }





    public boolean SCHRITT_DESIGNER_boolean = false;// erster Schritt Wahl des Designers
    public boolean SCHRITT_ARMBAND_boolean  = false;// zweite Schritt Wahl des Armbands
    public boolean SCHRITT_UHRWERK_boolean  = false;// dritter Schritt Wahl des Uhrwerks und der Uhrenart

    public String getSCHRITT_VERKAUFSPREIS() {
        return SCHRITT_VERKAUFSPREIS;
    }

    public boolean isAENDERE_ARMBAND_boolean() {
        return AENDERE_ARMBAND_boolean;
    }

    public void setAENDERE_ARMBAND_boolean(boolean AENDERE_ARMBAND_boolean) {
        this.AENDERE_ARMBAND_boolean = AENDERE_ARMBAND_boolean;
    }

    public boolean isAENDERE_GEHAEUSE_boolean() {
        return AENDERE_GEHAEUSE_boolean;
    }

    public void setAENDERE_GEHAEUSE_boolean(boolean AENDERE_GEHAEUSE_boolean) {
        this.AENDERE_GEHAEUSE_boolean = AENDERE_GEHAEUSE_boolean;
    }

    public boolean isAENDERE_ZUSAMMENBAU_boolean() {
        return AENDERE_ZUSAMMENBAU_boolean;
    }

    public void setAENDERE_ZUSAMMENBAU_boolean(boolean AENDERE_ZUSAMMENBAU_boolean) {
        this.AENDERE_ZUSAMMENBAU_boolean = AENDERE_ZUSAMMENBAU_boolean;
    }

    public Spieler getAktiverSpieler() {
        return aktiverSpieler;
    }

    public void setAktiverSpieler(Spieler aktiverSpieler) {
        this.aktiverSpieler = aktiverSpieler;
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

    public void setDaten(Daten daten) {
        this.daten = daten;
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

    public boolean isSCHRITT_ARMBAND_boolean() {
        return SCHRITT_ARMBAND_boolean;
    }

    public void setSCHRITT_ARMBAND_boolean(boolean SCHRITT_ARMBAND_boolean) {
        this.SCHRITT_ARMBAND_boolean = SCHRITT_ARMBAND_boolean;
    }

    public String getSCHRITT_DESIGNER() {
        return SCHRITT_DESIGNER;
    }

    public boolean isSCHRITT_DESIGNER_boolean() {
        return SCHRITT_DESIGNER_boolean;
    }

    public void setSCHRITT_DESIGNER_boolean(boolean SCHRITT_DESIGNER_boolean) {
        this.SCHRITT_DESIGNER_boolean = SCHRITT_DESIGNER_boolean;
    }

    public String getSCHRITT_DICHTHEIT() {
        return SCHRITT_DICHTHEIT;
    }

    public boolean isSCHRITT_DICHTHEIT_boolean() {
        return SCHRITT_DICHTHEIT_boolean;
    }

    public void setSCHRITT_DICHTHEIT_boolean(boolean SCHRITT_DICHTHEIT_boolean) {
        this.SCHRITT_DICHTHEIT_boolean = SCHRITT_DICHTHEIT_boolean;
    }

    public String getSCHRITT_GEHAUESE() {
        return SCHRITT_GEHAUESE;
    }

    public boolean isSCHRITT_GEHAUESE_boolean() {
        return SCHRITT_GEHAUESE_boolean;
    }

    public void setSCHRITT_GEHAUESE_boolean(boolean SCHRITT_GEHAUESE_boolean) {
        this.SCHRITT_GEHAUESE_boolean = SCHRITT_GEHAUESE_boolean;
    }

    public String getSCHRITT_KAUFVOLUMEN() {
        return SCHRITT_KAUFVOLUMEN;
    }

    public boolean isSCHRITT_KAUFVOLUMEN_boolean() {
        return SCHRITT_KAUFVOLUMEN_boolean;
    }

    public void setSCHRITT_KAUFVOLUMEN_boolean(boolean SCHRITT_KAUFVOLUMEN_boolean) {
        this.SCHRITT_KAUFVOLUMEN_boolean = SCHRITT_KAUFVOLUMEN_boolean;
    }

    public String getSCHRITT_UHRWERK() {
        return SCHRITT_UHRWERK;
    }

    public boolean isSCHRITT_UHRWERK_boolean() {
        return SCHRITT_UHRWERK_boolean;
    }

    public void setSCHRITT_UHRWERK_boolean(boolean SCHRITT_UHRWERK_boolean) {
        this.SCHRITT_UHRWERK_boolean = SCHRITT_UHRWERK_boolean;
    }

    public boolean isSCHRITT_VERKAUFSPREIS_boolean() {
        return SCHRITT_VERKAUFSPREIS_boolean;
    }

    public void setSCHRITT_VERKAUFSPREIS_boolean(boolean SCHRITT_VERKAUFSPREIS_boolean) {
        this.SCHRITT_VERKAUFSPREIS_boolean = SCHRITT_VERKAUFSPREIS_boolean;
    }

    public String getSCHRITT_VERSANDART() {
        return SCHRITT_VERSANDART;
    }

    public boolean isSCHRITT_VERSANDART_boolean() {
        return SCHRITT_VERSANDART_boolean;
    }

    public void setSCHRITT_VERSANDART_boolean(boolean SCHRITT_VERSANDART_boolean) {
        this.SCHRITT_VERSANDART_boolean = SCHRITT_VERSANDART_boolean;
    }

    public String getSCHRITT_WERBUNG() {
        return SCHRITT_WERBUNG;
    }

    public boolean isSCHRITT_WERBUNG_boolean() {
        return SCHRITT_WERBUNG_boolean;
    }

    public void setSCHRITT_WERBUNG_boolean(boolean SCHRITT_WERBUNG_boolean) {
        this.SCHRITT_WERBUNG_boolean = SCHRITT_WERBUNG_boolean;
    }

    public String getSCHRITT_ZUSAMMENBAU() {
        return SCHRITT_ZUSAMMENBAU;
    }

    public boolean isSCHRITT_ZUSAMMENBAU_boolean() {
        return SCHRITT_ZUSAMMENBAU_boolean;
    }

    public void setSCHRITT_ZUSAMMENBAU_boolean(boolean SCHRITT_ZUSAMMENBAU_boolean) {
        this.SCHRITT_ZUSAMMENBAU_boolean = SCHRITT_ZUSAMMENBAU_boolean;
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


    public Bestellposition[] getBestellpositionen(){
        Bestellposition[] bestellpositionen = new Bestellposition[daten.getSpielerAnzahl()];
        try {
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

        }//Ende Try
        catch (Exception e) {
            e.printStackTrace();
        }
        return bestellpositionen;
    }

} // ENDE KLASSE

