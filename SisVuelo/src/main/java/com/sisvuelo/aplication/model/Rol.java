package com.sisvuelo.aplication.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ROL")
public class Rol implements Serializable {
	
	private static final long serialVersionUID = 3118632738004642420L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator ="native")
	private Integer id;
	
	@Column(name="NombreRol")
	private String nombre;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	public Rol() {
		super();
	}

	public Rol(Integer id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
