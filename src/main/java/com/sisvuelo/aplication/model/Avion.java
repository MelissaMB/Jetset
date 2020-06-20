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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_AVION")
public class Avion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private Integer id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_modelo", nullable = false)
	private Modelo modelo;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_aerolinea", nullable = false)
	private Aerolinea aerolinea;

	@Column(name = "nombre_avion", nullable = false, length = 50)
	private String nombre;

	@Column(name = "anio_fabricacion", updatable = true, nullable = true)
	private Integer anioFabricacion;

	@Column(name = "estado_avion", nullable = true)
	private boolean estado;

	public Avion() {
		super();
	}

	public Avion(Integer id, Modelo modelo, Aerolinea aerolinea, String nombre, Integer anioFabricacion,
			boolean estado) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.aerolinea = aerolinea;
		this.nombre = nombre;
		this.anioFabricacion = anioFabricacion;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Avion{" +
				"id=" + id +
				", modelo=" + modelo +
				", aerolinea=" + aerolinea +
				", nombre='" + nombre + '\'' +
				", anioFabricacion=" + anioFabricacion +
				", estado=" + estado +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
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
