package com.example.patsc.fallstudie.Network;

/**
 * Created by vince on 18.01.2017.
 */

public class Data {

    private String id = null;
    private int runde = -1;
    private int menge = -1;
    private double respr = -1;
    private double vkp = -1;
    private double bonus = -1;
    private double konto = -1;
    private double ma = -1;

    /**
     * ----------------------Construktor----------------------
     * @param id Name des Spielers
     * @param runde aktuelle Rundennummer
     * @param menge Menge der in dieser Runde hergestellten Uhren
     * @param respr Reservationspreis
     * @param vkp Vom Spieler festgelegter Verkaufspreis
     * @param bonus Bonus durch z.B. Kreditkarten in Summe über alle Koeffizienten
     *
     */
    public  Data(String id, int runde, int menge, double respr, double vkp, double bonus, double konto){
        this.id = id;
        this.runde = runde;
        this.menge = menge;
        this.respr = respr;
        this.vkp = vkp;
        this.bonus = bonus;
        this.konto = konto;
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

    /**
     * ----------------------Ende Getter und Setter----------------------
     */
}
