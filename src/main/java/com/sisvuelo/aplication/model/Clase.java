package com.sisvuelo.aplication.model;

//import java.sql.Date;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_Clase")
public class Clase {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_Clase")
	private Integer id;
	
	@Column(name = "nombre_Clase", nullable = false, length = 50)
	private String nombreClase;

	@Column(name = "estado_Clase", nullable = true)
	private boolean estado;

	


	public Clase() {
		super();
	}

	public Clase(Integer id, String nombreClase, boolean estado) {
		super();
		this.id = id;
		this.nombreClase = nombreClase;
		this.estado = estado;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}