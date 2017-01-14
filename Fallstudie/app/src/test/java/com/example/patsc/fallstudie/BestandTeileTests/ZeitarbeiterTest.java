package com.example.patsc.fallstudie.BestandTeileTests;

import com.example.patsc.fallstudie.Auftrag;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.fail;

/**
 * Created by julia on 03.01.2017.
 */
@RunWith(Theories.class)
public class ZeitarbeiterTest {



    public static @DataPoints
    String[] ProduktionsOrtWerte =
            {"Geselle", "Praktikant", "Lehrling", "Meister"};

    @Theory
    public void bestelleZusammenbauTest(String ProduktionsOrtWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleZeitarbeiter(ProduktionsOrtWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Theory
    public void korrigiereZusammenbauTest(String ProduktionsOrtWerte){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleZeitarbeiter(ProduktionsOrtWerte);
            testAuftrag.korriegiereZeitarbeiter("Praktikant");
        }catch (Exception e){
            fail(e.getMessage());
        }
    }



    @Test
    public void bestelleZusammenbauFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleZeitarbeiter("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getZusammenbauTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleZeitarbeiter("Geselle");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(testAuftrag.getZusammenbau().isGeselle());
    }






}
