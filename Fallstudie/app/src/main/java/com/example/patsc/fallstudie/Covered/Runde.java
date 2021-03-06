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
    public Runde(int RundenNr, Spieler spieler) {
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
    public void erhöheRundenNr() {
        RundenNr++;
        if (RundenNr > 10) {
            Controller.setZustand_Spielbeginn(true);
        }
    }
}




