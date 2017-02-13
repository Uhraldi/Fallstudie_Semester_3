package com.example.patsc.fallstudie.Covered.Controller;

/**
 * Created by Patricia Schneider on 06.02.2017.
 */

public interface IUserInterface {
    // Methoden für Produktionsauswahl
    public void setArmbandAktuell(String armbandAuswahl);
    public void setForschungAktuell(String designerAuswahl);
    public void setArmbandNeu (String armbandAuswahl);
    public void setUhrwerkAktuell(String uhrwerkAuswahl);
    public void setGehaeuseAktuell(String gehaeuseAuswahl);
    public void setGehaeuseNeu (String gehaeuseAuswahl);
    public void setBezahlartAktuell(String bezahlartAuswahl);
    public void setZeitarbeiterAktuell(String zeitarbeiterAuswahl);
    public void setZeitarbeiterNeu(String zeitarbeiterAuswahl);
    public void setMarketingAktuell(String marketingAuswahl);
    public void setProduktionsvolumenAktuell(float produktionsvolumenAuswahl);
    public void setVerkaufspreisAktuell (float verkaufspreisAuswahl);

    //Methoden um SPiel zu starten
    public boolean registrierung(String name,String passwort);
    public boolean login (final String name,final String passwort);

    public int getPosition();

    // Methoden nach Ende einer RUnde
    public boolean gleichenWerteNochmal ();
    public boolean neuesSpiel();
    public boolean starteNaechsteRunde ();
    public String[][] getBestenliste();

    // Methoden bzgl Personalwesen
    public void keineVeraenderung();
    public  boolean kuendigen (int neueMitarbeiter);
    public boolean einstellen (int neueMitarbeiter);

    public int getEingestellteGesamt();

    // Setzen der Activies
    public void setActivity_Login ();
    public void setActivity_Rundenergebnis ();
    public void setActivity_Z3 ();
    public void setActivity_Z2 ();
    public void setActivity_Z1 ();
    public void setActivity_Bestellzusammenfassung ();
    public void setActivity_Verkaufspreis ();
    public void setActivity_Produktionsvolumen ();
    public void setActivity_Marketing ();
    public void setActivity_Zeitarbeiter ();
    public void setActivity_Bezahlart ();
    public void setActivity_Gehaeuse ();
    public void setActivity_Armband ();
    public void setActivity_Forschung ();
    public void setActivity_Uhrwerk ();
}
