package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 30.12.2016.
 */


public class Designer extends Bestandteil {


    //Auswahlen
    private boolean marken = false;
    private boolean mittelmäßig = false;
    private boolean lowBudget = false;

    //EKPs
    private double markenEKP = 5000;
    private double mittelmäßigEKP = 3000;
    private double lowBudgetEKP = 1000;

    //PWSs
    private double markenPWS = 0.4;
    private double mittelmäßigPWS = 0.2;
    private double lowBudgetPWS = 0.05;




    public Designer() {
        /*
        super();
        String[] auswahlen = {"Markendesigner", "Mittelmäßiger Designer", "Low-Budget-Designer"};
        setAuswahl(auswahlen);
        double[] ekps = {5000,3000,1000};
        setEkp(ekps);
        double[] pwss = {0.4, 0.2, 0.05};
        setRisiko(pwss);
        double[] risiken = {0.01, 0.05, 0.2};
        setRisiko(risiken);
        double[] trends = {};
        setTrend(trends);
        */
    }

    public boolean isMarken() {
        return marken;
    }

    public boolean isMittelmäßig() {
        return mittelmäßig;
    }

    public boolean isLowBudget() {
        return lowBudget;
    }

    public double getMarkenEKP() {
        return markenEKP;
    }

    public double getMittelmäßigEKP() {
        return mittelmäßigEKP;
    }

    public double getLowBudgetEKP() {
        return lowBudgetEKP;
    }

    public double getMarkenPWS() {
        return markenPWS;
    }

    public double getMittelmäßigPWS() {
        return mittelmäßigPWS;
    }

    public double getLowBudgetPWS() {
        return lowBudgetPWS;
    }

    public void setMarken(boolean marken) {
        this.marken = marken;
    }

    public void setMittelmäßig(boolean mittelmäßig) {
        this.mittelmäßig = mittelmäßig;
    }

    public void setLowBudget(boolean lowBudget) {
        this.lowBudget = lowBudget;
    }
}
