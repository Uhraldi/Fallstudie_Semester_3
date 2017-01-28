package com.example.patsc.fallstudie.Network;

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

    /**
     * 1. Erzeuge eine Klasse vom Typ Data und gebe die richtigen Werte des Spielers mit
     * 2. führe diese MEthode aus
     * @param data Objekt der Klasse Data mit allen Koeffizienten, die im Konstruktor festgelegt sind
     */
    public void sendData(Data data){
        //Object in JSON transformieren
        String json = gson.toJson(data);

        System.out.println(json);

        //Verbindung mit Server aufbauen
        try{
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL("https://manufaktuhr.herokuapp.com/rundendaten/post").openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setDoInput(false);
            httpcon.setUseCaches(false);
            httpcon.setConnectTimeout(10000);
            httpcon.setReadTimeout(10000);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("POST");
            httpcon.connect();

            //Sendung festlegen
            byte[] outputBytes = json.getBytes("UTF-8");
            OutputStreamWriter os = new OutputStreamWriter(httpcon.getOutputStream());

            //JSONObject jsonObject = new JSONObject();
            //jsonObject.put("id",123);

            //Senden
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
    public Data[] getData( int runde){

        //Verbindung mit Server aufbauen
        try {
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL("https://manufaktuhr.herokuapp.com/rundendaten/get/"+runde).openConnection()));
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

            System.out.println(dataArray[0].toString());

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
