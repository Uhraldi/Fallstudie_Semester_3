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
public class GehaeuseTest {

    public static @DataPoints
    String[] GehaeuseWerte =
            {"Glas", "Kunststoff", "Holz", "Metall"};


    @Theory
    public void bestelleGehauseTest(String GehaeuseWerte){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleGehaeuse(GehaeuseWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test
    public void bestelleGehaeuseFailTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleGehaeuse("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getGehaeuseTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try{
            TestBestellposition.bestelleGehaeuse("Glas");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(TestBestellposition.getGehaeuse().isGlas());

    }


}
