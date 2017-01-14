package com.example.patsc.fallstudie;

import android.os.AsyncTask;
import com.google.gson.Gson;

import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vince on 13/01/2017.
 */

public class Network extends AsyncTask{

    public static String testURL = "testurl";
    Gson gson = new Gson();
    final JSONObject root = new JSONObject();

    public String toJsonOnConnect(String spielername){
        try {
            root.put("status", "connect");
            root.put("id", spielername);
        }catch(Exception e){
            e.printStackTrace();
        }
        return root.toString();
    }

    public void sendDataToServer(String toSend){
         final String json = toSend;

        new AsyncTask<Void, Void, String>(){

            @Override
            protected String doInBackground(Void... voids) {
                return getServerResponse(json);
            }

            @Override
            protected void onPostExecute(String s) {
                return result;
            }
        }.execute();
    }

    private String getServerResponse(String json) {
        try {
            URL url = new URL(Network.testURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}

