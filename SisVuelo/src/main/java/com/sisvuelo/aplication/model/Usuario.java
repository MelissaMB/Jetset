package com.sisvuelo.aplication.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_usuario")
	private Integer id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_rol", nullable=false)
	private Rol rol;
	
	@Column (name="email", nullable = false, length = 150 )
	private String email;
	
	@Column (name="password", nullable = false, length = 8 )
	private String password;
	
    @Column(name = "fecha_creacion", updatable = false, nullable = true)
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	

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