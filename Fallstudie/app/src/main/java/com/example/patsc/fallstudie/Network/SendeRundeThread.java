package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Controller;

/**
 * Created by vince on 01/02/2017.
 */

public class SendeRundeThread implements Runnable {

    RundenErgebnisWrapper rundenErgebnisWrapper;
    boolean ergebnis = false;
    Controller c;

    public SendeRundeThread(RundenErgebnisWrapper rundenErgebnisWrapper, Controller c){
        this.rundenErgebnisWrapper = rundenErgebnisWrapper;
        this.c = c;
    }

    @Override
    public void run() {
        Funkturm f = new Funkturm();
        ergebnis = f.sendeRunde(rundenErgebnisWrapper);
        c.setSendeRundeBool(ergebnis);
    }
}
