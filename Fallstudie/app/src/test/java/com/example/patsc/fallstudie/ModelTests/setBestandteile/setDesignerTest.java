package com.example.patsc.fallstudie.ModelTests.setBestandteile;

import com.example.patsc.fallstudie.Model;

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
public class setDesignerTest {

    public static @DataPoints
    String[] DesignerWerte =
            {"Marken", "Mittelmäßig", "LowBudget"};
    Model TestModel = new Model();
    boolean thrown = false;

    @Theory
    public void setDesignerTest(String DesignerWerte){
        try {
            TestModel.setSCHRITT_DESIGNER_boolean(true);
            TestModel.setDesigner(DesignerWerte);
        }catch (Exception e){
            e.printStackTrace();
            fail();
            }
        }

    @Test
    public void setDesignerFailTest(){
        try {
            TestModel.setDesigner("Falsche Eingabe");
        }catch(Exception e){
            thrown = true;
        }
        Assert.assertTrue(thrown);
    }

}
