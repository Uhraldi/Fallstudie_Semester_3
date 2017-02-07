package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class UpdateRunnable implements Runnable {

    SpielerDatenWrapper s;
    boolean ergebnis = false;
    Controller c;
    Funkturm f;

    public UpdateRunnable(SpielerDatenWrapper s, Funkturm f, Controller c){
        this.s = s;
        this.c = c;
        this.f = f;
    }

    @Override
    public void run() {
        ergebnis = f.updateSpieler(s);
        c.setUpdateBool(ergebnis);
    }
}
