package com.example.patsc.fallstudie.BestandTeileTests;

import com.example.patsc.fallstudie.Auftrag;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.Assert.fail;

/**
 * Created by julia on 03.01.2017.
 */
@RunWith(Theories.class)
public class WerbungTest {

    public static @DataPoints
    String[] WerbungWerte =
            {"viel", "mittel", "wenig"};


    @Theory
    public void bestelleWerbungTest(String WerbungWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleWerbung(WerbungWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test
    public void bestelleWerbungFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleWerbung("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getWerbungTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleWerbung("viel");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(testAuftrag.getWerbung().isViel());
    }

}
