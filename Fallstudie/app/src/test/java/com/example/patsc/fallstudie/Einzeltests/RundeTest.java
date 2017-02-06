package com.example.patsc.fallstudie.Einzeltests;

import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Runde;
import com.example.patsc.fallstudie.Covered.Spieler;

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

}
