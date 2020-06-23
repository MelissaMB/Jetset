package com.sisvuelo.aplication.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTE_EMPRESA")
public class ClienteEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name ="NIT" )
    private Integer nit;

    @Column(name = "NOMBRE_EMPRESA", length = 250, nullable = false)
    private String nombreEmpresa;

    @Column(name = "NIC_EMPRESA", length = 10, nullable = false)
    private Integer nic;

    @Column(name = "NOMBRE_CONTACTP", length = 250, nullable = false)
    private String nombreContacto;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PASAJERO", nullable = false)
    private Pasajero pasajero;

    public ClienteEmpresa() {
    }

    public ClienteEmpresa(Integer nit, String nombreEmpresa, Integer nic, String nombreContacto) {
        this.nit = nit;
        this.nombreEmpresa = nombreEmpresa;
        this.nic = nic;
        this.nombreContacto = nombreContacto;
    }

    public Integer getNit() {
        return nit;
    }

    public void setNit(Integer nit) {
        this.nit = nit;
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
