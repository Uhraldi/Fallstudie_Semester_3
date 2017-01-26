package com.example.patsc.fallstudie.ControllerTests.ControllerSetBestandteile;

import com.example.patsc.fallstudie.Controller;

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

    public static @DataPoints
    String[] DesignerWerte =
            {"Marken", "Mittelmäßig", "LowBudget"};
    Controller TestController = new Controller();
    boolean thrown = false;

    @Theory
    public void setDesignerTest(String DesignerWerte){
        try {
            TestController.setSCHRITT_FORSCHUNG_boolean(true);
            TestController.setForschungAktuell("1000€ Investition");
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
