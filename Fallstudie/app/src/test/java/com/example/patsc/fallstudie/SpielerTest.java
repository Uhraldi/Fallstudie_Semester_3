package com.example.patsc.fallstudie;


import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by julia on 31.12.2016.
 */

public class SpielerTest {

    @Test
    public void getNameTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        Assert.assertTrue(TestSpieler.getName().equals("testname"));
    }

    @Test
    public void getPasswortTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        Assert.assertTrue(TestSpieler.getPasswort().equals("testpasswort"));
    }

    @Test
    public void getStartguthabenTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        Assert.assertTrue(TestSpieler.getGuthaben() == 10000);
    }

    @Test
    public void setGuthabenTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        TestSpieler.setGuthaben(20000);
        Assert.assertTrue(TestSpieler.getGuthaben() == 20000);
    }

    @Test
    public void getStartmarktanteilTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        Assert.assertTrue(TestSpieler.getMarktanteil() == 0);
    }

    @Test
    public void setMarktanteilTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        TestSpieler.setMarktanteil(10);
        Assert.assertTrue(TestSpieler.getMarktanteil() == 10);
    }

    @Test
    public void setMarktanteilZuKleinTest(){
        try{
            Daten TestDaten = new Daten();
            Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        TestSpieler.setMarktanteil(-10);
        }catch(Exception e){
            String msg = "Marktanteil unter 0%";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void setMarktanteilZuGroßTest(){
        try{
            Daten TestDaten = new Daten();
            Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
            TestSpieler.setMarktanteil(110);
        }catch(Exception e){
            String msg = "Marktanteil über 100%";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getStartpunkteTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        Assert.assertTrue(TestSpieler.getPunkte()== 1000);
    }

    @Test
    public void setPunkteTest(){
        Daten TestDaten = new Daten();
        Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
        TestSpieler.setPunkte(10000);
        Assert.assertTrue(TestSpieler.getPunkte() == 10000);
    }

    @Test
    public void setPuntkeZuKleinTest(){
        try{
            Daten TestDaten = new Daten();
            Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
            TestSpieler.setPunkte(-3);
        }catch(Exception e){
            String msg = "Punkte kleiner als 0, automatisch auf 0 gesetzt";
            assertEquals(msg, e.getMessage());
        }
    }

}
