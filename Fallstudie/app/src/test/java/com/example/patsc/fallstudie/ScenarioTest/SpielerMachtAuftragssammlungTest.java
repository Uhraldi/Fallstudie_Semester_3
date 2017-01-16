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
    MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).setPreissim(
                  MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getFixKosten()+
                  (MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getVarKosten()) *
                          (double)MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getMenge(),
                  MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getVkp(), MarksTestBestellung);
     */


    //Überprüfung of Auftragssammlung Stimmt
    /*
    if (
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getArmband().isLeder() &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getForschung().isInvestition500() &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getGehaeuse().isGlas() &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getZeitarbeiter().isPraktikant() &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getUhrwerk().isMechanisch() &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getMarketing().isFernsehwerbung() &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getWasserdichtheit().isNichtWassergeschützt() &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getBezahlart().isRechnung() &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getVkp() == 1000.0 &&
               MarksTestBestellung.getAuftrag(SpielDaten.getRundenAnzahl()).getMenge() == 10000
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

        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleArmband(Armband);
        Preissimulation.berechneArmband(Armband);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleForschung(Designer);
        Preissimulation.berechneDesigner(Designer);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleGehaeuse(Gehaeuse);
        Preissimulation.berechneGehäuseUhrwerk(Gehaeuse);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleZeitarbeiter(Zusammenbau);
        Preissimulation.berechneProduktionsort(Zusammenbau);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleUhrwerk(Uhrwerk);
        Preissimulation.berechneUhrwerk(Uhrwerk);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleWerbung(Werbung);
        Preissimulation.berechneWerbung(Werbung);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleWasserdichtheit(Wasserdichtheit);
       // Preissimulation.berechneWasserdichtheit(Wasserdichtheit);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleVersandart(Versandart);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleVKP(VKP);
        auftragssammlung.getAuftrag(Daten.getRundenAnzahl()).bestelleMenge(Menge);
    }


    @Test
    public void Runde1Test(){
        System.out.println("Spieler " + Mark.getName() + " hat das Spiel betreten. Sein Guthaben beträgt: " + Mark.getGuthaben()+ "€, sein Marktanteil beträgt " + Mark.getMarktanteil() + "% und er hat "+ Mark.getPunkte() + " Punkte!");
        Auftragssammlung marksTestAuftragssammlung = Mark.getAuftragssammlung();
        marksTestAuftragssammlung.neueBestellpositon();
        Preissimulation MarksPreissim = new Preissimulation(SpielDaten.getRundenAnzahl(), marksTestAuftragssammlung);
        try {
            bestellen(marksTestAuftragssammlung, "Leder", "LowBudget", "Glas", "Praktikant", "Mechanisch","Fernsehwerbung","Nicht Wassergeschützt", "Rechnung", 1000.0 , 10000, SpielDaten, TestPreisSim);
            TestPreisSim.berechnePreis();
            System.out.println(TestPreisSim.getEinkaufspreis());
            System.out.println(TestPreisSim.getVerkaufspreis());

        }catch (Exception e){
            fail();
            e.printStackTrace();
        }



    }


}
