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
 * Created by julian on 03.01.2017.
 */

@RunWith(Theories.class)
public class VersandArtTest {

    public static @DataPoints String[] VersandartWerte =
            {"Flugzeug", "Schiff", "Landweg"};

    @Theory
    public void bestelleVersandTest(String VersandartWerteWerte){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleVersandart(VersandartWerteWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test
    public void bestelleVersandsrtFailTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleVersandart("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

}
