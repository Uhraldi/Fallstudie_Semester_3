package com.example.patsc.fallstudie.Network;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by vince on 18.01.2017.
 */

public class Funkturm {

    private Gson gson = new Gson();


    /**
     * ----------------------Constructor----------------------
     */
    public Funkturm(){

    }

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
        httpcon.disconnect();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public Data[] getData(){

        //Verbindung mit Server aufbauen
        try {
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL("http://10.0.0.2:8080/api/sendStats").openConnection()));
            httpcon.setDoOutput(false);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("GET");
            httpcon.connect();

            //Input einlesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = "";
            int ctr = 0;        //Counter für Menge der Objekte
            while(reader.readLine()!=null){     //Alle lines auslesen
                ctr++;
                res = res + ";" + reader.readLine();
            }

            //Input spalten, um die Daten auf Objekte zu verteilen
            String[] resArray = res.split(";");

            //Data[] initialisieren
            Data[] returnedData = null;

            //Input in Data-objekt transformieren
            for(int i=0;i<ctr;i++) {
                try {
                    returnedData[i] = gson.fromJson(resArray[i], Data.class);
                }catch (NullPointerException e){
                    break;
                }
            }

            //Inputstream schließen, Verbindung trennen
            reader.close();
            httpcon.disconnect();

            //Dataobejects zurückgeben
            return returnedData;
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
