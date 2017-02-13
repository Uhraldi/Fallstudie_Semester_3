package com.example.patsc.fallstudie.Covered.Daten;

import com.example.patsc.fallstudie.Covered.Auftrag;
import com.example.patsc.fallstudie.Covered.Auftragssammlung;
import com.example.patsc.fallstudie.Covered.Marktsim;
import com.example.patsc.fallstudie.Covered.Preissimulation;
import com.example.patsc.fallstudie.Covered.Spieler;
import com.example.patsc.fallstudie.Covered.Controller.*;

/**
 * Created by Patricia Schneider on 06.02.2017.
 */

public class SpielerAbfragen extends SuperDaten{

    public Spieler ASDgetAktiverSpieler(){
        return getController().getAktiverSpieler();
    }
    public Auftragssammlung ASDgetAuftragsamlung(){
        return ASDgetAktiverSpieler().getAuftragssammlung();
    }
    public Auftrag ASDgetAktuellerAuftrag(){
        return ASDgetAuftragsamlung().getAktuellerAuftrag();
    }

    public void ASDsetPreisSim(Preissimulation preissim){
        ASDgetAktuellerAuftrag().setPreissim(preissim);
    }
    public void ASDserMarktSim(Marktsim marktsim){
        ASDgetAktuellerAuftrag().setMarktsim(marktsim);
    }
}
