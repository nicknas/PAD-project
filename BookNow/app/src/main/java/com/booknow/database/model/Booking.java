package com.booknow.database.model;

import java.util.Date;

public class Booking {

    private Date dia;
    private Date hora;
    private String nombreReserva;
    private int numComensales;
    private int id;
    private int idUsuario;

    public Booking(Date dia, Date hora, String nombreReserva, int numComensales, int id, int idUsuario){
        this.dia = new Date(dia.getTime());
        this.hora = new Date(hora.getTime());
        this.nombreReserva = new String (nombreReserva);
        this.numComensales = numComensales;
        this.id = id;
        this.idUsuario = idUsuario;
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

    public String getNombreReserva() {
        return nombreReserva;
    }

    public void setNombreReserva(String nombreReserva) {
        this.nombreReserva = nombreReserva;
    }

    public int getNumComensales() {
        return numComensales;
    }

    public void setNumComensales(int numComensales) {
        this.numComensales = numComensales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
