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
@Table(name = "TB_CIUDAD")
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name = "id_ciudad")
	private Integer id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pais", nullable = false)
	private Pais pais;

	@Column(name = "nombre_ciudad", nullable = false, length = 50)
	private String nombre;

	public Ciudad(Integer id, Pais pais, String nombre) {
		super();
		this.id = id;
		this.pais = pais;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ciudad{" +
				"id=" + id +
				", pais=" + pais +
				", nombre='" + nombre + '\'' +
				'}';
	}

	public Ciudad() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
