package com.example.patsc.fallstudie.Covered;

import com.example.patsc.fallstudie.Covered.Daten.Daten;

/**
 * Created by Patricia Schneider on 30.12.2016.
 *
 * Wird bei der Eingabe der Spieler für jeden Spieler erzeugt.
 * Eine Liste aller Spieler liegt in //ToDo
 *
 */
public class Spieler {

    private String Name; //Name des Spielers
    private String Passwort; //Passwort des Spielers, nur wenn dieses korrekt ist, darf der Spieler eine Aktion durchführen; Datenspeicherung so unsicher
    private double Guthaben; //Aktuelle Anzahl der Geldeinheiten die ein Spieler hat
    private double Marktanteil; //Marktanteil den der Spieler aktuell hat
    private int Punkte; // Anzahl der Punkt die der SPieler aktuell hat
    private int Anfangsguthaben = 150000; // Guthaben das jeder SPieler am Anfang hat.
    private int AnfangsMarktanteil = 0; // Marktanteil in Prozent vor der ersten RUnde
    private int AnfagsPunkte = 1000; // Punkt des Spielers vor der ersten Runde
    private final Daten daten;
    private Auftragssammlung auftragssammlung; // ToDo Methoden, Konstruktor
    public Auftragssammlung getAuftragssammlung(){return auftragssammlung;}
    private int veraenderungPersonal = 0;
    private double kontoSchnitt;
    private double maSchnitt = 0.2;
    private int aktuellEingestellte = 2; // Initial auf 2

    public void setAktuellEingestellte(int aktuellEingestellte) {
        this.aktuellEingestellte = aktuellEingestellte;
    }

    public int getAktuellEingestellte() {
        return aktuellEingestellte;
    }


    /**
     * Konstruktor für den Spieler.
     *
     * @param name     Parameter wird von der Activty übergeben; Pflichtfeld
     * @param passwort Parameter wird von der Activty übergeben; Pflichtfeld
     *                 Zu Beginn hat jeder ein Guthaben von 10.000€ und einen Marktanteil von 0%.
     *                 Am Beginn hat jeder Spieler 1000 Punkte.
     */

    public Spieler(String name, String passwort, Daten daten)throws Exception {
        this.daten=daten;
        setName(name);
        setGuthaben(Anfangsguthaben);
        setPasswort(passwort);
        auftragssammlung = new Auftragssammlung();
        setMarktanteil(AnfangsMarktanteil);
        setPunkte(AnfagsPunkte);
    } // Ende Konstruktor



    /**
     * Das Guthaben darf nicht unter 0€ fallen. Wenn dieses geschieht, ist das Spiel verloren.
     * Der Spieler kann nach der Runde nicht mehr weiter spielen.
     *
     * @param guthaben
     */
    public void setGuthaben(double guthaben) {
        Guthaben = guthaben;
    }

    /**
     * Der Marktanteil muss zwischen 1-100% liegen.
     *
     * @param marktanteil
     */
    public void setMarktanteil(double marktanteil)throws Exception {
            if (marktanteil < 100 && marktanteil > 0) {
                Marktanteil = marktanteil;
            } else if (marktanteil > 100) {
                throw new Exception("Marktanteil über 100%");
            } else if (marktanteil < 0) {
                throw new Exception("Marktanteil unter 0%");
            }

    } // Ende setMarktanteil

    public void setName(String name) {
        Name = name;
    } // Ende setName()





    /**
     * Setzt das Passwort
     *
     * @param passwort
     */
    public void setPasswort(String passwort) {
        Passwort = passwort;
    }// Ende SetPasswort

    /**
     * Nachdem die Punkte berechnet sind, werden diese dem Spieler mitegeteilt.
     * Die Berechnung der Punkte erfolgt am Ende der Runde ToDo
     *
     * @param punkte
     */
    public void setPunkte(int punkte) throws Exception {
            if (punkte < 0) {
                Punkte = 0;
                throw new Exception("Punkte kleiner als 0, automatisch auf 0 gesetzt");
            } else {
                Punkte = punkte;
            }

    }// Ende setPunkte




// Getter und Setter

    public int getVeraenderungPersonal() {
        return veraenderungPersonal;
    }

    public void setVeraenderungPersonal(int veraenderungPersonal) {
        this.veraenderungPersonal = veraenderungPersonal;
    }

    public double getMaSchnitt() {
        return maSchnitt;
    }

    public void setMaSchnitt(double maSchnitt) {
        this.maSchnitt = maSchnitt;
    }

    public double getKontoSchnitt() {
        return kontoSchnitt;
    }
    public double getGuthaben() {
        return Guthaben;
    } // Ende getGuthaben

    public double getMarktanteil() {
        return Marktanteil;
    } // Ende getMarktanteil
    public int getPunkte() {
        return Punkte;
    }

    public String getName() {
        return Name;
    }

    public String getPasswort() {
        return Passwort;
    }

}// Ende Klasse