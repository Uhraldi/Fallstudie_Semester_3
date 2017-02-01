package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller;

/**
 * Created by vince on 01/02/2017.
 */

public class empfangeSpielerThread implements Runnable {

    String id;
    String passwort;
    SpielerDatenWrapper ergebnis;
    Controller c;

    public empfangeSpielerThread(String id, String passwort, Controller c){
        this.id = id;
        this.passwort = passwort;
        this.c = c;
    }

    @Override
    public void run() {
        Funkturm f = new Funkturm();
        ergebnis = f.empfangeSpieler(id, passwort);
        c.setLogInThreadSDW(ergebnis);
    }
}
