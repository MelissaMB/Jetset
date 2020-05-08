package com.sisvuelo.aplication.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avion {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator ="native")
	private Integer id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="IdModelo", nullable=false)
	private Modelo modelo;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="IdAerolinea", nullable=false)
	private Aerolinea aerolinea;
	
	@Column (name="NombreAvion", nullable = false, length = 50 )
	private String nombre;
	
	@Column (name="AnioFrabricacion", nullable = true)
	private Integer anioFabricacion;
	
	@Column (name="EstadoAvion", nullable = true  )
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
