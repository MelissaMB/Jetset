package com.sisvuelo.aplication.model;

import javax.persistence.*;

@Entity
@Table(name = "TB_ESTADO_CIVIL")
public class EstadoCivil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_ESTADO_CIVIL")
    private Integer id;

    @Column(name = "nombre_estado", nullable = false, length = 50)
    private String nombre;

    public EstadoCivil(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public EstadoCivil() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
