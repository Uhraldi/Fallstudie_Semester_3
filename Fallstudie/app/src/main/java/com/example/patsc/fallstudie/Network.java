package com.example.patsc.fallstudie;


import com.google.gson.Gson;

/**
 * Created by vince on 13/01/2017.
 */

public class Network {
    Object o = new Object();
    Gson gson = new Gson();
    String json = gson.toJson(o);
}
