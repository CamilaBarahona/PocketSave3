package com.camilaBarahona.pocketsave;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.camilaBarahona.pocketsave.menuHome.HomeMenu;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;

public class Register extends AppCompatActivity {

    private EditText ed_nombre, ed_apellidos, ed_email, ed_pass;
    Spinner listaPaises;
    private FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    String nameUser = "";
    String lastNameUser = "";
    String emailUser = "";
    String countryUser = "";
    String passwordUser = "";
    String[] datosPaises = {"Seleccione un país de Latinoamérica", "Antigua y Barbuda", "Argentina", "Bahamas", "Barbados", "Belice",
            "Bolivia", "Brasil", "Colombia", "Costa Rica", "Cuba", "Chile", "Dominica", "Ecuador", "El Salvador", "Granada", "Guatemala", "Guyana", "Haití", "Honduras", "Jamaica",
            "México", "Nicaragua", "Panamá", "Paraguay", "Perú", "República Dominicana", "San Cristóbal y Nieves", "San Vicente y las Granadinas", "Santa Lucía"
            , "Surinam", "Trinidad y Tobago", "Uruguay", "Venezuela"};
    ArrayAdapter arrayAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("Registro");
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Register.this);

        // Inicialización de los botones
        Button btn_validar = findViewById(R.id.btn_validar);
        // Inicialización de los edit Text.
        ed_nombre = findViewById(R.id.ed_nombre);
        ed_apellidos = findViewById(R.id.ed_apellidos);
        ed_email = findViewById(R.id.ed_email);
        ed_pass =  findViewById(R.id.ed_contrasena);

        // Inicialización del Spinner.
        listaPaises = findViewById(R.id.listaPaises);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, datosPaises);
        listaPaises.setAdapter(arrayAdapter);

        // Método para poder seleccionar una opción.
        listaPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 12:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 14:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 15:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 16:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 17:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 18:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 19:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 20:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 21:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 22:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 23:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 24:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 25:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 26:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 27:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 28:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 29:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 30:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 31:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 32:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 33:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 34:
                        Toast.makeText(Register.this, datosPaises[position], Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_validar.setOnClickListener(v -> ValidarDatos());
    }

    private void ValidarDatos() {
        nameUser = ed_nombre.getText().toString();
        lastNameUser = ed_apellidos.getText().toString();
        emailUser = ed_email.getText().toString().trim();
        countryUser = listaPaises.getSelectedItem().toString();
        passwordUser = ed_pass.getText().toString().trim();
        if (TextUtils.isEmpty(nameUser)) {
            Toast.makeText(this, "Ingrese el nombre", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(lastNameUser)) {
            Toast.makeText(this, "Ingrese los apellidos", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailUser).matches()) {
            Toast.makeText(this, "Ingrese correo", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(passwordUser)) {
            Toast.makeText(this, "Ingrese contraseña", Toast.LENGTH_SHORT).show();
        } else {
            CrearCuenta();
        }
    }

    private void CrearCuenta() {
        progressDialog.setMessage("Creando su cuenta....");
        progressDialog.show();
        // Crear un usuario en Firebase
        mAuth.createUserWithEmailAndPassword(emailUser, passwordUser).addOnSuccessListener(authResult -> GuardarInformacion()).addOnFailureListener(e -> {
            progressDialog.dismiss();
            Toast.makeText(Register.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        });
    }

    private void GuardarInformacion() {
        progressDialog.setMessage("Guardando información");
        progressDialog.dismiss();

        //Obtener la identificación del usuario actual
        String uid = mAuth.getUid();
        HashMap<String, String> datos = new HashMap<>();
        datos.put("uid", uid);
        datos.put("nombre", nameUser);
        datos.put("apellidos", lastNameUser);
        datos.put("correo", emailUser);
        datos.put("pais", countryUser);
        datos.put("contrasena",passwordUser);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Usuarios");
        assert uid != null;
        databaseReference.child(uid).setValue(datos).addOnSuccessListener(unused -> {
            progressDialog.dismiss();
            Toast.makeText(Register.this, "Usuario creado con éxito", Toast.LENGTH_SHORT).show();
            limpiar();
            startActivity( new Intent(Register.this, HomeMenu.class));
            finish();
        }).addOnFailureListener(e -> {
            progressDialog.dismiss();
            Toast.makeText(Register.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        });


    }




    private void limpiar() {
        ed_nombre.setText("");
        ed_apellidos.setText("");
        ed_email.setText("");
        ed_pass.setText("");
        listaPaises.setSelection(0);
    }

}