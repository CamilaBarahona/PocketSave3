package com.camilaBarahona.pocketsave.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbRecordatorios extends DbHelper {
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

            id = db.insert(TABLE_RECORDATORIOS, null, values);

        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    public ArrayList<Recordatorio> mostrarRecordatorio() {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Recordatorio> listaRecordatorios = new ArrayList<>();
        Recordatorio recordatorio = null;
        Cursor cursorRecordatorios = null;
        cursorRecordatorios = db.rawQuery("SELECT * FROM " + TABLE_RECORDATORIOS, null);
        if (cursorRecordatorios.moveToFirst()) {
            do {
                recordatorio = new Recordatorio();
                recordatorio.setId(cursorRecordatorios.getInt(0));
                recordatorio.setTitulo(cursorRecordatorios.getString(1));
                recordatorio.setCuerpo(cursorRecordatorios.getString(2));
                recordatorio.setFecha(cursorRecordatorios.getString(3));
                recordatorio.setHora(cursorRecordatorios.getString(4));
                listaRecordatorios.add(recordatorio);

            } while (cursorRecordatorios.moveToNext());
        }
        cursorRecordatorios.close();

        return listaRecordatorios;
    }
}
