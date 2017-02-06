package com.example.patsc.fallstudie.Einzeltests;

import com.example.patsc.fallstudie.Covered.Auftrag;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import static junit.framework.Assert.fail;

/**
 * Created by julia on 03.01.2017.
 */
@RunWith(Theories.class)
public class AuftragTest {



    @Test
    public void getFixeKostenTest(){
        Auftrag testBestellPosition = new Auftrag();
        Assert.assertEquals(0.0, testBestellPosition.getFixKosten());
    }

    @Test
    public void getVarKostenTest(){
        Auftrag testBestellPosition = new Auftrag();
        Assert.assertEquals(0.0, testBestellPosition.getVarKosten());
    }

    @Test
    public void getPwsTest(){
        Auftrag testBestellPosition = new Auftrag();
        Assert.assertEquals(0.0, testBestellPosition.getResPr());
    }

    @Test
    public void getRisikoArmbandTest(){
        Auftrag testBestellPosition = new Auftrag();
        Assert.assertEquals(0.0, testBestellPosition.getRisikoArmband());
    }

    @Test
    public void getRisikoGehaeuseTest(){
        Auftrag testBestellPosition = new Auftrag();
        Assert.assertEquals(0.0, testBestellPosition.getRisikoGehaeuse());
    }

    @Test
    public void getRisikoProduktionsOrtTest(){
        Auftrag testBestellPosition = new Auftrag();
        Assert.assertEquals(0.0, testBestellPosition.getRisikoZusammenbau()); // Namensänderung
    }

    @Test
    public void getZufallTest(){
        Auftrag testBestellPosition = new Auftrag();
        Assert.assertEquals(0.0, testBestellPosition.getZufall());
    }

    @Test
    public void getMengeTest(){
        Auftrag testBestellPosition = new Auftrag();
        try {
            testBestellPosition.bestelleMenge(1500);
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertEquals(1500, testBestellPosition.getMenge());
    }

    @Test
    public void getVKpTest(){
        Auftrag testAuftrag = new Auftrag();
        try{
            testAuftrag.bestelleVKP(1500);
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertEquals(1500.0, testAuftrag.getVkp());
    }

}
