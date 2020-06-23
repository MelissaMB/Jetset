package com.sisvuelo.aplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE_NATURAL")
public class ClienteNatural {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Integer numeroDocumento;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ESTADO_CIVIL", nullable = false)
    private EstadoCivil estadoCivil;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_GENERO", nullable = false)
    private Genero genero;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", nullable = false)
    private TipoDocumento tipoDocumento;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_NACIMIENTO", updatable = true, nullable = false)
    private String fechaNacimiento;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PASAJERO", nullable = false)
    private Pasajero pasajero;


    public ClienteNatural() {
    }

    public ClienteNatural(Integer numeroDocumento, EstadoCivil estadoCivil, Genero genero, TipoDocumento tipoDocumento, String fechaNacimiento) {
        this.numeroDocumento = numeroDocumento;
        this.estadoCivil = estadoCivil;
        this.genero = genero;
        this.tipoDocumento = tipoDocumento;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
