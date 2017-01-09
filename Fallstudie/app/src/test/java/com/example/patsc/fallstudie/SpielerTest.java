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

    Daten TestDaten = new Daten();
    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
    boolean thrown = false;

    @Test
    public void getNameTest(){
        Assert.assertTrue(TestSpieler.getName().equals("testname"));
    }

    @Test
    public void getPasswortTest(){
        Assert.assertTrue(TestSpieler.getPasswort().equals("testpasswort"));
    }

    @Test
    public void getStartguthabenTest(){
        Assert.assertTrue(TestSpieler.getGuthaben() == 10000);
    }

    @Test
    public void setGuthabenTest(){
        TestSpieler.setGuthaben(20000);
        Assert.assertTrue(TestSpieler.getGuthaben() == 20000);
    }

    @Test
    public void getStartmarktanteilTest(){
        Assert.assertTrue(TestSpieler.getMarktanteil() == 0);
    }

    /*
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
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

    @Test
    public void setMarktanteilZuGroßTest(){
        try{
            Daten TestDaten = new Daten();
            Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
            TestSpieler.setMarktanteil(110);
        }catch(Exception e){
           thrown = true;
        }
        Assert.assertTrue(thrown);
    }

    */

    @Test
    public void getStartpunkteTest(){
        Assert.assertTrue(TestSpieler.getPunkte()== 1000);
    }

    @Test
    public void setPunkteTest(){
        TestSpieler.setPunkte(10000);
        Assert.assertTrue(TestSpieler.getPunkte() == 10000);
    }

    @Test
    public void setPuntkeZuKleinTest(){
        try{
            TestSpieler.setPunkte(-3);
        }catch(Exception e){
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

}
