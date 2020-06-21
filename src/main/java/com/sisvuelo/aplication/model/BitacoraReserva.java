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
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Entity
@Table(name = "TB_BitacoraReserva")
public class BitacoraReserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@Column(name = "id_Bitacora_Reserva")
	private Integer id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_reserva", nullable = false)
	private Reserva reserva;
	
	@Column(name="id_B_usuario", nullable=true)
	private Integer usuario;
	
	@Column(name="id_B_estatus_reserva", nullable=true)
	private Integer estatusReserva;
	
	@Column(name="id_B_vuelo", nullable=true)
	private Integer vuelo;
	
	@Column(name="id_B_Precio", nullable=true)
	private Integer precio;

    @Column(name = "fecha_Bitacora", updatable = true, nullable = true)
 //   @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

	public BitacoraReserva() {
		super();
	}

	public BitacoraReserva(Integer id, Reserva reserva, Integer usuario, Integer estatusReserva,
			Integer vuelo, Integer precio, Date fecha) {
		super();
		this.id = id;
		this.reserva = reserva;
		this.usuario = usuario;
		this.estatusReserva = estatusReserva;
		this.vuelo = vuelo;
		this.precio = precio;
		this.fecha = fecha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Integer getUsuario() {
		return usuario;
	}
	

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getEstatusReserva() {
		return estatusReserva;
	}

	public void setEstatusReserva(Integer estatusReserva) {
		this.estatusReserva = estatusReserva;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
	
}