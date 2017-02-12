package com.example.patsc.fallstudie.ScenarioTest;

import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Spieler;

import org.junit.Test;

/**
 * Hier im Scenario-Test wird ein kompletter Durchlauf der App simuliert.
 */

public class ScenarioTestBasic {


    /**
     * Initialisieren der Variablen
     */

    public int WaitingTime = 100;
    private static String AUSWAHL_JONAS_ZEITARBEITER = Controller.ZEITARBEITER_WAHL_GESELLE;
    private static String AUSWAHL_JONAS_FORSCHUNG = Controller.FORSCHUNG_WAHL_MITTELMAESIG;
    private static String AUSWAHL_JONAS_MARKETING = Controller.MARKETING_WAHL_RADIOWERBUNG;
    private static String AUSWAHL_JONAS_ARMBAND = Controller.ARMBAND_WAHL_METALL;
    private static String AUSWAHL_JONAS_UHRWERK = Controller.UHRWERK_WAHL_ELEKTRONISCH;
    private static String AUSWAHL_JONAS_GEHAEUSE = Controller.GEHAEUSE_WAHL_METALL;
    private static String AUSWAHL_JONAS_BEZAHLARTEN = Controller.BEZAHLART_WAHL_PAYPAL;
    private static float AUSWAHL_JONAS_PRODUKTIONSVOLUMEN = 2000;
    private static float AUSWAHL_JONAS_VERKAUFSPREIS = 60;
    public  int mitarbeiter;
    private double GEWINN_JONAS;
    private float ABSATZ_JONAS;
    private double MARKTANTEIL_JONAS;
    private float POSITION_JONAS;
    private double GUTHABEN_JONAS;


    /**
     *
     * Hier wurde das bestellen in eine Methode ausgelagert um den Test übersichtlich zu halten
     *
     * @param Controller
     * @param Auswahlzeitarbeiter
     * @param Auswahlforschung
     * @param Auswahlmarketing
     * @param Auswahlarmband
     * @param Auswahluhrwerk
     * @param Auswahlgehaeuse
     * @param Bezahlarten
     * @param Produktionsvolumen
     * @param Verkaufspreis
     * @throws Exception
     */

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


    /**
     *
     * Diese Methode dient dazu die wichtigsten Daten als Rundenergebnisse auszugeben.
     *
     * @param Controller
     * @param Gewinn
     * @param Absatz
     * @param Marktanteil
     * @param Position
     * @param Guthaben
     */


    public void Rundenergebnisse(Controller Controller, Double Gewinn, float Absatz, double Marktanteil, float Position, double Guthaben){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ergebnisse für " + Controller.getAktiverSpieler().getName());
        System.out.println("Aktuelle Mitarbeiter: " + Controller.getAktiverSpieler().getAktuellEingestellte());
        System.out.println("Runde: " + (Controller.getRunde() + 1));
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
        Spieler Jonas = new Spieler("Jonas", "Jonas", Daten);
        Controller.setAktiverSpieler(Jonas);
        System.out.println("Spieler erstellt!");




        for (int i = 0; i<9 ; i++){
            //4.Spieler führen Bestellungen durch
            Controller.setZustand_Bestellung(true);
            bestellen(Controller,
                    AUSWAHL_JONAS_ZEITARBEITER,
                    AUSWAHL_JONAS_FORSCHUNG,
                    AUSWAHL_JONAS_MARKETING,
                    AUSWAHL_JONAS_ARMBAND,
                    AUSWAHL_JONAS_UHRWERK,
                    AUSWAHL_JONAS_GEHAEUSE,
                    AUSWAHL_JONAS_BEZAHLARTEN,
                    AUSWAHL_JONAS_PRODUKTIONSVOLUMEN,
                    AUSWAHL_JONAS_VERKAUFSPREIS);
            Thread.sleep(WaitingTime);
            Controller.setActivity_Berechnung();
            System.out.println("Alle bestellt. Fixkosten: " + Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getFixKosten());
            Thread.sleep(WaitingTime);


            //5. Rundenergebnisse anzeigen
            ABSATZ_JONAS = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getAbsatz(Controller.getAktiverSpieler().getName());
            MARKTANTEIL_JONAS = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getMarktanteil(Controller.getAktiverSpieler().getName());
            GEWINN_JONAS = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getRundenGewinn(Controller.getAktiverSpieler().getName());
            GUTHABEN_JONAS = Controller.getGuthaben();
            POSITION_JONAS = Controller.getPosition();
            Rundenergebnisse(Controller, GEWINN_JONAS, ABSATZ_JONAS, MARKTANTEIL_JONAS, POSITION_JONAS, GUTHABEN_JONAS);
            Controller.starteNaechsteRunde();
        }
    }

}
