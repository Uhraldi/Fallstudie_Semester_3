package com.example.patsc.fallstudie.Covered.Bestandteile.Controller;

/**
 * Created by patsc on 06.02.2017.
 */

public interface IZustaende {

    /**
     * Strings für die Übergabe der Auswahl
     */
    public static final String FORSCHUNG_WAHL_LOWBUDGET = "2500€ Investition";
    public static final String FORSCHUNG_WAHL_MITTELMAESIG = "8000€ Investition";
    public static final String FORSCHUNG_WAHL_HOCH = "15000€ Investition";

    public static final String ARMBAND_WAHL_LEDER = "Leder";
    public static  final String ARMBAND_WAHL_KUNSTLEDER = "Kunstleder";
    public static  final String ARMBAND_WAHL_HOLZ = "Holz";
    public static final String ARMBAND_WAHL_TEXTIL = "Textil";
    public static final String ARMBAND_WAHL_METALL = "Metall";

    public static final String UHRWERK_WAHL_MECHANISCH = "Mechanisch";
    public static final String UHRWERK_WAHL_ELEKTROMECHANISCH ="Elektromechanisch";
    public static final String UHRWERK_WAHL_ELEKTRONISCH = "Elektronisch";

    public static final String GEHAEUSE_WAHL_GLAS = "Glas";
    public static final String GEHAEUSE_WAHL_HOLZ = "Holz";
    public static final String GEHAEUSE_WAHL_KUNSTSTOFF = "Kunststoff";
    public static final String GEHAEUSE_WAHL_METALL ="Metall";

    public static final String BEZAHLART_WAHL_KREDITKARTE = "Kreditkarte";
    public static final String BEZAHLART_WAHL_RECHNUNG ="Rechnung";
    public static final String BEZAHLART_WAHL_PAYPAL = "PayPal";

//    private final String WASSERDICHTHEIT_WAHL_NICHTWASSERGESCHUETZT = "nichtWassergeschützt";
//    private final String WASSERDICHTHEIT_WAHL_SPRITZWASSERGESCHUETZT = "spritzwassergeschützt";
//    private final String WASSERDICHTHEIT_WAHL_WASSERDICHT = "wasserdicht";

    public static final String ZEITARBEITER_WAHL_GESELLE = "Geselle";
    public static final String ZEITARBEITER_WAHL_PRAKTIKANT ="Praktikant";
    public static final String ZEITARBEITER_WAHL_Lehrling ="Lehrling";
    public static  final String ZEITARBEITER_WAHL_MEISTER ="Meister";

    public static final String MARKETING_WAHL_RADIOWERBUNG = "Radiowerbung";
    public static final String MARKETING_WAHL_PRINTWERBUNG = "Printwerbung";
    public static final String MARKETING_WAHL_FERNSEHWERBUNG = "Fernsehwerbung";

    // Einzelne Schritte in dem Auswahlprozess
    public static final String SCHRITT_FORSCHUNG = "SCHRITT_FORSCHUNG"; // erster Schritt Wahl des Designers
    public static final String SCHRITT_ARMBAND = "SCHRITT_ARMBAND"; // zweite Schritt Wahl des Armbands
    public static final String SCHRITT_UHRWERK = "SCHRITT_UHRWERK"; // dritter Schritt Wahl des Uhrwerks und der Uhrenart
    public static final String SCHRITT_GEHAUESE = "SCHRITT_GEHAUSE"; // vierter Schritt Wahl des Gehäuses für die Uhr
    // private final String SCHRITT_DICHTHEIT = "SCHRITT_DICHTHEIT"; // fuenfter Schritt Wahl der Dichtheit
    public static  final String SCHRITT_ZEITARBEITER = "SCHRITT_ZEITARBEITER"; // sechster Schritt Wahl Zeitarbeiter
    public static  final String SCHRITT_MARKETING = "SCHRITT_MARKETING"; // siebter Schritt Wahl des Werbeetars
    public static final String SCHRITT_PRODUKTIONSVOLUMEN = "SCHRITT_PRODUKTIONSVOLUMEN"; // achter Schritt Wahl des Kaufvolumens
    public static final String SCHRITT_BEZAHLART = "SCHRITT_BEZAHLART"; // neunter Schritt Wahl der Bezahlart
    public static final String SCHRITT_VERKAUFSPREIS = "SCHRITT_VERKAUFSPREIS"; // zehnter Schritt Wahl der Bezahlart
    public static final String SCHRITT_PERSONALWESEN = "SCHRITT_PERSONALWESEN";




}
