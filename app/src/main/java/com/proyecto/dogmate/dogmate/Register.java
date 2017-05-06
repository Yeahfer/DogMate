package com.proyecto.dogmate.dogmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import java.util.ArrayList;

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button butonRegistrarse;
    EditText nombre, apellidos, numero, correo, fecha, password;
    int size = 1;
    private FirebaseDatabase database;
    private DatabaseReference base;
    ArrayList<Integer> lista = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        butonRegistrarse = (Button) findViewById(R.id.button4);
        butonRegistrarse.setOnClickListener(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        getSize();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button4:
                nombre = (EditText) findViewById(R.id.editText);
                apellidos = (EditText) findViewById(R.id.editText2);
                numero = (EditText) findViewById(R.id.editText6);
                correo = (EditText) findViewById(R.id.editText7);
                fecha = (EditText) findViewById(R.id.editText8);
                password = (EditText) findViewById(R.id.editText9);
                long num = Long.parseLong(numero.getText().toString());
                Usuario usuario = new Usuario(apellidos.getText().toString(), num, correo.getText().toString(),
                        fecha.getText().toString(), nombre.getText().toString(), password.getText().toString());
                writeUsuario(usuario, size);
                startActivity(new Intent(Register.this, IniciarSesion.class));
                break;
        }
    }

    public void writeUsuario(Usuario usuario, int n){
        database = FirebaseDatabase.getInstance();
        base = database.getReference();
        base.child("usuarios").child("U"+Integer.toString(n)).setValue(usuario);
        Toast.makeText(this,"Registro exitoso!", Toast.LENGTH_LONG).show();
    }

    public void getSize(){
        final int num = 1;
        database = FirebaseDatabase.getInstance();
        base = database.getReference().child("usuarios");
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
