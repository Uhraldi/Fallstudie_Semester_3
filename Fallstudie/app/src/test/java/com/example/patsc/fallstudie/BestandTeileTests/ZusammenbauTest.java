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
public class ZusammenbauTest {



    public static @DataPoints
    String[] ProduktionsOrtWerte =
            {"Deutschland", "Asien", "Osteuropa", "Schweiz"};

    @Theory
    public void bestelleZusammenbauTest(String ProduktionsOrtWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleZusamenbau(ProduktionsOrtWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Theory
    public void korrigiereZusammenbauTest(String ProduktionsOrtWerte){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleZusamenbau(ProduktionsOrtWerte);
            testAuftrag.korrigiereZusammenbau("Asien");
        }catch (Exception e){
            fail(e.getMessage());
        }
    }



    @Test
    public void bestelleZusammenbauFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleZusamenbau("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getZusammenbauTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleZusamenbau("Deutschland");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(testAuftrag.getZusammenbau().isDeutschland());
    }






}
