package com.example.patsc.fallstudie;



/**
 * Created by Jonas on 02.01.17.
 */

public class Preissimulation {

    /*
    Wichtige Attribute
     */
    private Auftragssammlung auftragssammlung;
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

    private double Produktionsvolumen = auftragssammlung.getAuftrag(RundenNr).getMenge();
    private double Gesamtkosten;
    private double Stückkosten;

    private double Reservationspreis;
    private double ReservapPersonalwesen;
    private double ReservapZeitarbeiter;
    private double ReservapForschung;
    private double ReservapMarketing;
    private double ReservapArmband;
    private double ReservapUhrwerk;
    private double ReservapGehäuse;

    /*
    Konstruktor für die Preissimulation
     */
    public Preissimulation (int RundenNr, Auftragssammlung auftragssammlung) {
        this.RundenNr = RundenNr;
        this.auftragssammlung = auftragssammlung;
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


    /*
    Berechne die Fixkosten für einen Auftrag!
    */
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
                FixkostenForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getFixkostenInvestition2500();
                break;
            }
            case "1500€ Investition": {
                FixkostenForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getFixkostenInvestition1500();
                break;
            }
            case "500€ Investition": {
                FixkostenForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getFixkostenInvestition500();
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

    /*
    Berechne die Variablen Stückkosten für einen Auftrag
     */
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

    /*
    Berechne die Variablen Kosten
     */
    public void berechneVariableKosten() {
        VariableKosten = VariableStückKosten * Produktionsvolumen;
    }

    /*
    Berechne die Gesamtkosten
     */
    public void berechneGesamtkosten() {
        Gesamtkosten = Fixkosten + VariableKosten;
    }

    /*
    Berechne die Stückkosten
     */
    public void berechneStückkosten() {
        Stückkosten = Gesamtkosten / Produktionsvolumen;
    }

    /*
    Berechne den Reservationspreis
     */
    public void berechneReservationspreis(String ReservationspreisPersonalwesen, String ReservationspreisZeitarbeiter,
                                          String ReservationspreisForschung, String ReservationspreisMarketing,
                                          String ReservationspreisArmband, String ReservationspreisUhrwerk,
                                          String ReservationspreisGehäuse) {
        switch (ReservationspreisPersonalwesen) {
            case "Eingestellte": {
                // ReservapPersonalwesen = FixkostenPersonalwesen * (1 + )
                break;
            }
            case "Veränderung": {
                // ReservapPersonalwesen = FixkostenPersonalwesen * (1 + )
                break;
            }
            default: System.err.println();
        }
        switch (ReservationspreisZeitarbeiter) {
            case "Geselle": {
                ReservapZeitarbeiter = VariableStückkostenZeitarbeiter *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getGesellePWS());
                break;
            }
            case "Praktikant": {
                ReservapZeitarbeiter = VariableStückkostenZeitarbeiter *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getPraktikantPWS());
                break;
            }
            case "Lehrling": {
                ReservapZeitarbeiter = VariableStückkostenZeitarbeiter *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getLehrlingPWS());
                break;
            }
            case "Meister": {
                ReservapZeitarbeiter = VariableStückkostenZeitarbeiter *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getMeisterPWS());
                break;
            }
            default: System.err.println();
        }
        switch (ReservationspreisForschung) {
            case "2500€ Investition": {
                ReservapForschung = FixkostenForschung *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition2500PWS());
                break;
            }
            case "1500€ Investition": {
                ReservapForschung = FixkostenForschung *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition1500PWS());
                break;
            }
            case "500€ Investition": {
                ReservapForschung = FixkostenForschung *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition500PWS());
                break;
            }
            default: System.err.println();
        }
        switch (ReservationspreisMarketing) {
            case "Fernsehwerbung": {
                ReservapMarketing = FixkostenMarketing *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getFernsehwerbungPWS());
                break;
            }
            case "Radiowerbung": {
                ReservapMarketing = FixkostenMarketing *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getRadiowerbungPWS());
                break;
            }
            case "Printwerbung": {
                ReservapMarketing = FixkostenMarketing *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getPrintwerbungPWS());
                break;
            }
            default: System.err.println();
        }
        switch (ReservationspreisArmband) {
            case "Leder": {
                ReservapArmband = VariableStückkostenArmband *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getLederPWS());
                break;
            }
            case "Kunstleder": {
                ReservapArmband = VariableStückkostenArmband *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederPWS());
                break;
            }
            case "Holz": {
                ReservapArmband = VariableStückkostenArmband *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzPWS());
                break;
            }
            case "Textil": {
                ReservapArmband = VariableStückkostenArmband *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilPWS());
                break;
            }
            case "Metall": {
                ReservapArmband = VariableStückkostenArmband *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallPWS());
                break;
            }
            default: System.err.println();
        }
        switch (ReservationspreisUhrwerk) {
            case "Mechanisch": {
                ReservapUhrwerk = VariableStückkostenUhrwerk *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getMechanischPWS());
                break;
            }
            case "Elektromechanisch": {
                ReservapUhrwerk = VariableStückkostenUhrwerk *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getElektromechanischPWS());
                break;
            }
            case "Elektronisch": {
                ReservapUhrwerk = VariableStückkostenUhrwerk *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getEletronischPWS());
                break;
            }
            default: System.err.println();
        }
        switch (ReservationspreisGehäuse) {
            case "Glas": {
                ReservapGehäuse = VariableStückkostenGehäuse *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasPWS());
                break;
            }
            case "Holz": {
                ReservapGehäuse = VariableStückkostenGehäuse *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzPWS());
                break;
            }
            case "Kunststoff": {
                ReservapGehäuse = VariableStückkostenGehäuse *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffPWS());
                break;
            }
            case "Metall": {
                ReservapGehäuse = VariableStückkostenGehäuse *
                        (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallPWS());
                break;
            }
            default: System.err.println();
        }
        Reservationspreis = (ReservapPersonalwesen + ReservapForschung + ReservapMarketing + FixkostenBezahlart)
                + ((ReservapZeitarbeiter + ReservapArmband + ReservapUhrwerk + ReservapGehäuse) * Produktionsvolumen);
    } // Ende berechneReservationspreis()

} // Ende Klasse