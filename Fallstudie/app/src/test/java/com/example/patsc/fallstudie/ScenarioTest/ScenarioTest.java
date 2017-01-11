package com.example.patsc.fallstudie.ScenarioTest;

import com.example.patsc.fallstudie.Daten;
import com.example.patsc.fallstudie.Model;

/**
 * Created by julian on 11.01.2017.
 */

public class ScenarioTest {

    /*
    Ablauf:
    1.Controller erzeugen ( Hier werden die Spieldaten erstellt.)



        Schritte in der Produktion:
        1.Personalwesen
        2.Zeitarbeiter
        3.Forschung und Entwicklung
        4.Marketing
        5.Armband
        6.Uhrwerk
        7.Gehaeuse
        8.

     */

    Model Controller = new Model();
    Daten Testdaten = Controller.getDaten();

    public void setAktiverSpieler(){
        Controller.setAktiverSpieler();
    }


}
