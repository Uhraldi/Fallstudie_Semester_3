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

/**
 * Created by patsc on 13.12.2016.
*/

public class Controller extends UserInterface{
    /*
    Deklaration der einzelnen Namen der Schritte.
    Final damit sich der Name nicht verändert.
     */
    // Zugriff auf wichtige Elemente




    /**
     * Konstruktor, wird in der on Create Methode aufgerufen
     */
    public Controller(){
        setDaten(new Daten(this)); // erzeugung der Klasse Daten

    }
    public String toString(){
        String controllerString;
        controllerString = "";
        return controllerString;
    }
        public void setActivity_Berechnung (){
        try {
            setZustand_Lieferung(true);

            Preissimulation preissim = new Preissimulation(this); //ToDo
            getDaten().ASDsetPreisSim(preissim);

            //#Netzwerk Runde hochladen
            rundeHochladen(this);


            //#Netzwerk Gegner herunterladen
            RundenErgebnisWrapper[] gegnerliste = gegnerHerunterladen(this);
            Marktsim marktsim = new Marktsim( this, gegnerliste);
            getDaten().ASDserMarktSim(marktsim);

            //# Netzwerk Spieler Daten speichern
            spielerDatenSpeichern(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    // Methoden zum weitergeben der UI-Inputs
    /**
     * Aufruf in Activity
     * @param designerAuswahl
     */
    public void setForschungAktuell(String designerAuswahl){
        //Prüfung ob die Wahl des Designers erlaubt ist
        try {
            if (isSCHRITT_FORSCHUNG_boolean()) {
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
            getDaten().ASDgetAktuellerAuftrag().getForschung().setInvestition8000(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    } // Ende SetForschung
    public void setArmbandAktuell(String armbandAuswahl) {
        try {
            if (isSCHRITT_ARMBAND_boolean()) {
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
            getDaten().ASDgetAktuellerAuftrag().getArmband().setLeder(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }


    }// Ende SetArmband

    public void setArmbandNeu (String armbandAuswahl){              //nach Zufall Z3
        try {
            if (isAENDERE_ARMBAND_boolean()) {
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
    public void setUhrwerkAktuell(String uhrwerkAuswahl){
        try {
            if (isSCHRITT_UHRWERK_boolean()) {
                if (uhrwerkAuswahl.equals(UHRWERK_WAHL_ELEKTROMECHANISCH) || uhrwerkAuswahl.equals(UHRWERK_WAHL_ELEKTRONISCH) || uhrwerkAuswahl.equals(UHRWERK_WAHL_MECHANISCH)) {
                    getDaten().ASDgetAktuellerAuftrag().bestelleUhrwerk(uhrwerkAuswahl);
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
            getDaten().ASDgetAktuellerAuftrag().getUhrwerk().setElektronisch(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }

    }//Ende setUhrwek //

    public void setGehaeuseAktuell(String gehaeuseAuswahl){
        try {
            if (isSCHRITT_GEHAUESE_boolean()) {
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
        //Wahl wird standardmäßig auf Metall gesetzt
        catch (Exception e) {
            getDaten().ASDgetAktuellerAuftrag().getGehaeuse().setMetall(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    }// Ende setGehaeuseAktuell

    public void setGehaeuseNeu (String gehaeuseAuswahl){                //nach Zufall Z
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
    public void setBezahlartAktuell(String bezahlartAuswahl){
        try {
            // if (SCHRITT_BEZAHLART_boolean) {
            if (bezahlartAuswahl.equals(BEZAHLART_WAHL_KREDITKARTE) || bezahlartAuswahl.equals(BEZAHLART_WAHL_PAYPAL) || bezahlartAuswahl.equals(BEZAHLART_WAHL_RECHNUNG)) {
                getDaten().ASDgetAktuellerAuftrag().bestelleBezahlart(bezahlartAuswahl);
            }
            //letzte Auswahl die gesetzt werden kan
            else if (bezahlartAuswahl.equals(BEZAHLART_WAHL_PAYPAL)) {
                //  setzeAlleSchritteFalse();
            } else {
                throw new Exception("Syntax Fehler; Falsches Wort uebergeben");
            }
            // } else {
            //   throw new Exception("Falscher Bestellschritt");
            //}
        }
        //Wahl wird standardmäßig auf NUR Rechnung gesetzt
        catch (Exception e) {
            getDaten().ASDgetAktuellerAuftrag().getBezahlart().setRechnung(true);
            setzeAlleSchritteFalse();
            e.printStackTrace();
        }
    } //Ende set Bezahlart //


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
    } // Ende setZusammebau

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

    public boolean einstellen (int neueMitarbeiter) {
        return veraenderePersonal(neueMitarbeiter,aktiverSpieler,aktiverSpieler.getAuftragssammlung().aktuellerAuftragInt);
    }

    public  boolean kuendigen (int neueMitarbeiter){
        return veraenderePersonal(neueMitarbeiter*(-1),aktiverSpieler,aktiverSpieler.getAuftragssammlung().aktuellerAuftragInt);
    }
    public void keineVeraenderung(){
        kuendigen(0);
    }

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

    public boolean persoAenderungErlaubt(int anzahlMitarbeiter, Spieler spieler, int auftragsnummer){
        return (spieler.getAktuellEingestellte()+anzahlMitarbeiter)>0;
    }
    public int personalNeu(int anzahlMitarbeiter, Spieler spieler, int auftragsnummer){
        int personalGesamt = spieler.getAktuellEingestellte()+spieler.getVeraenderungPersonal();
        return personalGesamt;
    }

    //Methoden zum abholen der Bestellpositionen, zur Anzeige der Bestellzusammenfassung
    public String getForschungAktuellerAuftrag( ){
        return getForschungAuftragI(getDaten().getRundenAnzahl(),aktiverSpieler);
    }// Ende getForschungAktuellerAuftrag


    //Methoden zum abholen der Bestellpositionen, zur Anzeige der Bestellzusammenfassung
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


    public String getArmbandAktuellerAuftrag( ){
        return getArmbandAuftragI(getDaten().getRundenAnzahl(),aktiverSpieler);
    }// Ende get Armband

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

    public String getUhrwerkAktuellerAuftrag( ) {
        return getUhrwerkAuftragI(getDaten().getRundenAnzahl(), aktiverSpieler);
    }// Ende getUhrwerkAktuellerAuftrag

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


    public String getZeitarbeiterAktuellerAuftrag(){
        return getZeitarbeiterAuftragI(getDaten().getRundenAnzahl(), aktiverSpieler);
    } // Ende getZeitarbeiterAktuellerAuftrag


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

    public String getGehaeuseAktuellerAuftrag( ){
        return getGehaeuseAuftragI(getDaten().getRundenAnzahl(),aktiverSpieler);
    } // Ende getGehaeuseAktuellerAuftrag


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

    public String getBezahlartAktuellerAuftrag( ){
        return        getBezahlartAuftragI(getDaten().getRundenAnzahl(),aktiverSpieler);
    }//Ende getBezahlartAktuellerAuftrag


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

    //ToDo mehrfachauswahl
    public String getMarketingAktuellerAuftrag( ){
        return getMarketingAuftragI(getDaten().getRundenAnzahl(), aktiverSpieler);
    } // Ende get Marketing

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
        double guthabenkurz =  Math.round(guthaben * 100.0) / 100.0;

        return guthabenkurz;
    }



    //TODO: getGesamtkosten und getStueckkosten fuer Anzeige bei VerkaufspreisActivity
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

    public double getStueckkosten () {
        double stueckkosten = getGesamtkosten()/aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge();
        double stueckkostenkurz = Math.round(stueckkosten * 100.0) / 100.0;

        return stueckkostenkurz;
    }




    // Methoden für die Ereignisse
    //Methoden zum Überprüfen ob ein Zufall eingetreten ist, entsprechende Weiterleitung der Activities
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

    public void naechster_Schritt_Auswahl(){} // Setzen des nächsten AuswahlSchritts
    public void naechster_Zustand(){} // Setzen des nächsten Zustands
    /**
     * Aufruf wenn Nutzerdaten bestätigt werden (Button in UI)
     * UI Registierung
     * Parameter werden von UI übergeben
     * @param name
     * @param passwort
     */ public boolean registrierung(String name,String passwort){
        try {
            //#Netzwerk
            Runnable r = new RegisterRunnable(name, passwort, funkturm, this);
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
        Runnable r = new EmpfangeSpielerRunnable(name, passwort, funkturm, this);
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
                aktiverSpieler.setMarktanteil(spieler.getMaSchnitt());
                aktiverSpieler.getAuftragssammlung().aktuellerAuftrag.getPersonalwesen().setEingestellte(spieler.getPersonalAnzahl());
                if (aktiverSpieler.getGuthaben()==0){
                    aktiverSpieler = new Spieler(name,passwort,getDaten());
                }

                return true;
            } // Ende else
        } catch (Exception e) {
            return false;         } // Ende Methode

    }

    public int getPosition(){
        int pos=9898;
        RundenErgebnisWrapper[] spielerArray = sortSpieler(aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getData());
        for (int i = 0; i<spielerArray.length;i++) {
            if (aktiverSpieler.getName().equals(spielerArray[i].getId())) {
                pos = i + 1;
            } //Ende if
        }// Ende for
        return pos;
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
        return getDaten().getRundenAnzahl();
    }//Ende getRunde
    // Hilfsmethoden



    /**
     * Methode für die Marktsiumulation
     * @return gibt eine Liste der einzelnen Bestellpositionen fuer jeden Speieler zurueck
     */
    public Auftrag[] getAuftrage()throws Exception{
        Auftrag[] auftraege = new Auftrag[getDaten().getSpielerAnzahl()];
        try {
            if (getDaten().getSpielerListe() == null) {
                throw new Exception("Spieler Liste leer");
            }

            for (int i = 0; i < getDaten().getSpielerAnzahl(); i++) {
                if (getDaten().getSpielerListe().get(i).getAuftragssammlung().getAktuellerAuftrag() != null)
                    auftraege[i] = getDaten().getSpielerListe().get(i).getAuftragssammlung().getAktuellerAuftrag();
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
        double[] Preise = new double[getDaten().getSpielerAnzahl()];
        try {
            if (getDaten().getSpielerListe() == null) {
                throw new Exception("Spieler Liste leer");
            }
            for (int i = 0; i < getDaten().getSpielerAnzahl(); i++) {
                if (getDaten().getSpielerListe().get(i).getAuftragssammlung().getAktuellerAuftrag() != null){


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

    public RundenErgebnisWrapper[] sortSpieler(RundenErgebnisWrapper[] spielers){
        RundenErgebnisWrapper temp;
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

    public boolean gleichenWerteNochmal (){

        aktiverSpieler.getAuftragssammlung().neuerAuftragGleicheWerte();
        getDaten().erhoeheRundenanzahl();
        veraenderePersonal(aktiverSpieler.getVeraenderungPersonal() ,aktiverSpieler,aktiverSpieler.getAuftragssammlung().aktuellerAuftragInt);
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

    public boolean starteNaechsteRunde (){
        aktiverSpieler.getAuftragssammlung().neuerAuftrag();
        getDaten().erhoeheRundenanzahl();
        return true;
    }

    public void setRegistrierungBool(boolean registrierungBool){
        this.registrierungBool = registrierungBool;
    }

    public void setUpdateBool(boolean updateBool) {
        this.updateBool = updateBool;
    }

    public void setEmpfangeSpielerSDW(SpielerDatenWrapper empfangeSpielerSDW) {
        this.empfangeSpielerSDW = empfangeSpielerSDW;
    }

    public void setSendeRundeBool(boolean SendeRundeBool) {
        this.sendeRundeBool = sendeRundeBool;
    }

    public void setRundenErgebnisREW(RundenErgebnisWrapper[] rundenErgebnisREW) {
        this.rundenErgebnisREW = rundenErgebnisREW;
    }


} // ENDE KLASSE