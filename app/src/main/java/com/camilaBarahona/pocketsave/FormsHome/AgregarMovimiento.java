package com.camilaBarahona.pocketsave.FormsHome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.camilaBarahona.pocketsave.R;
import com.camilaBarahona.pocketsave.Register;
import com.camilaBarahona.pocketsave.db.DbGastos;
import com.camilaBarahona.pocketsave.db.DbRecordatorios;
import com.camilaBarahona.pocketsave.menuHome.GastosFragment;
import com.camilaBarahona.pocketsave.menuHome.HomeFragment;
import com.camilaBarahona.pocketsave.menuHome.HomeMenu;
import com.google.android.material.textfield.TextInputEditText;

public class AgregarMovimiento extends AppCompatActivity {
    Button btn_regresar, btn_guardarMovimiento;
    Spinner lista;
    TextInputEditText input_cat, input_monto, input_fecha;

    String datos[] = {"Seleccionar tipo de Movimiento","Ingreso", "Egreso"};
    ArrayAdapter arrayAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_movimiento);
        //Inicialización de botones:
        btn_guardarMovimiento = (Button) findViewById(R.id.btn_guardarMovimiento);
        btn_regresar = (Button) findViewById(R.id.btn_regresar);

        //Inicialización de los inputTexts
        input_cat = (TextInputEditText) findViewById(R.id.input_cat);
        input_monto = (TextInputEditText) findViewById(R.id.input_monto);
        input_fecha = (TextInputEditText) findViewById(R.id.input_fecha);

        //Inicialización del spinner
        lista = (Spinner) findViewById(R.id.listaMov);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, datos);
        lista.setAdapter(arrayAdapter);

        // Método para definir las opciones seleccionadas
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        Toast.makeText(AgregarMovimiento.this, datos[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(AgregarMovimiento.this, datos[position], Toast.LENGTH_SHORT).show();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Metodo click del botón regresar
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( AgregarMovimiento.this, HomeMenu.class);
                startActivity(intent);
            }
        });

        btn_guardarMovimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbGastos dbGastos = new DbGastos(AgregarMovimiento.this);
                long id = dbGastos.insertarGasto(
                        lista.toString(),
                        input_cat.getText().toString(),
                        Integer.parseInt(input_monto.getText().toString()),
                        input_fecha.getText().toString()
                );

                if (id > 0) {
                    Toast.makeText(AgregarMovimiento.this, "MOVIMIENTO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(AgregarMovimiento.this, "ERROR AL GUARDAR MOVIMIENTO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiar() {
        input_cat.setText("");
        input_monto.setText("");
        input_fecha.setText("");
    }
}