package com.camilaBarahona.pocketsave.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbGastos extends DbHelper {
    Context context;

    public DbGastos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarGasto(String tipo_movimiento, String categoria_movimiento, int monto, String fecha) {
        long id = 0;
        int img = 0;
        try {

            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("tipo_movimiento", tipo_movimiento);
            values.put("categoria_movimiento", categoria_movimiento);
            values.put("monto", monto);
            values.put("fecha", fecha);
            id = db.insert(TABLE_GASTOS, null, values);
        } catch (Exception e) {
            e.toString();
        }
        return id;
    }

    public ArrayList<Gasto> mostrarGasto(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Gasto> listaGastos = new ArrayList<>();
        Gasto gasto = null;
        Cursor cursorGastos = db.rawQuery("SELECT * FROM " + TABLE_GASTOS, null);
        if (cursorGastos.moveToFirst()) {
            do {
                gasto = new Gasto();
                gasto.setId(cursorGastos.getInt(0));
                gasto.setTipo_movimiento(cursorGastos.getString(1));
                gasto.setCategoria_movimiento(cursorGastos.getString(2));
                gasto.setMonto(cursorGastos.getString(3));
                gasto.setFecha(cursorGastos.getString(4));
                listaGastos.add(gasto);

            } while (cursorGastos.moveToNext());
        }
        cursorGastos.close();
        return listaGastos;
    }
}
