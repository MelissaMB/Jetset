package com.sisvuelo.aplication.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_PASAJERO")
public class Pasajero {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_PASAJERO")
    private Integer numeroViajero;
    @Column(name = "NIT", nullable = false, length = 15)
    private Integer nit;
    @Column(name = "PRIMER_NOMBRE", nullable = false, length = 10)
    private String primerNombre;
    @Column(name = "SEGUNDO_NOMBRE", nullable = true, length = 10)
    private String segundoNomnbre;
    @Column(name = "PRIMER_APELLIDO", nullable = false, length = 10)
    private String primerApellido;
    @Column(name = "SEGUNDO_APELLIDO", nullable = true, length = 10)
    private String segundoApellido;
    @Column(name = "TELEFONO_FIJO", nullable = true, length = 8)
    private String telefonoFijo;
    @Column(name = "TELEFONO_MOVIL", nullable = false, length = 8)
    private String telefonoMovil;
    @Column(name = "EMAIL", nullable = false, length = 50)
    private String email;

    public Pasajero() {
    }

    public Pasajero(Integer numeroViajero, Integer nit, String primerNombre, String segundoNomnbre, String primerApellido, String segundoApellido, String telefonoFijo, String telefonoMovil, String email) {
        this.numeroViajero = numeroViajero;
        this.nit = nit;
        this.primerNombre = primerNombre;
        this.segundoNomnbre = segundoNomnbre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.email = email;
    }

    public Integer getNumeroViajero() {
        return numeroViajero;
    }

    public void setNumeroViajero(Integer numeroViajero) {
        this.numeroViajero = numeroViajero;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
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

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
