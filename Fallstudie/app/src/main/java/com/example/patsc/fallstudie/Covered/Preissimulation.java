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
    public Preissimulation(Controller controller) {
        this.RundenNr = controller.getRunde();
        this.auftragssammlung = controller.getAktiverSpieler().getAuftragssammlung();
        c = controller;
        auftrag = c.getAktiverSpieler().getAuftragssammlung().getAktuellerAuftrag();
        berechneReservationspreis(c.getZeitarbeiterAktuellerAuftrag(), c.getForschungAktuellerAuftrag(), c.getMarketingAktuellerAuftrag(), c.getArmbandAktuellerAuftrag(),
                 c.getUhrwerkAktuellerAuftrag(), c.getGehaeuseAktuellerAuftrag(), c.getBezahlartAktuellerAuftrag());

        //ToDo berechneReservationspreis(c.getMarketingAktuellerAuftrag(),c.getZeitarbeiterAktuellerAuftrag(),c.get)

        /*
        berechneGesamtkosten();
        berechneStückkosten();
        */

    }

    /*
    Getter-Methoden
     */
    public double getFixkosten() {
        return Fixkosten;
    }

    public double getVariableStückKosten() {
        return VariableStückKosten;
    }

    public double getVariableKosten() {
        return VariableKosten;
    }

    public double getGesamtkosten() {
        return Gesamtkosten;
    }

    public double getStückkosten() {
        return Stückkosten;
    }

    public double getReservationspreis() {
        return Reservationspreis;
    }

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


public double getPWSZeitarbeiter (String Zeitarbeiter) {
    double ReservapZeitarbeiter = 0;
    try {
        switch (Zeitarbeiter) {
            case "Geselle": {
                ReservapZeitarbeiter = auftrag.getZeitarbeiter().getGesellePWS();
                //ReservapZeitarbeiter = auftrag.getZeitarbeiter().getVarKostenGeselle() *
                  //      (1 + auftrag.getZeitarbeiter().getGesellePWS()) *
                  //      (1 + auftrag.getZeitarbeiter().getGeselleZufall());
                break;
            }
            case "Praktikant": {
                ReservapZeitarbeiter =auftrag.getZeitarbeiter().getPraktikantPWS();
                //auftrag.getZeitarbeiter().getVarKostenPraktikant(); //*
                        //(1 + auftrag.getZeitarbeiter().getPraktikantPWS()) *
                        //(1 + auftrag.getZeitarbeiter().getPraktikantZufall());
                break;
            }
            case "Lehrling": {
                ReservapZeitarbeiter = auftrag.getZeitarbeiter().getLehrlingPWS();//auftrag.getZeitarbeiter().getVarKostenLehrling();// *
                        //(1 + auftrag.getZeitarbeiter().getLehrlingPWS()) *
                        //(1 + auftrag.getZeitarbeiter().getLehrlingZufall());
                break;
            }
            case "Meister": {
                ReservapZeitarbeiter = auftrag.getZeitarbeiter().getMeisterPWS();
                //auftrag.getZeitarbeiter().getVarKostenMeister();
                        //*
                        //(1 + auftrag.getZeitarbeiter().getMeisterPWS()) *
                        //(1 + auftrag.getZeitarbeiter().getMeisterZufall());
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

    public double getForschungPWS (String Forschung){
        double ReservapForschung = 0;
        try {
            switch (Forschung) {
                case "15000€ Investition": {
                    ReservapForschung = auftrag.getForschung().getInvestition15000PWS();//auftrag.getForschung().getFixkostenInvestition15000() *
                            //(1 + auftrag.getForschung().getInvestition15000PWS());
                    break;
                }
                case "8000€ Investition": {
                    ReservapForschung = auftrag.getForschung().getInvestition8000PWS();
                    //auftrag.getForschung().getFixkostenInvestition8000() *
                      //      (1 + auftrag.getForschung().getInvestition8000PWS());
                    break;
                }
                case "2500€ Investition": {
                    ReservapForschung = auftrag.getForschung().getInvestition2500PWS();
                            //auftrag.getForschung().getFixkostenInvestition2500() *
                            //(1 + auftrag.getForschung().getInvestition2500PWS());
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

    public double getMarketingPWS (String Marketing){
        double ReservapMarketing = 0;
        try {
            switch (Marketing) {

                case "Fernseh": {
                    ReservapMarketing = auftrag.getMarketing().getFernsehwerbungPWS();
                    //auftrag.getMarketing().getFixkostenFernsehwerbung() *
                            //(1 + auftrag.getMarketing().getFernsehwerbungPWS());
                    break;
                }
                case "Radio": {
                    ReservapMarketing =ReservapMarketing + auftrag.getMarketing().getRadiowerbungPWS();
                    //auftrag.getMarketing().getFixkostenRadiowerbung() *
                            //(1 + auftrag.getMarketing().getRadiowerbungPWS());
                    break;
                }
                case "Print": {
                    ReservapMarketing = ReservapMarketing+auftrag.getMarketing().getPrintwerbungPWS();//auftrag.getMarketing().getFixkostenPrintwerbung() *
                           // (1 + auftrag.getMarketing().getPrintwerbungPWS());
                   break;
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

    public double getArmbandPWS (String Armband){
        double ReservapArmband = 0;
        try {
            switch (Armband) {
                case "Leder": {
                    ReservapArmband = auftrag.getArmband().getLederPWS()+auftrag.getArmband().getLederZufall();
                            //auftrag.getArmband().getVarKostenLeder() *
                            //(1 + auftrag.getArmband().getLederPWS()) *
                            //(1 + auftrag.getArmband().getLederZufall());
                    break;
                }
                case "Kunstleder": {
                    ReservapArmband = auftrag.getArmband().getKunstlederPWS()+auftrag.getArmband().getKunstlederZufall();
                            //auftrag.getArmband().getVarKostenKunstleder() *
                           // (1 + auftrag.getArmband().getKunstlederPWS()) *
                         //   (1 + auftrag.getArmband().getKunstlederZufall());
                    break;
                }
                case "Holz": {
                    ReservapArmband = auftrag.getArmband().getHolzZufall() + auftrag.getArmband().getHolzPWS();
                            //auftrag.getArmband().getVarKostenHolz() *
                            //(1 + auftrag.getArmband().getHolzPWS()) *
                            //(1 + auftrag.getArmband().getHolzZufall());
                    break;
                }
                case "Textil": {
                    ReservapArmband =auftrag.getArmband().getTextilPWS()+ auftrag.getArmband().getTextilZufall();
                            //auftrag.getArmband().getVarKostenTextil() *
                            //(1 + auftrag.getArmband().getTextilPWS()) *
                            //(1 + auftrag.getArmband().getTextilZufall());
                    break;
                }
                case "Metall": {
                    ReservapArmband = auftrag.getArmband().getMetallPWS()+auftrag.getArmband().getMetallZufall();
                    //auftrag.getArmband().getVarKostenMetall() *
                            //(1 + auftrag.getArmband().getMetallPWS()) *
                            //(1 + auftrag.getArmband().getMetallZufall());
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

    public double getUhrwerkPWS (String Uhrwerk){
       double ReservapUhrwerk = 0;
        try {
            switch (Uhrwerk) {
                case "Mechanisch": {
                    ReservapUhrwerk = auftrag.getUhrwerk().getMechanischPWS();//auftrag.getUhrwerk().getVarKostenMechanisch() *
                           // (1 + auftrag.getUhrwerk().getMechanischPWS());
                    break;
                }
                case "Elektromechanisch": {
                    ReservapUhrwerk = auftrag.getUhrwerk().getElektromechanischPWS();
                            //auftrag.getUhrwerk().getVarKostenElektromechanisch() *
                            //(1 + auftrag.getUhrwerk().getElektromechanischPWS());
                    break;
                }
                case "Elektronisch": {
                    ReservapUhrwerk =auftrag.getUhrwerk().getEletronischPWS();
                    //auftrag.getUhrwerk().getVarKostenElektronisch() *
                      //      (1 + auftrag.getUhrwerk().getEletronischPWS());
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

    public double getGehaeusePWS(String Gehaeuse){
        double ReservapGehäuse = 0;
        try {
            switch (Gehaeuse) {
                case "Glas": {
                    ReservapGehäuse = auftrag.getGehaeuse().getGlasPWS() + auftrag.getGehaeuse().getGlasZufall();
                            //auftrag.getGehaeuse().getVarKostenGlas() *
 //                           (1 + auftrag.getGehaeuse().getGlasPWS()) *
   //                         (1 + auftrag.getGehaeuse().getGlasZufall());
                    break;
                }
                case "Holz": {
                    ReservapGehäuse = auftrag.getGehaeuse().getHolzPWS()+auftrag.getGehaeuse().getHolzZufall();
                            //auftrag.getGehaeuse().getVarKostenHolz() *
                            //(1 + auftrag.getGehaeuse().getHolzPWS()) *
                            //(1 + auftrag.getGehaeuse().getHolzZufall());
                    break;
                }
                case "Kunststoff": {
                    ReservapGehäuse = auftrag.getGehaeuse().getKunststoffPWS() + auftrag.getGehaeuse().getKunststoffZufall();
                            //auftrag.getGehaeuse().getVarKostenKunststoff() *
                            //(1 + auftrag.getGehaeuse().getKunststoffPWS()) *
                            //(1 + auftrag.getGehaeuse().getKunststoffZufall());
                    break;
                }
                case "Metall": {
                    ReservapGehäuse = auftrag.getGehaeuse().getMetallPWS() + auftrag.getGehaeuse().getMetallZufall();
                            //auftrag.getGehaeuse().getVarKostenMetall() *
                            //(1 + auftrag.getGehaeuse().getMetallPWS()) *
                            //(1 + auftrag.getGehaeuse().getMetallZufall());
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

    public double getBezahlartPWS (String Bezahlart) {
        double ReservapBezahlart = 0;
        try {
            switch (Bezahlart) {
                case "Kreditkarte": {
                    ReservapBezahlart = auftrag.getBezahlart().getKreditkartePWS() + auftrag.getBezahlart().getKreditkarteZufall();
                    //auftrag.getBezahlart().getFixkostenKreditkarte() *
                    // (1 + auftrag.getBezahlart().getKreditkartePWS()) *
                    //(1 + auftrag.getBezahlart().getKreditkarteZufall());
                    break;
                }
                case "Rechnung": {
                    ReservapBezahlart = ReservapBezahlart + auftrag.getBezahlart().getRechnungPWS() + auftrag.getBezahlart().getRechnungZufall();
                    //auftrag.getBezahlart().getFixkostenRechnung() *
                    //(1 + auftrag.getBezahlart().getRechnungPWS()) *
                    //(1 + auftrag.getBezahlart().getRechnungZufall());
                    break;
                }
                case "PayPal": {
                    ReservapBezahlart = auftrag.getBezahlart().getPayPalPWS() + auftrag.getBezahlart().getPayPalZufall();
                    //auftrag.getBezahlart().getFixkostenPayPal() *
                    //(1 + auftrag.getBezahlart().getPayPalPWS()) *
                    // (1 + auftrag.getBezahlart().getPayPalZufall());
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

        double PWS = getPWS(ReservationspreisZeitarbeiter, ReservationspreisForschung, ReservationspreisMarketing,
                ReservationspreisArmband, ReservationspreisUhrwerk, ReservationspreisGehäuse, ReservationspreisBezahlart);
        double stueckKosten = auftrag.getVarKosten()+auftrag.getFixKosten()/auftrag.getMenge();

        double reservationspreis = stueckKosten * (1+PWS);
        this.Reservationspreis = reservationspreis;
        //Reservationspreis = (auftrag.getPersonalwesen().getFixkosten() + ReservapForschung +
            //    ReservapMarketing + ReservapBezahlart)
          //      + ((ReservapZeitarbeiter + ReservapArmband + ReservapUhrwerk + ReservapGehäuse));
        //Produktionsvolumen = auftrag.getMenge();

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