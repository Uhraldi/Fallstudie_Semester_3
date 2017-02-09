package com.example.patsc.fallstudie.Covered.Controller;

/**
 * Created by patsc on 06.02.2017.
 */

public interface IZustaende {

    /**
     * Strings für die Übergabe der Auswahl
     * Da sich diese nicht ändern dürfen, werden sind sie final gesetzt.
     *
     * Die Strings sind public, da von allen Klassen aus auf sie zugegriffen werden können soll.
     * Damit keine Instanz einer Klasse, die das Interfache implementiert bestehen muss, sind die Werte static.
     */

    // Strings für die Forschung
    public static final String FORSCHUNG_WAHL_LOWBUDGET = "2500€ Investition";
    public static final String FORSCHUNG_WAHL_MITTELMAESIG = "8000€ Investition";
    public static final String FORSCHUNG_WAHL_HOCH = "15000€ Investition";

    // Strings für das Armband
    public static final String ARMBAND_WAHL_LEDER = "Leder";
    public static  final String ARMBAND_WAHL_KUNSTLEDER = "Kunstleder";
    public static  final String ARMBAND_WAHL_HOLZ = "Holz";
    public static final String ARMBAND_WAHL_TEXTIL = "Textil";
    public static final String ARMBAND_WAHL_METALL = "Metall";

    // Strings für das Uhrwerk
    public static final String UHRWERK_WAHL_MECHANISCH = "Mechanisch";
    public static final String UHRWERK_WAHL_ELEKTROMECHANISCH ="Elektromechanisch";
    public static final String UHRWERK_WAHL_ELEKTRONISCH = "Elektronisch";

    // Strings für das Gehäuse
    public static final String GEHAEUSE_WAHL_GLAS = "Glas";
    public static final String GEHAEUSE_WAHL_HOLZ = "Holz";
    public static final String GEHAEUSE_WAHL_KUNSTSTOFF = "Kunststoff";
    public static final String GEHAEUSE_WAHL_METALL ="Metall";

    // Strings für die Bezahlart
    public static final String BEZAHLART_WAHL_KREDITKARTE = "Kreditkarte";
    public static final String BEZAHLART_WAHL_RECHNUNG ="Rechnung";
    public static final String BEZAHLART_WAHL_PAYPAL = "PayPal";

    // Strings für die Zeitarbeiter
    public static final String ZEITARBEITER_WAHL_GESELLE = "Geselle";
    public static final String ZEITARBEITER_WAHL_PRAKTIKANT ="Praktikant";
    public static final String ZEITARBEITER_WAHL_Lehrling ="Lehrling";
    public static  final String ZEITARBEITER_WAHL_MEISTER ="Meister";

    // Strings für das Marketing
    public static final String MARKETING_WAHL_RADIOWERBUNG = "Radiowerbung";
    public static final String MARKETING_WAHL_PRINTWERBUNG = "Printwerbung";
    public static final String MARKETING_WAHL_FERNSEHWERBUNG = "Fernsehwerbung";

    // Einzelne Schritte in dem Auswahlprozess
    public static final String SCHRITT_FORSCHUNG = "SCHRITT_FORSCHUNG";
    public static final String SCHRITT_ARMBAND = "SCHRITT_ARMBAND";
    public static final String SCHRITT_UHRWERK = "SCHRITT_UHRWERK";
    public static final String SCHRITT_GEHAUESE = "SCHRITT_GEHAUSE";
    public static final String SCHRITT_ZEITARBEITER = "SCHRITT_ZEITARBEITER";
    public static final String SCHRITT_MARKETING = "SCHRITT_MARKETING";
    public static final String SCHRITT_PRODUKTIONSVOLUMEN = "SCHRITT_PRODUKTIONSVOLUMEN";
    public static final String SCHRITT_BEZAHLART = "SCHRITT_BEZAHLART";
    public static final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS";
    public static final String SCHRITT_PERSONALWESEN = "SCHRITT_PERSONALWESEN";




}
