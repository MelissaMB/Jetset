package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Avion;
import com.sisvuelo.aplication.model.Destino;
import com.sisvuelo.aplication.model.Destino;
import com.sisvuelo.aplication.model.Aerolinea;

import java.util.Date;
import java.util.Date;
import java.util.Date;


public class VueloFilter {

    private Integer id;
    private String codigo;
    private Destino origen;
    private Destino destino;
    private Aerolinea aerolinea;
    private Avion avion;
    private double costo;
    private double millasReales;
    private double millasPasajeros;
    private Date fecha;
    private Date horaDespegue;
    private Date horaAterrizaje;
    private boolean tieneEscala;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Destino getOrigen() {
        return this.origen;
    }

    public void setOrigen(Destino origen) {
        this.origen = origen;
    }

    public Destino getDestino() {
        return this.destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Aerolinea getAerolinea() {
        return this.aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getMillasReales() {
        return this.millasReales;
    }

    public void setMillasReales(double millasReales) {
        this.millasReales = millasReales;
    }

    public double getMillasPasajeros() {
        return this.millasPasajeros;
    }

    public void setMillasPasajeros(double millasPasajeros) {
        this.millasPasajeros = millasPasajeros;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraDespegue() {
        return this.horaDespegue;
    }

    public void setHoraDespegue(Date horaDespegue) {
        this.horaDespegue = horaDespegue;
    }

    public Date getHoraAterrizaje() {
        return this.horaAterrizaje;
    }

    public void setHoraAterrizaje(Date horaAterrizaje) {
        this.horaAterrizaje = horaAterrizaje;
    }

    public boolean isTieneEscala() {
        return this.tieneEscala;
    }

    public void setTieneEscala(boolean tieneEscala) {
        this.tieneEscala = tieneEscala;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
