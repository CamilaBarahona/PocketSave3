package com.camilaBarahona.pocketsave.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbRecordatorios extends DbHelper{
    Context context;
    public DbRecordatorios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarRecordatorio(String titulo, String cuerpo, String fecha, String hora) {
        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("titulo", titulo);
            values.put("cuerpo", cuerpo);
            values.put("fecha", fecha);
            values.put("hora", hora);

            id = db.insert(TABLE_RECORDATORIOS, null,values);

        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
}
