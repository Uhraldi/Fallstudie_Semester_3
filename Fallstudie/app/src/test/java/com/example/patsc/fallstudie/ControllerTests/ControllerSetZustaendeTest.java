package com.example.patsc.fallstudie.ControllerTests;

import com.example.patsc.fallstudie.Daten;
import com.example.patsc.fallstudie.Controller;
import com.example.patsc.fallstudie.Spieler;

import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * Created by julian on 07.01.2017.
 */

public class ControllerSetZustaendeTest {
    private Controller TestController = new Controller();
    private Daten TestDaten = TestController.getDaten();
    Spieler TestSpieler = new Spieler("testname", "testpasswort", TestDaten);


    private boolean Testpassed;

    public ControllerSetZustaendeTest() throws Exception {
    }

    private boolean isPassed(){
        return Testpassed;
    }

    private void setzteAlleZustaendeTrue(){
        TestController.setZustand_Lieferung(true);
        TestController.setZustand_Ereignis(true);
        TestController.setZustand_Ende(true);
        TestController.setZustand_Bestellung(true);
        TestController.setZustand_Spielbeginn(true);
       // System.err.println("Alle Zustaende auf True gesetzt");
    }

    private void setzteAlleSchritteTrue(){
        TestController.setSCHRITT_ARMBAND_boolean(true);
        TestController.setSCHRITT_FORSCHUNG_boolean(true);
        TestController.setSCHRITT_DICHTHEIT_boolean(true);
        TestController.setSCHRITT_GEHAUESE_boolean(true);
        TestController.setSCHRITT_PRODUKTIONSVOLUMEN_boolean(true);
        TestController.setSCHRITT_UHRWERK_boolean(true);
        TestController.setSCHRITT_VERKAUFSPREIS_boolean(true);
        TestController.setSCHRITT_BEZAHLART_boolean(true);
        TestController.setSCHRITT_MARKETING_boolean(true);
        TestController.setSCHRITT_ZEITARBEITER_boolean(true);
       // System.err.println("Alle Schritte auf True gesetzt");
    }
/*
    TestController.isZustand_Spielbeginn() == true &&
            TestController.isZustand_Bestellung() == false &&
            TestController.isZustand_Ende() == false &&
            TestController.isZustand_Ereignis() == false &&
            TestController.isZustand_Lieferung() == false)
*/
    @Test
    public void setActivity_Login(){
        setzteAlleZustaendeTrue();
        setzteAlleSchritteTrue();
        TestController.setActivity_Login();
        if (
                TestController.isZustand_Spielbeginn() &&
              //  TestController.isZustand_Bestellung() == false &&
                        !TestController.isZustand_Ende() &&
                        !TestController.isZustand_Ereignis() &&
                        !TestController.isZustand_Lieferung()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    Assert.assertTrue(isPassed());

    }

    @Test
    public void setActivity_E1Test(){

    }

    //ToDo Auftragssammlung richtig implementieren.
    @Test
    public void setActivity_E2Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_E2();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_ARMBAND_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E3Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_E3();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_UHRWERK_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E4Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_E4();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_GEHAUESE_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E5Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_E5();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_BEZAHLART_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E6Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_E6();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_DICHTHEIT_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_E7Test(){
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_E7();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_ZEITARBEITER_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }



}
