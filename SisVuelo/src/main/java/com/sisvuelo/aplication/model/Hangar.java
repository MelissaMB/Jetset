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
@Entity
@Table(name = "TB_HANGAR")
public class Hangar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_hangar")
	private Integer id;
	
	@Column(name = "codigo_hangar", nullable = false, length = 10)
	private String codigo;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ciudad", nullable = false)
	private Aeropuerto aeropuerto;
	
	@Column(name = "estado_hangar", nullable = false)
	private boolean estado;
	
	@Column(name = "capacidad", nullable = false)
	private Integer capacidad;

	public Hangar(Integer id, String codigo, Aeropuerto aeropuerto, boolean estado, Integer capacidad) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.aeropuerto = aeropuerto;
		this.estado = estado;
		this.capacidad = capacidad;
	}

	public Hangar() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	

}
