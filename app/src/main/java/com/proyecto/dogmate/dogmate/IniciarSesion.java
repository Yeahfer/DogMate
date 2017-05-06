package com.proyecto.dogmate.dogmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class IniciarSesion extends AppCompatActivity implements View.OnClickListener {

    Button butonIniciaSesion;
    boolean correoFlag = false;
    boolean contraFlag = false;
    private FirebaseDatabase database;
    private DatabaseReference base;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        butonIniciaSesion = (Button) findViewById(R.id.button5);
        butonIniciaSesion.setOnClickListener(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    public void onClick(View v) {
        verificarUsuario(v);

    }

    public void verificarUsuario(final View v){

        EditText correo = (EditText) findViewById(R.id.editText3);
        EditText contra = (EditText) findViewById(R.id.editText4);
        final String correE = correo.getText().toString();
        final  String contraE = contra.getText().toString();
        Log.d("FERNANDO", "DENTRO DEL METODO");

        database = FirebaseDatabase.getInstance();
        base = database.getReference().child("usuarios");
        base.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("FERNANDO", "Dentro del for");
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
                    String correoBase = singleSnapshot.child("correo").getValue().toString();
                    String contraBase = "QWERTY";
                    if (singleSnapshot.hasChild("password")){
                        contraBase = singleSnapshot.child("password").getValue().toString();
                    }

                    Log.d("FERNANDO", correoBase + " : " + contraBase);
                    //comprueba se los correos son iguales
                    if (correE.equals(correoBase) && contraE.equals(contraBase)){
                        Log.d("FERNANDO", "Dnhorabuena coincide: " + correoBase);
                        Log.d("FERNANDO", "Dnhorabuena coincide: " + contraBase);
                        correoFlag = true;
                        contraFlag = true;
                        switch (v.getId()){
                            case R.id.button5:
                                startActivity(new Intent(IniciarSesion.this, Main2SesionActivada.class));
                                break;
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                personalToast("Error");
            }
        });
        if(correoFlag && contraFlag){

        }else if(correoFlag && !contraFlag){
            personalToast("Contraseña incorrecta");
        }else {
            personalToast("Usuario o contraseña incorrectos");
        }
    }

    public void personalToast(String mensaje){
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
    }
}
