package com.example.patsc.fallstudie.ScenarioTest;

import android.content.SyncStatusObserver;

import com.example.patsc.fallstudie.Covered.Auftragssammlung;
import com.example.patsc.fallstudie.Covered.Daten;
import com.example.patsc.fallstudie.Covered.Controller;
import com.example.patsc.fallstudie.Covered.Preissimulation;
import com.example.patsc.fallstudie.Covered.Spieler;

import org.junit.Test;

import java.util.ResourceBundle;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by julian on 11.01.2017.
 */

public class ScenarioTestLow {

    private static String AUSWAHL_JULIAN_ZEITARBEITER = Controller.ZEITARBEITER_WAHL_PRAKTIKANT;
    private static String AUSWAHL_JULIAN_FORSCHUNG = Controller.FORSCHUNG_WAHL_LOWBUDGET;
    private static String AUSWAHL_JULIAN_MARKETING = Controller.MARKETING_WAHL_PRINTWERBUNG;
    private static String AUSWAHL_JULIAN_ARMBAND = Controller.ARMBAND_WAHL_TEXTIL;
    private static String AUSWAHL_JULIAN_UHRWERK = Controller.UHRWERK_WAHL_ELEKTROMECHANISCH;
    private static String AUSWAHL_JULIAN_GEHAEUSE = Controller.GEHAEUSE_WAHL_KUNSTSTOFF;
    private static String AUSWAHL_JULIAN_BEZAHLARTEN = Controller.BEZAHLART_WAHL_RECHNUNG;
    private static float AUSWAHL_JULIAN_PRODUKTIONSVOLUMEN = 2000;
    private static float AUSWAHL_JULIAN_VERKAUFSPREIS = 70;
    private double GEWINN_JULIAN;
    private float ABSATZ_JULIAN;
    private double MARKTANTEIL_JULIAN;
    private float POSITION_JULIAN;
    private double GUTHABEN_JULIAN;


    public void bestellen(Controller Controller, String Auswahlzeitarbeiter,String Auswahlforschung, String Auswahlmarketing, String Auswahlarmband, String Auswahluhrwerk,String Auswahlgehaeuse, String Bezahlarten, Float Produktionsvolumen, Float Verkaufspreis )throws Exception{
        Controller.setSCHRITT_ZEITARBEITER_boolean(true);
        Controller.setZeitarbeiterAktuell(Auswahlzeitarbeiter);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlzeitarbeiter + " bestellt");
        Controller.setSCHRITT_FORSCHUNG_boolean(true);
        Controller.setForschungAktuell(Auswahlforschung);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlforschung + " bestellt");
        Controller.setSCHRITT_MARKETING_boolean(true);
        Controller.setMarketingAktuell(Auswahlmarketing);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlmarketing + " bestellt");
        Controller.setSCHRITT_ARMBAND_boolean(true);
        Controller.setArmbandAktuell(Auswahlarmband);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlarmband + " bestellt");
        Controller.setSCHRITT_UHRWERK_boolean(true);
        Controller.setUhrwerkAktuell(Auswahluhrwerk);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahluhrwerk + " bestellt");
        Controller.setSCHRITT_GEHAUESE_boolean(true);
        Controller.setGehaeuseAktuell(Auswahlgehaeuse);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlgehaeuse + " bestellt");
        Controller.setSCHRITT_BEZAHLART_boolean(true);
        Controller.setBezahlartAktuell(Bezahlarten);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Bezahlarten + " bestellt");
        Controller.setSCHRITT_PRODUKTIONSVOLUMEN_boolean(true);
        Controller.setProduktionsvolumenAktuell(Produktionsvolumen);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Produktionsvolumen + " Uhren bestellt");
        Controller.setSCHRITT_VERKAUFSPREIS_boolean(true);
        Controller.setVerkaufspreisAktuell(Verkaufspreis);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Verkaufspreis + " als VKP festgelegt");
        if(Controller.isZufall1()){
            Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().korrigiereArmband(Controller.getARMBAND_WAHL_LEDER());
            System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Controller.getARMBAND_WAHL_LEDER() + " korrigiert.");
        }
        if(Controller.isZufall2()){
            Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().korrigiereGehaeuse(Controller.getGEHAEUSE_WAHL_METALL());
            System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Controller.getGEHAEUSE_WAHL_METALL() + " korrigiert.");
        }
        if(Controller.isZufall3()){
            Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().korriegiereZeitarbeiter(Controller.getZEITARBEITER_WAHL_Lehrling());
            System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Controller.getZEITARBEITER_WAHL_Lehrling() + " korrigiert.");
        }
    }

    public void Rundenergebnisse(Controller Controller, Double Gewinn, float Absatz, double Marktanteil, float Position, double Guthaben){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ergebnisse für " + Controller.getAktiverSpieler().getName());
        System.out.println("Runde: " + Controller.getRunde());
        System.out.println("Absatz: " + Absatz);;
        System.out.println("Marktanteil: " + Marktanteil);
        System.out.println("Position: " + Position);
        System.out.println("Guthaben: " + Guthaben);
        System.out.println("Gewinnn: "+ Gewinn);
        System.out.println("-------------------------------------------------------------");
    }



    @Test
    public void TestScenario() throws Exception {
        //1.Controller erzeugen
        Controller Controller = new Controller();

        //2.Spieler erstellen
        Spieler Julian = new Spieler("Julian", "passwort", Controller.getDaten());
        System.out.println("Spieler erstellt!");
        Controller.setAktiverSpieler(Julian);
        Controller.einstellen(1);

        //3.Spieler führen Bestellungen durch
        for(int i = 0; i<10; i++) {
            Controller.setAktiverSpieler(Julian);
            Controller.setZustand_Bestellung(true);
            bestellen(Controller,
                    AUSWAHL_JULIAN_ZEITARBEITER,
                    AUSWAHL_JULIAN_FORSCHUNG,
                    AUSWAHL_JULIAN_MARKETING,
                    AUSWAHL_JULIAN_ARMBAND,
                    AUSWAHL_JULIAN_UHRWERK,
                    AUSWAHL_JULIAN_GEHAEUSE,
                    AUSWAHL_JULIAN_BEZAHLARTEN,
                    AUSWAHL_JULIAN_PRODUKTIONSVOLUMEN,
                    AUSWAHL_JULIAN_VERKAUFSPREIS);
            Controller.setActivity_Berechnung();
            System.out.println("Alle bestellt ");


        //4. Rundenergebnisse anzeigen
        Controller.aktiverSpieler = Julian;
        ABSATZ_JULIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getAbsatz(Controller.getAktiverSpieler().getName());
        MARKTANTEIL_JULIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getMarktanteil(Controller.getAktiverSpieler().getName());
        GEWINN_JULIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getRundenGewinn(Controller.getAktiverSpieler().getName());
        GUTHABEN_JULIAN = Controller.getGuthaben();
        POSITION_JULIAN = Controller.getPosition();
        Rundenergebnisse(Controller, GEWINN_JULIAN, ABSATZ_JULIAN, MARKTANTEIL_JULIAN, POSITION_JULIAN, GUTHABEN_JULIAN);
        Controller.getAktiverSpieler().getAuftragssammlung().neuerAuftrag();
        Controller.getDaten().erhoeheRundenanzahl();

    }

    }
}
