package com.example.patsc.fallstudie;

import com.example.patsc.fallstudie.Spieler;

/**
 * Created by Jonas on 01.01.17.
 */

public class Runde {

    private int RundenNr; // Welche Runde gerade gespielt wird
    private Spieler spieler; // Spieler, der die Runde spielt

    /*
    Konstruktor für die Runde
     */
    public Runde (int RundenNr, Spieler spieler) {
        this.RundenNr = RundenNr;
        this.spieler = spieler;
    }
    public int getRundenNr() {
        return RundenNr;
    }

    public Spieler getSpieler() {
        return spieler;
    }

    public void erhöheRundenNr () {
        RundenNr++;
    } // ToDo Prüfung einfügen

    /*public void beendeRunde() {
        // ToDo

    }*/

    /*
    public void setRundenNr(int rundenNr) {
        try {
            if (rundenNr <= 1) {
                rundenNr = 1;
                erhöheRundenNr();
            }
            if (RundenNr > 10) {
                zeigeHighscoreListe();
            }
            throw new Exception("Alle Runden sind durchlaufen!");
        }
        catch (Exception e) {
            System.err.println (e);
        }
    }

    *///ToDo überflüssig?

    public void zeigeHighscoreListe() {//ToDo Runde prüfen, nicht über 10.
        try {
            if (RundenNr > 10) {
                starteNeueRunde(RundenNr);
            }
            throw new Exception("Spieler sieht Highscore Liste und die Runde ist beendet!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    public void starteNeueRunde(int rundenNr) {
        rundenNr = 1;
    }


}
