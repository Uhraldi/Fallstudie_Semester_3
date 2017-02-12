package com.example.patsc.fallstudie.Covered.Bestandteile;

/**
 * @author Patricia Schneider
 * Created by patsc on 14.01.2017.
 */
public class Personalwesen {

    //Auswahlen
    private int eingestellte = 2; // Personal am Anfang initial auf 2 gesetzt initial wird es mit der veraenderung gesetzt
    private int veraenderung = 0; // Veranderung für das Personal in der nächsten runde
    private double fixkosten ;

    //EKPs
    private double personalKostenProMitarbeiter = 27600;

    /**Konstruktor*/
    public Personalwesen(){

    }


    /**Methoden*/

    public String toString(){
        return eingestellte + ":" + veraenderung + ":" + fixkosten;
    }

    /**Getter*/
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
    /**End of Getter*/

    /**Setter*/
    public void setVeraenderung(int veraenderung) {
        this.veraenderung = veraenderung;
    }
    /**End of Setter*/
}
