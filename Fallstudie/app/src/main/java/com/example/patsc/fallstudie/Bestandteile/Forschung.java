package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 * testable
 */


public class Forschung {


    //Auswahlen
    private boolean Investition2500 = false;
    private boolean Investition1500 = false;
    private boolean Investition500 = false;

    //Fixkosten
    private double FixkostenInvestition2500 = 2500;
    private double FixkostenInvestition1500 = 1500;
    private double FixkostenInvestition500 = 500;

    //PWSs
    private double Investition2500PWS = 0.4;
    private double Investition1500PWS = 0.2;
    private double Investition500PWS = 0.05;

    /**
     * Constructor
     */
    public Forschung() {

    }

    /**
     * Variablen-Getter
     */
    public boolean isInvestition2500() {
        return Investition2500;
    }

    public boolean isInvestition1500() {
        return Investition1500;
    }

    public boolean isInvestition500() {
        return Investition500;
    }

    public double getFixkostenInvestition2500() {
        return FixkostenInvestition2500;
    }

    public double getFixkostenInvestition1500() {
        return FixkostenInvestition1500;
    }

    public double getFixkostenInvestition500() {
        return FixkostenInvestition500;
    }

    public double getInvestition2500PWS() {
        return Investition2500PWS;
    }

    public double getInvestition1500PWS() {
        return Investition1500PWS;
    }

    public double getInvestition500PWS() {
        return Investition500PWS;
    }

    /**
     * Variablen-Setter
     */

    //Forschung 2500€ Investition
    public void setInvestition2500(boolean investition2500) {
        this.Investition2500 = Investition2500;
    }

    //Forschung 1500€ Investition
    public void setInvestition1500(boolean investition1500) {
        this.Investition1500 = investition1500;
    }

    //Forschung 500€ Investition
    public void setInvestition500(boolean investition500) {
        this.Investition500 = investition500;
    }
}
