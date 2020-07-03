package com.sisvuelo.aplication.filter;

import java.sql.Timestamp;

public class View_itinerarioFilter {

    private Long ident;
    private String aerolinea;
    private Integer idVuelo;
    private String codigo;
    private String origen;
    private String destino;
    private Timestamp horaAterrizaje;
    private Timestamp horaReal;
    private String estadoVuelo;
	public Long getIdent() {
		return ident;
	}
	public void setIdent(Long ident) {
		this.ident = ident;
	}
	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	public Integer getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(Integer idVuelo) {
		this.idVuelo = idVuelo;
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
	public Timestamp getHoraAterrizaje() {
		return horaAterrizaje;
	}
	public void setHoraAterrizaje(Timestamp horaAterrizaje) {
		this.horaAterrizaje = horaAterrizaje;
	}
	public Timestamp getHoraReal() {
		return horaReal;
	}
	public void setHoraReal(Timestamp horaReal) {
		this.horaReal = horaReal;
	}
	public String getEstadoVuelo() {
		return estadoVuelo;
	}
	public void setEstadoVuelo(String estadoVuelo) {
		this.estadoVuelo = estadoVuelo;
	}

    
}