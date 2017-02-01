package com.example.patsc.fallstudie.Covered;


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

    private double Fixkosten;
    private double FixkostenPersonalwesen;
    private double FixkostenForschung;
    private double FixkostenMarketing;
    private double FixkostenBezahlart;

    private double VariableKosten;
    private double VariableStückKosten;
    private double VariableStückkostenZeitarbeiter;
    private double VariableStückkostenArmband;
    private double VariableStückkostenUhrwerk;
    private double VariableStückkostenGehäuse;

    private double Produktionsvolumen;
    private double Gesamtkosten;
    private double Stückkosten;

   // public String toString(){
     //   String persoString;
       // persoString = Fixkosten + ":" + FixkostenPersonalwesen + ":" + FixkostenForschung + ":" + FixkostenForschung + ":" +  FixkostenMarketing + ":" +FixkostenBezahlart + ":";
      //  persoString = persoString + ":" + VariableKosten + ":" +VariableStückKosten + ":"+ VariableStückkostenZeitarbeiter + ":"+ VariableStückkostenArmband + ":"+ VariableStückkostenUhrwerk + ":"+ VariableStückkostenGehäuse+ ":";
      //  return persoString;
   // }

    private double Reservationspreis;
    private double ReservapZeitarbeiter;
    private double ReservapForschung;
    private double ReservapMarketing;
    private double ReservapArmband;
    private double ReservapUhrwerk;
    private double ReservapGehäuse;
    private double ReservapBezahlart;

    /*
    Konstruktor für die Preissimulation
     */
    public Preissimulation (Controller controller) {
        this.RundenNr = controller.getRunde();
        this.auftragssammlung = controller.getAktiverSpieler().getAuftragssammlung();
        c = controller;
        auftrag = c.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag();
        berechneReservationspreis(c.getZeitarbeiterAktuellerAuftrag(), c.getForschungAktuellerAuftrag(), c.getMarketingAktuellerAuftrag(), c.getArmbandAktuellerAuftrag(),
                c.getGehaeuseAktuellerAuftrag(), c.getUhrwerkAktuellerAuftrag(), c.getBezahlartAktuellerAuftrag());

       //ToDo berechneReservationspreis(c.getMarketingAktuellerAuftrag(),c.getZeitarbeiterAktuellerAuftrag(),c.get)

        /*
        berechneGesamtkosten();
        berechneStückkosten();
        */

    }

    /*
    Getter-Methoden
     */
    public double getFixkosten() { return Fixkosten; }
    public double getVariableStückKosten() { return VariableStückKosten; }
    public double getVariableKosten() {
        return VariableKosten;
    }
    public double getGesamtkosten() {
        return Gesamtkosten;
    }
    public double getStückkosten() { return Stückkosten; }
    public double getReservationspreis() {
        return Reservationspreis;
    }

    /* Berechnung vorerst in der Klasse Auftrag


    public void berechneFixkosten(String auswahlPersonalwesen, String auswahlForschung, String auswahlMarketing, String auswahlBezahlart) {
        switch (auswahlPersonalwesen) {
            case "Eingestellte": {
                FixkostenPersonalwesen = auftragssammlung.getAuftrag(RundenNr).getPersonalwesen().getEingestellte();
                break;
            }
            case "Veränderung": {
                FixkostenPersonalwesen = auftragssammlung.getAuftrag(RundenNr).getPersonalwesen().getVeraenderung();
                break;
            }
            default: System.err.println();
        }
        switch (auswahlForschung) {
            case "2500€ Investition": {
                FixkostenForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getFixkostenInvestition15000();
                break;
            }
            case "1500€ Investition": {
                FixkostenForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getFixkostenInvestition8000();
                break;
            }
            case "500€ Investition": {
                FixkostenForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getFixkostenInvestition2500();
                break;
            }
            default: System.err.println();
        }
        switch (auswahlMarketing) {
            case "Fernsehwerbung": {
                FixkostenMarketing = auftragssammlung.getAuftrag(RundenNr).getMarketing().getFixkostenFernsehwerbung();
                break;
            }
            case "Radiowerbung": {
                FixkostenMarketing = auftragssammlung.getAuftrag(RundenNr).getMarketing().getFixkostenRadiowerbung();
                break;
            }
            case "Printwerbung": {
                FixkostenMarketing = auftragssammlung.getAuftrag(RundenNr).getMarketing().getFixkostenPrintwerbung();
                break;
            }
            default: System.err.println();
        }
        switch (auswahlBezahlart) {
            case "Kreditkarte": {
                FixkostenBezahlart = auftragssammlung.getAuftrag(RundenNr).getBezahlart().getFixkostenKreditkarte();
                break;
            }
            case "Rechnung": {
                FixkostenBezahlart = auftragssammlung.getAuftrag(RundenNr).getBezahlart().getFixkostenRechnung();
                break;
            }
            case "PayPal": {
                FixkostenBezahlart = auftragssammlung.getAuftrag(RundenNr).getBezahlart().getFixkostenPayPal();
                break;
            }
            default: System.err.println();
        }
        Fixkosten = FixkostenPersonalwesen + FixkostenForschung + FixkostenMarketing + FixkostenBezahlart;
    } // Ende berechneFixkosten()


    public void berechneVariableStückkosten(String auswahlZeitarbeiter, String auswahlArmband, String auswahlUhrwerk, String auswahlGehäuse) {
        switch (auswahlZeitarbeiter) {
            case "Geselle": {
                VariableStückkostenZeitarbeiter = auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getVarKostenGeselle();
                break;
            }
            case "Praktikant": {
                VariableStückkostenZeitarbeiter = auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getVarKostenPraktikant();
                break;
            }
            case "Lehrling":  {
                VariableStückkostenZeitarbeiter = auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getVarKostenLehrling();
                break;
            }
            case "Meister": {
                VariableStückkostenZeitarbeiter = auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getVarKostenMeister();
                break;
            }
            default: System.err.println();
        }
        switch (auswahlArmband) {
            case "Leder": {
                VariableStückkostenArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getVarKostenLeder();
                break;
            }
            case "Kunstleder": {
                VariableStückkostenArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getVarKostenKunstleder();
                break;
            }
            case "Holz": {
                VariableStückkostenArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getVarKostenHolz();
                break;
            }
            case "Textil": {
                VariableStückkostenArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getVarKostenTextil();
                break;
            }
            case "Metall": {
                VariableStückkostenArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getVarKostenMetall();
                break;
            }
            default: System.err.println();
        }
        switch (auswahlUhrwerk) {
            case "Mechanisch": {
                VariableStückkostenUhrwerk = auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getVarKostenMechanisch();
                break;
            }
            case "Elektromechanisch": {
                VariableStückkostenUhrwerk = auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getVarKostenElektromechanisch();
                break;
            }
            case "Elektronisch": {
                VariableStückkostenUhrwerk = auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getVarKostenElektronisch();
                break;
            }
            default: System.err.println();
        }
        switch (auswahlGehäuse) {
            case "Glas": {
                VariableStückkostenGehäuse = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getVarKostenGlas();
                break;
            }
            case "Holz": {
                VariableStückkostenGehäuse = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getVarKostenHolz();
                break;
            }
            case "Kunststoff": {
                VariableStückkostenGehäuse = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getVarKostenKunststoff();
                break;
            }
            case "Metall": {
                VariableStückkostenGehäuse = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getVarKostenMetall();
                break;
            }
            default: System.err.println();
        }
        VariableStückKosten = VariableStückkostenZeitarbeiter + VariableStückkostenArmband +
                VariableStückkostenUhrwerk + VariableStückkostenGehäuse;
    } // Ende berechneVariableStückkosten()


    public void berechneVariableKosten() {
        VariableKosten = VariableStückKosten * Produktionsvolumen;
    }


    public void berechneGesamtkosten() {
        Gesamtkosten = Fixkosten + VariableKosten;
    }


    public void berechneStückkosten() {
        Stückkosten = Gesamtkosten / Produktionsvolumen;
    }

    */



    /*
    Berechne den Reservationspreis
     */
    public void berechneReservationspreis(String ReservationspreisZeitarbeiter,
                                          String ReservationspreisForschung, String ReservationspreisMarketing,
                                          String ReservationspreisArmband, String ReservationspreisUhrwerk,
                                          String ReservationspreisGehäuse, String ReservationspreisBezahlart) {
        try {
            switch (ReservationspreisZeitarbeiter) {
                case "Geselle": {
                    ReservapZeitarbeiter = auftrag.getZeitarbeiter().getVarKostenGeselle() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getGesellePWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getGeselleZufall());
                    break;
                }
                case "Praktikant": {
                    ReservapZeitarbeiter = auftrag.getZeitarbeiter().getVarKostenPraktikant() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getPraktikantPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getPraktikantZufall());
                    break;
                }
                case "Lehrling": {
                    ReservapZeitarbeiter = auftrag.getZeitarbeiter().getVarKostenLehrling() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getLehrlingPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getLehrlingZufall());
                    break;
                }
                case "Meister": {
                    ReservapZeitarbeiter = auftrag.getZeitarbeiter().getVarKostenMeister() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getMeisterPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getMeisterZufall());
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        }
        catch (Exception e) {
                e.printStackTrace();
            }
        try {
            switch (ReservationspreisForschung) {
                case "15000€ Investition": {
                    ReservapForschung = auftrag.getForschung().getFixkostenInvestition15000() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition15000PWS());
                    break;
                }
                case "8000€ Investition": {
                    ReservapForschung = auftrag.getForschung().getFixkostenInvestition8000() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition8000PWS());
                    break;
                }
                case "2500€ Investition": {
                    ReservapForschung = auftrag.getForschung().getFixkostenInvestition2500() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition2500PWS());
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            switch (ReservationspreisMarketing) {
                case "Fernsehwerbung": {
                    ReservapMarketing = auftrag.getMarketing().getFixkostenFernsehwerbung() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getFernsehwerbungPWS());
                    break;
                }
                case "Radiowerbung": {
                    ReservapMarketing = auftrag.getMarketing().getFixkostenRadiowerbung() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getRadiowerbungPWS());
                    break;
                }
                case "Printwerbung": {
                    ReservapMarketing = auftrag.getMarketing().getFixkostenPrintwerbung() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getPrintwerbungPWS());
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            switch (ReservationspreisArmband) {
                case "Leder": {
                    ReservapArmband = auftrag.getArmband().getVarKostenLeder() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getLederPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getLederZufall());
                    break;
                }
                case "Kunstleder": {
                    ReservapArmband = auftrag.getArmband().getVarKostenKunstleder() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederZufall());
                    break;
                }
                case "Holz": {
                    ReservapArmband = auftrag.getArmband().getVarKostenHolz() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzZufall());
                    break;
                }
                case "Textil": {
                    ReservapArmband = auftrag.getArmband().getVarKostenTextil() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilZufall());
                    break;
                }
                case "Metall": {
                    ReservapArmband = auftrag.getArmband().getVarKostenMetall() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallZufall());
                    break;
                }
                default: {
                     System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            switch (ReservationspreisUhrwerk) {
                case "Mechanisch": {
                    ReservapUhrwerk = auftrag.getUhrwerk().getVarKostenMechanisch() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getMechanischPWS());
                    break;
                }
                case "Elektromechanisch": {
                    ReservapUhrwerk = auftrag.getUhrwerk().getVarKostenElektromechanisch() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getElektromechanischPWS());
                    break;
                }
                case "Elektronisch": {
                    ReservapUhrwerk = auftrag.getUhrwerk().getVarKostenElektronisch() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getEletronischPWS());
                    break;
                }
                default: {
                     System.err.println("Keine Auswahl getroffen worden.");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            switch (ReservationspreisGehäuse) {
                case "Glas": {
                    ReservapGehäuse = auftrag.getGehaeuse().getVarKostenGlas() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasZufall());
                    break;
                }
                case "Holz": {
                    ReservapGehäuse = auftrag.getGehaeuse().getVarKostenHolz() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzZufall());
                    break;
                }
                case "Kunststoff": {
                    ReservapGehäuse = auftrag.getGehaeuse().getVarKostenKunststoff() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffZufall());
                    break;
                }
                case "Metall": {
                    ReservapGehäuse = auftrag.getGehaeuse().getVarKostenMetall() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallZufall());
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            switch (ReservationspreisBezahlart) {
                case "Kreditkarte": {
                    ReservapBezahlart = auftrag.getBezahlart().getFixkostenKreditkarte() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getKreditkartePWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getKreditkarteZufall());
                    break;
                }
                case "Rechnung": {
                    ReservapBezahlart = auftrag.getBezahlart().getFixkostenRechnung() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getRechnungPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getRechnungZufall());
                    break;
                }
                case "PayPal": {
                    ReservapBezahlart = auftrag.getBezahlart().getFixkostenPayPal() *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getPayPalPWS()) *
                            (1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getPayPalZufall());
                    break;
                }
                default: {
                    System.err.println("Keine Auswahl getroffen worden");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        Produktionsvolumen  = auftragssammlung.getAuftrag(RundenNr).getMenge();
        Reservationspreis = (auftrag.getPersonalwesen().getFixkosten() + ReservapForschung +
                    ReservapMarketing + ReservapBezahlart)
                + ((ReservapZeitarbeiter + ReservapArmband + ReservapUhrwerk + ReservapGehäuse) * Produktionsvolumen);
    } // Ende berechneReservationspreis()

    /**
     * ToDo Dominik
     * @return
     */

    public int getBonus(){
 /*
        for (Auftrag s : bestellpos) { //// TODO: 24.01.2017 #Dodo in Preissimulation auslagern //Controller.aktiverSpieler.getAktuellerAuftrag();<- ist der aktuelle Spieler
            double zwischenspeicher = 0;
            if (s.getBezahlartAktuellerAuftrag().isKreditkarte()) {
                zwischenspeicher += s.getBezahlartAktuellerAuftrag().getKreditkarteZufall();
            }
            if (s.getBezahlartAktuellerAuftrag().isPayPal()) {
                zwischenspeicher += s.getBezahlartAktuellerAuftrag().getPayPalZufall();
            }
            if (s.getBezahlartAktuellerAuftrag().isRechnung()) {
                zwischenspeicher += s.getBezahlartAktuellerAuftrag().getRechnungZufall();
            }
            if (s.getMarketingAktuellerAuftrag().isFernsehwerbung()) {
                zwischenspeicher += s.getMarketingAktuellerAuftrag().getFernsehwerbungPWS();
            }
            if (s.getMarketingAktuellerAuftrag().isRadiowerbung()) {
                zwischenspeicher += s.getMarketingAktuellerAuftrag().getRadiowerbungPWS();
            }
            if (s.getMarketingAktuellerAuftrag().isPrintwerbung()) {
                zwischenspeicher += s.getMarketingAktuellerAuftrag().getPrintwerbungPWS();
            }
           // prozentualeVorteile.add(zwischenspeicher);
        }
        */
        return 123;
    }
} // Ende Klasse