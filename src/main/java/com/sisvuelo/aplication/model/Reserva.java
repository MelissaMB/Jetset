package com.sisvuelo.aplication.model;

//import java.sql.Date;

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
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_Reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_reserva")
	private Integer id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_estatus_reserva", nullable=false)
	private EstatusReserva estatusReserva;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_vuelo", nullable=false)
	private Vuelo vuelo;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_Precio", nullable=false)
	private Precio precio;



	public Reserva() {
		super();
	}

	public Reserva(Integer id, Usuario usuario, EstatusReserva estatusReserva, Vuelo vuelo, Precio precio) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.estatusReserva = estatusReserva;
		this.vuelo = vuelo;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public EstatusReserva getEstatusReserva() {
		return estatusReserva;
	}

	public void setEstatusReserva(EstatusReserva estatusReserva) {
		this.estatusReserva = estatusReserva;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

}
