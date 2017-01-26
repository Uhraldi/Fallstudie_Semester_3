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
 * Created by julia on 03.01.2017.
 */

@RunWith(Theories.class)
public class UhrwerkTest {
    public static @DataPoints
    String[] UhrwerkWerte =
            {"Mechanisch", "Elektromechanisch", "Elektronisch"};


    @Theory
    public void bestelleUhrwerkTest(String UhrwerkWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleUhrwerk(UhrwerkWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test public void bestelleUhrwerkFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleUhrwerk("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getUhrwerktTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleUhrwerk("Mechanisch");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(testAuftrag.getUhrwerk().isMechanisch());
    }


}
