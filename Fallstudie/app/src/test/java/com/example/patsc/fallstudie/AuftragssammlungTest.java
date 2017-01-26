package com.example.patsc.fallstudie;

import com.example.patsc.fallstudie.Covered.Auftrag;
import com.example.patsc.fallstudie.Covered.Auftragssammlung;

import org.junit.Test;

/**
 * Created by julia on 07.01.2017.
 */

public class AuftragssammlungTest {

    @Test
    public void BestellungArrayTest(){
        Auftrag testAuftrag = new Auftrag();
        Auftragssammlung testAuftragssammlung = new Auftragssammlung();
        testAuftragssammlung.neuerAuftrag();
    }

    @Test
    public void getBestellpositionTest(){
        Auftrag testAuftrag = new Auftrag();
        Auftragssammlung testAuftragssammlung = new Auftragssammlung();
        testAuftragssammlung.neuerAuftrag();
        testAuftragssammlung.getAuftrag(0);

    }

    @Test
    public void getBestellpositionenTest(){
        Auftrag testAuftrag = new Auftrag();
        Auftragssammlung testAuftragssammlung = new Auftragssammlung();
        testAuftragssammlung.neuerAuftrag();
        testAuftragssammlung.getAktuellerAuftrag();

    }

}
