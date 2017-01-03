package com.example.patsc.fallstudie;


import com.example.patsc.fallstudie.Bestandteile.Designer;
import com.example.patsc.fallstudie.Spieler;

/**
 * Created by Jonas on 02.01.17.
 */

public class Preissimulation extends Designer {

    private double Einkaufspreis;
    private double Verkaufspreis;
    private int RundenNr;
    private Bestellung bestellung;

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

    // zum Test: Bestellung bestellung = new Bestellung();

    public double getEinkaufspreis() { return Einkaufspreis; }
    public double getVerkaufspreis() { return Verkaufspreis; }

    public int getRundenNr() { return RundenNr; }
    public void setRundenNr(int rundenNr) { RundenNr = rundenNr; }

    public void berechneDesigner(String auswahlDesigner) {
        switch (auswahlDesigner) {
            case "Marken": {
                DesignerEkp = bestellung.getBestellposition(RundenNr).getDesigner().getMarkenEKP();
                DesignerVkp = (DesignerEkp
                        * bestellung.getBestellposition(RundenNr).getDesigner().getMarkenPWS())
                        + DesignerEkp;
                break;
            }
            case "Mittelmäßig": {
                DesignerEkp = bestellung.getBestellposition(RundenNr).getDesigner().getMittelmaessigEKP();
                DesignerVkp = (DesignerEkp
                        * bestellung.getBestellposition(RundenNr).getDesigner().getMittelmaessigPWS())
                        + DesignerEkp;
                break;
            }
            case "Low Budget": {
                DesignerEkp = bestellung.getBestellposition(RundenNr).getDesigner().getLowBudgetEKP();
                DesignerVkp = (DesignerEkp
                        * bestellung.getBestellposition(RundenNr).getDesigner().getLowBudgetPWS())
                        + DesignerEkp;
                break;
            }
            default: System.err.println();
        }

    }

    public void berechneArmband(String auswahlArmband) {
        switch (auswahlArmband) {
            case "Leder": {
                ArmbandEkp = bestellung.getBestellposition(RundenNr).getArmband().getLederEKP();
                ArmbandVkp = (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getLederPWS())
                        + (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getLederZufall())
                        + ArmbandEkp;
                break;
            }
            case "Kunstleder": {
                ArmbandEkp = bestellung.getBestellposition(RundenNr).getArmband().getKunstlederEKP();
                ArmbandVkp = (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getKunstlederPWS())
                        + (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getKunstlederZufall())
                        + ArmbandEkp;
                break;
            }
            case "Holz": {
                ArmbandEkp = bestellung.getBestellposition(RundenNr).getArmband().getHolzEKP();
                ArmbandVkp = (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getHolzPWS())
                        + (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getHolzZufall())
                        + ArmbandEkp;
                break;
            }
            case "Textil": {
                ArmbandEkp = bestellung.getBestellposition(RundenNr).getArmband().getTextilEKP();
                ArmbandVkp = (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getTextilPWS())
                        + (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getTextilZufall())
                        + ArmbandEkp;
                break;
            }
            case "Metall": {
                ArmbandEkp = bestellung.getBestellposition(RundenNr).getArmband().getMetallEKP();
                ArmbandVkp = (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getMetallPWS())
                        + (ArmbandEkp
                        * bestellung.getBestellposition(RundenNr).getArmband().getMetallZufall())
                        + ArmbandEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneUhrwerk(String auswahlUhrwerk) {
        switch (auswahlUhrwerk) {
            case "Mechanisch": {
                UhrwerkEkp = bestellung.getBestellposition(RundenNr).getUhrwerk().getMechanischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getUhrwerk().getMechanischPWS())
                        + UhrwerkEkp;
                break;
            }
            case "Elektromechanisch": {
                UhrwerkEkp = bestellung.getBestellposition(RundenNr).getUhrwerk().getElektromechanischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getUhrwerk().getElektromechanischPWS())
                        + UhrwerkEkp;
                break;
            }
            case "Elektronisch": {
                UhrwerkEkp = bestellung.getBestellposition(RundenNr).getUhrwerk().getElektronischEKP();
                UhrwerkVkp = (UhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getUhrwerk().getEletronischPWS())
                        + UhrwerkEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneGehäuseUhrwerk(String auswahlGehäuseUhrwerk) {
        switch (auswahlGehäuseUhrwerk) {
            case "Glas": {
                GehäuseUhrwerkEkp = bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasPWS())
                        + (GehäuseUhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Holz": {
                GehäuseUhrwerkEkp = bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzPWS())
                        + (GehäuseUhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Kunststoff": {
                GehäuseUhrwerkEkp = bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffPWS())
                        + (GehäuseUhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            case "Metall": {
                GehäuseUhrwerkEkp = bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallEKP();
                GehäuseUhrwerkVkp = (GehäuseUhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallPWS())
                        + (GehäuseUhrwerkEkp
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallZufall())
                        + GehäuseUhrwerkEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneVersandart(String auswahlVersandart) {
        switch (auswahlVersandart) {
            case "Flugzeug": {
                VersandartEkp = bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugEKP();
                VersandartVkp = (VersandartEkp
                        * bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugPWS())
                        + (VersandartEkp
                        * bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugZufall())
                        + VersandartEkp;
                break;
            }
            case "Schiff": {
                VersandartEkp = bestellung.getBestellposition(RundenNr).getVersandart().getSchiffEKP();
                VersandartVkp = (VersandartEkp
                        * bestellung.getBestellposition(RundenNr).getVersandart().getSchiffPWS())
                        + (VersandartEkp
                        * bestellung.getBestellposition(RundenNr).getVersandart().getSchiffZufall())
                        + VersandartEkp;
                break;
            }
            case "Landweg": {
                VersandartEkp = bestellung.getBestellposition(RundenNr).getVersandart().getLandwegEKP();
                VersandartVkp = (VersandartEkp
                        * bestellung.getBestellposition(RundenNr).getVersandart().getLandwegPWS())
                        + (VersandartEkp
                        * bestellung.getBestellposition(RundenNr).getVersandart().getLandwegZufall())
                        + VersandartEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneWasserdichtheit(String auswahlWasserdichtheit) {
        switch (auswahlWasserdichtheit) {
            case "nicht wassergeschützt": {
                WasserdichtheitEkp = bestellung.getBestellposition(RundenNr).getWasserdichtheit().getNichtWassergeschütztEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * bestellung.getBestellposition(RundenNr).getWasserdichtheit().getNichtWassergeschütztPWS())
                        + WasserdichtheitEkp;
                break;
            }
            case "spritzwassergeschützt": {
                WasserdichtheitEkp = bestellung.getBestellposition(RundenNr).getWasserdichtheit().getSpritzwassergeschütztEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * bestellung.getBestellposition(RundenNr).getWasserdichtheit().getSpritzwassergeschütztPWS())
                        + WasserdichtheitEkp;
                break;
            }
            case "wasserdicht": {
                WasserdichtheitEkp = bestellung.getBestellposition(RundenNr).getWasserdichtheit().getWasserdichtEKP();
                WasserdichtheitVkp = (WasserdichtheitEkp
                        * bestellung.getBestellposition(RundenNr).getWasserdichtheit().getWasserdichtPWS())
                        + WasserdichtheitEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneProduktionsort (String auswahlProduktionsort) {
        switch (auswahlProduktionsort) {
            case "Deutschland": {
                ProduktionsortEkp = bestellung.getBestellposition(RundenNr).getProduktionsort().getDeutschlandEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getDeutschlandPWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Asien": {
                ProduktionsortEkp = bestellung.getBestellposition(RundenNr).getProduktionsort().getAsienEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getAsienPWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Osteuropa": {
                ProduktionsortEkp = bestellung.getBestellposition(RundenNr).getProduktionsort().getOsteuropaEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getOsteuropaPWS())
                        + ProduktionsortEkp;
                break;
            }
            case "Schweiz": {
                ProduktionsortEkp = bestellung.getBestellposition(RundenNr).getProduktionsort().getSchweizEKP();
                ProduktionsortVkp = (ProduktionsortEkp
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getSchweizPWS())
                        + ProduktionsortEkp;
                break;
            }
            default: System.err.println();
        }
    }

    public void berechneWerbung (String auswahlWerbung) {
        switch (auswahlWerbung) {
            case "viel": {
                WerbungEkp = bestellung.getBestellposition(RundenNr).getWerbung().getVielEKP();
                WerbungVkp = (WerbungEkp
                        * bestellung.getBestellposition(RundenNr).getWerbung().getVielPWS())
                        + WerbungEkp;
                break;
            }
            case "mittel": {
                WerbungEkp = bestellung.getBestellposition(RundenNr).getWerbung().getMittelEKP();
                WerbungVkp = (WerbungEkp
                        * bestellung.getBestellposition(RundenNr).getWerbung().getMittelPWS())
                        + WerbungEkp;
                break;
            }
            case "wenig": {
                WerbungEkp = bestellung.getBestellposition(RundenNr).getWerbung().getWenigEKP();
                WerbungVkp = (WerbungEkp
                        * bestellung.getBestellposition(RundenNr).getWerbung().getWenigPWS())
                        + WerbungEkp;
                break;
            }
            default: System.err.println();
        }
    }


    public void berechnePreis(double Preis) {
       Einkaufspreis = DesignerEkp
                        + ArmbandEkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + UhrwerkEkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + GehäuseUhrwerkEkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + VersandartEkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + WasserdichtheitEkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + ProduktionsortEkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + WerbungEkp * bestellung.getBestellposition(RundenNr).getMenge()
                        ;

       Verkaufspreis = DesignerVkp
                        + ArmbandVkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + UhrwerkVkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + GehäuseUhrwerkVkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + VersandartVkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + WasserdichtheitVkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + ProduktionsortVkp * bestellung.getBestellposition(RundenNr).getMenge()
                        + WerbungVkp * bestellung.getBestellposition(RundenNr).getMenge()
                        ;
    }

} //Ende Klasse