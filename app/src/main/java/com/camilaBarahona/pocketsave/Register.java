package com.camilaBarahona.pocketsave;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.camilaBarahona.pocketsave.db.DbUsuarios;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private Button btn_validar;
    private EditText ed_rut, ed_nombre, ed_apelPat, ed_apelMat, ed_direccion, ed_fechaNac, ed_email, ed_pass;
    private RadioGroup rb_genero;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_validar = (Button) findViewById(R.id.btn_validar);

        ed_rut = (EditText) findViewById(R.id.ed_rut);
        ed_nombre = (EditText) findViewById(R.id.ed_nombre);
        ed_apelPat = (EditText) findViewById(R.id.ed_apellido_paterno);
        ed_apelMat = (EditText) findViewById(R.id.ed_apellido_materno);
        ed_direccion = (EditText) findViewById(R.id.ed_direccion);
        ed_fechaNac = (EditText) findViewById(R.id.ed_fechaNac);
        ed_email = (EditText) findViewById(R.id.ed_email);
        ed_pass = (EditText) findViewById(R.id.ed_password);

        rb_genero = (RadioGroup) findViewById(R.id.rgGenero);

        btn_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUsuarios dbUsuarios = new DbUsuarios(Register.this);
                long id = dbUsuarios.insertarUsuario(ed_rut.getText().toString(),
                       ed_nombre.getText().toString(),ed_apelPat.getText().toString(),
                        ed_apelMat.getText().toString(),ed_fechaNac.getText().toString(),
                        ed_direccion.getText().toString(), ed_email.getText().toString(),
                        ed_pass.getText().toString());

                if (id > 0) {
                    Toast.makeText(Register.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(Register.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private  void limpiar(){
        ed_rut.setText("");
        ed_nombre.setText("");
        ed_apelPat.setText("");
        ed_apelMat.setText("");
        ed_fechaNac.setText("");
        ed_direccion.setText("");
        ed_email.setText("");
        ed_pass.setText("");
    }

}