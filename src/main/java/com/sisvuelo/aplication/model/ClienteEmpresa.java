package com.sisvuelo.aplication.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value ="empresa" )
public class ClienteEmpresa extends Pasajero{



    @Column(name = "NOMBRE_EMPRESA", length = 250, nullable = true)
    private String nombreEmpresa;

    @Column(name = "NIC_EMPRESA", length = 10, nullable = true)
    private Integer nic;

    @Column(name = "NOMBRE_CONTACTO", length = 250, nullable = true)
    private String nombreContacto;


    public ClienteEmpresa() {
    }

    public ClienteEmpresa(Integer numeroViajero, String telefonoFijo, String telefonoMovil, String email, Usuario usuario, String nombreEmpresa, Integer nic, String nombreContacto) {
        super(numeroViajero, telefonoFijo, telefonoMovil, email, usuario);
        this.nombreEmpresa = nombreEmpresa;
        this.nic = nic;
        this.nombreContacto = nombreContacto;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Integer getNic() {
        return nic;
    }

    public void setNic(Integer nic) {
        this.nic = nic;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
}
