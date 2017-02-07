package com.example.patsc.fallstudie.Covered;

/**
 * Created by Jonas on 01.01.17.
 */

public class Runde {

    private int RundenNr; // Welche Runde gerade gespielt wird
    private Spieler spieler; // Spieler, der die Runde spielt
    private com.example.patsc.fallstudie.Covered.Controller.Controller Controller;

    /*
    Konstruktor für die Runde
     */
    public Runde (int RundenNr, Spieler spieler) {
        this.RundenNr = RundenNr;
        this.spieler = spieler;
    }

    // Getter-Methoden
    public int getRundenNr() {
        return RundenNr;
    }
    public Spieler getSpieler() {
        return spieler;
    }

    // Methode, um die Rundennummer zu erhöhen
    public void erhöheRundenNr () {
        RundenNr++;
        if (RundenNr > 10) {
            zeigeHighscoreListe();
            Controller.setZustand_Spielbeginn(true);
        }
    } //

    /*public void beendeRunde() {


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

    public void zeigeHighscoreListe() { // Übergang zur Highscore Liste
        try {
            if (RundenNr > 10) {    // Prüfung, ob mehr als 10 Runden vorhanden sind
                starteNeueRunde(); // Übergang zum Beginn einer neuen Runde
            }
            throw new Exception("Spieler sieht Highscore Liste und die Runde ist beendet!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    public void starteNeueRunde() { // Methode, um eine neue Runde zu beginnen
        erhöheRundenNr();
    }


}
