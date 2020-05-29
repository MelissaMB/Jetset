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
@Table(name = "TB_Estado_Vuelo")
public class EstadoVuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_estado_vuelo")
	private Integer id;
	
	@Column(name = "Estado_Vuelo", nullable = false, length = 50)
	private String estado_Vuelo;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_vuelo", nullable = false)
	private Vuelo vuelo;

	public EstadoVuelo() {
		super();
	}

	public EstadoVuelo(Integer id, String estado_Vuelo, Vuelo vuelo) {
		super();
		this.id = id;
		this.estado_Vuelo = estado_Vuelo;
		this.vuelo = vuelo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEstado_Vuelo() {
		return estado_Vuelo;
	}

	public void setEstado_Vuelo(String estado_Vuelo) {
		this.estado_Vuelo = estado_Vuelo;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

}
