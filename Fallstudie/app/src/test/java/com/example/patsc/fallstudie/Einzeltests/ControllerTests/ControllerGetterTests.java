package com.example.patsc.fallstudie.Einzeltests.ControllerTests;

import com.example.patsc.fallstudie.Covered.Bestandteile.Controller.Controller;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by julian on 07.01.2017.
 */

public class ControllerGetterTests {

    public final String SCHRITT_FORSCHUNG = "SCHRITT_FORSCHUNG"; // erster Schritt Wahl des Designers
    public final String SCHRITT_ARMBAND = "SCHRITT_ARMBAND"; // zweite Schritt Wahl des Armbands
    public final String SCHRITT_UHRWERK = "SCHRITT_UHRWERK"; // dritter Schritt Wahl des Uhrwerks und der Uhrenart
    public final String SCHRITT_GEHAUESE = "SCHRITT_GEHAUSE"; // vierter Schritt Wahl des Gehäuses für die Uhr
    public final String SCHRITT_DICHTHEIT = "SCHRITT_DICHTHEIT"; // fuenfter Schritt Wahl der Dichtheit
    public final String SCHRITT_ZUSAMMENBAU = "SCHRITT_ZUSAMMENBAU"; // sechster Schritt Wahl Zeitarbeiter
    public final String SCHRITT_WERBUNG = "SCHRITT_WEBUNG"; // siebter Schritt Wahl des Werbeetars
    public final String SCHRITT_PRODUKTIONSVOLUMEN = "SCHRITT_PRODUKTIONSVOLUMEN"; // achter Schritt Wahl des Kaufvolumens
    public final String SCHRITT_VERSANDART = "SCHRITT_BEZAHLART"; // neunter Schritt Wahl der Bezahlart
    public final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS"; // zehnter Schritt Wahl der Bezahlart
    Controller TestController = new Controller();


    @Test
    public void getSchrittDesignerTest(){

        Assert.assertEquals(SCHRITT_FORSCHUNG, TestController.getSCHRITT_FORSCHUNG());
    }

    @Test
    public void getSchrittArmbandTest(){
        Assert.assertEquals(SCHRITT_ARMBAND, TestController.getSCHRITT_ARMBAND());
    }

    @Test
    public void getSchrittUhrwerkTest(){
        Assert.assertEquals(SCHRITT_UHRWERK, TestController.getSCHRITT_UHRWERK());
    }

    @Test
    public void getSchrittGehaeuseTest(){
        Assert.assertEquals(SCHRITT_GEHAUESE, TestController.getSCHRITT_GEHAUESE());
    }



    /*

    @Test
    public void getSchrittZusammenbauTest(){
        Assert.assertEquals(SCHRITT_ZUSAMMENBAU, TestController.getSCHRITT_ZUSAMMENBAU());
    }
    */

    @Test
    public void getSchrittWerbungTest(){
        Assert.assertEquals(SCHRITT_PRODUKTIONSVOLUMEN, TestController.getSCHRITT_PRODUKTIONSVOLUMEN());
    }

    @Test
    public void getSchrittKaufvolumenTest(){
        Assert.assertEquals(SCHRITT_PRODUKTIONSVOLUMEN, TestController.getSCHRITT_PRODUKTIONSVOLUMEN());
    }


    @Test
    public void getSchrittVerkaufspreisTest(){
        Assert.assertEquals(SCHRITT_VERKAUFSPREIS, TestController.getSCHRITT_VERKAUFSPREIS());
    }

}
