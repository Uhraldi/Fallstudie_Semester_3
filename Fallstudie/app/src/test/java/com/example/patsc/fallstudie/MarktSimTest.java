package com.example.patsc.fallstudie;

import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 * Created by julian on 11.01.2017.
 */

public class MarktSimTest {
    double[] Testpkz = {13.4, 17.8,34.5,76.7};

    Marktsim TestSim = null;

    public MarktSimTest() throws Exception {
    }

    @Test
    public void ConstructorTest()throws Exception{
            TestSim = new Marktsim(Testpkz);

    }

}
