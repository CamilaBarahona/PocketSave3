package com.camilaBarahona.pocketsave.db;

import com.camilaBarahona.pocketsave.R;

public class Gasto {
    private int id;
    private String tipo_movimiento;
    private String categoria_movimiento;
    private String monto;
    private String fecha;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public String getCategoria_movimiento() {
        return categoria_movimiento;
    }

    public void setCategoria_movimiento(String categoria_movimiento) {
        this.categoria_movimiento = categoria_movimiento;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}



