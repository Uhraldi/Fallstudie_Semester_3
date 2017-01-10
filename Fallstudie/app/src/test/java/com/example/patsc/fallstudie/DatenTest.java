package com.example.patsc.fallstudie;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by julia on 03.01.2017.
 */

public class DatenTest {

    Daten TestDaten = new Daten();

    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);

    public DatenTest() throws Exception {
    }

    @Test
    public void SpielerAnzahlTest(){
        TestDaten.setSpielerAnzahl(3);
        Assert.assertEquals(3,TestDaten.getSpielerAnzahl());

    }

    @Test
    public void SpielerAnzahlErhöhenTest(){
        TestDaten.setSpielerAnzahl(3);
        TestDaten.erhöheSpielerAnzahl();
        Assert.assertEquals(4,TestDaten.getSpielerAnzahl());

    }

    @Test
    public void addSpielerListeTest(){
        try {
            TestDaten.addSpielerListe(TestSpieler);
        }catch (Exception e){
            fail("Fehler geworfen");
        }
    }

    @Test
    public void addSpielerListeFailTest(){
        Daten TestDaten = new Daten();
        TestSpieler = null;

    }



}
