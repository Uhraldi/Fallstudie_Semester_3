package com.example.patsc.fallstudie.Covered;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by vince on 16.01.2017.
 */

public class NetworkTest {

    public void test() {
        try {
            System.out.println("Starte");
            HttpURLConnection httpcon = (HttpURLConnection) ((new URL("http://10.0.0.2:8080/api/sendStats").openConnection()));
            httpcon.setDoOutput(true);
            httpcon.setRequestProperty("Content-Type", "application/json");
            httpcon.setRequestProperty("Accept", "application/json");
            httpcon.setRequestMethod("POST");
            System.out.println("Test 0.1");
            httpcon.connect();
            System.out.println("Test 1");
            byte[] outputBytes = "{'id' : 123, 'runde': 1}".getBytes("UTF-8");
            OutputStream os = httpcon.getOutputStream();
            os.write(outputBytes);

            InputStream is = httpcon.getInputStream();
            int res = is.read();

            System.out.println(res);

            System.out.println("Test 2");

            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}