package com.example.patsc.fallstudie;


import android.provider.ContactsContract;

import com.example.patsc.fallstudie.Bestandteile.Uhrwerk;
import com.google.gson.Gson;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by vince on 13/01/2017.
 */

public class Network {

    Uhrwerk u = new Uhrwerk();
    Gson gson = new Gson();

    public void

    /**
     * Wird verwendet, um die Daten zu versenden
     */
    private void sendConnect(){
        URL url = null;
        HttpURLConnection client = null;
        OutputStream outputPost = null;
        try {
            url = new URL("localhost:8080/api/connect");
            client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("POST");
            client.setDoOutput(true);
            outputPost = new BufferedOutputStream(client.getOutputStream());
            String a = "";
            outputPost.write(a.getBytes());
            outputPost.flush();
            outputPost.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (client != null){
                client.disconnect();
            }
        }
    }

    public void sendReady(Daten daten){
        URL url = null;
        HttpURLConnection client = null;
        OutputStream outputPost = null;
        try {
            url = new URL("localhost:8080/api/ready");
            client = (HttpURLConnection) url.openConnection();
            client.setRequestMethod("POST");
            client.setDoOutput(true);
            outputPost = new BufferedOutputStream(client.getOutputStream());
            String a = gson.toJson(daten);
            outputPost.write(a.getBytes());
            outputPost.flush();
            outputPost.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (client != null){
                client.disconnect();
            }
        }
    }

    public void sendReadyReq(){
        try {

            URL url = new URL("http://localhost:8080/api/ready");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            /*
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            */

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            Daten output = null;
            while ((output = gson.fromJson(br.readLine())) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}

