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
public class GehaeuseTest {

    public static @DataPoints
    String[] GehaeuseWerte =
            {"Glas", "Kunststoff", "Holz", "Metall"};


    @Theory
    public void bestelleGehauseTest(String GehaeuseWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleGehaeuse(GehaeuseWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }


    @Theory
    public void GehaeuseKorrekturTest(String GehaeuseWerte){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleGehaeuse(GehaeuseWerte);
            testAuftrag.korrigiereGehaeuse("Glas");
        }catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void GehausekorrekturFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleGehaeuse("Glas");
            testAuftrag.korrigiereGehaeuse("FAIL");
        } catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void bestelleGehaeuseFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleGehaeuse("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getGehaeuseTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleGehaeuse("Glas");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(testAuftrag.getGehaeuse().isGlas());

    }


}
