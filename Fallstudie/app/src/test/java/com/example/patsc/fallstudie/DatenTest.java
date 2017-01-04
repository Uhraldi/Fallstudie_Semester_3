package com.example.patsc.fallstudie;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by julia on 03.01.2017.
 */

public class DatenTest {


    @Test
    public void SpielerAnzahlTest(){
        Daten TestDaten = new Daten();
        TestDaten.setSpielerAnzahl(3);
        Assert.assertEquals(3,TestDaten.getSpielerAnzahl());

    }

    @Test
    public void SpielerAnzahlErhöhenTest(){
        Daten TestDaten = new Daten();
        TestDaten.setSpielerAnzahl(3);
        TestDaten.erhöheSpielerAnzahl();
        Assert.assertEquals(4,TestDaten.getSpielerAnzahl());

    }

    @Test
    public void addSpielerListeTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        try {
            TestDaten.addSpielerListe(TestSpieler);
        }catch (Exception e){
            fail("Fehler geworfen");
        }
    }

    @Test
    public void addSpielerListeFailTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = null;
        try {
            TestDaten.addSpielerListe(TestSpieler);
        }catch (Exception e){
            String msg = "Spieler == null";
            assertEquals(msg, e.getMessage());
        }
    }



}
