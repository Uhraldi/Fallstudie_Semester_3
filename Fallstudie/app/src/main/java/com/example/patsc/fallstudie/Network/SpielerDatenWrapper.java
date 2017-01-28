package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Spieler;

/**
 * Created by vince on 28.01.2017.
 */

public class SpielerDatenWrapper {

    String name;
    String passwort;
    int runde;
    double konto;
    double kontoSchnitt;
    double maSchnitt;

    /**
     * Äquivalent zu RundenErgebnisWrapper mit den Daten, die für den Spieler nötig sind.
     * @param name des Spielers
     * @param passwort des Spielers
     * @param runde Nummer der aktuellen Runde
     * @param konto -Stand des Spielers
     * @param kontoSchnitt Durchschnitt der bisherigen Kontostände, um am Ende einen Schnitt ausgeben zu können.
     * @param maSchnitt Durchschnitt der bisherigen Marktanteile, um am Ende einen Schnitt ausgeben zu können.
     */
    public SpielerDatenWrapper(String name, String passwort, int runde, double konto, double maSchnitt, double kontoSchnitt){
        this.name = name;
        this.passwort = passwort;
        this.runde = runde;
        this.konto = konto;
        this.kontoSchnitt = kontoSchnitt;
        this.maSchnitt = maSchnitt;
    }

}
