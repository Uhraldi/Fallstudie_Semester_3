package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Bestandteile.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class EmpfangeSpielerRunnable implements Runnable {

    String id;
    String passwort;
    SpielerDatenWrapper ergebnis;
    Controller c;
    Funkturm f;

    public EmpfangeSpielerRunnable(String id, String passwort, Funkturm f, Controller c){
        this.id = id;
        this.passwort = passwort;
        this.c = c;
        this.f = f;
    }

    @Override
    public void run() {
        ergebnis = f.empfangeSpieler(id, passwort);
        c.setEmpfangeSpielerSDW(ergebnis);
    }
}
