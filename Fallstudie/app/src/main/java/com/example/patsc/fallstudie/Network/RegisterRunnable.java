package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class RegisterRunnable implements Runnable {

    String id;
    String passwort;
    boolean ergebnis = false;
    Controller c;
    Funkturm f;

    public RegisterRunnable(String id, String passwort, Funkturm f, Controller c){
        this.id = id;
        this.passwort = passwort;
        this.c = c;
        this.f = f;
    }

    @Override
    public void run() {
        ergebnis = f.registriereSpieler(id, passwort);
        c.setRegistrierungBool(ergebnis);
    }
}
