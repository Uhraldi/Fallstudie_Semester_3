package com.example.patsc.fallstudie;



/**
 * Created by Jonas on 02.01.17.
 */

public class Preissimulation{

    // Wichtige Attribute
    private double Einkaufspreis;
    private double Verkaufspreis;
    private int RundenNr;
    private Auftragssammlung auftragssammlung;

    // 1. Schritt
    private double DesignerEkp;
    private double DesignerVkp;

    // 2. Schritt
    private double ArmbandEkp;
    private double ArmbandVkp;

    // 3. Schritt
    private double UhrwerkEkp;
    private double UhrwerkVkp;

    // 4. Schritt
    private double GehäuseUhrwerkEkp;
    private double GehäuseUhrwerkVkp;

    // 5. Schritt
    private double VersandartEkp;
    private double VersandartVkp;

    // 6. Schritt
    private double WasserdichtheitEkp;
    private double WasserdichtheitVkp;

    // 7. Schritt
    private double ProduktionsortEkp;
    private double ProduktionsortVkp;

    // 8. Schritt
    private double WerbungEkp;
    private double WerbungVkp;


    // Konstruktor für die Preissimulation
    public Preissimulation (int RundenNr, Auftragssammlung auftragssammlung) {
        this.RundenNr = RundenNr;
        this.auftragssammlung = auftragssammlung;
    }



    // zum Test: Auftragssammlung auftragssammlung = new Auftragssammlung();

    // Getter-Methoden
    public double getEinkaufspreis() { return Einkaufspreis; }
    public double getVerkaufspreis() { return Verkaufspreis; }



    // Methoden für die einzelnen Bestellschritte

    public void berechneDesigner(String auswahlDesigner) {
        switch (auswahlDesigner) {
            case "Marken": {
                DesignerEkp = auftragssammlung.getBestellposition(RundenNr).getDesigner().getMarkenEKP();
                DesignerVkp = (DesignerEkp
                        * auftragssammlung.getBestellposition(RundenNr).getDesigner().getMarkenPWS())
                        + DesignerEkp;
                break;
            }
            case "Mittelmäßig": {
                DesignerEkp = auftragssammlung.getBestellposition(RundenNr).getDesigner().getMittelmaessigEKP();
                DesignerVkp = (DesignerEkp
                        * auftragssammlung.getBestellposition(RundenNr).getDesigner().getMittelmaessigPWS())
                        + DesignerEkp;
                break;
            }
            case "Low Budget": {
                DesignerEkp = auftragssammlung.getBestellposition(RundenNr).getDesigner().getLowBudgetEKP();
                DesignerVkp = (DesignerEkp
                        * auftragssammlung.getBestellposition(RundenNr).getDesigner().getLowBudgetPWS())
                        + DesignerEkp;
                break;
            }
            default: System.err.println();
        }

    }

    public void berechneArmband(String auswahlArmband) {
        switch (auswahlArmband) {
            case "Leder": {
                ArmbandEkp = auftragssammlung.getBestellposition(RundenNr).getArmband().getLederEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getLederPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getLederZufall())
                        + ArmbandEkp;
                break;
            }
            case "Kunstleder": {
                ArmbandEkp = auftragssammlung.getBestellposition(RundenNr).getArmband().getKunstlederEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getKunstlederPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getKunstlederZufall())
                        + ArmbandEkp;
                break;
            }
            case "Holz": {
                ArmbandEkp = auftragssammlung.getBestellposition(RundenNr).getArmband().getHolzEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getHolzPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getHolzZufall())
                        + ArmbandEkp;
                break;
            }
            case "Textil": {
                ArmbandEkp = auftragssammlung.getBestellposition(RundenNr).getArmband().getTextilEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getTextilPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getTextilZufall())
                        + ArmbandEkp;
                break;
            }
            case "Metall": {
                ArmbandEkp = auftragssammlung.getBestellposition(RundenNr).getArmband().getMetallEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getMetallPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getBestellposition(RundenNr).getArmband().getMetallZufall())
                        + ArmbandEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneUhrwerk(String auswahlUhrwerk) {
        switch (auswahlUhrwerk) {
            case "Mechanisch": {
                UhrwerkEkp = auftragssammlung.getBestellposition(RundenNr).getUhrwerk().getMechanischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getUhrwerk().getMechanischPWS())
                        + UhrwerkEkp;
                break;
            }
            case "Elektromechanisch": {
                UhrwerkEkp = auftragssammlung.getBestellposition(RundenNr).getUhrwerk().getElektromechanischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getUhrwerk().getElektromechanischPWS())
                        + UhrwerkEkp;
                break;
            }
            case "Elektronisch": {
                UhrwerkEkp = auftragssammlung.getBestellposition(RundenNr).getUhrwerk().getElektronischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getUhrwerk().getEletronischPWS())
                        + UhrwerkEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneGehäuseUhrwerk(String auswahlGehäuseUhrwerk) {
        switch (auswahlGehäuseUhrwerk) {
            case "Glas": {
                GehäuseUhrwerkEkp = auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getGlasEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getGlasPWS())
                        + (GehäuseUhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getGlasZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Holz": {
                GehäuseUhrwerkEkp = auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getHolzEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getHolzPWS())
                        + (GehäuseUhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getHolzZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Kunststoff": {
                GehäuseUhrwerkEkp = auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getKunststoffEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getKunststoffPWS())
                        + (GehäuseUhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getKunststoffZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Metall": {
                GehäuseUhrwerkEkp = auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getMetallEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getMetallPWS())
                        + (GehäuseUhrwerkEkp
                        * auftragssammlung.getBestellposition(RundenNr).getGehaeuse().getMetallZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneVersandart(String auswahlVersandart) {
        switch (auswahlVersandart) {
            case "Flugzeug": {
                VersandartEkp = auftragssammlung.getBestellposition(RundenNr).getVersandart().getFlugzeugEKP();
                VersandartVkp = (VersandartEkp
                        * auftragssammlung.getBestellposition(RundenNr).getVersandart().getFlugzeugPWS())
                        + (VersandartEkp
                        * auftragssammlung.getBestellposition(RundenNr).getVersandart().getFlugzeugZufall())
                        + VersandartEkp;
                break;
            }
            case "Schiff": {
                VersandartEkp = auftragssammlung.getBestellposition(RundenNr).getVersandart().getSchiffEKP();
                VersandartVkp = (VersandartEkp
                        * auftragssammlung.getBestellposition(RundenNr).getVersandart().getSchiffPWS())
                        + (VersandartEkp
                        * auftragssammlung.getBestellposition(RundenNr).getVersandart().getSchiffZufall())
                        + VersandartEkp;
                break;
            }
            case "Landweg": {
                VersandartEkp = auftragssammlung.getBestellposition(RundenNr).getVersandart().getLandwegEKP();
                VersandartVkp = (VersandartEkp
                        * auftragssammlung.getBestellposition(RundenNr).getVersandart().getLandwegPWS())
                        + (VersandartEkp
                        * auftragssammlung.getBestellposition(RundenNr).getVersandart().getLandwegZufall())
                        + VersandartEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneWasserdichtheit(String auswahlWasserdichtheit) {
        switch (auswahlWasserdichtheit) {
            case "nicht wassergeschützt": {
                WasserdichtheitEkp = auftragssammlung.getBestellposition(RundenNr).getWasserdichtheit().getNichtWassergeschütztEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * auftragssammlung.getBestellposition(RundenNr).getWasserdichtheit().getNichtWassergeschütztPWS())
                        + WasserdichtheitEkp;
                break;
            }
            case "spritzwassergeschützt": {
                WasserdichtheitEkp = auftragssammlung.getBestellposition(RundenNr).getWasserdichtheit().getSpritzwassergeschütztEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * auftragssammlung.getBestellposition(RundenNr).getWasserdichtheit().getSpritzwassergeschütztPWS())
                        + WasserdichtheitEkp;
                break;
            }
            case "wasserdicht": {
                WasserdichtheitEkp = auftragssammlung.getBestellposition(RundenNr).getWasserdichtheit().getWasserdichtEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * auftragssammlung.getBestellposition(RundenNr).getWasserdichtheit().getWasserdichtPWS())
                        + WasserdichtheitEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneProduktionsort (String auswahlProduktionsort) {
        switch (auswahlProduktionsort) {
            case "Deutschland": {
                ProduktionsortEkp = auftragssammlung.getBestellposition(RundenNr).getZusammenbau().getDeutschlandEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * auftragssammlung.getBestellposition(RundenNr).getZusammenbau().getDeutschlandPWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Asien": {
                ProduktionsortEkp = auftragssammlung.getBestellposition(RundenNr).getZusammenbau().getAsienEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * auftragssammlung.getBestellposition(RundenNr).getZusammenbau().getAsienPWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Osteuropa": {
                ProduktionsortEkp = auftragssammlung.getBestellposition(RundenNr).getZusammenbau().getOsteuropaEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * auftragssammlung.getBestellposition(RundenNr).getZusammenbau().getOsteuropaPWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Schweiz": {
                ProduktionsortEkp = auftragssammlung.getBestellposition(RundenNr).getZusammenbau().getSchweizEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * auftragssammlung.getBestellposition(RundenNr).getZusammenbau().getSchweizPWS())
                        + ProduktionsortEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneWerbung (String auswahlWerbung) {
        switch (auswahlWerbung) {
            case "viel": {
                WerbungEkp = auftragssammlung.getBestellposition(RundenNr).getWerbung().getVielEKP();
                WerbungVkp = (WerbungEkp
                        * auftragssammlung.getBestellposition(RundenNr).getWerbung().getVielPWS())
                        + WerbungEkp;
                break;
            }
            case "mittel": {
                WerbungEkp = auftragssammlung.getBestellposition(RundenNr).getWerbung().getMittelEKP();
                WerbungVkp = (WerbungEkp
                        * auftragssammlung.getBestellposition(RundenNr).getWerbung().getMittelPWS())
                        + WerbungEkp;
                break;
            }
            case "wenig": {
                WerbungEkp = auftragssammlung.getBestellposition(RundenNr).getWerbung().getWenigEKP();
                WerbungVkp = (WerbungEkp
                        * auftragssammlung.getBestellposition(RundenNr).getWerbung().getWenigPWS())
                        + WerbungEkp;
                break;
            }
            default: System.err.println();
        }
    }


    // Methode um endgültig den Preis zu berechnen

    public void berechnePreis() {
       Einkaufspreis = DesignerEkp
                        + ArmbandEkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + UhrwerkEkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + GehäuseUhrwerkEkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + VersandartEkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + WasserdichtheitEkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + ProduktionsortEkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + WerbungEkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        ;

       Verkaufspreis = DesignerVkp
                        + ArmbandVkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + UhrwerkVkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + GehäuseUhrwerkVkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + VersandartVkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + WasserdichtheitVkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + ProduktionsortVkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        + WerbungVkp * auftragssammlung.getBestellposition(RundenNr).getMenge()
                        ;
    }

} //Ende Klasse