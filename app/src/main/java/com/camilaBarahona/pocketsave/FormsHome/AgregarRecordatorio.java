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
import com.camilaBarahona.pocketsave.db.DbRecordatorios;
import com.camilaBarahona.pocketsave.menuHome.HomeFragment;
import com.camilaBarahona.pocketsave.menuHome.HomeMenu;
import com.google.android.material.textfield.TextInputEditText;

public class AgregarRecordatorio extends AppCompatActivity {
    Button btn_guardar, btn_regresar;
    TextInputEditText tituloRecordatorio, cuerpoRecordatorio, fechaRecordatorio;
    Spinner listaHoras;
    String datosHora[] = {"00:00", "01:00", "02:00", "03:00", "04:00","05:00", "06:00","07:00", "08:00"};
    ArrayAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_recordatorio);

        //Inicialización de botones
        btn_guardar = (Button) findViewById(R.id.btn_guardar);
        btn_regresar = (Button) findViewById(R.id.btn_regresar2);

        //Inicialización de inputTexts
        tituloRecordatorio = (TextInputEditText) findViewById(R.id.tituloRecordatorio);
        cuerpoRecordatorio = (TextInputEditText) findViewById(R.id.cuerpoRecordatorio);
        fechaRecordatorio = (TextInputEditText) findViewById(R.id.fechaRecordatorio);

        //Inicialización de Spinner
        listaHoras = (Spinner) findViewById(R.id.listaHoras);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,datosHora);
        listaHoras.setAdapter(adapter);

        //Metodo para definir las opciones seleccionadas.
        listaHoras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Metodo click del botón Regresar
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( AgregarRecordatorio.this, HomeMenu.class);
                startActivity(intent);
            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbRecordatorios dbRecordatorios = new DbRecordatorios(AgregarRecordatorio.this);
                long id = dbRecordatorios.insertarRecordatorio(
                        tituloRecordatorio.getText().toString(),
                        cuerpoRecordatorio.getText().toString(),
                        fechaRecordatorio.getText().toString(),
                        listaHoras.toString()
                );

                if (id > 0) {
                    Toast.makeText(AgregarRecordatorio.this, "RECORDATORIO GUARDADO", Toast.LENGTH_SHORT).show();
                    limpiar();
                } else {
                    Toast.makeText(AgregarRecordatorio.this, "ERROR AL GUARDAR RECORDATORIO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiar() {
        tituloRecordatorio.setText("");
        cuerpoRecordatorio.setText("");
        fechaRecordatorio.setText("");
    }
}