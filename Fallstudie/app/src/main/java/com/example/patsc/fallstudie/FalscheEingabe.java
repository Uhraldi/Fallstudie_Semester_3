package com.example.patsc.fallstudie;

/**
 * Created by vince on 03.01.2017.
 */

public class FalscheEingabe extends Exception {

    public FalscheEingabe(){
        super("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
    }
}