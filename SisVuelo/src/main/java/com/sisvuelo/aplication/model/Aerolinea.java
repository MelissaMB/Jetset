package com.sisvuelo.aplication.model;

import java.sql.Date;

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
@Table(name = "TB_AEROLINEA")
public class Aerolinea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_aerolinea")
	private Integer id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_pais", nullable=false)
	private Pais pais;
	
	@Column(name = "codigo_aerolinea", nullable = false, length = 10)
	private String codigo;
	
	@Column(name = "nombre_corto", nullable = true, length = 50)
	private String nombreCorto;
	
	@Column(name = "nombre_largo", nullable = true, length = 250)
	private String nombreLargo;
	
	@Column(name = "representante", nullable = true, length = 250)
	private String representante;
	
	@Column(name = "email", nullable = true, length = 50)
	private String email;
	
	@Column(name = "fecha_fundacion", updatable = true, nullable = true)
	private Date fechaFundacion;
	
	@Column(name = "estado_aerolinea", updatable = true, nullable = true)
	private boolean estado;

	public Aerolinea() {
		super();
	}

	public Aerolinea(Integer id, Pais pais, String codigo, String nombreCorto, String nombreLargo, String representante,
			String email, Date fechaFundacion, boolean estado) {
		super();
		this.id = id;
		this.pais = pais;
		this.codigo = codigo;
		this.nombreCorto = nombreCorto;
		this.nombreLargo = nombreLargo;
		this.representante = representante;
		this.email = email;
		this.fechaFundacion = fechaFundacion;
		this.estado = estado;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(Date fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
    

}
