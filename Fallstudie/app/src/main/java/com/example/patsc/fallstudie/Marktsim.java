package com.example.patsc.fallstudie;

import com.example.patsc.fallstudie.Network.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static android.R.attr.data;


/**
 * Created by dominik on 30.12.2016. Not testable.
 */

public class Marktsim {

    private Data[] data;
    private Daten daten;
    private Controller Controller;
    private int anzSpieler = daten.getSpielerAnzahl();


    private int anzKäufer = anzSpieler * 8000;           // Abfrage der Spieleranzahl, mult. mit 8000
    private int lowKäufer, middleKäufer, highKäufer;  // Variable für die Anzahl der möglichen Kunden in dem jeweiligen Preissegment
    private int lowsumme, middlesumme, highsumme;  // Zwischenspeicher für die Summe der Abverkäufe in dem jeweiligen Preissegment


    private float highestp = 300;
    private float lowestp = 5;
    private final double startguthaben = 150000;
    private float lowGrenze = 150, middleGrenze = 250; // Preissegmentsgrenzen low = 150, middle = 250, high > middle


    private ArrayList<Integer> lowarray, middlearray, higharray = new ArrayList<Integer>();
    private ArrayList absatzreturn = new ArrayList();
    private ArrayList<Double> marktanteil = new ArrayList<Double>();
    private ArrayList<Double> rundenGewinn = new ArrayList<Double>();
    private ArrayList<Double> summierterGewinn = new ArrayList<Double>();
    private ArrayList<Double> bonusarray = new ArrayList<Double>();
    private ArrayList<Double> vkparray = new ArrayList<Double>();
    private ArrayList<Integer> mengearray = new ArrayList<Integer>();
    private ArrayList<Double> reservationspreisarray = new ArrayList<Double>();
    private ArrayList<Double> differenz = new ArrayList<Double>();
    private ArrayList gesamtkostenarray = new ArrayList();
    private ArrayList kontoarray = new ArrayList();

    /**
     * Konstruktor
     *
     * @param reservationspreis
     * @param controller
     * @param daten
     * @param data
     * @throws Exception
     */
    public Marktsim(double[] reservationspreis, Controller controller, Daten daten, Data[] data) throws Exception {

        this.Controller = controller;
        this.daten = daten;
        this.data = data;

        for (int i = 0; i < reservationspreis.length; i++) {
            reservationspreisarray.set(i, reservationspreis[i]);
        }


        for (Data p : this.data) {   // Menge-Abfrage
            mengearray.add(p.getMenge());
        }

        for (Data p : this.data) {   // VKP-Abfrage
            vkparray.add(p.getVkp());
        }

        for (Data p : this.data) {   // VKP-Abfrage
            // gesamtkostenarray.add(p.getGesamtKosten()); ToDo Fehler kommentiert da falsch, fix notwendig
        }

        for (Data p : this.data) {   // Menge-Abfrage
            bonusarray.add(p.getBonus());
        }

        for (Data p : this.data) {   // Kontostand-Abfrage
            kontoarray.add(p.getKonto());
        }

        for (int i = 0; i < anzSpieler; i++) {      // Differenzberechnung zwischen Reservationspreis und Verkaufspreis
            differenz.set(i, (double) reservationspreisarray.get(i) - (double) vkparray.get(i));
        }
        berechnePreissegmente();        // Verteilung der möglichen Käufer zufällig auf die Preissegmente low, middle und high
        berechneAbsatz();               // Ausführen der Methode "berechneAbsatz"
    }


    /**
     * @return
     * @throws Exception
     */

    public ArrayList berechneAbsatz() throws Exception {

        /**  prozentualeVorteile.clear(); // Leeren der Arraylists vor neuer Berechnung  NOTWENDIG?
         vkparray.clear();
         mengearray.clear();
         reservationspreisarray.clear();
         differenz.clear();
         absatzreturn.clear();   **/


        for (int i = 0; i < anzSpieler; i++) {                            // Abweichungen wirken sich auf die prozentualenVorteile aus. 80, 100 und 150 % Schritte
            if (differenz.get(i) < (0 - reservationspreisarray.get(i) * 0.60)) {
                double y = bonusarray.get(i) - 0.15;
                bonusarray.set(i, y);
            }
            if (differenz.get(i) < (0 - reservationspreisarray.get(i) * 0.80)) {
                double y = bonusarray.get(i) - 0.25;
                bonusarray.set(i, y);
            }
            if (differenz.get(i) < (0 - reservationspreisarray.get(i) * 1.5)) {
                double y = bonusarray.get(i) - 0.375;
                bonusarray.set(i, y);
            }
            if (differenz.get(i) < (0 - reservationspreisarray.get(i) * 2.0)) {
                double y = bonusarray.get(i) - 0.8;
                bonusarray.set(i, y);
            }

        }

        /**
         lowarray.clear(); // Leeren der Arrays          NOTWENDIG, da jedes mal neues Objekt?
         middlearray.clear();
         higharray.clear();   **/

        for (int i = 0; i < anzSpieler; i++) {

            if (vkparray.get(i) <= lowGrenze) {        //Abfrage, ob der Verkaufspreis ins Low-Segment fällt  //Todo Personalwesen einbauen
                double y = ((double) randInt(30, 80) / 100 + bonusarray.get(i));
                if (y > 1) {
                    y = 1;
                }
                if (y < 0) {
                    y = 0;
                }
                if (y * lowKäufer > mengearray.get(i)) {
                    double x = (double) mengearray.get(i);
                    absatzreturn.set(i, x);
                } else {
                    absatzreturn.set(i, Math.round(y * lowKäufer));
                }
                lowsumme += (double) absatzreturn.get(i);
                lowarray.add(i);
            } else {
                if (vkparray.get(i) <= middleGrenze) { //Abfrage, ob der Verkaufspreis ins Middle-Segment fällt
                    double y = ((double) randInt(30, 50) / 100 + bonusarray.get(i));
                    if (y > 1) {
                        y = 1;
                    }
                    if (y < 0) {
                        y = 0;
                    }
                    if (y * middleKäufer > mengearray.get(i)) {
                        double x = (double) mengearray.get(i);
                        absatzreturn.set(i, x);
                    } else {
                        absatzreturn.set(i, Math.round(y * middleKäufer));
                    }
                    middlesumme += (double) absatzreturn.get(i);
                    middlearray.add(i);
                } else {
                    if (vkparray.get(i) > middleGrenze) { //Abfrage, ob der Verkaufspreis ins Middle-Segment fällt
                        double y = ((double) randInt(35, 70) / 100 + bonusarray.get(i));
                        if (y > 1) {
                            y = 1;
                        }
                        if (y < 0) {
                            y = 0;
                        }
                        if (y * highKäufer > (int) mengearray.get(i)) {
                            double x = (double) mengearray.get(i);
                            absatzreturn.set(i, x);
                        } else {

                            absatzreturn.set(i, Math.round(y * highKäufer));
                        }
                        highsumme += (double) absatzreturn.get(i);
                        higharray.add(i);
                    }
                }
            }
        }

        while (lowsumme > lowKäufer) {
            for (int s : lowarray) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 2);
            }
        }

        while (middlesumme > middleKäufer) {
            for (int s : middlearray) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 2);
            }
        }

        while (highsumme > highKäufer) {
            for (int s : higharray) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 2);
            }
        }

        berechneRundengewinn();
        summiereGewinn();
        berechneMarktanteil();
        berechneNeuenKontostand();
        setGuthabenAktiverSpieler();

        for (int i = 0; i < data.length; i++) {
            data[i].setKonto((double) kontoarray.get(i));
          //  data[i].setMarktanteil((double) marktanteil.get(i));ToDo Fehler kommentiert da falsch, fix notwendig
          // data[i].setRundengewinn((double) rundenGewinn.get(i)); ToDo Fehler kommentiert da falsch, fix notwendig
        }

        return absatzreturn;
    } // Ende berechneAbsatz


    /**
     * Verteilt die Kunden zufällig auf die Preissegmente low, middle und high
     */
    public void berechnePreissegmente() {

        int lowverteilung = randInt(40, 49);                      // Verteilung low (zufällig)
        int highverteilung = randInt(40, 49);                     // Verteilung high (zufällig)
        int middleverteilung = lowverteilung - highverteilung;    // Verteilung middle abhängig von low und high
        lowKäufer = (lowverteilung / 100) * anzKäufer;
        middleKäufer = (middleverteilung / 100) * anzKäufer;
        highKäufer = (highverteilung / 100) * anzKäufer;

    } //Ende BerechenePreissegmente

    /**
     * Berechnet den prozentualen Marktanteil jedes Spielers
     * Absatz/Spieler im Verhältnis zum Absatz aller Spieler
     */
    public void berechneMarktanteil() {
        int sum = 0;
        for (int i = 0; i < absatzreturn.size(); i++) {          // Aufaddieren aller verkauften Uhren von allen Spielern
            sum += (int) absatzreturn.get(i);
        }

        for (int i = 0; i < absatzreturn.size(); i++) {           // Befüllen der ArrayList "martkanteil" mit dem prozentualen Anteil jedes Spielers
            marktanteil.set(i, (double) absatzreturn.get(i) / sum);
        }
    } //Ende berechneMarktanteil

    /**
     * Berechnet den Rundengewinn jedes Spielers
     */
    public void berechneRundengewinn() {
        for (int i = 0; i < absatzreturn.size(); i++) {
            rundenGewinn.set(i, ((double) absatzreturn.get(i) * vkparray.get(i)) - (double) gesamtkostenarray.get(i));
        }
    }

    public void berechneNeuenKontostand() {
        for (int i = 0; i < absatzreturn.size(); i++) {
            kontoarray.set(i, ((double) kontoarray.get(i) + rundenGewinn.get(i)));
        }
    }

    /**
     * Summiert die Gewinne der Runden auf
     */
    public void summiereGewinn() {
        for (int i = 0; i < rundenGewinn.size(); i++) {
            double o = summierterGewinn.get(i);
            summierterGewinn.set(i, o + rundenGewinn.get(i));
        }
    } //Ende summiereGewinn

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
    }

    public ArrayList getVerkaufreturn() {
        return absatzreturn;
    }

    public double getMarktanteil(String namen) {
        HashMap<String, Double> hashmap = new HashMap<>();
        String[] namenarray = Controller.getNamen();

        for (int i = 0; i < namenarray.length; i++) {
            hashmap.put(namenarray[i], marktanteil.get(i));
        }
        return hashmap.get(namen);
    }

    public double getRundenGewinn(String namen) {
        HashMap<String, Double> hashmap = new HashMap<>();
        String[] namenarray = Controller.getNamen();

        for (int i = 0; i < namenarray.length; i++) {
            hashmap.put(namenarray[i], rundenGewinn.get(i));
        }
        return hashmap.get(namen);
    }

    public ArrayList<Double> getSummierterGewinn() {
        return summierterGewinn;
    }

    public ArrayList<Double> getRundenGewinn() {
        return rundenGewinn;
    }

}
