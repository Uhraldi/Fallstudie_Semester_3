package com.example.patsc.fallstudie;

import java.util.*;

/**
 * Created by dominik on 30.12.2016.
 */

public class Marktsim {
    private int  anzSpieler = Daten.getSpielerAnzahl();                                                             //ToDo
    private int AnzKäufer = anzSpieler * 8000;   // Abfrage der Spieleranzahl, mult. mit 8000
    private int lKäufer;                         //low-budget-Käufer
    private int hKäufer;                         //high-budget-Käufer
    private float highestp = 5;
    private float lowestp = 1500;
    private int lvertKäufer = 0, hvertKäufer = 0;
    ArrayList <Bestellposition> bestellpos = new ArrayList();
    private float l1,l2,l3,h1,h2,h3,l1v,l2v,l3v,h1v,h2v,h3v;

    public Marktsim(){
    }

    public ArrayList berechneAbsatz(ArrayList bestellpos){

        this.bestellpos = bestellpos;

        ArrayList prozentualeVorteile = new ArrayList();
        ArrayList vkparray = new ArrayList();
        ArrayList mengearray = new ArrayList();
        ArrayList verkaufreturn = new ArrayList();
        ArrayList pkzarray = new ArrayList();
        ArrayList diff = new ArrayList();

        int lverteilung = randInt(40,60);               //Verteilung low-zufall
        int hverteilung = 100 - lverteilung;            //Verteilung 100 Prozent - low-verteilung
        lvertKäufer = lverteilung/100 * lKäufer;    // Berechnung Anzahl low-budget-Käufer
        hvertKäufer = hverteilung/100 * hKäufer;    // Berechnung Anzahl low-budget-Käufer

        this.berechnePreissegmente();        // Verteilung der Käufer auf l1-3 und l1-3 zufällig

        for (Bestellposition s:  this.bestellpos) {
            double zw = 0;
            if(s.getVersandart().isFlugzeug()){
                zw += s.getVersandart().getFlugzeugZufall();
            }
            if(s.getVersandart().isLandweg()){
                zw += s.getVersandart().getLandwegZufall();
            }
            if(s.getVersandart().isSchiff()){
                zw += s.getVersandart().getSchiffZufall();
            }
            if(s.getWerbung().isViel()){
                zw += s.getWerbung().getVielPWS();
            }
            if(s.getWerbung().isMittel()){
                zw += s.getWerbung().getMittelPWS();
            }
            if(s.getWerbung().isWenig()){
                zw += s.getWerbung().getWenigPWS();
            }
            prozentualeVorteile.add(zw);
        }

        for(Bestellposition p: this.bestellpos){   // Menge-Abfrage
            mengearray.add(p.getMenge());
        }

        for(Bestellposition e: this.bestellpos){   // VKP-Abfrage
            vkparray.add(e.getVkp());
        }

        for(Bestellposition g: this.bestellpos){
            pkzarray.add(g.Preis.());              // ToDo Preis, den Kunden zahlen würden
        }

        for (int i = 0; i < anzSpieler; i++){      // Differenzberechnung
            diff.set(i,(double)pkzarray.get(i) - (double)vkparray.get(i));
        }


        for (int i = 0; i < anzSpieler; i++){                                       // Abweichungen wirken sich auf die prozentualenVorteile aus 50,75,100 Prozent Schritte
            if((double)diff.get(i) < (0-(double)pkzarray.get(i)*0.50)){
                double y = (double)prozentualeVorteile.get(i)-0.25;
                prozentualeVorteile.set(i,y);
            }
            if((double)diff.get(i) < (0-(double)pkzarray.get(i)*0.75)){
                double y = (double)prozentualeVorteile.get(i)-0.375;
                prozentualeVorteile.set(i,y);
            }
            if((double)diff.get(i) < (0-(double)pkzarray.get(i))){
                double y = (double)prozentualeVorteile.get(i)-0.5;
                prozentualeVorteile.set(i,y);
            }

        }


        Collections.sort(); // ToDo Sortieren notwendig?


        for(int i = 0; i<anzSpieler ; i++){

            if((double)vkparray.get(i) < l1){
                double y = ((double)randInt(30,80)/100 + (double)prozentualeVorteile.get(i));
                if(y > 1){ y = 1;}
                if(y < 0){ y = 0;}
                if(y*l1v > (int)mengearray.get(i)){
                    double x = (double)mengearray.get(i);
                    verkaufreturn.set(i,x);
                }
                else{verkaufreturn.set(i,y*l1v);}
                l1v = l1v - (float)verkaufreturn.get(i);
            }
            else{
                if((double)vkparray.get(i) < l2){
                    double y = ((double)randInt(30,80)/100 + (double)prozentualeVorteile.get(i));
                    if(y > 1){ y = 1;}
                    if(y < 0){ y = 0;}
                    if(y*l2v > (int)mengearray.get(i)){
                        double x = (double)mengearray.get(i);
                        verkaufreturn.set(i,x);
                    }
                    else{verkaufreturn.set(i,y*l2v);}
                    l2v = l2v - (float)verkaufreturn.get(i);
                }
                else{
                    if((double)vkparray.get(i) < l3){
                        double y = ((double)randInt(30,80)/100 + (double)prozentualeVorteile.get(i));
                        if(y > 1){ y = 1;}
                        if(y < 0){ y = 0;}
                        if(y*l3v > (int)mengearray.get(i)){
                            double x = (double)mengearray.get(i);
                            verkaufreturn.set(i,x);
                        }
                        else{verkaufreturn.set(i,y*l3v);}
                        l3v = l3v - (float)verkaufreturn.get(i);
                    }
                    else{
                        if((double)vkparray.get(i) < h1){
                            double y = ((double)randInt(30,80)/100 + (double)prozentualeVorteile.get(i));
                            if(y > 1){ y = 1;}
                            if(y < 0){ y = 0;}
                            if(y*h1v > (int)mengearray.get(i)){
                                double x = (double)mengearray.get(i);
                                verkaufreturn.set(i,x);
                            }
                            else{verkaufreturn.set(i,y*h1v);}
                            h1v = h1v - (float)verkaufreturn.get(i);
                        }
                        else{
                            if((double)vkparray.get(i) < h2){
                                double y = ((double)randInt(30,80)/100 + (double)prozentualeVorteile.get(i));
                                if(y > 1){ y = 1;}
                                if(y < 0){ y = 0;}
                                if(y*h2v > (int)mengearray.get(i)){
                                    double x = (double)mengearray.get(i);
                                    verkaufreturn.set(i,x);
                                }
                                else{verkaufreturn.set(i,y*h2v);}
                                h2v = h2v - (float)verkaufreturn.get(i);
                            }
                            else{
                                if((double)vkparray.get(i) < h3){
                                    double y = ((double)randInt(30,80)/100 + (double)prozentualeVorteile.get(i));
                                    if(y > 1){ y = 1;}
                                    if(y < 0){ y = 0;}
                                    if(y*h3v > (int)mengearray.get(i)){
                                        double x = (double)mengearray.get(i);
                                        verkaufreturn.set(i,x);
                                    }
                                    else{verkaufreturn.set(i,y*h3v);}
                                    h3v = h3v - (float)verkaufreturn.get(i);
                                }

                            }

                        }

                    }

                }
            }
        }

        return verkaufreturn;
    } // Ende berechneAbsatz



    public void berechnePreissegmente(){

        float middle = (highestp - lowestp) / 2;

        l1 = lowestp + (1/4 * middle);                             //Preisklassen l1-3 und h1-3
        l2 = lowestp + (1/2 * middle);                             // Enteilung in 1/3 Schritte, Verteilung Zufällig
        l3 = lowestp + (3/3 * middle);
        h1 = (lowestp + middle) + (1/4 * middle);
        h2 = (lowestp + middle) + (1/2 * middle);
        h3 = (lowestp + middle) + (3/3 * middle);

        l1v = randInt(1,49);                        // Prozentuale Verteilung low budget
        l2v = randInt(1,49);
        l3v = (l1v - l2v);

        l1v = l1v/100 * lvertKäufer;                // Anzahl der low budget Käufer in den Preissegmenten
        l2v = l2v/100 * lvertKäufer;
        l3v = l3v/100 * lvertKäufer;

        h1v = randInt(1,49);                        // Prozentuale Verteilung high budget
        h2v = randInt(1,49);
        h3v = h1v - h2v;

        h1v = h1v /100 * hvertKäufer;               // Anzahl der high budget Käufer in den Preissegmenten
        h2v = h2v /100 * hvertKäufer;
        h3v = h3v /100 * hvertKäufer;
    } //Ende BerechenePreissegmente




    public static int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int getlKäufer() {
        return lKäufer;
    }

    public int gethKäufer() {
        return hKäufer;
    }

    public float getLowestp() {
        return lowestp;
    }

    public float getHighestp() {
        return highestp;
    }

}
