package com.example.patsc.fallstudie.BestellpositionTests;

import com.example.patsc.fallstudie.Bestellposition;

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
public class ZusammenbauTest {


    public static @DataPoints
    String[] ProduktionsOrtWerte =
            {"Deutschland", "Asien", "Osteuropa", "Schweiz"};

    @Theory
    public void bestelleZusammenbauTest(String ProduktionsOrtWerte){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleZusamenbau(ProduktionsOrtWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Theory
    public void korrigiereZusammenbauTest(String ProduktionsOrtWerte){
        Bestellposition TestBestellposition = new Bestellposition();
        try{
            TestBestellposition.bestelleZusamenbau(ProduktionsOrtWerte);
            TestBestellposition.korrigiereZusammenbau("Asien");
        }catch (Exception e){
            fail(e.getMessage());
        }
    }

    @Test
    public void bestelleZusammenbauFailTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleZusamenbau("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getZusammenbauTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try{
            TestBestellposition.bestelleZusamenbau("Deutschland");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(TestBestellposition.getZusammenbau().isDeutschland());
    }





}
