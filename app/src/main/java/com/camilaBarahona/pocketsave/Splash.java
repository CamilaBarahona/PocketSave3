package com.camilaBarahona.pocketsave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.camilaBarahona.pocketsave.menuHome.HomeMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        firebaseAuth = FirebaseAuth.getInstance();
        int tiempo = 4000;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                VerificarUsuario();
            }
        }, tiempo);
    }
    private void VerificarUsuario(){
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        // Si el usuario no está registrado.
        if (firebaseUser == null){
            startActivity(new Intent(Splash.this, MainActivity.class));
            finish();

            // Si el usuario está registrado.
        } else {
            startActivity(new Intent(Splash.this, HomeMenu.class));
            finish();
        }
    }
}