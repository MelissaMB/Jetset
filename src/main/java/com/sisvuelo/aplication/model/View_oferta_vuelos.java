package com.sisvuelo.aplication.model;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Id;

public class View_oferta_vuelos {

	@Id
	@Column(name = "vuelo")
	private Integer id;
	
	@Column(name="Aerolinea", nullable = false, length = 250)
	private String aerolinea;
	
	@Column(name="escalas", nullable=true)
	private boolean escala;
	
	@Column(name="origen", nullable=true, length = 250)
	private String origen;
	
	@Column(name="destino", nullable=true, length = 250)
	private String destino;
		
	@Column(name="id_vuelo", nullable=false)
	private Integer vuelo;
	
	@Column(name="id_aerolinea", nullable=false)
	private Integer id_aerolinea;
	
	@Column(name = "hora_aterrizaje", nullable = true)
	private Time hora_aterrizaje;
	
	@Column(name = "duracion", nullable = true)
	private Time duracion;
	
	@Column(name = "hora_despegue", nullable = true)
	private Time hora_despegue;
	
	@Column(name="id_clase", nullable=false)
	private Integer id_clase;
	
	@Column(name = "clase", nullable = false, length = 250)
	private String clase;
	
	@Column(name = "precio", nullable = true)
	private float precio;
	
	@Column(name = "disponibles", nullable = true)
	private boolean disponible;
	

	public View_oferta_vuelos(Integer id, String aerolinea, boolean escala, String origen, String destino, Integer vuelo,
			Integer id_aerolinea, Time hora_aterrizaje, Time duracion, Time hora_despegue, Integer id_clase,
			String clase, float precio, boolean disponible) {
		super();
		this.id = id;
		this.aerolinea = aerolinea;
		this.escala = escala;
		this.origen = origen;
		this.destino = destino;
		this.vuelo = vuelo;
		this.id_aerolinea = id_aerolinea;
		this.hora_aterrizaje = hora_aterrizaje;
		this.duracion = duracion;
		this.hora_despegue = hora_despegue;
		this.id_clase = id_clase;
		this.clase = clase;
		this.precio = precio;
		this.disponible = disponible;
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


	public boolean isEscala() {
		return escala;
	}


	public void setEscala(boolean escala) {
		this.escala = escala;
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


	public Integer getVuelo() {
		return vuelo;
	}


	public void setVuelo(Integer vuelo) {
		this.vuelo = vuelo;
	}


	public Integer getId_aerolinea() {
		return id_aerolinea;
	}


	public void setId_aerolinea(Integer id_aerolinea) {
		this.id_aerolinea = id_aerolinea;
	}


	public Time getHora_aterrizaje() {
		return hora_aterrizaje;
	}


	public void setHora_aterrizaje(Time hora_aterrizaje) {
		this.hora_aterrizaje = hora_aterrizaje;
	}


	public Time getDuracion() {
		return duracion;
	}


	public void setDuracion(Time duracion) {
		this.duracion = duracion;
	}


	public Time getHora_despliegue() {
		return hora_despegue;
	}


	public void setHora_despliegue(Time hora_despliegue) {
		this.hora_despegue = hora_despliegue;
	}


	public Integer getId_clase() {
		return id_clase;
	}


	public void setId_clase(Integer id_clase) {
		this.id_clase = id_clase;
	}


	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public boolean isDisponible() {
		return disponible;
	}


	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	
}
