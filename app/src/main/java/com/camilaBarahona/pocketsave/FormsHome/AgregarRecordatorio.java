package com.camilaBarahona.pocketsave.FormsHome;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.camilaBarahona.pocketsave.R;
import com.camilaBarahona.pocketsave.db.DbRecordatorios;
import com.camilaBarahona.pocketsave.menuHome.HomeMenu;
import com.google.android.material.textfield.TextInputEditText;

public class AgregarRecordatorio extends AppCompatActivity {
    Button btn_guardar, btn_regresar;
    TextInputEditText tituloRecordatorio, cuerpoRecordatorio, fechaRecordatorio;
    Spinner listaHoras;
    String datosHora[] = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    ArrayAdapter adapter;
    String spinnerValue;

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
        this.spinnerValue = "";
        //Inicialización de Spinner
        listaHoras = (Spinner) findViewById(R.id.listaHoras);
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, datosHora);
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
                    case 9:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 11:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 12:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 13:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 14:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 15:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 16:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 17:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 18:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 19:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 20:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 21:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 22:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 23:
                        Toast.makeText(AgregarRecordatorio.this, datosHora[position], Toast.LENGTH_SHORT).show();
                        break;
                    case 24:
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
                Intent intent = new Intent(AgregarRecordatorio.this, HomeMenu.class);
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
                        listaHoras.getSelectedItem().toString()
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
        listaHoras.setSelection(0);
    }
}