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

import com.camilaBarahona.pocketsave.AdapterHome.AdapterConsolidado;
import com.camilaBarahona.pocketsave.FormsHome.AgregarMovimiento;
import com.camilaBarahona.pocketsave.R;
import com.camilaBarahona.pocketsave.db.DbGastos;
import com.camilaBarahona.pocketsave.db.Gasto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class GastosFragment extends Fragment {
    private final static int rView = R.layout.fragment_gastos;
    View view;
    FloatingActionButton btn_agregarGasto;
    ArrayList<Gasto> gastoArrayList;

    public GastosFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(rView, container, false);
        btn_agregarGasto = (FloatingActionButton) view.findViewById(R.id.btn_agregarGasto);
        btn_agregarGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getActivity(), AgregarMovimiento.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewGastos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        DbGastos dbGastos = new DbGastos(getContext());
        AdapterConsolidado adapterConsolidado = new AdapterConsolidado(getContext(), dbGastos.mostrarGasto());
        recyclerView.setAdapter(adapterConsolidado);
    }

    /*private ArrayList<Consolidado> dataInitialize() {
        ArrayList<Consolidado> consolidadoArrayList = new ArrayList<>();
        consolidadoArrayList.add(new Consolidado("INGRESO", "01/07/2022", "Sueldo", "$650.000", R.drawable.flechaverde));
        consolidadoArrayList.add(new Consolidado("INGRESO", "03/07/2022", "prestamo Juanita", "$60.000", R.drawable.flechaverde));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Luz", "$20.000", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Celular", "$15.000", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Agua", "$10.000", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Gas", "$21.000", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Internet", "$18.395", R.drawable.red_arrow));
        consolidadoArrayList.add(new Consolidado("EGRESO", "03/07/2022", "Pago Arriendo", "$250.000", R.drawable.red_arrow));
        return consolidadoArrayList;
    } */

}