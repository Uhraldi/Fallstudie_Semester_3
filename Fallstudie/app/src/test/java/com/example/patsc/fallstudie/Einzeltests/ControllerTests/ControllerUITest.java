package com.example.patsc.fallstudie.Einzeltests.ControllerTests;

import com.example.patsc.fallstudie.Covered.Controller.Controller;

import org.junit.Test;

/**
 * Created by julian on 13.02.2017.
 */

public class ControllerUITest {
    Controller C = new Controller();


    @Test
    public void getGesamtkostenTest(){
    C.getGesamtkosten();
    }
}
