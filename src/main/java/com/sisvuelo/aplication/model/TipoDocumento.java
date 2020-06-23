package com.sisvuelo.aplication.model;

import javax.persistence.*;


@Entity
@Table(name = "TB_TIPO_DOCUMENTO")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_TIPO_DOCUMENTO")
    private Integer id;

    @Column(name = "NOMBRE_TIPO_DOCUMENTO", nullable = false, length = 250)
    private String nombre;

    public TipoDocumento() {
    }

    public TipoDocumento(Integer id, String nombre) {
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
