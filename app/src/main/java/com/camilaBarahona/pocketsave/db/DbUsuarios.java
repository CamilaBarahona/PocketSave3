package com.camilaBarahona.pocketsave.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbUsuarios extends DbHelper{

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarUsuario(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                                String fechaNacimiento, String direccion, String correo, String password) {
        long id = 0;
        try {


            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("rut", rut);
            values.put("nombre", nombre);
            values.put("apellido_paterno", apellidoPaterno);
            values.put("apellido_materno", apellidoMaterno);
            values.put("fecha_nacimiento", fechaNacimiento);
            values.put("direccion", direccion);
            values.put("email", correo);
            values.put("password", password);

             id = db.insert(TABLE_USUARIOS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
}
