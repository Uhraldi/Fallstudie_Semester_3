package com.example.patsc.fallstudie;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.*;
import org.apache.http.entity.StringEntity;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vince on 13/01/2017.
 */

public class Network extends Activity{

    public static String testURL = "testurl";
    Gson gson = new Gson();
    final JSONObject root = new JSONObject();

    public String toJsonOnConnect(String spielername) {
        try {
            root.put("status", "connect");
            root.put("id", spielername);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return root.toString();
    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    public void postConnect(){
        new exePostConnect().execute("");
    }

    public void


        /**
     * Sollte eine Nachricht an den Server senden, die angibt, dass der Spieler sich angemeldet hat
     */
    private class exePostConnect extends AsyncTask<String, Void, String>{
            @Override
            protected String doInBackground(String... strings) {

                InputStream inputStream = null;
                String result = "";
                try {
                    // 1. create HttpClient
                    HttpClient httpclient = new DefaultHttpClient();

                    // 2. make POST request to the given URL
                    HttpPost httpPost = new HttpPost("www.herokuapp.manufaktuhr/api/connect");

                    String json = "";

                    // 3. build jsonObject
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.accumulate("id", "testID");
                    jsonObject.accumulate("pkd", "200");

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
                        result = convertInputStreamToString(inputStream);
                    else
                        result = "Did not work!";

                } catch (Exception e) {
                    Log.d("InputStream", e.getLocalizedMessage());
                }

                // 11. return result
                //return result;
                return null;
            }
        }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            String result = "";
            while ((line = bufferedReader.readLine()) != null)
                result += line;

            inputStream.close();
            return result;
        }catch (IOException e){
            e.printStackTrace();
            return "did not work";
        }
    }

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
}
