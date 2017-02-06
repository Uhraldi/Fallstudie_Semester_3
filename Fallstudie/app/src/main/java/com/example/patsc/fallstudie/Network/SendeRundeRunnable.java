package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Bestandteile.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class SendeRundeRunnable implements Runnable {

    RundenErgebnisWrapper rundenErgebnisWrapper;
    boolean ergebnis = false;
    Controller c;
    Funkturm f;

    public SendeRundeRunnable(RundenErgebnisWrapper rundenErgebnisWrapper, Funkturm f, Controller c){
        this.rundenErgebnisWrapper = rundenErgebnisWrapper;
        this.c = c;
        this.f = f;
    }

    @Override
    public void run() {
        ergebnis = f.sendeRunde(rundenErgebnisWrapper);
        c.setSendeRundeBool(ergebnis);
    }
}
