package com.example.patsc.fallstudie;

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
    private int Anfangsguthaben = 10000; // Guthaben das jeder SPieler am Anfang hat.
    private int AnfangsMarktanteil = 0; // Marktanteil in Prozent vor der ersten RUnde
    private int AnfagsPunkte = 1000; // Punkt des Spielers vor der ersten Runde
    private final Daten daten;
    /**
     * Konstruktor für den Spieler.
     *
     * @param name     Parameter wird von der Activty übergeben; Pflichtfeld
     * @param passwort Parameter wird von der Activty übergeben; Pflichtfeld
     *                 Zu Beginn hat jeder ein Guthaben von 10.000€ und einen Marktanteil von 0%.
     *                 Am Beginn hat jeder Spieler 1000 Punkte.
     */

    public Spieler(String name, String passwort, Daten daten) {
        this.daten=daten;
        setName(name);
        setGuthaben(Anfangsguthaben);
        setMarktanteil(AnfangsMarktanteil);
        setPasswort(passwort);
        setPunkte(AnfagsPunkte);
        daten.addSpielerListe(this); // Hinzufügen des Spielers in die Liste
    } // Ende Konstruktor

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
    public void setMarktanteil(double marktanteil) {
        try {
            if (marktanteil < 100 && marktanteil > 0) {
                Marktanteil = marktanteil;
            } else if (marktanteil > 100) {
                throw new Exception("Marktanteil über 100%");
            } else if (marktanteil < 0) {
                throw new Exception("Marktanteil unter 0%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    } // Ende setMarktanteil

    public void setName(String name) {
        if (prüfeNameDoppelt(name)) {
            // ToDo Aufforderung neue Namenseingabe GUI
        }
        Name = name;
    } // Ende setName()


    /**
     * ToDO
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
    public void setPunkte(int punkte) {
        try {
            if (punkte < 0) {
                Punkte = 0;
                throw new Exception("Punkte kleiner als 0, automatisch auf 0 gesetzt");
            } else {
                Punkte = punkte;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// Ende setPunkte

    public void beendeRunde() {
        //ToDo
    }// Ende beendeRUnde()

    /**
     * Was passiert wenn der Spieler dasspiel beendet oder das Spiel wegen abschliessen der 10.Runde oder wegen einem zu geringen Geldwert passiert.
     */
    public void beendeSpiel() {
        //ToDo
    } //Ende beendeSpiel()

    /**
     * Prüft ob der Name bereits von einem anderen Spieler verwendet wird
     *
     * @param name der dem Spieler gegeben werden soll.
     * @return boolean ob der Name bereits vegreben ist; true = Name wird bereits verwendet; false = Name wird noch nicht verwendet
     */
    public boolean prüfeNameDoppelt(String name) {
        //ToDo Jonas
        return false;
    } // Ende prüfeNameDoppelt
}// Ende Klasse