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
public class ArmbandTest {

    public static @DataPoints
    String[] ArmbandWerte =
            {"Leder", "Kunstleder", "Holz", "Textil", "Metall"};

    @Theory
    public void bestelleArmbandTest(String ArmbandWerte){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleArmband(ArmbandWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test
    public void bestelleArmbandFailTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleArmband("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

}
