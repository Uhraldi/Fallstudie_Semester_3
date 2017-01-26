package com.example.patsc.fallstudie.BestandTeileTests;

import com.example.patsc.fallstudie.Covered.Auftrag;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.Assert.fail;

/**
 * Created by julian on 03.01.2017.
 */

@RunWith(Theories.class)
public class ZeitarbeiterTest {

    public static @DataPoints String[] ZeitarbeiterWerte =
            {"Geselle", "Praktikant", "Lehrling","Meister"};

    @Theory
    public void bestelleVersandTest(String ZeitarbeiterWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleZeitarbeiter(ZeitarbeiterWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test
    public void bestelleVersandsrtFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleZeitarbeiter("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getVersandArtTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleZeitarbeiter("Geselle");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(testAuftrag.getZeitarbeiter().isGeselle());

    }

}
