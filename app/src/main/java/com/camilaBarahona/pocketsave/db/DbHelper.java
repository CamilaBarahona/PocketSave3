package com.camilaBarahona.pocketsave.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "pocketSave.db";
    protected static final String TABLE_USUARIOS = "t_usuarios";
    private static final String TABLE_GASTOS = "t_gastos";
    private static final String TABLE_RECORDATORIOS = "t_recordatorios";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIOS + "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "rut TEXT NOT NULL," +
                "nombre TEXT NOT NULL," +
                "apellido_paterno TEXT NOT NULL," +
                "apellido_materno TEXT NOT NULL," +
                "fecha_nacimiento DATE NOT NULL," +
                "direccion TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "password TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_GASTOS + "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tipo_movimiento TEXT NOT NULL," +
                "categoria_movimiento TEXT NOT NULL," +
                "monto INT NOT NULL," +
                "fecha DATE NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_RECORDATORIOS + "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL," +
                "cuerpo TEXT NOT NULL," +
                "fecha DATE NOT NULL," +
                "hora TIME NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+ TABLE_USUARIOS);
        onCreate(sqLiteDatabase);
    }
}
