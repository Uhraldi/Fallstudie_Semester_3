package com.example.patsc.fallstudie;

import com.example.patsc.fallstudie.Bestandteile.Designer;

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
public class BestellpositionTest {



    @Test
    public void getFixeKostenTest(){
        Bestellposition TestBestellPosition = new Bestellposition();
        Assert.assertEquals(0.0, TestBestellPosition.getFixKosten());
    }

    @Test
    public void getVarKostenTest(){
        Bestellposition TestBestellPosition = new Bestellposition();
        Assert.assertEquals(0.0, TestBestellPosition.getVarKosten());
    }

    @Test
    public void getPwsTest(){
        Bestellposition TestBestellPosition = new Bestellposition();
        Assert.assertEquals(0.0, TestBestellPosition.getPws());
    }

    @Test
    public void getRisikoArmbandTest(){
        Bestellposition TestBestellPosition = new Bestellposition();
        Assert.assertEquals(0.0, TestBestellPosition.getRisikoArmband());
    }

    @Test
    public void getRisikoGehaeuseTest(){
        Bestellposition TestBestellPosition = new Bestellposition();
        Assert.assertEquals(0.0, TestBestellPosition.getRisikoGehaeuse());
    }

    @Test
    public void getRisikoProduktionsOrtTest(){
        Bestellposition TestBestellPosition = new Bestellposition();
        Assert.assertEquals(0.0, TestBestellPosition.getRisikoProduktionsort());
    }

    @Test
    public void getZufallTest(){
        Bestellposition TestBestellPosition = new Bestellposition();
        Assert.assertEquals(0.0, TestBestellPosition.getZufall());
    }

    @Test
    public void getMengeTest(){
        Bestellposition TestBestellPosition = new Bestellposition();
        try {
            TestBestellPosition.bestelleMenge(1500);
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertEquals(1500,TestBestellPosition.getMenge());
    }

    @Test
    public void getVKpTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        try{
            TestBestellposition.bestelleVKP(1500);
        }catch (Exception e){
            fail(e.getMessage());
        }
        Assert.assertEquals(1500.0, TestBestellposition.getVkp());
    }

}
