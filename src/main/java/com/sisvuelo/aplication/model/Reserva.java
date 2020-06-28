package com.sisvuelo.aplication.model;

//import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
import java.util.Date;
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
	@JoinColumn(name="id_pasajero", nullable=false)
	private Pasajero pasajero;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_estatus_reserva", nullable=false)
	private EstatusReserva estatusReserva;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_vuelo", nullable=false)
	private Vuelo vuelo;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="id_Precio", nullable=false)
	private Precio precio;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;
	@Column(name = "numero_equipaje", nullable = false)
	private Integer numeroEquipaje;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_reserva", updatable = true, nullable = true)
	private Date fechaReserva;



	public Reserva() {
		super();
	}

	public Reserva(Integer id, Pasajero pasajero, EstatusReserva estatusReserva, Vuelo vuelo, Precio precio, Integer cantidad, Integer numeroEquipaje, Date fechaReserva) {
		this.id = id;
		this.pasajero = pasajero;
		this.estatusReserva = estatusReserva;
		this.vuelo = vuelo;
		this.precio = precio;
		this.cantidad = cantidad;
		this.numeroEquipaje = numeroEquipaje;
		this.fechaReserva = fechaReserva;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Integer getNumeroEquipaje() {
		return numeroEquipaje;
	}

	public void setNumeroEquipaje(Integer numeroEquipaje) {
		this.numeroEquipaje = numeroEquipaje;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
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
