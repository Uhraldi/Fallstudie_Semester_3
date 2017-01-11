package com.example.patsc.fallstudie.ScenarioTest;

import com.example.patsc.fallstudie.Bestellung;
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
   Bestellposition MarksUhrArmband = new Bestellposition();
        Bestellposition MarksUhrDesigner = new Bestellposition();
        Bestellposition MarksUhrGehaeuse = new Bestellposition();
        Bestellposition MarksUhrProduktionsort = new Bestellposition();
        Bestellposition MarksUhr = new Bestellposition();
        Bestellposition MarksUhrArmband = new Bestellposition();
        Bestellposition MarksUhrArmband = new Bestellposition();
 */

    /*
    MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).setPreissim(
                  MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getFixKosten()+
                  (MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getVarKosten()) *
                          (double)MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getMenge(),
                  MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getVkp(), MarksTestBestellung);
     */


    //Überprüfung of Bestellung Stimmt
    /*
    if (
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getArmband().isLeder() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getDesigner().isLowBudget() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getGehaeuse().isGlas() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getZusammenbau().isAsien() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getUhrwerk().isMechanisch() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getWerbung().isViel() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getWasserdichtheit().isNichtWassergeschützt() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getVersandart().isSchiff() &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getVkp() == 1000.0 &&
               MarksTestBestellung.getBestellposition(SpielDaten.getRundenAnzahl()).getMenge() == 10000
               ){
          passed = true;

       }
        Assert.assertTrue(passed);
     */

public class SpielerMachtBestellungTest {


    Daten SpielDaten = new Daten();
    Spieler Mark = new Spieler("Mark", "passwort123", SpielDaten);
    Boolean passed;
    Preissimulation TestPreisSim = null;
    Double[] pkz = null;

    public SpielerMachtBestellungTest() throws Exception {
    }

    public void bestellen(Bestellung bestellung, String Armband, String Designer, String Gehaeuse, String Zusammenbau, String Uhrwerk, String Werbung, String Wasserdichtheit, String Versandart, Double VKP, int Menge, Daten Daten, Preissimulation Preissimulation) throws  Exception {

        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleArmband(Armband);
        Preissimulation.berechneArmband(Armband);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleDesigner(Designer);
        Preissimulation.berechneDesigner(Designer);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleGehaeuse(Gehaeuse);
        Preissimulation.berechneGehäuseUhrwerk(Gehaeuse);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleZusamenbau(Zusammenbau);
        Preissimulation.berechneProduktionsort(Zusammenbau);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleUhrwerk(Uhrwerk);
        Preissimulation.berechneUhrwerk(Uhrwerk);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleWerbung(Werbung);
        Preissimulation.berechneWerbung(Werbung);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleWasserdichtheit(Wasserdichtheit);
        Preissimulation.berechneWasserdichtheit(Wasserdichtheit);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleVersandart(Versandart);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleVKP(VKP);
        bestellung.getBestellposition(Daten.getRundenAnzahl()).bestelleMenge(Menge);
    }


    @Test
    public void Runde1Test(){
        System.out.println("Spieler " + Mark.getName() + " hat das Spiel betreten. Sein Guthaben beträgt: " + Mark.getGuthaben()+ "€, sein Marktanteil beträgt " + Mark.getMarktanteil() + "% und er hat "+ Mark.getPunkte() + " Punkte!");
        Bestellung MarksTestBestellung = Mark.getBestellung();
        MarksTestBestellung.neueBestellpositon();
        Preissimulation MarksPreissim = new Preissimulation(SpielDaten.getRundenAnzahl(), MarksTestBestellung);
        try {
            bestellen(MarksTestBestellung, "Leder", "LowBudget", "Glas", "Asien", "Mechanisch","viel","Nicht Wassergeschützt", "Schiff", 1000.0 , 10000, SpielDaten, TestPreisSim);
            TestPreisSim.berechnePreis();
            System.out.println(TestPreisSim.getEinkaufspreis());
            System.out.println(TestPreisSim.getVerkaufspreis());

        }catch (Exception e){
            fail();
            e.printStackTrace();
        }



    }


}
