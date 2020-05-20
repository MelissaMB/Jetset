package com.sisvuelo.aplication.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_DESTINO")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "id_destino")
    private Integer id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aeropuerto", nullable = false)
    private Aerolinea aerolinea;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aerolinea", nullable = false)
    private Aeropuerto aeropuerto;

    public Destino() {
    }

    public Destino(Integer id, Aerolinea aerolinea, Aeropuerto aeropuerto) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.aeropuerto = aeropuerto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }
}
