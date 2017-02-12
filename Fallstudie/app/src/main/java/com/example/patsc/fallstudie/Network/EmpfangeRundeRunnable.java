package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class EmpfangeRundeRunnable implements Runnable {

    private int runde;
    private Controller c;
    private Funkturm f;

    /**
     * Konstruktor
     * @param runde Altuelle Rundenzahl
     * @param f Funkturm des Controllers
     * @param c Controller
     */
    public EmpfangeRundeRunnable(int runde, Controller c){
        this.runde = runde;
        this.c = c;
        f = c.getFunkturm();
    }

    @Override
    public void run() {
        RundenErgebnisWrapper[] ergebnis = f.empfangeRunde(runde);
        c.setRundenErgebnisREW(ergebnis);
    }
}
