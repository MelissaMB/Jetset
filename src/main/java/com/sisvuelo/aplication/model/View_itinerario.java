package com.sisvuelo.aplication.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ITINERARIO")
public class View_itinerario {

    @Id
    @Column(name = "vuelo")
    private Integer id;

	@Column(name="Aerolinea", nullable = false, length = 250)
	private String aerolinea;
    
	@Column(name="codigo", nullable=false)
	private String codigo;
    
	@Column(name="origen", nullable=true, length = 250)
	private String origen;
	
	@Column(name="destino", nullable=true, length = 250)
	private String destino;
    
	@Column(name = "hora_aterrizaje", nullable = true)
	private Time hora_aterrizaje;
 
	@Column(name = "hora_real", nullable = true)
	private Time hora_real;

    @Column(name = "estado_vuelo", nullable = false, length = 50)
	private String estado_vuelo;

    public View_itinerario() {
    }

    public View_itinerario(Integer id, String aerolinea, String codigo, String origen, String destino, Time hora_aterrizaje, Time hora_real, String estado_vuelo) {
		super();
		this.id = id;
		this.aerolinea = aerolinea;
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.hora_aterrizaje = hora_aterrizaje;
		this.hora_real = hora_real;
		this.estado_vuelo = estado_vuelo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Time getHora_aterrizaje() {
		return hora_aterrizaje;
	}

	public void setHora_aterrizaje(Time hora_aterrizaje) {
		this.hora_aterrizaje = hora_aterrizaje;
	}

	public Time getHora_real() {
		return hora_real;
	}

	public void setHora_real(Time hora_real) {
		this.hora_real = hora_real;
	}

	public String getEstado_vuelo() {
		return estado_vuelo;
	}

	public void setEstado_vuelo(String estado_vuelo) {
		this.estado_vuelo = estado_vuelo;
	}

    
}