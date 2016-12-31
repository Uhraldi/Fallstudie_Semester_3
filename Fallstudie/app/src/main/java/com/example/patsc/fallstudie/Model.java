package com.example.patsc.fallstudie;

/**
 * Created by patsc on 13.12.2016.
 */
public class  Model {
    /*
    Deklaration der einzelnen Namen der Schritte.
    Final damit sich der Name nicht verändert.
     */
    // Einzelne Schritte in dem Auswahlprozess
    public final String SCHRITT_DESIGNER = "SCHRITT_DESIGNER"; // erster Schritt Wahl des Designers
    public final String SCHRITT_ARMBAND = "SCHRITT_ARMBAND"; // zweite Schritt Wahl des Armbands
    public final String SCHRITT_UHRWERK = "SCHRITT_UHRWERK"; // dritter Schritt Wahl des Uhrwerks und der Uhrenart
    public final String SCHRITT_GEHAUESE = "SCHRITT_GEHAUSE"; // vierter Schritt Wahl des Gehäuses für die Uhr
    public final String SCHRITT_DICHTHEIT = "SCHRITT_DICHTHEIT"; // fuenfter Schritt Wahl der Dichtheit
    public final String SCHRITT_ZUSAMMENBAU = "SCHRITT_ZUSAMMENBAU"; // sechster Schritt Wahl Zusammenbau
    public final String SCHRITT_WERBUNG = "SCHRITT_WEBUNG"; // siebter Schritt Wahl des Werbeetars
    public final String SCHRITT_KAUFVOLUMEN = "SCHRITT_KAUFVOLUMEN"; // achter Schritt Wahl des Kaufvolumens
    public final String SCHRITT_VERSANDART = "SCHRITT_VERSANDART"; // neunter Schritt Wahl der Versandart
    public final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS"; // zehnter Schritt Wahl der Versandart
    /*
     * getter Methoden
     * keine String Methode da final
     */


    public String getSchrittDesigner(){return SCHRITT_DESIGNER;}
    public String getSchrittArmband(){return SCHRITT_ARMBAND;}
    public String getSchrittUhrwerk(){return SCHRITT_UHRWERK;}
    public String getSchrittDichtheit(){return SCHRITT_DICHTHEIT;}
    public String getSchrittGehauese(){return SCHRITT_GEHAUESE;}
    public String getSchrittZusammenbau(){return SCHRITT_ZUSAMMENBAU;}
    public String getSchrittWerbung(){return SCHRITT_WERBUNG;}
    public String getSchrittKaufvolumen(){return SCHRITT_KAUFVOLUMEN;}
    public String getSchrittVersandart(){return SCHRITT_VERSANDART;}
    public String getSchrittVerkaufspreis(){return SCHRITT_VERKAUFSPREIS;}

    /*
            Zustände während des Spiels
             */
    private boolean Zustand_Spielbeginn = true;
    private boolean Zustand_Bestellung = false;
    private boolean Zustand_Ereignis = false; // ToDO Eventuell mehrere? für jedes Ereignis ein eigener Zustand? Oder wie bei Bestellung?
    private boolean Zustand_Aenderung = false;
    private boolean Zustand_Lieferung = false;
    private boolean Zustand_Verkauf = false; // 3 Phasen? // ToDo
    private boolean Zustand_Ende = false;
    /*
    Getter und Setter für Zustände
     */
    public boolean isZustand_Spielbeginn(){return Zustand_Spielbeginn;}
    public boolean isZustand_Aenderung(){return Zustand_Aenderung;}
    public boolean isZustand_Bestellung(){return Zustand_Bestellung;}
    public boolean isZustand_Ende(){return Zustand_Ende;}
    public boolean isZustand_Ereignis(){return Zustand_Ereignis;}
    public boolean isZustand_Lieferung(){return Zustand_Lieferung;}
    public boolean isZustand_Verkauf() {return Zustand_Verkauf;}

    public void setZustand_Spielbeginn(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Spielbeginn = true;
    }
    public void setZustand_Ereignis(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Ereignis = true;
    }
    public void setZustand_Aenderung(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Aenderung = true;
    }
    public void setZustand_Bestellung(boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Bestellung = true;
    }
    public void setZustand_Lieferung (boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Lieferung = true;
    }
    public void setZustand_Verkauf (boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Verkauf = true;
    }
    public void setZustand_Ende (boolean Zustand){
        setzeAlleZustaendeFalse();
        Zustand_Ende = false;
    }


    /**
     * Methoden
     */

    public void naechster_Schritt_Auswahl(){} // Setzen des nächsten AuswahlSchritts
    public void naechster_Zustand(){} // Setzen des nächsten Zustands


    /**
     * Hilfsmethoden
     */


    /**
     * Alle Zustaende werden auf false gesetzt
     */
    private void setzeAlleZustaendeFalse(){
        Zustand_Aenderung = false;
        Zustand_Bestellung = false;
        Zustand_Ende = false;
        Zustand_Ereignis = false;
        Zustand_Lieferung = false;
        Zustand_Spielbeginn = false;
        Zustand_Verkauf = false;
    }
} // ENDE KLASSE
