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
@Table(name = "TBL_AEROPUERTO")
public class Aeropuerto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "IdAeropuerto")
	private Integer id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "IdCiudad", nullable = false)
	private Ciudad ciudad;
	
	@Column(name = "CodigoAeropuerto", nullable = false, length = 10)
	private String codigo;
	
	@Column(name = "NombreAeropuerto", nullable = false, length = 250)
	private String nombre;

	@Column(name = "Telefono", nullable = true, length = 10)
	private String telefono;
	
	@Column(name = "NombreResponsable", nullable = true, length = 250)
	private String Responsable;
	
	@Column(name = "NumeroBahias", nullable = true)
	private Integer numeroBahias;
	
	@Column(name = "NumeroHangares", nullable = true)
	private Integer numeroHangares;
	
	@Column(name = "EstadoAeropuerto", nullable = true)
	private boolean estado;
	
	public Aeropuerto(Integer id, Ciudad ciudad, String codigo, String nombre, String telefono, String responsable,
			Integer numeroBahias, Integer numeroHangares, boolean estado) {
		super();
		this.id = id;
		this.ciudad = ciudad;
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.Responsable = responsable;
		this.numeroBahias = numeroBahias;
		this.numeroHangares = numeroHangares;
		this.estado=estado;
		
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Aeropuerto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getResponsable() {
		return Responsable;
	}

	public void setResponsable(String responsable) {
		Responsable = responsable;
	}

	public Integer getNumeroBahias() {
		return numeroBahias;
	}

	public void setNumeroBahias(Integer numeroBahias) {
		this.numeroBahias = numeroBahias;
	}

	public Integer getNumeroHangares() {
		return numeroHangares;
	}

	public void setNumeroHangares(Integer numeroHangares) {
		this.numeroHangares = numeroHangares;
	}
	
	
	
	
	
	
	
	
}
