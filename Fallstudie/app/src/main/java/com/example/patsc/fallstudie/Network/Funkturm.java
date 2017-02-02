package com.example.patsc.fallstudie.Network;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Klasse zum Senden von Daten
 *
 * @author Vincent Schmalor
 *         Created by vince on 18.01.2017.
 */


public class Funkturm {

    private Gson gson = new Gson();


    //----------------------Constructor----------------------
    public Funkturm() {

    }

    private final String domain = "https://manufaktuhr.herokuapp.com/";
    private final String spielerPost = "spielerDaten/postNew";
    private final String spielerUpdate = "spielerDaten/updateExisting";
    private final String spielerGet = "spielerDaten/load";
    private final String rundePost = "rundenDaten/post";
    private final String rundeGet = "rundenDaten/get/";


    //-------------------Rundenmethoden-------------------

    /**
     * Rufe diese Methode auf, um die Rundenergebnisse zu pushen
     *
     * @param rundenErgebnisWrapper Wrapper mit allen Spielerdaten (siehe Doc. RundenergebnisWrapper)
     */
    public boolean sendeRunde(final RundenErgebnisWrapper rundenErgebnisWrapper) {
        boolean objective = false;

        //Object in JSON transformieren

        String json = gson.toJson(rundenErgebnisWrapper);

        //Verbindung mit Server aufbauen
        try {
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL(domain + rundePost).openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("POST");
            httpcon.connect();

            //Senden
            OutputStreamWriter os = new OutputStreamWriter(httpcon.getOutputStream());
            os.write(json);
            os.flush();

            //Input einlesen
            BufferedReader is = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = is.readLine();

            //Gelesenen Input verarbeiten
            if (res.equals("accepted")) {
                objective = true;
            }

            //Abschlussarbeiten
            is.close();
            os.close();
            httpcon.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objective;

    }




    /**
     * [beachte return doc] Rufe diese Methode auf, um die Daten der aktuellen Runde zu erhalten
     *
     * @param runde aktuelle Rundenzahl
     * @return Alle gespeicherten Spielstände der Runde
     * ACHTUNG! Bei fehlerhafter Verarbeitung wird ein RundenErgebnisWrapper an der Stelle [0] mit der ID "failed" erstellt
     * Es sollte also nach Aufruf dieser Methode auf die Identität der ID mit "failed geprüft werden.
     */
    public RundenErgebnisWrapper[] empfangeRunde(int runde) {

        //Verbindung mit Server aufbauen
        try {
            int zahl = runde +1;
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL(domain + rundeGet + zahl).openConnection()));
            httpcon.setDoOutput(false);
            //httpcon.setRequestProperty("Content-Type", "application/json"); Löschen, wenn es immernoch funktioniert
            //httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("GET");
            httpcon.connect();

            //Input einlesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = reader.readLine();

            //Gelesenen Input in Objekte verpacken
            RundenErgebnisWrapper[] data = gson.fromJson(res, RundenErgebnisWrapper[].class);

            //Inputstream schließen, Verbindung trennen
            reader.close();
            httpcon.disconnect();

            //Dataobjekte returnen
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new RundenErgebnisWrapper[]{new RundenErgebnisWrapper()};
        }
    }

    //-------------------Spielermethoden-------------------

    /**
     * Methode zum registrieren eines spielers
     *
     * @param id       Name des Spielers
     * @param passwort Passwort des Spielers
     * @return Gibt an, ob das speichern erfolgreich war, oder nicht
     */
    public boolean registriereSpieler(String id, String passwort) {

        SpielerDatenWrapper wrapper = new SpielerDatenWrapper(id, passwort);
        String json = gson.toJson(wrapper);

        //Verbindung mit Server aufbauen
        try {
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL(domain + spielerPost).openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("POST");
            httpcon.connect();

            //Senden
            OutputStreamWriter os = new OutputStreamWriter(httpcon.getOutputStream());
            os.write(json);
            os.flush();

            //Input einlesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = reader.readLine();
            boolean objective = false;
            if (res.equals("accepted")) {
                objective = true;
            }

            //Inputstream schließen, Verbindung trennen
            reader.close();
            httpcon.disconnect();

            //Dataobjekte returnen
            return objective;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Methode zum Updaten eines Spieler-Spielstandes
     *
     * @param spielerDatenWrapper Wrapper mit allen nötigen Spielerinformationen, die gespeichert werden sollen
     */
    public boolean updateSpieler(SpielerDatenWrapper spielerDatenWrapper) {
        //Object in JSON transformieren
        String json = gson.toJson(spielerDatenWrapper);

        //Verbindung mit Server aufbauen
        try {
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL(domain + spielerUpdate).openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setConnectTimeout(10000);
            httpcon.setReadTimeout(10000);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("POST");
            httpcon.connect();

            //Senden
            OutputStreamWriter os = new OutputStreamWriter(httpcon.getOutputStream());
            os.write(json);
            os.flush();

            //Outputstream schließen, Verbindung trennen
            os.close();

            //Input einlesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = reader.readLine();
            boolean objective = false;
            if (res.equals("accepted")) {
                objective = true;
            }

            //Inputstream schließen, Verbindung trennen
            reader.close();
            httpcon.disconnect();

            //Dataobjekte returnen
            return objective;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * [beachte return doc] Methode zum Laden einer Spielerdatei
     *
     * @param id       Name des gewünschten Spielers
     * @param passwort Passwort des gewünschten Spielers
     * @return Spielerdaten
     * ACHTUNG! Wird der Spieler nicht gefunden, wird ein SpielerWrapper mit der ID und Passwort "failed" erzeugt.
     * nach dieser Methode sollte also auf die Identität der ID oder des Passworts mit "failed" geprüft werden.
     * Wird die Sendung nicht richtig ausgeführt, bleiben alle Werte unberührt. Eine Prüfung der Rundenzahl
     * auf -1 sollte durchgeführt werden.
     */
    public SpielerDatenWrapper empfangeSpieler(String id, String passwort) {
        SpielerDatenWrapper wrapper = new SpielerDatenWrapper(id, passwort);
        String json = gson.toJson(wrapper);

        //Verbindung mit Server aufbauen
        try {
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL(domain + spielerGet).openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("POST");
            httpcon.connect();

            //Senden
            OutputStreamWriter os = new OutputStreamWriter(httpcon.getOutputStream());
            os.write(json);
            os.flush();

            //Input einlesen
            BufferedReader is = new BufferedReader(new InputStreamReader(httpcon.getInputStream()));
            String res = is.readLine();

            //Gelesenen Input in Objekt verpacken
            wrapper = gson.fromJson(res, SpielerDatenWrapper.class);

            //Inputstream schließen, Verbindung trennen
            is.close();
            os.close();
            httpcon.disconnect();

            //Dataobjekte returnen

        } catch (Exception e) {
            e.printStackTrace();
        }
        return wrapper;
    }

    public void unidleServer(){
        try {
            HttpsURLConnection httpcon = (HttpsURLConnection) ((new URL("https://manufaktuhr.herokuapp.com").openConnection()));
            httpcon.setDoOutput(false);
            httpcon.setRequestMethod("GET");
            httpcon.connect();
            httpcon.getOutputStream().write("Test".getBytes());
            httpcon.getOutputStream().flush();
            httpcon.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}