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
                ReservapZeitarbeiter = auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getGesellePWS();
                //ReservapZeitarbeiter = auftrag.getZeitarbeiter().getVarKostenGeselle() *
                  //      (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getGesellePWS()) *
                  //      (1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getGeselleZufall());
                break;
            }
            case "Praktikant": {
                ReservapZeitarbeiter =auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getPraktikantPWS();
                //auftrag.getZeitarbeiter().getVarKostenPraktikant(); //*
                        //(1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getPraktikantPWS()) *
                        //(1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getPraktikantZufall());
                break;
            }
            case "Lehrling": {
                ReservapZeitarbeiter = auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getLehrlingPWS();//auftrag.getZeitarbeiter().getVarKostenLehrling();// *
                        //(1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getLehrlingPWS()) *
                        //(1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getLehrlingZufall());
                break;
            }
            case "Meister": {
                ReservapZeitarbeiter = auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getMeisterPWS();
                //auftrag.getZeitarbeiter().getVarKostenMeister();
                        //*
                        //(1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getMeisterPWS()) *
                        //(1 + auftragssammlung.getAuftrag(RundenNr).getZeitarbeiter().getMeisterZufall());
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
                    ReservapForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition15000PWS();//auftrag.getForschung().getFixkostenInvestition15000() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition15000PWS());
                    break;
                }
                case "8000€ Investition": {
                    ReservapForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition8000PWS();
                    //auftrag.getForschung().getFixkostenInvestition8000() *
                      //      (1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition8000PWS());
                    break;
                }
                case "2500€ Investition": {
                    ReservapForschung = auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition2500PWS();
                            //auftrag.getForschung().getFixkostenInvestition2500() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getForschung().getInvestition2500PWS());
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

                case "Fernsehwerbung": {
                    ReservapMarketing = auftragssammlung.getAuftrag(RundenNr).getMarketing().getFernsehwerbungPWS();
                    //auftrag.getMarketing().getFixkostenFernsehwerbung() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getFernsehwerbungPWS());
                    //break;
                }
                case "Radiowerbung": {
                    ReservapMarketing =ReservapMarketing + auftragssammlung.getAuftrag(RundenNr).getMarketing().getRadiowerbungPWS();
                    //auftrag.getMarketing().getFixkostenRadiowerbung() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getRadiowerbungPWS());
                    //break;
                }
                case "Printwerbung": {
                    ReservapMarketing = ReservapMarketing+auftragssammlung.getAuftrag(RundenNr).getMarketing().getPrintwerbungPWS();//auftrag.getMarketing().getFixkostenPrintwerbung() *
                           // (1 + auftragssammlung.getAuftrag(RundenNr).getMarketing().getPrintwerbungPWS());
                   // break;
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
                    ReservapArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getLederPWS()+auftragssammlung.getAuftrag(RundenNr).getArmband().getLederZufall();
                            //auftrag.getArmband().getVarKostenLeder() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getLederPWS()) *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getLederZufall());
                    break;
                }
                case "Kunstleder": {
                    ReservapArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederPWS()+auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederZufall();
                            //auftrag.getArmband().getVarKostenKunstleder() *
                           // (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederPWS()) *
                         //   (1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederZufall());
                    break;
                }
                case "Holz": {
                    ReservapArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzZufall() + auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzPWS();
                            //auftrag.getArmband().getVarKostenHolz() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzPWS()) *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzZufall());
                    break;
                }
                case "Textil": {
                    ReservapArmband =auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilPWS()+ auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilZufall();
                            //auftrag.getArmband().getVarKostenTextil() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilPWS()) *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilZufall());
                    break;
                }
                case "Metall": {
                    ReservapArmband = auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallPWS()+auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallZufall();
                    //auftrag.getArmband().getVarKostenMetall() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallPWS()) *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallZufall());
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
                    ReservapUhrwerk = auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getMechanischPWS();//auftrag.getUhrwerk().getVarKostenMechanisch() *
                           // (1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getMechanischPWS());
                    break;
                }
                case "Elektromechanisch": {
                    ReservapUhrwerk = auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getElektromechanischPWS();
                            //auftrag.getUhrwerk().getVarKostenElektromechanisch() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getElektromechanischPWS());
                    break;
                }
                case "Elektronisch": {
                    ReservapUhrwerk =auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getEletronischPWS();
                    //auftrag.getUhrwerk().getVarKostenElektronisch() *
                      //      (1 + auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getEletronischPWS());
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
                    ReservapGehäuse = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasPWS() + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasZufall();
                            //auftrag.getGehaeuse().getVarKostenGlas() *
 //                           (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasPWS()) *
   //                         (1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasZufall());
                    break;
                }
                case "Holz": {
                    ReservapGehäuse = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzPWS()+auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzZufall();
                            //auftrag.getGehaeuse().getVarKostenHolz() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzPWS()) *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzZufall());
                    break;
                }
                case "Kunststoff": {
                    ReservapGehäuse = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffPWS() + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffZufall();
                            //auftrag.getGehaeuse().getVarKostenKunststoff() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffPWS()) *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffZufall());
                    break;
                }
                case "Metall": {
                    ReservapGehäuse = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallPWS() + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallZufall();
                            //auftrag.getGehaeuse().getVarKostenMetall() *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallPWS()) *
                            //(1 + auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallZufall());
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
                    ReservapBezahlart = auftragssammlung.getAuftrag(RundenNr).getBezahlart().getKreditkartePWS() + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getKreditkarteZufall();
                    //auftrag.getBezahlart().getFixkostenKreditkarte() *
                    // (1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getKreditkartePWS()) *
                    //(1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getKreditkarteZufall());
                    // break;
                }
                case "Rechnung": {
                    ReservapBezahlart = ReservapBezahlart + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getRechnungPWS() + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getRechnungZufall();
                    //auftrag.getBezahlart().getFixkostenRechnung() *
                    //(1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getRechnungPWS()) *
                    //(1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getRechnungZufall());
                    // break;
                }
                case "PayPal": {
                    ReservapBezahlart = auftragssammlung.getAuftrag(RundenNr).getBezahlart().getPayPalPWS() + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getPayPalZufall();
                    //auftrag.getBezahlart().getFixkostenPayPal() *
                    //(1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getPayPalPWS()) *
                    // (1 + auftragssammlung.getAuftrag(RundenNr).getBezahlart().getPayPalZufall());
                    // break;
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
        //Produktionsvolumen = auftragssammlung.getAuftrag(RundenNr).getMenge();

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