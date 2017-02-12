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
 Hier werden die Methoden der Armbandklassen getestet.
 Dazu gehört das bestellen und korriegieren sowie das Fehlschlagen.
 */

@RunWith(Theories.class)
public class ArmbandTest {

    public static @DataPoints
    String[] ArmbandWerte =
            {"Leder", "Kunstleder", "Holz", "Textil", "Metall"};


    @Theory
    public void bestelleArmbandTest(String ArmbandWerte){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleArmband(ArmbandWerte);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }



    @Theory
    public void ArmbandkorrekturTest(String ArmbandWerte){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleArmband(ArmbandWerte);
            testAuftrag.korrigiereArmband("Leder");
        }catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void ArmbandkorrekturFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleArmband("Leder");
            testAuftrag.korrigiereArmband("FAIL");
        }catch (Exception e) {
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }



    @Test
    public void bestelleArmbandFailTest(){
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleArmband("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getArmbandTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleArmband("Leder");
        }catch (Exception e){
            fail(e.getMessage());
        }

        Assert.assertTrue(testAuftrag.getArmband().isLeder());

    }

}
