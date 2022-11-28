package com.camilaBarahona.pocketsave;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.camilaBarahona.pocketsave.menuHome.HomeMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    Button btnIngresar, btnRegistrarse;
    EditText correoLogin, passwordLogin;
    ProgressDialog progressDialog;
    FirebaseAuth auth;

    String correo = "";
    String contrasena = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Login");
        setContentView(R.layout.activity_login);
        correoLogin = (EditText) findViewById(R.id.correoLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrarse = (Button) findViewById(R.id.btn_registrarse);
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Login.this);
        progressDialog.setTitle("Espere por favor");
        progressDialog.setCanceledOnTouchOutside(false);


        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidarDatos();
            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        Login.this, Register.class
                ));
            }
        });
    }

    private void ValidarDatos() {
        correo = correoLogin.getText().toString();
        contrasena = passwordLogin.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this, "Correo iválido", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(contrasena)) {
            Toast.makeText(this, "Ingrese contraseña", Toast.LENGTH_SHORT).show();
        } else {
            LoginUsuario();
        }
    }

    private void LoginUsuario() {
        progressDialog.setMessage("Iniciando sesión...");
        progressDialog.show();
        auth.signInWithEmailAndPassword(correo, contrasena).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    FirebaseUser user = auth.getCurrentUser();
                    startActivity(new Intent(Login.this, HomeMenu.class));
                    Toast.makeText(Login.this, "Bienvenido(a): " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(Login.this, "Verifique si el correo y contraseña son correctos", Toast.LENGTH_SHORT).show();
                }
            }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure (@NonNull Exception e){
                    Toast.makeText(Login.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
