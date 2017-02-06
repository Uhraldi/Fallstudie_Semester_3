package com.example.patsc.fallstudie.Covered.Bestandteile.Controller;

import com.example.patsc.fallstudie.Network.EmpfangeRundeRunnable;
import com.example.patsc.fallstudie.Network.Funkturm;
import com.example.patsc.fallstudie.Network.RundenErgebnisWrapper;
import com.example.patsc.fallstudie.Network.SendeRundeRunnable;
import com.example.patsc.fallstudie.Network.SpielerDatenWrapper;
import com.example.patsc.fallstudie.Network.UpdateRunnable;

/**
 * Created by patsc on 06.02.2017.
 */

public class CNetzwerk extends Zustaende implements INetzwerk {
    /**
     *  Netzwerkvariablen
     */

    boolean registrierungBool = false;
    boolean updateBool = false;
    SpielerDatenWrapper empfangeSpielerSDW;
    boolean sendeRundeBool = false;
    RundenErgebnisWrapper[] rundenErgebnisREW;

    /**
     * Funkturm zum Senden von Daten
     */
    Funkturm funkturm = new Funkturm();

    public void rundeHochladen(Controller c){
        // aktiverSpieler.getVeraenderung für die nächste Runde soltle auch gespeichert werden
        RundenErgebnisWrapper rundenErgebnisWrapper = new RundenErgebnisWrapper(aktiverSpieler.getName(), getDaten().getRundenAnzahl(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPersonalwesen().getEingestellte(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPreissimulation().getReservationspreis(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getVkp(), c.getGesamtkosten(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPreissimulation().getBonus(), aktiverSpieler.getGuthaben(),aktiverSpieler.getMaSchnitt());
        Runnable r1 = new SendeRundeRunnable(rundenErgebnisWrapper,funkturm, c);
        Thread t1 = new Thread(r1);
        t1.start();
        while (t1.isAlive()) {
        }
    }

    public RundenErgebnisWrapper[] gegnerHerunterladen (Controller c){
        Runnable r2 = new EmpfangeRundeRunnable(getDaten().getRundenAnzahl(), funkturm,c);
        Thread t2 = new Thread(r2);
        t2.start();
        while (t2.isAlive()) {

        }
        RundenErgebnisWrapper[] gegnerliste = rundenErgebnisREW;
        return gegnerliste;
    }
    public void spielerDatenSpeichern (Controller c){
        //#Netzwerk Spielerdaten speichern
        SpielerDatenWrapper spieler = new SpielerDatenWrapper(
                aktiverSpieler.getName(),
                aktiverSpieler.getPasswort(),
                getDaten().getRundenAnzahl()+1,
                aktiverSpieler.getGuthaben(),
                aktiverSpieler.getMarktanteil(),
                aktiverSpieler.getKontoSchnitt(),
                aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPersonalwesen().getEingestellte(),
                aktiverSpieler.getVeraenderungPersonal());
        Runnable r3 = new UpdateRunnable(spieler, funkturm, c);
        Thread t3 = new Thread(r3);
        t3.start();
        while (t3.isAlive()) {

        }
    }
}
