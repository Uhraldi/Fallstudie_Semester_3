package com.example.patsc.fallstudie.BestandTeileTests;

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
public class DesignerTest {

    public static @DataPoints
    String[] DesignerWerte =
            {"Marken", "Mittelmäßig", "LowBudget"};


    @Theory
    public void bestelleDesignerTest(String DesignerWerte){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleDesigner(DesignerWerte);
        }catch (Exception e){
            fail("Fehler bei Variable: "+ DesignerWerte );
        }
    }

    @Test
    public void bestelleDesignerFailTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try {
            TestBestellposition.bestelleDesigner("FAIL");
        }catch (Exception e){
            String msg = "Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein";
            Assert.assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void getDesignerTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try{
            TestBestellposition.bestelleDesigner("Marken");
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertTrue(TestBestellposition.getDesigner().isMarken());

    }

}
