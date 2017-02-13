package com.example.patsc.fallstudie.Covered.Controller;

/**
 * Created by patsc on 06.02.2017.
 */

public interface INetzwerk {
    public void rundeHochladen(Controller c);
    public RundenErgebnisWrapper[] gegnerHerunterladen (Controller c);
    public void spielerDatenSpeichern (Controller c);

    // Aufnahme der setter damit die Erstellung der Variablen sichergestellt ist
    public void setUpdateBool(boolean updateBool);
    public void setRegistrierungBool(boolean registrierungBool);
    public void setSendeRundeBool(boolean SendeRundeBool);

    public void setEmpfangeSpielerSDW(SpielerDatenWrapper empfangeSpielerSDW);
    public void setRundenErgebnisREW(RundenErgebnisWrapper[] rundenErgebnisREW);

}
