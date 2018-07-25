package com.booknow.database.model;


import java.util.Date;

/**
 *
 * Entidad Restaurante
 *
 */
public class Restaurant {
    private String name;
    private Date inauguracion;
    private int id;
    private String direccion;
    private String chef;
    private Date horarioApertura;
    private Date horarioCierre;

    public Restaurant(String name, Date inauguracion, int id, String direccion, String chef, Date horarioApertura, Date horarioCierre){
        this.name = name;
        this.inauguracion = new Date(inauguracion.getTime());
        this.id = id;
        this.direccion = direccion;
        this.chef = chef;
        this.horarioApertura = new Date(horarioApertura.getTime());
        this.horarioCierre = new Date(horarioCierre.getTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInauguracion() {
        return inauguracion;
    }

    public void setInauguracion(Date inauguracion) {
        this.inauguracion = inauguracion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public Date getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(Date horarioApertura) {
        this.horarioApertura = horarioApertura;
    }

    public Date getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(Date horarioCierre) {
        this.horarioCierre = horarioCierre;
    }

}
