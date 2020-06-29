package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Pasajero;
import com.sisvuelo.aplication.model.EstatusReserva;
import com.sisvuelo.aplication.model.Vuelo;
import com.sisvuelo.aplication.model.Clase;
import java.util.Date;


public class ReservaFilter {

private Integer id;
private Pasajero pasajero;
private EstatusReserva estatusReserva;
private Vuelo vuelo;
private Clase clase;
private Integer cantidad;
private Integer numeroEquipaje;
private Date fechaReserva;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public Pasajero getPasajero() {
  return this.pasajero;
}
public void setPasajero(Pasajero pasajero) {
  this.pasajero = pasajero;
}
public EstatusReserva getEstatusReserva() {
  return this.estatusReserva;
}
public void setEstatusReserva(EstatusReserva estatusReserva) {
  this.estatusReserva = estatusReserva;
}
public Vuelo getVuelo() {
  return this.vuelo;
}
public void setVuelo(Vuelo vuelo) {
  this.vuelo = vuelo;
}
public Clase getClase() {
  return this.clase;
}
public void setClase(Clase clase) {
  this.clase = clase;
}
public Integer getCantidad() {
  return this.cantidad;
}
public void setCantidad(Integer cantidad) {
  this.cantidad = cantidad;
}
public Integer getNumeroEquipaje() {
  return this.numeroEquipaje;
}
public void setNumeroEquipaje(Integer numeroEquipaje) {
  this.numeroEquipaje = numeroEquipaje;
}
public Date getFechaReserva() {
  return this.fechaReserva;
}
public void setFechaReserva(Date fechaReserva) {
  this.fechaReserva = fechaReserva;
}



}
