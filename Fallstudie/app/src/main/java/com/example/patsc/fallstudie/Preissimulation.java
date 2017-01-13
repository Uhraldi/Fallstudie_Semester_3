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
                DesignerEkp = auftragssammlung.getAuftrag(RundenNr).getForschung().getMarkenEKP();
                DesignerVkp = (DesignerEkp
                        * auftragssammlung.getAuftrag(RundenNr).getForschung().getMarkenPWS())
                        + DesignerEkp;
                break;
            }
            case "Mittelmäßig": {
                DesignerEkp = auftragssammlung.getAuftrag(RundenNr).getForschung().getMittelmaessigEKP();
                DesignerVkp = (DesignerEkp
                        * auftragssammlung.getAuftrag(RundenNr).getForschung().getMittelmaessigPWS())
                        + DesignerEkp;
                break;
            }
            case "Low Budget": {
                DesignerEkp = auftragssammlung.getAuftrag(RundenNr).getForschung().getLowBudgetEKP();
                DesignerVkp = (DesignerEkp
                        * auftragssammlung.getAuftrag(RundenNr).getForschung().getLowBudgetPWS())
                        + DesignerEkp;
                break;
            }
            default: System.err.println();
        }

    }

    public void berechneArmband(String auswahlArmband) {
        switch (auswahlArmband) {
            case "Leder": {
                ArmbandEkp = auftragssammlung.getAuftrag(RundenNr).getArmband().getLederEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getLederPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getLederZufall())
                        + ArmbandEkp;
                break;
            }
            case "Kunstleder": {
                ArmbandEkp = auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getKunstlederZufall())
                        + ArmbandEkp;
                break;
            }
            case "Holz": {
                ArmbandEkp = auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getHolzZufall())
                        + ArmbandEkp;
                break;
            }
            case "Textil": {
                ArmbandEkp = auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getTextilZufall())
                        + ArmbandEkp;
                break;
            }
            case "Metall": {
                ArmbandEkp = auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallEKP();
                ArmbandVkp = (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallPWS())
                        + (ArmbandEkp
                        * auftragssammlung.getAuftrag(RundenNr).getArmband().getMetallZufall())
                        + ArmbandEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneUhrwerk(String auswahlUhrwerk) {
        switch (auswahlUhrwerk) {
            case "Mechanisch": {
                UhrwerkEkp = auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getMechanischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getMechanischPWS())
                        + UhrwerkEkp;
                break;
            }
            case "Elektromechanisch": {
                UhrwerkEkp = auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getElektromechanischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getElektromechanischPWS())
                        + UhrwerkEkp;
                break;
            }
            case "Elektronisch": {
                UhrwerkEkp = auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getElektronischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getUhrwerk().getEletronischPWS())
                        + UhrwerkEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneGehäuseUhrwerk(String auswahlGehäuseUhrwerk) {
        switch (auswahlGehäuseUhrwerk) {
            case "Glas": {
                GehäuseUhrwerkEkp = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasPWS())
                        + (GehäuseUhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getGlasZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Holz": {
                GehäuseUhrwerkEkp = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzPWS())
                        + (GehäuseUhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getHolzZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Kunststoff": {
                GehäuseUhrwerkEkp = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffPWS())
                        + (GehäuseUhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getKunststoffZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Metall": {
                GehäuseUhrwerkEkp = auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallPWS())
                        + (GehäuseUhrwerkEkp
                        * auftragssammlung.getAuftrag(RundenNr).getGehaeuse().getMetallZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneVersandart(String auswahlVersandart) {
        switch (auswahlVersandart) {
            case "Kreditkarte": {
                VersandartEkp = auftragssammlung.getAuftrag(RundenNr).getVersandart().getKreditkarteEKP();
                VersandartVkp = (VersandartEkp
                        * auftragssammlung.getAuftrag(RundenNr).getVersandart().getKreditkartePWS())
                        + (VersandartEkp
                        * auftragssammlung.getAuftrag(RundenNr).getVersandart().getKreditkarteZufall())
                        + VersandartEkp;
                break;
            }
            case "Rechnung": {
                VersandartEkp = auftragssammlung.getAuftrag(RundenNr).getVersandart().getRechnungEKP();
                VersandartVkp = (VersandartEkp
                        * auftragssammlung.getAuftrag(RundenNr).getVersandart().getRechnungPWS())
                        + (VersandartEkp
                        * auftragssammlung.getAuftrag(RundenNr).getVersandart().getRechnungZufall())
                        + VersandartEkp;
                break;
            }
            case "PayPal": {
                VersandartEkp = auftragssammlung.getAuftrag(RundenNr).getVersandart().getPayPalEKP();
                VersandartVkp = (VersandartEkp
                        * auftragssammlung.getAuftrag(RundenNr).getVersandart().getPayPalPWS())
                        + (VersandartEkp
                        * auftragssammlung.getAuftrag(RundenNr).getVersandart().getPayPalZufall())
                        + VersandartEkp;
                break;
            }
            default: System.err.println();
        }
    }

  /*  public void berechneWasserdichtheit(String auswahlWasserdichtheit) {
        switch (auswahlWasserdichtheit) {
            case "nicht wassergeschützt": {
                WasserdichtheitEkp = auftragssammlung.getAuftrag(RundenNr).getWasserdichtheit().getNichtWassergeschütztEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * auftragssammlung.getAuftrag(RundenNr).getWasserdichtheit().getNichtWassergeschütztPWS())
                        + WasserdichtheitEkp;
                break;
            }
            case "spritzwassergeschützt": {
                WasserdichtheitEkp = auftragssammlung.getAuftrag(RundenNr).getWasserdichtheit().getSpritzwassergeschütztEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * auftragssammlung.getAuftrag(RundenNr).getWasserdichtheit().getSpritzwassergeschütztPWS())
                        + WasserdichtheitEkp;
                break;
            }
            case "wasserdicht": {
                WasserdichtheitEkp = auftragssammlung.getAuftrag(RundenNr).getWasserdichtheit().getWasserdichtEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * auftragssammlung.getAuftrag(RundenNr).getWasserdichtheit().getWasserdichtPWS())
                        + WasserdichtheitEkp;
                break;
            }
            default: System.err.println();
        }
    }*/

    public void berechneProduktionsort (String auswahlProduktionsort) {
        switch (auswahlProduktionsort) {
            case "Geselle": {
                ProduktionsortEkp = auftragssammlung.getAuftrag(RundenNr).getZusammenbau().getGeselleEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * auftragssammlung.getAuftrag(RundenNr).getZusammenbau().getGesellePWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Praktikant": {
                ProduktionsortEkp = auftragssammlung.getAuftrag(RundenNr).getZusammenbau().getPraktikantEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * auftragssammlung.getAuftrag(RundenNr).getZusammenbau().getPraktikantPWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Lehrling": {
                ProduktionsortEkp = auftragssammlung.getAuftrag(RundenNr).getZusammenbau().getLehrlingEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * auftragssammlung.getAuftrag(RundenNr).getZusammenbau().getLehrlingPWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Meister": {
                ProduktionsortEkp = auftragssammlung.getAuftrag(RundenNr).getZusammenbau().getMeisterEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * auftragssammlung.getAuftrag(RundenNr).getZusammenbau().getMeisterPWS())
                        + ProduktionsortEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneWerbung (String auswahlWerbung) {
        switch (auswahlWerbung) {
            case "Fernsehwerbung": {
                WerbungEkp = auftragssammlung.getAuftrag(RundenNr).getMarketing().getFernsehwerbungEKP();
                WerbungVkp = (WerbungEkp
                        * auftragssammlung.getAuftrag(RundenNr).getMarketing().getFernsehwerbungPWS())
                        + WerbungEkp;
                break;
            }
            case "mittel": {
                WerbungEkp = auftragssammlung.getAuftrag(RundenNr).getMarketing().getRadiowerbungEKP();
                WerbungVkp = (WerbungEkp
                        * auftragssammlung.getAuftrag(RundenNr).getMarketing().getRadiowerbungPWS())
                        + WerbungEkp;
                break;
            }
            case "wenig": {
                WerbungEkp = auftragssammlung.getAuftrag(RundenNr).getMarketing().getPrintwerbungEKP();
                WerbungVkp = (WerbungEkp
                        * auftragssammlung.getAuftrag(RundenNr).getMarketing().getPrintwerbungPWS())
                        + WerbungEkp;
                break;
            }
            default: System.err.println();
        }
    }


    // Methode um endgültig den Preis zu berechnen

    public void berechnePreis() {
       Einkaufspreis = DesignerEkp
                        + ArmbandEkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + UhrwerkEkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + GehäuseUhrwerkEkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + VersandartEkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + WasserdichtheitEkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + ProduktionsortEkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + WerbungEkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        ;

       Verkaufspreis = DesignerVkp
                        + ArmbandVkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + UhrwerkVkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + GehäuseUhrwerkVkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + VersandartVkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + WasserdichtheitVkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + ProduktionsortVkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        + WerbungVkp * auftragssammlung.getAuftrag(RundenNr).getMenge()
                        ;
    }

} //Ende Klasse