package com.camilaBarahona.pocketsave.menuHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.camilaBarahona.pocketsave.MainActivity;
import com.camilaBarahona.pocketsave.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LogoutFragment extends Fragment {
    private final static int rView = R.layout.fragment_log_out;
    View view;
    Button cerrarSesion;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;



    public LogoutFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(rView, container, false);
        cerrarSesion = (Button) view.findViewById(R.id.logoutButton);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SalirAplicacion();
            }
        });
        return view;
    }

    private void SalirAplicacion(){
        firebaseAuth.signOut();
        startActivity(new Intent(getActivity(), MainActivity.class));
        Toast.makeText(getActivity(), "Cerraste Sesión exitosamente", Toast.LENGTH_SHORT).show();
    }
}