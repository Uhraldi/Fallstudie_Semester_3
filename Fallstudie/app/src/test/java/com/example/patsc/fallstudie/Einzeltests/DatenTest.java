package com.example.patsc.fallstudie.Einzeltests;

import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Spieler;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 In dieser Klasse werden die Methoden der Daten-Klasse getestet.
 -  Konstruktor
 -  Das setzten und erhöhen der Spieleranzahl
 -  Das hinzufügen eines Spieler in die Spielerliste mit Fehlschlag
 -  Das Ausgeben der Rundenanzahl
 */

public class DatenTest {

    public DatenTest() throws Exception {
    }
        Controller TestController = new Controller();
        Daten TestDaten = TestController.getDaten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        boolean ispassed = false;




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
        TestSpieler = null;
        try {
            TestDaten.addSpielerListe(TestSpieler);
        }catch (Exception e){
            ispassed = true;
        }

        Assert.assertTrue(ispassed);
    }

    @Test
    public void getRundenanzahlTest(){
        TestDaten.getRundenAnzahl();
    }



}
