package com.example.patsc.fallstudie.BestellpositionTests;

import com.example.patsc.fallstudie.Bestellposition;
import com.example.patsc.fallstudie.FalscheEingabe;

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
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleWerbung(WerbungWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test
    public void bestelleWerbungFailTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleWerbung("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

}
