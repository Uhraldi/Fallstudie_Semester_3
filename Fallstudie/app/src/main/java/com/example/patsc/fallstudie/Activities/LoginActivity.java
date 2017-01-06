package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.patsc.fallstudie.R;

public class LoginActivity extends AppCompatActivity {

    String inputUsername;
    String inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IntroductionActivity.model.setActivity_Login();

        //Verknuepfen von EditText mit UI-Element per ID
        EditText login_username_input = (EditText) findViewById(R.id.login_username_input);
        EditText login_password_input = (EditText) findViewById(R.id.login_password_input);

        //speichere Eingabewerte im String
        inputUsername = login_username_input.getText().toString();
        inputPassword = login_password_input.getText().toString();
    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {

        //Methodenaufrufe von Model zur Registrierung und Login
        IntroductionActivity.model.registrierung(inputUsername, inputPassword);
        IntroductionActivity.model.login(inputUsername, inputPassword);

        Intent intent = new Intent(this, E1_DesignerActivity.class);
        startActivity(intent);
        finish();
    }

}
