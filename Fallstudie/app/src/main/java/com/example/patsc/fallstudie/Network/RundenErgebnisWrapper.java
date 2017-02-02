


package com.example.patsc.fallstudie.Network;

/**
 * @author Vincent Schmalor
 * Created by vince on 18.01.2017.
 */

public class RundenErgebnisWrapper {

    private String id = null;
    private int runde = -1;
    private int menge = -1;
    private int personalanzahl = -1;
    private double respr = -1;
    private double vkp = -1;
    private double gesamtKosten = -1;
    private double bonus = -1;
    private double konto = -1;
    private double marktanteil = -1;
    private double rundengewinn = -1;
    private double maSchnitt = -1;


    //----------------------Construktor----------------------

    /**
     * Konstruktor zum Erstellen eines Wrappers, der versendet werden soll
     *
     * @param id           Name des Spielers
     * @param runde        aktuelle Rundennummer
     * @param menge        Menge der in dieser Runde hergestellten Uhren
     * @param respr        Reservationspreis
     * @param vkp          Vom Spieler festgelegter Verkaufspreis
     * @param bonus        Bonus durch z.B. Kreditkarten in Summe über alle Koeffizienten
     * @param gesamtKosten Summe der Fixkosten und variablen Kosten*Menge
     * @param konto        Kontostand des Spielers
     *                     //* @param marktanteil marktanteil wird von der Marktsim hinzugefügt, um die Sortierfähigkeit zu gewährleisten
     *                     //* @param rundengewinn Gewinn des Spielers in dieser Runde
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
        /**
         * Übergabe nicht im Konstruktor? - Nein, weil sie erst von der Marktsim gesetzt werden. Dieses Objekt muss aber sortiert werden und dafür diese beiden Variablen besitzen
         * this.marktanteil = marktanteil;
         * this.rundengewinn = rundengewinn;
         */
    }

    /**
     * Konstruktor eines Wrappers, der offensichtlich fehlerhaft ist
     */
    public RundenErgebnisWrapper() {
        id = "failed";
        runde = -1;
    }

    /**
     * ----------------------Getter und Setter----------------------
     */
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

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public int getPersonalanzahl() {
        return personalanzahl;
    }

    public void setPersonalanzahl(int personalanzahl) {
        this.personalanzahl = personalanzahl;
    }

    public double getRespr() {
        return respr;
    }

    public void setRespr(double respr) {
        this.respr = respr;
    }

    public double getVkp() {
        return vkp;
    }

    public void setVkp(double vkp) {
        this.vkp = vkp;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
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

    public void setGesamtKosten(double gesamtKosten) {
        this.gesamtKosten = gesamtKosten;
    }

    public double getMarktanteil() {
        return marktanteil;
    }

    public double getRundengewinn() {
        return rundengewinn;
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

    /**
     * ----------------------Ende Getter und Setter----------------------
     */
}
