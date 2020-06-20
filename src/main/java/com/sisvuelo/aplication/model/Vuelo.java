package com.sisvuelo.aplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_VUELO")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id_vuelo")
    private Integer id;

    @Column(name = "codigo", nullable = false, length = 10)
    private String codigo;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_origen", nullable = false)
    private Destino origen;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_destino", nullable = false)
    private Destino destino;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aerolinea", nullable = false)
    private Aerolinea aerolinea;

    @Column(name = "Costo", nullable = false)
    private double costo;

    @Column(name = "millas_reales", nullable = false)
    private double millasReales;

    @Column(name = "millas_pasajeros", nullable = false)
    private double millasPasajeros;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha", updatable = true, nullable = true)
    private Date fecha;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "hora_despegue", updatable = true, nullable = true)
    private Date horaDespegue;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "hora_aterrizaje", updatable = true, nullable = true)
    private Date horaAterrizaje;

    @Column(name = "tiene_escala", nullable = false)
    private boolean tieneEscala;

    public Vuelo() {
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", origen=" + origen +
                ", destino=" + destino +
                ", aerolinea=" + aerolinea +
                ", costo=" + costo +
                ", millasReales=" + millasReales +
                ", millasPasajeros=" + millasPasajeros +
                ", fecha=" + fecha +
                ", horaDespegue=" + horaDespegue +
                ", horaAterrizaje=" + horaAterrizaje +
                ", tieneEscala=" + tieneEscala +
                '}';
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
