package com.example.patsc.fallstudie.Covered.Controller;

import com.example.patsc.fallstudie.Network.RundenErgebnisWrapper;

/**
 * Created by patsc on 06.02.2017.
 */

public class UserInterface extends CNetzwerk implements IUserInterface {

    public void setActivity_Uhrwerk () {
        setZustand_Bestellung(true);
        setSCHRITT_UHRWERK_boolean(true);
    }
    public void setActivity_Personalwesen () {     }


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
    public void setActivity_Rundenergebnis () {
        setZustand_Lieferung(true);

    }
    public void setActivity_Bestenliste() {
        //TODO: setActivity_Bestenliste
    }

    public void setActivity_Login () {
        setzeAlleZustaendeFalse();
        setzeAlleSchritteFalse();
        setZustand_Spielbeginn(true);
        //#Netzwerk
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                funkturm.registriereSpieler("", "");
                //  funkturm.unidleServer();
            }});
        t.start();
    }

    /**
     * Bestenliste sortiert nach Spieler
     *              Spieler 1   Spieler 2   Spieler 3   Spieler 4   Spieler 5
     * Position
     * Name
     * Guthaben
     * Marktanteil
     *
     * @return String[Spieler][Eigenschaft]
     */
    public String[][] getBestenliste(RundenErgebnisWrapper[] spielers){

        String [][] bestenliste = new String[4][4];
        RundenErgebnisWrapper[] ergebnisWrappers = getDaten().getController().sortSpieler(spielers);
        for (int i = 0; i<5;i++){
            bestenliste[i][0] = Integer.toString(i+1); //ergebnisWrappers ist bereits sortiert, daher ist der erste Spieler der gespeichert wird an Position 1
            bestenliste[i][1] = ergebnisWrappers[i].getId();
            int konto = (int) ergebnisWrappers[i].getKonto()*100;
            double dkonto = konto/100; // abschneiden des Guthabens auf zwei Nachkommastellen
            bestenliste[i][2] = Double.toString(dkonto);
            int marktanteil  = (int) ergebnisWrappers[i].getMarktanteil()*100;
            double dmarktanteil = marktanteil/100; // abschneiden des Marktanteils auf zwei Nachkommastellen
            bestenliste[i][3] = Double.toString(dmarktanteil);
        }
        return bestenliste;
    }

}
