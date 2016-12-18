
/**
 * Created by patsc on 13.12.2016.
 */
public abstract interface Model {
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
    public final String SCHRITT_WERBUNG = "SCHRITT_WEBUNG"; // siebter Schritt Wahl des Webetars
    public final String SCHRITT_KAUFVOLUMEN = "SCHRITT_KAUFVOLUMEN"; // achter Schritt Wahl des Kaufvolumens
    public final String SCHRITT_VERSANDART = "SCHRITT_VERSANDART"; // neunter Schritt Wahl der Versandart
    public final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS"; // zehnter Schritt Wahl der Versandart
    /*
     * getter Methoden
     * keine String Methode da final
     */


    public String getSchrittDesigner();
    public String getSchrittArmband();
    public String getSchrittUhrwerk();
    public String getSchrittDichtheit();
    public String getSchrittGehauese();
    public String getSchrittZusammenbau();
    public String getSchrittWerbung();
    public String getSchrittKaufvolumen();
    public String getSchrittVersandart();
    public String getSchrittVerkaufspreis();

    /*
            Zustände während des Spiels
             */
    public boolean Zustand_Spielbeginn = true;
    public boolean Zustand_Bestellung = false;
    public boolean Zustand_Ereignis = false; // ToDO Eventuell mehrere? für jedes Ereignis ein eigener Zustand? Oder wie bei Bestellung?
    public boolean Zustand_Aenderung = false;
    public boolean Zustand_Lieferung = false;
    public boolean Zustand_Verkauf = false; // 3 Phasen? // ToDo
    public boolean Zustand_Ende = false;
    /*
    Getter und Setter für Zustände
     */
    public boolean isZustand_Spielbeginn();
    public boolean isZustand_Aenderung();
    public boolean isZustand_Bestellung();
    public boolean isZustand_Ende();
    public boolean isZustand_Ereignis();
    public boolean isZustand_Lieferung();
    public boolean isZustand_Verkauf();

    public void setZustand_Spielbeginn(boolean Zustand);
    public void setZustand_Ereignis(boolean Zustand);
    public void setZustand_Aenderung(boolean Zustand);
    public void setZustand_Bestellung(boolean Zustand);
    public void setZustand_Lieferung (boolean Zustand);
    public void setZustand_Verkauf (boolean Zustand);
    public void setZustand_Ende (boolean Zustand);


    /**
     * Methoden
     */

    public void naechster_Schritt_Auswahl(); // Setzen des nächsten AuswahlSchritts
    public void naechster_Zustand(); // Setzen des nächsten Zustands



} // ENDE KLASSE
