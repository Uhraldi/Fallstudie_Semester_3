package com.example.patsc.fallstudie.Covered;
import com.example.patsc.fallstudie.Covered.Bestandteile.*;
import com.example.patsc.fallstudie.Covered.Controller.Controller;

/**
 * Created by vince on 01.01.2017.
 * testable
 */

public class Auftrag {

    /**
     * Variablen deklarieren und instanziieren
     * @param fixKosten werden mit jeder Bestellposition, die die Fixkosten der Uhr berühren hochgezählt.
     * @param varKosten werden mit jeder Bestellposition, die die variablen Kosten der Uhr berühren hochgezählt.
     * @param resPr = Reservationspreis: Gibt den Preis an, den Kunden zahlen würden. Wahrscheinlich ausgelagert in Preissimulation
     * @param menge ist die Menge an Uhren, die der Spieler herstellen möchte
     * @param vkp ist der Verkaufspreis, den der Spieler für die Uhren festlegt
     * @param risikoArmband ist das Risiko, das bei der Auswahl eines Armbandes endsteht
     * @param zufall ist die Summe aller zufälligen Produktwertsteigerungen durch zum Beispiel Beliebtheit des Materials
     */
    private double fixKosten = 0;
    private double varKosten = 0;
    private double resPr = 0;
    private int menge = 0;
    private double vkp = 0;
    private double risikoArmband = 0;
    private double risikoGehaeuse = 0;
    private double risikoZusammenbau = 0;
    private double zufall = 0;
    private double strafe = 0.9;


    /**
     * Objekte deklarieren und instanziieren
     */
    private Armband armband = new Armband();
    private Forschung forschung = new Forschung();
    private Gehaeuse gehaeuse = new Gehaeuse();
    public Zeitarbeiter zeitarbeiter = new Zeitarbeiter();
    private Uhrwerk uhrwerk = new Uhrwerk();
    private Bezahlart bezahlart = new Bezahlart();
    private Wasserdichtheit wasserdichtheit = new Wasserdichtheit();
    private Marketing marketing = new Marketing();
    private Marktsim marktsim = null;
    private Preissimulation preissim = null;
    private Personalwesen personalwesen = new Personalwesen();


    public String toString(){
        String stringAuftrag;
        stringAuftrag = fixKosten + ":" + varKosten+ ":"+resPr+ ":"+menge+ ":"+vkp+ ":"+risikoArmband+":"+risikoGehaeuse + ":" + risikoZusammenbau+ ":"+zufall;
        return stringAuftrag;
    }


    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleArmband(String eingabe) throws Exception{
        switch(eingabe) {
            case "Leder": {
                armband.setLeder(true);
                varKosten += armband.getVarKostenLeder();
                resPr += armband.getLederPWS();
                risikoArmband = armband.getLederRisiko();
                zufall += armband.getLederZufall();
                break;
            }
            case "Kunstleder": {
                armband.setKunstleder(true);
                varKosten += armband.getVarKostenKunstleder();
                resPr += armband.getKunstlederPWS();
                risikoArmband = armband.getKunstlederRisiko();
                zufall += armband.getKunstlederZufall();
                break;
            }
            case "Holz": {
                armband.setHolz(true);
                varKosten += armband.getVarKostenHolz();
                resPr += armband.getHolzPWS();
                risikoArmband = armband.getHolzRisiko();
                zufall += armband.getHolzZufall();
                break;
            }
            case "Textil": {
                armband.setTextil(true);
                varKosten += armband.getVarKostenTextil();
                resPr += armband.getTextilPWS();
                risikoArmband = armband.getTextilRisiko();
                zufall += armband.getTextilZufall();
                break;
            }
            case "Metall": {
                armband.setMetall(true);
                varKosten += armband.getVarKostenMetall();
                resPr += armband.getMetallPWS();
                risikoArmband = armband.getMetallRisiko();
                zufall += armband.getMetallZufall();
                break;
            }
            default: {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleForschung(String eingabe) throws Exception{
        switch(eingabe){
            case Controller.FORSCHUNG_WAHL_HOCH: {
                forschung.setInvestition15000(true); //Fehler korrigiert





                //forschung.setMarken(true);
                //Aenderungen patsch 12.01 10.23
                //fixKosten += forschung.getFixkostenInvestition15000();
                //fixKosten = forschung.getFixkostenInvestition15000(); //neu

                fixKosten += forschung.getFixkostenInvestition15000();

                resPr += forschung.getInvestition15000PWS();
                break;
            }
            case Controller.FORSCHUNG_WAHL_MITTELMAESIG: {
                forschung.setInvestition8000(true);
                fixKosten += forschung.getFixkostenInvestition8000();
                resPr += forschung.getInvestition8000PWS();
                break;
            }
            case Controller.FORSCHUNG_WAHL_LOWBUDGET: {
                forschung.setInvestition2500(true);
                fixKosten += forschung.getFixkostenInvestition2500();
                resPr += forschung.getInvestition2500PWS();
                break;
            }
            default: {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleGehaeuse(String eingabe) throws Exception{
        switch(eingabe) {
            case "Glas": {
                gehaeuse.setGlas(true);
                varKosten += gehaeuse.getVarKostenGlas();
                resPr += gehaeuse.getGlasPWS();
                risikoGehaeuse = gehaeuse.getGlasRisiko();
                zufall += gehaeuse.getGlasZufall();
                break;
            }
            case "Holz": {
                gehaeuse.setHolz(true);
                varKosten += gehaeuse.getVarKostenHolz();
                resPr += gehaeuse.getHolzPWS();
                risikoGehaeuse = gehaeuse.getHolzRisiko();
                zufall += gehaeuse.getHolzZufall();
                break;
            }
            case "Kunststoff": {
                gehaeuse.setKunststoff(true);
                varKosten += gehaeuse.getVarKostenKunststoff();
                resPr += gehaeuse.getKunststoffPWS();
                risikoGehaeuse = gehaeuse.getKunststoffRisiko();
                zufall += gehaeuse.getKunststoffZufall();
                break;
            }
            case "Metall": {
                gehaeuse.setMetall(true);
                varKosten += gehaeuse.getVarKostenMetall();
                resPr += gehaeuse.getMetallPWS();
                risikoGehaeuse = gehaeuse.getMetallRisiko();
                zufall += gehaeuse.getMetallZufall();
                break;
            }
            default: {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleZeitarbeiter(String eingabe) throws Exception{
        switch(eingabe) {
            case "Geselle": {
                zeitarbeiter.setGeselle(true);
                varKosten += zeitarbeiter.getVarKostenGeselle(); //neu
                resPr += zeitarbeiter.getGesellePWS();
                risikoZusammenbau = zeitarbeiter.getGeselleRisiko();
                break;
            }
            case "Praktikant": {
                zeitarbeiter.setPraktikant(true);
                varKosten += zeitarbeiter.getVarKostenPraktikant();
                resPr += zeitarbeiter.getPraktikantPWS();
                risikoZusammenbau = zeitarbeiter.getPraktikantRisiko();
                break;
            }
            case "Lehrling": {
                zeitarbeiter.setLehrling(true);
                varKosten += zeitarbeiter.getVarKostenLehrling();
                resPr += zeitarbeiter.getLehrlingPWS();
                risikoZusammenbau = zeitarbeiter.getLehrlingRisiko();
                break;
            }
            case "Meister": {
                zeitarbeiter.setMeister(true);
                varKosten += zeitarbeiter.getVarKostenMeister();
                resPr += zeitarbeiter.getMeisterPWS();
                risikoZusammenbau = zeitarbeiter.getMeisterRisiko();
                break;
            }
            default: {
                // varKosten = 999999;
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleUhrwerk(String eingabe) throws Exception{
        switch (eingabe) {
            case Controller.UHRWERK_WAHL_MECHANISCH: {
                uhrwerk.setMechanisch(true);
                varKosten += uhrwerk.getVarKostenMechanisch();
                resPr += uhrwerk.getMechanischPWS();
                break;
            }
            case Controller.UHRWERK_WAHL_ELEKTROMECHANISCH: {
                uhrwerk.setElektromechanisch(true);
                varKosten += uhrwerk.getVarKostenElektromechanisch();
                resPr += uhrwerk.getElektromechanischPWS();
                break;
            }
            case Controller.UHRWERK_WAHL_ELEKTRONISCH: {
                uhrwerk.setElektronisch(true);
                varKosten += uhrwerk.getVarKostenElektronisch();
                resPr += uhrwerk.getEletronischPWS();
                break;
            }
            default: {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleBezahlart(String eingabe) throws Exception {
        switch (eingabe) {
            case "Kreditkarte": {
                bezahlart.setKreditkarte(true);
                fixKosten += bezahlart.getFixkostenKreditkarte();
                resPr += bezahlart.getKreditkartePWS();
                zufall += bezahlart.getKreditkarteZufall();
                break;
            }
            case "Rechnung": {
                bezahlart.setRechnung(true);
                fixKosten += bezahlart.getFixkostenRechnung();
                resPr += bezahlart.getRechnungPWS();
                zufall += bezahlart.getRechnungZufall();
                break;
            }
            case "PayPal": {
                bezahlart.setPayPal(true);
                fixKosten += bezahlart.getFixkostenPayPal();
                resPr += bezahlart.getPayPalPWS();
                zufall += bezahlart.getPayPalZufall();
                break;
            }
            default: {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleWasserdichtheit(String eingabe) throws Exception {
        switch (eingabe) {
            case "Nicht Wassergeschützt": {
                wasserdichtheit.setNichtWassergeschützt(true);
                varKosten += wasserdichtheit.getNichtWassergeschütztEKP();
                resPr += wasserdichtheit.getNichtWassergeschütztPWS();
                break;
            }
            case "Spritzwassergeschützt": {
                wasserdichtheit.setSpritzwassergeschützt(true);
                varKosten += wasserdichtheit.getSpritzwassergeschütztEKP();
                resPr += wasserdichtheit.getSpritzwassergeschütztPWS();
                break;
            }
            case "Wasserdicht": {
                wasserdichtheit.setWasserdicht(true);
                varKosten += wasserdichtheit.getWasserdichtEKP();
                resPr += wasserdichtheit.getWasserdichtPWS();
                break;
            }
            default: {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void bestelleWerbung(String eingabe) throws Exception {
        switch (eingabe) {
            case Controller.MARKETING_WAHL_FERNSEHWERBUNG: {
                marketing.setFernsehwerbung(true);
                fixKosten += marketing.getFixkostenFernsehwerbung();
                resPr += marketing.getFernsehwerbungPWS();
                break;
            }
            case Controller.MARKETING_WAHL_RADIOWERBUNG: {
                marketing.setRadiowerbung(true);
                fixKosten += marketing.getFixkostenRadiowerbung();
                resPr += marketing.getRadiowerbungPWS();
                break;
            }
            case Controller.MARKETING_WAHL_PRINTWERBUNG: {
                marketing.setPrintwerbung(true);
                fixKosten += marketing.getFixkostenPrintwerbung();
                resPr += marketing.getPrintwerbungPWS();
                break;
            }
            default: {
                throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
            }
        }
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param menge = Menge, die im Spinner eingegeben wird und die Menge an herzustellenden Uhren angibt
     */
    public void bestelleMenge(int menge){
        this.menge = menge;
    }

    /**
     * Methode, die ausgelöst wird, sobald der Screen zum Bestellen dieses Bestandteils ausgefüllt wurde und auf "weiter" gedrückt wurde
     * @param vkp = Verkaupspreis, der im Spinner eingegeben wird und den Verkaufspreis bestimmt, zu dem die Uhren am Markt angeboten werden
     */
    public void bestelleVKP(double vkp){
        this.vkp = vkp;
    }

    /**
     * Methode, die ausgelöst wird, wenn das Risikoereignis im Armband ausgelöst woird. Alle relevanten Änderungen an den Variablen weden zurückgerollt und mit der neien eingabe erneut ausgeführt
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void korrigiereArmband( String eingabe) throws Exception{
        if(armband.isLeder()){
            armband.setLeder(false);
            varKosten = varKosten- (armband.getVarKostenLeder()*strafe);
            resPr -= armband.getLederPWS();
            risikoArmband = 0;
            zufall -= armband.getLederZufall();
        }else if(armband.isKunstleder()) {
            armband.setKunstleder(false);
            varKosten = varKosten- (armband.getVarKostenKunstleder()*strafe);
            resPr -= armband.getKunstlederPWS();
            risikoArmband = 0;
            zufall -= armband.getKunstlederZufall();
        }else if(armband.isHolz()) {
            armband.setHolz(false);
            varKosten = varKosten- (armband.getVarKostenHolz()*strafe);
            resPr -= armband.getHolzPWS();
            risikoArmband = 0;
            zufall -= armband.getHolzZufall();
        }else if(armband.isTextil()) {
            armband.setTextil(false);
            varKosten = varKosten- (armband.getVarKostenTextil()*strafe);
            resPr -= armband.getTextilPWS();
            risikoArmband = 0;
            zufall -= armband.getTextilZufall();
        }else if (armband.isMetall()) {
            armband.setMetall(false);
            varKosten = varKosten- (armband.getVarKostenMetall()*strafe);
            resPr -= armband.getMetallPWS();
            risikoArmband = 0;
            zufall -= armband.getMetallZufall();
        }else {
            throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
        }
        varKosten = varKosten * getStrafe(); //Erhöhung der varKosten um eine Strafe max um varKosten*1.05^3 bei 3 Ereignissen
        bestelleArmband(eingabe);
    }

    /**
     * Methode, die ausgelöst wird, wenn das Risikoereignis im Gehaeuse ausgelöst woird. Alle relevanten Änderungen an den Variablen weden zurückgerollt und mit der neien eingabe erneut ausgeführt
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void korrigiereGehaeuse(String eingabe) throws Exception{
        if(gehaeuse.isGlas()){
            gehaeuse.setGlas(false);
            varKosten = varKosten- (gehaeuse.getVarKostenGlas()*strafe);
            resPr -= gehaeuse.getGlasPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getGlasZufall();
        }else if (gehaeuse.isHolz()){
            gehaeuse.setHolz(false);
            varKosten = varKosten- (gehaeuse.getVarKostenHolz()*strafe);
            resPr -= gehaeuse.getHolzPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getHolzZufall();
        }else if (gehaeuse.isKunststoff()){
            gehaeuse.setKunststoff(false);
            varKosten = varKosten- (gehaeuse.getVarKostenKunststoff()*strafe);
            resPr -= gehaeuse.getKunststoffPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getKunststoffZufall();
        }else if (gehaeuse.isMetall()){
            gehaeuse.setMetall(false);
            varKosten = varKosten- (gehaeuse.getVarKostenMetall()*strafe);
            resPr -= gehaeuse.getMetallPWS();
            risikoGehaeuse = 0;
            zufall -= gehaeuse.getMetallZufall();
        }else{
            throw new Exception("Die Eingabe String zur Festlegung der Auswahl stimmt mit keiner Auswahlmöglichkeit überein");
        }
        varKosten += getStrafe();
        bestelleGehaeuse(eingabe);
    }

    /**
     * Methode, die ausgelöst wird, wenn das Risikoereignis im Zeitarbeiter ausgelöst woird. Alle relevanten Änderungen an den Variablen weden zurückgerollt und mit der neien eingabe erneut ausgeführt
     * @param eingabe = Eingabe aus dem Spinner, der angibt, welche Eingabe getätigt wurde
     * @throws Exception
     */
    public void korriegiereZeitarbeiter(String eingabe) throws Exception{
        if(zeitarbeiter.isGeselle()){
            zeitarbeiter.setGeselle(false);
            varKosten = varKosten- (zeitarbeiter.getVarKostenGeselle()*strafe);
            resPr -= zeitarbeiter.getGesellePWS();
            risikoZusammenbau = 0;
        }else if(zeitarbeiter.isPraktikant()){
            zeitarbeiter.setPraktikant(false);
            varKosten = varKosten- (zeitarbeiter.getVarKostenPraktikant()*strafe);
            resPr -= zeitarbeiter.getPraktikantPWS();
            risikoZusammenbau = 0;
        }else if (zeitarbeiter.isLehrling()) {
            zeitarbeiter.setLehrling(false);
            varKosten = varKosten- (zeitarbeiter.getVarKostenLehrling()*strafe);
            resPr -= zeitarbeiter.getLehrlingPWS();
            risikoZusammenbau = 0;
        }else if(zeitarbeiter.isMeister()){
            zeitarbeiter.setMeister(false);
            varKosten = varKosten- (zeitarbeiter.getVarKostenMeister()*strafe);
            resPr -= zeitarbeiter.getMeisterPWS();
            risikoZusammenbau = 0;
        }else{
            throw new Exception();
        }
        varKosten += getStrafe();
        bestelleZeitarbeiter(eingabe);
    }

    public void bestellePersonalwesen (int zahl){ //// TODO: 24.01.2017 #Vincent #Patschi
        personalwesen.setEingestellte(zahl);
        fixKosten = fixKosten + personalwesen.getEingestellte()*personalwesen.getPersonalKostenProMitarbeiter();
    }

    /**
     *  Variablen-Getter
     */


    public double getFixKosten() {
        return fixKosten;
    }

    public double getVarKosten() {
        return varKosten;
    }

    public double getResPr() {
        return resPr;
    }

    public int getMenge() {
        return menge;
    }

    public double getVkp() {
        return vkp;
    }

    public double getRisikoArmband() {
        return risikoArmband;
    }

    public double getRisikoGehaeuse() {
        return risikoGehaeuse;
    }

    public double getRisikoZusammenbau() {
        return risikoZusammenbau;
    }

    public double getZufall() {
        return zufall;
    }

    public double getStrafe(){
        return 0.05;
    }

    /**
     * Bestandteil-Getter
     */
    public Personalwesen getPersonalwesen(){
        return personalwesen;
    }
    public Zeitarbeiter getZeitarbeiter(){
        return zeitarbeiter;
    }
    public Forschung getForschung() {
        return forschung;
    }

    public Armband getArmband() {
        return armband;
    }

    public Uhrwerk getUhrwerk() {
        return uhrwerk;
    }

    public Gehaeuse getGehaeuse() {
        return gehaeuse;
    }

    public Zeitarbeiter getZusammenbau() {
        return zeitarbeiter;
    }

    public Bezahlart getBezahlart() {
        return bezahlart;
    }

    public Wasserdichtheit getWasserdichtheit() {
       return wasserdichtheit;
    }

    public Marketing getMarketing() {
        return marketing;
    }

    public Preissimulation getPreissimulation(){
        return preissim;
    }

    public Marktsim getMarktsim(){
        return marktsim;
    }

    /**
     * Objekt-Setter
     */


    public void setMarktsim(Marktsim marktsim) {
        this.marktsim = marktsim;
    }

    public void setPreissim(Preissimulation preissim) {
        this.preissim = preissim;
    }


    /**
     * Variablen Setter
     */

    /**
     * ToDO Prüfung erlaubter Wert
     * ToDo alter + neuer Wert
     */
    public void setVarKosten(double varKosten1){

        varKosten = varKosten1;

    }

    public void setStrafe(double strafe) {
        this.strafe = strafe;
    }

    public void setArmband(Armband armband) {
        this.armband = armband;
    }

    public void setForschung(Forschung forschung) {
        this.forschung = forschung;
    }

    public void setGehaeuse(Gehaeuse gehaeuse) {
        this.gehaeuse = gehaeuse;
    }

    public void setZeitarbeiter(Zeitarbeiter zeitarbeiter) {
        this.zeitarbeiter = zeitarbeiter;
    }

    public void setUhrwerk(Uhrwerk uhrwerk) {
        this.uhrwerk = uhrwerk;
    }

    public void setBezahlart(Bezahlart bezahlart) {
        this.bezahlart = bezahlart;
    }

    public void setWasserdichtheit(Wasserdichtheit wasserdichtheit) {
        this.wasserdichtheit = wasserdichtheit;
    }

    public void setMarketing(Marketing marketing) {
        this.marketing = marketing;
    }

    public Preissimulation getPreissim() {
        return preissim;
    }

    public void setPersonalwesen(Personalwesen personalwesen) {
        this.personalwesen = personalwesen;
    }

    public void setFixKosten(double i){
        fixKosten = i;
    }

    public void setResPr(double resPr) {
        this.resPr = resPr;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public void setVkp(double vkp) {
        this.vkp = vkp;
    }

    public void setRisikoArmband(double risikoArmband) {
        this.risikoArmband = risikoArmband;
    }

    public void setRisikoGehaeuse(double risikoGehaeuse) {
        this.risikoGehaeuse = risikoGehaeuse;
    }

    public void setRisikoZusammenbau(double risikoZusammenbau) {
        this.risikoZusammenbau = risikoZusammenbau;
    }

    public void setZufall(double zufall) {
        this.zufall = zufall;
    }
}
