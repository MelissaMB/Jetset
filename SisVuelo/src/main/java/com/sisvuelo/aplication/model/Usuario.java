package com.sisvuelo.aplication.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Usuario {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private Integer id;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
    @JsonFormat(pattern="dd/mm/aaaa")
	@Column
	private Date fechaCreacion;
	
	@ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
	private Rol rol;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String email, String password, Date fechaCreacion, Rol rol) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fechaCreacion = fechaCreacion;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	
	
}