package com.example.patsc.fallstudie.ModelTests;

import com.example.patsc.fallstudie.Daten;
import com.example.patsc.fallstudie.Model;
import com.example.patsc.fallstudie.Spieler;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * Created by julia on 07.01.2017.
 */

public class SetZustaendeTest {
    Model TestModel = new Model();
    Daten TestDaten = TestModel.getDaten();
    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);


    public boolean Testpassed;
    public boolean isPassed(){
        return Testpassed;
    }

    @Test
    public void setZustandSpielbeginnTest(){
        TestModel.setZustand_Lieferung(true);
        TestModel.setZustand_Ereignis(true);
        TestModel.setZustand_Ende(true);
        TestModel.setZustand_Bestellung(true);
        TestModel.setZustand_Spielbeginn(true);
        if (
                TestModel.isZustand_Spielbeginn() == true &&
                TestModel.isZustand_Bestellung() == false &&
                TestModel.isZustand_Ende() == false &&
                TestModel.isZustand_Ereignis() == false &&
                TestModel.isZustand_Lieferung() == false){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    assertTrue(isPassed());

    }


}
