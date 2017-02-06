package com.example.patsc.fallstudie.Covered.Bestandteile.Controller;

import com.example.patsc.fallstudie.Covered.Daten.Daten;
import com.example.patsc.fallstudie.Covered.Spieler;

/**
 * Created by patsc on 06.02.2017.
 */

public class SuperController implements ISuperController {

    private Daten daten; // Klasse in der alle Daten gehalten werden wird bei OnCreate erzeugt
    public Spieler aktiverSpieler;

    private double gesamtkosten = 0;

    public void setAktiverSpieler(Spieler aktiverSpieler) {
        this.aktiverSpieler = aktiverSpieler;
    }
    public void setDaten(Daten daten) {
        this.daten = daten;
    }
    public Spieler getAktiverSpieler() {
        return aktiverSpieler;
    }

    public Daten getDaten(){
        return daten;
    }
}
