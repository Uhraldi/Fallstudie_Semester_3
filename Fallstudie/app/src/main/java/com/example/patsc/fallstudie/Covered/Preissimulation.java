package com.example.patsc.fallstudie.Covered;


import com.example.patsc.fallstudie.Covered.Controller.Controller;

/**
 * Created by Jonas on 02.01.17.
 */

public class Preissimulation {

    /**
    Wichtige Attribute
     */
    private Auftragssammlung auftragssammlung;
    private Controller c;
    private Auftrag auftrag;
    private int RundenNr;
    private double Reservationspreis;

    // public String toString(){
    //   String persoString;
    // persoString = Fixkosten + ":" + FixkostenPersonalwesen + ":" + FixkostenForschung + ":" + FixkostenForschung + ":" +  FixkostenMarketing + ":" +FixkostenBezahlart + ":";
    //  persoString = persoString + ":" + VariableKosten + ":" +VariableStückKosten + ":"+ VariableStückkostenZeitarbeiter + ":"+ VariableStückkostenArmband + ":"+ VariableStückkostenUhrwerk + ":"+ VariableStückkostenGehäuse+ ":";
    //  return persoString;
    // }

    /**
    Konstruktor für die Preissimulation
     */
    public Preissimulation(Controller controller) {
        this.RundenNr = controller.getRunde(); // aktuelle Rundennummer holen
        this.auftragssammlung = controller.getAktiverSpieler().getAuftragssammlung(); // Auswahlen des aktiven Spielers aus der Auftragssammlung
        c = controller;
        auftrag = c.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag(); // aktuellen Auftrag aus dem Controller holen
        berechneReservationspreis(c.getZeitarbeiterAktuellerAuftrag(), c.getForschungAktuellerAuftrag(), c.getMarketingAktuellerAuftrag(), c.getArmbandAktuellerAuftrag(),
                 c.getUhrwerkAktuellerAuftrag(), c.getGehaeuseAktuellerAuftrag(), c.getBezahlartAktuellerAuftrag()); // Berechnung Reservationspreis bestehend aus den Auswahlen des aktuellen Auftrages
    } // Ende Konstruktor

    /**
    Getter-Methoden
     */
    public double getReservationspreis() {
        return Reservationspreis;
    }

    public double getPWS(String ReservationspreisZeitarbeiter,
                         String ReservationspreisForschung, String ReservationspreisMarketing,
                         String ReservationspreisArmband, String ReservationspreisUhrwerk,
                         String ReservationspreisGehäuse, String ReservationspreisBezahlart){
        double PWS = 0; // PWS = 0 setzen
        /*
        PWS der einzelnen Produktionsschritte aufaddieren
         */
        PWS = PWS + getPWSZeitarbeiter(ReservationspreisZeitarbeiter);
        PWS = PWS + getForschungPWS(ReservationspreisForschung);
        PWS = PWS + getMarketingPWS(ReservationspreisMarketing);
        PWS = PWS + getArmbandPWS(ReservationspreisArmband);
        PWS = PWS + getUhrwerkPWS(ReservationspreisUhrwerk);
        PWS = PWS + getGehaeusePWS(ReservationspreisGehäuse);
        PWS = PWS + getBezahlartPWS(ReservationspreisBezahlart);
        return PWS; // Rückgabe des PWS
    }

    /**
    PWS der Zeitarbeiter bestimmen
    Mithilfe einer switch-case Anweisung wird aus dem Auftrag
    die Auswahl geholt, um den individuellen PWS zu bestimmen.
     */
public double getPWSZeitarbeiter (String Zeitarbeiter) {
    double ReservapZeitarbeiter = 0; // Reservationspreis des Zeitarbeiter auf 0 setzen
    try {
        switch (Zeitarbeiter) {
            case "Geselle": {
                ReservapZeitarbeiter = auftrag.getZeitarbeiter().getGesellePWS();
                break;
            }
            case "Praktikant": {
                ReservapZeitarbeiter =auftrag.getZeitarbeiter().getPraktikantPWS();
                break;
            }
            case "Lehrling": {
                ReservapZeitarbeiter = auftrag.getZeitarbeiter().getLehrlingPWS();
                break;
            }
            case "Meister": {
                ReservapZeitarbeiter = auftrag.getZeitarbeiter().getMeisterPWS();
                break;
            }
            default: {
                System.err.println("Keine Auswahl getroffen worden.");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ReservapZeitarbeiter; // Rückgabe des Reservationspreis des Zeitarbeiters
}
    /**
    PWS der Forschung bestimmen
    Mithilfe einer switch-case Anweisung wird aus dem Auftrag
    die Auswahl geholt, um den individuellen PWS zu bestimmen.
     */
    public double getForschungPWS (String Forschung){
        double ReservapForschung = 0; // Reservationspreis der Forschung auf 0 setzen
        try {
            switch (Forschung) {
                case "15000€ Investition": {
                    ReservapForschung = auftrag.getForschung().getInvestition15000PWS();
                    break;
                }
                case "8000€ Investition": {
                    ReservapForschung = auftrag.getForschung().getInvestition8000PWS();
                    break;
                }
                case "2500€ Investition": {
                    ReservapForschung = auftrag.getForschung().getInvestition2500PWS();
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ReservapForschung; // Rückgabe des Reservationspreis der Forschung
    }

    /**
    PWS des Marketings bestimmen
    Aufgrund einer Mehrfachauswahl im Spiel wird hier mit einer if-Anweisung
    geprüft, welche Auswahl im Auftrag getroffen wurde. Falls mehrere Auswahlen vorhanden sein sollten,
    werden diese aufaddiert.
     */
    public double getMarketingPWS (String Marketing){
        double ReservapMarketing = 0; // Reservationspreis des Marketings auf 0 setzen
        try {

            if(auftrag.getMarketing().isFernsehwerbung()==true){
                    ReservapMarketing = auftrag.getMarketing().getFernsehwerbungPWS();
                }
                if (auftrag.getMarketing().isRadiowerbung()) {
                    ReservapMarketing =ReservapMarketing + auftrag.getMarketing().getRadiowerbungPWS();
                }

                if (auftrag.getMarketing().isPrintwerbung()) {
                    ReservapMarketing = ReservapMarketing + auftrag.getMarketing().getPrintwerbungPWS();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return ReservapMarketing; // Rückgabe des Reservationspreis des Marketings
    }

    /**
    Zufall und PWS des Armbands bestimmen
    Mithilfe einer switch-case Anweisung wird aus dem Auftrag
    die Auswahl geholt, um den individuellen PWS und Zufall zu bestimmen. Diese beiden Werte werden addiert.
     */
    public double getArmbandPWS (String Armband){
        double ReservapArmband = 0; // Reservationspreis des Armbands auf 0 setzen
        try {
            switch (Armband) {
                case "Leder": {
                    ReservapArmband = auftrag.getArmband().getLederPWS()+auftrag.getArmband().getLederZufall();
                    break;
                }
                case "Kunstleder": {
                    ReservapArmband = auftrag.getArmband().getKunstlederPWS()+auftrag.getArmband().getKunstlederZufall();
                    break;
                }
                case "Holz": {
                    ReservapArmband = auftrag.getArmband().getHolzZufall() + auftrag.getArmband().getHolzPWS();
                    break;
                }
                case "Textil": {
                    ReservapArmband =auftrag.getArmband().getTextilPWS()+ auftrag.getArmband().getTextilZufall();
                    break;
                }
                case "Metall": {
                    ReservapArmband = auftrag.getArmband().getMetallPWS()+auftrag.getArmband().getMetallZufall();
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return ReservapArmband; // Rückgabe des Reservationspreis des Armbands
    }
    /**
    PWS des Uhrwerks bestimmen
    Mithilfe einer switch-case Anweisung wird aus dem Auftrag
    die Auswahl geholt, um den individuellen PWS zu bestimmen
     */
    public double getUhrwerkPWS (String Uhrwerk){
       double ReservapUhrwerk = 0; // Reservationspreis des Uhrwerks auf 0 setzen
        try {
            switch (Uhrwerk) {
                case "Mechanisch": {
                    ReservapUhrwerk = auftrag.getUhrwerk().getMechanischPWS();
                    break;
                }
                case "Elektromechanisch": {
                    ReservapUhrwerk = auftrag.getUhrwerk().getElektromechanischPWS();
                    break;
                }
                case "Elektronisch": {
                    ReservapUhrwerk =auftrag.getUhrwerk().getEletronischPWS();
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ReservapUhrwerk; // Rückgabe des Reservationspreis des Uhrwerks
    }
    /**
    Zufall und PWS des Gehäuses bestimmen
    Mithilfe einer switch-case Anweisung wird aus dem Auftrag
    die Auswahl geholt, um den individuellen Zufall und PWS zu bestimmen. Diese beiden Werte werden addiert.
     */
    public double getGehaeusePWS(String Gehaeuse){
        double ReservapGehäuse = 0; // Reservationspreis des Gehäuses auf 0 setzen
        try {
            switch (Gehaeuse) {
                case "Glas": {
                    ReservapGehäuse = auftrag.getGehaeuse().getGlasPWS() + auftrag.getGehaeuse().getGlasZufall();
                    break;
                }
                case "Holz": {
                    ReservapGehäuse = auftrag.getGehaeuse().getHolzPWS()+auftrag.getGehaeuse().getHolzZufall();
                    break;
                }
                case "Kunststoff": {
                    ReservapGehäuse = auftrag.getGehaeuse().getKunststoffPWS() + auftrag.getGehaeuse().getKunststoffZufall();
                    break;
                }
                case "Metall": {
                    ReservapGehäuse = auftrag.getGehaeuse().getMetallPWS() + auftrag.getGehaeuse().getMetallZufall();
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ReservapGehäuse; // Rückgabe des Reservationspreises des Gehäuses
    }
    /**
    Zufall und PWS der Bezahlart bestimmen
    Aufgrund einer Mehrfachauswahl im Spiel wird hier mit einer if-Anweisung
    geprüft, welche Auswahl im Auftrag getroffen wurde. Falls mehrere Auswahlen vorhanden sein sollten,
    werden diese aufaddiert.
    */
    public double getBezahlartPWS (String Bezahlart) {
        double ReservapBezahlart = 0; // Reservationspreis der Bezahlart auf 0 setzen
        try {
            if (auftrag.getBezahlart().isKreditkarte()){
                    ReservapBezahlart = auftrag.getBezahlart().getKreditkartePWS() + auftrag.getBezahlart().getKreditkarteZufall();

                }
                if (auftrag.getBezahlart().isRechnung()){
                    ReservapBezahlart = ReservapBezahlart + auftrag.getBezahlart().getRechnungPWS() + auftrag.getBezahlart().getRechnungZufall();

                }
                if (auftrag.getBezahlart().isPayPal()){
                    ReservapBezahlart = auftrag.getBezahlart().getPayPalPWS() + auftrag.getBezahlart().getPayPalZufall();

                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return ReservapBezahlart; // Rückgabe des Reservationspreises der Bezahlart
    }

    /**
    Berechne den Reservationspreis
     */
    public void berechneReservationspreis(String ReservationspreisZeitarbeiter,
                                          String ReservationspreisForschung, String ReservationspreisMarketing,
                                          String ReservationspreisArmband, String ReservationspreisUhrwerk,
                                          String ReservationspreisGehäuse, String ReservationspreisBezahlart) {
        // PWS insgesamt bestimmen
        double PWS = getPWS(ReservationspreisZeitarbeiter, ReservationspreisForschung, ReservationspreisMarketing,
                ReservationspreisArmband, ReservationspreisUhrwerk, ReservationspreisGehäuse, ReservationspreisBezahlart);
        /*
        Stückkosten bestimmen durch die Addition von Variablen Kosten und Fixen Kosten,
        dividiert durch die Menge des Auftrags
        */
        double stueckKosten = auftrag.getVarKosten()+auftrag.getFixKosten()/auftrag.getMenge();
        // Reservationspreis bestimmen durch eine Multiplikation der Stückkosten mit den PWS+1
        double reservationspreis = stueckKosten * (1+PWS);
        this.Reservationspreis = reservationspreis;

    } // Ende berechneReservationspreis()

    /**
     * Aufaddieren der Bonuswerte
     *
     * @return
     */

    public double getBonus() {

        Auftrag s = c.aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag();
        double zwischenspeicher = 0;

        if (s.getBezahlart().isKreditkarte()) {
            zwischenspeicher += s.getBezahlart().getKreditkarteZufall();
        }
        if (s.getBezahlart().isPayPal()) {
            zwischenspeicher += s.getBezahlart().getPayPalZufall();
        }
        if (s.getBezahlart().isRechnung()) {
            zwischenspeicher += s.getBezahlart().getRechnungZufall();
        }
        if (s.getMarketing().isFernsehwerbung()) {
            zwischenspeicher += s.getMarketing().getFernsehwerbungPWS();
        }
        if (s.getMarketing().isRadiowerbung()) {
            zwischenspeicher += s.getMarketing().getRadiowerbungPWS();
        }
        if (s.getMarketing().isPrintwerbung()) {
            zwischenspeicher += s.getMarketing().getPrintwerbungPWS();
        }

        return zwischenspeicher;
    } // Ende getBonus
} // Ende Klasse