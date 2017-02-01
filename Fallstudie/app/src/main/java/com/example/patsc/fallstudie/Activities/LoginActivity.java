package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patsc.fallstudie.Covered.Controller;
import com.example.patsc.fallstudie.R;

public class LoginActivity extends AppCompatActivity {

    String inputUsername;
    String inputPassword;
    Controller c;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IntroductionActivity.Controller.setActivity_Login();
        c = IntroductionActivity.Controller;
        c.setActivity_Login();


    }


    /**
     * Aufruf der Methode zum Registrieren, schickt Daten ins Backend und startet Login Activity neu
     * @param view
     * @throws Exception
     */
    public void register (View view){

        //speichere Eingabewerte im String
        EditText login_username_input = (EditText) findViewById(R.id.login_username_input);
        EditText login_password_input = (EditText) findViewById(R.id.login_password_input);
        inputUsername = login_username_input.getText().toString();
        inputPassword = login_password_input.getText().toString();

        if (c.registrierung(inputUsername, inputPassword)) {
            Intent intent = new Intent(this, PersonalwesenActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast toast = Toast.makeText(this, "Nutzername bereits vergeben", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    /**
     * Aufruf der Methode zum Login, prüft ob Nutzername/Passwort-Kombination richtig ist und leitet dann erst weiter
     * @param view
     * @throws Exception
     */
   public void login (View view) throws Exception {
        if(c.login(inputUsername, inputPassword)) {
            Intent intent = new Intent(this, PersonalwesenActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast toast = Toast.makeText(this, "Falscher Nutzername und/oder Passwort", Toast.LENGTH_SHORT);
        }

    }

}
