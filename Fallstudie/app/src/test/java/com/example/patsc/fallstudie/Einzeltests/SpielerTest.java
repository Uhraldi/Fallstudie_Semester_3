package com.example.patsc.fallstudie.Einzeltests;


import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Spieler;

import junit.framework.Assert;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 Hier werden alle Methoden der Spielerklasse getestet
 -  diverse Getter und Setter-Methoden
 */

public class SpielerTest {

    Controller TC = new Controller();
    Daten TestDaten = TC.getDaten();
    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
    boolean thrown = false;

    public SpielerTest() throws Exception {
    }

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
        Assert.assertTrue(TestSpieler.getGuthaben() == 150000);
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


    @Test
    public void setMarktanteilTest(){
        Spieler TestSpieler = null;
        try {
            TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
            TestSpieler.setMarktanteil(10);
        } catch (Exception e) {
            fail();
        }
        Assert.assertTrue(TestSpieler.getMarktanteil() == 10);
    }

    @Test
    public void setMarktanteilZuKleinTest(){
        try{
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
            Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);
            TestSpieler.setMarktanteil(110);
        }catch(Exception e){
           thrown = true;
        }
        Assert.assertTrue(thrown);
    }



    @Test
    public void getStartpunkteTest(){
        Assert.assertTrue(TestSpieler.getPunkte()== 1000);
    }

    @Test
    public void setPunkteTest(){
        try {
            TestSpieler.setPunkte(10000);
        } catch (Exception e) {
            fail(e.getMessage());
        }
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
