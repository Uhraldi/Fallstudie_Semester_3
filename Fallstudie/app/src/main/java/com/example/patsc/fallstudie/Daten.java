package com.example.patsc.fallstudie;
import java.util.ArrayList;
/**
 * Created by Patricia Schneider on 30.12.2016.
 * Klasse in der alle Daten zu dem Spiel gesammelt werden, diese Klasse wird auch gespeichert,
 * so dass aus Ihr der neue Spielstand geladen werden kann.
 */
public class Daten {
    public ArrayList<Spieler> getSpielerListe() {
        return SpielerListe;
    }

    private ArrayList<Spieler> SpielerListe; // Liste aller Spieler
    private int SpielerAnzahl;
    private ArrayList<Runde> RundenListe; //Liste der bisherigen Runden //ToDo MEthoden
    private int RundenAnzahl; //ToDo Methoden
    private Spieler dieserSpieler; // Der Spieler dieses Geräts ToDo
    public Spieler getDieserSpieler(){return dieserSpieler;} //ToDO
    public int getRundenAnzahl(){
        return RundenAnzahl;
    }


    public Daten(){
        ladeDaten();
        SpielerListe = new ArrayList<Spieler>();
    } // Ende Konstruktor

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
