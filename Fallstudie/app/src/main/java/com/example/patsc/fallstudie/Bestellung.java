package com.example.patsc.fallstudie;
import com.example.patsc.fallstudie.Bestandteile.Armband;
import com.example.patsc.fallstudie.Bestandteile.Designer;
import com.example.patsc.fallstudie.Bestandteile.Gehaeuse;
import com.example.patsc.fallstudie.Bestandteile.Produktionsort;
import com.example.patsc.fallstudie.Bestandteile.Uhrwerk;
import com.example.patsc.fallstudie.Bestandteile.Versandart;
import com.example.patsc.fallstudie.Bestandteile.Wasserdichtheit;
import com.example.patsc.fallstudie.Bestandteile.Werbung;

import java.util.ArrayList;


/**
 * Created by vince on 02.01.2017.
 */

public class Bestellung {

    ArrayList<Bestellposition> positionen = new ArrayList <Bestellposition>();

    public Bestellung(){

    }

    public void neueBestellung(){
        positionen.add(new Bestellposition());
    }

    public Bestellposition getBestellposition(int i){
        return positionen.get(i);
    }

    public ArrayList<Bestellposition> getBestellpositionen(){
        return positionen;
    }
}
