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
public class WasserdichtheitsTest {

    public static @DataPoints
    String[] WasserdichtheitWerte =
            {"Nicht Wassergeschützt", "Spritzwassergeschützt", "Wasserdicht"};

    @Theory
    public void bestelleWasserdichtheitTest(String WasserdichtheitWerte){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleWasserdichtheit(WasserdichtheitWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test
    public void bestelleWasserdichtheitFailTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleWasserdichtheit("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getWasserdichtheitsFailTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try{
            TestBestellposition.bestelleWasserdichtheit("Nicht Wassergeschützt");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(TestBestellposition.getWasserdichtheit().isNichtWassergeschützt());

    }

}
