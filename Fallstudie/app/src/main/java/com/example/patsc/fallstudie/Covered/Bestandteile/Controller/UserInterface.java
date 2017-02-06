package com.example.patsc.fallstudie.Covered.Bestandteile.Controller;

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
}
