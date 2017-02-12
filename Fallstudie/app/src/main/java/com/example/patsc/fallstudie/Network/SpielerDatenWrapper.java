package com.example.patsc.fallstudie.Network;

/**
 * @author Vincent Schmalor
 * Created by vince on 28.01.2017.
 */

public class SpielerDatenWrapper {

    private String id;
    private String passwort;
    private int runde = -1;
    private double konto;
    private double kontoSchnitt;
    private double maSchnitt;
    private int personalAnzahl;
    private int personalVeraenderung;

    /**
     * Äquivalent zu RundenErgebnisWrapper nur mit den Daten, die für den Spieler nötig sind.
     * @param id Name des Spielers
     * @param passwort Passwort des Spielers
     * @param runde Nummer der aktuellen Runde
     * @param konto Kontostand des Spielers
     * @param kontoSchnitt Durchschnitt der bisherigen Kontostände, um am Ende einen Schnitt ausgeben zu können.
     * @param maSchnitt Durchschnitt der bisherigen Marktanteile, um am Ende einen Schnitt ausgeben zu können.
     * @param personalAnzahl Anzahl des eingestellten Personals
     * @param personalVeraenderung Anzahl der Personalveränderung
     */
    public SpielerDatenWrapper(String id, String passwort, int runde, double konto, double maSchnitt, double kontoSchnitt, int personalAnzahl, int personalVeraenderung){
        this.id = id;
        this.passwort = passwort;
        this.runde = runde;
        this.konto = konto;
        this.kontoSchnitt = kontoSchnitt;
        this.maSchnitt = maSchnitt;
        this.personalAnzahl = personalAnzahl;
        this.personalVeraenderung = personalVeraenderung;
    }

    /**
     * Konstruktor, um ein Objekt zu erzeugen, das zur Identifikation dient. Zum Beispiel beim Anfragen der Spielerdaten
     * @param id Name des Spielers
     * @param passwort Passwort des Spielers
     */
    public SpielerDatenWrapper(String id, String passwort){
        this.id = id;
        this.passwort = passwort;
    }


    /**Getter and Setter*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public int getRunde() {
        return runde;
    }

    public void setRunde(int runde) {
        this.runde = runde;
    }

    public double getKonto() {
        return konto;
    }

    public double getMaSchnitt() {
        return maSchnitt;
    }

    public int getPersonalAnzahl() {
        return personalAnzahl;
    }

    public int getPersonalVeraenderung() {
        return personalVeraenderung;
    }
    /**End of Getter and Setter*/
}
