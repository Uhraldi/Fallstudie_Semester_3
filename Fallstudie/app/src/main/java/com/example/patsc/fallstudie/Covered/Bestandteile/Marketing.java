
package com.example.patsc.fallstudie.Covered.Bestandteile;
/**
 * Created by vince on 30.12.2016.
 * testable
 */

public class Marketing {

    //Auswahlen
    private boolean Fernsehwerbung = false;
    private boolean Radiowerbung = false;
    private boolean Printwerbung = false;

    //Fixkosten
    private double FixkostenFernsehwerbung = 13000;
    private double FixkostenRadiowerbung = 5000;
    private double FixkostenPrintwerbung = 2000;

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

    public double getFixkostenFernsehwerbung() {
        return FixkostenFernsehwerbung;
    }

    public double getFixkostenRadiowerbung() {
        return FixkostenRadiowerbung;
    }

    public double getFixkostenPrintwerbung() {
        return FixkostenPrintwerbung;
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