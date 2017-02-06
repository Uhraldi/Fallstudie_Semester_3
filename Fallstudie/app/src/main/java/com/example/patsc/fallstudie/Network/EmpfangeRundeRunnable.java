package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Bestandteile.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class EmpfangeRundeRunnable implements Runnable {

    int runde;
    RundenErgebnisWrapper[] ergebnis;
    Controller c;
    Funkturm f;

    public EmpfangeRundeRunnable(int runde, Funkturm f, Controller c){
        this.runde = runde;
        this.c = c;
        this.f = f;
    }

    @Override
    public void run() {
        ergebnis = f.empfangeRunde(runde);
        c.setRundenErgebnisREW(ergebnis);
    }
}
