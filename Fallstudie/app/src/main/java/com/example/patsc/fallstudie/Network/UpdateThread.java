package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class UpdateThread implements Runnable {

    SpielerDatenWrapper s;
    boolean ergebnis = false;
    Controller c;

    public UpdateThread(SpielerDatenWrapper s, Controller c){
        this.s = s;
        this.c = c;
    }

    @Override
    public void run() {
        Funkturm f = new Funkturm();
        ergebnis = f.updateSpieler(s);
        c.setUpdateBool(ergebnis);
    }
}
