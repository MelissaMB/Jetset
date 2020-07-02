package com.sisvuelo.aplication.model;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "VIEW_OFERTA_VUELOS")
public class ViewOfertaVuelos {

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

    @Id
    @Column(name = "IDENT")
    public Long getIdent() {
        return ident;
    }

    public void setIdent(Long ident) {
        this.ident = ident;
    }


    @Column(name = "ID_VUELO")
    public Integer getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }


    @Column(name = "VUELO")
    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }


    @Column(name = "ID_AEROLINEA")
    public Integer getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }


    @Column(name = "AEROLINEA")
    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }


    @Column(name = "ESCALAS")
    public String getEscalas() {
        return escalas;
    }

    public void setEscalas(String escalas) {
        this.escalas = escalas;
    }


    @Column(name = "ORIGEN")
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }


    @Column(name = "DESTINO")
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }


    @Column(name = "HORA_ATERRIZAJE")
    public Timestamp getHoraAterrizaje() {
        return horaAterrizaje;
    }

    public void setHoraAterrizaje(Timestamp horaAterrizaje) {
        this.horaAterrizaje = horaAterrizaje;
    }


    @Column(name = "DURACION")
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }


    @Column(name = "HORA_DESPEGUE")
    public Timestamp getHoraDespegue() {
        return horaDespegue;
    }

    public void setHoraDespegue(Timestamp horaDespegue) {
        this.horaDespegue = horaDespegue;
    }

    @Column(name = "ID_CLASE")
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }


    @Column(name = "CLASE")
    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }


    @Column(name = "PRECIO")
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Column(name = "DISPONIBLES")
    public Long getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Long disponibles) {
        this.disponibles = disponibles;
    }
}
