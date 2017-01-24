package com.example.patsc.fallstudie.Network;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Klasse zum Senden von Daten
 * @author Vincent Schmalor
 * Created by vince on 18.01.2017.
 */

//// TODO: 24.01.2017 #Vincent Dokument  erstellen, in das man imaginäre Daten für  den Server eintragen kann. 
public class Funkturm {

    private Gson gson = new Gson();


    /**
     * ----------------------Constructor----------------------
     */
    public Funkturm(){

    }

    /**
     * 1. Erzeuge eine Klasse vom Typ Data und gebe die richtigen Werte des Spielers mit
     * 2. führe diese MEthode aus
     * @param data Objekt der Klasse Data mit allen Koeffizienten, die im Konstruktor festgelegt sind
     */
    public void sendData(Data data){
        //Object in JSON transformieren
        String json = gson.toJson(data);

        //Verbindung mit Server aufbauen
        try{
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL("http://10.0.0.2:8080/api/sendStats").openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("POST");
            httpcon.connect();

            //Sendung festlegen
            byte[] outputBytes = json.getBytes("UTF-8");
            OutputStream os = httpcon.getOutputStream();

            //Senden
            os.write(outputBytes);

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
    public Data[] getData( int runde){

        //Verbindung mit Server aufbauen
        try {
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL("http://10.0.0.2:8080/api/getStats/"+runde).openConnection()));
            httpcon.setDoOutput(false);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("GET");
            httpcon.connect();

            //Input einlesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = reader.readLine();

            //Gelesenen Input in Objekte verpacken
            Data[] dataArray = gson.fromJson(res, Data[].class);


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
