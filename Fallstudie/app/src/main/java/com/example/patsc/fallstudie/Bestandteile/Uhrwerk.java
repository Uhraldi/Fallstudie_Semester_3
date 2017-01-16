package com.example.patsc.fallstudie.Bestandteile;

/**
 * Created by vince on 28.12.2016.
 * testable
 */

public class Uhrwerk {

    //Auswahlen
    private boolean mechanisch = false;
    private boolean elektromechanisch = false;
    private boolean elektronisch = false;

    //Variable Kosten
    private double VarKostenMechanisch = 4;
    private double VarKostenElektromechanisch = 3;
    private double VarKostenElektronisch = 2;

    //PWSs
    private double mechanischPWS = 0.1;
    private double elektromechanischPWS = 0;
    private double eletronischPWS = 0.05;


    /**
     * Constructor
     */
    public Uhrwerk(){

    }

    public boolean isMechanisch() {
        return mechanisch;
    }

    public boolean isElektromechanisch() {
        return elektromechanisch;
    }

    public boolean isElektronisch() {
        return elektronisch;
    }

    public double getVarKostenMechanisch() {
        return VarKostenMechanisch;
    }

    public double getVarKostenElektromechanisch() {
        return VarKostenElektromechanisch;
    }

    public double getVarKostenElektronisch() {
        return VarKostenElektronisch;
    }

    public double getMechanischPWS() {
        return mechanischPWS;
    }

    public double getElektromechanischPWS() {
        return elektromechanischPWS;
    }

    public double getEletronischPWS() {
        return eletronischPWS;
    }

    public void setMechanisch(boolean mechanisch) {
        this.mechanisch = mechanisch;
    }

    public void setElektromechanisch(boolean elektromechanisch) {
        this.elektromechanisch = elektromechanisch;
    }

    public void setElektronisch(boolean elektronisch) {
        this.elektronisch = elektronisch;
    }
}