package com.example.patsc.fallstudie.Covered;

import com.example.patsc.fallstudie.Network.RundenErgebnisWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


/**
 * Created by dominik on 30.12.2016. Not testable.
 */

public class Marktsim {

    private RundenErgebnisWrapper[] data;
    private Controller Controller;
    private int anzSpieler = 10;

    private double anzKäufer = anzSpieler * 8000;         //Anzahl der Spieler mult. mit 8000
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
    private ArrayList<Double> summierterGewinn = new ArrayList<Double>();
    private ArrayList<Double> bonusarray = new ArrayList<Double>();
    private ArrayList<Double> vkparray = new ArrayList<Double>();
    private ArrayList<Integer> mengearray = new ArrayList<Integer>();
    private ArrayList<Double> reservationspreisarray = new ArrayList<Double>();
    private ArrayList<Double> differenz = new ArrayList<Double>();
    private ArrayList gesamtkostenarray = new ArrayList();
    private ArrayList kontoarray = new ArrayList();
    private ArrayList namenarray = new ArrayList();

    /**
     * Konstruktor
     *
     * @param controller
     * @param rundenErgebnisWrapper
     * @throws Exception
     */
    public Marktsim(Controller controller, RundenErgebnisWrapper[] rundenErgebnisWrapper) throws Exception {

        this.Controller = controller;
        this.data = rundenErgebnisWrapper;

        for (RundenErgebnisWrapper p : this.data) {
            reservationspreisarray.add(p.getRespr());
        }

        for (RundenErgebnisWrapper p : this.data) {   // Menge-Abfrage
            mengearray.add(p.getMenge());
        }

        for (RundenErgebnisWrapper p : this.data) {   // VKP-Abfrage
            vkparray.add(p.getVkp());
        }

        for (RundenErgebnisWrapper p : this.data) {   // VKP-Abfrage
            gesamtkostenarray.add(p.getGesamtKosten());
        }

        for (RundenErgebnisWrapper p : this.data) {   // Menge-Abfrage
            bonusarray.add(p.getBonus());
        }

        for (RundenErgebnisWrapper p : this.data) {   // Kontostand-Abfrage
            kontoarray.add(p.getKonto());
        }

        for (RundenErgebnisWrapper p : this.data) {
            namenarray.add(p.getId());
        }

        for (int i = 0; i < anzSpieler; i++) {      // Differenzberechnung zwischen Reservationspreis und Verkaufspreis
            differenz.add((double) reservationspreisarray.get(i) - (double) vkparray.get(i));
        }
        berechnePreissegmente();        // Verteilung der möglichen Käufer zufällig auf die Preissegmente low, middle und high
        berechneAbsatz();               // Ausführen der Methode "berechneAbsatz"
    }


    /**
     * @return
     * @throws Exception
     */

    public ArrayList berechneAbsatz() throws Exception {


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
                    int x = mengearray.get(i);
                    absatzarrayint.add(x);
                } else {
                    int eingabe = (int) (Math.round(y * lowKäufer));
                    absatzarrayint.add(eingabe);
                }
                lowsumme += (int) absatzarrayint.get(i);
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
                        int x = mengearray.get(i);
                        absatzarrayint.add(x);
                    } else {
                        absatzarrayint.add((int) (Math.round(y * middleKäufer)));
                    }
                    middlesumme += (int) absatzarrayint.get(i);
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
                        if (y * highKäufer > mengearray.get(i)) {
                            int x = mengearray.get(i);
                            absatzarrayint.add(x);
                        } else {

                            absatzarrayint.add((int) (Math.round(y * highKäufer)));
                        }
                        highsumme += (int) absatzarrayint.get(i);
                        higharray.add(i);
                    }
                }
            }
        }

        while (lowsumme > lowKäufer) {
            for (int s : lowarray) {
                int f = (int) absatzarrayint.get(s);
                absatzarrayint.set(s, f - 2);
            }
        }

        while (middlesumme > middleKäufer) {
            for (int s : middlearray) {
                int f = (int) absatzarrayint.get(s);
                absatzarrayint.set(s, f - 2);
            }
        }

        while (highsumme > highKäufer) {
            for (int s : higharray) {
                int f = (int) absatzarrayint.get(s);
                absatzarrayint.set(s, f - 2);
            }
        }
        for (int i = 0; i < absatzarrayint.size(); i++) {    //Übertragen der Daten des absatzarray von Typ Integer in Double für die weitere Berechnung
            int zwischenint = (int) absatzarrayint.get(i);
            double zwischendouble = zwischenint;
            absatzarraydouble.add(zwischendouble);
        }
        berechneRundengewinn();
        berechneMarktanteil();
        berechneNeuenKontostand();
        setGuthabenAktiverSpieler();

        for (int i = 0; i < data.length; i++) {
            data[i].setKonto((double) kontoarray.get(i));
            data[i].setMarktanteil((double) marktanteil.get(i));
            data[i].setRundengewinn((double) rundenGewinn.get(i));
        }

        return absatzarrayint;
    } // Ende berechneAbsatz


    /**
     * Verteilt die Kunden zufällig auf die Preissegmente low, middle und high
     */
    public void berechnePreissegmente() {

        lowverteilung = randInt(40, 49);                      // Verteilung low (zufällig)
        highverteilung = randInt(30, 49);                     // Verteilung high (zufällig)
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
        for (int i = 0; i < absatzarraydouble.size(); i++) {          // Aufaddieren aller verkauften Uhren von allen Spielern
            sum += (int) absatzarrayint.get(i);
        }
        double sum1 = sum;
        for (int i = 0; i < absatzarrayint.size(); i++) {           // Befüllen der ArrayList "martkanteil" mit dem prozentualen Anteil jedes Spielers
            marktanteil.add((double) absatzarraydouble.get(i) / sum1);
        }
    } //Ende berechneMarktanteil

    // TODO: 02.02.2017 #Dodo der durchschnittliche Marktanteil sollte hier übergeben werden. Dazu brauchen wir die Methode zum setzen, aber auch das berechnen müsste wohl angepasst werden
    // Der Spieler besitzt jetzt den durchschnittlichen Marktanteil und er wird auch mit den Rundenergebnissen versandt und empfangen


    /**
     * Berechnet den Rundengewinn jedes Spielers
     */
    public void berechneRundengewinn() {
        for (int i = 0; i < absatzarrayint.size(); i++) {
            rundenGewinn.add(((int) absatzarrayint.get(i) * vkparray.get(i)) - (double) gesamtkostenarray.get(i));
        }
    }

    public void berechneNeuenKontostand() {
        for (int i = 0; i < absatzarrayint.size(); i++) {
            kontoarray.set(i, ((double) kontoarray.get(i) + rundenGewinn.get(i)));
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
            hashmap.put((String) namenarray.get(i), marktanteil.get(i));
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

    public RundenErgebnisWrapper[] getData() {
        return data;
    }

    /**
     * ----------------------Ende Getter und Setter----------------------
     */
}
