package com.booknow.database.model;

import java.util.Date;

public class Booking {

    private Date dia;
    private Date hora;
    private String nombreReserva;
    private int numComensales;
    private int id;
    private int idUsuario;
    private boolean isPending;
    private boolean isAccepted;
    private int idRestaurante;

    public Booking(Date dia, Date hora, String nombreReserva, int numComensales, int id, int idUsuario, int idRestaurante){
        this.dia = new Date(dia.getTime());
        this.hora = new Date(hora.getTime());
        this.nombreReserva = new String (nombreReserva);
        this.numComensales = numComensales;
        this.id = id;
        this.idUsuario = idUsuario;
        this.isAccepted = false;
        this.isPending = true;
        this.idRestaurante = idRestaurante;
    }

    public Booking(Date dia, Date hora, String nombreReserva, int numComensales, int id, int idUsuario, boolean isPending, boolean isAccepted, int idRestaurante){
        this.dia = new Date(dia.getTime());
        this.hora = new Date(hora.getTime());
        this.nombreReserva = new String (nombreReserva);
        this.numComensales = numComensales;
        this.id = id;
        this.idUsuario = idUsuario;
        this.isAccepted = isAccepted;
        this.isPending = isPending;
        this.idRestaurante = idRestaurante;
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

    public boolean getIsPending() {
        return isPending;
    }

    public void setIsPending(boolean pending) {
        isPending = pending;
    }

    public boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public int getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(int idRestaurante) {
        this.idRestaurante = idRestaurante;
    }
}
