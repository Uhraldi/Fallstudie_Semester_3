package com.example.patsc.fallstudie.ScenarioTest;

import com.example.patsc.fallstudie.Auftragssammlung;
import com.example.patsc.fallstudie.Daten;
import com.example.patsc.fallstudie.Preissimulation;
import com.example.patsc.fallstudie.Spieler;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.fail;

/**
 * Created by julian on 11.01.2017.
 */

/*
   Auftrag MarksUhrArmband = new Auftrag();
        Auftrag MarksUhrDesigner = new Auftrag();
        Auftrag MarksUhrGehaeuse = new Auftrag();
        Auftrag MarksUhrProduktionsort = new Auftrag();
        Auftrag MarksUhr = new Auftrag();
        Auftrag MarksUhrArmband = new Auftrag();
        Auftrag MarksUhrArmband = new Auftrag();
 */

    /*
    MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).setPreissim(
                  MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getFixKosten()+
                  (MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getVarKosten()) *
                          (double)MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getMenge(),
                  MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getVkp(), MarksTestBestellung);
     */


    //Überprüfung of Auftragssammlung Stimmt
    /*
    if (
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getArmband().isLeder() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getForschung().isLowBudget() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getGehaeuse().isGlas() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getZusammenbau().isPraktikant() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getUhrwerk().isMechanisch() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getMarketing().isFernsehwerbung() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getWasserdichtheit().isNichtWassergeschützt() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getVersandart().isSchiff() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getVkp() == 1000.0 &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getMenge() == 10000
               ){
          passed = true;

       }
        Assert.assertTrue(passed);
     */

public class SpielerMachtAuftragssammlungTest {


    Daten SpielDaten = new Daten();
    Spieler Mark = new Spieler("Mark", "passwort123", SpielDaten);
    Boolean passed;
    Preissimulation TestPreisSim = null;
    Double[] pkz = null;

    public SpielerMachtAuftragssammlungTest() throws Exception {
    }

    public void bestellen(Auftragssammlung auftragssammlung, String Armband, String Designer, String Gehaeuse, String Zusammenbau, String Uhrwerk, String Werbung, String Wasserdichtheit, String Versandart, Double VKP, int Menge, Daten Daten, Preissimulation Preissimulation) throws  Exception {

        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleArmband(Armband);
        Preissimulation.berechneArmband(Armband);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleForschung(Designer);
        Preissimulation.berechneDesigner(Designer);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleGehaeuse(Gehaeuse);
        Preissimulation.berechneGehäuseUhrwerk(Gehaeuse);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleZeitarbeiter(Zusammenbau);
        Preissimulation.berechneProduktionsort(Zusammenbau);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleUhrwerk(Uhrwerk);
        Preissimulation.berechneUhrwerk(Uhrwerk);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleWerbung(Werbung);
        Preissimulation.berechneWerbung(Werbung);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleWasserdichtheit(Wasserdichtheit);
        Preissimulation.berechneWasserdichtheit(Wasserdichtheit);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleVersandart(Versandart);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleVKP(VKP);
        auftragssammlung.getBestellposition(Daten.getRundenAnzahl()).bestelleMenge(Menge);
    }


    @Test
    public void Runde1Test(){
        System.out.println("Spieler " + Mark.getName() + " hat das Spiel betreten. Sein Guthaben beträgt: " + Mark.getGuthaben()+ "€, sein Marktanteil beträgt " + Mark.getMarktanteil() + "% und er hat "+ Mark.getPunkte() + " Punkte!");
        Auftragssammlung marksTestAuftragssammlung = Mark.getAuftragssammlung();
        marksTestAuftragssammlung.neueBestellpositon();
        Preissimulation MarksPreissim = new Preissimulation(SpielDaten.getRundenAnzahl(), marksTestAuftragssammlung);
        try {
            bestellen(marksTestAuftragssammlung, "Leder", "LowBudget", "Glas", "Praktikant", "Mechanisch","Fernsehwerbung","Nicht Wassergeschützt", "Schiff", 1000.0 , 10000, SpielDaten, TestPreisSim);
            TestPreisSim.berechnePreis();
            System.out.println(TestPreisSim.getEinkaufspreis());
            System.out.println(TestPreisSim.getVerkaufspreis());

        }catch (Exception e){
            fail();
            e.printStackTrace();
        }



    }


}
