package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Aeropuerto;


public class HangarFilter {

private Integer id;
private String codigo;
private Aeropuerto aeropuerto;
private boolean estado;
private Integer capacidad;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public String getCodigo() {
  return this.codigo;
}
public void setCodigo(String codigo) {
  this.codigo = codigo;
}
public Aeropuerto getAeropuerto() {
  return this.aeropuerto;
}
public void setAeropuerto(Aeropuerto aeropuerto) {
  this.aeropuerto = aeropuerto;
}
public boolean isEstado() {
  return this.estado;
}
public void setEstado(boolean estado) {
  this.estado = estado;
}
public Integer getCapacidad() {
  return this.capacidad;
}
public void setCapacidad(Integer capacidad) {
  this.capacidad = capacidad;
}



}
