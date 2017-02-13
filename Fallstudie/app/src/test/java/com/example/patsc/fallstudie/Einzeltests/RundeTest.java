package com.example.patsc.fallstudie.Einzeltests;

import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Runde;
import com.example.patsc.fallstudie.Covered.Spieler;

import junit.framework.Assert;

import org.junit.Test;

/**
 Hier werden alle Methoden der Rundenklasse getestet.
 */

public class RundeTest {

    Controller TestController = new Controller();
    Daten TestDaten = TestController.getDaten();
    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
    int StartRunde = 1;
    Runde TestRunde = new Runde(StartRunde, TestSpieler);

    public RundeTest() throws Exception {
    }

    @Test
    public void erhoeheRundenNrTest(){
        int NeueRundenNr = StartRunde + 1;
        TestRunde.erhöheRundenNr();
        Assert.assertEquals(NeueRundenNr ,TestRunde.getRundenNr());
    }

    @Test
    public void erhoeheRundenNrUeber10Test(){
        int NeueRundenNr = StartRunde + 10;
        TestRunde.erhöheRundenNr();
    }

    @Test
    public void getSpielerTest(){
        TestRunde.getSpieler();
    }

}
