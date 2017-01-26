package com.example.patsc.fallstudie.LokaleDaten;

import com.example.patsc.fallstudie.Controller;
import com.example.patsc.fallstudie.Daten;
import com.example.patsc.fallstudie.Spieler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by patsc on 20.01.2017.
 */

public class lokaleDaten {

    private static String  fileName ="Manufaktuhr";

    private String datenS = "Daten";
    private String controllerS = "Controller";
    private String spielerS = "Spieler";
    private String auftragsammlungS = "Auftragsammlung";
    private String auftragS = "Auftrag";
    private String armbandsS = "Armband";
    private String forschungS = "Forschung";
    private String gehaeuseS = "Gehaeuse";
    private String zeitarbeiterS = "Zeitarbeiter";
    private String uhrwerkS ="Uhrwerk";
    private String bezahlartS = "Bezahlart";
    private String wasserdichtheitS = "Wasserdichtheit";
    private String marketingS = "Marketing";
    private String personalwesenS = "Personalwesen";
    private String marktSimS ="Marktsimulation";
    private String preisSimsS = "Preissimulation";

    private Daten daten;
    private Controller controller;
    private Spieler spieler;

    public lokaleDaten(Daten d, Controller c){
        daten = d;
        controller = c;
        spieler = c.aktiverSpieler;
    }
    public void load() {
        try{
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

            String zeile = "";

            while( (zeile = br.readLine()) != null )
            {
                // Objekt die während des Prozesses erzeugt werden
                int rundenanzahl = 0;
                Controller c;
                Daten d;
                Spieler s;

                String[] fZeile;



                // Daten ereugen
                fZeile = zeile.split(controllerS);
                String stringDaten = fZeile[0];
                String[] datenFeld = stringDaten.split(":"); // datenFeld[0] = Daten datenFeld[1] rundenanzahl
                rundenanzahl = Integer.parseInt(datenFeld[1]);
                d = new Daten();
                d.setRundenAnzahl(rundenanzahl);

                zeile = fZeile[1];
                fZeile = zeile.split(spielerS);
                String stringController= fZeile[0];
                // Keine Infos aus Controller nur erzeugen;
                c = new Controller();

                //Spieler
                zeile = fZeile[1];
                fZeile = zeile.split(auftragsammlungS);
                String stringSpieler = fZeile[0];
                String[] spielerFeld = stringSpieler.split(":"); // Name Passwort Guthaben Marktanteil Punkte
                s = new Spieler(spielerFeld[0],spielerFeld[1],d); // gesetzt name passwort daten
                s.setGuthaben(Double.parseDouble(spielerFeld[2]));
                s.setMarktanteil(Double.parseDouble(spielerFeld[3]));
                s.setPunkte(Integer.parseInt(spielerFeld[4]));

                //Auftragsammlunh
                zeile = fZeile[1];
                fZeile = zeile.split(auftragS);
                String stringAuftragsammlung = fZeile[0];
                String[] auftragSFeld = stringAuftragsammlung.split(":");
                s.getAuftragssammlung().setAktuellerAuftragInt(Integer.parseInt(auftragSFeld[1]));


                //Setzen der einzelnen Aufträge
                for ( int i = 0; i<rundenanzahl;i++){
                    zeile = fZeile[1];
                    fZeile = zeile.split(armbandsS);
                    String stringAuftrag=fZeile[0];
                    String[] auftragFeld = stringAuftrag.split(":");
                    // Reihenfolge Fixkosten varKosten resPreis Menge vkp risikoArmband risikoGehaeuese risikoZusammenbau Zufall
                    int k = 0;
                    s.getAuftragssammlung().getAuftrag(i).setFixKosten(Double.parseDouble(auftragFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).setVarKosten(Double.parseDouble(auftragFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).setResPr(Double.parseDouble(auftragFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).setMenge(Integer.parseInt(auftragFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).setVkp(Double.parseDouble(auftragFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).setRisikoArmband(Double.parseDouble(auftragFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).setRisikoGehaeuse(Double.parseDouble(auftragFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).setRisikoZusammenbau(Double.parseDouble(auftragFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).setZufall(Double.parseDouble(auftragFeld[k])); k++;

                    //Bestandteil Armband
                    zeile = fZeile[1];
                    fZeile = zeile.split(forschungS);
                    String stringArmband=fZeile[0];
                    String[] armbandFeld = stringArmband.split(":"); // Reihenfolge lederzufall kunstlederzufall holzzufall textilzufall metallzufall MaterialString
                    k = 0;
                    s.getAuftragssammlung().getAuftrag(i).getArmband().setLederZufall(Double.parseDouble(armbandFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).getArmband().setKunstlederZufall(Double.parseDouble(armbandFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).getArmband().setHolzZufall(Double.parseDouble(armbandFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).getArmband().setTextilZufall(Double.parseDouble(armbandFeld[k])); k++;
                    s.getAuftragssammlung().getAuftrag(i).getArmband().setMetallZufall(Double.parseDouble(armbandFeld[k])); k++;
                    c.setArmbandEingabeWerte(armbandFeld[k],spieler,rundenanzahl);

                    //Bestandteil Forschung
                    zeile = fZeile[1];
                    fZeile = zeile.split(gehaeuseS);
                    String stringForschung=fZeile[0];
                    String[] ForschungFeld = stringForschung.split(":");
                    c.setForschungEingabeWerte(ForschungFeld[k],spieler,rundenanzahl);

                    //Bestandteil Gehaeuse
                    zeile = fZeile[1];
                    fZeile = zeile.split(zeitarbeiterS);
                    String stringGehaeuse=fZeile[0];
                    String[] gehaeuseFeld = stringGehaeuse.split(":");
                    k=0;  //Reihenfolge glasZufall holzzufall kunststoffZufall metallZufall gehaueseString
                    s.getAuftragssammlung().getAuftrag(i).getGehaeuse().setGlasZufall(Double.parseDouble(gehaeuseFeld[k]));k++;
                    s.getAuftragssammlung().getAuftrag(i).getGehaeuse().setHolzZufall(Double.parseDouble(gehaeuseFeld[k]));k++;
                    s.getAuftragssammlung().getAuftrag(i).getGehaeuse().setKunststoffZufall(Double.parseDouble(gehaeuseFeld[k]));k++;
                    s.getAuftragssammlung().getAuftrag(i).getGehaeuse().setMetallZufall(Double.parseDouble(gehaeuseFeld[k]));k++;
                    c.setGehaueseWerte(gehaeuseFeld[k],spieler,rundenanzahl);

                    //Bestandteil Zeitarbeiter
                    zeile = fZeile[1];
                    fZeile = zeile.split(uhrwerkS);
                    String stringZeitarbeiter=fZeile[0];
                    String[] zeitarbeiterFeld = stringZeitarbeiter.split(":");
                    c.setZeitarbeiterWerte(zeitarbeiterFeld[0],spieler,rundenanzahl);

                    //Besandteil Uhrwerk
                    zeile = fZeile[1];
                    fZeile = zeile.split(bezahlartS);
                    String stringUhrwerk=fZeile[0];
                    String[] uhrwerkFeld = stringUhrwerk.split(":");
                    c.setUhrwerkEingabeWerte(uhrwerkFeld[0],spieler,rundenanzahl);

                    //Bestandteil Bezahlart
                    //ToDo mehrere einzel Werte Methode in Controller
                    zeile = fZeile[1];
                    fZeile = zeile.split(marketingS);
                    String stringMarketing=fZeile[0];
                    String[] marketingFeld = stringMarketing.split(":");
                    c.setBezahlartWerte(marketingFeld[0],spieler,rundenanzahl);

                    //Bestandteil Personalwesen
                    zeile = fZeile[1];
                    String stringPersonalwesen=fZeile[0];
                    String[] personalwesenFeld= stringPersonalwesen.split(":");
                    k=0; // Reihenfolge eingestellte veraenderung fixkosten
                    s.getAuftragssammlung().getAuftrag(i).getPersonalwesen().setEingestellte(Integer.parseInt(personalwesenFeld[k]));k++;
                    s.getAuftragssammlung().getAuftrag(i).getPersonalwesen().setVeraenderung(Integer.parseInt(personalwesenFeld[k]));k++;
                    s.getAuftragssammlung().getAuftrag(i).getPersonalwesen().setFixkosten(Integer.parseInt(personalwesenFeld[k]));


                }// ENde for Auftrag
            } // Ende While

        br.close();}
        catch (Exception e) {
        }
    } // Ende load

    public void save(){

        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);

        BufferedWriter bw = new BufferedWriter(fw);
//Durchlaufen der Spieler liste
            ArrayList<Spieler> spielerListe = daten.getSpielerListe();

            for (int i = 0; i<spielerListe.size(); i++){
                bw.write("\n" + "NaechsterSpieler:");
                spieler = spielerListe.get(i);
                bw.write(schreibeStringSpieler());

            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// Ende save


    public String schreibeStringSpieler (){
        String stringSpieler;

        stringSpieler = datenS + ":"+ daten.toString() + ":";
        stringSpieler = stringSpieler + controllerS + ":"+ controller.toString()+ ":";
        stringSpieler = stringSpieler  + spielerS + ":"+ spieler.toString()+ ":";
        stringSpieler = stringSpieler + auftragsammlungS + ":"+ spieler.getAuftragssammlung().toString();
        //hinzufügen der Aufträge
        for ( int i = 0; i<daten.getRundenAnzahl();i++){ // ToDo wirklcih 10 oder nur so viele wie bereits verwendet wurden?
            stringSpieler = stringSpieler + ":" + auftragS+ ":"+ spieler.getAuftragssammlung().getAuftrag(i).toString()+ ":";

            stringSpieler = stringSpieler +armbandsS+ ":"+ spieler.getAuftragssammlung().getAuftrag(i).getArmband().toString()+ ":"+
                    controller.getArmbandAuftragI(i,spieler) + ":";
            stringSpieler = stringSpieler + forschungS + ":"+ controller.getForschungAuftragI(i,spieler) + ":";
            stringSpieler = stringSpieler + gehaeuseS + ":" + spieler.getAuftragssammlung().getAuftrag(i).getGehaeuse().toString() + ":" +
                    controller.getForschungAuftragI(i,spieler) + ":";
            stringSpieler = stringSpieler + zeitarbeiterS + ":" + controller.getZeitarbeiterAuftragI(i,spieler)+ ":";
            stringSpieler = stringSpieler + uhrwerkS + ":" + controller.getUhrwerkAuftragI(i,spieler) +":";
            stringSpieler = stringSpieler + bezahlartS + ":" + controller.getBezahlartAuftragI(i,spieler) + ":";
            //stringSpieler = stringSpieler + wasserdichtheitS + ":"+controller.getWasserdichtheit(i,spieler)+":";
            stringSpieler = stringSpieler + marketingS + ":" +controller.getMarketingAuftragI(i,spieler)+":";
            stringSpieler = stringSpieler + personalwesenS + ":" + spieler.getAuftragssammlung().getAuftrag(i).getPersonalwesen().toString()+":";

            // ToDo stringSpieler = stringSpieler + preisSimsS +":" + spieler.getAuftragssammlung().getAuftrag(i).getPreissimulation().toString();
            //ToDo stringSpieler = stringSpieler + marktSimS + ":" + spieler.getAuftragssammlung().getAuftrag(i).getMarktsim().toString()+":";
        }
                return stringSpieler ;
    }
} // Ende lokaleDaten
