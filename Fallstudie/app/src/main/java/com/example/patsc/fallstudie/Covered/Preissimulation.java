package com.example.patsc.fallstudie.Covered;


import com.example.patsc.fallstudie.Covered.Bestandteile.Controller.Controller;

/**
 * Created by Jonas on 02.01.17.
 */

public class Preissimulation {

    /*
    Wichtige Attribute
     */
    private Auftragssammlung auftragssammlung;
    private Controller c;
    private Auftrag auftrag;
    private int RundenNr;

    private double Fixkosten = auftrag.getFixKosten();
    private double VariableKosten = auftrag.getVarKosten();
    private double Produktionsvolumen = auftrag.getMenge();

    private double Reservationspreis;

    // public String toString(){
    //   String persoString;
    // persoString = Fixkosten + ":" + FixkostenPersonalwesen + ":" + FixkostenForschung + ":" + FixkostenForschung + ":" +  FixkostenMarketing + ":" +FixkostenBezahlart + ":";
    //  persoString = persoString + ":" + VariableKosten + ":" +VariableStückKosten + ":"+ VariableStückkostenZeitarbeiter + ":"+ VariableStückkostenArmband + ":"+ VariableStückkostenUhrwerk + ":"+ VariableStückkostenGehäuse+ ":";
    //  return persoString;
    // }


    /*
    Konstruktor für die Preissimulation
     */
    public Preissimulation(Controller controller) {
        this.RundenNr = controller.getRunde();
        this.auftragssammlung = controller.getAktiverSpieler().getAuftragssammlung();
        c = controller;
        auftrag = c.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag();
        berechneReservationspreis(c.getZeitarbeiterAktuellerAuftrag(), c.getForschungAktuellerAuftrag(), c.getMarketingAktuellerAuftrag(), c.getArmbandAktuellerAuftrag(),
                c.getUhrwerkAktuellerAuftrag(), c.getGehaeuseAktuellerAuftrag(), c.getBezahlartAktuellerAuftrag());
    }

    /*
    Getter-Methoden
     */
    public double getReservationspreis() {
        return Reservationspreis;
    }

    // PWS insgesamt bestimmen
    public double getPWS(String ReservationspreisZeitarbeiter,
                         String ReservationspreisForschung, String ReservationspreisMarketing,
                         String ReservationspreisArmband, String ReservationspreisUhrwerk,
                         String ReservationspreisGehäuse, String ReservationspreisBezahlart){
        double PWS = 0;
        PWS = PWS + getPWSZeitarbeiter(ReservationspreisZeitarbeiter);
        PWS = PWS + getForschungPWS(ReservationspreisForschung);
        PWS = PWS + getMarketingPWS(ReservationspreisMarketing);
        PWS = PWS + getArmbandPWS(ReservationspreisArmband);
        PWS = PWS + getUhrwerkPWS(ReservationspreisUhrwerk);
        PWS = PWS + getGehaeusePWS(ReservationspreisGehäuse);
        PWS = PWS + getBezahlartPWS(ReservationspreisBezahlart);
        return PWS;
    }

    // PWS des Zeitarbeiters bestimmen
    public double getPWSZeitarbeiter (String Zeitarbeiter) {
        double ReservapZeitarbeiter = 0;
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
        return ReservapZeitarbeiter;
    }

    // PWS der Forschung bestimmen
    public double getForschungPWS (String Forschung){
        double ReservapForschung = 0;
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
        return ReservapForschung;
    }

    // PWS des Marketings bestimmen
    public double getMarketingPWS (String Marketing){
        double ReservapMarketing = 0;
        try {
            switch (Marketing) {
                case "Fernsehwerbung": {
                    ReservapMarketing = auftrag.getMarketing().getFernsehwerbungPWS();
                    break;
                }
                case "Radiowerbung": {
                    ReservapMarketing =ReservapMarketing + auftrag.getMarketing().getRadiowerbungPWS();
                    break;
                }
                case "Printwerbung": {
                    ReservapMarketing = ReservapMarketing+auftrag.getMarketing().getPrintwerbungPWS();
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ReservapMarketing;
    }

    // PWS des Armbands bestimmen
    public double getArmbandPWS (String Armband){
        double ReservapArmband = 0;
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
        return ReservapArmband;
    }

    // PWS des Uhrwerks bestimmen
    public double getUhrwerkPWS (String Uhrwerk){
        double ReservapUhrwerk = 0;
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
        return ReservapUhrwerk;
    }

    // PWS des Gehäuses bestimmen
    public double getGehaeusePWS(String Gehaeuse){
        double ReservapGehäuse = 0;
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
        return ReservapGehäuse;
    }

    // PWS der Bezahlart bestimmen
    public double getBezahlartPWS (String Bezahlart) {
        double ReservapBezahlart = 0;
        try {
            switch (Bezahlart) {
                case "Kreditkarte": {
                    ReservapBezahlart = auftrag.getBezahlart().getKreditkartePWS() + auftrag.getBezahlart().getKreditkarteZufall();
                    break;
                }
                case "Rechnung": {
                    ReservapBezahlart = ReservapBezahlart + auftrag.getBezahlart().getRechnungPWS() + auftrag.getBezahlart().getRechnungZufall();
                    break;
                }
                case "PayPal": {
                    ReservapBezahlart = auftrag.getBezahlart().getPayPalPWS() + auftrag.getBezahlart().getPayPalZufall();
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ReservapBezahlart;
    }

    /*
    Berechne den Reservationspreis
     */
    public void berechneReservationspreis(String ReservationspreisZeitarbeiter,
                                          String ReservationspreisForschung, String ReservationspreisMarketing,
                                          String ReservationspreisArmband, String ReservationspreisUhrwerk,
                                          String ReservationspreisGehäuse, String ReservationspreisBezahlart) {
        // Summe der PWS aus den verschiedenen Produktionsschritten bilden
        double PWS = getPWS(ReservationspreisZeitarbeiter, ReservationspreisForschung, ReservationspreisMarketing,
                ReservationspreisArmband, ReservationspreisUhrwerk, ReservationspreisGehäuse, ReservationspreisBezahlart);
        // Stückkosten berechnen
        double stueckKosten = VariableKosten + Fixkosten / Produktionsvolumen;
        // Reservationspreis berechnen, indem die Stückkosten mit der PWS (1+PWS) multipliziert werden
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
    }
} // Ende Klasse getBonus