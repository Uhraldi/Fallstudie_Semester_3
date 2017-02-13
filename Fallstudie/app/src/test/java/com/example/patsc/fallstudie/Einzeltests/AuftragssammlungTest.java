package com.example.patsc.fallstudie.Einzeltests;

import com.example.patsc.fallstudie.Covered.Auftrag;
import com.example.patsc.fallstudie.Covered.Auftragssammlung;
import com.example.patsc.fallstudie.Covered.Controller.Controller;

import org.junit.Test;

/**
 In dieser Klasse werden alle Methoden der Auftragsammlung durch Ausführung getestet.
 -  Erstellen eines neuen Auftrages
 -  Eine bestimmte Bestellung abfragen
 -  Die aktuelle Bestellung abfragen
 -  Einen neuen Auftrag mit dem gleichen Werten erstellen
 -  Die überladene toString-Methode
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

    @Test
    public void NeuerAuftragGleicheWerteTest(){
        Auftragssammlung testAuftragssammlung = new Auftragssammlung();
        Auftrag testAuftrag = new Auftrag();
        try {
            testAuftrag.bestelleZeitarbeiter(Controller.ZEITARBEITER_WAHL_GESELLE);
            testAuftrag.bestelleForschung(Controller.FORSCHUNG_WAHL_HOCH);
            testAuftrag.bestelleWerbung(Controller.MARKETING_WAHL_FERNSEHWERBUNG);
            testAuftrag.bestelleArmband(Controller.ARMBAND_WAHL_HOLZ);
            testAuftrag.bestelleUhrwerk(Controller.UHRWERK_WAHL_ELEKTROMECHANISCH);
            testAuftrag.bestelleGehaeuse(Controller.GEHAEUSE_WAHL_GLAS);
            testAuftrag.bestelleBezahlart(Controller.BEZAHLART_WAHL_KREDITKARTE);
            testAuftrag.bestelleMenge(100);
            testAuftrag.bestelleVKP(100);




        }catch (Exception e){
            e.printStackTrace();
        }

        testAuftragssammlung.neuerAuftrag();
        testAuftragssammlung.neuerAuftragGleicheWerte();

    }

    @Test
    public void WerteToStringTest(){
        Auftragssammlung TestSammlung = new Auftragssammlung();
        TestSammlung.setAktuellerAuftragInt(3);
        TestSammlung.toString();
    }

}
