package com.sisvuelo.aplication.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_PASAJERO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class Pasajero {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_PASAJERO")
    private Integer numeroViajero;
    @Column(name = "TELEFONO_FIJO", nullable = true, length = 8)
    protected String telefonoFijo;
    @Column(name = "TELEFONO_MOVIL", nullable = true, length = 8)
    protected String telefonoMovil;
    @Column(name = "EMAIL", nullable = true, length = 50)
    protected String email;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", nullable = false)
    protected Usuario usuario ;



    public Pasajero() {
    }

    public Pasajero(Integer numeroViajero, String telefonoFijo, String telefonoMovil, String email, Usuario usuario) {
        this.numeroViajero = numeroViajero;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.email = email;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getNumeroViajero() {
        return numeroViajero;
    }

    public void setNumeroViajero(Integer numeroViajero) {
        this.numeroViajero = numeroViajero;
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
