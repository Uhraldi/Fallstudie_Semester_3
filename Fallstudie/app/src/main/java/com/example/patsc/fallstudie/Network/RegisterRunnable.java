package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller.Controller;

/**
 * @author Vincent Schmalor
 * Created by vince on 01/02/2017.
 * Threadumgebung zum mitgeben von Daten und Speicherung von Ergebnissen im Controller
 */

public class RegisterRunnable implements Runnable {

    private String id;
    private String passwort;
    private Controller c;
    private Funkturm f;

    /**
     * Konstruktor
     * @param id Name des Spielers
     * @param passwort Passwort des Spielers
     * @param c Controller
     */
    public RegisterRunnable(String id, String passwort, Controller c){
        this.id = id;
        this.passwort = passwort;
        this.c = c;
        f = c.getFunkturm();
    }

    @Override
    public void run() {
        boolean ergebnis = f.registriereSpieler(id, passwort);
        c.setRegistrierungBool(ergebnis);
    }
}
