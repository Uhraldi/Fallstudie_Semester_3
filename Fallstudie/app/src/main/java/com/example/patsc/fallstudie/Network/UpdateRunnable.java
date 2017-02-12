package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class UpdateRunnable implements Runnable {

    private SpielerDatenWrapper s;
    private Controller c;
    private Funkturm f;

    /**
     * Konstruktor
     * @param s Datenwrapper des Spielers
     * @param c Controller zum festlegen eines Wertes
     */
    public UpdateRunnable(SpielerDatenWrapper s, Controller c){
        this.s = s;
        this.c = c;
        f=c.getFunkturm();
    }

    @Override
    public void run() {
        boolean ergebnis = f.updateSpieler(s);
        c.setUpdateBool(ergebnis);
    }
}
