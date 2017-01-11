package com.example.patsc.fallstudie;

import java.util.ArrayList;


/**
 * Created by vince on 02.01.2017.
 * testable
 */

public class Bestellung {

    ArrayList<Bestellposition> positionen = new ArrayList <Bestellposition>();

    public Bestellung(){

    }
//umbenannt
    public void neueBestellpositon( ){
        positionen.add(new Bestellposition());
    }

    public Bestellposition getBestellposition(int i){
        return positionen.get(i);
    }

    public ArrayList<Bestellposition> getBestellpositionen(){
        return positionen;
    }
}
