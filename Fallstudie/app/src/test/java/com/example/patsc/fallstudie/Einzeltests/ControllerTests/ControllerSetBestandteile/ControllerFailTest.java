package com.example.patsc.fallstudie.Einzeltests.ControllerTests.ControllerSetBestandteile;

import com.example.patsc.fallstudie.Covered.Bestandteile.Zeitarbeiter;
import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Spieler;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by julian on 13.02.2017.
 */

public class ControllerFailTest {


    private static String WORTFAIL = "Syntax Fehler; Falsches Wort uebergeben";
    private static String SCHRITTFAIL= "Falscher Bestellschritt";
    Controller C = new Controller();
    Spieler S = new Spieler("test", "test", C.getDaten());
    boolean thrown = false;

    public ControllerFailTest() throws Exception {
    }


    @Test
    public void SetZeitarbeiterFailEingabeTest(){
        try {
            C.setAktiverSpieler(S);
            C.setSCHRITT_ZEITARBEITER_boolean(true);
            C.setZeitarbeiterAktuell("FAIL");
            C.setZeitarbeiterNeu("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),WORTFAIL);
        }
    }

    @Test
    public void SetZeitarbeiterFailSchrittTest(){
        try {
            C.setAktiverSpieler(S);
           // C.setSCHRITT_ZEITARBEITER_boolean(true);
            C.setZeitarbeiterAktuell("FAIL");
            C.setZeitarbeiterNeu("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),SCHRITTFAIL);
        }
    }

    @Test
    public void SetArmbandFailEingabeTest(){
        try {
            C.setAktiverSpieler(S);
            C.setSCHRITT_ARMBAND_boolean(true);
            C.setArmbandAktuell("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),WORTFAIL);
        }
    }

    @Test
    public void SetArmbandFailSchrittTest(){
        try {
            C.setAktiverSpieler(S);
            // C.setSCHRITT_ZEITARBEITER_boolean(true);
            C.setArmbandAktuell("FAIL");
            C.setArmbandNeu("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),SCHRITTFAIL);
        }
    }

    @Test
    public void SetGehauseFailEingabeTest(){
        try {
            C.setAktiverSpieler(S);
            C.setSCHRITT_GEHAUESE_boolean(true);
            C.setGehaeuseAktuell("FAIL");
            C.setGehaeuseNeu("Fail");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),WORTFAIL);
        }
    }

    @Test
    public void SetGehauseFailSchrittTest(){
        try {
            C.setAktiverSpieler(S);
            // C.setSCHRITT_ZEITARBEITER_boolean(true);
            C.setGehaeuseAktuell("FAIL");
            C.setGehaeuseNeu("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),SCHRITTFAIL);
        }
    }

    @Test
    public void SetMarketingFailEingabeTest(){
        try {
            C.setAktiverSpieler(S);
            C.setSCHRITT_MARKETING_boolean(true);
            C.setMarketingAktuell("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),WORTFAIL);
        }
    }

    @Test
    public void SetMarketingFailSchrittTest(){
        try {
            C.setAktiverSpieler(S);
            // C.setSCHRITT_ZEITARBEITER_boolean(true);
            C.setMarketingAktuell("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),SCHRITTFAIL);
        }
    }

    @Test
    public void SetProduktionsVolumenSchrittFailTest(){
        try {
            C.setAktiverSpieler(S);
           // C.setSCHRITT_GEHAUESE_boolean(true);
            C.setProduktionsvolumenAktuell(12314);
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),WORTFAIL);
        }
    }

    @Test
    public void SetBeszahlArtFailTest(){
        try{
            C.setAktiverSpieler(S);
            C.setBezahlartAktuell("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(), WORTFAIL);
        }
    }

    @Test
    public void SetUhrwerkFailEingabeTest(){
        try {
            C.setAktiverSpieler(S);
            C.setSCHRITT_UHRWERK_boolean(true);
            C.setUhrwerkAktuell("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),WORTFAIL);
        }
    }

    @Test
    public void SetUhrwerkFailSchrittTest(){
        try {
            C.setAktiverSpieler(S);
            // C.setSCHRITT_ZEITARBEITER_boolean(true);
            C.setUhrwerkAktuell("FAIL");
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(),SCHRITTFAIL);
        }
    }

}
