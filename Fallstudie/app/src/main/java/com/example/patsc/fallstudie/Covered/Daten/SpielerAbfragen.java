package com.example.patsc.fallstudie.Covered.Daten;

import com.example.patsc.fallstudie.Covered.Auftrag;
import com.example.patsc.fallstudie.Covered.Auftragssammlung;
import com.example.patsc.fallstudie.Covered.Marktsim;
import com.example.patsc.fallstudie.Covered.Preissimulation;
import com.example.patsc.fallstudie.Covered.Spieler;

/**
 * Created by patsc on 06.02.2017.
 */

public class SpielerAbfragen extends SuperDaten implements ISpielerAbfragen {

    public Spieler ASDgetAktiverSpieler(){
        return getController().getAktiverSpieler();
    }
    public Auftragssammlung ASDgetAuftragsamlung(){
        return ASDgetAktiverSpieler().getAuftragssammlung();
    }
    public Auftrag ASDgetAktuellerAuftrag(){
        return ASDgetAuftragsamlung().getAktuellerAuftrag();
    }
    public double ASDgetFixkosten(){
        return ASDgetAktuellerAuftrag().getFixKosten();
    }
    public double ASDgetVarKosten(){
        return ASDgetAktuellerAuftrag().getVarKosten();
    }
    public double ASDgetGesamtKosten(){
        return ASDgetFixkosten() + ASDgetVarKosten();
    }
    public void ASDsetPreisSim(Preissimulation preissim){
        ASDgetAktuellerAuftrag().setPreissim(preissim);
    }
    public void ASDserMarktSim(Marktsim marktsim){
        ASDgetAktuellerAuftrag().setMarktsim(marktsim);
    }
}
