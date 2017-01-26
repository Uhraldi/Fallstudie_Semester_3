package com.example.patsc.fallstudie.Covered.Bestandteile;

/**
 * Created by patsc on 14.01.2017.
 */
public class Personalwesen {



    //Auswahlen
        private int eingestellte = 2; // Personal am Anfang initial auf 2 gesetzt
        private int veraenderung = 0; // Veranderung für das Personal in der nächsten runde
        private double fixkosten; //// TODO: 24.01.2017 #Vincent werte anpassen

    //EKPs
        private double personalKostenProMitarbeiter = 3000; //ToDo richtiger Wert

    private int anzahlDerMöglichenUhrenProMitarbeiter = 5000;//ToDo richtiger Wert

    /**
     * Constructor
     */
    public Personalwesen(){

    }

    public String toString(){
        return eingestellte + ":" + veraenderung + ":" + fixkosten;
    }
    public int getAnzahlDerMöglichenUhrenProMitarbeiter() {
        return anzahlDerMöglichenUhrenProMitarbeiter;
    }

    public void setAnzahlDerMöglichenUhrenProMitarbeiter(int anzahlDerMöglichenUhrenProMitarbeiter) {
        this.anzahlDerMöglichenUhrenProMitarbeiter = anzahlDerMöglichenUhrenProMitarbeiter;
    }

    public int getEingestellte() {
        return eingestellte;
    }

    public void setEingestellte(int eingestellte) {
        this.eingestellte = eingestellte;
    }

    public int getVeraenderung() {
        return veraenderung;
    }

    public double getPersonalKostenProMitarbeiter() {
        return personalKostenProMitarbeiter;
    }

    public void setPersonalKostenProMitarbeiter(double personalKostenProMitarbeiter) {
        this.personalKostenProMitarbeiter = personalKostenProMitarbeiter;
    }

    public void setVeraenderung(int veraenderung) {
        this.veraenderung = veraenderung;
    }

    public void setFixkosten(double fixkosten) {
        this.fixkosten = fixkosten;
    }
}
