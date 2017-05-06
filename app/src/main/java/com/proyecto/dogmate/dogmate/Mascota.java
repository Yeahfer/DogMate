package com.proyecto.dogmate.dogmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Mascota extends AppCompatActivity implements View.OnClickListener{
    Button registrar;
    int size = 1;
    private FirebaseDatabase database;
    private DatabaseReference base;
    EditText edad, esterilizado, foto, genero, nombre, raza;
    ArrayList<Integer> lista = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota);
        registrar = (Button) findViewById(R.id.button6);
        registrar.setOnClickListener(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        getSize();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button6:
                edad = (EditText) findViewById(R.id.editText10);
                esterilizado = (EditText) findViewById(R.id.editText12);
                foto = (EditText) findViewById(R.id.editText11);
                genero = (EditText) findViewById(R.id.editText13);
                nombre = (EditText) findViewById(R.id.editText5);
                raza = (EditText) findViewById(R.id.editText14);

                String txt = esterilizado.getText().toString();
                boolean est = false;
                if((txt.equals("Si")) || (txt.equals("Verdadero")) || (txt.equals("Esterilizado"))){
                    est = true;
                }

                MascotaRegistrada nueva = new MascotaRegistrada(edad.getText().toString(), est, foto.getText().toString(),
                        genero.getText().toString(), nombre.getText().toString(), raza.getText().toString());
                writeMascota(nueva, size);

                startActivity(new Intent(Mascota.this, Main2SesionActivada.class));
                break;
        }
    }

    public void writeMascota(MascotaRegistrada mascota, int n){
        database = FirebaseDatabase.getInstance();
        base = database.getReference();
        base.child("mascotas").child("M"+Integer.toString(n)).setValue(mascota);
        Toast.makeText(this,"Registro exitoso!", Toast.LENGTH_LONG).show();
    }

    public void getSize(){
        database = FirebaseDatabase.getInstance();
        base = database.getReference().child("mascotas");
        base.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                size = (int) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                failToast();
            }
        });
    }

    public void failToast(){
        Toast.makeText(this,"Error", Toast.LENGTH_LONG).show();
    }
}
