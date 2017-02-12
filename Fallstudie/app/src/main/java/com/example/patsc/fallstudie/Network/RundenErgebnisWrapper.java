


package com.example.patsc.fallstudie.Network;

/**
 * @author Vincent Schmalor
 * Created by vince on 18.01.2017.
 */

public class RundenErgebnisWrapper {

    private String id = null;
    private int runde = -1;
    private int menge = -1;
    private int personalanzahl = 2;
    private double respr = -1;
    private double vkp = -1;
    private double gesamtKosten = -1;
    private double bonus = -1;
    private double konto = -1;
    private double marktanteil = 0.1;
    private double rundengewinn = -1;
    private double maSchnitt = 0.1;


    //----------------------Construktor----------------------

    /**
     * Konstruktor zum Erstellen eines Wrappers, der versendet werden soll
     * @param id           Name des Spielers
     * @param runde        aktuelle Rundennummer
     * @param menge        Menge der in dieser Runde hergestellten Uhren
     * @param respr        Reservationspreis
     * @param vkp          Vom Spieler festgelegter Verkaufspreis
     * @param bonus        Bonus durch z.B. Kreditkarten in Summe über alle Koeffizienten
     * @param gesamtKosten Summe der Fixkosten und variablen Kosten*Menge
     * @param konto        Kontostand des Spielers
     * //@param marktanteil marktanteil wird von der Marktsim hinzugefügt, um die Sortierfähigkeit zu gewährleisten
     * //@param rundengewinn Gewinn des Spielers in dieser Runde
     */
    public RundenErgebnisWrapper(String id, int runde, int menge, int personalanzahl, double respr, double vkp, double gesamtKosten, double bonus, double konto, double maSchnitt) {
        this.id = id;
        this.runde = runde;
        this.menge = menge;
        this.respr = respr;
        this.vkp = vkp;
        this.gesamtKosten = gesamtKosten;
        this.bonus = bonus;
        this.konto = konto;
        this.maSchnitt = maSchnitt;
        this.personalanzahl = personalanzahl;
    }

    /**
     * Konstruktor eines Wrappers, der offensichtlich fehlerhaft ist
     */
    public RundenErgebnisWrapper() {
        id = "failed";
        runde = -1;
    }

    /**Getter and Setter*/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRunde() {
        return runde;
    }

    public void setRunde(int runde) {
        this.runde = runde;
    }

    public int getMenge() {
        return menge;
    }

    public int getPersonalanzahl() {
        return personalanzahl;
    }

    public double getRespr() {
        return respr;
    }

    public double getVkp() {
        return vkp;
    }

    public double getBonus() {
        return bonus;
    }

    public double getKonto() {
        return konto;
    }

    public void setKonto(double konto) {
        this.konto = konto;
    }

    public double getGesamtKosten() {
        return gesamtKosten;
    }

    public double getMarktanteil() {
        return marktanteil;
    }

    public void setRundengewinn(double rundengewinn) {
        this.rundengewinn = rundengewinn;
    }

    public void setMarktanteil(double marktanteil) {
        this.marktanteil = marktanteil;
    }

    public double getMaSchnitt() {
        return maSchnitt;
    }

    public void setMaSchnitt(double maSchnitt) {
        this.maSchnitt = maSchnitt;
    }
    /**End of Getter and Setter*/
}
