package com.example.patsc.fallstudie.Einzeltests.ControllerTests;

import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Spieler;

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
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleZustaendeTrue();
        setzteAlleSchritteTrue();
        TestController.setActivity_Login();
        if (    TestController.isZustand_Spielbeginn() &&
                !TestController.isSCHRITT_MARKETING_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    Assert.assertTrue(isPassed());
    }

    @Test
    public void EingestellteTest(){
        TestController.setAktiverSpieler(TestSpieler);
        TestController.getEingestellteGesamt();
        TestController.keineVeraenderung();
        TestController.setActivity_Rundenergebnis();
        TestController.setActivity_Personalwesen();
        TestController.setActivity_Forschung();
    }


    @Test
    public void setActivity_ArmbandTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Armband();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_ARMBAND_boolean()){
            Testpassed = true;

        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_UhrwerkTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Uhrwerk();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_UHRWERK_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_GehauseTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Gehaeuse();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_GEHAUESE_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_BezahlartTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Bezahlart();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_BEZAHLART_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_ZeitarbeiterTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Zeitarbeiter();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_ZEITARBEITER_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_ProduktionsvolumenTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Produktionsvolumen();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_PRODUKTIONSVOLUMEN_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_MarketingTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Marketing();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_MARKETING_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_VerkaufsPreisTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Verkaufspreis();
        if (
                TestController.isZustand_Bestellung() &&
                        TestController.isSCHRITT_VERKAUFSPREIS_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_BestellzusammenfassungTest(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Bestellzusammenfassung();
        if (
                TestController.isZustand_Bestellung()){
            Testpassed = true;
        }else{
            System.err.println(TestController.isZustand_Bestellung());
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_Z1Test(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Z1();
        if (
                TestController.isZustand_Ereignis() &&
                        TestController.isAENDERE_ARMBAND_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }

    @Test
    public void setActivity_Z2Test(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Z2();
        if (
                TestController.isZustand_Ereignis() &&
                        TestController.isAENDERE_GEHAEUSE_boolean()){
            Testpassed = true;
        }else{
            fail("FEHLER");

        }
    }

    @Test
    public void setActivity_Z3Test(){
        TestController.aktiverSpieler = TestSpieler;
        setzteAlleSchritteTrue();
        setzteAlleZustaendeTrue();
        TestController.setActivity_Z3();
        if (
                TestController.isZustand_Ereignis() &&
                        TestController.isAENDERE_ZEITARBEITER_boolean()){
            Testpassed = true;
        }else{
            fail("Mehr als ein Zustand true");
        }
    }



}
