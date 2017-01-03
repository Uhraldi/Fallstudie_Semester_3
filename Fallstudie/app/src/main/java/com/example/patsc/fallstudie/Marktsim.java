package com.example.patsc.fallstudie;

import java.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

/**
 * Created by dominik on 30.12.2016.
 */

public class Marktsim {
   private int anzSpieler = 2; //ToDo kann aus Daten gezogen werden Damit kein Fehler mehr geworfen wird habe ich das jetzt mal auf den Wert 2 gesetzt
    private int AnzKäufer = anzSpieler * 8000;   // Abfrage der Spieleranzahl, mult. mit 8000   // TODO heißt die get-Methode so?
    private int lKäufer;                         //low-budget-Käufer
    private int hKäufer;                         //high-budget-Käufer
    private float highestp = 5;
    private float lowestp = 1500;       //Fickerzeile

    // ToDo Konstruktor
    /**
     * ToDo
     */
    public void berechnePreissegmente(){

        float middle = (highestp - lowestp) / 2;

        float l1 = lowestp + (1/4 * middle);                             //Preisklassen l1-3 und h1-3
        float l2 = lowestp + (1/2 * middle);                             // Enteilung in 1/3 Schritte, Verteilung Zufällig
        float l3 = lowestp + (3/3 * middle);
        float h1 = (lowestp + middle) + (1/4 * middle);
        float h2 = (lowestp + middle) + (1/2 * middle);
        float h3 = (lowestp + middle) + (3/3 * middle);

        float l1v,l2v,l3v,h1v,h2v,h3v;
        l1v = randInt(1,49);                         // Prozentuale Verteilung low budget
        l2v = randInt(1,49);
        l3v = (l1v - l2v);
       //ToDo
       // l1v = l1v/100 * lvertKäufer;                // Anzahl der low budget Käufer in den Preissegmenten
       // l2v = l2v/100 * lvertKäufer;
       // l3v = l3v/100 * lvertKäufer;

        h1v = randInt(1,49);                       // Prozentuale Verteilung high budget
        h2v = randInt(1,49);
        h3v = h1v - h2v;
        //ToDo
        // h1v = h1v /100 * hvertKäufer;              // Anzahl der high budget Käufer in den Preissegmenten
        // h2v = h2v /100 * hvertKäufer;
        // h3v = h3v /100 * hvertKäufer;
    } //Ende BerecheneOreissegmente

    public int berechneAbsatz(){

        int lverteilung = randInt(40,60);               //Verteilung low-zufall
        int hverteilung = 100 - lverteilung;            //Verteilung 100 Prozent - low-verteilung
        int lvertKäufer = lverteilung/100 * lKäufer;    // Berechnung Anzahl low-budget-Käufer
        int hvertKäufer = hverteilung/100 * hKäufer;    // Berechnung Anzahl low-budget-Käufer

        this.berechnePreissegmente();        // Verteilung der Käufer auf l1-3 und l1-3 zufällig

        return 2; //ToDo return berechne Absatz
    } // Ende berechneAbsatz

    /**
     * ToDo
     * @param min
     * @param max
     * @return
     */
    public static int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    /**
     * ToDo
     * @return
     */
    public int getlKäufer() {
        return lKäufer;
    }

    /**
     * ToDO
     * @return
     */
    public int gethKäufer() {
        return hKäufer;
    }

}
