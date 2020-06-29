package com.sisvuelo.aplication.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value ="natural" )
public class ClienteNatural extends Pasajero {


    @Column(name = "NUMERO_DOCUMENTO", nullable = true, length = 10)
    private Integer numeroDocumento;
    @Column(name = "NIT", nullable = true, length = 10)
    private Integer nit;
    @Column(name = "PRIMER_NOMBRE", nullable = true, length = 10)
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE", nullable = true, length = 10)
    private String segundoNomnbre;
    @Column(name = "PRIMER_APELLIDO", nullable = true, length = 10)
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO", nullable = true, length = 10)
    private String segundoApellido;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_ESTADO_CIVIL", nullable = true)
    private EstadoCivil estadoCivil;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_GENERO", nullable = true)
    private Genero genero;

    @ManyToOne(optional = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_TIPO_DOCUMENTO", nullable = true)
    private TipoDocumento tipoDocumento;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FECHA_NACIMIENTO", updatable = true, nullable = true)
    private String fechaNacimiento;


    public ClienteNatural() {
    }

    public ClienteNatural(Integer numeroViajero, String telefonoFijo, String telefonoMovil, String email, Usuario usuario, Integer numeroDocumento, Integer nit, String primerNombre, String segundoNomnbre, String primerApellido, String segundoApellido, EstadoCivil estadoCivil, Genero genero, TipoDocumento tipoDocumento, String fechaNacimiento) {
        super(numeroViajero, telefonoFijo, telefonoMovil, email, usuario);
        this.numeroDocumento = numeroDocumento;
        this.nit = nit;
        this.primerNombre = primerNombre;
        this.segundoNomnbre = segundoNomnbre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
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

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNomnbre() {
        return segundoNomnbre;
    }

    public void setSegundoNomnbre(String segundoNomnbre) {
        this.segundoNomnbre = segundoNomnbre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
    }
}
