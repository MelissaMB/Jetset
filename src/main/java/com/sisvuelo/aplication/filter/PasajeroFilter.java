package com.sisvuelo.aplication.filter;

import javax.persistence.Column;

public class PasajeroFilter {

    private Integer numeroViajero;
    private Integer nit;
    private String primerNombre;
    private String segundoNomnbre;
    private String primerApellido;
    private String segundoApellido;
    private String telefonoFijo;
    private String telefonoMovil;
    private String email;
    private Integer tipoPasajero;

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

    public Integer getTipoPasajero() {
        return tipoPasajero;
    }

    public void setTipoPasajero(Integer tipoPasajero) {
        this.tipoPasajero = tipoPasajero;
    }
}
