package com.example.patsc.fallstudie.Covered.Controller;

import com.example.patsc.fallstudie.Covered.Auftrag;
import com.example.patsc.fallstudie.Covered.Auftragssammlung;
import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Marktsim;
import com.example.patsc.fallstudie.Covered.Preissimulation;
import com.example.patsc.fallstudie.Covered.Spieler;
import com.example.patsc.fallstudie.Network.EmpfangeSpielerRunnable;
import com.example.patsc.fallstudie.Network.Funkturm;
import com.example.patsc.fallstudie.Network.RegisterRunnable;
import com.example.patsc.fallstudie.Network.RundenErgebnisWrapper;
import com.example.patsc.fallstudie.Network.SpielerDatenWrapper;

import static com.example.patsc.fallstudie.Covered.Controller.IZustaende.ARMBAND_WAHL_HOLZ;
import static com.example.patsc.fallstudie.Covered.Controller.IZustaende.FORSCHUNG_WAHL_HOCH;
import static com.example.patsc.fallstudie.Covered.Controller.IZustaende.FORSCHUNG_WAHL_LOWBUDGET;
import static com.example.patsc.fallstudie.Covered.Controller.IZustaende.MARKETING_WAHL_FERNSEHWERBUNG;
import static com.example.patsc.fallstudie.Covered.Controller.IZustaende.MARKETING_WAHL_RADIOWERBUNG;
import com.example.patsc.fallstudie.Covered.Controller.SuperController;
import com.example.patsc.fallstudie.Covered.*;
import com.example.patsc.fallstudie.Covered.Controller.IZustaende;

/**
 * Created by Patricia Schneider on 13.12.2016.
 * Steuert das Zusammenspiel von Netzwerk UI und Logik.
*/

public class Controller extends UserInterface implements IController {
    /**
     * Konstruktor, wird in der on Create Methode aufgerufen
     */
    public Controller(){
        setDaten(new Daten(this)); // erzeugung der Klasse Daten
    }

    /**
     * Methode wird bei dem LadeScreen augerufen. Führt alle Berechnungen aus, damit eine Produktionsreihe bewertet und verkauft werden kann.
     * Hierfür finden mehrere Netzwerkaufrufre statt, die Preissimulation und Marktsimulation.
     * Der errechnete Spielstand wird anschließend auf den Server geladen.
     */
    public void fuehreBerechnungAus(){
        try {
            Preissimulation preissim = new Preissimulation(this); //ToDo
            getDaten().ASDsetPreisSim(preissim); // Zuordnen der Preissim zu einem Spieler
            rundeHochladen(this); //Netzwerk Runde hochladen
            RundenErgebnisWrapper[] gegnerliste = gegnerHerunterladen(this); //Netzwerk Gegner herunterladen
            Marktsim marktsim = new Marktsim( this, gegnerliste);
            getDaten().ASDserMarktSim(marktsim);
            spielerDatenSpeichern(this); //Netzwerk Spieler Daten speichern
        }catch (Exception e){
            e.printStackTrace(); // Abfangen des Fehlers nur für Spiel an Konsole; wenn kein Stand zurück gegeben wird, wird für den Spieler ein Toast erzeugt.
        }
    }// Ende fuehre BerechnungAus


    // Methoden zum weitergeben der UI-Inputs

    /**
     * Aufruf durch Activity / UI
     * Setzen der Auswahl des Armbands im aktuellen Auftrag
     * @param armbandAuswahl String welche Auswahl getroffen wurde
     */
    public void setArmbandAktuell(String armbandAuswahl) {
        try {
            //Prüfung ob der richtige Schritt genutzt wird
            if (isSCHRITT_ARMBAND_boolean()) {
                //Prüfung ob ein valider String verwendet wird
                if (armbandAuswahl.equals(ARMBAND_WAHL_HOLZ) || armbandAuswahl.equals(ARMBAND_WAHL_KUNSTLEDER) || armbandAuswahl.equals(ARMBAND_WAHL_LEDER) || armbandAuswahl.equals(ARMBAND_WAHL_METALL) || armbandAuswahl.equals(ARMBAND_WAHL_TEXTIL)) {
                    getDaten().ASDgetAktuellerAuftrag().bestelleArmband(armbandAuswahl);
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
            getDaten().ASDgetAktuellerAuftrag().getArmband().setLeder(true); // Setzen eines Standardwertes, falls ein Fehler aufgetreten ist
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }// Ende SetArmband

    /**
     * Aufruf in Activity
     * Setzen der aktuellen Forschungsauswahl
     * @param designerAuswahl
     */
    public void setForschungAktuell(String designerAuswahl){
        //Prüfung ob die Wahl des Designers erlaubt ist
        try {
            if (super.isSCHRITT_FORSCHUNG_boolean()) {
                if (designerAuswahl.equals(FORSCHUNG_WAHL_LOWBUDGET) || designerAuswahl.equals(FORSCHUNG_WAHL_HOCH) || designerAuswahl.equals(FORSCHUNG_WAHL_MITTELMAESIG)) {
                    getDaten().ASDgetAktuellerAuftrag().bestelleForschung(designerAuswahl); //ToDo Nullpointer Exception
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
            getDaten().ASDgetAktuellerAuftrag().getForschung().setInvestition8000(true);  // Falls ein Fehler auftritt wird ein Standardwert gesetzt
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    } // Ende SetForschung

    /**
     * Wenn der dritte Zufall eintritt, muss eine neue Wahl für das Armband getroffen werden.
     * @param armbandAuswahl
     */
    public void setArmbandNeu (String armbandAuswahl){              //nach Zufall Z3
        try {
            if (isAENDERE_ARMBAND_boolean()) { // Prüfung ob das Armband geändert werden soll
                if (armbandAuswahl.equals(ARMBAND_WAHL_HOLZ) || armbandAuswahl.equals(ARMBAND_WAHL_KUNSTLEDER) || armbandAuswahl.equals(ARMBAND_WAHL_LEDER) || armbandAuswahl.equals(ARMBAND_WAHL_METALL) || armbandAuswahl.equals(ARMBAND_WAHL_TEXTIL))
                // Prüfung ob das Material schon einmal gewaehlt wurde in Activity
                {
                    getDaten().ASDgetAktuellerAuftrag().bestelleArmband(armbandAuswahl);
                    setAENDERE_ARMBAND_boolean(false);
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standarmäßig auf Leder gesetzt, außer vorherige Auswahl war Leder, dann Kunstleder
        catch (Exception e){
            if (getArmbandAktuellerAuftrag().equals(ARMBAND_WAHL_LEDER)) {
                getDaten().ASDgetAktuellerAuftrag().getArmband().setKunstleder(true);
                setAENDERE_ARMBAND_boolean(false);
            } else {
                getDaten().ASDgetAktuellerAuftrag().getArmband().setLeder(true);
                setAENDERE_ARMBAND_boolean(false);
            }
            e.printStackTrace();
        }

    }// Ende setArmbandNeu

    /**
     * Wenn der Zufall eintritt, dass das geählte Uhrwerk nicht geliefert / produziert werden kann.
     * Muss eine neue AUswahl getroffen werden. Dieses wird über diese Methode realisiert.
     * @param uhrwerkAuswahl String welches Uhrwerk die neue Auwahl ist
     */
    public void setUhrwerkAktuell(String uhrwerkAuswahl){
        try {
            if (isSCHRITT_UHRWERK_boolean()) { // Prüfung ob an dieser Stelle ein neues Uhrwerk geählt werden darf
                // Prüfun ob ein valider String übergeben wurde
                if (uhrwerkAuswahl.equals(UHRWERK_WAHL_ELEKTROMECHANISCH) || uhrwerkAuswahl.equals(UHRWERK_WAHL_ELEKTRONISCH) || uhrwerkAuswahl.equals(UHRWERK_WAHL_MECHANISCH)) {
                    getDaten().ASDgetAktuellerAuftrag().bestelleUhrwerk(uhrwerkAuswahl); // Setzen des neuen Uhrwerks
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
            getDaten().ASDgetAktuellerAuftrag().getUhrwerk().setElektronisch(true); // Wenn ein Fehler aufgetreten ist, wird der Standard Wert gesetzt
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }//Ende setUhrwek

    /**
     * Aufruf durch UI
     * Setzen der Auswahl für das Gehäuse
     * @param gehaeuseAuswahl ausgewählte Gehäuse
     */
    public void setGehaeuseAktuell(String gehaeuseAuswahl){
        try {
            if (isSCHRITT_GEHAUESE_boolean()) { // Prüfung ob das sezten des Gehäuses an dieser Stelle legal ist
                // Prüfung ob ein gültiger String übergeben wurde
                if (gehaeuseAuswahl.equals(GEHAEUSE_WAHL_GLAS) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_HOLZ) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_KUNSTSTOFF) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_METALL)) {
                    getDaten().ASDgetAktuellerAuftrag().bestelleGehaeuse(gehaeuseAuswahl);
                    setzeAlleSchritteFalse();
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        catch (Exception e) {
            getDaten().ASDgetAktuellerAuftrag().getGehaeuse().setMetall(true); //Wahl wird standardmäßig auf Metall gesetzt, wenn ein Fehler aufgetreten ist
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }// Ende setGehaeuseAktuell

    /**
     * Aufruf wenn das Ereignis Gehäuse eingetreten ist.
     * @param gehaeuseAuswahl  neue Auswahl des Gehäuses
     */
    public void setGehaeuseNeu (String gehaeuseAuswahl){
        try {
            if (isAENDERE_GEHAEUSE_boolean()) {
                if (gehaeuseAuswahl.equals(GEHAEUSE_WAHL_GLAS) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_HOLZ) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_KUNSTSTOFF) || gehaeuseAuswahl.equals(GEHAEUSE_WAHL_METALL)) {
                    getDaten().ASDgetAktuellerAuftrag().korrigiereGehaeuse(gehaeuseAuswahl);
                    setAENDERE_GEHAEUSE_boolean(false);
                } else {
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            } else {
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmäßig auf Holz gesetzt, außer vorherige Auswahl war Holz, dann
        catch (Exception e) {
            if (getGehaeuseAktuellerAuftrag().equals(GEHAEUSE_WAHL_HOLZ)) {
                getDaten().ASDgetAktuellerAuftrag().getGehaeuse().setGlas(true);
                setAENDERE_GEHAEUSE_boolean(false);
            } else {
                getDaten().ASDgetAktuellerAuftrag().getGehaeuse().setHolz(true);
                setAENDERE_GEHAEUSE_boolean(false);
            }
            e.printStackTrace();
        }
    } // Ende setGehaeuseNeu

    /**
     * Setzt die von Spieler gesetzte Auswahl für die Bezahlarten
     * Es ist möglich mehrere Bezahlarten auszwählen
     * Aufruf durch UI/Activity
     * @param bezahlartAuswahl
     */
    public void setBezahlartAktuell(String bezahlartAuswahl){
        try {

            if (bezahlartAuswahl.equals(BEZAHLART_WAHL_KREDITKARTE) || bezahlartAuswahl.equals(BEZAHLART_WAHL_PAYPAL) || bezahlartAuswahl.equals(BEZAHLART_WAHL_RECHNUNG)) {
                getDaten().ASDgetAktuellerAuftrag().bestelleBezahlart(bezahlartAuswahl);
            }
             else {
                throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
            }
        }
        //Wahl wird standardmäßig auf NUR Rechnung gesetzt
        catch (Exception e) {
            getDaten().ASDgetAktuellerAuftrag().getBezahlart().setRechnung(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    } //Ende set Bezahlart

    /**
     * Aufruf durch UI /Activty
     * setzen des von Spieler gewählten Wertes für den Zeitarbeiter
     * @param zeitarbeiterAuswahl Wahl des Spielers
     */
    public void setZeitarbeiterAktuell(String zeitarbeiterAuswahl){
        try{
            if (isSCHRITT_ZEITARBEITER_boolean()){
                if(zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_PRAKTIKANT)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_GESELLE)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_Lehrling)|| zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_MEISTER))
                { getDaten().ASDgetAktuellerAuftrag().bestelleZeitarbeiter(zeitarbeiterAuswahl);
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
            getDaten().ASDgetAktuellerAuftrag().getZusammenbau().setLehrling(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    } // Ende

    /**
     * Wenn das dritte Ereignis eintritt, muss ein neuer Zeitarbeiter gewählt werden.
     * @param zeitarbeiterAuswahl neue Auswahl des Zeitarbeiters
     */
    public void setZeitarbeiterNeu(String zeitarbeiterAuswahl){              //nach Zufall Z3
        try{
            if (isAENDERE_ZEITARBEITER_boolean()){
                if(zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_PRAKTIKANT)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_GESELLE)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_Lehrling)||zeitarbeiterAuswahl.equals(ZEITARBEITER_WAHL_MEISTER))
                {getDaten().ASDgetAktuellerAuftrag().korriegiereZeitarbeiter(zeitarbeiterAuswahl);
                    setAENDERE_ZEITARBEITER_boolean(false);
                }
                else{
                    throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
                }
            }
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }
        //Wahl wird standardmäßig auf Geselle gesetzt, außer vorherige Wahl war Geselle, dann Lehrling
        catch (Exception e){
            if (getZeitarbeiterAktuellerAuftrag().equals(ZEITARBEITER_WAHL_GESELLE)) {
                getDaten().ASDgetAktuellerAuftrag().getZusammenbau().setLehrling(true);
                setAENDERE_ZEITARBEITER_boolean(false);
            } else {
                getDaten().ASDgetAktuellerAuftrag().getZusammenbau().setGeselle(true);
                setAENDERE_ZEITARBEITER_boolean(false);
            }
            e.printStackTrace();
        }
    }// Ende setZeitarbeiterNeu


    /**
     * Aufruf durch UI / Activty
     * Setzen des Wertes für das MArketing
     * @param marketingAuswahl
     */
    public void setMarketingAktuell(String marketingAuswahl){
        try{
            if (isSCHRITT_MARKETING_boolean()){
                if(marketingAuswahl.equals(MARKETING_WAHL_PRINTWERBUNG)||marketingAuswahl.equals(MARKETING_WAHL_FERNSEHWERBUNG)||marketingAuswahl.equals(MARKETING_WAHL_RADIOWERBUNG))
                { getDaten().ASDgetAktuellerAuftrag().bestelleWerbung(marketingAuswahl);
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
            getDaten().ASDgetAktuellerAuftrag().getMarketing().setRadiowerbung(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }//Ende set Marketing

    /**
     * Setzen des Wertes für das Produktionsvolumen
     * Wert wird bereits im UI geprüft
     *
     * @param produktionsvolumenAuswahl Anzahl der zu prodzuierenden Uhren
     */
    public void setProduktionsvolumenAktuell(float produktionsvolumenAuswahl){
        try{
            if (isSCHRITT_PRODUKTIONSVOLUMEN_boolean()){
                int produktionsVolumen = ((int) produktionsvolumenAuswahl);
               getDaten().ASDgetAktuellerAuftrag().bestelleMenge(produktionsVolumen);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }
        catch (Exception e){
            setzeAlleSchritteFalse();
            setSCHRITT_PRODUKTIONSVOLUMEN_boolean(true);
            int produktionsVolumen = ((int) produktionsvolumenAuswahl);
            getDaten().ASDgetAktuellerAuftrag().bestelleMenge(produktionsVolumen);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }//Ende setProduktionsvolumenAktuell

    /**
     * Setzen des vom Spieler geplanten Verkaufspreises
     * Auswahl wird bereits im UI geprüft
     * @param verkaufspreisAuswahl Preis für den der Spieler die Uhr (pro Stück) verkaufen möchte
     *                             Übergabe durch Eingabefeld
     */
    public void setVerkaufspreisAktuell (float verkaufspreisAuswahl){
        try{
            if (isSCHRITT_VERKAUFSPREIS_boolean()){
                double verkaufspreis = ((double)verkaufspreisAuswahl);
                getDaten().ASDgetAktuellerAuftrag().bestelleVKP(verkaufspreis);
                setzeAlleSchritteFalse();}
            else{
                throw new Exception("Falscher Bestellschritt");
            }
        }
        catch (Exception e){
            setzeAlleSchritteFalse();
            setSCHRITT_VERKAUFSPREIS_boolean(true);
            double verkaufspreis = ((double)verkaufspreisAuswahl);
            getDaten().ASDgetAktuellerAuftrag().bestelleVKP(verkaufspreis);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }// Ende Verkaufspreis //


    /**
     * Passt das aktuell beschäftigte Personal für die nächste Runde an
     * @param anzahlMitarbeiter Veränderung des Personals
     * @param spieler Spieler bei dem das Personal geändert werden soll
     * @param auftragsnummer Auftrag, bei dem die Auswahl getroffen wurde ( Achtung gültig erst für nächsten Auftrag)
     * @return true wenn die Personaländerung möglich ist (Spielerzahl nach Veränderung >1
     *          false wenn die Personalveränderung nicht erlaubt ist
     */
    public boolean veraenderePersonal (int anzahlMitarbeiter, Spieler spieler, int auftragsnummer){
        //spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getPersonalwesen().setEingestellte(spieler.getAuftragssammlung().getAuftrag(auftragsnummer).getPersonalwesen().getEingestellte()+spieler.getVeraenderungPersonal());
        if (persoAenderungErlaubt(anzahlMitarbeiter,spieler,auftragsnummer)==false) {
            return false;
        }
        else {
            spieler.getAuftragssammlung().getAktuellerAuftrag().bestellePersonalwesen(personalNeu(anzahlMitarbeiter, spieler, auftragsnummer));
            spieler.setAktuellEingestellte(spieler.getAuftragssammlung().getAktuellerAuftrag().getPersonalwesen().getEingestellte());
            spieler.setVeraenderungPersonal(anzahlMitarbeiter);

            return true;
        }
    }

    /**
     * Prüfun ob die Personalveränderung erlaubt ist
     * @param anzahlMitarbeiter Veränderung des Personals
     * @param spieler Spieler bei dem das Personal geändert werden soll
     * @param auftragsnummer Auftrag, bei dem die Auswahl getroffen wurde ( Achtung gültig erst für nächsten Auftrag)
     * @return true wenn die Personalveränderung zulässig ist
     *          false wenn die Personalveränderung nicht zulässig ist
     */
    public boolean persoAenderungErlaubt(int anzahlMitarbeiter, Spieler spieler, int auftragsnummer){
        return ((spieler.getAktuellEingestellte() + spieler.getVeraenderungPersonal()) + anzahlMitarbeiter) > 0;
    }

    /**
     * Berechnung der Anzahl der neuen Mitarbeiter
     * @param anzahlMitarbeiter Veränderung der Mitarbeiter, bereits in Vorrunde gesetzt
     * @param spieler Spieler bei dem die Veränderung durchgeführt werden soll
     * @param auftragsnummer Auftrag in dem die Veränderung statt finden soll
     * @return
     */
    public int personalNeu(int anzahlMitarbeiter, Spieler spieler, int auftragsnummer){
        int personalGesamt = spieler.getAktuellEingestellte()+spieler.getVeraenderungPersonal();
        return personalGesamt;
    }

    /**
     * Gibt die getroffene Auswahl im Bereich Forschung für den aktuellen Spieler und die aktuelle RUnde zurück
      * @return String aktuelle Forschung
     */
    public String getForschungAktuellerAuftrag( ){
        return getForschungAuftragI(getDaten().getRundenAnzahl(),aktiverSpieler);
    }// Ende getForschungAktuellerAuftrag

    /**
     * Gibt die getroffene AUswahl im Bereich FOrschung für einen beliebigen Spieler und Auftrag zurück.
     * @param i Auftragsnummer für die die Abfrage läuft
     * @param spieler Spieler für den die Abfrage läuft
     * @return
     */
    public String getForschungAuftragI(int i, Spieler spieler ){
        String forschung = "";
        try {
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getForschung().isInvestition2500()) {
                forschung = FORSCHUNG_WAHL_LOWBUDGET;
            } else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getForschung().isInvestition15000()) {
                forschung = FORSCHUNG_WAHL_HOCH;
            }
            else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getForschung().isInvestition8000()) {
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

    /**
     * Gibt die Auswahl für das Material des Armbands des aktuellen SPielers und Auftrag zurück
     * @return String aktuelle Auswahl
     */
    public String getArmbandAktuellerAuftrag( ){
        return getArmbandAuftragI(getDaten().getRundenAnzahl(),aktiverSpieler);
    }// Ende get Armband

    /**
     * Gibt die Auswahl des Armbandmaterials für einen belibigen Spieler und Auftrag zurück
     * @param i Auftragsnummer
     * @param spieler spieler
     * @return String getroffene Auswahl
     */
    public String getArmbandAuftragI(int i ,Spieler spieler){
        String armband ="";
        try {
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().isHolz()) {
                armband = ARMBAND_WAHL_HOLZ;
            } else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().isKunstleder()) {
                armband = ARMBAND_WAHL_KUNSTLEDER;
            } else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().isLeder()) {
                armband = ARMBAND_WAHL_LEDER;
            } else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().isMetall()) {
                armband = ARMBAND_WAHL_METALL;
            } else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getArmband().isTextil()) {
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

    /**
     * Gibt die Auswahl des Uhrwerks von dem aktuellen Spieler und AUftrag zurück
     * @return String getroffene Auswahl
     */
    public String getUhrwerkAktuellerAuftrag( ) {
        return getUhrwerkAuftragI(getDaten().getRundenAnzahl(), aktiverSpieler);
    }// Ende getUhrwerkAktuellerAuftrag

    /**
     * Gibt das von einem belibigen SPieler in einer belibigen Runde verwendete Uhrwerk zurück
     * @param i Auftragsnummer
     * @param spieler spieler
     * @return String aktuelles Uhrwerk
     */
    public String getUhrwerkAuftragI(int i, Spieler spieler){
        String uhrwerk = "";
        try {
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getUhrwerk().isElektromechanisch()) {
                uhrwerk = UHRWERK_WAHL_ELEKTROMECHANISCH;
            } else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getUhrwerk().isElektronisch()) {
                uhrwerk = UHRWERK_WAHL_ELEKTRONISCH;
            } else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getUhrwerk().isMechanisch()) {
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

    /**
     * Gibt den vom aktuellen Spieler gewählten Zeitarbeiter zurück
     * @return String aktuelle AUswahl Zeitarbeiter
     */
    public String getZeitarbeiterAktuellerAuftrag(){
        return getZeitarbeiterAuftragI(getDaten().getRundenAnzahl(), aktiverSpieler);
    } // Ende getZeitarbeiterAktuellerAuftrag

    /**
     * Gibt die von einem Spieler in RUnde i gewählten Zeitarbeiter zurück
     * @param i RUndennummer für die abgefragt wird
     * @param spieler SPieler
     * @return String mit der Auswahl
     */
    public String getZeitarbeiterAuftragI(int i, Spieler spieler){
        String zeitarbeiter = "";
        try{
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().isPraktikant()){
                zeitarbeiter = ZEITARBEITER_WAHL_PRAKTIKANT;
            }
            else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().isGeselle()){
                zeitarbeiter = ZEITARBEITER_WAHL_GESELLE;
            }
            else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().isLehrling()){
                zeitarbeiter = ZEITARBEITER_WAHL_Lehrling;
            }
            else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getZusammenbau().isMeister()){
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

    /**
     * GIbt das aktuell gewählte Gehäuse zurück
     * @return String Gehäuse wahl aktiver Spieler aktuelle Runde
     */
    public String getGehaeuseAktuellerAuftrag( ){
        return getGehaeuseAuftragI(getDaten().getRundenAnzahl(),aktiverSpieler);
    } // Ende getGehaeuseAktuellerAuftrag

    /**
     * Gibt die Wahl des Gehäuses für einen SPieler in RUnde i zurück
     * @param i Rundenummer
     * @param spieler Spieler der gewählt hat
     * @return String mit der AUswahl
     */
    public String getGehaeuseAuftragI ( int i, Spieler spieler){
        String gehaeuse ="";
        try{
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().isMetall()){
                gehaeuse = GEHAEUSE_WAHL_METALL;
            }
            else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().isHolz()){
                gehaeuse = GEHAEUSE_WAHL_HOLZ;
            }
            else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().isGlas()){
                gehaeuse =GEHAEUSE_WAHL_GLAS;
            }
            else if (spieler.getAuftragssammlung().getAktuellerAuftrag().getGehaeuse().isKunststoff()) {
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

    /**
     * Gibt die vom aktivenSpieler in der aktuellen RUdne gewählte Auswahl für die Bezahlart zurück
     * @return String getroffene AUswahl Bezahlart
     */
    public String getBezahlartAktuellerAuftrag( ){
        return        getBezahlartAuftragI(getDaten().getRundenAnzahl(),aktiverSpieler);
    }//Ende getBezahlartAktuellerAuftrag

    /**
     * Gibt einen String der alle gewählten Bezahlarten enthält zurück.
     * Die verschiedenen Parameter sind hierbei mit "," getrennt
     * @param i Auftragsnummer von dem der String erzeugt wird
     * @param spieler Spieler der die AUswahl getroffen hat
     * @return String mit allen Bezahlarten
     */
    public String getBezahlartAuftragI (int i, Spieler spieler){
        String bezahlart ="";
        try{
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getBezahlart().isKreditkarte()){

                bezahlart = "Visa";
            }
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getBezahlart().isPayPal()){
                if (!bezahlart.equals("")){
                    bezahlart = bezahlart + ", " + BEZAHLART_WAHL_PAYPAL;
                }
                else bezahlart = BEZAHLART_WAHL_PAYPAL;
            }
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getBezahlart().isRechnung()){
                if (!bezahlart.equals("")){
                    bezahlart = bezahlart + ", " + BEZAHLART_WAHL_RECHNUNG;
                }
                else  bezahlart = BEZAHLART_WAHL_RECHNUNG;
            }
            else{
                throw new Exception("Keine Auswahl der Bezahlart getroffen.");
            }
        }
        catch (Exception e){

        }
        return bezahlart;
    }

    /**
     * Gibt das gewählte Marketing für den aktivenSpieler im aktuellen Auftrag zurück
     * @return String gewählte Marketing
     */
    public String getMarketingAktuellerAuftrag( ){
        return getMarketingAuftragI(getDaten().getRundenAnzahl(), aktiverSpieler);
    } // Ende get Marketing

    /**
     * Gibt das vom Spieler "spieler" gewählte Marketing in Runde i zurück
     * Wenn mehrere Auswahlen getroffen sind, werden diese mit Hilfe von "," getrennt
     * @param i Rundennummer
     * @param spieler Spieler
     * @return String mit allen getroffenen AUswahlen der RUnde i des SPielers spieler
     */
    public String getMarketingAuftragI (int i, Spieler spieler){
        String marketing ="";
        try {
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getMarketing().isRadiowerbung()) {
                marketing = "Radio";
            }
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getMarketing().isFernsehwerbung()) {
                if (!marketing.equals("")) {
                    marketing = marketing + ", " + "TV";
                }
                else marketing = MARKETING_WAHL_FERNSEHWERBUNG;
            }
            if (spieler.getAuftragssammlung().getAktuellerAuftrag().getMarketing().isPrintwerbung()) {
                if (!marketing.equals("")) {
                    marketing = marketing + ", " + "Print";
                }
                else marketing = MARKETING_WAHL_RADIOWERBUNG;
            } else {
                throw new Exception("Keine Auswahl bei dem Zusamenbau getroffen.");
            }
        }
        catch (Exception e){

        }
        return marketing;
    }

    /**
     * Gibt das gewählte Produktionsvolumen des aktiven Spielers im aktuellenAuftrag zurück
     * @return float Produktionsvolumen  (float da vom UI so benötigt)
     */
    public float getProduktionsvolumen( ){ //#Nils Refactored von getKaufvolumen zu getProduktionsvolumen
        float kv = (float)aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge();
        return kv;
    } // Ende getProduktionsvolumen

    /**
     * Gibt dem von aktivenSPieler im aktuellenAuftrag gewählten VKP zurück
     * @return vkp (float da vom UI benötigt)
     */
    public float getVerkaufspreis ( ){
        float vkp = (float)aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getVkp();
        return vkp;
    }// Ende getVerkaugspreis

    // Methoden zum Aufrufen der Bonären Werte

    /**
     * Gibt die Fixkosten für den aktuellenAuftrag des aktivenSPielers zurück
     * @return FixKosten der aktuellen RUnde
     */
    public float getFixKosten() {
        Spieler s = aktiverSpieler;
        Auftragssammlung as = s.getAuftragssammlung();
        Auftrag a = as.getAktuellerAuftrag();
        double fixKosten = a.getFixKosten();
            return (float) fixKosten;
    }
    /**
     * Gibt die Varkosten für den aktuellenAuftrag des aktivenSPielers zurück
     * @return VarKosten der aktuellen RUnde
     */
    public float getVarKosten(){
        Spieler s = aktiverSpieler;
        Auftragssammlung as = s.getAuftragssammlung();
        Auftrag a = as.getAktuellerAuftrag();
        double varKosten = a.getVarKosten();
        //ToDo(float) aktiverSpieler.getAuftragssammlung().getAuftrag(0).getVarKosten();
        return (float) varKosten;
    }
    /**
     * Gibt das Guthaben des aktivenSPielers zurück
     * @return Guthaben des aktivenSpielers
     */
    public double getGuthaben(){
        double guthaben = (double) aktiverSpieler.getGuthaben();
        double guthabenkurz =  Math.round(guthaben * 100.0) / 100.0;

        return guthabenkurz;
    }
    /**
     * Gibt die Gesamtkosten für den aktuellenAuftrag des aktivenSPielers zurück
     * Gesamtkosten = fixkosten + varKosten*MEnge;
     * @return Gesamtkosten der aktuellen RUnde
     */
    public double getGesamtkosten () {
        Spieler s = aktiverSpieler;
        Auftragssammlung as = s.getAuftragssammlung();
        Auftrag a = as.getAktuellerAuftrag();
        double fix= a.getFixKosten();
        double var = a.getVarKosten();
        int menge = a.getMenge();
        double gesamt = fix+var*menge;

        return gesamt;
    }
    /**
     * Gibt die Stückkosten für den aktuellenAuftrag des aktivenSPielers zurück
     * Stückkosten = Gesamtkosten / Menge;
     * @return Stückkosten der aktuellen RUnde des aktivenSPielers
     */
    public double getStueckkosten () {
        double stueckkosten = getGesamtkosten()/aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge();
        double stueckkostenkurz = Math.round(stueckkosten * 100.0) / 100.0;

        return stueckkostenkurz;
    }




    // Methoden für die Ereignisse

    /**
     * Methoden zum Überprüfen ob ein Zufall eingetreten ist, entsprechende Weiterleitung der Activities
     * @return true wenn der Zufall 1 eingetreten ist
     *          false wenn der Zufall 1 nicht eingetreten ist
     */
    public boolean isZufall1 (){ // Zufall 1 = Armband Ändern
        double zufallszahl = Math.random();
        setzeZustaendeAendere(false);
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
            setAENDERE_ARMBAND_boolean(true);
            return true;
        }
        else{
            return false;
        }
    }// Ende isZufall1

    /**
     * Methoden zum Überprüfen ob ein Zufall eingetreten ist, entsprechende Weiterleitung der Activities
     * @return true wenn der Zufall 2 eingetreten ist
     *          false wenn der Zufall 2 nicht eingetreten ist
     */
    public boolean isZufall2 (){ // Zufall 2 = Gehäuse Ändern
        double zufallszahl = Math.random();
        setzeZustaendeAendere(false);
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
            setAENDERE_GEHAEUSE_boolean(true);
            return true;
        }
        else{
            return false;
        }
    }// Ende isZufall2
    /**
     * Methoden zum Überprüfen ob ein Zufall eingetreten ist, entsprechende Weiterleitung der Activities
     * @return true wenn der Zufall 3 eingetreten ist
     *          false wenn der Zufall 3 nicht eingetreten ist
     */
    public boolean isZufall3 (){ // Zufall 3 = Zeitarbeiter Ändern
        double zufallszahl = Math.random();
        setzeZustaendeAendere(false);
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
            setAENDERE_ZEITARBEITER_boolean(true);
            return true;
        }
        else{
            return false;
        }
    }// Ende isZufall3
    //Andere Abfragen

    /**
     * Aufruf wenn Nutzerdaten bestätigt werden (Button in UI)
     * UI Registierung
     * Parameter werden von UI übergeben
     * @param name
     * @param passwort
     */ public boolean registrierung(String name,String passwort){
        try {
            //#Netzwerk
            Runnable r = new RegisterRunnable(name, passwort, this);
            Thread t = new Thread(r);
            t.start();
            while(t.isAlive()){

            }
            if (registrierungBool) {
                aktiverSpieler = new Spieler(name, passwort, getDaten());
                getDaten().addSpielerListe(aktiverSpieler);
                return true;
            }
            else{
                return false;
            }

        } // Ende try
        catch (Exception e){
            e.printStackTrace();
            return false;
        } // Ende catch
        } // Ende registrierung()
    /**
     * Aufrug wenn Login bestätigt wird (Button in UI)
     * UI Login
     * Parameter werden von UI übergeben
     * @param name
     * @param passwort
     */
    public boolean login (final String name,final String passwort) {
        //#Netzwerk
        final SpielerDatenWrapper ergebnis;
        Funkturm f = new Funkturm();
        Runnable r = new EmpfangeSpielerRunnable(name, passwort, this);
        Thread t = new Thread(r);
        t.start();
        while(t.isAlive()){

        }
        SpielerDatenWrapper spieler = empfangeSpielerSDW;
        try {
            if (spieler.getId().equals("failed")) {
                return false;
            } else {

                aktiverSpieler = new Spieler(name, passwort, getDaten());
                getDaten().setRundenAnzahl(spieler.getRunde());
                aktiverSpieler.setGuthaben(spieler.getKonto());
                aktiverSpieler.setMaSchnitt(spieler.getMaSchnitt());
                aktiverSpieler.getAuftragssammlung().aktuellerAuftrag.getPersonalwesen().setEingestellte(spieler.getPersonalAnzahl());
                aktiverSpieler.setAktuellEingestellte(spieler.getPersonalAnzahl());
                aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPersonalwesen().setVeraenderung(spieler.getPersonalVeraenderung());
                aktiverSpieler.setVeraenderungPersonal(spieler.getPersonalVeraenderung());
                if (aktiverSpieler.getGuthaben()==0){
                    aktiverSpieler = new Spieler(name,passwort,getDaten());
                }

                return true;
            } // Ende else
        } catch (Exception e) {
            return false;         } // Ende Methode

    }

    /**
     * Gibt die POsition auf der sich der Spieler im Vergleich zu den neun Konkurenten befindet zurück
     * 1 -> beste Platz
     * 10 -> schlechteste Platz
     * @return Position des aktiven Spielers in der Rangliste
     */
    public int getPosition(){
        int pos=9898;
        RundenErgebnisWrapper[] spielerArray = sortSpieler(aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getRundenErgebnisWrapper());
        for (int i = 0; i<spielerArray.length;i++) {
            if (aktiverSpieler.getName().equals(spielerArray[i].getId())) {
                pos = i + 1;
            } //Ende if
        }// Ende for
        return pos;
    }

    /**
     * Gibt den Marktanteil für den SPieler zurück
     * @return Marktanteil des aktivenSPielers
     */
    public float getMarktanteil(){
        float marktAnteil = (float) aktiverSpieler.getMarktanteil();
        return marktAnteil;
    }// Ende getMarktanteil

    /**
     * GIbt die aktuelle Rundennummer zurück
     * @return Rundennummer
     */
    public int getRunde(){
        return getDaten().getRundenAnzahl();
    }//Ende getRunde

    /**
     * Sortiert die Liste der 10 Spieler nach ihrer Position in der Rangliste
     * die Position ist dabei von gewinn und Marktanteil abhängig
     * @param spielers alle 10 Spieler
     * @return sortierte Liste mit allen 10 Spielern;  an Pos [0] steht hierbei der beste Spieler an Position [9] derschlechteste
     */
    public RundenErgebnisWrapper[] sortSpieler(RundenErgebnisWrapper[] spielers){
        RundenErgebnisWrapper temp;
        for(int i=1; i<spielers.length; i++) {
            for(int j=0; j<spielers.length-i; j++) {
                if((spielers[j].getKonto() * spielers[j].getMaSchnitt()) < (spielers[j+1].getKonto() * spielers[j+1].getMaSchnitt())) {
                    temp=spielers[j];
                    spielers[j]=spielers[j+1];
                    spielers[j+1]=temp;
                }

            }
        }
        return spielers;
    }

   /**
     * Spielt das Spiel mit den gleichen Werten nocheinmal
     * Wenn die Personalveränderung nicht nocheinmal so durchgeführt werden kann (zB beim kündigen Eingestellte <0),
     * wird diese einfach auf 0 gesetzt.
     * @return Ob das ausführen der Methode erflogreich war
     */
    public boolean gleichenWerteNochmal (){
        aktiverSpieler.getAuftragssammlung().neuerAuftragGleicheWerte();
        getDaten().erhoeheRundenanzahl();
        veraenderePersonal(aktiverSpieler.getVeraenderungPersonal() ,aktiverSpieler,aktiverSpieler.getAuftragssammlung().aktuellerAuftragInt);
        super.setGesamtkosten(getGesamtkosten());
        if (persoAenderungErlaubt(aktiverSpieler.getVeraenderungPersonal(), aktiverSpieler, getDaten().getRundenAnzahl())) {
            return true;
        }
        else{
            aktiverSpieler.setVeraenderungPersonal(0);
            return true;}
    }

    /**
     * Erstellt ein neues Spiel für den Spieler, der bisher gespielt hat.
     * Alle Werte werden auf die Initial Werte zurückgesetzt.
     * Der neue "Spielstand" wird dem Server mitgeteilt.
     * @return  true wenn das erzeugen eines neuen Spiels erfolgreich war
     *          false wenn das erzeugen eines neuen Spiels fehlgeschlagen ist
     */
    public boolean neuesSpiel(){
        Spieler s = aktiverSpieler; // Zwischenspeichern, damit Namens und Passwort Abfrage weiterhin möglich ist
        setDaten(new Daten(this)); // neue Daten, damit keine Probleme mit alten Werten auftreten können
        try {
            aktiverSpieler = new Spieler (s.getName(),s.getPasswort(),getDaten()); // Anfangswerte für den aktivenSpieler bei selben Namen und PW wie bisher
            spielerDatenSpeichern (this); // Speichern des Spielers damit die Anwendung konsistent zu dem Server ist
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Keine weitere Fehlerbehandlung, da ein Toast an den Nutzer ausgegeben wird
            return false;
        }
    }

    /**
     * Der Spieler gelangt in die nächste Runde -> neuer Auftrag
     * Prüfung ob nicht bereits RUnde 11 bereits vorher geschehen
     * @return boolean ob alles geklappt hat
     */
    public boolean starteNaechsteRunde (){
        aktiverSpieler.getAuftragssammlung().neuerAuftrag();
        getDaten().erhoeheRundenanzahl();
        return true;
    }
} // ENDE KLASSE