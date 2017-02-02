package com.example.patsc.fallstudie.Covered.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 * testable
 */

public class Bezahlart {

    //Auswahlen
    private boolean Kreditkarte = false;
    private boolean Rechnung = false;
    private boolean PayPal = false;

    //Fixkosten
    private double FixkostenKreditkarte = 2000;
    private double FixkostenRechnung = 750;
    private double FixkostenPayPal = 1600;

    //PWSs
    private double KreditkartePWS = 0.4;
    private double RechnungPWS = 0.2;
    private double PayPalPWS = 0.05;

    //Time-to-Market (wird behandelt wie Zufall aber mit fixen werten
    private double KreditkarteZufall = 0.15;
    private double RechnungZufall = 0.05;

    private double PayPalZufall = 0.1;


    /**
     * Constructor
     */
    public Bezahlart(){

    }

    /**
     * Variablen-Getter
     */
    public boolean isKreditkarte() {
        return Kreditkarte;
    }

    public boolean isRechnung() {
        return Rechnung;
    }

    public boolean isPayPal() {
        return PayPal;
    }

    public double getFixkostenKreditkarte() {
        return FixkostenKreditkarte;
    }

    public double getFixkostenRechnung() {
        return FixkostenRechnung;
    }

    public double getFixkostenPayPal() {
        return FixkostenPayPal;
    }

    public double getKreditkartePWS() {
        return KreditkartePWS;
    }

    public double getRechnungPWS() {
        return RechnungPWS;
    }

    public double getPayPalPWS() {
        return PayPalPWS;
    }

    public double getKreditkarteZufall() {
        return KreditkarteZufall;
    }

    public double getRechnungZufall() {
        return RechnungZufall;
    }

    public double getPayPalZufall() {
        return PayPalZufall;
    }

    /**
     * Variablen-Setter
     */
    public void setKreditkarte(boolean Kreditkarte) {
        this.Kreditkarte = Kreditkarte;
    }

    public void setRechnung(boolean Rechnung) {
        this.Rechnung = Rechnung;
    }

    public void setPayPal(boolean PayPal) {
        this.PayPal = PayPal;
    }
}
