package com.example.patsc.fallstudie.Network;

import com.example.patsc.fallstudie.Covered.Runde;
import com.example.patsc.fallstudie.Covered.Spieler;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Klasse zum Senden von Daten
 * @author Vincent Schmalor
 * Created by vince on 18.01.2017.
 */

public class Funkturm {

    private Gson gson = new Gson();


    /**
     * ----------------------Constructor----------------------
     */
    public Funkturm(){

    }

    private final String spielerPost = "spielerDaten/postNew";
    private final String spielerUpdate = "spielerDaten/updateExisting";
    private final String spielerGet = "spielerDaten/getExisting";
    private final String rundePost = "rundenDaten/post";
    private final String rundeGet = "rundenDaten/get/";


    /**
     * Rufe diese Methode auf, um die Rundenergebnisse zu pushen
     * @param rundenErgebnisWrapper
     */
    public void sendeRunde(RundenErgebnisWrapper rundenErgebnisWrapper){
        sendeDaten(rundenErgebnisWrapper, rundePost);
    }

    public  void registriereSpieler(SpielerDatenWrapper spielerDatenWrapper){
        sendeDaten(spielerDatenWrapper, spielerPost);
    }

    public void updateSpieler(SpielerDatenWrapper spielerDatenWrapper){
        sendeDaten(spielerDatenWrapper, spielerUpdate);
    }


    /**
     * @param rundenErgebnisWrapper Objekt der Klasse RundenErgebnisWrapper mit allen Koeffizienten, die im Konstruktor festgelegt sind
     * @param path Pfad des Servers, der angesprochen werden soll
     *             Valide Pfade sind
     *              rundenDaten/post
     *              spielerDaten/postNew
     *              spielerDaten/updateExisting
     */
    private void sendeDaten(Object rundenErgebnisWrapper, String path){
        //Object in JSON transformieren
        String json = gson.toJson(rundenErgebnisWrapper);

        System.out.println(json);

        //Verbindung mit Server aufbauen
        try{
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL("https://manufaktuhr.herokuapp.com/"+path).openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setDoInput(false);
            httpcon.setUseCaches(false);
            httpcon.setConnectTimeout(10000);
            httpcon.setReadTimeout(10000);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("POST");
            httpcon.connect();

            //Senden
            byte[] outputBytes = json.getBytes("UTF-8");
            OutputStreamWriter os = new OutputStreamWriter(httpcon.getOutputStream());
            os.write(json);
            os.flush();
            //Outputstream schließen, Verbindung trennen
            os.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Rufe diese Methode auf, um die Daten der aktuellen Runde zu erhalten
     * @param runde aktuelle Rundentzahl
     * @return Alle gespeicherten Spielstände der Runde
     */
    public RundenErgebnisWrapper[] empfangeRunde(int runde){

        //Verbindung mit Server aufbauen
        try {
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL("https://manufaktuhr.herokuapp.com/rundenDaten/get/"+runde).openConnection()));
            httpcon.setDoOutput(false);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("GET");
            httpcon.connect();

            //Input einlesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = reader.readLine();

            //Gelesenen Input in Objekte verpacken
            RundenErgebnisWrapper[] dataArray = gson.fromJson(res, RundenErgebnisWrapper[].class);

            //Inputstream schließen, Verbindung trennen
            reader.close();
            httpcon.disconnect();

            //Dataobjekte returnen
            return dataArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SpielerDatenWrapper empfangeSpieler(String id, String passwort) {

        //Verbindung mit Server aufbauen
        try {
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL("https://manufaktuhr.herokuapp.com/" + id + "/" + passwort).openConnection()));
            httpcon.setDoOutput(false);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("GET");
            httpcon.connect();

            //Input einlesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = reader.readLine();

            //Gelesenen Input in Objekte verpacken
            SpielerDatenWrapper dataArray = gson.fromJson(res, SpielerDatenWrapper.class);

            //Inputstream schließen, Verbindung trennen
            reader.close();
            httpcon.disconnect();

            //Dataobjekte returnen
            return dataArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


/** Nur leicht veränderter Code zur Vorlage für weitere Connection-methoden
 public void senden () {
 try {
 HttpURLConnection httpcon = (HttpURLConnection) ((new URL("http://10.0.0.2:8080/api/sendStats").openConnection()));
 httpcon.setDoOutput(true);
 httpcon.setRequestProperty("Content-Type", "application/json");
 httpcon.setRequestProperty("Accept", "application/json");
 httpcon.setRequestMethod("POST");

 httpcon.connect();

 byte[] outputBytes = "{'id' : 123, 'runde': 1}".getBytes("UTF-8");
 OutputStream os = httpcon.getOutputStream();
 os.write(outputBytes);

 InputStream is = httpcon.getInputStream();
 int res = is.read();

 System.out.println(res);

 os.close();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
 */
}
