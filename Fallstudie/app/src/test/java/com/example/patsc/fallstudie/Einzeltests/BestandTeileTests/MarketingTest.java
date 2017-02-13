package com.example.patsc.fallstudie.Einzeltests.BestandTeileTests;

import com.example.patsc.fallstudie.Covered.Auftrag;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.Assert.fail;
/**
 Hier werden die Methoden der Marketingklasse getestet.
 Dazu gehört das bestellen sowie das Fehlschlagen.
 */
@RunWith(Theories.class)
public class MarketingTest {

    public static @DataPoints
    String[] WerbungWerte =
            {"Fernsehwerbung", "Radiowerbung", "Printwerbung"};


    @Theory
    public void bestelleWerbungTest(String WerbungWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleWerbung(WerbungWerte);
        }catch (Exception e){
            fail("Sollte kein Fehler werfen");
        }
    }

    @Test
    public void bestelleWerbungFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleWerbung("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getWerbungTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleWerbung("Fernsehwerbung");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(testAuftrag.getMarketing().isFernsehwerbung());
    }

}
