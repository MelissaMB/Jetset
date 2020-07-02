package com.sisvuelo.aplication.filter;

import java.sql.Timestamp;

public class ViewOfertaVueloFilter {

    private Long ident;
    private Integer idVuelo;
    private String vuelo;
    private Integer idAerolinea;
    private String aerolinea;
    private String escalas;
    private String origen;
    private String destino;
    private Timestamp horaAterrizaje;
    private String duracion;
    private Timestamp horaDespegue;
    private Integer idClase;
    private String clase;
    private Double precio;
    private Long disponibles;

    public Long getIdent() {
        return ident;
    }

    public void setIdent(Long ident) {
        this.ident = ident;
    }

    public Integer getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    public Integer getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getEscalas() {
        return escalas;
    }

    public void setEscalas(String escalas) {
        this.escalas = escalas;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Timestamp getHoraAterrizaje() {
        return horaAterrizaje;
    }

    public void setHoraAterrizaje(Timestamp horaAterrizaje) {
        this.horaAterrizaje = horaAterrizaje;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Timestamp getHoraDespegue() {
        return horaDespegue;
    }

    public void setHoraDespegue(Timestamp horaDespegue) {
        this.horaDespegue = horaDespegue;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Long getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Long disponibles) {
        this.disponibles = disponibles;
    }
}
