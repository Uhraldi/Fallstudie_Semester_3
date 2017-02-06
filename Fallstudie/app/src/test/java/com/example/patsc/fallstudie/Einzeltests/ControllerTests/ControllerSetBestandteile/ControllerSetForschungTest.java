package com.example.patsc.fallstudie.Einzeltests.ControllerTests.ControllerSetBestandteile;

import com.example.patsc.fallstudie.Covered.Bestandteile.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Spieler;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.fail;

/**
 * Created by julia on 09.01.2017.
 */

@RunWith(Theories.class)
public class ControllerSetForschungTest {

    public ControllerSetForschungTest() throws Exception {
    }

    public static @DataPoints
    String[] ForschungsWerte =
            {"2500€ Investition", "8000€ Investition", "15000€ Investition"};
    Controller TestController = new Controller();
    boolean thrown = false;
    Daten TestDaten = new Daten();
    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);



    @Theory
    public void setDesignerTest(String ForschungsWerte){
        TestController.aktiverSpieler = TestSpieler;
        try {
            TestController.setSCHRITT_FORSCHUNG_boolean(true);
            TestController.setForschungAktuell(ForschungsWerte);
        }catch (Exception e){
            e.printStackTrace();
            fail();
            }
        }

    @Test
    public void setDesignerFailTest(){
        try {
            TestController.setForschungAktuell("Falsche Eingabe");
        }catch(Exception e){
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

}
