package com.sisvuelo.aplication.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "VIEW_OFERTA_VUELOS", schema = "BAD115", catalog = "")
public class ViewOfertaVuelo {
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

    @Basic
    @Id
    @Column(name = "IDENT")
    public Long getIdent() {
        return ident;
    }

    public void setIdent(Long ident) {
        this.ident = ident;
    }

    @Basic
    @Column(name = "ID_VUELO")
    public Integer getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(Integer idVuelo) {
        this.idVuelo = idVuelo;
    }

    @Basic
    @Column(name = "VUELO")
    public String getVuelo() {
        return vuelo;
    }

    public void setVuelo(String vuelo) {
        this.vuelo = vuelo;
    }

    @Basic
    @Column(name = "ID_AEROLINEA")
    public Integer getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(Integer idAerolinea) {
        this.idAerolinea = idAerolinea;
    }

    @Basic
    @Column(name = "AEROLINEA")
    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    @Basic
    @Column(name = "ESCALAS")
    public String getEscalas() {
        return escalas;
    }

    public void setEscalas(String escalas) {
        this.escalas = escalas;
    }

    @Basic
    @Column(name = "ORIGEN")
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Basic
    @Column(name = "DESTINO")
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Basic
    @Column(name = "HORA_ATERRIZAJE")
    public Timestamp getHoraAterrizaje() {
        return horaAterrizaje;
    }

    public void setHoraAterrizaje(Timestamp horaAterrizaje) {
        this.horaAterrizaje = horaAterrizaje;
    }

    @Basic
    @Column(name = "DURACION")
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Basic
    @Column(name = "HORA_DESPEGUE")
    public Timestamp getHoraDespegue() {
        return horaDespegue;
    }

    public void setHoraDespegue(Timestamp horaDespegue) {
        this.horaDespegue = horaDespegue;
    }

    @Basic
    @Column(name = "ID_CLASE")
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    @Basic
    @Column(name = "CLASE")
    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    @Basic
    @Column(name = "PRECIO")
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "DISPONIBLES")
    public Long getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Long disponibles) {
        this.disponibles = disponibles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewOfertaVuelo that = (ViewOfertaVuelo) o;
        return Objects.equals(ident, that.ident) &&
                Objects.equals(idVuelo, that.idVuelo) &&
                Objects.equals(vuelo, that.vuelo) &&
                Objects.equals(idAerolinea, that.idAerolinea) &&
                Objects.equals(aerolinea, that.aerolinea) &&
                Objects.equals(escalas, that.escalas) &&
                Objects.equals(origen, that.origen) &&
                Objects.equals(destino, that.destino) &&
                Objects.equals(horaAterrizaje, that.horaAterrizaje) &&
                Objects.equals(duracion, that.duracion) &&
                Objects.equals(horaDespegue, that.horaDespegue) &&
                Objects.equals(idClase, that.idClase) &&
                Objects.equals(clase, that.clase) &&
                Objects.equals(precio, that.precio) &&
                Objects.equals(disponibles, that.disponibles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ident, idVuelo, vuelo, idAerolinea, aerolinea, escalas, origen, destino, horaAterrizaje, duracion, horaDespegue, idClase, clase, precio, disponibles);
    }
}
