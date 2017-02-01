package com.example.patsc.fallstudie.ScenarioTest;

import com.example.patsc.fallstudie.Covered.Auftragssammlung;
import com.example.patsc.fallstudie.Covered.Daten;
import com.example.patsc.fallstudie.Covered.Controller;
import com.example.patsc.fallstudie.Covered.Preissimulation;
import com.example.patsc.fallstudie.Covered.Spieler;

import org.junit.Test;

import java.util.ResourceBundle;

/**
 * Created by julian on 11.01.2017.
 */

public class ScenarioTest {

    private static String AUSWAHL_JULIAN_ZEITARBEITER = Controller.ZEITARBEITER_WAHL_PRAKTIKANT;
    private static String AUSWAHL_JULIAN_FORSCHUNG = Controller.FORSCHUNG_WAHL_LOWBUDGET;
    private static String AUSWAHL_JULIAN_MARKETING = Controller.MARKETING_WAHL_PRINTWERBUNG;
    private static String AUSWAHL_JULIAN_ARMBAND = Controller.ARMBAND_WAHL_TEXTIL;
    private static String AUSWAHL_JULIAN_UHRWERK = Controller.UHRWERK_WAHL_ELEKTROMECHANISCH;
    private static String AUSWAHL_JULIAN_GEHAEUSE = Controller.GEHAEUSE_WAHL_KUNSTSTOFF;
    private static String AUSWAHL_JULIAN_BEZAHLARTEN = Controller.BEZAHLART_WAHL_RECHNUNG;
    private static float AUSWAHL_JULIAN_PRODUKTIONSVOLUMEN = 10000;
    private static float AUSWAHL_JULIAN_VERKAUFSPREIS = 10;
    private double GEWINN_JULIAN;
    private float ABSATZ_JULIAN;
    private double MARKTANTEIL_JULIAN;
    private float POSITION_JULIAN;
    private double GUTHABEN_JULIAN;

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

    private static String AUSWAHL_JONAS_ZEITARBEITER = Controller.ZEITARBEITER_WAHL_GESELLE;
    private static String AUSWAHL_JONAS_FORSCHUNG = Controller.FORSCHUNG_WAHL_MITTELMAESIG;
    private static String AUSWAHL_JONAS_MARKETING = Controller.MARKETING_WAHL_RADIOWERBUNG;
    private static String AUSWAHL_JONAS_ARMBAND = Controller.ARMBAND_WAHL_METALL;
    private static String AUSWAHL_JONAS_UHRWERK = Controller.UHRWERK_WAHL_ELEKTRONISCH;
    private static String AUSWAHL_JONAS_GEHAEUSE = Controller.GEHAEUSE_WAHL_METALL;
    private static String AUSWAHL_JONAS_BEZAHLARTEN = Controller.BEZAHLART_WAHL_PAYPAL;
    private static float AUSWAHL_JONAS_PRODUKTIONSVOLUMEN = 6000;
    private static float AUSWAHL_JONAS_VERKAUFSPREIS = 35;
    private double GEWINN_JONAS;
    private float ABSATZ_JONAS;
    private double MARKTANTEIL_JONAS;
    private float POSITION_JONAS;
    private double GUTHABEN_JONAS;

    public void bestellen(Controller Controller, String Auswahlzeitarbeiter,String Auswahlforschung, String Auswahlmarketing, String Auswahlarmband, String Auswahluhrwerk,String Auswahlgehaeuse, String Bezahlarten, Float Produktionsvolumen, Float Verkaufspreis ){
        Controller.setSCHRITT_ZEITARBEITER_boolean(true);
        Controller.setZeitarbeiterAktuell(Auswahlzeitarbeiter);
        Controller.setSCHRITT_FORSCHUNG_boolean(true);
        Controller.setForschungAktuell(Auswahlforschung);
        Controller.setSCHRITT_MARKETING_boolean(true);
        Controller.setMarketingAktuell(Auswahlmarketing);
        Controller.setSCHRITT_ARMBAND_boolean(true);
        Controller.setArmbandAktuell(Auswahlarmband);
        Controller.setSCHRITT_UHRWERK_boolean(true);
        Controller.setUhrwerkAktuell(Auswahluhrwerk);
        Controller.setSCHRITT_GEHAUESE_boolean(true);
        Controller.setGehaeuseAktuell(Auswahlgehaeuse);
        Controller.setSCHRITT_BEZAHLART_boolean(true);
        Controller.setBezahlartAktuell(Bezahlarten);
        Controller.setSCHRITT_PRODUKTIONSVOLUMEN_boolean(true);
        Controller.setProduktionsvolumenAktuell(Produktionsvolumen);
        Controller.setSCHRITT_VERKAUFSPREIS_boolean(true);
        Controller.setVerkaufspreisAktuell(Verkaufspreis);
    }

    public void Rundenergebnisse(Controller Controller, Double Gewinn, float Absatz, double Marktanteil, float Position, double Guthaben){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ergebnisse für" + Controller.getAktiverSpieler().getName());
        System.out.println("Runde: " + Controller.getRunde());
        System.out.println("Absatz: " + Absatz);;
        System.out.println("Marktanteil: " + Marktanteil);
        System.out.println("Position: " + Position);
        System.out.println("Guthaben: " + Guthaben);
        System.out.println("-------------------------------------------------------------");
    }


    /*
    Ablauf:
    1.Controller erzeugen ( Hier werden die Spieldaten erstellt.)
    2.Daten erzeugen.
    3.Die Spieler werden erstellt (Julian, Sebastian, Jonas)
    4.Julian spielt seine Runde:
        Er trifft folgende Entscheidungen:
            1) Personalwesen()
            2) Zeitarbeiter(Praktikant)
            3) Forschung und Entwicklung (2500€)
            4) Marketing (Printwerbung)
            5) Armband (Textil)
            6) Uhrwerk (elektromechanisch)
            7) Gehäuse (Kunststoff)
            8) Bezahlarten (Rechnung)
            9 Produktionsvolumen (10.000)
            10) geplanter Verkaufspreis (10€)
    5.Preissimulation
    6.Sebastian trifft seine Entscheidung:
        Er trifft folgende Entscheidungen:
            1) Personalwesen()
            2) Zeitarbeiter(Meister)
            3) Forschung und Entwicklung(15000€)
            4) Marketing (Fernsehwerbung)
            5) Armband (Holz)
            6) Uhrwerk (mechanisch)
            7) Gehäuse (Glas)
            8) Bezahlarten (Kreditkarte)
            9 Produktionsvolumen (3000)
            10) geplanter Verkaufspreis (150€)
    7.Preissimulation
    8.Jonas spielt seine Runde:
        Er trifft folgende Entscheidungen:
            1) Personalwesen(0)
            2) Zeitarbeiter(Geselle)
            3) Forschung und Entwicklung (8000€)
            4) Marketing (Radiowerbung)
            5) Armband (Metall)
            6) Uhrwerk (elektronisch)
            7) Gehäuse (Metall)
            8) Bezahlarten (Paypal)
            9 Produktionsvolumen (6.000)
            10) geplanter Verkaufspreis (35€)
     9.Preissimulation
     10.Marktsimulation
     11.Rundenende

     */

    @Test
    public void TestScenario() throws Exception {
        //1.Controller erzeugen
        Controller Controller = new Controller();
        //2.Daten erstellen
        Daten Daten = new Daten();
        //3.Spieler erstellen
        Spieler Julian = new Spieler("Julian", "passwort", Daten);
        Spieler Sebastian = new Spieler("Sebastian", "passwort", Daten);
        Spieler Jonas = new Spieler("Hurensohn1", "ichbineinhurensohn", Daten);
        //4.Spieler führen Bestellungen durch
        //Julian ist dran
        Controller.aktiverSpieler = Julian;
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


        //Sebastian ist dran
        Controller.aktiverSpieler = Sebastian;
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
        Controller.setActivity_Berechnung();

        //Jonas ist dran
        Controller.aktiverSpieler = Jonas;
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
        Controller.setActivity_Berechnung();


        //5. Rundenergebnisse anzeigen
            //Rundenergebnis von Julian
            Controller.aktiverSpieler = Julian;
            //TEST

            //TEST
            ABSATZ_JULIAN=Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getAbsatz();
            MARKTANTEIL_JULIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getMarktanteil(Controller.getAktiverSpieler().getName());
            GEWINN_JULIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getGewinn();
            GUTHABEN_JULIAN = Controller.getGuthaben();
            POSITION_JULIAN = Controller.getPosition();
            Rundenergebnisse(Controller,GEWINN_JULIAN, ABSATZ_JULIAN,MARKTANTEIL_JULIAN,POSITION_JULIAN,GUTHABEN_JULIAN);
            Controller.aktiverSpieler = Sebastian;
            ABSATZ_SEBASTIAN=Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getAbsatz();
            MARKTANTEIL_SEBASTIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getMarktanteil(Controller.getAktiverSpieler().getName());
            GEWINN_SEBASTIAN = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getGewinn();
            GUTHABEN_SEBASTIAN = Controller.getGuthaben();
            POSITION_SEBASTIAN = Controller.getPosition();
            Rundenergebnisse(Controller,GEWINN_SEBASTIAN, ABSATZ_SEBASTIAN, MARKTANTEIL_SEBASTIAN, POSITION_SEBASTIAN, GUTHABEN_SEBASTIAN);
            Controller.aktiverSpieler = Jonas;
            ABSATZ_JONAS = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getAbsatz();
            MARKTANTEIL_JONAS = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getMarktanteil(Controller.getAktiverSpieler().getName());
            GEWINN_JONAS = Controller.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag().getMarktsim().getGewinn();
            GUTHABEN_JONAS = Controller.getGuthaben();
            POSITION_JONAS = Controller.getPosition();
            Rundenergebnisse(Controller,GEWINN_JONAS, ABSATZ_JONAS, MARKTANTEIL_JONAS, POSITION_JONAS,GUTHABEN_JONAS);
    }
}
