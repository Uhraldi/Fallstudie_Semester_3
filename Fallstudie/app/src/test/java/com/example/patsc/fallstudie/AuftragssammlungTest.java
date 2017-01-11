package com.example.patsc.fallstudie;

import org.junit.Test;

/**
 * Created by julia on 07.01.2017.
 */

public class AuftragssammlungTest {

    @Test
    public void BestellungArrayTest(){
        Auftrag testAuftrag = new Auftrag();
        Auftragssammlung testAuftragssammlung = new Auftragssammlung();
        testAuftragssammlung.neueBestellpositon();
    }

    @Test
    public void getBestellpositionTest(){
        Auftrag testAuftrag = new Auftrag();
        Auftragssammlung testAuftragssammlung = new Auftragssammlung();
        testAuftragssammlung.neueBestellpositon();
        testAuftragssammlung.getBestellposition(0);

    }

    @Test
    public void getBestellpositionenTest(){
        Auftrag testAuftrag = new Auftrag();
        Auftragssammlung testAuftragssammlung = new Auftragssammlung();
        testAuftragssammlung.neueBestellpositon();
        testAuftragssammlung.getBestellpositionen();

    }

}
