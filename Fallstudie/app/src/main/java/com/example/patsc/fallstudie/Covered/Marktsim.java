package com.example.patsc.fallstudie.Covered;

import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Network.RundenErgebnisWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by dominik on 30.12.2016. Not testable.
 */

public class Marktsim {

    private RundenErgebnisWrapper[] rundenergebniswrapperarray;
    private com.example.patsc.fallstudie.Covered.Controller.Controller Controller;
    private int anzSpieler = 10;

    private double anzKäufer = anzSpieler * 7000;         //Anzahl der Spieler multipliziert mit 7000
    private double lowKäufer, middleKäufer, highKäufer;  // Variable für die Anzahl der möglichen Kunden in dem jeweiligen Preissegment
    private double lowsumme, middlesumme, highsumme;     // Zwischenspeicher für die Summe der Abverkäufe in dem jeweiligen Preissegment

    private float lowGrenze = 150, middleGrenze = 250; // Preissegmentsgrenzen low = 150, middle = 250, high > middle
    int lowverteilung;                      // Verteilung low (zufällig)
    int highverteilung;                     // Verteilung high (zufällig)
    int middleverteilung;                   // Verteilung middle abhängig von low und high

    private ArrayList<Integer> middlearray = new ArrayList<Integer>();
    private ArrayList<Integer> lowarray = new ArrayList<Integer>();
    private ArrayList<Integer> higharray = new ArrayList<Integer>();
    private ArrayList absatzarrayint = new ArrayList();
    private ArrayList absatzarraydouble = new ArrayList();
    private ArrayList<Double> marktanteil = new ArrayList<Double>();
    private ArrayList<Double> rundenGewinn = new ArrayList<Double>();
    private ArrayList<Double> absatzbonusarray = new ArrayList<Double>();
    private ArrayList<Double> vkparray = new ArrayList<Double>();
    private ArrayList<Integer> mengearray = new ArrayList<Integer>();
    private ArrayList<Double> reservationspreisarray = new ArrayList<Double>();
    private ArrayList<Double> differenz = new ArrayList<Double>();
    private ArrayList gesamtkostenarray = new ArrayList();
    private ArrayList kontoarray = new ArrayList();
    private ArrayList namenarray = new ArrayList();
    private ArrayList personalanzahlarray = new ArrayList();
    private ArrayList maSchnitt = new ArrayList();

    /**
     * Konstruktor
     * Füllen der ArrayListen zur Berechnung; Berechnung der Differenz von Reservationspreis und VKP
     *
     * @param controller
     * @param rundenErgebnisWrapper
     * @throws Exception
     */
    public Marktsim(Controller controller, RundenErgebnisWrapper[] rundenErgebnisWrapper) throws Exception {
        this.Controller = controller;
        this.rundenergebniswrapperarray = rundenErgebnisWrapper;
        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {
            reservationspreisarray.add(p.getRespr());
        }

        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {   // Menge-Abfrage
            mengearray.add(p.getMenge());
        }

        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {   // VKP-Abfrage
            vkparray.add(p.getVkp());
        }

        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {   // Gesamtkosten-Abfrage
            gesamtkostenarray.add(p.getGesamtKosten());
        }

        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {   // Personalanzahl-Abfrage
            personalanzahlarray.add(p.getPersonalanzahl());
        }

        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {   // Marktanteildurchschnitt-Abfrage
            maSchnitt.add(p.getMaSchnitt());
        }

        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {   // Menge-Abfrage
            absatzbonusarray.add(p.getBonus());
        }

        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {   // Kontostand-Abfrage
            kontoarray.add(p.getKonto());
        }

        for (RundenErgebnisWrapper p : this.rundenergebniswrapperarray) {   //Namen-Abfrage (ID)
            namenarray.add(p.getId());
        }

        for (int i = 0; i < anzSpieler; i++) {      // Differenzberechnung zwischen Reservationspreis und Verkaufspreis
            differenz.add((double) reservationspreisarray.get(i) - (double) vkparray.get(i));
        }
        berechnePreissegmente();        // Verteilung der möglichen Käufer zufällig auf die Preissegmente low, middle und high
        berechneAbsatz();               // Ausführen der Methode "berechneAbsatz"
    }


    /**
     * Hauptmethode der Berechnungen.
     * (1) Abweichung VKP vom Reservationspreis beeinflusst Absatzzahlen
     * (2) Einordnung des VKP auf die Preissegmente Low, Middle und High; Zufällige Absatzzahlen + Bonusarray ergeben die Absatzzahl des Spielers
     * (3) Gleichmäßige Verminderung der Absatzzahlen eines Preissegments bis die Käuferanzahl des jeweiligen Preissegments erreicht ist
     * (4) Aufrufen der Methoden zur Berechnung der Kennzahlen
     * (5) Speichern der geänderten Kennzahlen im ErgebnisRundenWrapper[]
     *
     * @return
     * @throws Exception
     */

    public ArrayList berechneAbsatz() throws Exception {


        for (int i = 0; i < anzSpieler; i++) {                            //(1) Abweichungen wirken sich auf das bonusarray aus. 80, 100 und 150 % Schritte
            if (differenz.get(i) < (0 - reservationspreisarray.get(i) * 0.60)) {
                double y = absatzbonusarray.get(i) - 0.15;
                absatzbonusarray.set(i, y);
            }
            if (differenz.get(i) < (0 - reservationspreisarray.get(i) * 0.80)) {
                double y = absatzbonusarray.get(i) - 0.25;
                absatzbonusarray.set(i, y);
            }
            if (differenz.get(i) < (0 - reservationspreisarray.get(i) * 1.5)) {
                double y = absatzbonusarray.get(i) - 0.375;
                absatzbonusarray.set(i, y);
            }
            if (differenz.get(i) < (0 - reservationspreisarray.get(i) * 2.0)) {
                double y = absatzbonusarray.get(i) - 0.8;
                absatzbonusarray.set(i, y);
            }

        }


        for (int i = 0; i < anzSpieler; i++) {      // (2)

            if (vkparray.get(i) <= lowGrenze) {
                double y = ((double) randInt(30, 80) / 100 + absatzbonusarray.get(i));
                if (y > 1) {
                    y = 1;
                }
                if (y < 0) {
                    y = 0;
                }
                if (y * lowKäufer > mengearray.get(i)) {
                    if ((int) personalanzahlarray.get(i) * 2000 >= mengearray.get(i)) {
                        int x = mengearray.get(i);
                        absatzarrayint.add(x);
                    } else {
                        absatzarrayint.add((int) personalanzahlarray.get(i) * 2000);
                    }
                } else {
                    if ((int) personalanzahlarray.get(i) * 2000 >= y * lowKäufer) {
                        int eingabe = (int) (Math.round(y * lowKäufer));
                        absatzarrayint.add(eingabe);
                    } else {
                        absatzarrayint.add((int) personalanzahlarray.get(i) * 2000);
                    }

                }
                lowsumme += (int) absatzarrayint.get(i);
                lowarray.add(i);
            } else {
                if (vkparray.get(i) <= middleGrenze) {
                    double y = ((double) randInt(30, 50) / 100 + absatzbonusarray.get(i));
                    if (y > 1) {
                        y = 1;
                    }
                    if (y < 0) {
                        y = 0;
                    }
                    if (y * middleKäufer > mengearray.get(i)) {
                        if ((int) personalanzahlarray.get(i) * 2000 >= mengearray.get(i)) {
                            int x = mengearray.get(i);
                            absatzarrayint.add(x);
                        } else {
                            absatzarrayint.add((int) personalanzahlarray.get(i) * 2000);
                        }
                    } else {
                        if ((int) personalanzahlarray.get(i) * 2000 >= y * middleKäufer) {
                            int eingabe = (int) (Math.round(y * middleKäufer));
                            absatzarrayint.add(eingabe);
                        } else {
                            absatzarrayint.add((int) personalanzahlarray.get(i) * 2000);
                        }

                    }
                    middlesumme += (int) absatzarrayint.get(i);
                    middlearray.add(i);
                } else {
                    if (vkparray.get(i) > middleGrenze) {
                        double y = ((double) randInt(35, 70) / 100 + absatzbonusarray.get(i));
                        if (y > 1) {
                            y = 1;
                        }
                        if (y < 0) {
                            y = 0;
                        }
                        if (y * highKäufer > mengearray.get(i)) {
                            if ((int) personalanzahlarray.get(i) * 2000 >= mengearray.get(i)) {
                                int x = mengearray.get(i);
                                absatzarrayint.add(x);
                            } else {
                                absatzarrayint.add((int) personalanzahlarray.get(i) * 2000);
                            }
                        } else {
                            if ((int) personalanzahlarray.get(i) * 2000 >= y * highKäufer) {
                                int eingabe = (int) (Math.round(y * highKäufer));
                                absatzarrayint.add(eingabe);
                            } else {
                                absatzarrayint.add((int) personalanzahlarray.get(i) * 2000);
                            }

                        }
                        highsumme += (int) absatzarrayint.get(i);
                        higharray.add(i);
                    }
                }
            }
        }

        while (lowsumme > lowKäufer) {      // (3)
            for (int s : lowarray) {
                int f = (int) absatzarrayint.get(s);
                absatzarrayint.set(s, f - 2);
            }
            lowsumme = lowsumme - 20;
        }

        while (middlesumme > middleKäufer) {
            for (int s : middlearray) {
                int f = (int) absatzarrayint.get(s);
                absatzarrayint.set(s, f - 2);
            }
            middlesumme = middlesumme - 20;
        }

        while (highsumme > highKäufer) {
            for (int s : higharray) {
                int f = (int) absatzarrayint.get(s);
                absatzarrayint.set(s, f - 2);
            }
            highsumme = highsumme - 20;
        }
        for (int i = 0; i < absatzarrayint.size(); i++) {    //Übertragen der Daten des absatzarray von Typ Integer in Double für die weitere Berechnung
            int zwischenint = (int) absatzarrayint.get(i);
            double zwischendouble = zwischenint;
            absatzarraydouble.add(zwischendouble);
        }

        berechneRundengewinn();                              // (4)
        berechneMarktanteil();
        berechneNeuenKontostand();
        setGuthabenAktiverSpieler();
        berechneMaSchnitt();


        for (int i = 0; i < rundenergebniswrapperarray.length; i++) {            // (5)
            rundenergebniswrapperarray[i].setKonto((double) kontoarray.get(i));
            rundenergebniswrapperarray[i].setMarktanteil(marktanteil.get(i));
            rundenergebniswrapperarray[i].setRundengewinn(rundenGewinn.get(i));
            rundenergebniswrapperarray[i].setMaSchnitt((double) maSchnitt.get(i));
        }

        return absatzarrayint;
    } // Ende berechneAbsatz

    /**
     * Berechnet den durschnittlichen Marktanteil des Spielers über alle bisher gespielten Runden
     */
    private void berechneMaSchnitt() {
        for (int i = 0; i < maSchnitt.size(); i++) {
            double zwischen = (double) maSchnitt.get(i) * (rundenergebniswrapperarray[i].getRunde() - 1);
            maSchnitt.set(i, ((zwischen + marktanteil.get(i)) / (rundenergebniswrapperarray[i].getRunde())));
        }
    }

    /**
     * Verteilt die Kunden zufällig auf die Preissegmente low, middle und high
     */
    public void berechnePreissegmente() {

        lowverteilung = randInt(40, 50);                            // Verteilung low (zufällig)
        highverteilung = randInt(30, 40);                           // Verteilung high (zufällig)
        middleverteilung = 100 - lowverteilung - highverteilung;    // Verteilung middle abhängig von low und high
        lowKäufer = (((double) lowverteilung / 100) * anzKäufer);
        middleKäufer = (((double) middleverteilung / 100) * anzKäufer);
        highKäufer = (((double) highverteilung / 100) * anzKäufer);

    } //Ende BerechenePreissegmente

    /**
     * Berechnet den prozentualen Marktanteil jedes Spielers
     * Absatz/Spieler im Verhältnis zum Absatz aller Spieler
     */
    public void berechneMarktanteil() {
        int sum = 0;
        for (int i = 0; i < absatzarrayint.size(); i++) {          // Aufaddieren aller verkauften Uhren von allen Spielern
            sum += (int) absatzarrayint.get(i);
        }
        double sum1 = sum;
        for (int i = 0; i < absatzarraydouble.size(); i++) {           // Befüllen der ArrayList "martkanteil" mit dem prozentualen Anteil jedes Spielers
            marktanteil.add((double) Math.round(((double) absatzarraydouble.get(i) / sum1) * 100) / 100);
        }
    } //Ende berechneMarktanteil

    /**
     * Berechnet den Rundengewinn jedes Spielers
     */
    public void berechneRundengewinn() {
        for (int i = 0; i < absatzarrayint.size(); i++) {
            rundenGewinn.add((double) Math.round((((int) absatzarrayint.get(i) * vkparray.get(i)) - (double) gesamtkostenarray.get(i)) * 100) / 100);
        }
    }

    /**
     * Berechnung des neuen Kontostands für jeden Spielers
     */
    public void berechneNeuenKontostand() {
        for (int i = 0; i < absatzarrayint.size(); i++) {
            double zwischen = (double) kontoarray.get(i);
            kontoarray.set(i, (double) Math.round((zwischen + rundenGewinn.get(i)) * 100) / 100);
        }
    }

    /**
     * Addiert zum Guthaben des Spielers den Rundengewinn hinzu.
     */
    public void setGuthabenAktiverSpieler() {
        Controller.aktiverSpieler.setGuthaben(Controller.aktiverSpieler.getGuthaben() + getRundenGewinn(Controller.aktiverSpieler.getName()));
    }

    /**
     * Gibt einen zufälligen Integerwert zurück zur Berechnung der Zufälle
     *
     * @param min
     * @param max
     * @return
     */
    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    } //Ende randInt

    /**
     * ----------------------Getter und Setter----------------------
     */

    public double getMarktanteil(String namen) {

        HashMap<String, Double> hashmap = new HashMap<>();


        for (int i = 0; i < namenarray.size(); i++) {
            hashmap.put((String) namenarray.get(i), (double) (Math.round(marktanteil.get(i) * 10000) / 100));
        }
        return hashmap.get(namen);
    }

    public double getRundenGewinn(String name) {
        HashMap<String, Double> hashmap = new HashMap<>();


        for (int i = 0; i < namenarray.size(); i++) {
            hashmap.put((String) namenarray.get(i), rundenGewinn.get(i));
        }
        return hashmap.get(name);
    }

    public int getAbsatz(String name) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < namenarray.size(); i++) {
            hashmap.put((String) namenarray.get(i), (int) absatzarrayint.get(i));
        }
        return hashmap.get(name);
    }

    public RundenErgebnisWrapper[] getRundenErgebnisWrapper() {
        return rundenergebniswrapperarray;
    }

    public RundenErgebnisWrapper getAktiverErgebnisWrapper (String name){
        HashMap<String, RundenErgebnisWrapper> hashmap = new HashMap<>();
        for (int i = 0; i < namenarray.size(); i++) {
            hashmap.put((String) namenarray.get(i), rundenergebniswrapperarray[i]);
        }
        return hashmap.get(name);
    }

    /**
     * ----------------------Ende Getter und Setter----------------------
     */
}