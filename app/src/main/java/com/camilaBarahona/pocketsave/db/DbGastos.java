package com.camilaBarahona.pocketsave.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbGastos extends DbHelper {
    Context context;
    public DbGastos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarGasto(String tipo_movimiento, String categoria_movimiento, int monto, String fecha) {
        long id = 0;
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
}
