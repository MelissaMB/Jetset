package com.sisvuelo.aplication.model;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Table(name = "TB_GENERO")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_GENERO")
    private Integer id;

    @Column(name = "NOMBRE_GENERO")
    private String nombre;

    public Genero() {
    }

    public Genero(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
