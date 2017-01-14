package com.example.patsc.fallstudie;

import java.util.ArrayList;


/**
 * Created by vince on 02.01.2017.
 * testable
 */

public class Auftragssammlung {

    ArrayList<Auftrag> positionen = new ArrayList <Auftrag>();

    public Auftragssammlung(){

    }
//umbenannt
    public void neueBestellpositon( ){
        positionen.add(new Auftrag());
    }

    public Auftrag getAuftrag(int i){
        return positionen.get(i);
    }

    public ArrayList<Auftrag> getBestellpositionen(){
        return positionen;
    }
}
