package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller;

/**
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class EmpfangeRundeThread implements Runnable {

    int runde;
    RundenErgebnisWrapper[] ergebnis;
    Controller c;

    public EmpfangeRundeThread(int runde, Controller c){
        this.runde = runde;
        this.c = c;
    }

    @Override
    public void run() {
        Funkturm f = new Funkturm();
        ergebnis = f.empfangeRunde(runde);
        c.setRundenErgebnisREW(ergebnis);
    }
}
