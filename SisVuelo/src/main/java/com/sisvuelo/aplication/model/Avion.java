package com.sisvuelo.aplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avion {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator ="native")
	private Integer id;
	
	@Column
	private String nombre;
	
	@Column
	private Integer anioFabricacion;
	
	@Column
	private boolean estado;

	public Avion() {
		super();
	}

	public Avion(Integer id, String nombre, Integer anioFabricacion, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.anioFabricacion = anioFabricacion;
		this.estado = estado;
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

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(Integer anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
	
}
