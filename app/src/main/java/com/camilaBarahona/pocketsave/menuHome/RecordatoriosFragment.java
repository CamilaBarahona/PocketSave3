package com.camilaBarahona.pocketsave.menuHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camilaBarahona.pocketsave.FormsHome.AgregarRecordatorio;
import com.camilaBarahona.pocketsave.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecordatoriosFragment extends Fragment {
    View vista;
    FloatingActionButton btn_agregarRecordatorio;

    public RecordatoriosFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_recordatorios, container, false);

        btn_agregarRecordatorio = (FloatingActionButton) vista.findViewById(R.id.btn_agregarRecordatorio);

        btn_agregarRecordatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), AgregarRecordatorio.class);
                startActivity(intent);
            }
        });
        return vista;
    }
}