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
 * Created by julia on 03.01.2017.
 */
@RunWith(Theories.class)
public class ForschungTest {

    public static @DataPoints
    String[] DesignerWerte =
            {"2500€ Investition", "8000€ Investition", "15000€ Investition"};


    @Theory
    public void bestelleDesignerTest(String DesignerWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleForschung(DesignerWerte);
        }catch (Exception e){
            fail("Fehler bei Variable: "+ DesignerWerte );
        }
    }

    @Test
    public void bestelleDesignerFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleForschung("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getDesignerTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleForschung("2500€ Investition");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(testAuftrag.getForschung().isInvestition2500());

    }

}
