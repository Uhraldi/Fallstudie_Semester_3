package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Spieler;

/**
 * Created by vince on 28.01.2017.
 */

public class SpielerDatenWrapper {

    String id;
    String passwort;
    int runde = -1;
    double konto;
    double kontoSchnitt;
    double maSchnitt;

    /**
     * Äquivalent zu RundenErgebnisWrapper mit den Daten, die für den Spieler nötig sind.
     * @param id Name des Spielers
     * @param passwort Passwort des Spielers
     * @param runde Nummer der aktuellen Runde
     * @param konto Kontostand des Spielers
     * @param kontoSchnitt Durchschnitt der bisherigen Kontostände, um am Ende einen Schnitt ausgeben zu können.
     * @param maSchnitt Durchschnitt der bisherigen Marktanteile, um am Ende einen Schnitt ausgeben zu können.
     */
    public SpielerDatenWrapper(String id, String passwort, int runde, double konto, double maSchnitt, double kontoSchnitt){
        this.id = id;
        this.passwort = passwort;
        this.runde = runde;
        this.konto = konto;
        this.kontoSchnitt = kontoSchnitt;
        this.maSchnitt = maSchnitt;
    }

    /**
     * Konstruktor, um ein Objekt zu erzeugen, das dur Identifikation dient. Zum Beispiel beim Anfragen der Spielerdaten
     * @param id Name des Spielers
     * @param passwort Passwort des Spielers
     */
    public SpielerDatenWrapper(String id, String passwort){
        this.id = id;
        this.passwort = passwort;
    }
}
