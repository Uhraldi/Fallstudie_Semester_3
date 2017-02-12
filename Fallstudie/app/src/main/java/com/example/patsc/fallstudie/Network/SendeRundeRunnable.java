package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class SendeRundeRunnable implements Runnable {

    private RundenErgebnisWrapper rundenErgebnisWrapper;
    private Controller c;
    private Funkturm f;

    /**
     * Konstruktor
     * @param rundenErgebnisWrapper An das Netzwerk zu senden der Wrapper
     * @param c Controller zum festlegen von Daten
     */
    public SendeRundeRunnable(RundenErgebnisWrapper rundenErgebnisWrapper, Controller c){
        this.rundenErgebnisWrapper = rundenErgebnisWrapper;
        this.c = c;
        f=c.getFunkturm();
    }

    @Override
    public void run() {
        boolean ergebnis = f.sendeRunde(rundenErgebnisWrapper);
        c.setSendeRundeBool(ergebnis);
    }
}
