package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class RegisterThread implements Runnable {

    String id;
    String passwort;
    boolean ergebnis = false;
    Controller c;

    public RegisterThread(String id, String passwort, Controller c){
        this.id = id;
        this.passwort = passwort;
        this.c = c;
    }

    @Override
    public void run() {
        Funkturm f = new Funkturm();
        ergebnis = f.registriereSpieler(id, passwort);
        c.setRegistrierungBool(ergebnis);
    }
}
