package com.example.patsc.fallstudie;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by julia on 09.01.2017.
 */

public class RundeTest {

    Daten TestDaten = new Daten();
    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
    int StartRunde = 1;
    Runde TestRunde = new Runde(StartRunde, TestSpieler);

    @Test
    public void erhoeheRundenNrTest(){
        int NeueRundenNr = StartRunde + 1;
        TestRunde.erhöheRundenNr();
        Assert.assertEquals(NeueRundenNr ,TestRunde.getRundenNr());
    }

    @Test
    public void setRundenNrTest() {
        int NeueRundenNr = 3;
        TestRunde.setRundenNr(3);
        Assert.assertEquals(NeueRundenNr, TestRunde.getRundenNr());
    }

}
