package com.booknow.data;

import java.util.Date;

public class HoursDiners {
    private Date dia;
    private Date hora;
    private int id;
    private int id_restaurante;
    private int comensales_disponibles;

    public HoursDiners(Date dia, Date hora, int id, int id_restaurante, int comensales_disponibles){
        this.dia = new Date(dia.getTime());
        this.hora = new Date(hora.getTime());
        this.id = id;
        this.id_restaurante = id_restaurante;
        this.comensales_disponibles = comensales_disponibles;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(int id_restaurante) {
        this.id_restaurante = id_restaurante;
    }

    public int getComensales_disponibles() {
        return comensales_disponibles;
    }

    public void setComensales_disponibles(int comensales_disponibles) {
        this.comensales_disponibles = comensales_disponibles;
    }
}
