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
    /**
     * Konstruktor
     * @param pkz
     * @param controller
     * @param daten
     * @throws Exception
     */
    public Marktsim(double[] pkz, Controller controller, Daten daten, Data[] data, throws Exception {
    this.Controller = controller;
        this.daten = daten;
        this.data = data;
        for (int i = 0; i < pkz.length; i++) {
            pkzarray.set(i, pkz[i]);
        }
        berechneAbsatz(); //ToDo Exception Handling
    }

    private Data[] data;
    private Daten daten;
    private int anzSpieler = daten.getSpielerAnzahl();
    private int AnzKäufer = anzSpieler * 8000;   // Abfrage der Spieleranzahl, mult. mit 8000
    private int lKäufer;                         //low-budget-Käufer
    private int hKäufer;                         //high-budget-Käufer
    private float highestp = 5;
    private float lowestp = 1500;
    private int lvertKäufer = 0, hvertKäufer = 0;
    private static double startguthaben = 10000;
    ArrayList<Auftrag> bestellpos = new ArrayList();
    private float l1, l2, l3, h1, h2, h3, l1v, l2v, l3v, h1v, h2v, h3v, l1summe, l2summe, l3summe, h1summe, h2summe, h3summe; //l1,l2 .. usw Preissegmentsgrenzen //l1v.. usw Verteilung der Kunden auf die Preissegmente
    private ArrayList<Integer> l1array, l2array, l3array, h1array, h2array, h3array = new ArrayList<Integer>();
    ArrayList absatzreturn = new ArrayList();
    ArrayList<Double> marktanteil = new ArrayList<Double>();
    ArrayList<Double> rundenGewinn = new ArrayList<Double>();
    ArrayList<Double> summierterGewinn = new ArrayList<Double>();
    ArrayList prozentualeVorteile = new ArrayList();
    ArrayList vkparray = new ArrayList();
    ArrayList mengearray = new ArrayList();
    ArrayList pkzarray = new ArrayList();
    ArrayList diff = new ArrayList();
    Controller Controller;

    /**
     * @throws Exception
     */

    public ArrayList berechneAbsatz() throws Exception {

        prozentualeVorteile.clear(); // Leeren der Arraylists vor neuer Berechnung
        vkparray.clear();
        mengearray.clear();
        pkzarray.clear();
        diff.clear();
        absatzreturn.clear();

        Auftrag[] bp = Controller.getAuftrage();

        for (int i = 0; i < bp.length; i++) {
            bestellpos.set(i, bp[i]);
        }


        int lverteilung = randInt(40, 60);               //Verteilung low-zufall
        int hverteilung = 100 - lverteilung;            //Verteilung 100 Prozent - low-verteilung
        lvertKäufer = lverteilung / 100 * lKäufer;    // Berechnung Anzahl low-budget-Käufer
        hvertKäufer = hverteilung / 100 * hKäufer;    // Berechnung Anzahl low-budget-Käufer

        berechnePreissegmente();        // Verteilung der Käufer auf l1-3 und l1-3 zufällig

        for (Auftrag s : this.bestellpos) {
            double zw = 0;
            if (s.getBezahlart().isKreditkarte()) {
                zw += s.getBezahlart().getKreditkarteZufall();
            }
            if (s.getBezahlart().isPayPal()) {
                zw += s.getBezahlart().getPayPalZufall();
            }
            if (s.getBezahlart().isRechnung()) {
                zw += s.getBezahlart().getRechnungZufall();
            }
            if (s.getMarketing().isFernsehwerbung()) {
                zw += s.getMarketing().getFernsehwerbungPWS();
            }
            if (s.getMarketing().isRadiowerbung()) {
                zw += s.getMarketing().getRadiowerbungPWS();
            }
            if (s.getMarketing().isPrintwerbung()) {
                zw += s.getMarketing().getPrintwerbungPWS();
            }
            prozentualeVorteile.add(zw);
        }

        for (Auftrag p : this.bestellpos) {   // Menge-Abfrage
            mengearray.add(p.getMenge());
        }

        for (Auftrag e : this.bestellpos) {   // VKP-Abfrage
            vkparray.add(e.getVkp());
        }

        for (int i = 0; i < anzSpieler; i++) {      // Differenzberechnung
            diff.set(i, (double) pkzarray.get(i) - (double) vkparray.get(i));
        }


        for (int i = 0; i < anzSpieler; i++) {                                       // Abweichungen wirken sich auf die prozentualenVorteile aus. 80, 100 und 150 % Schritte
            if ((double) diff.get(i) < (0 - (double) pkzarray.get(i) * 0.80)) {
                double y = (double) prozentualeVorteile.get(i) - 0.25;
                prozentualeVorteile.set(i, y);
            }
            if ((double) diff.get(i) < (0 - (double) pkzarray.get(i) * 1.5)) {
                double y = (double) prozentualeVorteile.get(i) - 0.375;
                prozentualeVorteile.set(i, y);
            }
            if ((double) diff.get(i) < (0 - (double) pkzarray.get(i) * 2.0)) {
                double y = (double) prozentualeVorteile.get(i) - 0.8;
                prozentualeVorteile.set(i, y);
            }

        }

        l1array.clear(); // Leeren der Arrays
        l2array.clear();
        l3array.clear();
        h1array.clear();
        h2array.clear();
        h3array.clear();


        for (int i = 0; i < anzSpieler; i++) {

            if ((double) vkparray.get(i) < l1) {
                double y = ((double) randInt(30, 80) / 100 + (double) prozentualeVorteile.get(i));
                if (y > 1) {
                    y = 1;
                }
                if (y < 0) {
                    y = 0;
                }
                if (y * l1v > (int) mengearray.get(i)) {
                    double x = (double) mengearray.get(i);
                    absatzreturn.set(i, x);
                } else {
                    absatzreturn.set(i, y * l1v);
                }
                l1summe += (double) absatzreturn.get(i);
                l1array.add(i);
            } else {
                if ((double) vkparray.get(i) < l2) {
                    double y = ((double) randInt(35, 70) / 100 + (double) prozentualeVorteile.get(i));
                    if (y > 1) {
                        y = 1;
                    }
                    if (y < 0) {
                        y = 0;
                    }
                    if (y * l2v > (int) mengearray.get(i)) {
                        double x = (double) mengearray.get(i);
                        absatzreturn.set(i, x);
                    } else {
                        absatzreturn.set(i, y * l2v);
                    }
                    l2summe += (double) absatzreturn.get(i);
                    l2array.add(i);
                } else {
                    if ((double) vkparray.get(i) < l3) {
                        double y = ((double) randInt(35, 70) / 100 + (double) prozentualeVorteile.get(i));
                        if (y > 1) {
                            y = 1;
                        }
                        if (y < 0) {
                            y = 0;
                        }
                        if (y * l3v > (int) mengearray.get(i)) {
                            double x = (double) mengearray.get(i);
                            absatzreturn.set(i, x);
                        } else {
                            absatzreturn.set(i, y * l3v);
                        }
                        l3summe += (double) absatzreturn.get(i);
                        l3array.add(i);
                    } else {
                        if ((double) vkparray.get(i) < h1) {
                            double y = ((double) randInt(35, 70) / 100 + (double) prozentualeVorteile.get(i));
                            if (y > 1) {
                                y = 1;
                            }
                            if (y < 0) {
                                y = 0;
                            }
                            if (y * h1v > (int) mengearray.get(i)) {
                                double x = (double) mengearray.get(i);
                                absatzreturn.set(i, x);
                            } else {
                                absatzreturn.set(i, y * h1v);
                            }
                            h1summe += (double) absatzreturn.get(i);
                            h1array.add(i);
                        } else {
                            if ((double) vkparray.get(i) < h2) {
                                double y = ((double) randInt(30, 65) / 100 + (double) prozentualeVorteile.get(i));
                                if (y > 1) {
                                    y = 1;
                                }
                                if (y < 0) {
                                    y = 0;
                                }
                                if (y * h2v > (int) mengearray.get(i)) {
                                    double x = (double) mengearray.get(i);
                                    absatzreturn.set(i, x);
                                } else {
                                    absatzreturn.set(i, y * h2v);
                                }
                                h2summe += (double) absatzreturn.get(i);
                            } else {
                                if ((double) vkparray.get(i) < h3) {
                                    double y = ((double) randInt(30, 70) / 100 + (double) prozentualeVorteile.get(i));
                                    if (y > 1) {
                                        y = 1;
                                    }
                                    if (y < 0) {
                                        y = 0;
                                    }
                                    if (y * h3v > (int) mengearray.get(i)) {
                                        double x = (double) mengearray.get(i);
                                        absatzreturn.set(i, x);
                                    } else {
                                        absatzreturn.set(i, y * h3v);
                                    }
                                    h3summe += (double) absatzreturn.get(i);
                                    h3array.add(i);
                                }

                            }

                        }

                    }

                }
            }
        }

        while (l1summe > l1v) {
            for (int s : l1array) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 5);
            }
        }

        while (l2summe > l2v) {
            for (int s : l2array) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 5);
            }
        }


        while (l3summe > l3v) {
            for (int s : l3array) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 5);
            }
        }

        while (h1summe > h1v) {
            for (int s : h1array) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 5);
            }
        }

        while (h2summe > h2v) {
            for (int s : h2array) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 5);
            }
        }

        while (h3summe > h3v) {
            for (int s : h3array) {
                double f = (double) absatzreturn.get(s);
                absatzreturn.set(s, f - 5);
            }
        }


        berechneRundengewinn();
        berechneMartkanteil();

        return absatzreturn;
    } // Ende berechneAbsatz


    /**
     * Verteilt die Kunden auf die Preissegmente l1-3 und h1-3
     */
    public void berechnePreissegmente() {

        float middle = (highestp - lowestp) / 2;

        l1 = lowestp + (1 / 4 * middle);                             //Preisklassen l1-3 und h1-3
        l2 = lowestp + (1 / 2 * middle);                             // Enteilung in 1/3 Schritte, Verteilung Zufällig
        l3 = lowestp + (3 / 3 * middle);
        h1 = (lowestp + middle) + (1 / 4 * middle);
        h2 = (lowestp + middle) + (1 / 2 * middle);
        h3 = (lowestp + middle) + (3 / 3 * middle);

        l1v = randInt(1, 49);                        // Prozentuale Verteilung low budget
        l2v = randInt(1, 49);
        l3v = (l1v - l2v);

        l1v = l1v / 100 * lvertKäufer;                // Anzahl der low budget Käufer in den Preissegmenten
        l2v = l2v / 100 * lvertKäufer;
        l3v = l3v / 100 * lvertKäufer;

        h1v = randInt(1, 49);                        // Prozentuale Verteilung high budget
        h2v = randInt(1, 49);
        h3v = h1v - h2v;

        h1v = h1v / 100 * hvertKäufer;               // Anzahl der high budget Käufer in den Preissegmenten
        h2v = h2v / 100 * hvertKäufer;
        h3v = h3v / 100 * hvertKäufer;
    } //Ende BerechenePreissegmente

    /**
     * Berechnet den prozentualen Marktanteil jedes Spielers
     * Absatz/Spieler im Verhältnis zum Absatz aller Spieler
     */
    public void berechneMartkanteil() {
        int sum = 0;
        for (int i = 0; i < absatzreturn.size(); i++) {
            sum += (int) absatzreturn.get(i);
        }

        for (int i = 0; i < absatzreturn.size(); i++) {
            marktanteil.set(i, (double) absatzreturn.get(i) / sum);
        }
    }

    /**
     * Berechnet den Rundengewinn jedes Spielers
     */
    public void berechneRundengewinn() {
        for (int i = 0; i < absatzreturn.size(); i++) {
            rundenGewinn.set(i, ((double) absatzreturn.get(i) * (double) vkparray.get(i)) - startguthaben);
        }
        summiereGewinn();
    }

    /**
     * Summiert die Gewinne der Runden auf
     */
    public void summiereGewinn() {
        for (int i = 0; i < rundenGewinn.size(); i++) {
            double o = summierterGewinn.get(i);
            summierterGewinn.set(i, o + rundenGewinn.get(i));
        }
    }

    /**
     * Gibt einen Zufalls-Integer zurück zur Berechnung der Zufälle
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

    public int getlKäufer() {
        return lKäufer;
    }

    public int gethKäufer() {
        return hKäufer;
    }

    public float getLowestp() {
        return lowestp;
    }

    public float getHighestp() {
        return highestp;
    }

    public double getMarktanteil(String namen) {
        HashMap<String, Double> h = new HashMap<String, Double>();
        String[] u = Controller.getNamen();

        for (int i = 0; i < u.length; i++) {
            h.put(u[i], marktanteil.get(i));
        }
        return h.get(namen);
    }

    public ArrayList<Double> getSummierterGewinn() {
        return summierterGewinn;
    }

    public ArrayList<Double> getRundenGewinn() {
        return rundenGewinn;
    }

}
