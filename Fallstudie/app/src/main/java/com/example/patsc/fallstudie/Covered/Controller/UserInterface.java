package com.example.patsc.fallstudie.Covered.Controller;

import com.example.patsc.fallstudie.Network.Funkturm;
import com.example.patsc.fallstudie.Network.RundenErgebnisWrapper;

/**
 * Created by patsc on 06.02.2017.
 */

public abstract class UserInterface extends CNetzwerk implements IUserInterface {

    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Uhrwerk () {
        setZustand_Bestellung(true);
        setSCHRITT_UHRWERK_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Forschung () {
        setZustand_Bestellung(true);
        setSCHRITT_FORSCHUNG_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Personalwesen () {
        setZustand_Bestellung(true);
        setSCHRITT_FORSCHUNG_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Armband () {
        setZustand_Bestellung(true);
        setSCHRITT_ARMBAND_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Gehaeuse () {
        setZustand_Bestellung(true);
        setSCHRITT_GEHAUESE_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Bezahlart () {
        setZustand_Bestellung(true);
        setSCHRITT_BEZAHLART_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Zeitarbeiter () {
        setZustand_Bestellung(true);
        setSCHRITT_ZEITARBEITER_boolean(true);

    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Marketing () {
        setZustand_Bestellung(true);
        setSCHRITT_MARKETING_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Produktionsvolumen () {
        setZustand_Bestellung(true);
        setSCHRITT_PRODUKTIONSVOLUMEN_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Verkaufspreis () {
        setZustand_Bestellung(true);
        setSCHRITT_VERKAUFSPREIS_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Bestellzusammenfassung () {
        setzeAlleZustaendeFalse();
        setZustand_Bestellung(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Z1 () {
        setZustand_Ereignis(true);
        setAENDERE_ARMBAND_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Z2 () {
        setZustand_Ereignis(true);
        setAENDERE_GEHAEUSE_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Z3 () {
        setZustand_Ereignis(true);
        setAENDERE_ZEITARBEITER_boolean(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Rundenergebnis () {
        setZustand_Lieferung(true);
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Login () {
        setzeAlleZustaendeFalse();
        setzeAlleSchritteFalse();
        setZustand_Spielbeginn(true);
        //#Netzwerk
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Funkturm funkturm = new Funkturm();
                funkturm.registriereSpieler("", "");
                //  funkturm.unidleServer();
            }});
        t.start();
    }
    /**
     * RÜckgabe  Bestenliste sortiert nach Spieler
     *              Spieler 1   Spieler 2   Spieler 3   Spieler 4   Spieler 5
     * Position
     * Name
     * Guthaben
     * Marktanteil
     *
     * @return String[Spieler][Eigenschaft]
     */
    public String[][] getBestenliste(){
        String [][] bestenliste = new String[5][4];
        RundenErgebnisWrapper[] ergebnisWrappers = getDaten().getController().sortSpieler(aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getRundenErgebnisWrapper());
        for (int i = 0; i<5;i++){
            bestenliste[i][0] = Integer.toString(i+1); //ergebnisWrappers ist bereits sortiert, daher ist der erste Spieler der gespeichert wird an Position 1
            bestenliste[i][1] = ergebnisWrappers[i].getId();
            int konto = (int) ergebnisWrappers[i].getKonto()*100;
            double dkonto = konto/100; // abschneiden des Guthabens auf zwei Nachkommastellen
            bestenliste[i][2] = Double.toString(dkonto);
            double marktanteil  = ergebnisWrappers[i].getMaSchnitt();
            marktanteil = marktanteil*100; // in Prozent umwandeln
            marktanteil = Math.round(marktanteil); // abschneiden des Marktanteils auf zwei Nachkommastellen
            bestenliste[i][3] = Double.toString(marktanteil);
        }
        return bestenliste;
    }

    /**
     * Rückgabe der Anzahl der insgesamt eingestellten SPieler
     * Methode wird für das UI verwendet, da dem Spieler die Anzahl der aktuellen Mitarbeiter bereits angezeigt bevor diese gesetzt ist.
     * @return Anzahl der SPieler ink Veränderung
     */
    public int getEingestellteGesamt(){
        return aktiverSpieler.getVeraenderungPersonal()+aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPersonalwesen().getEingestellte();
    }
    /**
     * Setzen der Activity
     * Aufruf in der OnCreate Methode der Activity
     * Sicherstellund das der richtige Zustand verwendet wird
     */
    public void setActivity_Berechnung (){
        setZustand_Lieferung(true);
        getDaten().getController().fuehreBerechnungAus();
    }



    /**
     * Aufruf durch UI
     * Wenn keine Veränderung bzgl. der Mitarbeiter geschehen soll
     */
    public void keineVeraenderung(){
        kuendigen(0);
    }

}
