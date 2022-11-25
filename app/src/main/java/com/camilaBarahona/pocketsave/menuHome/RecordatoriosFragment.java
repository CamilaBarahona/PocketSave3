package com.camilaBarahona.pocketsave.menuHome;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.camilaBarahona.pocketsave.AdapterHome.AdapterRecordatorio;
import com.camilaBarahona.pocketsave.FormsHome.AgregarRecordatorio;
import com.camilaBarahona.pocketsave.R;
import com.camilaBarahona.pocketsave.db.DbRecordatorios;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecordatoriosFragment extends Fragment {
    private final static int rView = R.layout.fragment_recordatorios;
    View vista;
    FloatingActionButton btn_agregarRecordatorio;
    ArrayList<com.camilaBarahona.pocketsave.db.Recordatorio> recordatorioArraylist;

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
        vista = inflater.inflate(rView, container, false);
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
    @Override
    public void onViewCreated(@NonNull View vista, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(vista, savedInstanceState);
        RecyclerView recyclerView = vista.findViewById(R.id.recyclerViewRecordatorios);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        DbRecordatorios dbRecordatorios = new DbRecordatorios(getContext());
        recordatorioArraylist = new ArrayList<>();
        AdapterRecordatorio adapterRecordatorio = new AdapterRecordatorio( getContext(), dbRecordatorios.mostrarRecordatorio());
        recyclerView.setAdapter(adapterRecordatorio);


    }
}