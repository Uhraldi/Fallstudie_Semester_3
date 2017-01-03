package com.example.patsc.fallstudie;


import com.example.patsc.fallstudie.Bestandteile.Armband;
import com.example.patsc.fallstudie.Bestandteile.Designer;
import com.example.patsc.fallstudie.Bestandteile.Gehaeuse;
import com.example.patsc.fallstudie.Bestandteile.Produktionsort;
import com.example.patsc.fallstudie.Bestandteile.Uhrwerk;
import com.example.patsc.fallstudie.Bestandteile.Versandart;
import com.example.patsc.fallstudie.Bestandteile.Wasserdichtheit;
import com.example.patsc.fallstudie.Bestandteile.Werbung;
import com.example.patsc.fallstudie.Bestellung;


/**
 * Created by Jonas on 02.01.17.
 */

public class Preissimulation extends Designer {

    private double Einkaufspreis;
    private double Verkaufspreis;
    private int RundenNr;

    private double MarkenEkp;
    private double MarkenVkp;
    private double MittelmäßigEkp;
    private double MittelmäßigVkp;
    private double LowBudgetEkp;
    private double LowBudgetVkp;

    // 2. Schritt
    private double LederVkp;
    private double LederEkp;
    private double KunstlederEkp;
    private double KunstlederVkp;
    private double HolzEkp;
    private double HolzVkp;
    private double TextilEkp;
    private double TextilVkp;
    private double MetallEkp;
    private double MetallVkp;

    // 3. Schritt
    private double MechanischEkp;
    private double MechanischVkp;
    private double ElektromechanischEkp;
    private double ElektromechanischVkp;
    private double ElektronischEkp;
    private double ElektronischVkp;

    // 4. Schritt
    private double UGlasEkp;
    private double UGlasVkp;
    private double UHolzEkp;
    private double UHolzVkp;
    private double UKunststoffEkp;
    private double UKunststoffVkp;
    private double UMetallEkp;
    private double UMetallVkp;

    // 5. Schritt
    private double FlugzeugEkp;
    private double FlugzeugVkp;
    private double SchiffEkp;
    private double SchiffVkp;
    private double LandwegEkp;
    private double LandwegVkp;

    // 6. Schritt
    private double nichtwassergeschütztEkp;
    private double nichtwassergeschütztVkp;
    private double spritzwassergeschütztEkp;
    private double spritzwassergeschütztVkp;
    private double wasserdichtEkp;
    private double wasserdichtVkp;

    // 7. Schritt
    private double DeutschlandEkp;
    private double DeutschlandVkp;
    private double AsienEkp;
    private double AsienVkp;
    private double OsteuropaEkp;
    private double OsteuropaVkp;
    private double SchweizEkp;
    private double SchweizVkp;

    // 8. Schritt
    private double WvielEkp;
    private double WvielVkp;
    private double WmittelEkp;
    private double WmittelVkp;
    private double WwenigEkp;
    private double WwenigVkp;

    // 9. Schritt
    private double Stückzahl;

    // 10. Schritt


    Bestellung bestellung = new Bestellung();


   // public double getPreis() { return Preis; } ToDo
  //  public void setPreis(double preis) { ToDo
  //      Preis = preis;
  //  }

    public int getRundenNr() { return RundenNr; }
    public void setRundenNr(int rundenNr) { RundenNr = rundenNr; }

    public void berechneDesigner(String auswahlDesigner) {
        switch (auswahlDesigner) {
            case "Marken": {
               // LowBudgetEkp = bestellung.getBestellposition(RundenNr).getDesigner().getmarkenEKP();
               // LowBudgetVkp = (bestellung.getBestellposition(RundenNr).getDesigner().getmarkenEKP()
               //         * bestellung.getBestellposition(RundenNr).getDesigner().getMarkenPWS())
               //         + bestellung.getBestellposition(RundenNr).getDesigner().getmarkenEKP();
               // break;
            }
            case "Mittelmäßig": {
                MittelmäßigEkp = bestellung.getBestellposition(RundenNr).getDesigner().getMittelmaessigEKP();
                MittelmäßigVkp = (bestellung.getBestellposition(RundenNr).getDesigner().getMittelmaessigEKP()
                        * bestellung.getBestellposition(RundenNr).getDesigner().getMittelmaessigPWS())
                        + bestellung.getBestellposition(RundenNr).getDesigner().getMittelmaessigEKP();
                break;
            }
            case "Low Budget": {
                LowBudgetEkp = bestellung.getBestellposition(RundenNr).getDesigner().getLowBudgetEKP();
                LowBudgetVkp = (bestellung.getBestellposition(RundenNr).getDesigner().getLowBudgetEKP()
                        * bestellung.getBestellposition(RundenNr).getDesigner().getLowBudgetPWS())
                        + bestellung.getBestellposition(RundenNr).getDesigner().getLowBudgetEKP();
                break;
            }
        }

    }

    public void berechneArmband(String auswahlArmband) {
        switch (auswahlArmband) {
            case "Leder": {
                LederEkp = bestellung.getBestellposition(RundenNr).getArmband().getLederEKP();
                LederVkp = (LederEkp * bestellung.getBestellposition(RundenNr).getArmband().getLederPWS())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getLederEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getLederZufall())
                        + bestellung.getBestellposition(RundenNr).getArmband().getLederEKP();
                break;
            }
            case "Kunstleder": {
                KunstlederEkp = bestellung.getBestellposition(RundenNr).getArmband().getKunstlederEKP();
                KunstlederVkp = (bestellung.getBestellposition(RundenNr).getArmband().getKunstlederEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getKunstlederPWS())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getKunstlederEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getKunstlederRisiko())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getKunstlederEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getKunstlederZufall())
                        + bestellung.getBestellposition(RundenNr).getArmband().getKunstlederEKP();
                break;
            }
            case "Holz": {
                HolzEkp = bestellung.getBestellposition(RundenNr).getArmband().getHolzEKP();
                HolzVkp = (bestellung.getBestellposition(RundenNr).getArmband().getHolzEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getHolzPWS())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getHolzEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getHolzRisiko())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getHolzEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getHolzZufall())
                        + bestellung.getBestellposition(RundenNr).getArmband().getHolzEKP();
                break;
            }
            case "Textil": {
                TextilEkp = bestellung.getBestellposition(RundenNr).getArmband().getTextilEKP();
                TextilVkp = (bestellung.getBestellposition(RundenNr).getArmband().getTextilEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getTextilPWS())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getTextilEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getTextilRisiko())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getTextilEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getTextilZufall())
                        + bestellung.getBestellposition(RundenNr).getArmband().getTextilEKP();
                break;
            }
            case "Metall": {
                MetallEkp = bestellung.getBestellposition(RundenNr).getArmband().getMetallEKP();
                MetallVkp = (bestellung.getBestellposition(RundenNr).getArmband().getMetallEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getMetallPWS())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getMetallEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getMetallRisiko())
                        + (bestellung.getBestellposition(RundenNr).getArmband().getMetallEKP()
                        * bestellung.getBestellposition(RundenNr).getArmband().getMetallZufall())
                        + bestellung.getBestellposition(RundenNr).getArmband().getMetallEKP();
                break;
            }
        }
    }

    public void berechneUhrwerk(String auswahlUhrwerk) {
        switch (auswahlUhrwerk) {
            case "Mechanisch": {
                MechanischEkp = bestellung.getBestellposition(RundenNr).getUhrwerk().getMechanischEKP();
                MetallVkp = (bestellung.getBestellposition(RundenNr).getUhrwerk().getMechanischEKP()
                        * bestellung.getBestellposition(RundenNr).getUhrwerk().getMechanischPWS())
                        + bestellung.getBestellposition(RundenNr).getUhrwerk().getMechanischEKP();
            }
            case "Elektromechanisch": {
                ElektromechanischEkp = bestellung.getBestellposition(RundenNr).getUhrwerk().getElektromechanischEKP();
                ElektromechanischVkp = (bestellung.getBestellposition(RundenNr).getUhrwerk().getElektromechanischEKP()
                        * bestellung.getBestellposition(RundenNr).getUhrwerk().getElektromechanischPWS())
                        + bestellung.getBestellposition(RundenNr).getUhrwerk().getElektromechanischEKP();
            }
            case "Elektronisch": {
                ElektronischEkp = bestellung.getBestellposition(RundenNr).getUhrwerk().getElektronischEKP();
                ElektronischVkp = (bestellung.getBestellposition(RundenNr).getUhrwerk().getElektronischEKP()
                        * bestellung.getBestellposition(RundenNr).getUhrwerk().getEletronischPWS())
                        + bestellung.getBestellposition(RundenNr).getUhrwerk().getElektronischEKP();
            }
        }
    }

    public void berechneGehäuseUhrwerk(String auswahlGehäuseUhrwerk) {
        switch (auswahlGehäuseUhrwerk) {
            case "Glas": {
                UGlasEkp = bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasEKP();
                UGlasVkp = (bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasPWS())
                        + (bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasRisiko())
                        + (bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasZufall())
                        + bestellung.getBestellposition(RundenNr).getGehaeuse().getGlasEKP();
            }
            case "Holz": {
                UHolzEkp = bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzEKP();
                UHolzVkp = (bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzPWS())
                        + (bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzRisiko())
                        + (bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzZufall())
                        + bestellung.getBestellposition(RundenNr).getGehaeuse().getHolzEKP();
            }
            case "Kunststoff": {
                UKunststoffEkp = bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffEKP();
                UKunststoffVkp = (bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffPWS())
                        + (bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffRisiko())
                        + (bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffZufall())
                        + bestellung.getBestellposition(RundenNr).getGehaeuse().getKunststoffEKP();
            }
            case "Metall": {
                UMetallEkp = bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallEKP();
                UMetallVkp = (bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallPWS())
                        + (bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallRisiko())
                        + (bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallEKP()
                        * bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallZufall())
                        + bestellung.getBestellposition(RundenNr).getGehaeuse().getMetallEKP();
            }
        }
    }

    public void berechneVersandart(String auswahlVersandart) {
        switch (auswahlVersandart) {
            case "Flugzeug": {
                FlugzeugEkp = bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugEKP();
                FlugzeugVkp = (bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugEKP()
                        * bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugPWS())
                        + (bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugEKP()
                        * bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugZufall())
                        + bestellung.getBestellposition(RundenNr).getVersandart().getFlugzeugEKP();
            }
            case "Schiff": {
                SchiffEkp = bestellung.getBestellposition(RundenNr).getVersandart().getSchiffEKP();
                SchiffVkp = (bestellung.getBestellposition(RundenNr).getVersandart().getSchiffEKP()
                        * bestellung.getBestellposition(RundenNr).getVersandart().getSchiffPWS())
                        + (bestellung.getBestellposition(RundenNr).getVersandart().getSchiffEKP()
                        * bestellung.getBestellposition(RundenNr).getVersandart().getSchiffZufall())
                        + bestellung.getBestellposition(RundenNr).getVersandart().getSchiffEKP();
            }
            case "Landweg": {
                LandwegEkp = bestellung.getBestellposition(RundenNr).getVersandart().getLandwegEKP();
                LandwegVkp = (bestellung.getBestellposition(RundenNr).getVersandart().getLandwegEKP()
                        * bestellung.getBestellposition(RundenNr).getVersandart().getLandwegPWS())
                        + (bestellung.getBestellposition(RundenNr).getVersandart().getLandwegEKP()
                        * bestellung.getBestellposition(RundenNr).getVersandart().getLandwegZufall())
                        + bestellung.getBestellposition(RundenNr).getVersandart().getLandwegEKP();
            }
        }
    }

    public void berechneWasserdichtheit(String auswahlWasserdichtheit) {
        switch (auswahlWasserdichtheit) {
            case "nicht wassergeschützt": {
                nichtwassergeschütztEkp = bestellung.getBestellposition(RundenNr).getWasserdichtheit().getNichtWassergeschütztEKP();
                nichtwassergeschütztVkp = (bestellung.getBestellposition(RundenNr).getWasserdichtheit().getNichtWassergeschütztEKP()
                        * bestellung.getBestellposition(RundenNr).getWasserdichtheit().getNichtWassergeschütztPWS())
                        + bestellung.getBestellposition(RundenNr).getWasserdichtheit().getNichtWassergeschütztEKP();
            }
            case "spritzwassergeschützt": {
                spritzwassergeschütztEkp = bestellung.getBestellposition(RundenNr).getWasserdichtheit().getSpritzwassergeschütztEKP();
                spritzwassergeschütztVkp = (bestellung.getBestellposition(RundenNr).getWasserdichtheit().getSpritzwassergeschütztEKP()
                        * bestellung.getBestellposition(RundenNr).getWasserdichtheit().getSpritzwassergeschütztPWS())
                        + bestellung.getBestellposition(RundenNr).getWasserdichtheit().getSpritzwassergeschütztEKP();
            }
            case "wasserdicht": {
                wasserdichtEkp = bestellung.getBestellposition(RundenNr).getWasserdichtheit().getWasserdichtEKP();
                wasserdichtVkp = (bestellung.getBestellposition(RundenNr).getWasserdichtheit().getWasserdichtEKP()
                        * bestellung.getBestellposition(RundenNr).getWasserdichtheit().getWasserdichtPWS())
                        + bestellung.getBestellposition(RundenNr).getWasserdichtheit().getWasserdichtEKP();
            }
        }
    }

    public void berechneProduktionsort (String auswahlProduktionsort) {
        switch (auswahlProduktionsort) {
            case "Deutschland": {
                DeutschlandEkp = bestellung.getBestellposition(RundenNr).getProduktionsort().getDeutschlandEKP();
                DeutschlandVkp = (bestellung.getBestellposition(RundenNr).getProduktionsort().getDeutschlandEKP()
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getDeutschlandPWS())
                        + (bestellung.getBestellposition(RundenNr).getProduktionsort().getDeutschlandEKP()
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getDeutschlandRisiko())
                        + bestellung.getBestellposition(RundenNr).getProduktionsort().getDeutschlandEKP();
            }
            case "Asien": {
                AsienEkp = bestellung.getBestellposition(RundenNr).getProduktionsort().getAsienEKP();
                AsienVkp = (bestellung.getBestellposition(RundenNr).getProduktionsort().getAsienEKP()
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getAsienPWS())
                        + (bestellung.getBestellposition(RundenNr).getProduktionsort().getAsienEKP()
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getAsienRisiko())
                        + bestellung.getBestellposition(RundenNr).getProduktionsort().getAsienEKP();
            }
            case "Osteuropa": {
                OsteuropaEkp = bestellung.getBestellposition(RundenNr).getProduktionsort().getOsteuropaEKP();
                OsteuropaVkp = (bestellung.getBestellposition(RundenNr).getProduktionsort().getOsteuropaEKP()
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getOsteuropaPWS())
                        + (bestellung.getBestellposition(RundenNr).getProduktionsort().getOsteuropaEKP()
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getOsteuropaRisiko())
                        + bestellung.getBestellposition(RundenNr).getProduktionsort().getOsteuropaEKP();
            }
            case "Schweiz": {
                SchweizEkp = bestellung.getBestellposition(RundenNr).getProduktionsort().getSchweizEKP();
                SchweizVkp = (bestellung.getBestellposition(RundenNr).getProduktionsort().getSchweizEKP()
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getSchweizPWS())
                        + (bestellung.getBestellposition(RundenNr).getProduktionsort().getSchweizEKP()
                        * bestellung.getBestellposition(RundenNr).getProduktionsort().getSchweizRisiko())
                        + bestellung.getBestellposition(RundenNr).getProduktionsort().getSchweizEKP();
            }
        }
    }

    public void berechneWerbung (String auswahlWerbung) {
        switch (auswahlWerbung) {
            case "viel": {
                WvielEkp = bestellung.getBestellposition(RundenNr).getWerbung().getVielEKP();
                WvielVkp = (bestellung.getBestellposition(RundenNr).getWerbung().getVielEKP()
                        * bestellung.getBestellposition(RundenNr).getWerbung().getVielPWS())
                        + bestellung.getBestellposition(RundenNr).getWerbung().getVielEKP();
                break;
            }
            case "mittel": {
                WmittelEkp = bestellung.getBestellposition(RundenNr).getWerbung().getMittelEKP();
                WmittelVkp = (bestellung.getBestellposition(RundenNr).getWerbung().getMittelEKP()
                        * bestellung.getBestellposition(RundenNr).getWerbung().getMittelPWS())
                        + bestellung.getBestellposition(RundenNr).getWerbung().getMittelEKP();
            }
            case "wenig": {
                WwenigEkp = bestellung.getBestellposition(RundenNr).getWerbung().getWenigEKP();
                WwenigVkp = (bestellung.getBestellposition(RundenNr).getWerbung().getWenigEKP()
                        * bestellung.getBestellposition(RundenNr).getWerbung().getWenigPWS())
                        + bestellung.getBestellposition(RundenNr).getWerbung().getWenigEKP();
            }
        }
    }

    public void berechneKaufvolumen (double stückzahl) {
        // ToDo
        }

    // ToDo
    public void berechnegeplanterVerkaufspreis(){

    }
    //ToDo
    public void berechnePreis(double Preis) {
       // Einkaufspreis =
     //  Verkaufspreis =

    }
} //Ende Klasse
