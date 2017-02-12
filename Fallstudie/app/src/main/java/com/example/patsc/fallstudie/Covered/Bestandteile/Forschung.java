package com.example.patsc.fallstudie.Covered.Bestandteile;

/**
 * @author Vincent Schmalor
 * Created by vince on 30.12.2016.
 * testable
 */


public class Forschung {

    /**Initialisierung zur Quasidatenhaltung*/
    //Auswahlen
    private boolean Investition15000 = false;
    private boolean Investition8000 = false;
    private boolean Investition2500 = false;

    //Fixkosten
    private double FixkostenInvestition15000 = 15000;
    private double FixkostenInvestition8000 = 8000;
    private double FixkostenInvestition2500 = 2500;

    //PWSs
    private double Investition15000PWS = 0.4;
    private double Investition8000PWS = 0.2;
    private double Investition2500PWS = 0.05;

    /**Konstruktor*/
    public Forschung() {

    }

    /**Methoden*/

    public String toString(){
        return"";
    }

    /**Getter*/
    public boolean isInvestition15000() {
        return Investition15000;
    }

    public boolean isInvestition8000() {
        return Investition8000;
    }

    public boolean isInvestition2500() {
        return Investition2500;
    }

    public double getFixkostenInvestition15000() {
        return FixkostenInvestition15000;
    }

    public double getFixkostenInvestition8000() {
        return FixkostenInvestition8000;
    }

    public double getFixkostenInvestition2500() {
        return FixkostenInvestition2500;
    }

    public double getInvestition15000PWS() {
        return Investition15000PWS;
    }

    public double getInvestition8000PWS() {
        return Investition8000PWS;
    }

    public double getInvestition2500PWS() {
        return Investition2500PWS;
    }
    /**End of Getter*/

    /**Setter*/
    //Forschung 2500€ Investition
    public void setInvestition15000(boolean investition15000) {
        this.Investition15000 = investition15000;
    }

    //Forschung 1500€ Investition
    public void setInvestition8000(boolean investition8000) {
        this.Investition8000 = investition8000;
    }

    //Forschung 500€ Investition
    public void setInvestition2500(boolean investition2500) {
        this.Investition2500 = investition2500;
    }
    /**End of Setter*/
}
