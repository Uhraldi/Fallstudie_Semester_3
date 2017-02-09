package com.example.patsc.fallstudie.ScenarioTest;

import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Spieler;

import org.junit.Test;

/**
 * Created by julian on 08.02.2017.
 */

public class ScenarioTestHigh {
    public int WaitingTime = 500;
    private static String AUSWAHL_SEBASTIAN_ZEITARBEITER = Controller.ZEITARBEITER_WAHL_MEISTER;
    private static String AUSWAHL_SEBASTIAN_FORSCHUNG = Controller.FORSCHUNG_WAHL_HOCH;
    private static String AUSWAHL_SEBASTIAN_MARKETING = Controller.MARKETING_WAHL_FERNSEHWERBUNG;
    private static String AUSWAHL_SEBASTIAN_ARMBAND = Controller.ARMBAND_WAHL_HOLZ;
    private static String AUSWAHL_SEBASTIAN_UHRWERK = Controller.UHRWERK_WAHL_MECHANISCH;
    private static String AUSWAHL_SEBASTIAN_GEHAEUSE = Controller.GEHAEUSE_WAHL_GLAS;
    private static String AUSWAHL_SEBASTIAN_BEZAHLARTEN = Controller.BEZAHLART_WAHL_KREDITKARTE;
    private static float AUSWAHL_SEBASTIAN_PRODUKTIONSVOLUMEN = 3000;
    private static float AUSWAHL_SEBASTIAN_VERKAUFSPREIS = 150;
    private double GEWINN_SEBASTIAN;
    private float ABSATZ_SEBASTIAN;
    private double MARKTANTEIL_SEBASTIAN;
    private float POSITION_SEBASTIAN;
    private double GUTHABEN_SEBASTIAN;

    public void bestellen(Controller Controller, String Auswahlzeitarbeiter,String Auswahlforschung, String Auswahlmarketing, String Auswahlarmband, String Auswahluhrwerk,String Auswahlgehaeuse, String Bezahlarten, Float Produktionsvolumen, Float Verkaufspreis ) throws  Exception{
        Controller.setSCHRITT_ZEITARBEITER_boolean(true);
        Controller.setZeitarbeiterAktuell(Auswahlzeitarbeiter);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlzeitarbeiter + " bestellt");
        Thread.sleep(WaitingTime);
        Controller.setSCHRITT_FORSCHUNG_boolean(true);
        Controller.setForschungAktuell(Auswahlforschung);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlforschung + " bestellt");
        Thread.sleep(WaitingTime);
        Controller.setSCHRITT_MARKETING_boolean(true);
        Controller.setMarketingAktuell(Auswahlmarketing);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlmarketing + " bestellt");
        Thread.sleep(WaitingTime);
        Controller.setSCHRITT_ARMBAND_boolean(true);
        Controller.setArmbandAktuell(Auswahlarmband);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlarmband + " bestellt");
        Thread.sleep(WaitingTime);
        Controller.setSCHRITT_UHRWERK_boolean(true);
        Controller.setUhrwerkAktuell(Auswahluhrwerk);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahluhrwerk + " bestellt");
        Thread.sleep(WaitingTime);
        Controller.setSCHRITT_GEHAUESE_boolean(true);
        Controller.setGehaeuseAktuell(Auswahlgehaeuse);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Auswahlgehaeuse + " bestellt");
        Thread.sleep(WaitingTime);
        Controller.setSCHRITT_BEZAHLART_boolean(true);
        Controller.setBezahlartAktuell(Bezahlarten);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Bezahlarten + " bestellt");
        Thread.sleep(WaitingTime);
        Controller.setSCHRITT_PRODUKTIONSVOLUMEN_boolean(true);
        Controller.setProduktionsvolumenAktuell(Produktionsvolumen);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Produktionsvolumen + " Uhren bestellt");
        Thread.sleep(WaitingTime);
        Controller.setSCHRITT_VERKAUFSPREIS_boolean(true);
        Controller.setVerkaufspreisAktuell(Verkaufspreis);
        System.out.println(Controller.getAktiverSpieler().getName() + " hat " + Verkaufspreis + " als VKP festgelegt");
        Thread.sleep(WaitingTime);

        if(Controller.isZufall1()){
            Controller.aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().korrigiereArmband(Controller.getARMBAND_WAHL_LEDER());
            System.out.println(Controller.getAktiverSpieler().getName() + " hat Armband auf " + Controller.getARMBAND_WAHL_LEDER() + " korrigiert.");
        }
        Thread.sleep(WaitingTime);
        if(Controller.isZufall2()){
            Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().korrigiereGehaeuse(Controller.getGEHAEUSE_WAHL_METALL());
            System.out.println(Controller.getAktiverSpieler().getName() + " hat Gehäuse auf " + Controller.getGEHAEUSE_WAHL_METALL() + " korrigiert.");
        }Thread.sleep(WaitingTime);

        if(Controller.isZufall3()){
            Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().korriegiereZeitarbeiter(Controller.getZEITARBEITER_WAHL_Lehrling());
            System.out.println(Controller.getAktiverSpieler().getName() + " hat Zeitarbeiter auf " + Controller.getZEITARBEITER_WAHL_Lehrling() + " korrigiert.");
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

        //2.Daten erstellen
        Daten Daten = Controller.getDaten();

        //3.Spieler erstellen
        Spieler Sebastian = new Spieler("Sebastian", "passwort", Daten);
        Controller.setAktiverSpieler(Sebastian);
        System.out.println("Spieler erstellt!");

        for (int i = 0; i<9; i++){

            //4.Spieler führen Bestellungen durch
            Controller.setZustand_Bestellung(true);
            bestellen(Controller,
                    AUSWAHL_SEBASTIAN_ZEITARBEITER,
                    AUSWAHL_SEBASTIAN_FORSCHUNG,
                    AUSWAHL_SEBASTIAN_MARKETING,
                    AUSWAHL_SEBASTIAN_ARMBAND,
                    AUSWAHL_SEBASTIAN_UHRWERK,
                    AUSWAHL_SEBASTIAN_GEHAEUSE,
                    AUSWAHL_SEBASTIAN_BEZAHLARTEN,
                    AUSWAHL_SEBASTIAN_PRODUKTIONSVOLUMEN,
                    AUSWAHL_SEBASTIAN_VERKAUFSPREIS);
            Thread.sleep(WaitingTime);
            Controller.setActivity_Berechnung();
            System.out.println("Alle bestellt ");
            Thread.sleep(WaitingTime);


            //5. Rundenergebnisse anzeigen
            ABSATZ_SEBASTIAN=Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getAbsatz(Controller.getAktiverSpieler().getName());
            MARKTANTEIL_SEBASTIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getMarktanteil(Controller.getAktiverSpieler().getName());
            GEWINN_SEBASTIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getRundenGewinn(Controller.getAktiverSpieler().getName());
            GUTHABEN_SEBASTIAN = Controller.getGuthaben();
            POSITION_SEBASTIAN = Controller.getPosition();
            Rundenergebnisse(Controller,GEWINN_SEBASTIAN, ABSATZ_SEBASTIAN, MARKTANTEIL_SEBASTIAN, POSITION_SEBASTIAN, GUTHABEN_SEBASTIAN);
            Controller.starteNaechsteRunde();
        }
    }
}
