package com.example.patsc.fallstudie;



/**
 * Created by Jonas on 02.01.17.
 */

public class Preissimulation{

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
    }

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
    }

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
    public void berechneReservationspreis() {
        // ToDO
    }




} //Ende Klasse