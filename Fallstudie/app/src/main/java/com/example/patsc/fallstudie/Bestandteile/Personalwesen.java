package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by patsc on 14.01.2017.
 */
public class Personalwesen {



    //Auswahlen
        private int eingestellte = 5; // Personal am Anfang initial auf 5 gesetzt
        private int veraenderung = 0; // Veranderung für das Personal in der nächsten runde

    //EKPs
        private double personalKostenProMitarbeiter = 3000; //ToDo richtiger Wert

    private int anzahlDerMöglichenUhrenProMitarbeiter = 5000;//ToDo richtiger Wert

    /**
     * Constructor
     */
    public Personalwesen(){

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

    public double getPersonalKostenProMitarbeiter() {
        return personalKostenProMitarbeiter;
    }

    public void setPersonalKostenProMitarbeiter(double personalKostenProMitarbeiter) {
        this.personalKostenProMitarbeiter = personalKostenProMitarbeiter;
    }
}