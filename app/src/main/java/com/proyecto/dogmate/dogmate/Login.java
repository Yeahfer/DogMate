package com.proyecto.dogmate.dogmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button butonRegister;
    Button butonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        butonRegister = (Button) findViewById(R.id.button2);
        butonRegister.setOnClickListener(this);

        butonLogin = (Button) findViewById(R.id.button3);
        butonLogin.setOnClickListener(this);
    }

    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button2:
                startActivity(new Intent(Login.this, Register.class));
                break;
            case R.id.button3:
                startActivity(new Intent(Login.this, IniciarSesion.class));
                break;
        }
    }
}
