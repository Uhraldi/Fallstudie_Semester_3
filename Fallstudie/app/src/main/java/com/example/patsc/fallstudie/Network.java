package com.example.patsc.fallstudie;


import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by vince on 13/01/2017.
 */

public class Network extends Activity {

    /**
     * -----------------------------SetUp the shit-------------------------
     */
    public static String testURL = "testurl";
    Gson gson = new Gson();


    /**
     * ------------------Allgemeine Methoden, die innerhalb der Klasse verwendet werden-------------------
     */
    /**
     * Rpüft, ob das Gerät mit dem Internet verbunden ist
     * @return true wenn verbunden
     */
    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    /**
     * Konvertiert InputStream-Daten in Json
     * @param inputStream Inputstram vom kontaktierten Server
     * @return jsonObject
     */
    private JSONObject getJsonObject(InputStream inputStream){

        //Create input stream
        InputStream inputStreamObject = inputStream;

        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStreamObject, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);

            JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());

            //returns the json object
            return jsonObject;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //if something went wrong, return null
        return null;
    }

    /**
     * -------------------------Netzwerkinteraktionen--------------------------
     */

    /**
     * Sollte eine Nachricht an den Server senden, die angibt, dass der Spieler sich angemeldet hat
     */

    /**
     * Hintergrundprozess, der ein JSON an den Server sendet. Der Server speichert die Daten entsprechend
     * @return
     */
    protected JSONObject exeGetReady(, int runde) {
        InputStream inputStream = null;
        JSONObject result = null;
        try {
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost("www.herokuapp.manufaktuhr/api/getStats");

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("runde", runde);

            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // ** Alternative way to convert Person object to JSON string usin Jackson Lib
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person);

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            //httpPost.setHeader("Accept", "application/json");
            //httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if (inputStream != null)
                result = getJsonObject(inputStream);
            else
                result = new JSONObject();
            result.accumulate("didnt", "work");

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        // 11. return result
        return result;
    }

    /**
     * Hintergrundprozess, der ein JSON an den Server sendet. Der Server speichert die Daten entsprechend
     * @return
     */
    protected void exePostReady(String id, int runde, double pkz, int menge, double vkp, double bonus) {
        InputStream inputStream = null;
        JSONObject result = null;
        try {
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost("www.herokuapp.manufaktuhr/api/sendStats");

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("id", id);
            jsonObject.accumulate("runde", runde);
            jsonObject.accumulate("pkz", pkz);
            jsonObject.accumulate("menge", menge);
            jsonObject.accumulate("vkp", vkp);
            jsonObject.accumulate("bonus", bonus);
            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // ** Alternative way to convert Person object to JSON string usin Jackson Lib
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person);

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            //httpPost.setHeader("Accept", "application/json");
            //httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
    }

    /**
     *
     * @param id
     * @param runde
     * @param gewinn
     * @param ma
     */
    protected void exePostEnde(String id, int runde, double gewinn, double ma) {
        InputStream inputStream = null;
        JSONObject result = null;
        try {
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost("www.herokuapp.manufaktuhr/api/sendEnd");

            String json = "";

            // 3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("id", id);
            jsonObject.accumulate("runde", runde);
            jsonObject.accumulate("gewinn", gewinn);
            jsonObject.accumulate("marktanteil", ma);
            // 4. convert JSONObject to JSON to String
            json = jsonObject.toString();

            // ** Alternative way to convert Person object to JSON string usin Jackson Lib
            // ObjectMapper mapper = new ObjectMapper();
            // json = mapper.writeValueAsString(person);

            // 5. set json to StringEntity
            StringEntity se = new StringEntity(json);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            //httpPost.setHeader("Accept", "application/json");
            //httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
    }
}
