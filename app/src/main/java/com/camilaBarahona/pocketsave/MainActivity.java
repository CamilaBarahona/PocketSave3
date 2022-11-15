package com.camilaBarahona.pocketsave;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.camilaBarahona.pocketsave.Sensores.Sensores;
import com.camilaBarahona.pocketsave.db.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button btn_registrarse, btn_iniciarSesion, btn_sensores, btn_crearDb;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_iniciarSesion = (Button) findViewById(R.id.btn_iniciarSesion);
        btn_registrarse = (Button) findViewById(R.id.btn_registrarse);
        btn_sensores = (Button) findViewById(R.id.btn_sensores);
        btn_crearDb = (Button) findViewById(R.id.btn_crearDB);

        btn_iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        MainActivity.this, Login.class
                ));
            }
        });

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        MainActivity.this, Register.class
                ));
            }
        });
        btn_sensores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Sensores.class));
            }
        });
        btn_crearDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {
                    Toast.makeText(MainActivity.this, "BASE DE DATOS CREADA", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "ERROR AL CREAR BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}