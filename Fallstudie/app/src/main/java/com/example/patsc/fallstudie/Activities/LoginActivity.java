package com.example.patsc.fallstudie.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.patsc.fallstudie.R;

import static com.example.patsc.fallstudie.Activities.IntroductionActivity.Controller;

public class LoginActivity extends AppCompatActivity {

    String inputUsername;
    String inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IntroductionActivity.Controller.setActivity_Login();

        //Verknuepfen von EditText mit UI-Element per ID
        EditText login_username_input = (EditText) findViewById(R.id.login_username_input);
        EditText login_password_input = (EditText) findViewById(R.id.login_password_input);

        //speichere Eingabewerte im String
        inputUsername = login_username_input.getText().toString();
        inputPassword = login_password_input.getText().toString();
    }

    //Aufruf der Methode zum Registrieren, schickt Daten ins Backend und startet Login Activity neu
    public void register (View view)throws Exception{
        Controller.registrierung(inputUsername, inputPassword);
      //geaendet patsch 12.01 9.56
        //  Intent intent = new Intent(this, LoginActivity.class);//alt
        Intent intent = new Intent(this,PersonalwesenActivity.class); //neu
        startActivity(intent);
        finish();


    }


    //Aufruf der Methode zum Login, prüft ob Nutzername/Passwort-Kombination richtig ist und leitet dann erst weiter
   public void login (View view) throws Exception {
        if(Controller.login(inputUsername, inputPassword)) {
            Intent intent = new Intent(this, PersonalwesenActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast toast = Toast.makeText(this, "Falscher Nutzername und/oder Passwort", Toast.LENGTH_SHORT);
        }

    }
    

}
