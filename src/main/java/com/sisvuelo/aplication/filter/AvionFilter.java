package com.sisvuelo.aplication.filter;

import com.sisvuelo.aplication.model.Modelo;
import com.sisvuelo.aplication.model.Aerolinea;


public class AvionFilter {

private Integer id;
private Modelo modelo;
private Aerolinea aerolinea;
private String nombre;
private Integer anioFabricacion;
private boolean estado;


public Integer getId() {
  return this.id;
}
public void setId(Integer id) {
  this.id = id;
}
public Modelo getModelo() {
  return this.modelo;
}
public void setModelo(Modelo modelo) {
  this.modelo = modelo;
}
public Aerolinea getAerolinea() {
  return this.aerolinea;
}
public void setAerolinea(Aerolinea aerolinea) {
  this.aerolinea = aerolinea;
}
public String getNombre() {
  return this.nombre;
}
public void setNombre(String nombre) {
  this.nombre = nombre;
}
public Integer getAnioFabricacion() {
  return this.anioFabricacion;
}
public void setAnioFabricacion(Integer anioFabricacion) {
  this.anioFabricacion = anioFabricacion;
}
public boolean isEstado() {
  return this.estado;
}
public void setEstado(boolean estado) {
  this.estado = estado;
}



}
