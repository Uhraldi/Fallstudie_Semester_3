
package com.example.patsc.fallstudie.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 * testable
 */

public class Marketing {

    //Auswahlen
    private boolean Fernsehwerbung = false;
    private boolean Radiowerbung = false;
    private boolean Printwerbung = false;

    //EKPs
    private double FernsehwerbungEKP = 5000;
    private double RadiowerbungEKP = 3000;
    private double PrintwerbungEKP = 1000;

    //PWSs
    private double FernsehwerbungPWS = 0.4;
    private double RadiowerbungPWS = 0.2;
    private double PrintwerbungPWS = 0.05;


    /**
     * Constructor
     */
    public Marketing(){

    }

    /**
     * Variablen-Getter
     */
    public boolean isFernsehwerbung() {
        return Fernsehwerbung;
    }

    public boolean isRadiowerbung() {
        return Radiowerbung;
    }

    public boolean isPrintwerbung() {
        return Printwerbung;
    }

    public double getFernsehwerbungEKP() {
        return FernsehwerbungEKP;
    }

    public double getRadiowerbungEKP() {
        return RadiowerbungEKP;
    }

    public double getPrintwerbungEKP() {
        return PrintwerbungEKP;
    }

    public double getFernsehwerbungPWS() {
        return FernsehwerbungPWS;
    }

    public double getRadiowerbungPWS() {
        return RadiowerbungPWS;
    }

    public double getPrintwerbungPWS() {
        return PrintwerbungPWS;
    }

    /**
     * Variablen-Setter
     */
    public void setFernsehwerbung(boolean fernsehwerbung) {
        this.Fernsehwerbung = fernsehwerbung;
    }

    public void setRadiowerbung(boolean radiowerbung) {
        this.Radiowerbung = radiowerbung;
    }

    public void setPrintwerbung(boolean printwerbung) {
        this.Printwerbung = printwerbung;
    }
}