package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.patsc.fallstudie.R;

import static com.example.patsc.fallstudie.Activities.IntroductionActivity.model;

public class LoginActivity extends AppCompatActivity {

    String inputUsername;
    String inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IntroductionActivity.model.setActivity_Login();                        // TODO: überall setActivity implementieren

        //Verknuepfen von EditText mit UI-Element per ID
        EditText login_username_input = (EditText) findViewById(R.id.login_username_input);
        EditText login_password_input = (EditText) findViewById(R.id.login_password_input);

        //speichere Eingabewerte im String
        String inputUsername = login_username_input.getText().toString();
        String inputPassword = login_password_input.getText().toString();
    }

    //Methode fuer den weiter_button um zur nächsten Activity/Screen zu navigieren
    public void goToNextActivity (View view) {

        //Methodenaufrufe von Model zur Registrierung und Login
       model.registrierung(inputUsername, inputPassword);           //TODO: Greifen die wirklich auf die Strings in der onCreate zu?
       model.login(inputUsername, inputPassword);

        Intent intent = new Intent(this, E1_DesignerActivity.class);
        startActivity(intent);
        finish();
    }

}
