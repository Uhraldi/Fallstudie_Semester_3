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
 * Created by julian on 07.01.2017.
 */

public class ModelSetZustaendeTest {
    private Model TestModel = new Model();
    private Daten TestDaten = TestModel.getDaten();
    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);


    private boolean Testpassed;

    public ModelSetZustaendeTest() throws Exception {
    }

    private boolean isPassed(){
        return Testpassed;
    }

    private void setzteAlleZustaendeTrue(){
        TestModel.setZustand_Lieferung(true);
        TestModel.setZustand_Ereignis(true);
        TestModel.setZustand_Ende(true);
        TestModel.setZustand_Bestellung(true);
        TestModel.setZustand_Spielbeginn(true);
       // System.err.println("Alle Zustaende auf True gesetzt");
    }

    private void setzteAlleSchritteTrue(){
        TestModel.setSCHRITT_ARMBAND_boolean(true);
        TestModel.setSCHRITT_DESIGNER_boolean(true);
        TestModel.setSCHRITT_DICHTHEIT_boolean(true);
        TestModel.setSCHRITT_GEHAUESE_boolean(true);
        TestModel.setSCHRITT_KAUFVOLUMEN_boolean(true);
        TestModel.setSCHRITT_UHRWERK_boolean(true);
        TestModel.setSCHRITT_VERKAUFSPREIS_boolean(true);
        TestModel.setSCHRITT_VERSANDART_boolean(true);
        TestModel.setSCHRITT_WERBUNG_boolean(true);
        TestModel.setSCHRITT_ZUSAMMENBAU_boolean(true);
       // System.err.println("Alle Schritte auf True gesetzt");
    }
/*
    TestModel.isZustand_Spielbeginn() == true &&
            TestModel.isZustand_Bestellung() == false &&
            TestModel.isZustand_Ende() == false &&
            TestModel.isZustand_Ereignis() == false &&
            TestModel.isZustand_Lieferung() == false)
*/
    @Test
    public void setActivity_Login(){
        setzteAlleZustaendeTrue();
        setzteAlleSchritteTrue();
        TestModel.setActivity_Login();
        if (
                TestModel.isZustand_Spielbeginn() &&
              //  TestModel.isZustand_Bestellung() == false &&
                        !TestModel.isZustand_Ende() &&
                        !TestModel.isZustand_Ereignis() &&
                        !TestModel.isZustand_Lieferung()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    Assert.assertTrue(isPassed());

    }

    @Test
    public void setActivity_E1Test(){

    }

    //ToDo Bestellung richtig implementieren.
    @Test
    public void setActivity_E2Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestModel.setActivity_E2();
        if (
                TestModel.isZustand_Bestellung() &&
                        TestModel.isSCHRITT_ARMBAND_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E3Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestModel.setActivity_E3();
        if (
                TestModel.isZustand_Bestellung() &&
                        TestModel.isSCHRITT_UHRWERK_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E4Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestModel.setActivity_E4();
        if (
                TestModel.isZustand_Bestellung() &&
                        TestModel.isSCHRITT_GEHAUESE_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E5Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestModel.setActivity_E5();
        if (
                TestModel.isZustand_Bestellung() &&
                        TestModel.isSCHRITT_VERSANDART_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E6Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestModel.setActivity_E6();
        if (
                TestModel.isZustand_Bestellung() &&
                        TestModel.isSCHRITT_DICHTHEIT_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E7Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestModel.setActivity_E7();
        if (
                TestModel.isZustand_Bestellung() &&
                        TestModel.isSCHRITT_ZUSAMMENBAU_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }



}
