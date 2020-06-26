package com.sisvuelo.aplication.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ROL")
public class Rol implements Serializable {
	
	private static final long serialVersionUID = 3118632738004642420L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator ="native")
	private Integer id;


	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public Rol() {

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

	@Override
	public String toString() {
		return "Rol{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", descripcion='" + descripcion + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Rol)) return false;
		Rol rol = (Rol) o;
		return id.equals(rol.id) &&
				nombre.equals(rol.nombre) &&
				descripcion.equals(rol.descripcion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre, descripcion);
	}
}
