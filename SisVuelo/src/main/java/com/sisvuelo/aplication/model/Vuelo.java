package com.sisvuelo.aplication.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TBL_VUELO")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "IdVuelo")
    private Integer id;

    @Column(name = "Codigo", nullable = false, length = 10)
    private String codigo;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "IdOrigen", nullable = false)
    private Destino origen;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDestino", nullable = false)
    private Destino destino;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "IdAerolinea", nullable = false)
    private Aerolinea aerolinea;

    @Column(name = "Costo", nullable = false)
    private double costo;

    @Column(name = "MillasReales", nullable = false)
    private double millasReales;

    @Column(name = "MillasPasajeros", nullable = false)
    private double millasPasajeros;

    @Column(name = "Fecha", updatable = true, nullable = true)
    private Date fecha;

    @Column(name = "HoraDespegue", updatable = true, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaDespegue;

    @Column(name = "HoraAterrizaje", updatable = true, nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaAterrizaje;

    @Column(name = "TieneEscala", nullable = false)
    private boolean tieneEscala;

    public Vuelo() {
    }

    public Vuelo(Integer id, String codigo, Destino origen, Destino destino, Aerolinea aerolinea, double costo, double millasReales, double millasPasajeros, Date fecha, Date horaDespegue, Date horaAterrizaje, boolean tieneEscala) {
        this.id = id;
        this.codigo = codigo;
        this.origen = origen;
        this.destino = destino;
        this.aerolinea = aerolinea;
        this.costo = costo;
        this.millasReales = millasReales;
        this.millasPasajeros = millasPasajeros;
        this.fecha = fecha;
        this.horaDespegue = horaDespegue;
        this.horaAterrizaje = horaAterrizaje;
        this.tieneEscala = tieneEscala;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Destino getOrigen() {
        return origen;
    }

    public void setOrigen(Destino origen) {
        this.origen = origen;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getMillasReales() {
        return millasReales;
    }

    public void setMillasReales(double millasReales) {
        this.millasReales = millasReales;
    }

    public double getMillasPasajeros() {
        return millasPasajeros;
    }

    public void setMillasPasajeros(double millasPasajeros) {
        this.millasPasajeros = millasPasajeros;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraDespegue() {
        return horaDespegue;
    }

    public void setHoraDespegue(Date horaDespegue) {
        this.horaDespegue = horaDespegue;
    }

    public Date getHoraAterrizaje() {
        return horaAterrizaje;
    }

    public void setHoraAterrizaje(Date horaAterrizaje) {
        this.horaAterrizaje = horaAterrizaje;
    }

    public boolean isTieneEscala() {
        return tieneEscala;
    }

    public void setTieneEscala(boolean tieneEscala) {
        this.tieneEscala = tieneEscala;
    }
}
