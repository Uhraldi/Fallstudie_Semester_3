package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 * testable
 */


public class Forschung {


    //Auswahlen
    private boolean marken = false;
    private boolean mittelmaessig = false;
    private boolean lowBudget = false;

    //EKPs
    private double markenEKP = 5000;
    private double mittelmaessigEKP = 3000;
    private double lowBudgetEKP = 1000;

    //PWSs
    private double markenPWS = 0.4;
    private double mittelmaessigPWS = 0.2;
    private double lowBudgetPWS = 0.05;

    /**
     * Constructor
     */
    public Forschung() {

    }

    /**
     * Variblen-Getter
     */
    public boolean isMarken() {
        return marken;
    }

    public boolean isMittelmaessig() {
        return mittelmaessig;
    }

    public boolean isLowBudget() {
        return lowBudget;
    }

    public double getMarkenEKP() {
        return markenEKP;
    }

    public double getMittelmaessigEKP() {
        return mittelmaessigEKP;
    }

    public double getLowBudgetEKP() {
        return lowBudgetEKP;
    }

    public double getMarkenPWS() {
        return markenPWS;
    }

    public double getMittelmaessigPWS() {
        return mittelmaessigPWS;
    }

    public double getLowBudgetPWS() {
        return lowBudgetPWS;
    }

    /**
     * Variablen-Setter
     */

    //Forschung Hoch
    public void setMarken(boolean marken) {
        this.marken = marken;
    }
    //Forschung Mittelmäßig
    public void setMittelmaessig(boolean mittelmaessig) {
        this.mittelmaessig = mittelmaessig;
    }
    //Forschung Low
    public void setLowBudget(boolean lowBudget) {
        this.lowBudget = lowBudget;
    }
}