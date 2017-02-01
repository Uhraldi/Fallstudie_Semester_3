package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller;

/**
 * Created by vince on 01/02/2017.
 */

public class MyThread implements Runnable {

    String id;
    String passwort;
    boolean ergebnis = false;
    Controller c;

    public MyThread(String id, String passwort, Controller c){
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

    public boolean getErgebnis(){
        return ergebnis;
    }

}
