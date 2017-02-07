package com.example.patsc.fallstudie.Covered.Daten;
import com.example.patsc.fallstudie.Covered.Controller.Controller;
import com.example.patsc.fallstudie.Covered.Runde;
import com.example.patsc.fallstudie.Covered.Spieler;

import java.util.ArrayList;
/**
 * Created by Patricia Schneider on 30.12.2016.
 * Klasse in der alle Daten zu dem Spiel gesammelt werden, diese Klasse wird auch gespeichert,
 * so dass aus Ihr der neue Spielstand geladen werden kann.
 */
public class Daten extends SpielerAbfragen{
    public ArrayList<Spieler> getSpielerListe() {
        return SpielerListe;
    }

    private ArrayList<Spieler> SpielerListe; // Liste aller Spieler; die auf dem Device gespeichert sind
    private int SpielerAnzahl = 10;
    private ArrayList<Runde> RundenListe; //Liste der bisherigen Runden //ToDo MEthoden
    private int RundenAnzahl; //ToDo Methoden
    public void setRundenAnzahl(int i){
        RundenAnzahl = i;
    }
    private Spieler dieserSpieler; // Der Spieler dieses Geräts ToDo
    public Spieler getDieserSpieler(){return dieserSpieler;} //ToDO
    public int getRundenAnzahl(){
        return RundenAnzahl;
    }


    public Daten(Controller c){
        ladeDaten();
        setController(c);
        SpielerListe = new ArrayList<Spieler>();
    } // Ende Konstruktor

    public String toString(){
        String dataString;
        dataString = RundenAnzahl+":";
        return dataString;
    }
    public void erhoeheRundenanzahl(){
        RundenAnzahl++;
    }
    public void setDieserSpieler(Spieler spieler){
        dieserSpieler = spieler;
    }
    public int getSpielerAnzahl() {
        return SpielerAnzahl;
    }
    /*
    ToDo
     */
    public void setSpielerAnzahl(int spielerAnzahl) {
        SpielerAnzahl = spielerAnzahl;
    }

    public void erhöheSpielerAnzahl(){
        SpielerAnzahl++;
    }
    public void ladeDaten(){
        //ToDO gewollt leer?
    }
    public void speichereDaten(){
        //ToDO
    }
    public void addSpielerListe(Spieler spieler){
        try{
            erhöheSpielerAnzahl();
            setDieserSpieler(spieler);
            if (spieler != null){
                SpielerListe.add(spieler); //ToDo hier tritt ein NullPointer auf!
            }
            else{
                throw new Exception("Spieler == null");
            }
        }// Ende Try
        catch (Exception e) {
            e.printStackTrace();
        } // Ende Catch

    }//Ende addSpielerListe
}// Ende Klasse
