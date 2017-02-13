package com.example.patsc.fallstudie.Covered.Controller;

import com.example.patsc.fallstudie.Network.EmpfangeRundeRunnable;
import com.example.patsc.fallstudie.Network.Funkturm;
import com.example.patsc.fallstudie.Network.RundenErgebnisWrapper;
import com.example.patsc.fallstudie.Network.SendeRundeRunnable;
import com.example.patsc.fallstudie.Network.SpielerDatenWrapper;
import com.example.patsc.fallstudie.Network.UpdateRunnable;

/**
 * Created by Vincent Schmalor on 06.02.2017.
 * Klasse die die Netzwerkkommunikation übernimmt.
 */

public abstract class CNetzwerk extends Zustaende implements INetzwerk {
    /**
     *  Netzwerkvariablen
     */

    boolean registrierungBool = false;
    boolean updateBool = false;
    SpielerDatenWrapper empfangeSpielerSDW;
    boolean sendeRundeBool = false;
    RundenErgebnisWrapper[] rundenErgebnisREW;
Funkturm funkturm;
    /**
     * Lädt alle Daten der aktuellen Runde des aktiven SPielers auf den Server
     * @param c Controller um an die Daten des aktiven SPilers zu gelangen
     */
    public void rundeHochladen(Controller c){
        RundenErgebnisWrapper rundenErgebnisWrapper = new RundenErgebnisWrapper(aktiverSpieler.getName(), getDaten().getRundenAnzahl(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getMenge(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPersonalwesen().getEingestellte(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPreissimulation().getReservationspreis(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getVkp(), c.getGesamtkosten(), aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPreissimulation().getBonus(), aktiverSpieler.getGuthaben(),aktiverSpieler.getMaSchnitt());
        Runnable r1 = new SendeRundeRunnable(rundenErgebnisWrapper, c);
        Thread t1 = new Thread(r1);
        t1.start();
        while (t1.isAlive()) {
        }
    }

    /**
     * Lädt eine Liste aller zehn Spieler, die auf dem Server gespeichert sind herunter
     * @param c Controller für den Datenzugriff umwelche RUnde es sich handelt
     * @return Liste mit allen Spielern des Servers
     */
    public RundenErgebnisWrapper[] gegnerHerunterladen (Controller c){
        Runnable r2 = new EmpfangeRundeRunnable(getDaten().getRundenAnzahl(), c);
        Thread t2 = new Thread(r2);
        t2.start();
        while (t2.isAlive()) {

        }
        RundenErgebnisWrapper[] gegnerliste = rundenErgebnisREW;
        return gegnerliste;
    }

    /**
     * Speichert die Daten des aktiven SPielers auf dem Server
     * @param c Controler für den Daten zugriff auf Daten
     */
    public void spielerDatenSpeichern (Controller c){
        SpielerDatenWrapper spieler = new SpielerDatenWrapper(
                aktiverSpieler.getName(),
                aktiverSpieler.getPasswort(),
                getDaten().getRundenAnzahl()+1,
                aktiverSpieler.getGuthaben(),
                aktiverSpieler.getMaSchnitt(),
                aktiverSpieler.getKontoSchnitt(),
                aktiverSpieler.getAuftragssammlung().getAktuellerAuftrag().getPersonalwesen().getEingestellte(),
                aktiverSpieler.getVeraenderungPersonal());
        Runnable r3 = new UpdateRunnable(spieler, c);
        Thread t3 = new Thread(r3);
        t3.start();
        while (t3.isAlive()) {

        }
    }

    /**
     * Setzt den boolean ob geupdatet werden darf
     * @param updateBool
     */
    public void setUpdateBool(boolean updateBool) {
        this.updateBool = updateBool;
    }

    /**
     * Param ob registrierung möglich ist
     * @param registrierungBool
     */
    public void setRegistrierungBool(boolean registrierungBool){
        this.registrierungBool = registrierungBool;
    }

    /**
     *  Param empfange Spieler
     * @param empfangeSpielerSDW
     */
    public void setEmpfangeSpielerSDW(SpielerDatenWrapper empfangeSpielerSDW) {
        this.empfangeSpielerSDW = empfangeSpielerSDW;
    }

    /**
     * param mögliche Runde zusenden
     * @param SendeRundeBool
     */
    public void setSendeRundeBool(boolean SendeRundeBool) {
        this.sendeRundeBool = sendeRundeBool;
    }

    /**
     * param setze aktuelle RUnde
     * @param rundenErgebnisREW
     */
    public void setRundenErgebnisREW(RundenErgebnisWrapper[] rundenErgebnisREW) {
        this.rundenErgebnisREW = rundenErgebnisREW;
    }
    public void setFunkturm(Funkturm funkturm){
        this.funkturm = funkturm;
    }
    public Funkturm getFunkturm(){
        return funkturm;
    }
}
