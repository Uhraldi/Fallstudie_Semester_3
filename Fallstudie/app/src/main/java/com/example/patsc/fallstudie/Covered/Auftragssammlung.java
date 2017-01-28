package com.example.patsc.fallstudie.Covered;


/**
 * Created by vince on 02.01.2017.
 * testable
 */

public class Auftragssammlung {


    /*
    neues Konzept keine Auftragssammlung mehr sondern 10 Auftraege; gespeichert in einem Feld; da es nur max 10 geben kann
     */
    Auftrag[] auftraege = new Auftrag[10];
    public Auftrag aktuellerAuftrag;
    public int aktuellerAuftragInt;

    public void setAktuellerAuftragInt(int i){
        aktuellerAuftragInt = i;
    }

    public Auftragssammlung(){
        aktuellerAuftragInt = 0;
        auftraege[aktuellerAuftragInt] = new Auftrag();
        aktuellerAuftrag = auftraege[aktuellerAuftragInt];
    }
    public String toString(){
        String stringA = String.valueOf(aktuellerAuftragInt);
        return stringA;
    }

//umbenannt
    public void neuerAuftrag( ){
        aktuellerAuftragInt++;
        auftraege[aktuellerAuftragInt] = new Auftrag();
        aktuellerAuftrag = auftraege[aktuellerAuftragInt];
    }
    public void neuerAuftragGleicheWerte( ){
        aktuellerAuftragInt++;
        auftraege[aktuellerAuftragInt] = auftraege[aktuellerAuftragInt-1];
        aktuellerAuftrag = auftraege[aktuellerAuftragInt];
    }

    public Auftrag getAuftrag(int i){
        return auftraege[i];
    }

    public Auftrag getAktuellerAuftrag() {
        return aktuellerAuftrag;
    }
} // Ende AUftragsammlung
