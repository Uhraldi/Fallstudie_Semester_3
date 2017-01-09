package com.example.patsc.fallstudie;

import org.junit.Test;

/**
 * Created by julia on 07.01.2017.
 */

public class BestellungTest {

    @Test
    public void BestellungArrayTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        Bestellung TestBestellung = new Bestellung();
        TestBestellung.neueBestellpositon();
    }

    @Test
    public void getBestellpositionTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        Bestellung TestBestellung = new Bestellung();
        TestBestellung.neueBestellpositon();
        TestBestellung.getBestellposition(0);

    }

    @Test
    public void getBestellpositionenTest(){
        Bestellposition TestBestellposition = new Bestellposition();
        Bestellung TestBestellung = new Bestellung();
        TestBestellung.neueBestellpositon();
        TestBestellung.getBestellpositionen();

    }

}
