package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.patsc.fallstudie.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //Verknuepfen von EditText mit UI-Element per ID
        EditText login_username_input = (EditText) findViewById(R.id.login_username_input);
        EditText login_password_input = (EditText) findViewById(R.id.login_password_input);

        //speichere Eingabewerte im String
        String inputUsername = login_username_input.getText().toString();
        String inputPassword = login_password_input.getText().toString();
    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {
        Intent intent = new Intent(this, E1_DesignerActivity.class);
        finish();
        startActivity(intent);
    }

}