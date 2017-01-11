package com.example.patsc.fallstudie.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.patsc.fallstudie.R;

public class BestenlisteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestenliste);
        IntroductionActivity.Controller.setActivity_Bestenliste();
    }
}
