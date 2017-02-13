package com.example.patsc.fallstudie.Covered.Controller;

/**
 * Created by Patricia Schneider on 06.02.2017.
 */

public interface IController {
    protected void fuehereBechnungAus();
    public boolean veraenderePersonal (int anzahlMitarbeiter, Spieler spieler, int auftragsnummer);
    public boolean persoAenderungErlaubt(int anzahlMitarbeiter, Spieler spieler, int auftragsnummer);
    public int personalNeu(int anzahlMitarbeiter, Spieler spieler, int auftragsnummer);

    public String getForschungAktuellerAuftrag( );
    public String getForschungAuftragI(int i, Spieler spieler );
    public String getArmbandAktuellerAuftrag( );
    public String getArmbandAuftragI(int i ,Spieler spieler);
    public String getUhrwerkAktuellerAuftrag( );
    public String getUhrwerkAuftragI(int i, Spieler spieler);
    public String getZeitarbeiterAktuellerAuftrag();
    public String getZeitarbeiterAuftragI(int i, Spieler spieler);
    public String getGehaeuseAktuellerAuftrag( );
    public String getGehaeuseAuftragI ( int i, Spieler spieler);

    public String getBezahlartAktuellerAuftrag( );
    public String getBezahlartAuftragI (int i, Spieler spieler);
    public String getMarketingAktuellerAuftrag( );
    public String getMarketingAuftragI (int i, Spieler spieler);

    public boolean isZufall1 ();
    public boolean isZufall2 ();
    public boolean isZufall3 ();

    public boolean registrierung(String name,String passwort);
    public boolean login (final String name,final String passwort);

    public boolean gleichenWerteNochmal ();
    public boolean neuesSpiel();
    public boolean starteNaechsteRunde ();

}

